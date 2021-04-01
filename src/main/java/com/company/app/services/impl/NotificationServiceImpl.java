package com.company.app.services.impl;

import com.company.app.services.api.NotificationService;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationServiceImpl implements NotificationService {

    //todo stateless
    private static final boolean logEnabled = true;
    private static final String NOTIFICATION_SERVICE_ADDRESS = "http://127.0.0.1:8081";

    private final List<String> log;

    public NotificationServiceImpl() {
        this.log = new ArrayList<>();
    }

    public void eventNotification(Object message) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("temp", message.toString());

        HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(), headers);
        URI locationHeader = restTemplate.postForLocation(NOTIFICATION_SERVICE_ADDRESS, request);
    }

    public void logNotification(Object message) {
        if (logEnabled) {
            log.add(message.toString());
        }
    }

    public void showLog() {
        for (String s : log) {
            System.out.println(s);
        }
    }

    public void errorNotification(Exception e) {
        e.printStackTrace();
    }
}
