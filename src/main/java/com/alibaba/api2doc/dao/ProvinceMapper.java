package com.alibaba.api2doc.dao;

import com.alibaba.api2doc.entity.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper{
     List<Province> queryAllProvince();
}
