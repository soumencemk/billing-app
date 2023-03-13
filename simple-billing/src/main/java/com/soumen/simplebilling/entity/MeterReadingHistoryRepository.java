package com.soumen.simplebilling.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReadingHistoryRepository extends JpaRepository<MeterReadingHistory,Long> {
}
