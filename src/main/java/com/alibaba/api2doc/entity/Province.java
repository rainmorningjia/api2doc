package com.alibaba.api2doc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "省份")
public class Province implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "省份id",name = "id",required = true)
	private Integer id;
	@ApiModelProperty(value = "编码",name = "code",required = true)
	private String code;
	@ApiModelProperty(value = "省份名称",name = "name",required = true)
	private String name;
	@ApiModelProperty(value = "创建时间",name = "createTime")
	private Long createTime;
	@ApiModelProperty(value = "修改时间",name = "updateTime")
	private Long updateTime;


}
