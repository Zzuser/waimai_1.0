package cuc.waimai.controller.usercontroller;

import com.google.gson.Gson;
import com.sun.nio.sctp.ShutdownNotification;
import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Dao.Orders;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.Vo.OrdersVo;
import cuc.waimai.controller.MsgPushController.ShopMsgPushController;
import cuc.waimai.po.Message;
import cuc.waimai.service.*;
import cuc.waimai.websocket.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserHandlerController {
    @Autowired
    ShopMsgPushController shopMsgPushController;
    @Autowired
    OrderFoodService orderFoodService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService userService;
    @Autowired
    FoodService foodService;
    @Autowired
    FoodCategoryService foodCategoryService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    FoodShopService foodShopService;

    @RequestMapping("/orderPlace.do")
    @ResponseBody
    public Integer UserPlaceOrder(@RequestParam("orderJson") String orderJson) {
        try {
            System.out.println(orderJson);
            Message message = parseJson(orderJson);
            Orders orders = new Orders();
            orders.setShopId(Integer.parseInt(message.getShopId()));
            orders.setUserId(1);
            ordersService.insert(orders);
            OrderFood orderFood = new OrderFood();
            orderFood.setFoodId(Integer.parseInt(message.getFoodId()));
            orderFood.setFoodCount(Integer.parseInt(message.getFoodNum()));
            orderFood.setOrderId(orders.getOrderId());
            orderFoodService.insert(orderFood);
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setUser_name(userService.selectByPrimaryKey(Integer.parseInt(message.getUserId())).getUserName());
            ordersVo.setOrder_status("未接单");
            ordersVo.setOrder_id(orders.getOrderId());
            ordersVo.setOrder_time(new Date());
            ordersVo.setShop_id(orders.getShopId());
            FoodVo foodVo = new FoodVo();
            Food food = foodService.selectByPrimaryKey(orderFood.getFoodId());
            foodVo.setFood_id(food.getFoodId());
            foodVo.setFood_name(food.getFoodName());
            foodVo.setCategory(categoryService.selectByPrimaryKey(food.getCategoryId()).getCatName());
            foodVo.setFoodShop(foodShopService.selectByFoodIdAndShopId(food.getFoodId(), Integer.parseInt(message.getShopId())));
            foodVo.setFood_count(Integer.parseInt(message.getFoodNum()));
            List<FoodVo> foodVoList = new ArrayList<>();
            foodVoList.add(foodVo);
            ordersVo.setFood_list(foodVoList);
            Gson gson = new Gson();
            shopMsgPushController.task(message.getShopId(), gson.toJson(ordersVo));
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    private Message parseJson(String msg) {
        Gson gson = new Gson();
        Message message = gson.fromJson(msg, Message.class);
        return message;
    }
}
