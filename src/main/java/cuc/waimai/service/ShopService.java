package cuc.waimai.service;

import cuc.waimai.entity.Shop;

import java.util.List;

public interface ShopService {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);

    Shop selectByShopTel(String shopTel);
}
