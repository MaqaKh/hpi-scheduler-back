package com.communitynotes.usecase.ad;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data

public class AdResponse {
    private List<ProductProperties> productProperties;
    private List<String> imgs;
    private List<String> subImgs;
    private String description;
    private List<ProductStatistics> stats;
    private List<ProductPrices> prices;
    private List<String> districts;

    public AdResponse(List<ProductProperties> productProperties, List<String> imgs, List<String> subImgs, String description, List<ProductStatistics> stats, List<ProductPrices> prices, List<String> districts) {
        this.productProperties = productProperties;
        this.imgs = imgs;
        this.subImgs = subImgs;
        this.description = description;
        this.stats = stats;
        this.prices = prices;
        this.districts = districts;
    }
}
