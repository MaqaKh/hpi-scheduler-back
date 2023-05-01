package com.communitynotes.infra.job;

import com.communitynotes.domain.childdisctrict.ChildDistrictRepository;
import com.communitynotes.domain.childdisctrict.ChildDistricts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class StatisticsScheduler {
    private ChildDistrictRepository childDistrictRepository;

    public StatisticsScheduler(ChildDistrictRepository childDistrictRepository) {
        this.childDistrictRepository = childDistrictRepository;
    }

    @Scheduled(cron = "0 0 23 * * ?")
    public void runStatistics() {
        log.info("About to run the scheduler to insert data to database");

        var districts = childDistrictRepository.findAll();
        for (ChildDistricts district: districts){

        }
        System.out.println("Running scheduled task at 11 pm every day");
    }
}
