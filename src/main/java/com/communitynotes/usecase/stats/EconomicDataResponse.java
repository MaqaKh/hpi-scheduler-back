package com.communitynotes.usecase.stats;

import java.time.LocalDate;

public record EconomicDataResponse(LocalDate date, Double value) {} 