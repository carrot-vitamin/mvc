package com.project.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yinshaobo on 2018/5/4
 */
public interface IBaseDao<T extends Serializable, ID extends Serializable> {

    void insert(T t);

    void deleteByPrimaryKey(ID id);

    void delete(Map<String, Object> paramsMap);

    void update(T t);

    T selectByPrimaryKey(ID id);

    T selectOne(ID id);

    T selectOne(Map<String, Object> paramsMap);

    List<T> selectList(Map<String, Object> paramsMap);

    List<T> selectAll();

}
