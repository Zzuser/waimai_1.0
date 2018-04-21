package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Category;
import cuc.waimai.mapper.CategoryMapper;
import cuc.waimai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public int deleteByPrimaryKey(Integer catId) {
        return categoryMapper.deleteByPrimaryKey(catId);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer catId) {
        return categoryMapper.selectByPrimaryKey(catId);
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }
}
