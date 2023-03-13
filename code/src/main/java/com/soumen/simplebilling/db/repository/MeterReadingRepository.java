package com.soumen.simplebilling.db.repository;

import com.soumen.simplebilling.db.entity.MeterReading;
import com.soumen.simplebilling.model.MeterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading,Long> {

    List<MeterReading> findByMeterTypeAndIsBilled(MeterType meterType, boolean b);
}
