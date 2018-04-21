package cuc.waimai.service;

import cuc.waimai.Dao.Orders;

import java.util.List;

public interface OrdersService {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}
