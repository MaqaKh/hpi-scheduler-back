package com.communitynotes.usecase.stats;

import com.communitynotes.domain.statistics.EconomicData;
import com.communitynotes.domain.statistics.EconomicDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stats/economic-data")
@RequiredArgsConstructor
public class EconomicDataController {
    private final EconomicDataRepository economicDataRepository;

    @GetMapping("")
    public ResponseEntity<EconomicDataListResponse> fetchEconomicData(@RequestParam(name = "name", defaultValue = "Inflation") String name) {
        List<EconomicData> statistics = economicDataRepository.findByInfoTypeOrderByDateAsc(name);
        List<EconomicDataResponse> responseList = statistics.stream()
                .map(e -> new EconomicDataResponse(e.getDate(), e.getValue()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new EconomicDataListResponse(name, responseList));
    }
} 