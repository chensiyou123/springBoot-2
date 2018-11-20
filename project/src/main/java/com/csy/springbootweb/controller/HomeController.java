package com.csy.springbootweb.controller;

import com.csy.springbootweb.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.HashMap;
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


    @RequestMapping("/jquery")
    public String jquery() {
        return "jquery";
    }

    @RequestMapping(value ="/angularjs",method = RequestMethod.GET)
    public String angularjs() {
        return "angularjs";
    }
    @ResponseBody
    @RequestMapping(value = "/postData",method = RequestMethod.POST)
    public  Map<String, Object> postData(String no, int quantity, String date) {
        System.out.println("no:" + no);
        System.out.println("quantity:" + quantity);
        System.out.println("date:" + date);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("quantity", quantity);
        map.put("no", no);
        map.put("date", date);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/postJson",method = RequestMethod.POST)
    public  Map<String, Object> postJson(@RequestBody Order order) {
        System.out.println("order no:" + order.getNo());
        System.out.println("order quantity:" + order.getQuantity());
        System.out.println("order date:" + order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("value", order);
        return map;
    }


    @RequestMapping(value ="/order",method = RequestMethod.GET)
    public String order() {
        return "order";
    }

    @RequestMapping("/jpa")
    public String jpa() {
        return "jpa";
    }

    @RequestMapping("/aop")
    public String aop() {
        return "aop";
    }

    @RequestMapping("/redis")
    public String redis() {
        return "redis";
    }

    @RequestMapping("/redisChach")
    public String redisChach() {
        return "redisChach";
    }
}
