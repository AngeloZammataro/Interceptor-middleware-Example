package it2.develhope.Angelo.InterceptormiddlewareExample.controllers;

import it2.develhope.Angelo.InterceptormiddlewareExample.entitties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping("")
    public User get(HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        return user;
    }
}
