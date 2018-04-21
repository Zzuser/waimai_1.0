package cuc.waimai.service;

import cuc.waimai.Dao.OrderFood;

import java.util.List;

public interface OrderFoodService {
    int deleteByPrimaryKey(Integer orderFoodId);

    int insert(OrderFood record);

    OrderFood selectByPrimaryKey(Integer orderFoodId);

    List<OrderFood> selectAll();

    int updateByPrimaryKey(OrderFood record);
}
