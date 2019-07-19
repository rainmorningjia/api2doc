package com.alibaba.api2doc.dao;

import com.alibaba.api2doc.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
     List<Province> queryAllProvince();
}
