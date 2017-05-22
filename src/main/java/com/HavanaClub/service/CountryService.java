package com.HavanaClub.service;

import java.util.List;

import com.HavanaClub.entity.Country;


public interface CountryService {

	void save(Country country);

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country);
	
}
