package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.IngredientDao;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
            Ingredient ingredient = ingredientDao.ingredientWithDrinks(id);
            ingredient.getDrinks().add(drink);
            ingredientDao.save(ingredient);
        }

        drinkDao.save(drink);
    }

    @Override
    public List<Drink> findAll(Pageable pageable) {
        return drinkDao.findAll();
    }

    public Page<Drink> drinksWithIngredientsPages(Pageable pageable) {
        return drinkDao.drinksWithIngredientsPages(pageable);
    }

    public Drink findOne(int id) {
        return drinkDao.findOne(id);
    }

    public void delete(int id) {
        drinkDao.delete(id);
    }

    public List<Drink> drinkWithIngredientsParsed() {

        List<Drink> drinks = drinkDao.drinkWithIngredients();

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
    public Drink drinkWithIngredientsParsed(int id) {

        System.out.println("id = " + id);

        Drink drink = drinkDao.drinkWithIngredients(id);

        System.out.println("drink = " + drink);

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
    public Drink drinkWithIngredients(int id) {
        return drinkDao.drinkWithIngredients(id);
    }

    @Override
    public Drink drinkWithAllInfo(int id) {
        Drink drink = drinkDao.drinkWithIngredients(id);
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

        Iterator<Ingredient> iterator = drink.getIngredients().iterator();

        while (iterator.hasNext()) {

            if (ingredients.contains(iterator.next().getId())) {

            } else {
                iterator.remove();
            }

        }

        drinkDao.save(drink);

    }

    @Override
    public int random() {

        List<Drink> drinks = drinkDao.drinkWithIngredients();

        return drinks.get((int)(Math.random()*drinks.size())).getId();
    }
}
