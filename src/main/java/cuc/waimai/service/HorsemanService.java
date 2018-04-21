package cuc.waimai.service;

import cuc.waimai.Dao.Horseman;

import java.util.List;

public interface HorsemanService {
    int deleteByPrimaryKey(Integer horsemanId);

    int insert(Horseman record);

    Horseman selectByPrimaryKey(Integer horsemanId);

    List<Horseman> selectAll();

    int updateByPrimaryKey(Horseman record);
}
