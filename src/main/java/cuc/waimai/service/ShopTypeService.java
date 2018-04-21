package cuc.waimai.service;

import cuc.waimai.Dao.ShopType;

import java.util.List;

public interface ShopTypeService {
    int deleteByPrimaryKey(Integer shoptypeId);

    int insert(ShopType record);

    ShopType selectByPrimaryKey(Integer shoptypeId);

    List<ShopType> selectAll();

    int updateByPrimaryKey(ShopType record);
}
