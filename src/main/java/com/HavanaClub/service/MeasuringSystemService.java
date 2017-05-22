package com.HavanaClub.service;

import java.util.List;

import com.HavanaClub.entity.MeasuringSystem;

public interface MeasuringSystemService {

	void save(MeasuringSystem measuringSystem);
	List<MeasuringSystem> findAll();
	MeasuringSystem findOne(int id);
	void delete(int id);
	void update(MeasuringSystem measuringSystem);
	
}
