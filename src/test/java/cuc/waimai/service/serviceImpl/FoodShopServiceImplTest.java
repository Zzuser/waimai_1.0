package cuc.waimai.service.serviceImpl;

import cuc.waimai.service.FoodShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class FoodShopServiceImplTest {
@Autowired
    FoodShopService foodShopService;
    @Test
    public void selectByFoodIdAndShopId() {
        System.out.print(foodShopService.selectByFoodIdAndShopId(1, 1));
    }
}