package cuc.waimai.controller.foodcontroller;

import cuc.waimai.Dao.FoodShop;
import cuc.waimai.Dao.OrderFood;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.service.FoodService;
import cuc.waimai.service.FoodShopService;
import cuc.waimai.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {
@Autowired
    FoodShopService foodShopService;
@Autowired
    FoodService foodService;
@Autowired
OrderFoodService orderFoodService;
    @RequestMapping("/foodSelectAllByShopId.do")
    @ResponseBody
    public List<FoodVo> foodSelectAllByShopId(
            @RequestParam("ShopId") Integer shopId) {
        List<FoodVo> foodVoList = new ArrayList<>();
        List<FoodShop> foodShopList= foodShopService.selectByShopId(shopId);
        for (FoodShop foodShop : foodShopList) {
            foodVoList.add(foodVoSelectByFoodIdAndShopId(foodShop.getFoodId(),shopId));
        }
        return foodVoList;
    }

    @RequestMapping("/foodVoSelectByFoodIdAndShopId.do")
    @ResponseBody
    public FoodVo foodVoSelectByFoodIdAndShopId(@RequestParam("foodId") Integer foodId,@RequestParam("shopId") Integer shopId){
        FoodVo foodVo = new FoodVo();
        foodVo.setFood_id(foodId);
        foodVo.setFood_name(foodService.selectByPrimaryKey(foodId).getFoodName());
        foodVo.setFoodShop(foodShopService.selectByFoodIdAndShopId(foodId,shopId));
        return foodVo;
    }
}
