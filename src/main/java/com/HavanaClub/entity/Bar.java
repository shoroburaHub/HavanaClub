package com.HavanaClub.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/22/2017.
 */
@Entity
public class Bar {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "drink_ingredient",
            joinColumns = @JoinColumn(name = "id_bar"),
            inverseJoinColumns = @JoinColumn(name = "id_city"))
    private List<City> cities = new ArrayList<>();

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}

