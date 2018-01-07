package cn.itsoha.service;

import cn.itsoha.domain.Customer;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(Customer customer);

    Customer getById(Long cust_id);
}
