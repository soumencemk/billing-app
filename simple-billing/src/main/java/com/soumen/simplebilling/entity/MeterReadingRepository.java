package com.soumen.simplebilling.entity;

import com.soumen.simplebilling.model.MeterType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends MongoRepository<MeterReading, String> {

    List<MeterReading> findByMeterTypeAndStartingReading(MeterType meterType, Boolean startingReading);
}
