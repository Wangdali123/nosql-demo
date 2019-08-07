package com.wdl.nosql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: RedisController</p>
 * <p>Description: TODO</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: sodo</p>
 *
 * @author wangdali
 * @version 1.0
 * @date 2019/6/11 14:30
 */
@RestController
public class RedisController {

    @GetMapping("print")
    public String webPrint() {
        return "hello,welcome spring boot jenkins";
    }

}
