package com.soumen.simplebilling.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReadingHistoryRepository extends MongoRepository<MeterReadingHistory, String> {
}
