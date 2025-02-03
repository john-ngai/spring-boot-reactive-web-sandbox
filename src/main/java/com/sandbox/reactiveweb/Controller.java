package com.sandbox.reactiveweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final RestService restService;

    public Controller(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/hello")
    public String getRequest() {
        try {
            restService.getCars();
        } catch (Exception exception) {
            System.out.println("INFO $ getCars failed with exception = " + exception);
        }

        return "hello world";
    }
}
