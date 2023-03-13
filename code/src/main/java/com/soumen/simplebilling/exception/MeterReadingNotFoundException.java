package com.soumen.simplebilling.exception;

public class MeterReadingNotFoundException extends RuntimeException {

    private static final String DEFAULT_MSG = "NO METER READING FOUND";

    public MeterReadingNotFoundException() {
        super(DEFAULT_MSG);
    }

}
