package cuc.waimai.controller.shopcontroller;

import cuc.waimai.entity.Shop;
import cuc.waimai.po.ServerPath;
import cuc.waimai.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class ShopRegController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/shopReg.do")
    @ResponseBody
    public int shopReg(@RequestParam("shopName") String shopName,
                       @RequestParam("shopPsw") String shopPsw,
                       @RequestParam("shopTel") String shopTel,
                       @RequestParam("shopAdd") String shopAdd) {
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setShopPsw(shopPsw);
        shop.setShopTel(shopTel);
        shop.setShopAdd(shopAdd);
        shop.setDeliveryFee("0");
        shop.setCollectionNum(0);
        shop.setShopImg("resources/img/cbd.jpg");
        shop.setShopCreatetime(new Date());
        return shopService.insert(shop);
    }

    @RequestMapping("/shopChange.do")
    public String shopChange(@RequestParam("shopId") String shopId,
                                   @RequestParam("shopName") String shopName,
                                   @RequestParam("shopPsw") String shopPsw,
                                   @RequestParam("shopTel") String shopTel,
                                   @RequestParam("shopAdd") String shopAdd,
                                   @RequestParam("deliveryFee") String deliveryFee,
                                   @RequestParam("uploadImg") MultipartFile uploadImg
    ) throws IOException {
        String imgPath="";
        if (!uploadImg.isEmpty()) {
            //上传文件名
            String mainName = "imgof" + shopId + "Nb";
            //生成目录名字
            String dirName = "shop" + shopId + "Img";
            // 截取文件的扩展名(如.jpg)
            String oriName = uploadImg.getOriginalFilename();
            String extName = oriName.substring(oriName.lastIndexOf("."));
            //将上传文件保存到一个目标文件当中
            String pathname = ServerPath.RESOURSES_PATH + "resources/shopimg/";
            File tool = new File(pathname + dirName);
            if (!tool.exists()) {
                tool.mkdirs();
            }

            uploadImg.transferTo(new File(pathname + dirName + "/" + mainName + extName));
            imgPath="resources/shopimg/"+dirName+ "/" + mainName + extName;

        }

        Shop shop = shopService.selectByPrimaryKey(Integer.parseInt(shopId));
        shop.setShopId(Integer.parseInt(shopId));
        shop.setShopName(shopName);
        shop.setShopPsw(shopPsw);
        shop.setShopTel(shopTel);
        shop.setShopAdd(shopAdd);
        shop.setDeliveryFee(deliveryFee);
        shop.setShopImg(imgPath);
        shopService.updateByPrimaryKey(shop);
        return "relogin";
    }
}
