package com.alibaba.api2doc.controller;


import com.alibaba.api2doc.entity.Province;
import com.alibaba.api2doc.entity.User;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.terran4j.commons.api2doc.annotations.ApiError;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



@Api2Doc(id = "sample1", name = "用户接口", order = 1)
@ApiComment(seeClass = User.class)
@RestController
@RequestMapping(value = "/users")
@Api(value = "用户controller", tags = {"用户操作接口"})
public class TestUserController<T> {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Api2Doc(order = 1)
    @ApiComment("添加一个新用户以对象的形式")
    @ApiOperation(value = "添加一个新用户以对象的形式")
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public void insertUser(@ApiComment("用户信息")@ApiParam(name = "user",value = "用户信息") User<Province> user) {
        try {
            throw new RuntimeException("测试error日志追踪");
        }catch (Exception e){
            logger.error("日志输出error",e);
        }
        logger.trace("日志输出trance"+user.toString());
        logger.debug("日志输出debug"+user.toString());
        logger.info("日志输出info");
        logger.warn("日志输出warn");

    }

    @Api2Doc(order = 3)
    @RequestMapping(value = "/insertUserInfo2", method = RequestMethod.PUT)
    @ApiComment("添加一个新用户以单个参数的形式,不添加注解")
    @ApiModelProperty(value = "添加一个新用户以单个参数的形式")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = false, paramType = "path" ),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, paramType = "body"),
            @ApiImplicitParam(name = "age",value = "用户年龄",required = true,paramType = "body")
    })
    public void insertUserInfo2(Long id, String name, Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        System.out.println(user);
    }

    @Api2Doc(order = 2, name = "添加一个新用户以单个参数的形式2")
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    @ApiComment("添加一个新用户以单个参数的形式")
    @ApiModelProperty(value = "添加一个新用户以单个参数的形式2")

    public void insertUserInfo(@ApiComment("用户id") @ApiParam(name = "id ", value = "用户id", required = false) Long id,
                               @ApiComment("用户姓名") @ApiParam(name = "name ", value = "用户姓名", required = true) String name,
                               @ApiComment("用户年龄") @ApiParam(name = "age",value = "用户年龄",required = true) Integer age,
                               @ApiComment("测试泛型") @ApiParam(name = "test",value = "省份",required = true,hidden = true)Province test) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        System.out.println(user);
    }


    @Api2Doc(order = 1, name = "通过id得到用户信息")
    @ApiComment("根据用户id，得到用户信息")
    @ApiError(value = "user.not.found", comment = "此用户不存在！")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "得到用户信息通过id")
    public User<Province> getUser(@ApiParam(name = "id",value = "用户的id",required = true) Long id) {
        User user1 = new User();
        user1.setAge(25);
        user1.setName("家臣与");
        user1.setId(new Long(id));
        return user1;
    }
}
