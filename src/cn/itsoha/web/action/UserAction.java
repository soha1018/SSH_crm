package cn.itsoha.web.action;

import cn.itsoha.domain.User;
import cn.itsoha.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private UserService userService;

    public String login() throws Exception{
        User user = userService.getUserByUserCode(this.user);
        if (user != null) {
            ActionContext.getContext().getSession().put("user", user);
        } else {
            return "loginError";
        }

        return "toHome";
    }

    public String save() throws Exception {
        User user = new User();
        user.setUser_code("hdd");
        user.setUser_name("黄东东");
        user.setUser_password("hdd");
        userService.login(user);
        return "success";
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }
}
