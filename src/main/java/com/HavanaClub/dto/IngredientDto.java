package com.HavanaClub.dto;

/**
 * Created by admin on 5/26/2017.
 */
public class IngredientDto {

    private int id;
    private String name;

    public IngredientDto() {
    }

    public IngredientDto(int id, String name) {
        this.id = id;
        this.name = name;
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
}
