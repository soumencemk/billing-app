package com.soumen.simplebilling.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record PaymentRequest(@JsonFormat(pattern = "yyyy-MM-dd") Date paymentDate, Double amount, MeterType meterType) {
}
