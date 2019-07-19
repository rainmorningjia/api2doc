package com.alibaba.api2doc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String name;
	private Long createTime;
	private Long updateTime;


}
