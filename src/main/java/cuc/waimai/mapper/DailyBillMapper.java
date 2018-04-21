package cuc.waimai.mapper;

import cuc.waimai.Dao.DailyBill;

import java.util.List;

public interface DailyBillMapper {
    int deleteByPrimaryKey(Integer billId);

    int insert(DailyBill record);

    DailyBill selectByPrimaryKey(Integer billId);

    List<DailyBill> selectAll();

    int updateByPrimaryKey(DailyBill record);
}