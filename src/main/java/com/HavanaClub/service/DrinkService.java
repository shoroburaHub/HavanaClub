package com.HavanaClub.service;

import java.util.List;

import com.HavanaClub.dto.DrinkDto;
import com.HavanaClub.dto.DrinkDtoCreate;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.User;

public interface DrinkService {

	void save(DrinkDtoCreate drinkDtoCreate);

	List<Drink> findAll();

	Drink findOne(int id);

	void delete(int id);

	void update(Drink drink);
	
	List<Drink> drinksWithIngredients();

	Drink drinksWithIngredients(int id);

	void updateDrink(int drink_id, int ingredient_id);

	Drink drinkWithAllInfo(int id);

}
