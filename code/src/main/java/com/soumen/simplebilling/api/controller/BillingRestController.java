package com.soumen.simplebilling.api.controller;

import com.soumen.simplebilling.api.svc.BillingSvc;
import com.soumen.simplebilling.api.svc.MeterSvc;
import com.soumen.simplebilling.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/billing/")
@Slf4j
@RequiredArgsConstructor
public class BillingRestController {

    private final BillingSvc billingSvc;
    private final MeterSvc meterSvc;

    @GetMapping("/{meterType}/currentUsage")
    public CurrentUsageModel getCurrentUsage(@PathVariable MeterType meterType) {
        return billingSvc.getCurrentUsage(meterType);
    }

    @PostMapping("/{meterType}/bill")
    public ApiResponseModel submitBill(@PathVariable MeterType meterType,
                                       @RequestBody BillModel bill) {

        billingSvc.submitBill(meterType, bill);
        meterSvc.markBilledReadings(meterType, bill.startDate(), bill.endDate());
        return ApiResponseModel
                .builder()
                .apiStatus(ApiStatus.SUCCESS)
                .message("")
                .build();
    }

}
