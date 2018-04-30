package cuc.waimai.controller.shopcontroller;

import cuc.waimai.Dao.Shop;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShopHandlerController {
    @Autowired
    ShopService shopService;
    @RequestMapping("/shopSelectAll.do")
    @ResponseBody
    public List<Shop> shopSelectAll(){
        return shopService.selectAll();
    }
}
