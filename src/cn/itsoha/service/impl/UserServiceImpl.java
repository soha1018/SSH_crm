package cn.itsoha.service.impl;

import cn.itsoha.dao.UserDao;
import cn.itsoha.domain.User;
import cn.itsoha.service.UserService;
import cn.itsoha.utils.MD5Utils;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public User getUserByUserCode(User user) {
        User userCode = userDao.findByUserCode(user);
        if (userCode == null) {
            throw new RuntimeException("用户名不存在");
        }

        if (!userCode.getUser_password().equals(MD5Utils.md5(user.getUser_password()))) {
            throw new RuntimeException("密码错误");
        }
        return userCode;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void saveUser(User user) {
        if (!StringUtils.isNotBlank(user.getUser_code())) {
            throw new RuntimeException("用户名不能为空");
        }
        if (!StringUtils.isNotBlank(user.getUser_password())) {
            throw new RuntimeException("密码不能为空");
        }
        if (!StringUtils.isNotBlank(user.getUser_name())) {
            throw new RuntimeException("昵称不能为空");
        }
        User userCode = userDao.findByUserCode(user);
        if (userCode != null) {
            throw new RuntimeException("用户名已经存在");
        }
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        userDao.save(user);
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
