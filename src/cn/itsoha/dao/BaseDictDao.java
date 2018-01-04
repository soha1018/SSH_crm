package cn.itsoha.dao;

import cn.itsoha.domain.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDict> {
    List<BaseDict> getDictTypeCode(String dict_type_code);
}
