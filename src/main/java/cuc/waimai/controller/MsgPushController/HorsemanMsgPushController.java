package cuc.waimai.controller.MsgPushController;

import com.google.gson.Gson;
import cuc.waimai.po.HorsemanLoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HorsemanMsgPushController {
//    public int orderJpush(String alias, String msg) {
//        try {
//            PushUtils.buildPushObject_all_alias_alert();
//     //       PushUtils.sendPushMessage(alias, "新订单", msg);
//            return 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
    @RequestMapping("/msgTest")
    @ResponseBody
    public String msgTest(@RequestParam("username") String horsemanId,
                        @RequestParam("password")String psw){
        HorsemanLoginData loginData=new HorsemanLoginData();
        loginData.setId(1);
        loginData.setUsername("user");
        loginData.setAlias("user");
        loginData.setCount("10");
        loginData.setTag("android");
        loginData.setPassword("123");
        Gson gson=new Gson();
       return gson.toJson(loginData);


    }
}
