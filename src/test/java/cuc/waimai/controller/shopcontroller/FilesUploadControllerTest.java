package cuc.waimai.controller.shopcontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class FilesUploadControllerTest {
@Autowired
FilesUploadController filesUploadController;
    @Test
    public void fileUpload() {
        try {
            filesUploadController.fileUpload("1");
        }catch (Exception e){}

    }
}