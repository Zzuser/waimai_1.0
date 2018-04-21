package cuc.waimai.mapper;

import cuc.waimai.Dao.FoodShop;

import java.util.List;

public interface FoodShopMapper {
    int deleteByPrimaryKey(Integer foodShopId);

    int insert(FoodShop record);

    FoodShop selectByPrimaryKey(Integer foodShopId);

    List<FoodShop> selectAll();

    int updateByPrimaryKey(FoodShop record);
}