package com.liyuan.bmlogger.form.loggertype;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志类型")
public class LoggerTypeDeleteForm implements Serializable {

	@ApiModelProperty(value = "日志类型主键", required = true)
	@NotNull(message = "日志类型主键不能为空")
	private Integer id;

}