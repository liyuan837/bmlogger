package com.liyuan.bmlogger.controller;

import com.liyuan.bmlogger.domain.po.loggertype.LoggerTypePo;
import com.liyuan.bmlogger.domain.condition.loggertype.LoggerTypeCondition;
import com.liyuan.bmlogger.form.loggertype.*;
import com.liyuan.bmlogger.vo.loggertype.LoggerTypeVo;
import com.liyuan.bmlogger.service.LoggerTypeService;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.util.CopyUtil;
import com.liyuan.bmlogger.domain.response.ResponseEntity;
import com.liyuan.bmlogger.domain.response.PageListResponse;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

@RestController
@RequestMapping("/loggertype")
@Api(value = "/loggertype", description = "日志类型")
public class LoggerTypeController extends BaseController {

	@Autowired
	private LoggerTypeService loggerTypeService;

	@ApiOperation(value = "查询日志类型",notes = "根据ID查询日志类型",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<LoggerTypeVo> query(@ApiParam(value = "日志类型主键", required = true)@RequestParam Integer id) throws bmloggerException {
		LoggerTypePo po = loggerTypeService.queryWithValid(id);
		LoggerTypeVo vo = CopyUtil.transfer(po, LoggerTypeVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询日志类型数量",notes = "查询日志类型数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid LoggerTypeQueryForm form) throws bmloggerException {
		LoggerTypeCondition condition = CopyUtil.transfer(form, LoggerTypeCondition.class);
		int count = loggerTypeService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询日志类型列表",notes = "查询日志类型列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<LoggerTypeVo>> queryList(@RequestBody@Valid LoggerTypeQueryForm form) throws bmloggerException {
		LoggerTypeCondition condition = CopyUtil.transfer(form, LoggerTypeCondition.class);
		List<LoggerTypePo> poList = loggerTypeService.queryList(condition);
		List<LoggerTypeVo> voList = CopyUtil.transfer(poList, LoggerTypeVo.class);
		return getSuccessResult(voList);
	}

	@ApiOperation(value = "查询日志类型列表(带分页)",notes = "查询日志类型列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<LoggerTypeVo>> queryPageList(@RequestBody@Valid LoggerTypeQueryForm form) throws bmloggerException {
		LoggerTypeCondition condition = CopyUtil.transfer(form, LoggerTypeCondition.class);
		List<LoggerTypeVo> voList = new ArrayList<>();
		int count = loggerTypeService.queryCount(condition);
		if (count > 0) {
			List<LoggerTypePo> poList = loggerTypeService.queryList(condition);
			voList = CopyUtil.transfer(poList, LoggerTypeVo.class);
		}
		return getSuccessResult(getPageListResponse(condition.getPageNum(),condition.getPageSize(),count,voList));
	}

	@ApiOperation(value = "新增日志类型",notes = "新增日志类型",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<LoggerTypeVo> add(@RequestBody@Valid LoggerTypeCreateForm form) throws bmloggerException {
		LoggerTypePo po = CopyUtil.transfer(form, LoggerTypePo.class);
		po.setAddTime(new Date());
		loggerTypeService.insert(po);
		LoggerTypeVo vo = CopyUtil.transfer(po, LoggerTypeVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改日志类型",notes = "修改日志类型",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid LoggerTypeUpdateForm form) throws bmloggerException {
		LoggerTypePo po = CopyUtil.transfer(form, LoggerTypePo.class);
		po.setOptTime(new Date());
		loggerTypeService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除日志类型",notes = "删除日志类型",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid LoggerTypeDeleteForm form) throws bmloggerException {
		loggerTypeService.delete(form.getId());
		return getSuccessResult();
	}

	/**
	 * LoggerTypeQueryForm转换为LoggerTypeCondition
	 *
	 * @param form
	 * @return
	 */
	private LoggerTypeCondition getConditionByQueryForm(LoggerTypeQueryForm form) {
		LoggerTypeCondition condition = CopyUtil.transfer(form, LoggerTypeCondition.class);
		return condition;
	}

}