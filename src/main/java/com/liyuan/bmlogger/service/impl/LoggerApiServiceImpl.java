package com.liyuan.bmlogger.service.impl;

import com.liyuan.bmlogger.domain.po.loggerapi.LoggerApiPo;
import com.liyuan.bmlogger.domain.condition.loggerapi.LoggerApiCondition;
import com.liyuan.bmlogger.mapper.LoggerApiMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.service.LoggerApiService;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.liyuan.bmlogger.domain.po.loggerapi")
public class LoggerApiServiceImpl extends BaseServiceImpl<LoggerApiPo, LoggerApiCondition, LoggerApiMapper> implements LoggerApiService {

    @Override
    @Cacheable(key = "#id")
    public LoggerApiPo queryWithValid(Object id) throws bmloggerException {
        return super.queryWithValid(id);
    }
}