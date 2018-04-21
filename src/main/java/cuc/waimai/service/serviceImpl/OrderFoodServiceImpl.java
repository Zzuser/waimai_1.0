package cuc.waimai.service.serviceImpl;

import cuc.waimai.Dao.OrderFood;
import cuc.waimai.mapper.OrderFoodMapper;
import cuc.waimai.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {
@Autowired
    OrderFoodMapper orderFoodMapper;
    @Override
    public int deleteByPrimaryKey(Integer orderFoodId) {
        return orderFoodMapper.deleteByPrimaryKey(orderFoodId);
    }

    @Override
    public int insert(OrderFood record) {
        return orderFoodMapper.insert(record);
    }

    @Override
    public OrderFood selectByPrimaryKey(Integer orderFoodId) {
        return orderFoodMapper.selectByPrimaryKey(orderFoodId);
    }

    @Override
    public List<OrderFood> selectAll() {
        return orderFoodMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(OrderFood record) {
        return orderFoodMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderFood> selectByOrderId(Integer orderId) {
        return orderFoodMapper.selectByOrderId(orderId);
    }
}
