package cuc.waimai.mapper;

import cuc.waimai.Dao.ShopType;

import java.util.List;

public interface ShopTypeMapper {
    int deleteByPrimaryKey(Integer shoptypeId);

    int insert(ShopType record);

    ShopType selectByPrimaryKey(Integer shoptypeId);

    List<ShopType> selectAll();

    int updateByPrimaryKey(ShopType record);
}