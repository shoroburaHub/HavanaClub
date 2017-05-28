package com.HavanaClub.service;

import com.HavanaClub.entity.Drink;

import java.util.ArrayList;
import java.util.List;

public interface DrinkService {

    void save(Drink drink, ArrayList<Integer> ids);

    List<Drink> findAll();

    Drink findOne(int id);

    void delete(int id);

    void update(Drink drink);

    List<Drink> drinksWithIngredients();

    Drink drinksWithIngredients(int id);

    void updateDrink(int drink_id, int ingredient_id);

    Drink drinkWithAllInfo(int id);

}
