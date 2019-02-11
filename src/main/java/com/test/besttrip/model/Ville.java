package com.test.besttrip.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="VILLE")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VILLE_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PAYS")
    private String pays;

    @OneToMany(mappedBy = "ville", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Experience> experiences;

    public Ville(){}

    public Ville(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}