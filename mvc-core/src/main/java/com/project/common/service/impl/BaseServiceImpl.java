package com.project.common.service.impl;

import com.project.common.dao.IBaseDao;
import com.project.common.service.IBaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yinshaobo on 2018/5/4
 */
public abstract class BaseServiceImpl<T extends Serializable, ID extends Serializable>
        implements IBaseService<T, ID> {

    private IBaseDao<T, ID> baseDao;

    public void setBaseDao(IBaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void insert(T t) {
        this.baseDao.insert(t);
    }

    @Override
    public void deleteByPrimaryKey(ID id) {
        this.baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public void delete(Map<String, Object> paramsMap) {
        this.baseDao.delete(paramsMap);
    }

    @Override
    public void update(T t) {
        this.baseDao.update(t);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return this.baseDao.selectByPrimaryKey(id);
    }

    @Override
    public T selectOne(Map<String, Object> paramsMap) {
        return this.baseDao.selectOne(paramsMap);
    }

    @Override
    public List<T> selectList(Map<String, Object> paramsMap) {
        return this.baseDao.selectList(paramsMap);
    }

    @Override
    public List<T> selectAll() {
        return this.baseDao.selectAll();
    }
}
