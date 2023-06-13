package com.soumen.simplebilling.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends MongoRepository<Rates, String> {
}
