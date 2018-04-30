package cuc.waimai.service;

import cuc.waimai.Dao.City;

import java.util.List;

public interface CityService {
    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    City selectByPrimaryKey(Integer cityId);

    List<City> selectAll();

    int updateByPrimaryKey(City record);
}
