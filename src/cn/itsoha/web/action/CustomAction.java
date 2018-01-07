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

import java.io.File;

public class CustomAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage;
    private Integer pageSize;
    private File photo;
    private String photoFileName;

    public String list() throws Exception {
        //创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNotBlank(customer.getCust_name())) {
            dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        PageBean bean = customerService.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pagebean", bean);
        return "list";
    }

    /**
     * 添加客户
     */
    public String save() throws Exception {
        //图片保存
        if (photo != null) {
            photo.renameTo(new File("E:/upload/" + photoFileName));
        }
        customerService.save(customer);
        return "toList";
    }


    /**
     * 修改客户
     */
    public String toEdit() throws Exception {
        Customer serviceById = customerService.getById(customer.getCust_id());
        ActionContext.getContext().put("customer",serviceById);
        return "edit";
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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

}
