package com.communitynotes.usecase.stats;

import java.util.List;

public record EconomicDataListResponse(String name, List<EconomicDataResponse> statistics) {} 