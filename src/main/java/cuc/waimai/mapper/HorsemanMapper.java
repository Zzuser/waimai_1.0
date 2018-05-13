package cuc.waimai.mapper;

import cuc.waimai.entity.Horseman;

import java.util.List;

public interface HorsemanMapper {
    int deleteByPrimaryKey(Integer horsemanId);

    int insert(Horseman record);

    Horseman selectByPrimaryKey(Integer horsemanId);

    List<Horseman> selectAll();

    int updateByPrimaryKey(Horseman record);

    Horseman selectByName(String horsemanName);
}//selectByName