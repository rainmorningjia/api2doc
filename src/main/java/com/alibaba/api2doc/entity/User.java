package com.alibaba.api2doc.entity;


import com.terran4j.commons.api2doc.annotations.ApiComment;

public class User {

    @ApiComment("用户id")
    private Long id;
    @ApiComment("用户姓名")
    private String name;
    @ApiComment("用户年龄")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

