package com.example.mpdemo2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.OrderMapper;
import com.example.mpdemo2.mapper.OrderMapperPlus;
//import com.example.mpdemo2.mapper.UserMapper;
import com.example.mpdemo2.service.OrderService;
import com.example.mpdemo2.utils.JedisConnectionPool;
import com.example.mpdemo2.utils.LimitAccess;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Transactional
@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderMapperPlus orderMapperPlus;
    @Autowired
    private OrderService orderService;
    @GetMapping("/order")
    public List getOrder(){

        System.out.println("noplusorders:"+orderMapper.Orders());
        List<Order> orderList = orderMapperPlus.selectList(null);
        return  orderList;
    }

    @GetMapping("/orderAndUser")
    public List getOrderAndUser(){
        List<Order> orderList = null;
        try{
            orderList = orderMapper.selectOrderAndItsOrders();}catch (Exception e){
            System.out.println("这是catch里的报错"+e);
        }
        System.out.println("这是orderList"+orderList);
        return  orderList;
    }
    @PostMapping("/order")
    public String insertOrder(@RequestBody Order order){
        String create_Time=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //order.setOrder_time(LocalDateTime.parse(create_Time, formatter));
        int re=orderMapperPlus.insert(order);
        if(re>0) return "插入成功";
        return "插入败";
    }
    @GetMapping("/order/{id}")
    public Order getUser(@PathVariable int id) {
        JedisConnectionPool jedisPool= JedisConnectionPool.getInstance("47.109.132.129", 6379, "wlmxhyqrfd1.");
        Jedis jedis=jedisPool.getConnection();
        boolean flag = LimitAccess.canVisit(jedis,"getUser",3,10);
        if (flag){
            System.out.println("getOrder可以访问");
            jedisPool.releaseConnection(jedis);
            return orderService.getOrderById(id);
        }else {
            System.out.println("getOrder限制访问");
            jedisPool.releaseConnection(jedis);
            return new Order(-1,"访问次数达到限制","",-1,null);
        }

    }
}
