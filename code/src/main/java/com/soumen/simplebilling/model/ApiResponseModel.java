package com.soumen.simplebilling.model;

import lombok.Builder;

@Builder
public record ApiResponseModel(ApiStatus apiStatus,String message) {
}
