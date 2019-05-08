package com.wdl.nosql.manager;

import com.wdl.nosql.domain.dao.UserMongoRepository;
import com.wdl.nosql.domain.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p>Title: MongodbManagerTest</p>
 * <p>Description: Mongo 测试类</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: sodo</p>
 *
 * @author wangdali
 * @version 1.0
 * @date 2019/5/8 22:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbManagerTest {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertMany(){
        List<User> userList = new ArrayList<>(50);
        for(int i=50;i<100;i++){
            User user = new User();
            user.setName("wangdali" + i);
            user.setMobile("186420688" + i);
            user.setCreateTime(new Date());
            userList.add(user);
        }
        userMongoRepository.insert(userList);
    }

    @Test
    public void select(){
        System.out.println("名字查询：" + userMongoRepository.findByName("wangdali50"));
        System.out.println("name模糊查询：" + userMongoRepository.findByNameLike("wangdali").size());
        System.out.println("name模糊查询(分页)：" + userMongoRepository.findByNameLike("wangdali", PageRequest.of(1, 20)).size());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        System.out.println("范围查询：" + userMongoRepository.findByCreateTimeBetween(calendar.getTime(), new Date()).size());
    }

    /**
     * 原生操作
     */
    @Test
    public void mongoTemplate(){
        User user = new User();
        user.setName("王大厉");
        user.setMobile("18642066666");
        user.setCreateTime(new Date());
        mongoTemplate.insert(user, "UserAlias"); //可以指定集合名

        Query query = new Query(Criteria.where("name").is("王大厉"));
        System.out.println(mongoTemplate.findOne(query, User.class, "UserAlias"));

        Update update = new Update().set("name", "更新大厉").set("mobile", "18688886666");
        mongoTemplate.updateFirst(query, update, User.class, "UserAlias");
    }
}