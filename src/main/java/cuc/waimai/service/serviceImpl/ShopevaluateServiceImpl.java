package cuc.waimai.service.serviceImpl;


import cuc.waimai.entity.ShopEvaluate;
import cuc.waimai.mapper.ShopEvaluateMapper;

import cuc.waimai.service.ShopEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopevaluateServiceImpl implements ShopEvaluateService {
@Autowired
ShopEvaluateMapper shopevaluateMapper;
    @Override
    public int deleteByPrimaryKey(Integer evId) {
        return shopevaluateMapper.deleteByPrimaryKey(evId);
    }

    @Override
    public int insert(ShopEvaluate record) {
        return shopevaluateMapper.insert(record);
    }

    @Override
    public ShopEvaluate selectByPrimaryKey(Integer evId) {
        return shopevaluateMapper.selectByPrimaryKey(evId);
    }

    @Override
    public List<ShopEvaluate> selectAll() {
        return shopevaluateMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShopEvaluate record) {
        return shopevaluateMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ShopEvaluate> selectByShopId(Integer shopId) {
        return shopevaluateMapper.selectByShopId(shopId);
    }

    @Override
    public List<ShopEvaluate> selectByUserId(Integer userId) {
        return selectByUserId(userId);
    }
}
