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

	private String ingredientName;

	@ManyToMany
	@JoinTable(name = "drink_ingredient", 
	joinColumns = @JoinColumn(name = "id_ingredient"), 
	inverseJoinColumns = @JoinColumn(name = "id_drink"))
	private List<Drink> drinks = new ArrayList<Drink>();
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int id, String ingredientName) {
		this.id = id;
		this.ingredientName = ingredientName;
	}

	public Ingredient(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

	@Override
	public String toString() {
		return "Ingredient{" +
				"id=" + id +
				", ingredientName='" + ingredientName + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Ingredient that = (Ingredient) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
