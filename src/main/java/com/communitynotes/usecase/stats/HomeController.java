package com.communitynotes.usecase.stats;

import com.communitynotes.Statistics;
import com.communitynotes.infra.job.StatisticsScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/scrapper/rooms/")
public class HomeController {

    @Autowired
    StatisticsScheduler statisticsScheduler;

    @Autowired
    Statistics apartmentStatistics;

    @GetMapping("mark")
    public void tirggerStatisticsForMarks() throws IOException {
        statisticsScheduler.runStatisticsFor1RoomApartments();
    }

}
