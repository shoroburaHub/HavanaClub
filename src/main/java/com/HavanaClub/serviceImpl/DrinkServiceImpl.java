package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkDao drinkDao;
    @Autowired
    private IngredientDao ingredientDao;


    public void save(Drink drink, ArrayList<Integer> ids, MultipartFile image) {

        drinkDao.saveAndFlush(drink);

        String path = System.getProperty("catalina.home") + "/resources/"
                + drink.getDrinkName() + "/" + image.getOriginalFilename();

        drink.setPathImage("resources/" + drink.getDrinkName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        for (Integer id : ids) {
            Ingredient ingredient = ingredientDao.ingredientWirthDrinks(id);
            ingredient.getDrinks().add(drink);
            ingredientDao.save(ingredient);
        }

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

    public List<Drink> drinkWithIngredients() {

        List<Drink> drinks = drinkDao.drinksWithIngredients();

        for (Drink drink : drinks) {

            String recipe = drink.getRecipe();

            recipe = recipe.replaceAll("-?\\d+\\.", "_");

            String[] line = recipe.split("_");

            recipe = "";

            for (int i = 1; i < line.length; i++) {
                recipe += i + ". " + line[i].trim() + "<br>";
            }

            drink.setRecipe(recipe);

        }

        return drinks;
    }

    @Override
    public Drink drinkWithIngredients(int id) {
        Drink drink = drinkDao.drinksWithIngredients(id);

        String recipe = drink.getRecipe();

        recipe = recipe.replaceAll("-?\\d+\\.", "_");

        String[] line = recipe.split("_");

        recipe = "";

        for (int i = 1; i < line.length; i++) {
            recipe += i + ". " + line[i].trim() + "<br>";
        }

        drink.setRecipe(recipe);

        return drink;
    }

    @Override
    public Drink drinkWithAllInfo(int id) {

        Drink drink = drinkDao.drinksWithIngredients(id);
        Drink drink1 = drinkDao.drinksWithUsers(id);

        Drink returnedDrink = new Drink();
        returnedDrink.setId(drink.getId());
        returnedDrink.setIngredients(drink.getIngredients());
        returnedDrink.setUsers(drink1.getUsers());

        return returnedDrink;
    }

    @Transactional
    @Override
    public void updateDrink(Drink drink, MultipartFile image, ArrayList<Integer> ingredients) {

        String path = System.getProperty("catalina.home") + "/resources/"
                + drink.getDrinkName() + "/" + image.getOriginalFilename();

        drink.setPathImage("resources/" + drink.getDrinkName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        drinkDao.save(drink);

    }
}
