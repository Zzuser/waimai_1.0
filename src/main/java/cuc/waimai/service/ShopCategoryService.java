package cuc.waimai.service;

import cuc.waimai.Dao.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    List<ShopCategory> selectAll();

    int updateByPrimaryKey(ShopCategory record);
}
