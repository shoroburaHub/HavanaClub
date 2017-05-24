package com.HavanaClub.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String quantity;

	@ManyToMany
	@JoinTable(name = "drink_ingredient", 
	joinColumns = @JoinColumn(name = "id_ingredient"), 
	inverseJoinColumns = @JoinColumn(name = "id_drink"))
	private List<Drink> drinks = new ArrayList<Drink>();
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String name, String quantity) {
		this.name = name;
		this.quantity = quantity;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
}
