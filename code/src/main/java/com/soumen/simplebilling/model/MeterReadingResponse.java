package com.soumen.simplebilling.model;


import lombok.Builder;

@Builder
public record MeterReadingResponse(ApiStatus status, MeterReadingModel meterReading) {
}

