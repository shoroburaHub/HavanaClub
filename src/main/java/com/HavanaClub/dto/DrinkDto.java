package com.HavanaClub.dto;

/**
 * Created by admin on 6/21/2017.
 */
public class DrinkDto {

    private int id;
    private String drinkName;
    private String recipe;

    public DrinkDto() {
    }

    public DrinkDto(int id, String drinkName, String recipe) {
        this.id = id;
        this.drinkName = drinkName;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
