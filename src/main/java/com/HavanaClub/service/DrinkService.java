package com.HavanaClub.service;

import com.HavanaClub.entity.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

public interface DrinkService {

    void save(Drink drink, ArrayList<Integer> ids, MultipartFile image);

    List<Drink> findAll(Pageable pageable);
    Page<Drink> drinksWithIngredientsPages(Pageable pageable);

    Drink findOne(int id);

    void delete(int id);

    List<Drink> drinkWithIngredientsParsed();

    Drink drinkWithIngredients(int id);

    Drink drinkWithIngredientsParsed(int id);

    Drink drinkWithAllInfo(int id);

    void updateDrink(Drink drink, MultipartFile image, ArrayList<Integer> ingredients);

    int random();

    List<Drink> searchDrinks(String search);

}
