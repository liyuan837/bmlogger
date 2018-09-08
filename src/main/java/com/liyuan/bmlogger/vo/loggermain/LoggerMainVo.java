package com.liyuan.bmlogger.vo.loggermain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志主表")
public class LoggerMainVo implements Serializable {

	@ApiModelProperty(value = "日志主键", required = true)
	private String id;

	@ApiModelProperty(value = "外键关联日志类型表")
	private Integer typeId;

	@ApiModelProperty(value = "日志标题")
	private String title;

	@ApiModelProperty(value = "所属项目名")
	private String projectName;

	@ApiModelProperty(value = "日志产生时间")
	private Date createTime;

	@ApiModelProperty(value = "日志来源")
	private String hostIp;

	@ApiModelProperty(value = "")
	private Date addTime;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "授权用户编号")
	private String authCode;

}