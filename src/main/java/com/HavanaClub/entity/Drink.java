package com.HavanaClub.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

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

	public Drink(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	

}
