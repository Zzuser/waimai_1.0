package cuc.waimai.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Description : WebSocket配置文件类
 */

@Configuration
@EnableWebSocket
public class  WebSocketConfig  extends WebSocketConfigurationSupport implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(systemWebSocketHandler(),"/echo").addInterceptors(new HandshakeInterceptor());

        registry.addHandler(systemWebSocketHandler(), "/sockjs/echo").addInterceptors(new HandshakeInterceptor())
                .withSockJS();
    }

    @Bean(name = "SystemWebSocketHandler")
    public WebSocketHandler systemWebSocketHandler(){
        return new SystemWebSocketHandler();
    }
}
