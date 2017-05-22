package com.HavanaClub.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.CountryDao;
import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.DrinkService;

@Service
public class DrinkServiceImpl implements  DrinkService{

	@Autowired
	private DrinkDao drinkDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private IngredientDao ingredientDao;

	public void save(Drink drink, List<Integer> ingredientIds, int countryId) {
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(Integer id: ingredientIds){
			ingredients.add(ingredientDao.findOne(id));
		}
		
		drinkDao.saveAndFlush(drink);
		
		drink.setIngredients(ingredients);
		
		Country country = countryDao.findOne(countryId);
		
		drink.setCountry(country);
		
		drinkDao.save(drink);
		
	}

	public List<Drink> findAll() {
		return drinkDao.findAll();
	}

	public Drink findOne(int id) {
		return drinkDao.findOne(id);
	}

	public void delete(int id) {
		drinkDao.delete(id);
	}
	

	public void update(Drink drink) {
		drinkDao.save(drink);
	}

	public List<Drink> drinksWithIngredients() {
		return drinkDao.drinksWithIngredients();
	}
	
	
	
	
}
