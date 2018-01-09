package cn.itsoha.web.action;

import cn.itsoha.domain.Customer;
import cn.itsoha.domain.LinkMan;
import cn.itsoha.service.LinkManService;
import cn.itsoha.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
    private LinkMan linkMan = new LinkMan();
    private LinkManService service;
    private Integer currentPage;
    private Integer pageSize;

    public String save() throws Exception{
        service.save(linkMan);
        return "toList";
    }

    public String list()  throws Exception {
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
            dc.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
        }
        if (linkMan.getCustomer() != null&&linkMan.getCustomer().getCust_id()!=null) {
            dc.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id()));
        }
        PageBean bean = service.getPageBean(dc,currentPage,pageSize);
        System.out.println(bean);
        ActionContext.getContext().put("linkBean",bean);
        return "list";
    }

    public String toEdit() throws Exception {
        if (linkMan.getLkm_id() != null) {
            LinkMan lm = service.getById(linkMan.getLkm_id());
            ActionContext.getContext().put("lkm",lm);
        }
        return "edit";
    }

    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public LinkManService getService() {
        return service;
    }

    public void setService(LinkManService service) {
        this.service = service;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
