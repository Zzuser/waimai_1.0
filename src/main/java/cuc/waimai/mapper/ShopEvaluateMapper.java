package cuc.waimai.mapper;

import cuc.waimai.Dao.ShopEvaluate;
import java.util.List;

public interface ShopEvaluateMapper {
    int deleteByPrimaryKey(Integer evId);

    int insert(ShopEvaluate record);

    ShopEvaluate selectByPrimaryKey(Integer evId);

    List<ShopEvaluate> selectAll();

    int updateByPrimaryKey(ShopEvaluate record);
}