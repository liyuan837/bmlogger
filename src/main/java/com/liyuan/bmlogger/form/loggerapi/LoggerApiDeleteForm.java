package com.liyuan.bmlogger.form.loggerapi;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "接口日志")
public class LoggerApiDeleteForm implements Serializable {

	@ApiModelProperty(value = "日志编号", required = true)
	@NotEmpty(message = "日志编号不能为空")
	private String id;

}