package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.HorsemanEvaluate;
import cuc.waimai.mapper.HorsemanEvaluateMapper;
import cuc.waimai.service.HorsemanEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HorsemanEvaluateServiceImpl implements HorsemanEvaluateService {
    @Autowired
    HorsemanEvaluateMapper horsemanEvaluateMapper;
    @Override
    public int deleteByPrimaryKey(Integer evId) {
        return horsemanEvaluateMapper.deleteByPrimaryKey(evId);
    }

    @Override
    public int insert(HorsemanEvaluate record) {
        return horsemanEvaluateMapper.insert(record);
    }

    @Override
    public HorsemanEvaluate selectByPrimaryKey(Integer evId) {
        return horsemanEvaluateMapper.selectByPrimaryKey(evId);
    }

    @Override
    public List<HorsemanEvaluate> selectAll() {
        return horsemanEvaluateMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(HorsemanEvaluate record) {
        return horsemanEvaluateMapper.updateByPrimaryKey(record);
    }
}
