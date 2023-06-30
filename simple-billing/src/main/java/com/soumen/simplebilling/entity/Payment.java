package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Payment {
    @Id
    private String id;
    private Date paymentDate;
    private Double amount;
    private MeterType meterType;

    public Payment(){}

    public Payment(Date date, Double amount, MeterType meterType) {
        this.paymentDate = date;
        this.amount = amount;
        this.meterType = meterType;
    }
}
