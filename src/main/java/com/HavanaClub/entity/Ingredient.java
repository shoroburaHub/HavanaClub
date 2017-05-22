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

	private double quantity;

	@ManyToMany
	@JoinTable(name = "ingredient_measuring_system", 
	joinColumns = @JoinColumn(name = "ingredient_id"), 
	inverseJoinColumns = @JoinColumn(name = "measuring_system_id"))
	private List<MeasuringSystem> measuringSystems = new ArrayList<MeasuringSystem>();

	@ManyToMany
	@JoinTable(name = "drink_ingredient", 
	joinColumns = @JoinColumn(name = "id_ingredient"), 
	inverseJoinColumns = @JoinColumn(name = "id_drink"))
	private List<Drink> drinks = new ArrayList<Drink>();
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String name, double quantity) {
		super();
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public List<MeasuringSystem> getMeasuringSystems() {
		return measuringSystems;
	}

	public void setMeasuringSystems(List<MeasuringSystem> measuringSystems) {
		this.measuringSystems = measuringSystems;
	}

}
