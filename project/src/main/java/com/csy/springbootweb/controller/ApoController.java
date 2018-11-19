package com.csy.springbootweb.controller;

import com.csy.springbootweb.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/aop")
public class ApoController {
    @PostMapping("/save")
    public @ResponseBody Map<String, Object> save() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }
}
