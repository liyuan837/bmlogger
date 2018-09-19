package com.liyuan.bmlogger.domain.po.authuser;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AuthUserPo implements Serializable {

	/**
	 * 用户编号
	*/
	private String userCode;
	/**
	 * 用户姓名
	*/
	private String name;
    /**
     *项目编号
     */
    private Integer projectId;
    /**
     * 项目名
     */
    private String projectName;
	/**
	 * 授权码
	*/
	private String authCode;
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
	 * 授权时间
	*/
	private Date authTime;
}