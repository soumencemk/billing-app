package com.soumen.simplebilling.model;

import lombok.Builder;

@Builder
public record ApiResponse(String code, String status,String message) {
}
