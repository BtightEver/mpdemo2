package com.example.mpdemo2.utils;

import redis.clients.jedis.Jedis;

public class SaleUtil {
    private static String script = "local existedNum =" +
            "tonumber(redis.call('get',KEYS[1]))\n" +
            "if(existedNum > 0) then\n" +
            " redis.call('incrby',KEYS[1],-1)\n" +
            " return existedNum - 1\n" +
            "end\n" +
            "return -1";
    public static boolean canSale(Jedis jedis, String model){
        String r = jedis.eval(script,1,model).toString();
        return !"-1".equals(r);
    }
}