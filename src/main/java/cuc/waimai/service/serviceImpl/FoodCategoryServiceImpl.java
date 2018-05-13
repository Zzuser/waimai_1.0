package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.FoodCategory;
import cuc.waimai.mapper.FoodCategoryMapper;
import cuc.waimai.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
    @Autowired
    FoodCategoryMapper foodCategoryMapper;
    @Override
    public int deleteByPrimaryKey(Integer foodCategoryId) {
        return foodCategoryMapper.deleteByPrimaryKey(foodCategoryId);
    }

    @Override
    public int insert(FoodCategory record) {
        return foodCategoryMapper.insert(record);
    }

    @Override
    public FoodCategory selectByPrimaryKey(Integer foodCategoryId) {
        return foodCategoryMapper.selectByPrimaryKey(foodCategoryId);
    }

    @Override
    public List<FoodCategory> selectAll() {
        return foodCategoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FoodCategory record) {
        return foodCategoryMapper.updateByPrimaryKey(record);
    }
}
