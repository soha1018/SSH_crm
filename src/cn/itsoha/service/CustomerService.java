package cn.itsoha.service;

import cn.itsoha.domain.Customer;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    List<Object[]> getIndustryCount();

    void save(Customer customer);

    Customer getById(Long cust_id);
}
