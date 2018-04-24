package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Food;
import cuc.waimai.mapper.FoodMapper;
import cuc.waimai.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
@Autowired
    FoodMapper foodMapper;
    @Override
    public int deleteByPrimaryKey(Integer foodId) {
        return foodMapper.deleteByPrimaryKey(foodId);
    }

    @Override
    public int insert(Food record) {
        return foodMapper.insert(record);
    }

    @Override
    public Food selectByPrimaryKey(Integer foodId) {
        return foodMapper.selectByPrimaryKey(foodId);
    }

    @Override
    public List<Food> selectAll() {
        return foodMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Food record) {
        return foodMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Food> selectByCategoryId(Integer categoryId) {
        return foodMapper.selectByCategoryId(categoryId);
    }

}
