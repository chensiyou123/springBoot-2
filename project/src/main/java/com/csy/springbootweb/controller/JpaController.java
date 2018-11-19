package com.csy.springbootweb.controller;

import com.csy.springbootweb.entity.Order;
import com.csy.springbootweb.repository.OrderRepository;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * 持久化
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody Order entity) {
        Map<String, Object> result = new HashMap<>();
        if(StringUtils.isNullOrEmpty(entity.getId())){
            entity.setId(UUID.randomUUID().toString());
        }
        entity = orderRepository.save(entity);
        result.put("id", entity.getId());
        return result;
    }

    /**
     * 获取对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @ResponseBody
    public  Object get(String id) {
        return orderRepository.findById(id);
    }

    /**
     * 获取全部
     *
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public @ResponseBody Object findAll() {
        return orderRepository.findAll();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(String id) {
        Map<String, Object> result = new HashMap<>();
        orderRepository.deleteById(id);
        result.put("id", id);
        return result;
    }
}
