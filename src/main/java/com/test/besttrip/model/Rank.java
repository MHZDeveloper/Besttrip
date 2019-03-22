package com.test.besttrip.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity(name = "RANKS")
@Table(name = "RANKS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rankId")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RANK_ID")
    private int rankId;

    @ManyToOne
    @JoinColumn(name ="EXPERIENCE")
    private Experience experience;

    @Column(name = "RANK_NUMBER")
    private RankNumber rankNumber;

    @Column(name = "LOGIN")
    private String login;


    public Rank(int rankNumber) {
        this.rankNumber = RankNumber.getFromValue(rankNumber);
    }

    public RankNumber getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(RankNumber rankNumber) {
        this.rankNumber = rankNumber;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
