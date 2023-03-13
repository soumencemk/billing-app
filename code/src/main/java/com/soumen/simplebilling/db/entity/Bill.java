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
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private Date billDate;
    private Date usageStartDate;
    private Date usageEndDate;
    private Long startUnit;
    private Long endUnit;
    private Integer consumedUnit;
    private MeterType type;
    private Double calculatedAmount;
    private Double actualAmount;
}
