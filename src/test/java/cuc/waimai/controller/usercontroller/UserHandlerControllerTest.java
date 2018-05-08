package cuc.waimai.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class UserHandlerControllerTest {
@Autowired
UserHandlerController userHandlerController;
    @Test
    public void rewriteAdd() {
        userHandlerController.rewriteAdd("1","qwewrwerret");
    }

    @Test
    public void collectionAdd() {
        userHandlerController.collectionAdd("1","125");
    }

    @Test
    public void selectMyShopByUserId() {
        userHandlerController.selectMyShopByUserId("1");
    }
}