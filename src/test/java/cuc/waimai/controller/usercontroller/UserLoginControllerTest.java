package cuc.waimai.controller.usercontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class UserLoginControllerTest {
@Autowired
UserLoginController userLoginController;
    @Test
    public void userLogin() {
        MockHttpSession httpSession=new MockHttpSession();
        System.out.println(userLoginController.userLogin("1","1",httpSession));

    }
}