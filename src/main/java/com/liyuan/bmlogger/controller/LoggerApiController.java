package com.liyuan.bmlogger.controller;

import com.liyuan.bmlogger.domain.po.loggerapi.LoggerApiPo;
import com.liyuan.bmlogger.domain.condition.loggerapi.LoggerApiCondition;
import com.liyuan.bmlogger.form.loggerapi.*;
import com.liyuan.bmlogger.vo.loggerapi.LoggerApiVo;
import com.liyuan.bmlogger.service.LoggerApiService;
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
import java.util.UUID;

@RestController
@RequestMapping("/loggerapi")
@Api(value = "/loggerapi", description = "接口日志")
public class LoggerApiController extends BaseController {

	@Autowired
	private LoggerApiService loggerApiService;

	@ApiOperation(value = "查询接口日志",notes = "根据ID查询接口日志",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<LoggerApiVo> query(@ApiParam(value = "日志编号", required = true)@RequestParam String id) throws bmloggerException {
		LoggerApiPo po = loggerApiService.queryWithValid(id);
		LoggerApiVo vo = CopyUtil.transfer(po, LoggerApiVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询接口日志数量",notes = "查询接口日志数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid LoggerApiQueryForm form) throws bmloggerException {
		LoggerApiCondition condition = CopyUtil.transfer(form, LoggerApiCondition.class);
		int count = loggerApiService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询接口日志列表",notes = "查询接口日志列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<LoggerApiVo>> queryList(@RequestBody@Valid LoggerApiQueryForm form) throws bmloggerException {
		LoggerApiCondition condition = CopyUtil.transfer(form, LoggerApiCondition.class);
		List<LoggerApiPo> poList = loggerApiService.queryList(condition);
		List<LoggerApiVo> voList = CopyUtil.transfer(poList, LoggerApiVo.class);
		return getSuccessResult(voList);
	}

	@ApiOperation(value = "查询接口日志列表(带分页)",notes = "查询接口日志列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<LoggerApiVo>> queryPageList(@RequestBody@Valid LoggerApiQueryForm form) throws bmloggerException {
		LoggerApiCondition condition = CopyUtil.transfer(form, LoggerApiCondition.class);
		List<LoggerApiVo> voList = new ArrayList<>();
		int count = loggerApiService.queryCount(condition);
		if (count > 0) {
			List<LoggerApiPo> poList = loggerApiService.queryList(condition);
			voList = CopyUtil.transfer(poList, LoggerApiVo.class);
		}
		return getSuccessResult(getPageListResponse(condition.getPageNum(),condition.getPageSize(),count,voList));
	}

	@ApiOperation(value = "新增接口日志",notes = "新增接口日志",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<LoggerApiVo> add(@RequestBody@Valid LoggerApiCreateForm form) throws bmloggerException {
		LoggerApiPo po = CopyUtil.transfer(form, LoggerApiPo.class);
		po.setId(UUID.randomUUID().toString());
		po.setAddTime(new Date());
		loggerApiService.insert(po);
		LoggerApiVo vo = CopyUtil.transfer(po, LoggerApiVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改接口日志",notes = "修改接口日志",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid LoggerApiUpdateForm form) throws bmloggerException {
		LoggerApiPo po = CopyUtil.transfer(form, LoggerApiPo.class);
		loggerApiService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除接口日志",notes = "删除接口日志",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid LoggerApiDeleteForm form) throws bmloggerException {
		loggerApiService.delete(form.getId());
		return getSuccessResult();
	}

	/**
	 * LoggerApiQueryForm转换为LoggerApiCondition
	 *
	 * @param form
	 * @return
	 */
	private LoggerApiCondition getConditionByQueryForm(LoggerApiQueryForm form) {
		LoggerApiCondition condition = CopyUtil.transfer(form, LoggerApiCondition.class);
		return condition;
	}

}