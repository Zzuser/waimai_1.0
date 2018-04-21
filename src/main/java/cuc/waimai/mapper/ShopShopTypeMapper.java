package cuc.waimai.mapper;

import cuc.waimai.Dao.ShopShopType;
import java.util.List;

public interface ShopShopTypeMapper {
    int deleteByPrimaryKey(Integer shopShoptypeId);

    int insert(ShopShopType record);

    ShopShopType selectByPrimaryKey(Integer shopShoptypeId);

    List<ShopShopType> selectAll();

    int updateByPrimaryKey(ShopShopType record);
}