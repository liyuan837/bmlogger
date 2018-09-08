package com.liyuan.bmlogger.form.loggerapi;

import java.io.Serializable;

import com.liyuan.bmlogger.form.loggermain.LoggerMainCreateForm;
import com.liyuan.bmlogger.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "接口日志")
public class LoggerApiCreateForm  extends LoggerMainCreateForm implements Serializable{

	@ApiModelProperty(value = "日志标题")
	private String title;

	@ApiModelProperty(value = "日志内容")
	private String content;

	@ApiModelProperty(value = "请求uri")
	private String requestUri;

	@ApiModelProperty(value = "请求方ip")
	private String remoteAddr;

	@ApiModelProperty(value = "请求方式")
	private String requestMethod;

	@ApiModelProperty(value = "请求参数")
	private String requestParams;

	@ApiModelProperty(value = "请求参数类型")
	private String contentType;

	@ApiModelProperty(value = "API接口名")
	private String apiControllerName;

	@ApiModelProperty(value = "API方法名")
	private String apiMethodName;

	@ApiModelProperty(value = "API方法说明")
	private String apiMethodNotes;

	@ApiModelProperty(value = "请求开始时间,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date startTime;

	@ApiModelProperty(value = "请求结束时间,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date endTime;

	@ApiModelProperty(value = "耗时")
	private Integer useTime;

	@ApiModelProperty(value = "请求状态")
	private String status;

	@ApiModelProperty(value = "项目名")
	private String projectName;

	@ApiModelProperty(value = "日志生成时间,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createTime;

	@ApiModelProperty(value = "日志来源")
	private String hostIp;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private String authCode;

	@ApiModelProperty(value = "请求返回数据")
	private String resultData;

}