package cuc.waimai.mapper;

import cuc.waimai.entity.Food;

import java.util.List;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    Food selectByPrimaryKey(Integer foodId);

    List<Food> selectAll();

    int updateByPrimaryKey(Food record);

    List<Food>selectByCategoryId(Integer categoryId);

    Food selectByFoodName(String foodName);
}//selectByFoodName