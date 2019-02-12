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
    private int id;

    @ManyToOne
    @JoinColumn(name ="VILLE_ID")
    @JsonBackReference
    private Ville ville;

    @ElementCollection //collection
    @CollectionTable(name = "ACTIVITIES")
    private List<String> activites;

    @ElementCollection
    @CollectionTable(name = "PHOTOS")
    private List<String> photos;

    @Column(name = "RECOMMANDATION")
    @ElementCollection
    private List<Integer> recommandation;

    public Experience(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getActivites() {
        return activites;
    }

    public void setActivites(List<String> activites) {
        this.activites = activites;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Integer> getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(List<Integer> recommandation) {
        this.recommandation = recommandation;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
