package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.dto.DrinkDto;
import com.HavanaClub.dto.DrinkDtoCreate;
import com.HavanaClub.dto.DtoUtilMapper;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkDao drinkDao;
    @Autowired
    private IngredientDao ingredientDao;

    public void save(DrinkDtoCreate drinkDtoCreate) {

        Drink drink = new Drink();
        drink.setName(drinkDtoCreate.getName());

        drinkDao.saveAndFlush(drink);

        drink.
                setCountry(DtoUtilMapper.
                        countryDtoToCounty(drinkDtoCreate.
                                getCountryDto()));

        drink.
                setIngredients(DtoUtilMapper
                        .ingredientsDtosToIngredients(drinkDtoCreate
                                .getIngredientDtos()));

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

    @Override
    public Drink drinksWithIngredients(int id) {
        return drinkDao.drinksWithIngredients(id);
    }

    @Override
    public void updateDrink(int drink_id, int ingredient_id) {

        Drink drink = drinkDao.drinksWithIngredients(drink_id);

        for (Ingredient ingredient : drink.getIngredients()) {

            if(ingredient.getId() == ingredient_id){
                ingredient.setDrinks(null);
            }
            ingredientDao.save(ingredient);
        }
    }


    @Override
    public Drink drinkWithAllInfo(int id) {

        Drink  drink = drinkDao.drinksWithIngredients(id);
        Drink drink1 = drinkDao.drinksWithUsers(id);

        Drink returnedDrink = new Drink();
        returnedDrink.setId(drink.getId());
        returnedDrink.setIngredients(drink.getIngredients());
        returnedDrink.setUsers(drink1.getUsers());


        return returnedDrink;
    }
}
