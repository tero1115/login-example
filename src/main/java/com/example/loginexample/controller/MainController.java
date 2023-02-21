package com.example.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.loginexample.handler.ex.CustomException;
import com.example.loginexample.model.User;

@Controller
public class MainController {
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String home() {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            throw new CustomException("인증이 되지 않았습니다", HttpStatus.UNAUTHORIZED);
        }
        return "main";
    }
}
