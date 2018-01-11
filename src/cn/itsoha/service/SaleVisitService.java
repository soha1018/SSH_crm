package cn.itsoha.service;

import cn.itsoha.domain.SaleVisit;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    void save(SaleVisit saleVisit);

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    SaleVisit getById(Integer visit_id);
}
