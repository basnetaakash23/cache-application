package com.hibernate.cache.controller;

import com.hibernate.cache.stats.HibernatePackageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private final HibernatePackageHelper statsHelper;

    public StatsController(HibernatePackageHelper statsHelper) {
        this.statsHelper = statsHelper;
    }

    @GetMapping("/stats")
    public void showHibernateStats() {
        statsHelper.printStats(); // Triggers log output
    }
}
