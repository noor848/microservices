package com.atypon.analysis.scheduler;

import com.atypon.analysis.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsScheduler {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsScheduler(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @Scheduled(fixedRate = 10000) // Run every minute 60000
    public void performAnalyticsTask() {
        analyticsService.performAnalyticsAndSave();
    }
}