package com.ldp.gitdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
