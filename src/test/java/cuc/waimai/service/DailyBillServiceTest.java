package cuc.waimai.service;

import cuc.waimai.Dao.DailyBill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:config/spring/applicationContext.xml"})
public class DailyBillServiceTest {
@Autowired
DailyBillService billService;
    @Test
    public void deleteByPrimaryKey() {
billService.deleteByPrimaryKey(1);
    }

    @Test
    public void insert() {
        DailyBill bill=new DailyBill();
        bill.setBillId(1);
        bill.setBillTime(new Date());
        bill.setNewCollectionNum(100);
        bill.setOrderNum(100);
        bill.setShopId(1);
        bill.setTotalmoney(12324.0);

        billService.insert(bill);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println(billService.selectByPrimaryKey(2));
    }

    @Test
    public void selectAll() {
        System.out.println(billService.selectAll());
    }

    @Test
    public void updateByPrimaryKey() {
        DailyBill bill=new DailyBill();
        bill.setBillId(1);
        bill.setBillTime(new Date());
        bill.setNewCollectionNum(100);
        bill.setOrderNum(100);
        bill.setShopId(1);
        bill.setTotalmoney(12314.0);

        billService.updateByPrimaryKey(bill);
    }
}