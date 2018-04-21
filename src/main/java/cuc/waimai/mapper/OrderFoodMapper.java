package cuc.waimai.mapper;

import cuc.waimai.Dao.OrderFood;

import java.util.List;

public interface OrderFoodMapper {
    int deleteByPrimaryKey(Integer orderFoodId);

    int insert(OrderFood record);

    OrderFood selectByPrimaryKey(Integer orderFoodId);

    List<OrderFood> selectAll();

    int updateByPrimaryKey(OrderFood record);
    List<OrderFood> selectByOrderId(Integer orderId);
}