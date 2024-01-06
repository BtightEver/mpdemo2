package com.example.mpdemo2.utils;
import com.example.mpdemo2.entity.User;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisConnectionPool {
    private static volatile JedisConnectionPool instance;
    private GenericObjectPool<Jedis> jedisPool;

    private JedisConnectionPool(String host, int port, String password) {
        // 创建连接池配置
        GenericObjectPoolConfig<Jedis> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(10); // 设置最大连接数
        poolConfig.setMaxIdle(5); // 设置最大空闲连接数
        poolConfig.setMinIdle(1); // 设置最小空闲连接数

        // 创建连接池
        jedisPool = new GenericObjectPool<>(new JedisConnectionFactory(host, port, password), poolConfig);
    }

    public static JedisConnectionPool getInstance(String host, int port, String password) {
        if (instance == null) {
            synchronized (JedisConnectionPool.class) {
                if (instance == null) {
                    instance = new JedisConnectionPool(host, port, password);
                }
            }
        }
        return instance;
    }

    public Jedis getConnection() {
        try {
            // 从连接池获取Jedis实例
            return jedisPool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain Jedis instance from the pool", e);
        }
    }

    public void releaseConnection(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnObject(jedis);
        }
    }

    public void close() {
        jedisPool.close();
    }

    private static class JedisConnectionFactory extends org.apache.commons.pool2.BasePooledObjectFactory<Jedis> {
        private final String host;
        private final int port;
        private final String password;

        public JedisConnectionFactory(String host, int port, String password) {
            this.host = host;
            this.port = port;
            this.password = password;
        }

        @Override
        public Jedis create() throws Exception {
            // 创建Jedis实例
            Jedis jedis = new Jedis(host, port);
            if (password != null && !password.isEmpty()) {
                jedis.auth(password);
            }
            return jedis;
        }

        @Override
        public void destroyObject(PooledObject<Jedis> p) throws Exception {
            // 销毁Jedis实例
            p.getObject().close();
        }

        @Override
        public PooledObject<Jedis> wrap(Jedis jedis) {
            // 包装Jedis实例以供连接池管理
            return new DefaultPooledObject<>(jedis);
        }
    }

    public void saveUser(User user) {
        Jedis jedis = null;
        try {
            jedis = getConnection();
            Map<String, String> userData = new HashMap<>();
            userData.put("id", String.valueOf(user.getId()));
            userData.put("name", user.getUsername());
            userData.put("birthday", user.getBirthday());
            userData.put("Password", String.valueOf(user.getPassword()));
            jedis.hmset("users:" + user.getId(), userData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user", e);
        } finally {
            releaseConnection(jedis);
        }
    }

    public User getUser(int userId) {
        Jedis jedis = null;
        try {
            jedis = getConnection();
            Map<String, String> userData = jedis.hgetAll("users:" + userId);
            if (userData.isEmpty()) {
                return null;
            }
            User user = new User();
            user.setId(Integer.parseInt(userData.get("id")));
            user.setUsername(userData.get("name"));
            user.setBirthday(userData.get("birthday"));
            user.setPassword((userData.get("Password")));
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get user", e);
        } finally {
            releaseConnection(jedis);
        }
    }

    public boolean deleteUser(int userId) {
        Jedis jedis = null;
        try {
            jedis = getConnection();
            Long deletedCount = jedis.del("users:" + userId);
            return deletedCount > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user", e);
        } finally {
            releaseConnection(jedis);
        }
    }
}