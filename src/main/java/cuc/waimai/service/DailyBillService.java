package cuc.waimai.service;

import cuc.waimai.Dao.DailyBill;

import java.util.List;

public interface DailyBillService {
    int deleteByPrimaryKey(Integer billId);

    int insert(DailyBill record);

    DailyBill selectByPrimaryKey(Integer billId);

    List<DailyBill> selectAll();

    int updateByPrimaryKey(DailyBill record);
}
