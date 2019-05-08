package com.wdl.nosql.manager;

import com.wdl.nosql.domain.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * <p>Title: RedisManagerTest</p>
 * <p>Description: redis 测试类</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: sodo</p>
 *
 * @author wangdali
 * @version 1.0
 * @date 2019/5/8 23:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisManagerTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisTemplate(){
        redisTemplate.opsForValue().set("SK", "StringKey"); //key value
        redisTemplate.opsForList().rightPush("UserList", "WDL001"); //list 尾插
        redisTemplate.opsForSet(); //Set
        redisTemplate.opsForZSet(); //排序Set
        redisTemplate.opsForHash().put("UserMap", "name", "整个牛皮啊"); //map
    }

}
