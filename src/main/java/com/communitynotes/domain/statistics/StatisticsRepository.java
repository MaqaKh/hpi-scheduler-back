package com.communitynotes.domain.statistics;

import com.communitynotes.domain.childdisctrict.ChildDistrict;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;


public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {}