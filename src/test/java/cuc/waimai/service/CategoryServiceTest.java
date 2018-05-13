package cuc.waimai.service;

import cuc.waimai.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class CategoryServiceTest {
@Autowired
CategoryService categoryService;
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Category category=new Category();
        category.setCatId(1);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
        categoryService.selectAll();
    }

    @Test
    public void updateByPrimaryKey() {
    }
}