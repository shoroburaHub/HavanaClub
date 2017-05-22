package com.HavanaClub.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.entity.User;

public interface IngredientService{

	void save(Ingredient ingredient, int idMS);

	List<Ingredient> findAll();

	Ingredient findOne(int id);

	void delete(int id);

	void update(Ingredient ingredient);

	List<Ingredient> ingredientsWithMeasuringSystem();
	
	Ingredient findIngredientWithMeasuringSystem(int id);
	
}
