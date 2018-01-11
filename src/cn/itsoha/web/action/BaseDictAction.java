package cn.itsoha.web.action;

import cn.itsoha.domain.BaseDict;
import cn.itsoha.service.BasedictService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("baseDictAction")
@Scope("prototype")
public class BaseDictAction extends ActionSupport {
    private String dict_type_code;
    @Resource(name = "dictService")
    private BasedictService dictService;

    public String execute() throws Exception {
        List<BaseDict> list = dictService.getTypeCode(dict_type_code);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public BasedictService getDictService() {
        return dictService;
    }

    public void setDictService(BasedictService dictService) {
        this.dictService = dictService;
    }
}
