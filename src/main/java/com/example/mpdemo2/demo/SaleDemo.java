package com.example.mpdemo2.demo;

import com.example.mpdemo2.utils.JedisConnectionPool;
import com.example.mpdemo2.utils.SaleUtil;
import redis.clients.jedis.Jedis;

public class SaleDemo extends Thread {
    @Override
    public void run() {
        JedisConnectionPool jedisPool = JedisConnectionPool.getInstance("47.109.132.129", 6379, "wlmxhyqrfd1.");
        Jedis jedis = jedisPool.getConnection();
        String name = Thread.currentThread().getName();
        boolean flag = SaleUtil.canSale(jedis,"phone");
        if(flag){
            System.out.println(name+"可以购买");
        }else{
            System.out.println(name+"不能购买");
        }
        jedisPool.releaseConnection(jedis);
    }
    public static void main(String[] args) {
        JedisConnectionPool jedisPool = JedisConnectionPool.getInstance("47.109.132.129", 6379, "wlmxhyqrfd1.");
        Jedis jedis = jedisPool.getConnection();
        jedis.set("phone","3");
        jedis.expire("phone",10);
//开启10个线程抢购
        for(int i = 0;i<10;i++){
            new SaleDemo().start();
        }
    }
}