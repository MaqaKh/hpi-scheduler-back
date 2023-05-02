package com.communitynotes.infra.scrapper;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class Scrapper {

    public List<Double> findPrices(String districtMain, String district, String room, String hasRepair, String hasBillOfSale) throws IOException {
        String url;
        if(districtMain.length()<1){
            url =
                    String.format("https://bina.az/baki/%s/alqi-satqi/menziller/%s-otaqli?floor_first=false&floor_last=false&has_bill_of_sale=%s&has_repair=%s",
                            districtMain, room, hasRepair, hasBillOfSale);
        }else{
            url =
                    String.format("https://bina.az/baki/%s/%s/alqi-satqi/menziller/%s-otaqli?floor_first=false&floor_last=false&has_bill_of_sale=%s&has_repair=%s",
                            districtMain, district, room, hasRepair, hasBillOfSale);
        }


        log.info("About to scrap url {}", url);

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

}
