package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private Date paymentDate;
    private Double amount;
    private MeterType meterType;
}
