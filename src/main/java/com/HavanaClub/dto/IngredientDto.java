package com.HavanaClub.dto;

/**
 * Created by admin on 6/22/2017.
 */
public class IngredientDto {

    private String ingredientName;

    public IngredientDto(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
