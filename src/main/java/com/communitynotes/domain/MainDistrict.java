package com.communitynotes.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "maindistricts")
public class MainDistrict {
    @Id
    private int id;

    private String name;

}
