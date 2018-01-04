package cn.itsoha.dao.impl;

import cn.itsoha.dao.UserDao;
import cn.itsoha.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public User findByUserCode(User user) {

        return getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where user_code=?";
                Query query = session.createQuery(hql);
                query.setParameter(0, user.getUser_code());
                return (User) query.uniqueResult();
            }
        });
    }
}
