package com.soumen.simplebilling.restcontroller;

import com.soumen.simplebilling.entity.MeterReading;
import com.soumen.simplebilling.entity.MeterReadingHistory;
import com.soumen.simplebilling.exceptions.NoMeterReadingPresentException;
import com.soumen.simplebilling.model.ApiResponse;
import com.soumen.simplebilling.model.MeterReadingSubmitRequest;
import com.soumen.simplebilling.model.MonthlyUsagePredictionModel;
import com.soumen.simplebilling.model.Usage;
import com.soumen.simplebilling.service.MeterReadingService;
import com.soumen.simplebilling.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simple-billing")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MeterReadingRestController extends BaseRestController {

    private final MeterReadingService meterReadingService;
    private final RatingService ratingService;

    @PostMapping("/reading/submit")
    public ApiResponse submitStartingReading(@RequestBody MeterReadingSubmitRequest meterReadingRequest) {
        log.info("Submit Meter Reading : {}", meterReadingRequest);
        meterReadingService.saveOrReplaceMeterReading(meterReadingRequest);
        return successApiResponse();
    }

    @GetMapping("/reading/starting")
    public List<MeterReading> getStartingMeterReading() {
        log.info("Starting meter reading API");
        return meterReadingService.fetchStartingMeterReadings();
    }

    @GetMapping("/bill/current")
    public List<Usage> getCurrentUsage() {
        log.info("Current-usage API");
        List<Usage> usageList = meterReadingService.findUsages();
        if (usageList.isEmpty()) {
            throw new NoMeterReadingPresentException();
        }
        ratingService.calculateBills(usageList);
        return usageList;
    }

    @GetMapping("/reading/all")
    public List<MeterReading> getAllMeterReadings() {
        return meterReadingService.getAllMeterReadings();
    }
    @GetMapping("/reading/historical")
    public List<MeterReadingHistory> getHistoricalMeterReadings() {
        return meterReadingService.getHistoricalMeterReadings();
    }

    @GetMapping("/bill/monthPredict")
    public List<MonthlyUsagePredictionModel> getMonthlyUsagePredictions(){
        return getCurrentUsage()
                .stream()
                .map(usage -> new MonthlyUsagePredictionModel(usage.getMeterType(),
                        ratingService.calculateMonthly(usage)))
                .collect(Collectors.toList());

    }
}
