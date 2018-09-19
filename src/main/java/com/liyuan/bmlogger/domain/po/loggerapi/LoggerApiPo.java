package com.liyuan.bmlogger.domain.po.loggerapi;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class LoggerApiPo implements Serializable {

	/**
	 * 日志编号
	*/
	private String id;
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
	 * 请求开始时间
	*/
	private Date startTime;
	/**
	 * 请求结束时间
	*/
	private Date endTime;
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
	 * 日志生成时间
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
	 * 
	*/
	private String authCode;
	/**
	 * 请求返回数据
	*/
	private String resultData;
    /**
     * 接口调用结果状态
     */
    private Integer requestState;
}