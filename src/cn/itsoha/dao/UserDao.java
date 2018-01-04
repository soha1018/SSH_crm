package cn.itsoha.dao;

import cn.itsoha.domain.User;

public interface UserDao extends BaseDao<User> {

    User findByUserCode(User user);

}
