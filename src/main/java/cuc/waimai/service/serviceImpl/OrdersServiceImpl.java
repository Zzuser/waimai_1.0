package cuc.waimai.service.serviceImpl;

import cuc.waimai.entity.Orders;
import cuc.waimai.mapper.OrdersMapper;
import cuc.waimai.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return ordersMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public Orders selectByPrimaryKey(Integer orderId) {
        return ordersMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Orders> selectAll() {
        return ordersMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Orders> selectByShopId(Integer shopId) {
        return ordersMapper.selectByShopId(shopId);
    }

    @Override
    public List<Orders> selectByUserId(Integer userId) {
        return ordersMapper.selectByUserId(userId);
    }

    @Override
    public List<Orders> selectByStatus(String status,Integer shopId) {
        return ordersMapper.selectByStatus(status,shopId);
    }
}
