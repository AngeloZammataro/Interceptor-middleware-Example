package it2.develhope.Angelo.InterceptormiddlewareExample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("")
    public String sayHello(){
        return "Hello";
    }
}
