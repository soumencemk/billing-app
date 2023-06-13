package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Rates {
    @Id
    private String id;
    private MeterType meterType;
    private Double rate;
    private Double standingCharge;

}
