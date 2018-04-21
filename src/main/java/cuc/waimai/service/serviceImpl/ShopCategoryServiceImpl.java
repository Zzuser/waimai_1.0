package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.ShopCategory;
import cuc.waimai.mapper.ShopCategoryMapper;
import cuc.waimai.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
@Autowired
    ShopCategoryMapper shopCategoryMapper;
    @Override
    public int deleteByPrimaryKey(Integer shopCategoryId) {
        return shopCategoryMapper.deleteByPrimaryKey(shopCategoryId);
    }

    @Override
    public int insert(ShopCategory record) {
        return shopCategoryMapper.insert(record);
    }

    @Override
    public ShopCategory selectByPrimaryKey(Integer shopCategoryId) {
        return shopCategoryMapper.selectByPrimaryKey(shopCategoryId);
    }

    @Override
    public List<ShopCategory> selectAll() {
        return shopCategoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShopCategory record) {
        return shopCategoryMapper.updateByPrimaryKey(record);
    }
}
