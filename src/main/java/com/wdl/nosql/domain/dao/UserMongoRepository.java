package com.wdl.nosql.domain.dao;

import com.wdl.nosql.domain.pojo.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: UserMongoRepository</p>
 * <p>Description: 类似JPA那种写法</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: sodo</p>
 *
 * @author wangdali
 * @version 1.0
 * @date 2019/5/4 22:36
 */
public interface UserMongoRepository extends MongoRepository<User, String> {

    public User findByName(String name);

    public List<User> findByNameLike(String name);

    public List<User> findByNameLike(String name, Pageable pageable);

    public List<User> findByCreateTimeBetween(Date startTime, Date endTime);



}
