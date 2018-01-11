package cn.itsoha.dao.impl;

import cn.itsoha.dao.BaseDictDao;
import cn.itsoha.domain.BaseDict;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("dictDao")
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
    @Resource(name = "sessionFactory")
    public void setSF(SessionFactory factory) {
        super.setSessionFactory(factory);
    }

    @Override
    public List<BaseDict> getDictTypeCode(String dict_type_code) {
        DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));
        return (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
    }
}
