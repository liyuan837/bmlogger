package com.liyuan.bmlogger.domain.condition.authuser;

import java.io.Serializable;
import java.util.List;
import com.liyuan.bmlogger.domain.condition.BaseCondition;
import java.util.Date;
import lombok.Data;

@Data
public class AuthUserCondition extends BaseCondition implements Serializable {

	/**
	 * 用户编号
	*/
	private String userCode;
	/**
	 * 用户编号列表
	*/
	private List<String> userCodeList;
	/**
	 * 用户姓名
	*/
	private String name;
	/**
	 * 授权码
	*/
	private String authCode;
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
}