package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.FoodShop;
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

    @Override
    public List<FoodShop> selectByFoodId(Integer foodId) {
        return foodShopMapper.selectByFoodId(foodId);
    }

    @Override
    public List<FoodShop> selectByShopId(Integer shopId) {
        return foodShopMapper.selectByShopId(shopId);
    }

    @Override
    public FoodShop selectByFoodIdAndShopId(Integer foodId, Integer shopId) {
        return foodShopMapper.selectByFoodIdAndShopId(foodId,shopId);
    }
}
