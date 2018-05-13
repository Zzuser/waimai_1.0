package cuc.waimai.service;

import cuc.waimai.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersService {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);

    List<Orders> selectByShopId(Integer shopId);

    List<Orders> selectByUserId(Integer userId);

    List<Orders> selectByStatus(@Param("status") String status, @Param("shopId") Integer shopId);
}
