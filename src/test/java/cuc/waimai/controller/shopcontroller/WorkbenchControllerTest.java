package cuc.waimai.controller.shopcontroller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class WorkbenchControllerTest {
    @Autowired
    WorkbenchController workbenchController;

    @Test
    public void getWorkbenchDetails() {
        Gson gson=new Gson();
        System.out.println(gson.toJson(workbenchController.getWorkbenchDetails(123)));

    }

    @Test
    public void shopStatus() {
        workbenchController.shopStatus(1);
    }
    @Test
    public void getWorkbenchDetailstsd() {
        workbenchController.getWorkbenchDetails(123);
    }
}