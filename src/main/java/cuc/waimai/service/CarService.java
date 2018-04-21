package cuc.waimai.service;

import cuc.waimai.Dao.Car;

import java.util.List;

public interface CarService {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    Car selectByPrimaryKey(Integer carId);

    List<Car> selectAll();

    int updateByPrimaryKey(Car record);
}
