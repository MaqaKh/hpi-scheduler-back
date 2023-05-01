package com.communitynotes.usecase.stats;

import com.communitynotes.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/scrapper/rooms/")
public class HomeController {

    @Autowired
    Statistics apartmentStatistics;

    @GetMapping("high")
    public Double high() throws IOException {
       return apartmentStatistics.highestPricePerSquareOf1room();
    }
    @GetMapping("low")
    public Double low() throws IOException {
        return apartmentStatistics.lowestPricePerSquareOf1room();
    }
    @GetMapping("average")
    public double average() throws IOException {
        return apartmentStatistics.averagePricePerSquareOf1room();
    }


}
