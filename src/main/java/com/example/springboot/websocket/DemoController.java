package com.example.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/websocket")
@Slf4j
public class DemoController {

    @GetMapping("/sendToClient/{userId}")
    public void sendToClient(@PathVariable("userId") String userId) throws IOException {
        Map<String, WebSocket> clients = WebSocket.clients;
        WebSocket webSocket = clients.get(userId);
        Session session = webSocket.getSession();
        sendMessage(userId + " success", session);
        closeSession(session);
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败：{}", e);
        }
    }

    private void closeSession(Session session) throws IOException {
        log.info("关闭session, id: " + session.getId());
        session.close();
    }
}
