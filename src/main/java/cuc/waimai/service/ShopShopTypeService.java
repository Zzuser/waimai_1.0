package cuc.waimai.service;

import cuc.waimai.entity.ShopShopType;
import java.util.List;

public interface ShopShopTypeService {
    int deleteByPrimaryKey(Integer shopShoptypeId);

    int insert(ShopShopType record);

    ShopShopType selectByPrimaryKey(Integer shopShoptypeId);

    List<ShopShopType> selectAll();

    int updateByPrimaryKey(ShopShopType record);
}
