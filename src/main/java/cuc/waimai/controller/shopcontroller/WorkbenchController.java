package cuc.waimai.controller.shopcontroller;

import cuc.waimai.Dao.Shop;
import cuc.waimai.Vo.WorkbenchVO;
import cuc.waimai.service.OrdersService;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkbenchController {
    @Autowired
    ShopService shopService;
    @Autowired
    OrdersService ordersService;
    ;

    @RequestMapping("/getWorkbenchDetails.do")
    @ResponseBody

    public WorkbenchVO getWorkbenchDetails(@RequestParam("shopId") Integer shopId) {
        WorkbenchVO workbenchVO = new WorkbenchVO();

        workbenchVO.setPending_num(ordersService.selectByStatus("未接单", shopId).size());
        workbenchVO.setCarrying_num(ordersService.selectByStatus("未配送", shopId).size());
        workbenchVO.setFinish_num(ordersService.selectByStatus("已完成", shopId).size());

        workbenchVO.setAll_colledtion(shopService.selectByPrimaryKey(shopId).getCollectionNum());
        workbenchVO.setShop_statue(shopService.selectByPrimaryKey(shopId).getShopStatus());
        return workbenchVO;
    }

    @RequestMapping("/shopStatus.do")
    @ResponseBody

    public int shopStatus(@RequestParam("shopId") Integer shopId) {
        try {
            Shop shop = shopService.selectByPrimaryKey(shopId);
            if (shop.getShopStatus().equals("off")) {
                shop.setShopStatus("on");
            } else {
                shop.setShopStatus("off");
            }
            shopService.updateByPrimaryKey(shop);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}
