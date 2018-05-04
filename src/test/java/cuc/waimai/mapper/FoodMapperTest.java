package cuc.waimai.mapper;

import cuc.waimai.Dao.Category;
import cuc.waimai.Dao.Food;
import cuc.waimai.Dao.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class FoodMapperTest {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void Insert() {
        Food food = new Food();
        food.setFoodName("1");
        food.setCategoryId(1);
        System.out.print("前：" + food.getFoodId());
        foodMapper.insert(food);
        System.out.print("后:" + food.getFoodId());
    }

    @Test
    public void InsertC() {
        Category category = new Category();
        category.setCatName("1");
        System.out.print("前：" + category.getCatId());
        categoryMapper.insert(category);
        System.out.print("后:" + category.getCatId());
    }
}