package com.communitynotes.domain.agent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "agent")
public class Agent {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "num_of_ads")
    private int numOfAds;

    @Column(name = "rating")
    private int rating;

}
