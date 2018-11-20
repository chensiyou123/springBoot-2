package com.csy.springbootweb.dao;


import com.csy.springbootweb.entity.Order;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RedisDao{
    /**
     * 假设从数据库获取的订单数据
     *
     * @param id
     * @return
     */
    @Cacheable(value = "order", key = "'.id.'+#id")
    public Order get(String id) {
        Order order = new Order();
        order.setId(id);
        order.setNo("No.00001");
        order.setDate(new Date());
        order.setQuantity(100);
        return order;
    }
}

