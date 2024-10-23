package org.example.pattern.factorymethod;

import org.example.pattern.interfaces.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending zalo: " + message);
    }
}
