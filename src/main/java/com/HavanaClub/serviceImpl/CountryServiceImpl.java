package com.HavanaClub.serviceImpl;

import java.util.List;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.entity.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.CountryDao;
import com.HavanaClub.entity.Country;
import com.HavanaClub.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private DrinkDao drinkDao;


	public void save(Country country) {
		countryDao.save(country);
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	public void delete(int id) {

		Country country = countryDao.countryWithDrinks(id);

		for (Drink drink : country.getDrinks()) {

			drink.setCountry(null);
			drinkDao.saveAndFlush(drink);

		}

		countryDao.delete(id);
	}

	public void update(Country country) {
		countryDao.save(country);
	}

	
	
	
	
}
