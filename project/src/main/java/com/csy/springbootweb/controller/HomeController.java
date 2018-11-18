package com.csy.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "111");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("name", "fanfan");
        map.put("age", "12");
        return "hello";

    }
}
