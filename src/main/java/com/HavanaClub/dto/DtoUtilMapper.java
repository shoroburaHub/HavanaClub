package com.HavanaClub.dto;

import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/21/2017.
 */
public class DtoUtilMapper {

    public static DrinkDto drinkToDrinkDto(Drink drink){
        return new DrinkDto(drink.getId(),drink.getDrinkName(), drink.getPathImage(),drink.getRecipe());
    }

    public static IngredientDto ingredientToIngredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.getIngredientName());
    }

    public static List<IngredientDto> ingredientsToIngredientsDtos(List<Ingredient> ingredients){

        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            ingredientDtos.add(new IngredientDto(ingredient.getIngredientName()));
        }
        return ingredientDtos;
    }


    public static List<DrinkDto>drinksToDrinksDtos(List<Drink> drinks){
        List<DrinkDto> drinkDtos = new ArrayList<>();

        for (Drink drink : drinks) {

            DrinkDto drinkDto = drinkToDrinkDto(drink);
            drinkDto.setIngredients(ingredientsToIngredientsDtos(drink.getIngredients()));

            drinkDtos.add(drinkDto);

        }

        return drinkDtos;
    }

}
