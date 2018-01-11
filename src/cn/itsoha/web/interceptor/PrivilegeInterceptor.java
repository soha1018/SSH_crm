package cn.itsoha.web.interceptor;

import cn.itsoha.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 对用户权限拦截
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user != null) {
            return actionInvocation.invoke();
        } else {
            return "toLogin";
        }
    }
}
