package cuc.waimai.mapper;

import cuc.waimai.Dao.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer catId);

    int insert(Category record);

    Category selectByPrimaryKey(Integer catId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);

    Category selectByCatName(String catName);
}