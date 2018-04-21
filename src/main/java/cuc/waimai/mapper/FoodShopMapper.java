package cuc.waimai.mapper;

import cuc.waimai.Dao.FoodShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodShopMapper {
    int deleteByPrimaryKey(Integer foodShopId);

    int insert(FoodShop record);

    FoodShop selectByPrimaryKey(Integer foodShopId);

    List<FoodShop> selectAll();

    int updateByPrimaryKey(FoodShop record);

    List<FoodShop> selectByFoodId(Integer foodId);

     List<FoodShop> selectByShopId(Integer shopId);

    FoodShop selectByFoodIdAndShopId(@Param("foodId") Integer foodId, @Param("shopId") Integer shopId);


}