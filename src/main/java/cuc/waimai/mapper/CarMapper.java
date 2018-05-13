package cuc.waimai.mapper;

import cuc.waimai.entity.Car;
import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    Car selectByPrimaryKey(Integer carId);

    List<Car> selectAll();

    int updateByPrimaryKey(Car record);
}