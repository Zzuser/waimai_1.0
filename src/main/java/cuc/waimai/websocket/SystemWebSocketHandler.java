package cuc.waimai.websocket;

import com.google.gson.Gson;
import cuc.waimai.controller.MessageTestController;
import cuc.waimai.controller.ordercontroller.OrderController;
import cuc.waimai.po.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.socket.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljf-梁燕双栖 on 2016/7/16.
 */
public class SystemWebSocketHandler implements WebSocketHandler {
    @Autowired
    OrderController orderController;
    @Autowired
    MessageTestController messageTestController;

    private static final Logger log = Logger.getLogger(SystemWebSocketHandler.class);
    private static final List<WebSocketSession> users;

    static {
        users = new ArrayList<WebSocketSession>();
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        System.out.println("Socket链接成功！");
        users.add(webSocketSession);
        log.info("connect websocket success.......");
        String username = (String) webSocketSession.getAttributes().get("WEBSOCKET_USERNAME");
        if (username != null) {
            String count ="" ;
            webSocketSession.sendMessage(new TextMessage(count + ""));
        }
    }

@Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        Gson gson = new Gson();
        Message message=parseJSONWithGSON(webSocketMessage.getPayload().toString());
        MockHttpSession session=new MockHttpSession();
       System.out.println("你是不是msg" + webSocketMessage.getPayload());
        sendMessageToUser(message.getToId(),new TextMessage(  gson.toJson( orderController.ordersSelectALLByShopId("1",session))));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

        if (webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        System.out.println("连接失败");
        users.remove(webSocketSession);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private Message parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        Message message = gson.fromJson(jsonData, Message.class);
        return message;

    }
}