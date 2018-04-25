package cuc.waimai.controller.shopcontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class ShopRegControllerTest {
@Autowired
    ShopRegController shopRegController;
@Autowired
ShopLoginController shopLoginController;
@Autowired
    MessageTestController messageTestController;
    @Test
    public void shopReg() {
        MockHttpSession session=new MockHttpSession();
        shopLoginController.shopLogin("123","12",session);
    }
    @Test
    public void messageTestController() {
        messageTestController.sendMsg("1","666");
    }
}