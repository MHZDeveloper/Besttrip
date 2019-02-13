package com.test.besttrip.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EXPERIENCE")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EXP_ID")
    private int expId;

    @Column(name = "VILLE_NAME")
    private String villeName;

    @Column(name = "COUNTRY")
    private String country;

    @ManyToOne
    @JoinColumn(name ="LOGIN")
    @JsonBackReference
    private Account account;

    @CollectionTable(name = "DESCRIPTION")
    private String description;

    @ElementCollection
    @CollectionTable(name = "PHOTOS")
    private List<String> photos;

    @JoinColumn(name = "RECOMMANDATION_MEAN")
    private double moyenneRecommandation;

    @JoinColumn(name = "RECOMMANDATION_NUMBER")
    private int recommandationNumber;



    public Experience(int expId) {
        this.expId = expId;
    }

    public Experience (){}

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

    public double getMoyenneRecommandation() {
        return moyenneRecommandation;
    }

    public void setMoyenneRecommandation(double moyenneRecommandation) {
        this.moyenneRecommandation = moyenneRecommandation;
    }

    public int getRecommandationNumber() {
        return recommandationNumber;
    }

    public void setRecommandationNumber(int recommandationNumber) {
        this.recommandationNumber = recommandationNumber;
    }
}
