package cuc.waimai.mapper;

import cuc.waimai.Dao.Province;

import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer provinceId);

    int insert(Province record);

    Province selectByPrimaryKey(Integer provinceId);

    List<Province> selectAll();

    int updateByPrimaryKey(Province record);
}