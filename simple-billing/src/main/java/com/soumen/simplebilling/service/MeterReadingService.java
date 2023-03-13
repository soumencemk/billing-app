package com.soumen.simplebilling.service;

import com.soumen.simplebilling.entity.MeterReading;
import com.soumen.simplebilling.entity.MeterReadingHistory;
import com.soumen.simplebilling.entity.MeterReadingHistoryRepository;
import com.soumen.simplebilling.entity.MeterReadingRepository;
import com.soumen.simplebilling.model.MeterReadingSubmitRequest;
import com.soumen.simplebilling.model.MeterType;
import com.soumen.simplebilling.model.Usage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.soumen.simplebilling.model.MeterType.ELECTRIC;
import static com.soumen.simplebilling.model.MeterType.GAS;

@Service
@RequiredArgsConstructor
public class MeterReadingService {

    private final MeterReadingRepository meterReadingRepository;
    private final MeterReadingHistoryRepository mrhRepository;


    public Usage getUsage(List<MeterReading> startingMeterReadings, List<MeterReading> lastMeterReadings, MeterType meterType) {
        if (startingMeterReadings.isEmpty() || lastMeterReadings.isEmpty()) {
            return null;
        }
        Usage usage = new Usage();
        startingMeterReadings.stream().filter(m -> m.getMeterType().equals(meterType)).findFirst().map(meterReading -> {
            usage.setUsageStartUnit(meterReading.getMeterReadingValue());
            usage.setUsageStartDate(meterReading.getSubmitDate());
            usage.setMeterType(meterType);
            return null;
        }).isPresent();
        lastMeterReadings.stream().filter(m -> m.getMeterType().equals(meterType)).findFirst().map(meterReading -> {
            usage.setUsageEndUnit(meterReading.getMeterReadingValue());
            usage.setUsageEndDate(meterReading.getSubmitDate());
            return null;
        }).isPresent();
        return usage;
    }


    public List<MeterReading> fetchStartingMeterReadings() {
        return meterReadingRepository.findAll().stream().filter(MeterReading::getStartingReading).toList();
    }

    public List<MeterReading> fetchLastMeterReadings() {
        return meterReadingRepository.findAll().stream().filter(Predicate.not(MeterReading::getStartingReading)).toList();
    }

    public void saveOrReplaceMeterReading(MeterReadingSubmitRequest meterReadingRequest) {

        List<MeterReading> meterReadingsToBeDeleted = meterReadingRepository
                .findByMeterTypeAndStartingReading(meterReadingRequest.meterType(),
                        meterReadingRequest.isStartingReading());
        meterReadingsToBeDeleted
                .stream()
                .map(mr -> {
                            MeterReadingHistory mrh = new MeterReadingHistory();
                            mrh.setMeterType(mr.getMeterType());
                            mrh.setStartingReading(mr.getStartingReading());
                            mrh.setSubmitDate(mr.getSubmitDate());
                            mrh.setMeterReadingValue(mr.getMeterReadingValue());
                            return mrh;
                        })
                .forEach(mrhRepository::save);
        meterReadingsToBeDeleted.forEach(meterReading -> meterReadingRepository.deleteById(meterReading.getId()));
        MeterReading meterReading = new MeterReading();
        meterReading.setMeterType(meterReadingRequest.meterType());
        meterReading.setStartingReading(meterReadingRequest.isStartingReading());
        meterReading.setMeterReadingValue(meterReadingRequest.readingValue());
        meterReading.setSubmitDate(meterReadingRequest.readingDate());
        meterReadingRepository.save(meterReading);
    }

    public List<Usage> findUsages() {
        List<Usage> usageList = new ArrayList<>();
        List<MeterReading> startingMeterReadings = fetchStartingMeterReadings();
        List<MeterReading> lastMeterReadings = fetchLastMeterReadings();
        Usage electricUsage = getUsage(startingMeterReadings, lastMeterReadings, ELECTRIC);
        Usage gasUsage = getUsage(startingMeterReadings, lastMeterReadings, GAS);
        if (electricUsage != null)
            usageList.add(electricUsage);
        if (gasUsage != null)
            usageList.add(gasUsage);
        return usageList;
    }

    public List<MeterReading> getAllMeterReadings() {
        return meterReadingRepository.findAll();
    }

    public List<MeterReadingHistory> getHistoricalMeterReadings() {
        return mrhRepository.findAll();
    }
}
