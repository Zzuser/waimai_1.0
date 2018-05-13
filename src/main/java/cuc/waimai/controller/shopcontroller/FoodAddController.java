package cuc.waimai.controller.shopcontroller;

import cuc.waimai.entity.Food;
import cuc.waimai.Vo.FoodVo;
import cuc.waimai.service.CategoryService;
import cuc.waimai.service.FoodService;
import cuc.waimai.service.FoodShopService;
import cuc.waimai.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodAddController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    FoodService foodService;
    @Autowired
    FoodShopService foodShopService;
    @Autowired
    ShopCategoryService shopCategoryService;

    @RequestMapping("/foodOfOneShopSelectAllByCategoryId.do")
    @ResponseBody
    public List<FoodVo> foodSelectAllByCategoryId(
            @RequestParam("shopId") Integer shopId,
            @RequestParam("categoryId") Integer categoryId) {
        List<FoodVo> foodVoList = new ArrayList<>();
        List<Food> foodList = foodService.selectByCategoryId(categoryId);
        for (Food food : foodList) {
            FoodVo foodVo = new FoodVo();
            foodVo.setFood_id(food.getFoodId());
            foodVo.setCategory(categoryService.selectByPrimaryKey(food.getCategoryId()).getCatName());
            foodVo.setFood_name(food.getFoodName());
        //    foodVo.setFoodShop(foodShopService.selectByFoodIdAndShopId(food.getFoodId(),
          //          shopCategoryService.selectByCategoryId(categoryId));
        }
        return foodVoList;
    }
}
