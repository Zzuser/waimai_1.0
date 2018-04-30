package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Shop;
import cuc.waimai.mapper.ShopMapper;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopMapper shopMapper;
    @Override
    public int deleteByPrimaryKey(Integer shopId) {
        return shopMapper.deleteByPrimaryKey(shopId);
    }

    @Override
    public int insert(Shop record) {
        return shopMapper.insert(record);
    }

    @Override
    public Shop selectByPrimaryKey(Integer shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Shop record) {
        return shopMapper.updateByPrimaryKey(record);
    }

    @Override
    public Shop selectByShopTel(String shopTel) {
        return shopMapper.selectByShopTel(shopTel);
    }
}
