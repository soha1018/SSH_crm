package cn.itsoha.web.action;

import cn.itsoha.domain.Customer;
import cn.itsoha.service.CustomerService;
import cn.itsoha.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage;
    private Integer pageSize;

    public String list() throws Exception{
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNotBlank(customer.getCust_name())) {
            dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        PageBean bean = customerService.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pagebean",bean);
        return "list";
    }
    @Override
    public Customer getModel() {
        return customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
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
