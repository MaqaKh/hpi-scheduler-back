package com.communitynotes.usecase.stats;

import java.time.LocalDateTime;

public record StatisticsResponse(int id,
                                 int highest,
                                 int lowest,
                                 int average,
                                 LocalDateTime createdDate,
                                 int childDistrictId,
                                 int roomNum,
                                 boolean hasRepair,
                                 boolean hasBillOfSale) {
}
