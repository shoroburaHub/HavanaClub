package com.HavanaClub.dto;

import com.HavanaClub.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/21/2017.
 */
public class DrinkDto {

    private int id;
    private String drinkName;
    private String pathImage;
    private String recipe;

    private List<IngredientDto> ingredients = new ArrayList<>();

    public DrinkDto() {
    }

    public DrinkDto(int id, String drinkName, String pathImage, String recipe) {
        this.id = id;
        this.drinkName = drinkName;
        this.pathImage = pathImage;
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
