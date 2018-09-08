package com.liyuan.bmlogger.domain.po.loggermain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerMainPo implements Serializable {

	/**
	 * 日志主键
	*/
	private String id;
	/**
	 * 外键关联日志类型表
	*/
	private Integer typeId;
	/**
	 * 日志标题
	*/
	private String title;
	/**
	 * 所属项目名
	*/
	private String projectName;
	/**
	 * 日志产生时间
	*/
	private Date createTime;
	/**
	 * 日志来源
	*/
	private String hostIp;
	/**
	 * 
	*/
	private Date addTime;
	/**
	 * 
	*/
	private String addUserCode;
	/**
	 * 授权用户编号
	*/
	private String authUserCode;
}