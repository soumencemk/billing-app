package com.soumen.simplebilling.restcontroller;

import com.soumen.simplebilling.model.ApiResponse;

import static com.soumen.simplebilling.util.AppConstants.SUCCESS_DEFAULT_RESPONSE_CODE;
import static com.soumen.simplebilling.util.AppConstants.SUCCESS_RESPONSE_VAL;

public class BaseRestController {
    protected ApiResponse successApiResponse() {
        return ApiResponse
                .builder()
                .code(SUCCESS_DEFAULT_RESPONSE_CODE)
                .status(SUCCESS_RESPONSE_VAL)
                .build();
    }
}
