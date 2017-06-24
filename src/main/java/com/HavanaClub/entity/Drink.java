package com.HavanaClub.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drink", indexes = @Index(columnList = "drinkName",  name = "drinkName_index"))
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String drinkName;

    private String pathImage;

    @Type(type="text")
    private String recipe;

    @ManyToOne
    private Country country;

    private int price;
    private boolean alcohol;



    @ManyToMany
    @JoinTable(name = "orders_drink", joinColumns = @JoinColumn(name = "drink_id"), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders = new ArrayList<Orders>();

    @ManyToMany
    @JoinTable(name = "drink_user", joinColumns = @JoinColumn(name = "id_drink"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<User>();

    @ManyToMany
    @JoinTable(name = "drink_ingredient",
            joinColumns = @JoinColumn(name = "id_drink"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private List<Ingredient> ingredients = new ArrayList<>();


    public Drink() {
        // TODO Auto-generated constructor stub
    }

    public Drink(String drinkName) {
        super();
        this.drinkName = drinkName;
    }

    public Drink(int id, String drinkName, String recipe) {
        this.id = id;
        this.drinkName = drinkName;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", price=" + price +
                ", alcohol=" + alcohol +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        return id == drink.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
