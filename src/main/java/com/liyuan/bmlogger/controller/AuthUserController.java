package com.liyuan.bmlogger.controller;

import com.liyuan.bmlogger.domain.condition.authuser.AuthUserCondition;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.domain.po.authuser.AuthUserPo;
import com.liyuan.bmlogger.domain.response.PageListResponse;
import com.liyuan.bmlogger.domain.response.ResponseEntity;
import com.liyuan.bmlogger.form.authuser.AuthUserCreateForm;
import com.liyuan.bmlogger.form.authuser.AuthUserDeleteForm;
import com.liyuan.bmlogger.form.authuser.AuthUserQueryForm;
import com.liyuan.bmlogger.form.authuser.AuthUserUpdateForm;
import com.liyuan.bmlogger.service.AuthUserService;
import com.liyuan.bmlogger.util.CopyUtil;
import com.liyuan.bmlogger.vo.authuser.AuthUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/authuser")
@Api(value = "/authuser", description = "授权用户表")
public class AuthUserController extends BaseController {

	@Autowired
	private AuthUserService authUserService;

	@ApiOperation(value = "查询授权用户表",notes = "根据ID查询授权用户表",httpMethod = "GET")
	@GetMapping(value = "/query")
	public ResponseEntity<AuthUserVo> query(@ApiParam(value = "用户编号", required = true)@RequestParam String userCode) throws bmloggerException {
		AuthUserPo po = authUserService.queryWithValid(userCode);
		AuthUserVo vo = CopyUtil.transfer(po, AuthUserVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询授权用户表数量",notes = "查询授权用户表数量",httpMethod = "POST")
	@PostMapping(value = "/queryCount")
	public ResponseEntity<Integer> queryCount(@RequestBody@Valid AuthUserQueryForm form) throws bmloggerException {
		AuthUserCondition condition = CopyUtil.transfer(form, AuthUserCondition.class);
		int count = authUserService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询授权用户表列表",notes = "查询授权用户表列表",httpMethod = "POST")
	@PostMapping(value = "/queryList")
	public ResponseEntity<PageListResponse<AuthUserVo>> queryList(@RequestBody@Valid AuthUserQueryForm form) throws bmloggerException {
		AuthUserCondition condition = CopyUtil.transfer(form, AuthUserCondition.class);
		List<AuthUserPo> poList = authUserService.queryList(condition);
		List<AuthUserVo> voList = CopyUtil.transfer(poList, AuthUserVo.class);
		return getSuccessResult(voList);
	}

	@ApiOperation(value = "查询授权用户表列表(带分页)",notes = "查询授权用户表列表(带分页)",httpMethod = "POST")
	@PostMapping(value = "/queryPageList")
	public ResponseEntity<PageListResponse<AuthUserVo>> queryPageList(@RequestBody@Valid AuthUserQueryForm form) throws bmloggerException {
		AuthUserCondition condition = CopyUtil.transfer(form, AuthUserCondition.class);
		List<AuthUserVo> voList = new ArrayList<>();
		int count = authUserService.queryCount(condition);
		if (count > 0) {
			List<AuthUserPo> poList = authUserService.queryList(condition);
			voList = CopyUtil.transfer(poList, AuthUserVo.class);
		}
		return getSuccessResult(getPageListResponse(condition.getPageNum(),condition.getPageSize(),count,voList));
	}

	@ApiOperation(value = "新增授权用户表",notes = "新增授权用户表",httpMethod = "POST")
	@PostMapping(value = "/add")
	public ResponseEntity<AuthUserVo> add(@RequestBody@Valid AuthUserCreateForm form) throws bmloggerException {
		AuthUserPo po = CopyUtil.transfer(form, AuthUserPo.class);
		po.setAddTime(new Date());
		authUserService.insert(po);
		AuthUserVo vo = CopyUtil.transfer(po, AuthUserVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改授权用户表",notes = "修改授权用户表",httpMethod = "POST")
	@PostMapping(value = "/update")
	public ResponseEntity update(@RequestBody@Valid AuthUserUpdateForm form) throws bmloggerException {
		AuthUserPo po = CopyUtil.transfer(form, AuthUserPo.class);
		po.setOptTime(new Date());
		authUserService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除授权用户表",notes = "删除授权用户表",httpMethod = "POST")
	@PostMapping(value = "/delete")
	public ResponseEntity delete(@RequestBody@Valid AuthUserDeleteForm form) throws bmloggerException {
		authUserService.delete(form.getUserCode());
		return getSuccessResult();
	}

	/**
	 * AuthUserQueryForm转换为AuthUserCondition
	 *
	 * @param form
	 * @return
	 */
	private AuthUserCondition getConditionByQueryForm(AuthUserQueryForm form) {
		AuthUserCondition condition = CopyUtil.transfer(form, AuthUserCondition.class);
		return condition;
	}

}