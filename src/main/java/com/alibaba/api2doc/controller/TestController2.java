package com.alibaba.api2doc.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
@Api(tags = {"用户操作接口2"})
public class TestController2 {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){

    }
}
