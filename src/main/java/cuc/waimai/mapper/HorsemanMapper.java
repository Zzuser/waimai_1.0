package cuc.waimai.mapper;

import cuc.waimai.Dao.Horseman;
import java.util.List;

public interface HorsemanMapper {
    int deleteByPrimaryKey(Integer horsemanId);

    int insert(Horseman record);

    Horseman selectByPrimaryKey(Integer horsemanId);

    List<Horseman> selectAll();

    int updateByPrimaryKey(Horseman record);
}