package cuc.waimai.controller;

import cuc.waimai.Dao.Shop;
import cuc.waimai.websocket.SystemWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

@Controller
public class MessageTestController {
    @Autowired
    SystemWebSocketHandler socketHandler;


    @RequestMapping("/sendMsg.do")
    @ResponseBody
    public String sendMsg(String shopId, String msg) {
        TextMessage textMessage = new TextMessage(msg);
        socketHandler.sendMessageToUser(shopId, textMessage);
        return "200";
    }
}
