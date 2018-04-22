package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.DailyBill;
import cuc.waimai.mapper.DailyBillMapper;
import cuc.waimai.service.DailyBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DailyBillServiceImpl implements DailyBillService {
    @Autowired
    DailyBillMapper billMapper;
    @Override
    public int deleteByPrimaryKey(Integer billId) {
        return billMapper.deleteByPrimaryKey(billId);
    }

    @Override
    public int insert(DailyBill record) {
        return billMapper.insert(record);
    }

    @Override
    public DailyBill selectByPrimaryKey(Integer billId) {
        return billMapper.selectByPrimaryKey(billId);
    }

    @Override
    public List<DailyBill> selectAll() {
        return billMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(DailyBill record) {
        return billMapper.updateByPrimaryKey(record);
    }

    @Override
    public DailyBill selectByShopId(Integer shopId) {
        return billMapper.selectByShopId(shopId);
    }
}
