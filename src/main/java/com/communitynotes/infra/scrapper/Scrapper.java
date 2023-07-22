package com.communitynotes.infra.scrapper;

import com.communitynotes.usecase.ad.AdResponse;
import com.communitynotes.usecase.ad.ProductPrices;
import com.communitynotes.usecase.ad.ProductProperties;
import com.communitynotes.usecase.ad.ProductStatistics;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@Slf4j
public class Scrapper {

    public List<Double> findPrices(String districtMain, String district, String room, String hasRepair, String hasBillOfSale) throws IOException {
        String url;
        if (district == null) {
            url =
                    String.format("https://bina.az/baki/%s/alqi-satqi/menziller/%s-otaqli?floor_first=false&floor_last=false&has_bill_of_sale=%s&has_repair=%s",
                            districtMain, room, hasRepair, hasBillOfSale);
        } else {
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
            log.info(" Price per sqm: " + pricePerSqM + " " + id);
        }
        Collections.sort(prices);
        return prices;
    }

    public static List<ProductProperties> extractLabelValuePairs(Document doc) {

        List<ProductProperties> productProperties = new ArrayList<>();
        Elements propertyElements = doc.select("div.product-properties__i");

        for (Element element : propertyElements) {
            String label = element.select("label.product-properties__i-name").text();
            String value = element.select("span.product-properties__i-value").text();
            productProperties.add(new ProductProperties(label, value));
        }

        return productProperties;
    }

    public AdResponse findSingleApartment(String number) throws IOException {
        log.info("About to scrap ad with number {}", number);

        var url = String.format("https://bina.az/items/%s", number);
        var doc = Jsoup.connect(url).get();


        var productProperties = extractLabelValuePairs(doc);
        System.out.println(productProperties);

        var imgs = extractImageSrcByClassName(doc);
        System.out.println(imgs);

        var subImgs= extractSubImageSrcByClassName(url);
        System.out.println(subImgs);

        var description = extractDescription(doc);
        System.out.println(description);

        var stats = extractStats(doc);
        System.out.println(stats);

        var prices = extractPrice(doc);
        System.out.println(prices);

        var districts = extractListValues(doc);
        System.out.println(districts);

        return new AdResponse(productProperties, imgs, subImgs, description, stats, prices, districts);
    }

    private static List<String> extractListValues(Document doc) {
        List<String> values = new ArrayList<>();
        Elements liElements = doc.select("li.product-extras__i > a");

        for (Element liElement : liElements) {
            String value = liElement.text();
            values.add(value);
        }

        return values;
    }

    private static List<ProductPrices> extractPrice(Document doc) {
        List<ProductPrices> productPrices = new ArrayList<>();

        Elements priceElements = doc.select("div.product-price__i");

        if (priceElements.size() >= 2) {
            Element totalElement = priceElements.get(0);
            Element sqElement = priceElements.get(1);

            String total = totalElement.selectFirst("span.price-val").text().replaceAll("\\s+", "");
            String sq = sqElement.text().split("\\s+")[0];

            productPrices.add(new ProductPrices("Total", total));
            productPrices.add(new ProductPrices("Sq", sq));
        }

        return productPrices;
    }

    private static List<ProductStatistics>  extractStats(Document doc) {
        List<ProductStatistics> statistics = new ArrayList<>();
        Elements statElements = doc.select("div.product-statistics__i");

        for (Element element : statElements) {
            String text = element.selectFirst("span.product-statistics__i-text").text();
            String[] parts = text.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                statistics.add(new ProductStatistics(key, value));
            }
        }

        return statistics;
    }

    private static String extractDescription(Document doc) {
        Element descriptionElement = doc.selectFirst("div.product-description__content > p");
        return descriptionElement.text();
    }

    private static List<String> extractImageSrcByClassName(Document doc) {
        var className = "product-photos";
        Elements elements = doc.getElementsByClass(className);
        String[] srcList = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            Elements imgElements = element.select("img");
            if (imgElements.size() > 0) {
                Element imgElement = imgElements.first();
                String src = imgElement.attr("src");
                srcList[i] = src;
            }
        }

        return Arrays.asList(srcList);
    }

    private static List<String> extractSubImageSrcByClassName(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(".product-photos__slider-nav-i_picture");

            List<String> imageUrls = new ArrayList<>();

            for (Element element : elements) {
                String style = element.attr("style");
                String imageUrl = extractImageUrl(style);
                imageUrls.add(imageUrl);
            }

            return imageUrls;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String extractImageUrl(String style) {
        int startIndex = style.indexOf("url('") + 5;
        int endIndex = style.indexOf("')");
        return style.substring(startIndex, endIndex);
    }


}
