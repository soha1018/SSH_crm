package cn.itsoha.web.action;

import cn.itsoha.domain.SaleVisit;
import cn.itsoha.domain.User;
import cn.itsoha.service.SaleVisitService;
import cn.itsoha.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("saleVisitAction")
@Scope("prototype")
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
    private SaleVisit saleVisit = new SaleVisit();
    @Resource(name = "saleVisitService")
    private SaleVisitService saleVisitService;
    private Integer currentPage;
    private Integer pageSize;

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);

        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
            dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
        }
        PageBean bean =  saleVisitService.getPageBean(dc, currentPage, pageSize);
        System.out.println(bean);
        ActionContext.getContext().put("pageBean",bean);
        return "list";
    }
    public String add() throws Exception{
        User user = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(user);
        saleVisitService.save(saleVisit);
        return "toList";
    }

    public String toEdit() throws Exception {
        if (saleVisit.getVisit_id() != null) {
            SaleVisit visit = saleVisitService.getById(saleVisit.getVisit_id());
            ActionContext.getContext().put("saleVisit",visit);
        }
        return "edit";
    }
    @Override
    public SaleVisit getModel() {
        return saleVisit;
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

    public SaleVisitService getSaleVisitService() {
        return saleVisitService;
    }

    public void setSaleVisitService(SaleVisitService saleVisitService) {
        this.saleVisitService = saleVisitService;
    }

}
