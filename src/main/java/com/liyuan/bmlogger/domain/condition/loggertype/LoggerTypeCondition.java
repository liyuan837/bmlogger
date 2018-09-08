package com.liyuan.bmlogger.domain.condition.loggertype;

import java.io.Serializable;
import java.util.List;
import com.liyuan.bmlogger.domain.condition.BaseCondition;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerTypeCondition extends BaseCondition implements Serializable {

	/**
	 * 日志类型主键
	*/
	private Integer id;
	/**
	 * 日志类型主键列表
	*/
	private List<Integer> idList;
	/**
	 * 类型名称
	*/
	private String name;
	/**
	 * 描述
	*/
	private String description;
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