package cuc.waimai.mapper;

import cuc.waimai.Dao.Orders;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}