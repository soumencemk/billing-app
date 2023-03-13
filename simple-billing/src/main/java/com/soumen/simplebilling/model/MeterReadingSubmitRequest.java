package com.soumen.simplebilling.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record MeterReadingSubmitRequest(
        MeterType meterType,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date readingDate,
        Integer readingValue,
        Boolean isStartingReading
) {
}
