package com.wuhl.boot05web02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class Boot05Web02ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void testRedis(){

        //调用StringRedisTemplate中的方法
        ValueOperations<String,String> operations = redisTemplate.opsForValue();

        operations.set("aaa","bbb");

        String aaa = operations.get("aaa");

        System.out.println(aaa);
    }

    @Test
    void contextLoads() {

        //使用jdbcTemplate的方法进行查询
        List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from user");

        //打印信息
       log.info("{}",userList);


    }

}
