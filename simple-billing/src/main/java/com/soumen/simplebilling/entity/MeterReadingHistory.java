package com.soumen.simplebilling.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soumen.simplebilling.model.MeterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class MeterReadingHistory {
    @Id
    @GeneratedValue
    private Long id;
    private MeterType meterType;
    private Integer meterReadingValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitDate;
    private Boolean startingReading;

}
