package com.soumen.simplebilling.db.entity;

import com.soumen.simplebilling.model.MeterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MeterReading {
    @Id
    @GeneratedValue
    private Long id;
    private Date submitDate;
    private MeterType meterType;
    private Long meterReading;
    private Boolean isBilled;
}
