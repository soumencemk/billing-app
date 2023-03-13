package com.soumen.simplebilling.exceptions;

public class NoMeterReadingPresentException extends RuntimeException{

    private static final String DEFAULT_MSG = "No Meter reading present at the moment";

    public NoMeterReadingPresentException(){
        super(DEFAULT_MSG);
    }
    public NoMeterReadingPresentException(String message){
        super(message);
    }
}
