package cuc.waimai.mapper;

import cuc.waimai.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryMapper {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    List<ShopCategory> selectAll();

    int updateByPrimaryKey(ShopCategory record);

    List<ShopCategory> selectByCategoryId(Integer categoryId);
}