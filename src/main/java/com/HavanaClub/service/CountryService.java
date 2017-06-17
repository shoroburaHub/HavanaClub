package com.HavanaClub.service;

import java.util.List;

import com.HavanaClub.entity.Country;
import org.springframework.web.multipart.MultipartFile;


public interface CountryService {

	void save(Country country, List<MultipartFile> image);

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country, MultipartFile image);

	List<Country> countriesWithImages();
	
}
