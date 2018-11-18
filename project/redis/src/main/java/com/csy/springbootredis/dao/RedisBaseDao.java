package com.csy.springbootredis.dao;

import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

public class RedisBaseDao {
    @Resource(name="redisTemplate")
    protected ValueOperations<String, String> valueOperations;

    public void addValue(String key, String value){
        valueOperations.set(key, value);
    }

    public String getValue(String key){
        return valueOperations.get(key);
    }
}
