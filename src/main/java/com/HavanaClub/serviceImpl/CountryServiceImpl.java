package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.CountryDao;
import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.service.CountryService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private DrinkDao drinkDao;

	public void save(Country country, MultipartFile image){

		countryDao.saveAndFlush(country);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ country.getName() + "/" + image.getOriginalFilename();

		country.setPathImage("resources/" + country.getName() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

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

	public void update(Country country, MultipartFile image) {

		country.setName(country.getName());

		String path = System.getProperty("catalina.home") + "/resources/"
				+ country.getName() + "/" + image.getOriginalFilename();

		country.setPathImage("resources/" + country.getName() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			try {
				FileUtils.cleanDirectory
						(new File(System.getProperty("catalina.home") + "/resources/" + country.getName() + "/"));
			} catch (IOException e) {

			}
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		countryDao.save(country);
	}

	
	
	
	
}
