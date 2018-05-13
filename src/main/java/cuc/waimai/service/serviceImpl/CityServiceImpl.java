package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.City;
import cuc.waimai.mapper.CityMapper;
import cuc.waimai.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;
    @Override
    public int deleteByPrimaryKey(Integer cityId) {
        return cityMapper.deleteByPrimaryKey(cityId);
    }

    @Override
    public int insert(City record) {
        return cityMapper.insert(record);
    }

    @Override
    public City selectByPrimaryKey(Integer cityId) {
        return cityMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public List<City> selectAll() {
        return cityMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(City record) {
        return cityMapper.updateByPrimaryKey(record);
    }
}
