package com.hibernate.cache.stats;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

@Component
public class HibernatePackageHelper {

    private final Statistics statistics;

    public HibernatePackageHelper(EntityManagerFactory emf) {
        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true); // Enable stats
        this.statistics = sessionFactory.getStatistics();
    }

    public void printStats() {
        System.out.println("Fetch Count (Entity DB Hits): " + statistics.getEntityFetchCount());
        System.out.println("Load Count (includes 1st level): " + statistics.getEntityLoadCount());
        System.out.println("Second-level Cache Hits: " + statistics.getSecondLevelCacheHitCount());
        System.out.println("Second-level Cache Misses: " + statistics.getSecondLevelCacheMissCount());
        System.out.println("Query Execution Count: " + statistics.getQueryExecutionCount());
    }

    public void resetStats() {
        statistics.clear();
    }
}
