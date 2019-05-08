package com.wdl.nosql;

import com.wdl.nosql.domain.dao.UserMongoRepository;
import com.wdl.nosql.domain.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NosqlApplicationTests {

    @Autowired
    private UserMongoRepository userMongoRepository;

    private ConcurrentHashMap concurrentHashMap;

    @Test
    public void contextLoads() {
    }

//    public void testRedisTemplate(){
//        redisTemplate.opsForValue().in; //opsForxx xx对应着redis中的数据结构
//        redisTemplate.delete("");
//    }

    @Test
    public void testMongo(){
        List<User> userList = new ArrayList<>(50);
        Date insertTime = new Date();
        for(int i=0;i<50;i++){
            User user = new User();
            user.setName("wangdali" + i);
            user.setMobile("18642068888");
            user.setCreateTime(insertTime);
            userList.add(user);
        }
//        //批量插入
        userMongoRepository.insert(userList);
//        System.out.println(userList);
        //
    }

}
