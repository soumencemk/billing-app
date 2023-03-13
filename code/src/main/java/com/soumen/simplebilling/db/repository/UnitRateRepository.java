package com.soumen.simplebilling.db.repository;

import com.soumen.simplebilling.db.entity.UnitRate;
import com.soumen.simplebilling.model.MeterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRateRepository extends JpaRepository<UnitRate, Long> {
    UnitRate findByType(MeterType meterType);
}
