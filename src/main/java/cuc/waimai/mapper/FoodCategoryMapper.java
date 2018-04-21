package cuc.waimai.mapper;

import cuc.waimai.Dao.FoodCategory;

import java.util.List;

public interface FoodCategoryMapper {
    int deleteByPrimaryKey(Integer foodCategoryId);

    int insert(FoodCategory record);

    FoodCategory selectByPrimaryKey(Integer foodCategoryId);

    List<FoodCategory> selectAll();

    int updateByPrimaryKey(FoodCategory record);
}