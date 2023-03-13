package com.soumen.simplebilling.restcontroller;

import com.soumen.simplebilling.model.ApiResponse;
import com.soumen.simplebilling.util.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception e) {
        log.error("Exception : {}", e.getCause(),e);
        ApiResponse response = ApiResponse
                .builder()
                .code(AppConstants.FAIL_DEFAULT_RESPONSE_CODE)
                .status(AppConstants.FAIL_RESPONSE_VAL)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }
}
