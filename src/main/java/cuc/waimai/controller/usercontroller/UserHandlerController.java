package cuc.waimai.controller.usercontroller;

import com.google.gson.Gson;
import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Dao.Orders;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.Vo.OrdersVo;
import cuc.waimai.controller.MsgPushController.ShopMsgPushController;
import cuc.waimai.po.FoodInOrder;
import cuc.waimai.po.OrderMessage;
import cuc.waimai.service.*;
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
        Date date=new Date();
        try {
            System.out.println(orderJson);
            OrderMessage message = parseJson(orderJson);
            Orders orders = new Orders();
            orders.setShopId(Integer.parseInt(message.getShopId()));
            orders.setUserId(1);
            orders.setStatus("未接单");
            orders.setOrderTime(date);
            orders.setHorsemanId(0);
            ordersService.insert(orders);
            List<FoodVo> foodVoList = new ArrayList<>();
            for (FoodInOrder foodInOrder : message.getFoodInOrderList()) {
                OrderFood orderFood = new OrderFood();
                orderFood.setFoodId(Integer.parseInt(foodInOrder.getFoodId()));
                orderFood.setFoodCount(Integer.parseInt(foodInOrder.getFoodNum()));
                orderFood.setOrderId(orders.getOrderId());
                orderFoodService.insert(orderFood);
                FoodVo foodVo = new FoodVo();
                Food food = foodService.selectByPrimaryKey(Integer.parseInt(foodInOrder.getFoodId()));
                foodVo.setFood_id(Integer.parseInt(foodInOrder.getFoodId()));
                foodVo.setFood_count(Integer.parseInt(foodInOrder.getFoodNum()));
                foodVo.setFoodShop(
                        foodShopService.selectByFoodIdAndShopId(
                                Integer.parseInt(foodInOrder.getFoodId()), orders.getShopId()));
                foodVo.setFood_name(food.getFoodName());
                foodVo.setCategory(categoryService.selectByPrimaryKey(food.getCategoryId()).getCatName());
                foodVoList.add(foodVo);
            }

            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setUser_name(userService.selectByPrimaryKey(Integer.parseInt(message.getUserId())).getUserName());
            ordersVo.setOrder_status("未接单");
            ordersVo.setOrder_id(orders.getOrderId());
            ordersVo.setOrder_time(date);
            ordersVo.setShop_id(orders.getShopId());

            ordersVo.setFood_list(foodVoList);
            Gson gson = new Gson();
            System.out.println(gson.toJson(ordersVo));
            shopMsgPushController.task(message.getShopId(), gson.toJson(ordersVo));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    private OrderMessage parseJson(String msg) {
        Gson gson = new Gson();
        OrderMessage message = gson.fromJson(msg, OrderMessage.class);
        return message;
    }
}
