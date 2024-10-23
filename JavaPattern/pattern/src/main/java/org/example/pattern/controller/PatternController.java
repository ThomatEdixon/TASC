package org.example.pattern.controller;

import org.example.pattern.service.FactoryService;
import org.example.pattern.service.LoggerService;
import org.example.pattern.singleton.SingletonDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatternController {
    private LoggerService loggerService;
    private FactoryService factoryService;

    public PatternController(LoggerService loggerService, FactoryService factoryService) {
        this.loggerService = loggerService;
        this.factoryService = factoryService;
    }

    @GetMapping("/singleton")
    public void testSingleton(){
        SingletonDemo instance1 = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();

        if (instance1 == instance2) {
            System.out.println("Both instances are the same.");
        }
    }

    @GetMapping("/singletonSpring")
    public String testSingletonSpring() {
        loggerService.log("Singleton test");
        return "Check the console log for Singleton pattern demonstration";
    }
    @GetMapping("/factory")
    public String notify(@RequestParam String type, @RequestParam String message) {
        factoryService.createNotification(type).send(message);
        return "Notification sent via " + type;
    }

}
