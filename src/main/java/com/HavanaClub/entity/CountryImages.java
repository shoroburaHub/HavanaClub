package com.HavanaClub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by admin on 6/17/2017.
 */
@Entity
public class CountryImages {

    @Id
    @GeneratedValue
    private int id;

    private String pathImage;

    @ManyToOne
    private Country country;

    public CountryImages(String pathImage) {
        this.pathImage = pathImage;
    }

    public CountryImages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
