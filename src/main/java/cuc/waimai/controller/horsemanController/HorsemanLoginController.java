package cuc.waimai.controller.horsemanController;

import com.google.gson.Gson;
import cuc.waimai.Dao.Horseman;
import cuc.waimai.po.HorsemanLoginData;
import cuc.waimai.service.HorsemanService;

import org.apache.http.HttpResponse;
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
    public HorsemanLoginData horsemanLogin(@RequestParam("horsemanId") String horsemanId,
                                           @RequestParam("horsemanPsw")String psw,
                                           HttpSession session){
        Horseman horseman=horsemanService.selectByPrimaryKey(Integer.parseInt(horsemanId));
        System.out.println("ID:"+horsemanId+"PSW:"+psw);
        System.out.println("DID:"+horseman.getHorsemanId()+"DPSW:"+horseman.getHorsemanPsd());
        System.out.println(horseman.toString());
        System.out.println("pd:"+horseman.getHorsemanPsd().equals(psw));
        HorsemanLoginData loginData=new HorsemanLoginData();
        if(horseman!=null){
            if(horseman.getHorsemanPsd().equals(psw)){
                session.setAttribute("horseman",horseman);
                loginData.setId(horseman.getHorsemanId());
                loginData.setUsername(horseman.getHorsemanName());
                loginData.setAlias(horseman.getHorsemanId().toString());
                loginData.setCount("10");
                loginData.setTag("android");
                loginData.setPassword(horseman.getHorsemanPsd());
                return loginData;

            }
            else {
                return loginData;
            } }
        else {
            return loginData;
        }
    }
}
