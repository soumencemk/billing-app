package com.soumen.simplebilling.model;

import lombok.Getter;

@Getter
public enum MeterType {
    GAS("GAS"), ELECTRIC("ELECTRIC");
    private final String type;

    MeterType(String type) {
        this.type = type;
    }
}
