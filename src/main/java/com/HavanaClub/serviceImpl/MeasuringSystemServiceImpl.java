package com.HavanaClub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.MeasuringSystemDao;
import com.HavanaClub.entity.MeasuringSystem;
import com.HavanaClub.service.MeasuringSystemService;

@Service 
public class MeasuringSystemServiceImpl implements MeasuringSystemService{
	
	@Autowired
	private MeasuringSystemDao measuringSystemDao;

	public void save(MeasuringSystem measuringSystem) {
		measuringSystemDao.save(measuringSystem);
	}

	public List<MeasuringSystem> findAll() {
		return measuringSystemDao.findAll();
	}

	public MeasuringSystem findOne(int id) {
		return measuringSystemDao.findOne(id);
	}

	public void delete(int id) {
		measuringSystemDao.delete(id);
	}

	public void update(MeasuringSystem measuringSystem) {
		measuringSystemDao.save(measuringSystem);
	}
	
	

}
