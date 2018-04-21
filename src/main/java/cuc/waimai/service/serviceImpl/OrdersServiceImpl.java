package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.Orders;
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
}
