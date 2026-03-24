package com.mypractice.tset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("localhost", 6379);

//        jedis.auth("123456");

        jedis.select(0);
    }

    @Test
    void testString(){
        String result = jedis.set("name", "zhangsan");
        System.out.println("result= " + result);

        String name = jedis.get("name");
        System.out.println("name= " + name);
    }

    @Test
    void  testHash(){
        jedis.hset("user:1001)", "name", "lisi");
        jedis.hset("user:1001)", "age", "30");

        Map<String,String> map = jedis.hgetAll("user:1001)");
        System.out.println("map: " + map);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}

