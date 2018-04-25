package cuc.waimai.controller.MsgPushController;

import cuc.waimai.websocket.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ShopMsgPushController {
    @Autowired
    MyClient myClient;



    public String task(String shopId,String json){
        MyClient client = new MyClient();
        String uri = "ws://localhost:8080/websocket?service";
        client.start(uri+shopId);
        try {
            client.sendMessage(json);
            client.closeSocket();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "200";
    }
}
