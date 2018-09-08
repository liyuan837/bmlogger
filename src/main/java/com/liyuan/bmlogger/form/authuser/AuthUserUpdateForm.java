package com.liyuan.bmlogger.form.authuser;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import com.liyuan.bmlogger.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "授权用户表")
public class AuthUserUpdateForm implements Serializable {

	@ApiModelProperty(value = "用户编号", required = true)
	@NotEmpty(message = "用户编号不能为空")
	private String userCode;

	@ApiModelProperty(value = "用户姓名")
	private String name;

	@ApiModelProperty(value = "授权码")
	private String authCode;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private String optUserCode;

	@ApiModelProperty(value = "授权时间,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date authTime;

}