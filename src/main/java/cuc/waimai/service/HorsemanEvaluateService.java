package cuc.waimai.service;

import cuc.waimai.Dao.HorsemanEvaluate;

import java.util.List;

public interface HorsemanEvaluateService {
    int deleteByPrimaryKey(Integer evId);

    int insert(HorsemanEvaluate record);

    HorsemanEvaluate selectByPrimaryKey(Integer evId);

    List<HorsemanEvaluate> selectAll();

    int updateByPrimaryKey(HorsemanEvaluate record);
}
