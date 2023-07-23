package com.communitynotes.infra.job;

import com.communitynotes.domain.childdisctrict.DistrictInfo;
import com.communitynotes.domain.region.Region;
import com.communitynotes.domain.region.RegionRepository;
import com.communitynotes.domain.statistics.Statistics;
import com.communitynotes.domain.statistics.StatisticsRepository;
import com.communitynotes.infra.scrapper.Scrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class StatiscticsRegionScheduler {
    private final StatisticsRepository statisticsRepository;
    private final RegionRepository regionRepository;
    private final Scrapper scrapper;

    @Scheduled(cron = "0 30 12 * * *")
    public void runStatisticsFor1RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 1 room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "1", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 1, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 33 12 * * *")
    public void runStatisticsFor2RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 2 room apartments in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "2", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 2, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 36 12 * * *")
    public void runStatisticsFor3RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 3 room apartments in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "3", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 3, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 39 12 * * *")
    public void runStatisticsFor4RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 4 room apartments in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "4", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 4, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 42 12 * * *")
    public void runStatisticsFor5RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 5 room apartments in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "5", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 5, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    // not repaired
    @Scheduled(cron = "0 45 12 * * *")
    public void runStatisticsFor1RoomApartmentsNotRepaired() {
        log.info("About to run the scheduler to insert data for 1 room apartments not not repaired");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "1", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 1, false, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 48 12 * * *")
    public void runStatisticsFor2RoomApartmentsNotRepaired()  {
        log.info("About to run the scheduler to insert data for 2 room apartments not repaired in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "2", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 2, true, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 51 12 * * *")
    public void runStatisticsFor3RoomApartmentsNotRepaired() throws IOException {
        log.info("About to run the scheduler to insert data for 3 room apartments not repaired in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "3", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 3, false, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 54 12 * * *")
    public void runStatisticsFor4RoomApartmentsNotRepaired() throws IOException {
        log.info("About to run the scheduler to insert data for 4 room apartments not repaired in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "4", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 4, false, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 57 12 * * *")
    public void runStatisticsFor5RoomApartmentsNotRepaired() throws IOException {
        log.info("About to run the scheduler to insert data for 5 room apartments not repaired in regions");

        List<Statistics> stats = new ArrayList<>();
        var districts = regionRepository.findAll();
        for (Region district : districts) {
            if(district.getName().equalsIgnoreCase("baki")){
                continue;
            }
            try {
                var result = scrapper.findPricesForSuburbanAreas(district.getName(), "5", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofRegion(highest, lowest, average, 5, false, true, district.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

}
