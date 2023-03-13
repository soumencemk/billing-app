package com.soumen.simplebilling.api.controller;

import com.soumen.simplebilling.api.svc.MeterSvc;
import com.soumen.simplebilling.db.entity.MeterReading;
import com.soumen.simplebilling.model.MeterReadingModel;
import com.soumen.simplebilling.model.MeterReadingResponse;
import com.soumen.simplebilling.model.MeterType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meter/")
@Slf4j
@RequiredArgsConstructor
public class MeterRestController {

    private final MeterSvc meterSvc;

    @GetMapping("/reading/{meterType}")
    public List<MeterReading> getMeterReading(@PathVariable MeterType meterType) {
        return meterSvc.getAllMeterReadingsNotBilled(meterType);
    }

    @PostMapping("/reading/{meterType}")
    public MeterReadingResponse submitMeterReading(@RequestBody MeterReadingModel meterReadingModel,
                                                   @PathVariable MeterType meterType) {
        return meterSvc.submitMeterReading(meterType, meterReadingModel);

    }
}
