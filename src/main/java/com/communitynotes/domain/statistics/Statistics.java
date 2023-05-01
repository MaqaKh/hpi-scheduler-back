package com.communitynotes.domain.statistics;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    private int id;

    @Column(name = "highest")
    private int highest;

    @Column(name = "lowest")
    private int lowest;

    @Column(name = "average")
    private int average;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "childdisttrictid")
    private int childDistrictId;

    @Column(name = "room_num")
    private int roomNum;

    @Column(name = "hasRepair")
    private boolean hasRepair;

    @Column(name = "hasBillOfSale")
    private boolean hasBillOfSale;

}
