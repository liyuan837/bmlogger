package com.liyuan.bmlogger.vo.authuser;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "授权用户表")
public class AuthUserVo implements Serializable {

	@ApiModelProperty(value = "用户编号", required = true)
	private String userCode;

	@ApiModelProperty(value = "用户姓名")
	private String name;

    @ApiModelProperty(value = "项目编号")
    private Integer projectId;

    @ApiModelProperty(value = "项目名")
    private String projectName;

	@ApiModelProperty(value = "授权码")
	private String authCode;

	@ApiModelProperty(value = "")
	private Date addTime;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private Date optTime;

	@ApiModelProperty(value = "")
	private String optUserCode;

	@ApiModelProperty(value = "授权时间")
	private Date authTime;

}