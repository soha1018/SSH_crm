package cn.itsoha.dao.impl;

import cn.itsoha.dao.LinkManDao;
import cn.itsoha.domain.LinkMan;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("linkManDao")
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {
    @Resource(name = "sessionFactory")
    public void setSF(SessionFactory factory) {
        super.setSessionFactory(factory);
    }
}
