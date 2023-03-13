package com.soumen.simplebilling.api.controller;

import com.soumen.simplebilling.model.ApiResponseModel;
import com.soumen.simplebilling.model.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    //todo : Add specific handlers

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception e) {
        log.error("Exception : {}", e.getCause());
        ApiResponseModel apiResponseModel = ApiResponseModel.builder()
                .apiStatus(ApiStatus.FAILURE)
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(apiResponseModel, HttpStatus.I_AM_A_TEAPOT);

    }

}
