package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading,Long> {

    List<MeterReading> findByMeterTypeAndStartingReading(MeterType meterType,Boolean startingReading);
}
