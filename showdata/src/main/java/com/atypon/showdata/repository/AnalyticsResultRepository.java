package com.atypon.showdata.repository;

import com.atypon.showdata.model.AnalyticsResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsResultRepository extends MongoRepository<AnalyticsResult, String> {
    // Additional methods if needed
}