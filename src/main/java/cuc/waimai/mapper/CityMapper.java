package cuc.waimai.mapper;

import cuc.waimai.entity.City;
import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    City selectByPrimaryKey(Integer cityId);

    List<City> selectAll();

    int updateByPrimaryKey(City record);
}