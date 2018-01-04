package cn.itsoha.service.impl;

import cn.itsoha.dao.UserDao;
import cn.itsoha.domain.User;
import cn.itsoha.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public User getUserByUserCode(User user) {
        User userCode = userDao.findByUserCode(user);
        if (userCode == null) {
            throw new RuntimeException("用户名不存在");
        }
        if (!userCode.getUser_password().equals(user.getUser_password())) {
            throw new RuntimeException("密码错误");
        }
        return userCode;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void login(User user) {
        userDao.save(user);
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
