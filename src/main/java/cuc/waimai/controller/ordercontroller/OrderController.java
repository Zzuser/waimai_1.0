package cuc.waimai.controller.ordercontroller;

import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Dao.Orders;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.Vo.OrdersVo;
import cuc.waimai.controller.foodcontroller.FoodController;
import cuc.waimai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    HorsemanService horsemanService;
    @Autowired
    UserService userService;
    @Autowired
    FoodShopService foodShopService;
    @Autowired
    OrderFoodService orderFoodService;
    @Autowired
    FoodService foodService;
    @Autowired
    FoodController foodController;

    @RequestMapping("/ordersSelectALLByShopId.do")
    @ResponseBody
    public List<OrdersVo> ordersSelectALLByShopId(@RequestParam("shopId") String shopIdst, HttpSession session) {
        int shopId = Integer.parseInt(shopIdst);
        List<OrdersVo> ordersVoList = new ArrayList<>();
        List<Orders> ordersList = ordersService.selectByShopId(shopId);
        for (Orders orders : ordersList) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setOrder_status("finish");
            ordersVo.setShop_id(shopId);
            ordersVo.setOrder_number(orders.getOrderNumber().toString());
            ordersVo.setOrder_time(orders.getOrderTime());
            ordersVo.setArrive_time(orders.getArriveTime());
            ordersVo.setHorseman_id(orders.getHorsemanId());
            ordersVo.setHorseman_tel(horsemanService.selectByPrimaryKey(orders.getHorsemanId()).getHorsemanTel());
            ordersVo.setUser_name(userService.selectByPrimaryKey(orders.getUserId()).getUserName());
            ordersVo.setUser_tel(userService.selectByPrimaryKey(orders.getUserId()).getUserTel());
            ordersVo.setUser_add(userService.selectByPrimaryKey(orders.getUserId()).getReceiveAdd());
            List<FoodVo> foodVoList = new ArrayList<>();
            List<OrderFood> orderFoodList = orderFoodService.selectByOrderId(orders.getOrderId());
            for (OrderFood orderFood : orderFoodList) {
                FoodVo foodVo = foodController.foodVoSelectByFoodIdAndShopId(orderFood.getFoodId(), shopId);
                foodVo.setFood_count(orderFoodService.selectByFoodIdAndOrderId(
                        orders.getOrderId(), orderFood.getFoodId())
                        .getFoodCount());
                foodVoList.add(foodVo);
            }
            ordersVo.setFood_list(foodVoList);
            ordersVoList.add(ordersVo);
        }
        session.setAttribute("ordersVoList", ordersVoList);
        return ordersVoList;

    }

    @RequestMapping("/ordersSelectALLByUserId.do")
    @ResponseBody
    public List<OrdersVo> ordersSelectALLByUserId(@RequestParam("userId") Integer userId) {
        List<OrdersVo> ordersVoList = new ArrayList<>();
        List<Orders> ordersList = ordersService.selectByUserId(userId);
        for (Orders orders : ordersList) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setShop_id(ordersService.selectByPrimaryKey(orders.getOrderId()).getShopId());
            ordersVo.setOrder_number(orders.getOrderNumber().toString());
            ordersVo.setOrder_time(orders.getOrderTime());
            ordersVo.setArrive_time(orders.getArriveTime());
            ordersVo.setHorseman_id(orders.getHorsemanId());
            ordersVo.setHorseman_tel(horsemanService.selectByPrimaryKey(orders.getHorsemanId()).getHorsemanTel());
            ordersVo.setUser_name(userService.selectByPrimaryKey(userId).getUserName());
            ordersVo.setUser_tel(userService.selectByPrimaryKey(userId).getUserTel());
            ordersVo.setUser_add(userService.selectByPrimaryKey(userId).getReceiveAdd());
            List<FoodVo> foodVoList = new ArrayList<>();
            List<OrderFood> orderFoodList = orderFoodService.selectByOrderId(orders.getOrderId());
            for (OrderFood orderFood : orderFoodList) {

                FoodVo foodVo = foodController.foodVoSelectByFoodIdAndShopId(orderFood.getFoodId(),
                        ordersService.selectByPrimaryKey(orders.getOrderId()).getShopId());
                foodVo.setFood_count(orderFoodService.selectByFoodIdAndOrderId(
                        orders.getOrderId(), orderFood.getFoodId())
                        .getFoodCount());
                foodVoList.add(foodVo);
            }
            ordersVo.setFood_list(foodVoList);
            ordersVoList.add(ordersVo);
        }

        return ordersVoList;

    }


}
