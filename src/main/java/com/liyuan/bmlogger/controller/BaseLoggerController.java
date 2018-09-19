package com.liyuan.bmlogger.controller;

import com.github.pagehelper.util.StringUtil;
import com.liyuan.bmlogger.domain.condition.authuser.AuthUserCondition;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.domain.po.authuser.AuthUserPo;
import com.liyuan.bmlogger.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseLoggerController extends BaseController{
    @Autowired
    private AuthUserService authUserService;

    protected AuthUserPo checkAuthCode(String authCode){
        if(StringUtil.isEmpty(authCode)){
            throw new bmloggerException("授权码不能为空");
        }else{
            AuthUserCondition condition = new AuthUserCondition();
            condition.setAuthCode(authCode);
            List<AuthUserPo> poList = authUserService.queryList(condition);
            if(poList == null || poList.size() <= 0){
                throw new bmloggerException("无效授权码");
            }else{
                return poList.get(0);
            }
        }
    }
}
