package com.HavanaClub.dto;

import com.HavanaClub.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/26/2017.
 */
public class DrinkDtoCreate {

    private String name;

    private CountryDto countryDto;

    private List<IngredientDto> ingredientDtos = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

    public List<IngredientDto> getIngredientDtos() {
        return ingredientDtos;
    }

    public void setIngredientDtos(List<IngredientDto> ingredientDtos) {
        this.ingredientDtos = ingredientDtos;
    }

    @Override
    public String toString() {
        return "DrinkDtoCreate{" +
                "name='" + name + '\'' +
                ", countryDto=" + countryDto +
                ", ingredientDtos=" + ingredientDtos +
                '}';
    }
}
