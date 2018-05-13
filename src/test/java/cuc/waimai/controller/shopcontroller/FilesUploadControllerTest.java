package cuc.waimai.controller.shopcontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class FilesUploadControllerTest {
@Autowired
FilesUploadController filesUploadController;
//    @Test
//    public void fileUpload() {
//        try {
//            MockMultipartFile mockMultipartFile1 = new MockMultipartFile(
//                    "/home/zz/ideaprojects/waimai/doc/菜单模板.xls",
//                    new FileInputStream(new File("/home/zz/ideaprojects/waimai/doc/菜单模板.xls")));
//            MockMultipartFile mockMultipartFile2 = new MockMultipartFile(
//                    "/home/zz/ideaprojects/waimai/doc/img.zip",
//                    new FileInputStream(new File("/home/zz/ideaprojects/waimai/doc/img.zip")));
//            filesUploadController.fileUpload("125",mockMultipartFile1,mockMultipartFile2);
//        }catch (Exception e){}
//
//    }
//    @Test
//    public void pro(){
//        System.out.println(filesUploadController.batchProgress("125"));
//
//    }
}