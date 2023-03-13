package com.soumen.simplebilling.model;

import lombok.Builder;

@Builder
public record Bill(Double actualAmount, Double paidAmount, Double balance, String message) {
}
