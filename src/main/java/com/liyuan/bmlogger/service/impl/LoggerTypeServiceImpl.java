package com.liyuan.bmlogger.service.impl;

import com.liyuan.bmlogger.domain.po.loggertype.LoggerTypePo;
import com.liyuan.bmlogger.domain.condition.loggertype.LoggerTypeCondition;
import com.liyuan.bmlogger.mapper.LoggerTypeMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.service.LoggerTypeService;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.liyuan.bmlogger.domain.po.loggertype")
public class LoggerTypeServiceImpl extends BaseServiceImpl<LoggerTypePo, LoggerTypeCondition, LoggerTypeMapper> implements LoggerTypeService {

    @Override
    @Cacheable(key = "#id")
    public LoggerTypePo queryWithValid(Object id) throws bmloggerException {
        return super.queryWithValid(id);
    }
}