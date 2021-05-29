package com.example.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoService {

    @Async
    public void doSomeThings(String userId) throws InterruptedException {
        log.info("begin do somethings");
        Thread.sleep(5000);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet("http://localhost:8080/websocket/sendToClient/" + userId);
            httpClient.execute(httpGet);
        } catch (Exception e) {
            log.info("failed");
        }
    }
}
