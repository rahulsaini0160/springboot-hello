package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public String helloWithParam(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/hello/{name}")
    public String helloWithPath(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }
}