package com.liyuan.bmlogger.form.loggermain;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "日志主表")
public class LoggerMainDeleteForm implements Serializable {

	@ApiModelProperty(value = "日志主键", required = true)
	@NotEmpty(message = "日志主键不能为空")
	private String id;

}