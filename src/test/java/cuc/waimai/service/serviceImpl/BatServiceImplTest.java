package cuc.waimai.service.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class BatServiceImplTest {
@Autowired
BatServiceImpl batService;
//    @Test
//    public void bat() {
//        batService.bat("/home/zz/ideaprojects/waimai/src/main/webapp/resources/batchdata/s1Thu May 03 11:11:21 CST 2018.csv",1);
//    }
}