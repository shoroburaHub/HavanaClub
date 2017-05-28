package com.HavanaClub.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String drinkName;

    @Type(type="text")
    private String recipe;

    @ManyToOne
    private Country country;

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
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();


    public Drink() {
        // TODO Auto-generated constructor stub
    }

    public Drink(String drinkName) {
        super();
        this.drinkName = drinkName;
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

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", recipe='" + recipe + '\'' +
                ", country=" + country +
                ", ingredients=" + ingredients +
                '}';
    }
}
