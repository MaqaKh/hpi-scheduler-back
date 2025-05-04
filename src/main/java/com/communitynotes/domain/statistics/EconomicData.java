package com.communitynotes.domain.statistics;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "economic_data")
public class EconomicData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "infoType")
    private String infoType;

    @Column(name = "value")
    private Double value;

    @Column(name = "date")
    private LocalDate date;
} 