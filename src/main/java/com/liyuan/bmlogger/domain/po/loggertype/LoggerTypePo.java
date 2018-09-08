package com.liyuan.bmlogger.domain.po.loggertype;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerTypePo implements Serializable {

	/**
	 * 日志类型主键
	*/
	private Integer id;
	/**
	 * 类型名称
	*/
	private String name;
	/**
	 * 描述
	*/
	private String description;
	/**
	 * 
	*/
	private Date addTime;
	/**
	 * 
	*/
	private String addUserCode;
	/**
	 * 
	*/
	private Date optTime;
	/**
	 * 
	*/
	private String optUserCode;
	/**
	 * 状态，1有效，0无效，-1删除
	*/
	private Integer state;
	/**
	 * 所有者
	*/
	private String userCode;
}