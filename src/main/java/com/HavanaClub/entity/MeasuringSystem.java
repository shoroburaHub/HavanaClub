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

@Entity
public class MeasuringSystem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	@JoinTable(name="ingredient_measuring_system",
	joinColumns=@JoinColumn(name="measuring_system_id"),
	inverseJoinColumns=@JoinColumn(name="ingredient_id"))
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public MeasuringSystem() {
		// TODO Auto-generated constructor stub
	}
	

	public MeasuringSystem(String name) {
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
	
	
	
}
