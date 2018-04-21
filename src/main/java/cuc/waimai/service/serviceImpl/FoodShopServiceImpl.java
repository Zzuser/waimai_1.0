package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.FoodShop;
import cuc.waimai.mapper.FoodShopMapper;
import cuc.waimai.service.FoodShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodShopServiceImpl implements FoodShopService {
    @Autowired
    FoodShopMapper foodShopMapper;
    @Override
    public int deleteByPrimaryKey(Integer foodShopId) {
        return foodShopMapper.deleteByPrimaryKey(foodShopId);
    }

    @Override
    public int insert(FoodShop record) {
        return foodShopMapper.insert(record);
    }

    @Override
    public FoodShop selectByPrimaryKey(Integer foodShopId) {
        return foodShopMapper.selectByPrimaryKey(foodShopId);
    }

    @Override
    public List<FoodShop> selectAll() {
        return foodShopMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FoodShop record) {
        return foodShopMapper.updateByPrimaryKey(record);
    }
}
