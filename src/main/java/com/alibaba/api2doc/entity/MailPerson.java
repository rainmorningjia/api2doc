package com.alibaba.api2doc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author :wb-jcy525678
 * @Description: 邮件通知人
 * @date : 2019/5/23 11:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mail_person")
public class MailPerson implements Serializable {
    private Long id;
    /**
     * 邮件通知人姓名
     */
    private String managerName;
    /**
     * 邮件通知人id
     */
    private String managerId;
    /**
     * 邮箱
     */
    private String email;
    @Column(name = "gmt_create")
    private Long createTime;
    @Column(name = "gmt_modified")
    private Long updateTime;
}