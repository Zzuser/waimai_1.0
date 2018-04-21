package cuc.waimai.service;

import cuc.waimai.Dao.Province;

import java.util.List;

public interface ProvinceService {
    int deleteByPrimaryKey(Integer provinceId);

    int insert(Province record);

    Province selectByPrimaryKey(Integer provinceId);

    List<Province> selectAll();

    int updateByPrimaryKey(Province record);
}
