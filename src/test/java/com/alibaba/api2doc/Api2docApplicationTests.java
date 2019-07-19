package com.alibaba.api2doc;

import com.alibaba.api2doc.entity.MailPerson;
import com.alibaba.api2doc.entity.Province;
import com.alibaba.api2doc.service.MailPersonService;
import com.alibaba.api2doc.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Api2docApplicationTests {

    @Resource
    MailPersonService mailPersonService;
    @Resource
    ProvinceService provinceService;
    @Autowired
    DataSource datasource;
    @Test
    public void contextLoads() {
        List<MailPerson> mailPeople = mailPersonService.queryAllMailPerson();
        for (MailPerson mailPerson : mailPeople) {
            System.out.println(mailPeople);
        }

    }

    @Test
    public void province() {
        List<Province> list=provinceService.queryAllProvince();
        for (Province province:list){
            System.out.println(list);
        }
    }

}
