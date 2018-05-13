package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.ShopShopType;
import cuc.waimai.mapper.ShopShopTypeMapper;
import cuc.waimai.service.ShopShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopShoptypeServiceImpl implements ShopShopTypeService
{
    @Autowired
    ShopShopTypeMapper shopShoptypeMapper;
    @Override
    public int deleteByPrimaryKey(Integer shopShoptypeId) {
        return shopShoptypeMapper.deleteByPrimaryKey(shopShoptypeId);
    }

    @Override
    public int insert(ShopShopType record) {
        return shopShoptypeMapper.insert(record);
    }

    @Override
    public ShopShopType selectByPrimaryKey(Integer shopShoptypeId) {
        return shopShoptypeMapper.selectByPrimaryKey(shopShoptypeId);
    }

    @Override
    public List<ShopShopType> selectAll() {
        return shopShoptypeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShopShopType record) {
        return shopShoptypeMapper.updateByPrimaryKey(record);
    }
}
