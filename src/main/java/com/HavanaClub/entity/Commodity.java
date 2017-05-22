package com.HavanaClub.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate startDate;

	private LocalDate endDate;

	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public Commodity(LocalDate startDate) {
		super();
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
