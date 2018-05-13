package cuc.waimai.controller.horsemanController;

import cuc.waimai.entity.Horseman;
import cuc.waimai.entity.Shop;
import cuc.waimai.po.HorsemanLoginData;
import cuc.waimai.service.HorsemanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

@Controller
public class HorsemanLoginController {
    @Autowired
    HorsemanService horsemanService;

    @RequestMapping("/horsemanLogin.do")
    @ResponseBody
    public HorsemanLoginData horsemanLogin(@RequestParam("horsemanName") String horsemanName,
                                           @RequestParam("horsemanPsw") String psw,
                                           HttpSession session) {
        Horseman horseman = horsemanService.selectByName(horsemanName);
        System.out.println("NAME:" + horsemanName + "PSW:" + psw);
        System.out.println("DID:" + horseman.getHorsemanId() + "DPSW:" + horseman.getHorsemanPsd());
        System.out.println(horseman.toString());
        System.out.println("pd:" + horseman.getHorsemanPsd().equals(psw));
        HorsemanLoginData loginData = new HorsemanLoginData();
        if (horseman != null) {
            if (horseman.getHorsemanPsd().equals(psw)) {
                session.setAttribute("horseman", horseman);
                loginData.setId(horseman.getHorsemanId());
                loginData.setUsername(horseman.getHorsemanName());
                loginData.setAlias(horseman.getHorsemanId().toString());
                loginData.setCount("10");
                loginData.setTag("android");
                loginData.setPassword(horseman.getHorsemanPsd());
                return loginData;

            } else {
                return loginData;
            }
        } else {
            return loginData;
        }
    }

    @RequestMapping("/horsemanReg.do")
    @ResponseBody
    public int horsemanReg(@RequestParam("horsemanName") String horsemanName,
                             @RequestParam("horsemanPsw") String psw,
                             @RequestParam("horsemanAdd") String horsemanAdd,
                             @RequestParam("horsemanTel") String horsemanTel) {
      Horseman horseman=horsemanService.selectByName(horsemanName);
      if (horseman==null){
          Horseman horseman1=new Horseman();
          horseman1.setHoresemanAdd(horsemanAdd);
          horseman1.setHorsemanName(horsemanName);
          horseman1.setHorsemanTel(horsemanTel);
          horseman1.setHorsemanPsd(psw);
          horsemanService.insert(horseman1);
          return 1;
      }
      return 0;

    }
}
