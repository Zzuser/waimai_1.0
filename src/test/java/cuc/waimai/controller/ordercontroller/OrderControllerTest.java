package cuc.waimai.controller.ordercontroller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class OrderControllerTest {
@Autowired
OrderController orderController;
    @Test
    public void ordersSelectALLByShopId() {
        MockHttpSession session=new MockHttpSession();
        Gson gson=new Gson();
        System.out.println(gson.toJson( orderController.ordersSelectALLByShopId("1",session)));

    }

    @Test
    public void ordersSelectALLByUserId() {
        Gson gson=new Gson();
        System.out.println(gson.toJson( orderController.selectOrderByOrderId(24)));

    }
    @Test
    public void carryOrder() {
        Gson gson=new Gson();
        System.out.println(gson.toJson( orderController.carryOrder(59)));

    }
    @Test
    public void jiedan(){
        System.out.println(orderController.orderCFM(1,1));

    }
}