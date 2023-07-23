package com.communitynotes.domain.statistics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    void removeAllByAverageAndHighestAndLowest(double average, double highest, double lowest);
}