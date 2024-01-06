package com.example.mpdemo2.service;

import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.OrderMapperPlus;
import com.example.mpdemo2.mapper.UserMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapperPlus orderMapperPlus;
    @Cacheable("order")
    public Order getOrderById(int id) {
        return orderMapperPlus.selectById(id);
    }
}