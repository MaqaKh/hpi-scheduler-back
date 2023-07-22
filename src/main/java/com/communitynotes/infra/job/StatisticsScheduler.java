package com.communitynotes.infra.job;

import com.communitynotes.domain.childdisctrict.ChildDistrictRepository;
import com.communitynotes.domain.childdisctrict.DistrictInfo;
import com.communitynotes.domain.mark.Mark;
import com.communitynotes.domain.mark.MarkRepository;
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
public class StatisticsScheduler {
    private final ChildDistrictRepository childDistrictRepository;
    private final MarkRepository markRepository;
    private final StatisticsRepository statisticsRepository;
    private final Scrapper scrapper;




    // apartments by district with repair
    @Scheduled(cron = "0 0 9 * * *")
    public void runStatisticsFor1RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 1 room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "1", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics =  Statistics.ofChildDistrict(highest, lowest, average, 1, true, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 10 9 * * *")
    public void runStatisticsFor2RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 2 room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "2", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 2, true, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 20 9 * * *")
    public void runStatisticsFor3RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 3 room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "3", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 3, true, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 30 9 * * *")
    public void runStatisticsFor4RoomApartments() throws IOException {
        log.info("About to run the scheduler to insert data for 4 room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "4", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 4, true, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 40 9 * * *")
    public void runStatisticsFor5RoomApartments() {
        log.info("About to run the scheduler to insert data for 45 and more  room apartments");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "5", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 5, true, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }



    // apartments by district without repair
    @Scheduled(cron = "0 50 9 * * *")
    public void runStatisticsFor1RoomApartmentsWithoutRepair() throws IOException {
        log.info("About to run the scheduler to insert data for 1 room apartments without repair");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "1", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 1, false, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void runStatisticsFor2RoomApartmentsWithoutRepair() throws IOException {
        log.info("About to run the scheduler to insert data for 2 room apartments without repair");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "2", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 2, false, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 10 10 * * *")
    public void runStatisticsFor3RoomApartmentsWithoutRepair() {
        log.info("About to run the scheduler to insert data for 3 room apartments without repair");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "3", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 3, false, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 20 10 * * *")
    public void runStatisticsFor4RoomApartmentsWithoutRepair() {
        log.info("About to run the scheduler to insert data for 4 room apartments without repair");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "3", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 4, false, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }
    @Scheduled(cron = "0 30 10 * * *")
    public void runStatisticsFor5RoomApartmentsWithoutRepair() {
        log.info("About to run the scheduler to insert data for 5 room apartments without repair");

        List<Statistics> stats = new ArrayList<>();
        var districts = childDistrictRepository.findAllDistrictsWithParentName();
        for (DistrictInfo district : districts) {
            try {
                var result = scrapper.findPrices(district.mainDistrict(), district.childDistrict(), "3", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofChildDistrict(highest, lowest, average, 5, false, true, district.id());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }





 // by mark
 @Scheduled(cron = "0 40 10 * * *")
 public void runStatisticsFor1RoomApartmentsByMark() {
     log.info("About to run the scheduler to insert data for 1 room apartments by mark");

     List<Statistics> stats = new ArrayList<>();
     var marks = markRepository.findAll();
     for (Mark mark : marks) {
         try {
             var result = scrapper.findPrices( mark.getName(),null, "1", "true", "true");

             double highest = 0;
             double lowest = 0;
             double average = 0;
             if (result.size() > 0) {
                 highest = result.get(result.size() - 1);
                 lowest = result.get(0);
                 average = result.stream().mapToDouble(x -> x).average().orElse(0);
             }

             var statistics = Statistics.ofMark(highest, lowest, average, 1, true, true, mark.getId());
             stats.add(statistics);
         } catch (Exception e) {
             log.error("Exception occurred during the parsing", e);
         }

     }
     statisticsRepository.saveAll(stats);
 }

    @Scheduled(cron = "0 50 10 * * *")
    public void runStatisticsFor2RoomApartmentsByMark() {
        log.info("About to run the scheduler to insert data for 2 room apartmentsby mark");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices(mark.getName(), null, "2", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 2, true, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 0 11 * * *")
    public void runStatisticsFor3RoomApartmentsByMark(){
        log.info("About to run the scheduler to insert data for 3 room apartments by mark");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "3", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 3, true, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 10 11 * * *")
    public void runStatisticsFor4RoomApartmentsByMark(){
        log.info("About to run the scheduler to insert data for 4 room apartments by mark");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "4", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 2, true, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 20 11 * * *")
    public void runStatisticsFor5RoomApartmentsByMark(){
        log.info("About to run the scheduler to insert data for 5 room apartments by mark");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "5", "true", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 5, true, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }






    // by mark without repair
    @Scheduled(cron = "0 30 11 * * *")
    public void runStatisticsFor1RoomApartmentsByMarkWithoutRepair() throws IOException {
        log.info("About to run the scheduler to insert data for 1 room apartments by mark without repair");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "1", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 1, false, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 40 11 * * *")
    public void runStatisticsFor2RoomApartmentsByMarkWithoutRepair() {
        log.info("About to run the scheduler to insert data for 2 room apartments by mark without repair");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices(mark.getName(), null, "2", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 2, false, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 50 11 * * *")
    public void runStatisticsFor3RoomApartmentsByMarkWithoutRepair(){
        log.info("About to run the scheduler to insert data for 3 room apartments by mark without repair");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "3", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 3, false, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void runStatisticsFor4RoomApartmentsByMarkWithoutRepair(){
        log.info("About to run the scheduler to insert data for 4 room apartments by mark without repair");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "4", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 4, false, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }

    @Scheduled(cron = "0 10 12 * * *")
    public void runStatisticsFor5RoomApartmentsByMarkWithoutRepair(){
        log.info("About to run the scheduler to insert data for 5 room apartments by mark without repair");

        List<Statistics> stats = new ArrayList<>();
        var marks = markRepository.findAll();
        for (Mark mark : marks) {
            try {
                var result = scrapper.findPrices( mark.getName(),null, "5", "false", "true");

                double highest = 0;
                double lowest = 0;
                double average = 0;
                if (result.size() > 0) {
                    highest = result.get(result.size() - 1);
                    lowest = result.get(0);
                    average = result.stream().mapToDouble(x -> x).average().orElse(0);
                }

                var statistics = Statistics.ofMark(highest, lowest, average, 5, false, true, mark.getId());
                stats.add(statistics);
            } catch (Exception e) {
                log.error("Exception occurred during the parsing", e);
            }

        }
        statisticsRepository.saveAll(stats);
    }
}
