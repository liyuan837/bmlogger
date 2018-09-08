package com.liyuan.bmlogger.controller;

import com.liyuan.bmlogger.domain.po.loggermain.LoggerMainPo;
import com.liyuan.bmlogger.domain.condition.loggermain.LoggerMainCondition;
import com.liyuan.bmlogger.form.loggermain.*;
import com.liyuan.bmlogger.vo.loggermain.LoggerMainVo;
import com.liyuan.bmlogger.service.LoggerMainService;
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
@RequestMapping("/loggermain")
@Api(value = "/loggermain", description = "日志主表")
public class LoggerMainController extends BaseController {

	@Autowired
	private LoggerMainService loggerMainService;

	@ApiOperation(value = "查询日志主表",notes = "根据ID查询日志主表",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<LoggerMainVo> query(@ApiParam(value = "日志主键", required = true)@RequestParam String id) throws bmloggerException {
		LoggerMainPo po = loggerMainService.queryWithValid(id);
		LoggerMainVo vo = CopyUtil.transfer(po, LoggerMainVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询日志主表数量",notes = "查询日志主表数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid LoggerMainQueryForm form) throws bmloggerException {
		LoggerMainCondition condition = CopyUtil.transfer(form, LoggerMainCondition.class);
		int count = loggerMainService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询日志主表列表",notes = "查询日志主表列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<LoggerMainVo>> queryList(@RequestBody@Valid LoggerMainQueryForm form) throws bmloggerException {
		LoggerMainCondition condition = CopyUtil.transfer(form, LoggerMainCondition.class);
		List<LoggerMainPo> poList = loggerMainService.queryList(condition);
		List<LoggerMainVo> voList = CopyUtil.transfer(poList, LoggerMainVo.class);
		return getSuccessResult(voList);
	}

	@ApiOperation(value = "查询日志主表列表(带分页)",notes = "查询日志主表列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<LoggerMainVo>> queryPageList(@RequestBody@Valid LoggerMainQueryForm form) throws bmloggerException {
		LoggerMainCondition condition = CopyUtil.transfer(form, LoggerMainCondition.class);
		List<LoggerMainVo> voList = new ArrayList<>();
		int count = loggerMainService.queryCount(condition);
		if (count > 0) {
			List<LoggerMainPo> poList = loggerMainService.queryList(condition);
			voList = CopyUtil.transfer(poList, LoggerMainVo.class);
		}
		return getSuccessResult(getPageListResponse(condition.getPageNum(),condition.getPageSize(),count,voList));
	}

	@ApiOperation(value = "新增日志主表",notes = "新增日志主表",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<LoggerMainVo> add(@RequestBody@Valid LoggerMainCreateForm form) throws bmloggerException {
		LoggerMainPo po = CopyUtil.transfer(form, LoggerMainPo.class);
		po.setAddTime(new Date());
		loggerMainService.insert(po);
		LoggerMainVo vo = CopyUtil.transfer(po, LoggerMainVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改日志主表",notes = "修改日志主表",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid LoggerMainUpdateForm form) throws bmloggerException {
		LoggerMainPo po = CopyUtil.transfer(form, LoggerMainPo.class);
		loggerMainService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除日志主表",notes = "删除日志主表",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid LoggerMainDeleteForm form) throws bmloggerException {
		loggerMainService.delete(form.getId());
		return getSuccessResult();
	}

	/**
	 * LoggerMainQueryForm转换为LoggerMainCondition
	 *
	 * @param form
	 * @return
	 */
	private LoggerMainCondition getConditionByQueryForm(LoggerMainQueryForm form) {
		LoggerMainCondition condition = CopyUtil.transfer(form, LoggerMainCondition.class);
		return condition;
	}

}