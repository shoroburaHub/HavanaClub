package com.HavanaClub.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "orders_drink", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "drink_id"))
	private Set<Drink> drinks = new HashSet<Drink>();

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(LocalDate date) {
		super();
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(Set<Drink> drinks) {
		this.drinks = drinks;
	}

}
