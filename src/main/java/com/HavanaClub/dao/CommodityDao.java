package com.HavanaClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HavanaClub.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer>{

}
