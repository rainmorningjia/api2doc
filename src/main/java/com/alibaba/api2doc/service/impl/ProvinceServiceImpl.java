package com.alibaba.api2doc.service.impl;

import com.alibaba.api2doc.dao.ProvinceMapper;
import com.alibaba.api2doc.entity.Province;
import com.alibaba.api2doc.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Resource
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> queryAllProvince() {
        return provinceMapper.queryAllProvince();
    }
}
