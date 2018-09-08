package com.liyuan.bmlogger.vo.loggertype;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志类型")
public class LoggerTypeVo implements Serializable {

	@ApiModelProperty(value = "日志类型主键", required = true)
	private Integer id;

	@ApiModelProperty(value = "类型名称")
	private String name;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "")
	private Date addTime;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private Date optTime;

	@ApiModelProperty(value = "")
	private String optUserCode;

	@ApiModelProperty(value = "状态，1有效，0无效，-1删除")
	private Integer state;

	@ApiModelProperty(value = "所有者")
	private String userCode;

}