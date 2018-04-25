package cuc.waimai.controller.usercontroller;

import com.google.gson.Gson;
import com.sun.nio.sctp.ShutdownNotification;
import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Dao.Orders;
import cuc.waimai.Vo.OrdersVo;
import cuc.waimai.controller.MsgPushController.ShopMsgPushController;
import cuc.waimai.po.Message;
import cuc.waimai.service.OrderFoodService;
import cuc.waimai.service.OrdersService;
import cuc.waimai.websocket.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHandlerController {
    @Autowired
    ShopMsgPushController shopMsgPushController;
    @Autowired
    OrderFoodService orderFoodService;
    @Autowired
    OrdersService ordersService;

    @RequestMapping("/orderPlace.do")
    @ResponseBody
    public Integer UserPlaceOrder(@RequestParam("orderJson") String orderJson) {
        System.out.println(orderJson);
        Message message = parseJson(orderJson);
        Orders orders = new Orders();
        orders.setShopId(Integer.parseInt(message.getShopId()));
        orders.setUserId(1);
        orders.setHorsemanId(1);
        orders.setOrderId(12);
        ordersService.insert(orders);
        OrderFood orderFood = new OrderFood();
        orderFood.setFoodId(Integer.parseInt(message.getFoodId()));
        orderFood.setFoodCount(Integer.parseInt(message.getFoodNum()));
        orderFood.setOrderId(orders.getOrderId());
        orderFoodService.insert(orderFood);
        Gson gson = new Gson();
        shopMsgPushController.task(message.getShopId(), gson.toJson(orders));


        return 1;
    }

    private Message parseJson(String msg) {
        Gson gson = new Gson();
        Message message = gson.fromJson(msg, Message.class);
        return message;
    }
}
