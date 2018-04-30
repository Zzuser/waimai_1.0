package cuc.waimai.controller.MsgPushController;


import cuc.waimai.util.JiguangPush;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class HorsemanMsgPushControllerTest {
    @Test
    public void orderJpush() {
        JiguangPush jiguangPush=new JiguangPush();
        jiguangPush.jiguangPush("nihao");
    }
}