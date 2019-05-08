package com.wdl.nosql.manager;

import com.wdl.nosql.domain.dao.UserMongoRepository;
import com.wdl.nosql.domain.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>Title: MongodbManager</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: sodo</p>
 *
 * @author wangdali
 * @version 1.0
 * @date 2019/5/4 22:32
 */
@Service
public class MongodbManager {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserMongoRepository userMongoRepository;

}
