package com.HavanaClub.dto;

import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/26/2017.
 */
public class DtoUtilMapper {

    public static DrinkDto drinkToDrinkDto(Drink drink){
        DrinkDto drinkDto = new DrinkDto();
        drinkDto.setId(drink.getId());
        drinkDto.setName(drink.getName());
        return drinkDto;
    }

    public static List<DrinkDto> drinksToDrinksDtos(List<Drink> drinks){

        List<DrinkDto> drinkDtos = new ArrayList<>();

        for (Drink drink : drinks) {

            drinkDtos.add(DtoUtilMapper.drinkToDrinkDto(drink));

        }

        return drinkDtos;
    }


    public static CountryDto countryToCountryDto(Country country){
        return new CountryDto(country.getId(), country.getName());
    }

    public static List<CountryDto> countriesToCountriesDtos(List<Country> countries){
        List<CountryDto> countryDtos = new ArrayList<>();
        for (Country country : countries) {
            countryDtos.add(countryToCountryDto(country));
        }
        return countryDtos;
    }

    public static IngredientDto ingredientToingredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.getId(), ingredient.getName());
    }

    public static List<IngredientDto> ingredientsToingredientsDtos(List<Ingredient> ingredients){
        List<IngredientDto> ingredientDtos = new ArrayList<>();
        for (Ingredient ingredient: ingredients) {
            ingredientDtos.add(ingredientToingredientDto(ingredient));
        }
        return ingredientDtos;
    }

    public static Country countryDtoToCounty(CountryDto countryDto){

        Country country = new Country();
        country.setId(countryDto.getId());

        return country;
    }

    public static List<Ingredient> ingredientsDtosToIngredients(List<IngredientDto> ingredientDtos){

        List<Ingredient> ingredients = new ArrayList<>();

        for (IngredientDto ingredientDto : ingredientDtos) {

            Ingredient ingredient = new Ingredient();

            ingredient.setId(ingredientDto.getId());

            ingredients.add(ingredient);

        }

        return ingredients;

    }



}
