package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.Car;
import cuc.waimai.mapper.CarMapper;
import cuc.waimai.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;
    @Override
    public int deleteByPrimaryKey(Integer carId) {
        return carMapper.deleteByPrimaryKey(carId);
    }

    @Override
    public int insert(Car record) {
        return carMapper.insert(record);
    }

    @Override
    public Car selectByPrimaryKey(Integer carId) {
        return carMapper.selectByPrimaryKey(carId);
    }

    @Override
    public List<Car> selectAll() {
        return carMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Car record) {
        return carMapper.updateByPrimaryKey(record);
    }
}
