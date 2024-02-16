package com.atypon.analysis.service;

import com.atypon.analysis.model.AnalyticsResult;
import com.atypon.analysis.model.Grade;
import com.atypon.analysis.repository.AnalyticsResultRepository;
import com.atypon.analysis.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final GradeRepository gradeRepository;
    private final AnalyticsResultRepository analyticsResultRepository;

    @Autowired
    public AnalyticsService(GradeRepository gradeRepository, AnalyticsResultRepository analyticsResultRepository) {
        this.gradeRepository = gradeRepository;
        this.analyticsResultRepository = analyticsResultRepository;
    }

    public void performAnalyticsAndSave() {
        // Perform analytics
        int maxGrade = gradeRepository.findAll().stream().map(Grade::getGrade).max(Integer::compareTo).get();
        int minGrade = gradeRepository.findAll().stream().map(Grade::getGrade).min(Integer::compareTo).get();
        List<Grade> grades = gradeRepository.findAll();
        int sum = 0;
        for (Grade grade: grades) {
            sum += grade.getGrade();
        }

        // Save results to MongoDB
        AnalyticsResult analyticsResult = new AnalyticsResult(maxGrade, minGrade, sum/(grades.size() * 1.0));
        System.out.println("analyticsResult: " + analyticsResult);
        analyticsResultRepository.save(analyticsResult);
    }
}