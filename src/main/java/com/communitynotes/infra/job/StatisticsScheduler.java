package com.communitynotes.infra.job;

import com.communitynotes.domain.childdisctrict.ChildDistrictRepository;
import com.communitynotes.domain.childdisctrict.ChildDistrict;
import com.communitynotes.domain.childdisctrict.DistrictInfo;
import com.communitynotes.domain.statistics.Statistics;
import com.communitynotes.domain.statistics.StatisticsRepository;
import com.communitynotes.infra.scrapper.Scrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class StatisticsScheduler {
    private ChildDistrictRepository childDistrictRepository;
    private StatisticsRepository statisticsRepository;
    private Scrapper scrapper;

    public StatisticsScheduler(ChildDistrictRepository childDistrictRepository, StatisticsRepository statisticsRepository, Scrapper scrapper) {
        this.childDistrictRepository = childDistrictRepository;
        this.statisticsRepository = statisticsRepository;
        this.scrapper = scrapper;
    }

    //    @Scheduled(cron = "0 0 23 * * ?")
    @Scheduled(cron = "0 */2 * ? * *")
    public void runStatisticsFor1RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data to database");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            log.info("Running the scrapper for district {}", district);
            var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "1", "true", "true");

            double highest = 0;
            double lowest = 0;
            double average = 0;
            if (result.size() > 0) {
                highest = result.get(result.size() - 1);
                lowest = result.get(0);
                average = result.stream().mapToDouble(x -> x).average().orElse(0);
            }

//            var childDistrict = childDistrictRepository.findById(district.id()).get();
            var statistics = new Statistics(highest, lowest, average, 1, true, true, district.id());
            stats.add(statistics);
        }
        statisticsRepository.saveAll(stats);
    }
}
