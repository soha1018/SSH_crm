package cn.itsoha.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    void saveOrUpdate(T t);

    void save(T t);

    void deleteById(Serializable id);

    void delete(T t);

    void update(T t);

    T getById(Serializable id);

    Integer getTotalCount(DetachedCriteria dc);

    List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
