package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.ShopType;
import cuc.waimai.mapper.ShopTypeMapper;
import cuc.waimai.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopTypeServiceImpl implements ShopTypeService{
    @Autowired
    ShopTypeMapper shoptypeMapper;
    @Override
    public int deleteByPrimaryKey(Integer shoptypeId) {
        return shoptypeMapper.deleteByPrimaryKey(shoptypeId);
    }

    @Override
    public int insert(ShopType record) {
        return shoptypeMapper.insert(record);
    }

    @Override
    public ShopType selectByPrimaryKey(Integer shoptypeId) {
        return shoptypeMapper.selectByPrimaryKey(shoptypeId);
    }

    @Override
    public List<ShopType> selectAll() {
        return shoptypeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShopType record) {
        return shoptypeMapper.updateByPrimaryKey(record);
    }
}
