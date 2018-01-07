package cn.itsoha.service.impl;

import cn.itsoha.dao.CustomerDao;
import cn.itsoha.domain.Customer;
import cn.itsoha.service.CustomerService;
import cn.itsoha.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao;
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //查询总条数
        Integer totalCount = dao.getTotalCount(dc);
        PageBean pb = new PageBean(currentPage,totalCount,pageSize);
        List<Customer> list =  dao.getPageList(dc,pb.getStart(),pb.getPageSize());
        System.out.println("sss::"+list);
        pb.setList(list);

        return pb;
    }

    /**
     * 添加客户
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void save(Customer customer) {
        dao.saveOrUpdate(customer);
    }

    @Override
    public Customer getById(Long cust_id) {
        return dao.getById(cust_id);
    }

    public CustomerDao getDao() {
        return dao;
    }

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }
}
