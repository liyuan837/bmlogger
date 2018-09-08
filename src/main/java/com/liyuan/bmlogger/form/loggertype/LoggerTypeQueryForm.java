package com.liyuan.bmlogger.form.loggertype;

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
@ApiModel(description = "日志类型")
public class LoggerTypeQueryForm extends BaseQueryForm implements Serializable {

	@ApiModelProperty(value = "日志类型主键")
	private Integer id;

	@ApiModelProperty(value = "日志类型主键列表")
	private List<Integer> idList;

	@ApiModelProperty(value = "类型名称")
	private String name;

	@ApiModelProperty(value = "描述")
	private String description;

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

	@ApiModelProperty(value = "状态，1有效，0无效，-1删除")
	private Integer state;

	@ApiModelProperty(value = "所有者")
	private String userCode;

}