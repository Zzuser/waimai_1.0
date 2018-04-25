package cuc.waimai.mapper;

import cuc.waimai.Dao.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class OrdersMapperTest {
@Autowired
OrdersMapper ordersMapper;

    @Test
    public void selectByShopId() {
        System.out.print(ordersMapper.selectByShopId(1));
    }

    @Test
    public void Insert() {
        Orders orders=new Orders();
        orders.setUserId(1);
        orders.setHorsemanId(1);
        orders.setShopId(1);
        System.out.print("前："+orders.getOrderId());
        ordersMapper.insert(orders);
        System.out.print("后:"+orders.getOrderId());
    }
}