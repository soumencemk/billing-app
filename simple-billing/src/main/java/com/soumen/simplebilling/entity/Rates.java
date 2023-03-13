package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rates {
    @Id
    @GeneratedValue
    private Long id;
    private MeterType meterType;
    private Double rate;
    private Double standingCharge;

}
