package com.HavanaClub.parser;

import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/27/2017.
 */
public class DrinkIngredients {

    public static List<Drink> getDrinkNames(Document document) {

        List<Drink> drinks = new ArrayList<>();
        Elements elementsList = document.select("tbody > tr > td");

        for (Element element : elementsList) {

            Drink drink = new Drink();

            String line = element.text();
            try {

                if (line.contains("(") && line.contains(")")) {
                    if (line.contains("(МЕКСИКАНСКАЯ НОЧЬ)")) {


                        String current = line.substring((line.indexOf(")") + 1), line.indexOf("1.") - 1).trim();
                        String[] ingredients = current.split(";");
                        for (String ing : ingredients) {

                            Ingredient ingredient = new Ingredient();
                            ingredient.setIngredientName(ing);

                            drink.getIngredients().add(ingredient);

                        }

                        drink.setRecipe(line.substring(line.indexOf("1.") - 1).trim());

                        System.out.println();

                        drink.setDrinkName(line.substring(0, line.indexOf(")") + 1));

                       drinks.add(drink);

                    } else {
                        String current = line.substring((line.indexOf(")") + 1), line.indexOf("1.") - 1).trim();
                        String[] ingredients = current.split(";");
                        for (String ingre : ingredients) {

                            Ingredient ingredient = new Ingredient();
                            ingredient.setIngredientName(ingre);
                            drink.getIngredients().add(ingredient);
                        }

                        drink.setRecipe(line.substring(line.indexOf("1.") - 1).trim());

                        drink.setDrinkName(line.substring(0, line.indexOf(")") + 1));

                        drinks.add(drink);

                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
            }

        }

        return drinks;
    }

}
