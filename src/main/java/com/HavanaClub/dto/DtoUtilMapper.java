package com.HavanaClub.dto;

import com.HavanaClub.entity.Drink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/21/2017.
 */
public class DtoUtilMapper {

    public static DrinkDto drinkToDrinkDto(Drink drink){
        return new DrinkDto(drink.getId(),drink.getDrinkName(),drink.getRecipe());
    }

    public static List<DrinkDto>drinksToDrinksDtos(List<Drink> drinks){
        List<DrinkDto> drinkDtos = new ArrayList<>();

        for (Drink drink : drinks) {
            drinkDtos.add(drinkToDrinkDto(drink));
        }

        return drinkDtos;
    }

}
