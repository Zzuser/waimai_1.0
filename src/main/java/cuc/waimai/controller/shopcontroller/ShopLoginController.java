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
    public int shopLogin(@RequestParam("shopIdOrTel") String shopIdOrTel,
                         @RequestParam("shopPsw") String psw
            , HttpSession httpSession
    ) {
        Shop shop = new Shop();
        try {

            shop = shopService.selectByPrimaryKey(Integer.parseInt(shopIdOrTel));
            if (shop == null) {
                shop = shopService.selectByShopTel(shopIdOrTel);
            }

            System.out.println("ID:" + shopIdOrTel + "PSW:" + psw);
            System.out.println(shop.toString());
            System.out.println("pd" + shop.getShopPsw().equals(psw));
        } catch (Exception e) {
e.printStackTrace();
        } finally {
            if (shop != null) {
                if (shop.getShopPsw().equals(psw)) {
                    httpSession.setAttribute("shop", shop);
                    httpSession.setAttribute("shop_id",shop.getShopId());
                    httpSession.setAttribute("flag", "on");
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 2;
            }
        }


    }

    @RequestMapping("/shopLogOut.do")
    @ResponseBody
    public void shopLogOut() {
    }
}


