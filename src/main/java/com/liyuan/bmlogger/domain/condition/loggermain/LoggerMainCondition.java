package com.liyuan.bmlogger.domain.condition.loggermain;

import java.io.Serializable;
import java.util.List;
import com.liyuan.bmlogger.domain.condition.BaseCondition;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerMainCondition extends BaseCondition implements Serializable {

	/**
	 * 日志主键
	*/
	private String id;
	/**
	 * 日志主键列表
	*/
	private List<String> idList;
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
	 * 日志来源
	*/
	private String hostIp;
	/**
	 * 最小
	*/
	private Date minAddTime;
	/**
	 * 最大
	*/
	private Date maxAddTime;
	/**
	 * 
	*/
	private String addUserCode;
	/**
	 * 授权用户编号
	*/
	private String authCode;
}