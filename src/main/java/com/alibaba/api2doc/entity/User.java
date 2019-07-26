package com.alibaba.api2doc.entity;


import com.terran4j.commons.api2doc.annotations.ApiComment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户实体对象")
public class User<T> {

    @ApiComment("用户id")
    @ApiModelProperty(value = "用户id",name = "id",required = false)
    private Long id;
    @ApiComment("用户姓名")
    @ApiModelProperty(value = "用户名",name = "name",required = true)
    private String name;
    @ApiComment("用户年龄")
    @ApiModelProperty(value = "用户年龄",name = "age",required = true)
    private Integer age;
    @ApiModelProperty(value = "测试泛型",name = "test",required = true)
    @ApiComment("测试泛型")
    private T test;
}

