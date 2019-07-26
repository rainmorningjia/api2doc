package com.alibaba.api2doc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class TestController2 {

    @RequestMapping("/test")
    public void test(){

    }
}
