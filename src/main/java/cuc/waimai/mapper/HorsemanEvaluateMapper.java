package cuc.waimai.mapper;

import cuc.waimai.Dao.HorsemanEvaluate;
import java.util.List;

public interface HorsemanEvaluateMapper {
    int deleteByPrimaryKey(Integer evId);

    int insert(HorsemanEvaluate record);

    HorsemanEvaluate selectByPrimaryKey(Integer evId);

    List<HorsemanEvaluate> selectAll();

    int updateByPrimaryKey(HorsemanEvaluate record);
}