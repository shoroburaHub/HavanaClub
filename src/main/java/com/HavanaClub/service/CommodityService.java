package com.HavanaClub.service;

import com.HavanaClub.entity.Commodity;

import java.util.List;


public interface CommodityService {

	void save(Commodity commodity);

	List<Commodity> findAll();

	Commodity findOne(int id);

	void delete(int id);

	void update(Commodity commodity);
	
}
