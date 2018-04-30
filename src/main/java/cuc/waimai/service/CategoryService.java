package cuc.waimai.service;

import cuc.waimai.Dao.Category;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(Integer catId);

    int insert(Category record);

    Category selectByPrimaryKey(Integer catId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}
