package cn.itsoha.web.action;

import cn.itsoha.domain.User;
import cn.itsoha.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    @Resource(name = "userService")
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

        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "registError";
        }
        return "toLogin";
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        return user;
    }
}
