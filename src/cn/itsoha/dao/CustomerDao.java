package cn.itsoha.dao;


import cn.itsoha.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer>{
    List<Object[]> getIndustryCount();
}
