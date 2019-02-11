package com.test.besttrip.model;

import java.util.List;

public class Experience {

    private int id;

    private List<String> activites;

    private List<String> photos;

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
}
