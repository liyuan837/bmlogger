package com.liyuan.bmlogger.form.authuser;

import java.io.Serializable;
import java.util.List;
import com.liyuan.bmlogger.form.BaseQueryForm;
import com.liyuan.bmlogger.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "授权用户表")
public class AuthUserQueryForm extends BaseQueryForm implements Serializable {

	@ApiModelProperty(value = "用户编号")
	private String userCode;

	@ApiModelProperty(value = "用户编号列表")
	private List<String> userCodeList;

	@ApiModelProperty(value = "用户姓名")
	private String name;

    @ApiModelProperty(value = "项目编号")
    private Integer projectId;

    @ApiModelProperty(value = "项目名")
    private String projectName;

	@ApiModelProperty(value = "授权码")
	private String authCode;

	@ApiModelProperty(value = "最小,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date minAddTime;

	@ApiModelProperty(value = "最大,格式为:" + DateUtil.FORMAT)
	@DateTimeFormat(pattern = DateUtil.FORMAT)
	private Date maxAddTime;

	@ApiModelProperty(value = "")
	private String addUserCode;

	@ApiModelProperty(value = "")
	private String optUserCode;

}