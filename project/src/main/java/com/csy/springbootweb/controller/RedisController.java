package com.csy.springbootweb.controller;

import com.csy.springbootweb.dao.OrderDao;
import com.csy.springbootweb.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class RedisController {

    private static final String STR_REDIS_KEY = "key:name";

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @RequestMapping(value = "/setString",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> setString(String value) {
        redisTemplate.opsForValue().set(STR_REDIS_KEY, value);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

    @RequestMapping(value = "/getString",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getString() {
        String value = redisTemplate.opsForValue().get(STR_REDIS_KEY);
        Map<String, Object> map = new HashMap<>();
        map.put("value", value);
        map.put("msg", "ok");
        return map;
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public Order get(@RequestParam String id) {
        return orderDao.get(id);
    }
}
