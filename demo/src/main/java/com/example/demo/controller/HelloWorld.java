package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloWorld {


    @GetMapping("/hello")
    public String demo() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello World!";
    }


}
