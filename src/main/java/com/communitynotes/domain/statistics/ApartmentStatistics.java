package com.communitynotes.domain.statistics;

import com.communitynotes.Statistics;
import com.communitynotes.infra.scrapper.Scrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentStatistics implements Statistics {
    @Autowired
    Scrapper scrapper;

    @Override
    public double averagePricePerSquareOf1room() throws IOException {
//        return findPrices("yasamal", "yeni-yasamal", "1", "true").stream().mapToDouble(x -> x)
//                .average().orElse(0);
        return scrapper.findPrices("yasamal", "yasamal-qesebesi", "1", "true", "true").stream().mapToDouble(x -> x)
                .average().orElse(0);
    }

    @Override
    public Double highestPricePerSquareOf1room() throws IOException {
        List<Double> doubles = scrapper.findPrices("yasamal", "yeni-yasamal", "1", "true", "true");
        return doubles.get(doubles.size() - 1);
    }

    @Override
    public Double lowestPricePerSquareOf1room() throws IOException {
        return scrapper.findPrices("yasamal", "yeni-yasamal", "1", "true", "true").get(0);
    }


    private List<Double> detectAndRemoveAnomalies(List<Double> lst) {
        List<Double> anomalies = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            for (int j = i + 1; j < lst.size(); j++) {
                double diff = Math.abs(lst.get(i) - lst.get(j));
                if (diff > 300) {
                    anomalies.add(lst.get(i));
                    anomalies.add(lst.get(j));
                }
            }
        }
        lst.removeAll(anomalies);
        return anomalies;
    }
}
