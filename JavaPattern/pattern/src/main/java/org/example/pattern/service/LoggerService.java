package org.example.pattern.service;

import org.springframework.stereotype.Service;

@Service // sử dụng singleton được cấu hình sẵn trong Bean
public class LoggerService {
    private int count = 0;

    public LoggerService() {
        System.out.println("LoggerService instance created");
    }

    public void log(String message) {
        count++;
        System.out.println("Log #" + count + ": " + message);
    }
}
