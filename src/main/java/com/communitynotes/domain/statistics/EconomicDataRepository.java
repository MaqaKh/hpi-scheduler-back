package com.communitynotes.domain.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EconomicDataRepository extends JpaRepository<EconomicData, Long> {
    List<EconomicData> findByInfoTypeOrderByDateAsc(String infoType);
} 