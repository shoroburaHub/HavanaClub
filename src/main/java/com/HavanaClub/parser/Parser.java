package com.HavanaClub.parser;

import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

/**
 * Created by admin on 5/27/2017.
 */
public class Parser {

    public static void main(String[] args) throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
        EntityManager manager = factory.createEntityManager();


        Document document = Jsoup.connect("http://art-zakaz.com.ua/stati/podgotovka-k-prazdniku/47-top-50-koktejlej-mira.html").get();

        manager.getTransaction().begin();

        for (Drink drink : DrinkIngredients.getDrinkNames(document)) {

            for (Ingredient ingredient : drink.getIngredients()) {

                if (ingredient.getIngredientName().contains("Д")) {
                    ingredient.setIngredientName(ingredient.getIngredientName().substring(0, ingredient.getIngredientName().indexOf("Д")));

                    manager.persist(ingredient);
                } else {
                    manager.persist(ingredient);
                }


            }

            manager.persist(drink);
        }

        manager.getTransaction().commit();


    }


}
