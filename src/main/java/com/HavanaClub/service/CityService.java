package com.HavanaClub.service;

import com.HavanaClub.entity.City;

import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */
public interface CityService {

    void save(City city);

    List<City> findAll();

    void delete(int id);


}
