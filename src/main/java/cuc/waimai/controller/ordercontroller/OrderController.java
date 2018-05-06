package cuc.waimai.controller.ordercontroller;

import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Dao.Orders;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.Vo.OrdersVo;
import cuc.waimai.controller.foodcontroller.FoodController;
import cuc.waimai.service.*;
import cuc.waimai.util.JiguangPush;
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
    @Autowired
    ShopService shopService;

    @RequestMapping("/ordersSelectALLByShopId.do")
    @ResponseBody
    public List<OrdersVo> ordersSelectALLByShopId(@RequestParam("shopId") String shopIdst, HttpSession session) {
        int shopId = Integer.parseInt(shopIdst);
        List<OrdersVo> ordersVoList = new ArrayList<>();
        List<Orders> ordersList = ordersService.selectByShopId(shopId);
        System.out.println("ordersList.size" + ordersList.size());
        for (Orders orders : ordersList) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setOrder_id(orders.getOrderId());
            ordersVo.setOrder_status(ordersService.selectByPrimaryKey(orders.getOrderId()).getStatus());
            ordersVo.setShop_id(shopId);
            ordersVo.setOrder_number(orders.getOrderNumber());
            ordersVo.setOrder_time(orders.getOrderTime());
            ordersVo.setArrive_time(orders.getArriveTime());
//            try {
            if (orders.getHorsemanId() == 0) {

            } else {
                ordersVo.setHorseman_id(orders.getHorsemanId());
                ordersVo.setHorseman_tel(horsemanService.selectByPrimaryKey(orders.getHorsemanId()).getHorsemanTel());
            }
//                 } catch (Exception e) {
//                e.printStackTrace();
//                continue;
//            } finally {
            ordersVo.setUser_name(userService.selectByPrimaryKey(orders.getUserId()).getUserName());
            ordersVo.setUser_tel(userService.selectByPrimaryKey(orders.getUserId()).getUserTel());
            ordersVo.setUser_add(userService.selectByPrimaryKey(orders.getUserId()).getReceiveAdd());
            List<FoodVo> foodVoList = new ArrayList<>();
            List<OrderFood> orderFoodList = orderFoodService.selectByOrderId(orders.getOrderId());
            Double foodMoney = 0.0;
            for (OrderFood orderFood : orderFoodList) {
                FoodVo foodVo = foodController.foodVoSelectByFoodIdAndShopId(orderFood.getFoodId(), shopId);

                foodVo.setFood_count(orderFoodService.selectByFoodIdAndOrderId(
                        orders.getOrderId(), orderFood.getFoodId())
                        .getFoodCount());
                foodMoney += (foodVo.getFoodShop().getFoodPrice() * foodVo.getFood_count());
                foodVoList.add(foodVo);
            }
            foodMoney += Double.parseDouble(shopService.selectByPrimaryKey(shopId).getDeliveryFee());
            ordersVo.setOrder_money(foodMoney);
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
            ordersVo.setOrder_status(ordersService.selectByPrimaryKey(orders.getOrderId()).getStatus());
            ordersVo.setOrder_number(orders.getOrderNumber());
            ordersVo.setOrder_time(orders.getOrderTime());
            ordersVo.setArrive_time(orders.getArriveTime());
            ordersVo.setHorseman_id(orders.getHorsemanId());
            ordersVo.setHorseman_tel(horsemanService.selectByPrimaryKey(orders.getHorsemanId()).getHorsemanTel());
            ordersVo.setUser_name(userService.selectByPrimaryKey(userId).getUserName());
            ordersVo.setUser_tel(userService.selectByPrimaryKey(userId).getUserTel());
            ordersVo.setUser_add(userService.selectByPrimaryKey(userId).getReceiveAdd());
            List<FoodVo> foodVoList = new ArrayList<>();
            List<OrderFood> orderFoodList = orderFoodService.selectByOrderId(orders.getOrderId());

            Double foodMoney = 0.0;
            for (OrderFood orderFood : orderFoodList) {
                FoodVo foodVo = foodController.foodVoSelectByFoodIdAndShopId(orderFood.getFoodId(), ordersService.selectByPrimaryKey(orders.getOrderId()).getShopId());

                foodVo.setFood_count(orderFoodService.selectByFoodIdAndOrderId(
                        orders.getOrderId(), orderFood.getFoodId())
                        .getFoodCount());
                foodMoney += (foodVo.getFoodShop().getFoodPrice() * foodVo.getFood_count());
                foodVoList.add(foodVo);
            }
            foodMoney += Double.parseDouble(shopService.selectByPrimaryKey(ordersService.selectByPrimaryKey(orders.getOrderId()).getShopId()).getDeliveryFee());
            ordersVo.setOrder_money(foodMoney);
            ordersVo.setFood_list(foodVoList);
            ordersVoList.add(ordersVo);
        }

        return ordersVoList;

    }

    @RequestMapping("/receiveOrder")
    @ResponseBody
    public Integer receiveOrder(@RequestParam("orderId") Integer orderId) {
        Orders orders = ordersService.selectByPrimaryKey(orderId);
        orders.setStatus("未配送");
        return ordersService.updateByPrimaryKey(orders);

    }

    @RequestMapping("/carryOrder")
    @ResponseBody
    public Integer carryOrder(@RequestParam("orderId") Integer orderId) {
        try {
            JiguangPush jiguangPush = new JiguangPush();
            jiguangPush.jiguangPush(orderId.toString());
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return 400;
        }

    }

    @RequestMapping("/selectOrderByOrderId.do")
    @ResponseBody
    public OrdersVo selectOrderByOrderId(@RequestParam("orderId") Integer orderId) {
        Orders orders = ordersService.selectByPrimaryKey(orderId);
        OrdersVo ordersVo = new OrdersVo();
        ordersVo.setOrder_id(orderId);
        ordersVo.setOrder_status(orders.getStatus());
        ordersVo.setShop_id(orders.getShopId());
        ordersVo.setOrder_number(orders.getOrderNumber());
        ordersVo.setOrder_time(orders.getOrderTime());
        ordersVo.setArrive_time(orders.getArriveTime());


        ordersVo.setUser_name(userService.selectByPrimaryKey(orders.getUserId()).getUserName());
        ordersVo.setUser_tel(userService.selectByPrimaryKey(orders.getUserId()).getUserTel());
        ordersVo.setUser_add(userService.selectByPrimaryKey(orders.getUserId()).getReceiveAdd());
        List<FoodVo> foodVoList = new ArrayList<>();
        List<OrderFood> orderFoodList = orderFoodService.selectByOrderId(orders.getOrderId());
        Double foodMoney = 0.0;
        for (OrderFood orderFood : orderFoodList) {
            FoodVo foodVo = foodController.foodVoSelectByFoodIdAndShopId(orderFood.getFoodId(), orders.getShopId());

            foodVo.setFood_count(orderFoodService.selectByFoodIdAndOrderId(
                    orders.getOrderId(), orderFood.getFoodId())
                    .getFoodCount());
            foodMoney += (foodVo.getFoodShop().getFoodPrice() * foodVo.getFood_count());
            foodVoList.add(foodVo);
        }
        foodMoney += Double.parseDouble(shopService.selectByPrimaryKey(orders.getShopId()).getDeliveryFee());
        ordersVo.setOrder_money(foodMoney);
        ordersVo.setFood_list(foodVoList);
        return ordersVo;

    }

    @RequestMapping("/orderCFM.do")
    @ResponseBody
    public int orderCFM(@RequestParam("orderId") Integer orderId, @RequestParam("horsemanId") Integer horsemanId) {
        System.out.println("orderCFM" + "orderId:" + orderId + "\n" + "horsemanId:" + horsemanId);
        Orders orders = ordersService.selectByPrimaryKey(orderId);
        System.out.println("orderCFM" + "orderId:" + orders.toString());
        System.out.println("orderCFM" + "getHorsemanId:" + orders.getHorsemanId());
        if (orders.getHorsemanId() == 0) {
            orders.setHorsemanId(horsemanId);
            ordersService.updateByPrimaryKey(orders);
            return 200;
        } else {
            return 400;
        }


    }

    @RequestMapping("/orderFNS.do")
    @ResponseBody
    public int orderFNS(@RequestParam("orderId") Integer orderId, @RequestParam("horsemanId") Integer horsemanId) {
        System.out.println("orderId:" + orderId + "\n" + "horsemanId:" + horsemanId);
        Orders orders = ordersService.selectByPrimaryKey(orderId);
        if (orders.getHorsemanId().equals(horsemanId)) {
            orders.setStatus("已完成");
            ordersService.updateByPrimaryKey(orders);
            return 200;
        } else {
            return 400;
        }

    }

    @RequestMapping("/orderPlaceTest.do")
    @ResponseBody
    public int orderPlace(@RequestParam("orderJson") String orderPlace) {
        System.out.println(orderPlace);
        return 1;
    }


}

