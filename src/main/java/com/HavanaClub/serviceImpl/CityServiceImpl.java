package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.CityDao;
import com.HavanaClub.entity.City;
import com.HavanaClub.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void delete(int id) {
        cityDao.delete(id);
    }

    @Override
    public void update(String info) {

        City city = cityDao.findOne(Integer.parseInt(info.split("_")[1]));

        city.setName(info.split("_")[0]);

        cityDao.save(city);

    }
}
