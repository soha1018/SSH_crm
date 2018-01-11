package cn.itsoha.service.impl;

import cn.itsoha.dao.BaseDictDao;
import cn.itsoha.domain.BaseDict;
import cn.itsoha.service.BasedictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("dictService")
public class BaseditcServiceImpl implements BasedictService {
    @Resource(name = "dictDao")
    private BaseDictDao dictDao;
    @Override

    public List<BaseDict> getTypeCode(String dict_type_code) {
        return dictDao.getDictTypeCode(dict_type_code);
    }

    public BaseDictDao getDictDao() {
        return dictDao;
    }

    public void setDictDao(BaseDictDao dictDao) {
        this.dictDao = dictDao;
    }
}
