package com.atypon.analysis.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
public class AnalyticsResult {
    @MongoId
    private String id;
    private Integer maxGrade;
    private Integer minGrade;
    private Double avgGrade;


    public AnalyticsResult(Integer maxGrade, Integer minGrade, Double avgGrade) {
        this.maxGrade = maxGrade;
        this.minGrade = minGrade;
        this.avgGrade = avgGrade;
    }
}
