package cn.itsoha.service;

import cn.itsoha.domain.User;

public interface UserService {
    User getUserByUserCode(User user);

    void saveUser(User user);
}
