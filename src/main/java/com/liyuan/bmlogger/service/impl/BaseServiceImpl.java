package com.liyuan.bmlogger.service.impl;

import com.liyuan.bmlogger.util.PageHelperUtil;
import com.liyuan.bmlogger.domain.condition.BaseCondition;
import com.liyuan.bmlogger.mapper.BaseMapper;
import com.liyuan.bmlogger.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.liyuan.bmlogger.domain.exception.bmloggerException;
import java.util.List;

public abstract class BaseServiceImpl<T, C extends BaseCondition, M extends BaseMapper<T, C>> implements BaseService<T, C> {
    @Autowired
    private M mapper;

    @Override
    public T query(Object id) {
        T o = mapper.select(id);
        return o;
    }

    @Override
    public T queryWithValid(Object id) throws bmloggerException {
        T o = mapper.select(id);
        if (o == null) {
            throw new bmloggerException(id + "对应的记录为空");
        }
        return o;
    }

    @Override
    public List<T> queryList(C condition) {
        PageHelperUtil.startPage(condition.getPageNum(), condition.getPageSize(),condition.getOrderBy());
        List<T> list = mapper.selectList(condition);
        return list;
    }

    @Override
    public int queryCount(C condition) {
        PageHelperUtil.startPage(0, 0,null);
        return mapper.count(condition);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(T po) {
        int row = mapper.update(po);
        return row;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateWithValid(T po) throws bmloggerException {
        int row = mapper.update(po);
        if (row == 0) {
            throw new bmloggerException("修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insert(T po) {
        mapper.insert(po);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Object id) {
        mapper.delete(id);
    }


    /**
     * 返回对应的Mapper
     *
     * @return
     */
    protected M getMapper() {
        return mapper;
    }
}
