package com.spring.cloud.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer user_id;
	private String user_name;
	private String uuser_pass;
	private Integer sex;
	private String token;
	private Integer is_del;
	/***
	 **返回时按照指定格式转换，pattern样式，locale表示在中国，timezone表示东八区
	 */
	@JsonFormat(pattern="yyyy-MM-dd",locale="zh",timezone="GMT+8")
	private Date birthday;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date create_time;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date update_time;

}
