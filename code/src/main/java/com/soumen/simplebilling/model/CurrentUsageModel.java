package com.soumen.simplebilling.model;

import lombok.Builder;

import java.util.Date;

@Builder
public record CurrentUsageModel(
        Date startDate,
        Date endDate,
        Double amount,
        Long startUnit,
        Long endUnit,
        Integer unitConsumed,
        Double totalStandingCharges
) {
}
