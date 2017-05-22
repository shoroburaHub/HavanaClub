package com.HavanaClub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HavanaClub.entity.Ingredient;

public interface IngredientDao extends JpaRepository<Ingredient, Integer>{

	@Query("select i from Ingredient i left join fetch i.measuringSystems")
	List<Ingredient> ingredientsWithMeasuringSystem(); 
	
	
	@Query("select i from Ingredient i left join fetch i.measuringSystems where i.id =:id")
	Ingredient findIngredientWithMeasuringSystem(@Param("id") int id);
	
	
}
