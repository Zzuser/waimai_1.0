package cuc.waimai.service;

import cuc.waimai.entity.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
    int deleteByPrimaryKey(Integer foodCategoryId);

    int insert(FoodCategory record);

    FoodCategory selectByPrimaryKey(Integer foodCategoryId);

    List<FoodCategory> selectAll();

    int updateByPrimaryKey(FoodCategory record);
}
