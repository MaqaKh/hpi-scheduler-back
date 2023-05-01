package com.communitynotes.domain.statistics;

import com.communitynotes.Statistics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApartmentStatistics implements Statistics {
    @Override
    public double averagePricePerSquareOf1room() throws IOException {
//        return findPrices("yasamal", "yeni-yasamal", "1", "true").stream().mapToDouble(x -> x)
//                .average().orElse(0);
        return findPrices("yasamal", "yasamal-qesebesi", "1", "true", "true").stream().mapToDouble(x -> x)
                .average().orElse(0);
    }

    @Override
    public Double highestPricePerSquareOf1room() throws IOException {
        List<Double> doubles = findPrices("yasamal", "yeni-yasamal", "1", "true", "true");
        return doubles.get(doubles.size() - 1);
    }

    @Override
    public Double lowestPricePerSquareOf1room() throws IOException {
        return findPrices("yasamal", "yeni-yasamal", "1", "true", "true").get(0);
    }


    private List<Double> findPrices(String districtMain, String district, String room, String hasRepair, String hasBillOfSale) throws IOException {
        String url =
                String.format("https://bina.az/baki/%s/%s/alqi-satqi/menziller/%s-otaqli?floor_first=false&floor_last=false&has_bill_of_sale=%s&has_repair=%s",
                districtMain, district, room, hasRepair, hasBillOfSale);


        Document doc = Jsoup.connect(url).get();

        Elements cardParams = doc.select("div.items-i");
        List<Double> prices = new ArrayList<>();
        for (Element cardParam : cardParams) {
            String id = cardParam.attr("data-item-id");

            Element priceVal = cardParam.selectFirst("span.price-val");
            String priceText = priceVal.text().replaceAll("\\s+", "");

            Element areaLi = cardParam.select("ul.name li:nth-child(2)").first();
            String areaText = areaLi.text().replaceAll("\\s+", "");

            double price = Double.parseDouble(priceText);
            double area = Double.parseDouble(areaText.substring(0, areaText.length() - 2));

            double pricePerSqM = price / area;

            prices.add(pricePerSqM);
            System.out.println(" Price per sqm: " + pricePerSqM + " " + id);
            System.out.println("-------------------------");
        }
        Collections.sort(prices);
        return prices;
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
