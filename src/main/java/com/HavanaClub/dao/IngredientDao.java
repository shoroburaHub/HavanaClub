package com.HavanaClub.dao;

import com.HavanaClub.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientDao extends JpaRepository<Ingredient, Integer> {

    @Query("select i from Ingredient i left join fetch i.drinks where i.id=:id")
    Ingredient ingredientWirthDrinks(@Param("id") int id);


}
