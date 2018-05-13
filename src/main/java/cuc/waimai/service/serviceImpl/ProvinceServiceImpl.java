package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.Province;
import cuc.waimai.mapper.ProvinceMapper;
import cuc.waimai.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;
    @Override
    public int deleteByPrimaryKey(Integer provinceId) {
        return provinceMapper.deleteByPrimaryKey(provinceId);
    }

    @Override
    public int insert(Province record) {
        return provinceMapper.insert(record);
    }

    @Override
    public Province selectByPrimaryKey(Integer provinceId) {
        return provinceMapper.selectByPrimaryKey(provinceId);
    }

    @Override
    public List<Province> selectAll() {
        return provinceMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Province record) {
        return provinceMapper.updateByPrimaryKey(record);
    }
}
