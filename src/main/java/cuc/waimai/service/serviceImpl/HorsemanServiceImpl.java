package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Horseman;
import cuc.waimai.mapper.HorsemanMapper;
import cuc.waimai.service.HorsemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HorsemanServiceImpl implements HorsemanService {
    @Autowired
    HorsemanMapper horsemanMapper;
    @Override
    public int deleteByPrimaryKey(Integer horsemanId) {
        return horsemanMapper.deleteByPrimaryKey(horsemanId);
    }

    @Override
    public int insert(Horseman record) {
        return horsemanMapper.insert(record);
    }

    @Override
    public Horseman selectByPrimaryKey(Integer horsemanId) {
        return horsemanMapper.selectByPrimaryKey(horsemanId);
    }

    @Override
    public List<Horseman> selectAll() {
        return horsemanMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Horseman record) {
        return horsemanMapper.updateByPrimaryKey(record);
    }
}
