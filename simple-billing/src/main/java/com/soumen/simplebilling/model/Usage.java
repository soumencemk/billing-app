package com.soumen.simplebilling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Usage {
    private MeterType meterType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date usageStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date usageEndDate;
    private Integer usageStartUnit;
    private Integer usageEndUnit;
    private Double unitsUsed;
    private Integer noOfDays;
    private Bill bill;

}