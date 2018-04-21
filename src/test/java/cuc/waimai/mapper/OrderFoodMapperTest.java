package cuc.waimai.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class OrderFoodMapperTest {
@Autowired
OrderFoodMapper orderFoodMapper;
    @Test
    public void selectByOrderId() {
        System.out.print(orderFoodMapper.selectByOrderId(1));
    }
}