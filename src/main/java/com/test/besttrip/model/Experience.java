package com.test.besttrip.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity(name = "EXPERIENCE")
@Table(name = "EXPERIENCE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "expId")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EXP_ID")
    private int expId;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Account account;

    @Column(name = "VILLE_NAME")
    private String villeName;

    @Column(name = "COUNTRY")
    private String country;


    @Column(name = "DESCRIPTION")
    private String description;

    @ElementCollection
    @CollectionTable(name = "PHOTOS")
    private List<String> photos;

    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rank> ranks;

    public Experience() {
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVilleName() {
        return villeName;
    }

    public void setVilleName(String villeName) {
        this.villeName = villeName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int getMeanRank() {
        if (ranks.size() > 0) {
            int sum = 0;
            for (Rank rank : ranks) {
                sum += rank.getRankNumber().getValue();
            }
            return sum / ranks.size();
        }
        else {
            return 3;
        }
    }
}
