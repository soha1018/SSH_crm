package cn.itsoha.dao.impl;

import cn.itsoha.dao.CustomerDao;
import cn.itsoha.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

    @Resource(name = "sessionFactory")
    public void setSF(SessionFactory factory) {
        super.setSessionFactory(factory);
    }
    @Override
    public List<Object[]> getIndustryCount() {
        return getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                String sql = "select b.dict_item_name,count(*) total from base_dict b,cst_customer c where b.dict_id=c.cust_industry group by c.cust_industry";
                SQLQuery query = session.createSQLQuery(sql);
                return query.list();
            }
        });
    }
}
