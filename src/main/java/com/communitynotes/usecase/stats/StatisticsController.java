package com.communitynotes.usecase.stats;

import com.communitynotes.domain.statistics.Statistics;
import com.communitynotes.domain.statistics.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsRepository statisticsRepository;

    @GetMapping("")
    public ResponseEntity<List<Statistics>> index() {
        List<Statistics> stats = statisticsRepository.findTop100ByOrderByCreatedDateDesc();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<DateAverageResponse>> fetchStatisticsByRegion(@PathVariable String region) {
        List<Object[]> results;
        if (region.equals("null")) {
            results = statisticsRepository.groupByDateAndAverageByRegion(null);
        } else {
            results = statisticsRepository.groupByDateAndAverageByRegion(Integer.valueOf(region));
        }
        List<DateAverageResponse> response = results.stream().map(obj ->
                new DateAverageResponse(obj[0] instanceof java.sql.Date ? ((java.sql.Date)obj[0]).toLocalDate() : LocalDate.parse(obj[0].toString()),
                        ((Number)obj[1]).intValue())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<List<DateAverageResponse>> fetchStatisticsByMark(@PathVariable String mark) {
        List<Object[]> results;
        if (mark.equals("null")) {
            results = statisticsRepository.groupByDateAndAverageByMark(null);
        } else {
            results = statisticsRepository.groupByDateAndAverageByMark(Integer.valueOf(mark));
        }
        List<DateAverageResponse> response = results.stream().map(obj ->
                new DateAverageResponse(obj[0] instanceof java.sql.Date ? ((java.sql.Date)obj[0]).toLocalDate() : LocalDate.parse(obj[0].toString()),
                        ((Number)obj[1]).intValue())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/child-district/{child}")
    public ResponseEntity<List<DateAverageResponse>> fetchStatisticsByChildDistrict(@PathVariable("child") String child) {
        List<Object[]> results;
        if (child.equals("null")) {
            results = statisticsRepository.groupByDateAndAverageByChildDistrict(null);
        } else {
            results = statisticsRepository.groupByDateAndAverageByChildDistrict(Integer.valueOf(child));
        }
        List<DateAverageResponse> response = results.stream().map(obj ->
                new DateAverageResponse(obj[0] instanceof java.sql.Date ? ((java.sql.Date)obj[0]).toLocalDate() : LocalDate.parse(obj[0].toString()),
                        ((Number)obj[1]).intValue())
        ).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

} 