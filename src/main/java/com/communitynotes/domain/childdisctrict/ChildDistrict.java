package com.communitynotes.domain.childdisctrict;

import com.communitynotes.domain.MainDistrict;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "childdistricts")
public class ChildDistrict {
    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MainDistrict mainDistrict;

}

