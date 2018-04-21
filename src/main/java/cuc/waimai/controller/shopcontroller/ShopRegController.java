package cuc.waimai.controller.shopcontroller;

import cuc.waimai.Dao.Shop;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ShopRegController {
    @Autowired
    ShopService shopService;
    @RequestMapping("shopReg.do")
    @ResponseBody
    public int shopReg(@RequestParam("shopName") String shopName,
                       @RequestParam("shopPsw") String shopPsw,
                       @RequestParam("shopTel") Integer shopTel,
                       @RequestParam("shopAdd") String shopAdd){
        Shop shop=new Shop();
        shop.setShopName(shopName);
        shop.setShopPsw(shopPsw);
        shop.setShopTel(shopTel);
        shop.setShopAdd(shopAdd);
        shop.setShopCreatetime(new Date());

return 0;
    }
}
