package org.example.pattern.service;

import org.example.pattern.factorymethod.EmailNotification;
import org.example.pattern.factorymethod.ZaloNotification;
import org.example.pattern.interfaces.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryService {
    private EmailNotification emailNotification;
    private ZaloNotification zaloNotification;

    public FactoryService(EmailNotification emailNotification, ZaloNotification zaloNotification) {
        this.emailNotification = emailNotification;
        this.zaloNotification = zaloNotification;
    }

    public Notification createNotification(String type) {
        if ("email".equalsIgnoreCase(type)) {
            return emailNotification;
        } else if ("zalo".equalsIgnoreCase(type)) {
            return zaloNotification;
        }
        throw new IllegalArgumentException("Unknown notification type");
    }
}
