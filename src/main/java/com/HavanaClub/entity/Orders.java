package com.HavanaClub.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime localDateTime;

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "orders_drink", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "drink_id"))
	private Set<Drink> drinks = new HashSet<Drink>();

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(LocalDateTime localDateTime) {
		super();
		this.localDateTime = localDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
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
