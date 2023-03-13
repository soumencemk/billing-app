package com.soumen.simplebilling.model;

import lombok.Builder;

import java.util.Date;
@Builder
public record BillModel(
        Date billDate,
        Date startDate,
        Date endDate,
        Long startUnit,
        Long endUnit,
        Double amount
) {
}
