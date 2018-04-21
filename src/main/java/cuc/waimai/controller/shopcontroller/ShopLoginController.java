package cuc.waimai.controller.shopcontroller;

import cuc.waimai.Dao.Shop;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShopLoginController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/shopLogin.do")
    @ResponseBody
    public int shopLogin(@RequestParam("shopId") String shopId,
                         @RequestParam("shopPsw") String psw,
                         HttpSession httpSession) {

       Shop  shop = shopService.selectByPrimaryKey(Integer.parseInt(shopId));
        System.out.println("ID:"+shopId+"PSW:"+psw);
       System.out.println(shop.toString());
        System.out.println("pd"+shop.getShopPsw().equals(psw));
        if (shop != null) {
            if (shop.getShopPsw().equals(psw) ){
                httpSession.setAttribute("shop",shop);
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }
}


