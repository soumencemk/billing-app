package com.soumen.simplebilling.api.svc;

import com.soumen.simplebilling.db.entity.Bill;
import com.soumen.simplebilling.db.entity.MeterReading;
import com.soumen.simplebilling.db.entity.UnitRate;
import com.soumen.simplebilling.db.repository.BillRepository;
import com.soumen.simplebilling.db.repository.MeterReadingRepository;
import com.soumen.simplebilling.db.repository.UnitRateRepository;
import com.soumen.simplebilling.model.BillModel;
import com.soumen.simplebilling.model.CurrentUsageModel;
import com.soumen.simplebilling.model.MeterType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingSvc {
    private final BillRepository billRepository;
    private final MeterReadingRepository meterReadingRepository;
    private final UnitRateRepository unitRateRepository;

    public CurrentUsageModel getCurrentUsage(MeterType meterType) {
        List<MeterReading> unBilledReadings = meterReadingRepository.findByMeterTypeAndIsBilled(meterType, false);
        MeterReading endMeterReading = unBilledReadings
                .stream()
                .max(Comparator.comparing(MeterReading::getSubmitDate))
                .orElse(null);
        MeterReading startMeterReading = unBilledReadings
                .stream()
                .min(Comparator.comparing(MeterReading::getSubmitDate))
                .orElse(null);
        BillModel billModel = BillModel.builder()
                .endUnit(endMeterReading.getMeterReading())
                .startUnit(startMeterReading.getMeterReading())
                .startDate(startMeterReading.getSubmitDate())
                .endDate(endMeterReading.getSubmitDate())
                .build();
        return calculateBill(meterType, billModel);
    }

    public void submitBill(MeterType meterType, BillModel billModel) {
        Bill bill = new Bill();
        bill.setBillDate(billModel.billDate());
        bill.setUsageStartDate(billModel.startDate());
        bill.setUsageEndDate(billModel.endDate());
        bill.setStartUnit(billModel.startUnit());
        bill.setEndUnit(billModel.endUnit());
        bill.setConsumedUnit(billModel.endUnit().intValue() - billModel.startUnit().intValue());
        bill.setType(meterType);
        bill.setActualAmount(billModel.amount());
        bill.setCalculatedAmount(calculateBill(meterType, billModel).amount());
        billRepository.save(bill);
    }

    public CurrentUsageModel calculateBill(MeterType meterType, BillModel billModel) {
        UnitRate unitRate = unitRateRepository.findByType(meterType);
        int consumedUnit = billModel.endUnit().intValue() - billModel.startUnit().intValue();
        long noOfDays = Math.abs(billModel.endDate().getTime() - billModel.startDate().getTime());
        double totalStandingCharges = noOfDays * unitRate.getStandingCharges();
        double billAmount = (consumedUnit * unitRate.getRate()) + totalStandingCharges;
        return CurrentUsageModel
                .builder()
                .startDate(billModel.startDate())
                .endDate(billModel.endDate())
                .endUnit(billModel.endUnit())
                .startUnit(billModel.startUnit())
                .amount(billAmount)
                .unitConsumed(consumedUnit)
                .totalStandingCharges(totalStandingCharges)
                .build();
    }
}
