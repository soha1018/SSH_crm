package cn.itsoha.dao.impl;

import cn.itsoha.dao.SaleVisitDao;
import cn.itsoha.domain.SaleVisit;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("saleVisitDao")
public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements SaleVisitDao {
    @Resource(name = "sessionFactory")
    public void setSF(SessionFactory factory) {
        super.setSessionFactory(factory);
    }
}
