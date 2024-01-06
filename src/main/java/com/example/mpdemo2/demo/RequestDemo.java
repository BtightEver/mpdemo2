package com.example.mpdemo2.demo;

import com.example.mpdemo2.utils.JedisConnectionPool;
import com.example.mpdemo2.utils.LimitAccess;
import redis.clients.jedis.Jedis;

public class RequestDemo extends Thread{
    @Override
    public void run() {
        JedisConnectionPool jedisPool = JedisConnectionPool.getInstance("47.109.132.129", 6379, "wlmxhyqrfd1.");
        Jedis jedis = jedisPool.getConnection();
//当前线程中模拟发送5次请求
        for(int visitNum = 0; visitNum < 5;visitNum++){
            String name = Thread.currentThread().getName();
//10秒内访问3次
            boolean flag = LimitAccess.canVisit(jedis,name,3,10);
            if (flag){
                System.out.println(name + "可以访问");
            }else{
                System.out.println(name + "限制访问");
            }
        }
        jedisPool.releaseConnection(jedis);
        jedisPool.close();
    }
    public static void main(String[] args) {
// 开启2个线程
        for(int i = 0; i < 2;i++){
            new RequestDemo().start();
        }
    }
}