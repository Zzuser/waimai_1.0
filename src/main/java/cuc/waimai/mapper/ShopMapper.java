package cuc.waimai.mapper;

import cuc.waimai.entity.Shop;

import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);

    Shop selectByShopTel(String shopTel);
}