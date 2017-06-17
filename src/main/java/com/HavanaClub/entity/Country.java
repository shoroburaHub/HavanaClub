package com.HavanaClub.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "country")
	private List<Drink> drinks = new ArrayList<Drink>();

	@OneToMany(mappedBy = "country",cascade = CascadeType.REMOVE)
	private List<CountryImages> countryImages = new ArrayList<>();

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String name) {
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

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

	public List<CountryImages> getCountryImages() {
		return countryImages;
	}

	public void setCountryImages(List<CountryImages> countryImages) {
		this.countryImages = countryImages;
	}
}
