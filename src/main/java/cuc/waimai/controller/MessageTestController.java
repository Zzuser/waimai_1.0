package cuc.waimai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageTestController {
    @RequestMapping("/receiveMsg.do")
    @ResponseBody
    public String receiveMsg(@RequestParam("msgUserName") String rmsgUserName){
        return rmsgUserName;
    }
}
