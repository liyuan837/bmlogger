package com.liyuan.bmlogger.form.loggertype;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志类型")
public class LoggerTypeUpdateForm implements Serializable {

	@ApiModelProperty(value = "日志类型主键", required = true)
	@NotNull(message = "日志类型主键不能为空")
	private Integer id;

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