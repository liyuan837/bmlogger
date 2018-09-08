package com.liyuan.bmlogger.form.loggermain;

import java.io.Serializable;
import com.liyuan.bmlogger.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志主表")
public class LoggerMainCreateForm implements Serializable {

	@ApiModelProperty(value = "外键关联日志类型表")
	private Integer typeId;

	@ApiModelProperty(value = "日志标题")
	private String title;

	@ApiModelProperty(value = "所属项目名")
	private String projectName;

	@ApiModelProperty(value = "日志产生时间,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date createTime;

	@ApiModelProperty(value = "日志来源")
	private String hostIp;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "授权用户编号")
	private String authUserCode;

}