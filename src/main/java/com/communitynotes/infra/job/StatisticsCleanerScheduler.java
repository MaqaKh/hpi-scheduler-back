package com.communitynotes.infra.job;

import com.communitynotes.domain.statistics.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class StatisticsCleanerScheduler {
    private final StatisticsRepository statisticsRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void cleanUp(){
        statisticsRepository.removeAllByAverageAndHighestAndLowest(0,0,0);
    }
}
