package cuc.waimai.mapper;

import cuc.waimai.Dao.OrderFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFoodMapper {
    int deleteByPrimaryKey(Integer orderFoodId);

    int insert(OrderFood record);

    OrderFood selectByPrimaryKey(Integer orderFoodId);

    List<OrderFood> selectAll();

    int updateByPrimaryKey(OrderFood record);

    List<OrderFood> selectByOrderId(Integer orderId);

    List<OrderFood> selectByFoodId(Integer foodId);

   OrderFood  selectByFoodIdAndOrderId(@Param("foodId") Integer orderId, @Param("orderId") Integer foodId);

}