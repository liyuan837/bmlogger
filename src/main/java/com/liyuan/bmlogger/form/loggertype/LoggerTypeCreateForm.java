package com.liyuan.bmlogger.form.loggertype;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志类型")
public class LoggerTypeCreateForm implements Serializable {

	@ApiModelProperty(value = "类型名称")
	private String name;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private String optUserCode;

	@ApiModelProperty(value = "状态，1有效，0无效，-1删除")
	private Integer state;

	@ApiModelProperty(value = "所有者")
	private String userCode;

}