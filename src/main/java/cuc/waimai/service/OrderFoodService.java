package cuc.waimai.service;

import cuc.waimai.Dao.OrderFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFoodService {
    int deleteByPrimaryKey(Integer orderFoodId);

    int insert(OrderFood record);

    OrderFood selectByPrimaryKey(Integer orderFoodId);

    List<OrderFood> selectAll();

    int updateByPrimaryKey(OrderFood record);

    List<OrderFood> selectByOrderId(Integer orderId);

    OrderFood  selectByFoodIdAndOrderId(@Param("foodId") Integer orderId, @Param("orderId") Integer foodId);
}
