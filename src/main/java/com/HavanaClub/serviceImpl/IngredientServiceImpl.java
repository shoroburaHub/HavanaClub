package com.HavanaClub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.dao.MeasuringSystemDao;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.entity.MeasuringSystem;
import com.HavanaClub.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientDao ingredientDao;
	@Autowired
	private MeasuringSystemDao measuringSystemDao;
	
	public void save(Ingredient ingredient, int idMS) {
		
		MeasuringSystem measuringSystem = measuringSystemDao.findOne(idMS);
		
		ingredientDao.saveAndFlush(ingredient);
		
		ingredient.getMeasuringSystems().add(measuringSystem);
		
		ingredientDao.save(ingredient);
	}

	public List<Ingredient> findAll() {
		return ingredientDao.findAll();
	}

	public Ingredient findOne(int id) {
		return ingredientDao.findOne(id);
	}

	public void delete(int id) {
		ingredientDao.delete(id);
	}

	public void update(Ingredient ingredient) {
		ingredientDao.save(ingredient);
	}

	public List<Ingredient> ingredientsWithMeasuringSystem() {
		 
		return ingredientDao.ingredientsWithMeasuringSystem();
	}

	public Ingredient findIngredientWithMeasuringSystem(int id) {
		
		return ingredientDao.findIngredientWithMeasuringSystem(id);
	}
	
	
	
}
