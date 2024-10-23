package org.example.pattern.factorymethod;


import org.example.pattern.interfaces.Notification;
import org.springframework.stereotype.Component;

@Component
public class ZaloNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
