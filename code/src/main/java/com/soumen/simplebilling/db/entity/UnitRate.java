package com.soumen.simplebilling.db.entity;


import com.soumen.simplebilling.model.MeterType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitRate {
    @Id
    @GeneratedValue
    private Long id;
    private MeterType type;
    private Double rate;
    private Double standingCharges;
    private Boolean isActive;

}
