package com.alibaba.api2doc.controller;


import com.alibaba.api2doc.entity.User;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.terran4j.commons.api2doc.annotations.ApiError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api2Doc(id = "sample1", name = "用户接口", order = 1)
@ApiComment(seeClass = User.class)
@RestController
@RequestMapping(value = "/users")
public class TestUserController {

    @Api2Doc(order = 1)
    @ApiComment("添加一个新用户以对象的形式")
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public void insertUser(@ApiComment("用户信息") User user) {
        System.out.println(user);
    }

    @Api2Doc(order = 2,name = "添加一个新用户以单个参数的形式2")
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    @ApiComment("添加一个新用户以单个参数的形式")
    public void insertUserInfo(@ApiComment("用户id") Long id, @ApiComment("用户姓名") String name, @ApiComment("用户年龄") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        System.out.println(user);
    }

    @Api2Doc(order = 3)
    @RequestMapping(value = "/insertUserInfo2", method = RequestMethod.POST)
    @ApiComment("添加一个新用户以单个参数的形式,不添加注解")
    public void insertUserInfo2(Long id, String name, Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        System.out.println(user);
    }

    @Api2Doc(order = 4, name = "通过id得到用户信息")
    @ApiComment("根据用户id，得到用户信息")
    @ApiError(value = "user.not.found", comment = "此用户不存在！")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(Long id) {
        User user1 = new User();
        user1.setAge(25);
        user1.setName("家臣与");
        user1.setId(new Long(1000000));
        return user1;
    }
}
