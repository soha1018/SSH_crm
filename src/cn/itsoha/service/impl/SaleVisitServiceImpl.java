package cn.itsoha.service.impl;

import cn.itsoha.dao.SaleVisitDao;
import cn.itsoha.domain.SaleVisit;
import cn.itsoha.service.SaleVisitService;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("saleVisitService")
public class SaleVisitServiceImpl implements SaleVisitService {
    @Resource(name = "saleVisitDao")
    private SaleVisitDao dao;
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void save(SaleVisit saleVisit) {
        dao.saveOrUpdate(saleVisit);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //先去查总数
        Integer totalCount = dao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
        List<SaleVisit> list = dao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public SaleVisit getById(Integer visit_id) {
        return dao.getById(visit_id);
    }

    public SaleVisitDao getDao() {
        return dao;
    }

    public void setDao(SaleVisitDao dao) {
        this.dao = dao;
    }
}
