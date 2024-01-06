package com.example.mpdemo2;


import com.example.mpdemo2.utils.JedisConnectionPool;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@SpringBootApplication
@MapperScan("com/example/mpdemo2/mapper")
public class Mpdemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mpdemo2Application.class, args);
        JedisConnectionPool jedisPool = JedisConnectionPool.getInstance("47.109.132.129", 6379, "wlmxhyqrfd1.");
        Jedis jedis = jedisPool.getConnection();
        String luaScript = "redis.call('set',KEYS[1],ARGV[1])";
        jedis.eval(luaScript,1,"name","test");
        System.out.println(jedis.get("name"));
    }

}
