package com.liyuan.bmlogger.form.authuser;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "授权用户表")
public class AuthUserDeleteForm implements Serializable {

	@ApiModelProperty(value = "用户编号", required = true)
	@NotEmpty(message = "用户编号不能为空")
	private String userCode;

}