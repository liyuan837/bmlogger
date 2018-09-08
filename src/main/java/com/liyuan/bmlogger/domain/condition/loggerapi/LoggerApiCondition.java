package com.liyuan.bmlogger.domain.condition.loggerapi;

import java.io.Serializable;
import java.util.List;
import com.liyuan.bmlogger.domain.condition.BaseCondition;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerApiCondition extends BaseCondition implements Serializable {

	/**
	 * 日志编号
	*/
	private String id;
	/**
	 * 日志编号列表
	*/
	private List<String> idList;
	/**
	 * 日志标题
	*/
	private String title;
	/**
	 * 日志内容
	*/
	private String content;
	/**
	 * 请求uri
	*/
	private String requestUri;
	/**
	 * 请求方ip
	*/
	private String remoteAddr;
	/**
	 * 请求方式
	*/
	private String requestMethod;
	/**
	 * 请求参数
	*/
	private String requestParams;
	/**
	 * 请求参数类型
	*/
	private String contentType;
	/**
	 * API接口名
	*/
	private String apiControllerName;
	/**
	 * API方法名
	*/
	private String apiMethodName;
	/**
	 * API方法说明
	*/
	private String apiMethodNotes;
	/**
	 * 耗时
	*/
	private Integer useTime;
	/**
	 * 请求状态
	*/
	private String status;
	/**
	 * 项目名
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
	 * 
	*/
	private String authCode;
	/**
	 * 请求返回数据
	*/
	private String resultData;
}