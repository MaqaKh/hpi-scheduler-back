package com.communitynotes.domain.statistics;

import com.communitynotes.domain.childdisctrict.ChildDistrict;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    String id;
    @Column(name = "highest")
    private double highest;
    @Column(name = "lowest")
    private double lowest;

    @Column(name = "average")
    private double average;


    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "room_num")
    private int roomNum;

    @Column(name = "has_repair")
    private boolean hasRepair;

    @Column(name = "has_bill_of_sale")
    private boolean hasBillOfSale;

    @Column(name = "childdistrictid")
    private Integer childDistrictId;

    @Column(name = "mark_id")
    private Integer markId;

    public Statistics(double highest, double lowest, double average, int roomNum, boolean hasRepair, boolean hasBillOfSale, Integer childDistrictId, Integer markId) {
        this.id = UUID.randomUUID().toString();
        this.highest = highest;
        this.lowest = lowest;
        this.average = average;
        this.createdDate = LocalDateTime.now(ZoneOffset.UTC);
        this.roomNum = roomNum;
        this.hasRepair = hasRepair;
        this.hasBillOfSale = hasBillOfSale;
        this.childDistrictId = childDistrictId;
        this.markId=markId;
    }

    public static Statistics ofChildDistrict(double highest, double lowest, double average, int roomNum, boolean hasRepair, boolean hasBillOfSale, int childDistrictId){
        return new Statistics(highest,lowest,average,roomNum,hasRepair,hasBillOfSale,childDistrictId,null);
    }

    public static Statistics ofMark(double highest, double lowest, double average, int roomNum, boolean hasRepair, boolean hasBillOfSale, int markId){
        return new Statistics(highest,lowest,average,roomNum,hasRepair,hasBillOfSale,null,markId);
    }
}
