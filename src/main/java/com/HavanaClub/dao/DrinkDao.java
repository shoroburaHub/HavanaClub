package com.HavanaClub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HavanaClub.entity.Drink;

public interface DrinkDao extends JpaRepository<Drink, Integer>{

	@Query("select distinct d from Drink d left join fetch d.ingredients")
	List<Drink> drinksWithIngredients();
	
}
