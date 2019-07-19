package com.alibaba.api2doc.dao2;

import com.alibaba.api2doc.entity.MailPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author :wb-jcy525678
 * @Description:
 * @date : 2019/5/23 11:49
 */
@Mapper
public interface MailPersonMapper  {

    List<MailPerson> queryAllPerson();
}
