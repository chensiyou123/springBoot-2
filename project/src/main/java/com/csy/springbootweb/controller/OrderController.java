package com.csy.springbootweb.controller;

import com.csy.springbootweb.dao.OrderDao;
import com.csy.springbootweb.entity.Order;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Controller
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @ResponseBody
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public Map<String, Object> save(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isNullOrEmpty(order.getId())) {
            order.setId(UUID.randomUUID().toString());
            orderDao.insert(order);
        }else {
            orderDao.update(order);
        }
        result.put("id", order.getId());
        return result;
    }

    @PostMapping("/get")
    public @ResponseBody Object get(String id) {
        return orderDao.get(id);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public @ResponseBody Object findAll() {
        return orderDao.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    public  Map<String, Object> delete(String id) {
        Map<String, Object> result = new HashMap<>();
        orderDao.delete(id);
        result.put("id", id);
        return result;
    }
}
