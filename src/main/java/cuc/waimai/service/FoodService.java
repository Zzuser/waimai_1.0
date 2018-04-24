package cuc.waimai.service;

import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.FoodShop;

import java.util.List;

public interface FoodService {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    Food selectByPrimaryKey(Integer foodId);

    List<Food> selectAll();

    int updateByPrimaryKey(Food record);

    List<Food>selectByCategoryId(Integer categoryId);

}
