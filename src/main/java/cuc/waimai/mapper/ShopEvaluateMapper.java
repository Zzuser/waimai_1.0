package cuc.waimai.mapper;

import cuc.waimai.entity.ShopEvaluate;

import java.util.List;

public interface ShopEvaluateMapper {
    int deleteByPrimaryKey(Integer evId);

    int insert(ShopEvaluate record);

    ShopEvaluate selectByPrimaryKey(Integer evId);

    List<ShopEvaluate> selectAll();

    int updateByPrimaryKey(ShopEvaluate record);

    List<ShopEvaluate> selectByShopId(Integer shopId);

    List<ShopEvaluate> selectByUserId(Integer userId);


}
//selectByUserId