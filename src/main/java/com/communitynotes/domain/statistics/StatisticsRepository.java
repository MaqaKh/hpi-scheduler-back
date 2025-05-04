package com.communitynotes.domain.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, String> {
    void removeAllByAverageAndHighestAndLowest(double average, double highest, double lowest);

    // Get latest 100 statistics
    List<Statistics> findTop100ByOrderByCreatedDateDesc();

    // By regionId
    List<Statistics> findByRegionId(Integer regionId);
    List<Statistics> findByRegionIdIsNull();

    // By markId
    List<Statistics> findByMarkId(Integer markId);
    List<Statistics> findByMarkIdIsNull();

    // By childDistrictId
    List<Statistics> findByChildDistrictId(Integer childDistrictId);
    List<Statistics> findByChildDistrictIdIsNull();

    // For date/average grouping, use @Query
    @Query("SELECT DATE(s.createdDate) as date, ROUND(AVG(s.average), 0) as average FROM Statistics s WHERE (:regionId IS NULL AND s.regionId IS NULL OR s.regionId = :regionId) GROUP BY DATE(s.createdDate) HAVING ROUND(AVG(s.average), 0) >= 2000 ORDER BY date ASC")
    List<Object[]> groupByDateAndAverageByRegion(@Param("regionId") Integer regionId);

    @Query("SELECT DATE(s.createdDate) as date, ROUND(AVG(s.average), 0) as average FROM Statistics s WHERE (:markId IS NULL AND s.markId IS NULL OR s.markId = :markId) GROUP BY DATE(s.createdDate) HAVING ROUND(AVG(s.average), 0) >= 2000 ORDER BY date ASC")
    List<Object[]> groupByDateAndAverageByMark(@Param("markId") Integer markId);

    @Query("SELECT DATE(s.createdDate) as date, ROUND(AVG(s.average), 0) as average FROM Statistics s WHERE (:childDistrictId IS NULL AND s.childDistrictId IS NULL OR s.childDistrictId = :childDistrictId) GROUP BY DATE(s.createdDate) HAVING ROUND(AVG(s.average), 0) >= 2000 ORDER BY date ASC")
    List<Object[]> groupByDateAndAverageByChildDistrict(@Param("childDistrictId") Integer childDistrictId);
}