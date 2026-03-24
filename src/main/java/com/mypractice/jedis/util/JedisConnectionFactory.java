package com.mypractice.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisConnectionFactory   {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxTotal(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWait(Duration.ofDays(1000));

        jedisPool = new JedisPool(poolConfig,"localhost", 6379,1000);
    }
    public static Jedis getJedis(){
        return  jedisPool.getResource();
    }
}
