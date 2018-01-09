package cn.itsoha.service;

import cn.itsoha.domain.LinkMan;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
    void save(LinkMan linkMan);

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    LinkMan getById(Long lkm_id);
}
