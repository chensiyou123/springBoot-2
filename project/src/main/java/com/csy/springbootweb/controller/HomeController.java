package com.csy.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @RequestMapping("/")
    public @ResponseBody
    String index() {
        return "你好，这是第一个spring boot应用";
    }
}
