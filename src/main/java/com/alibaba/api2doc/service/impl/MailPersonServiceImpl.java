package com.alibaba.api2doc.service.impl;

import com.alibaba.api2doc.dao2.MailPersonMapper;
import com.alibaba.api2doc.entity.MailPerson;
import com.alibaba.api2doc.service.MailPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MailPersonServiceImpl implements MailPersonService {

    @Resource
    MailPersonMapper mailPersonMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<MailPerson> queryAllMailPerson() {
        return mailPersonMapper.queryAllPerson();
    }
}
