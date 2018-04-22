package cuc.waimai.controller.shopcontroller;

import cuc.waimai.Vo.WorkbenchVO;
import cuc.waimai.service.DailyBillService;
import cuc.waimai.service.ShopService;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkbenchController {
    @Autowired
    DailyBillService dailyBillService;
    @Autowired
    ShopService shopService;

    @RequestMapping("/getWorkbenchDetails.do")
    @ResponseBody

    public WorkbenchVO getWorkbenchDetails(@RequestParam("shopId") Integer shopId){
        WorkbenchVO workbenchVO=new WorkbenchVO();
        workbenchVO.setDailyBill(dailyBillService.selectByShopId(shopId));
        workbenchVO.setAll_colledtion(shopService.selectByPrimaryKey(shopId).getCollectionNum());
        workbenchVO.setShop_statue("off");
        return workbenchVO;
    }
}
