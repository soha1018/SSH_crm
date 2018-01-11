package cn.itsoha.service.impl;


import cn.itsoha.dao.LinkManDao;
import cn.itsoha.domain.LinkMan;
import cn.itsoha.service.LinkManService;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("linkManService")
public class LinkServiceImpl implements LinkManService {
    @Resource(name = "linkManDao")
    private LinkManDao dao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void save(LinkMan linkMan) {
        dao.saveOrUpdate(linkMan);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer count = dao.getTotalCount(dc);
        PageBean pb = new PageBean(currentPage, count, pageSize);
        List<LinkMan> list = dao.getPageList(dc, pb.getStart(), pb.getPageSize());
        pb.setList(list);
        return pb;
    }

    @Override
    public LinkMan getById(Long lkm_id) {
        return dao.getById(lkm_id);
    }

    public LinkManDao getDao() {
        return dao;
    }

    public void setDao(LinkManDao dao) {
        this.dao = dao;
    }
}
