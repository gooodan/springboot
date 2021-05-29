package com.example.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/connectWebSocket/{userId}")
public class WebSocket {

    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    public static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();

    /**
     * 会话
     */
    private Session session;

    /**
     * 用户名称
     */
    private String userId;

    private static DemoService demoService;


    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws InterruptedException {
        this.userId = userId;
        this.session = session;
        clients.put(userId, this);

        demoService.doSomeThings(userId);
        log.info("open session success!");
    }

    @OnClose
    public void onClose(Session session) {
        log.info("有一连接关闭：{}", session.getId());
    }

    public Session getSession() {
        return session;
    }

    public String getUserId() {
        return userId;
    }

    @Resource
    private void setDemoService(DemoService demoService) {
        WebSocket.demoService = demoService;
    }
}
