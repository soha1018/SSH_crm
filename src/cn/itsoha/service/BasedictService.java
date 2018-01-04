package cn.itsoha.service;

import cn.itsoha.domain.BaseDict;

import java.util.List;

public interface BasedictService {
    List<BaseDict> getTypeCode(String dict_type_code);
}
