package com.liyuan.bmlogger.service.impl;

import com.liyuan.bmlogger.domain.po.loggermain.LoggerMainPo;
import com.liyuan.bmlogger.domain.condition.loggermain.LoggerMainCondition;
import com.liyuan.bmlogger.mapper.LoggerMainMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import com.liyuan.bmlogger.service.LoggerMainService;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.liyuan.bmlogger.domain.po.loggermain")
public class LoggerMainServiceImpl extends BaseServiceImpl<LoggerMainPo, LoggerMainCondition, LoggerMainMapper> implements LoggerMainService {

    @Override
    @Cacheable(key = "#id")
    public LoggerMainPo queryWithValid(Object id) throws bmloggerException {
        return super.queryWithValid(id);
    }
}