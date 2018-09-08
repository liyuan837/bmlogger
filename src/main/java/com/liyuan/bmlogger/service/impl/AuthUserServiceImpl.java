package com.liyuan.bmlogger.service.impl;

import com.liyuan.bmlogger.domain.po.authuser.AuthUserPo;
import com.liyuan.bmlogger.domain.condition.authuser.AuthUserCondition;
import com.liyuan.bmlogger.mapper.AuthUserMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.service.AuthUserService;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.liyuan.bmlogger.domain.po.authuser")
public class AuthUserServiceImpl extends BaseServiceImpl<AuthUserPo, AuthUserCondition, AuthUserMapper> implements AuthUserService {

    @Override
    @Cacheable(key = "#id")
    public AuthUserPo queryWithValid(Object id) throws bmloggerException {
        return super.queryWithValid(id);
    }
}