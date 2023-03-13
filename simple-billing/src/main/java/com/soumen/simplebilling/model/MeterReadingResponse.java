package com.soumen.simplebilling.model;

import com.soumen.simplebilling.entity.MeterReading;

import java.util.List;

public record MeterReadingResponse(List<MeterReading> meterReadings) {
}
