package com.HavanaClub.serviceImpl;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HavanaClub.dao.CommodityDao;
import com.HavanaClub.entity.Commodity;
import com.HavanaClub.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityDao commodityDao;

	public void save(Commodity commodity) {
		commodityDao.save(commodity);
	}

	@Transactional(readOnly=true)
	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public Commodity findOne(int id) {
		// TODO Auto-generated method stub
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);
	}

	public void update(Commodity commodity) {
		commodityDao.save(commodity);
	}
	
	
}
