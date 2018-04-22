package cuc.waimai.controller.ordercontroller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class OrderControllerTest {
@Autowired
OrderController orderController;
//    @Test
//    public void ordersSelectALLByShopId() {
//        Gson gson=new Gson();
//        System.out.println(gson.toJson( orderController.ordersSelectALLByShopId(1)));
//
//    }

    @Test
    public void ordersSelectALLByUserId() {
        Gson gson=new Gson();
        System.out.println(gson.toJson( orderController.ordersSelectALLByUserId(1)));

    }
}