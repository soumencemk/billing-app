package com.soumen.simplebilling.api.svc;

import com.soumen.simplebilling.db.entity.MeterReading;
import com.soumen.simplebilling.db.repository.MeterReadingRepository;
import com.soumen.simplebilling.model.ApiStatus;
import com.soumen.simplebilling.model.MeterReadingModel;
import com.soumen.simplebilling.model.MeterReadingResponse;
import com.soumen.simplebilling.model.MeterType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeterSvc {
    private final MeterReadingRepository meterReadingRepository;

    public List<MeterReading> getAllMeterReadingsNotBilled(MeterType meterType) {
        return meterReadingRepository.findByMeterTypeAndIsBilled(meterType,false);

    }

    public MeterReadingResponse submitMeterReading(MeterType meterType, MeterReadingModel meterReadingModel) {
        MeterReading meterReading = new MeterReading();
        meterReading.setMeterType(meterType);
        meterReading.setSubmitDate(meterReadingModel.date() != null ? meterReadingModel.date() : new Date());
        meterReading.setMeterReading(meterReadingModel.meterReading());
        meterReadingRepository.save(meterReading);
        return MeterReadingResponse
                .builder()
                .meterReading(meterReadingModel)
                .status(ApiStatus.SUCCESS)
                .build();
    }

    public void markBilledReadings(MeterType meterType, Date startDate, Date endDate) {
        //todo: Implement this later !
    }
}
