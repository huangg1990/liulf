package com.liulf.modular.liulf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.modular.liulf.dao.CustomerDao;
import com.liulf.modular.liulf.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends BaseService{

    @Autowired
    CustomerDao customerDao;

    public void save(Customer entity){
        customerDao.save(entity);
    }

    public void update(Customer entity){
        customerDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        customerDao.deleteById(ids,userid);
    }

    public Customer getById(Long id){
        return customerDao.getById(id);
    }

    public List<Customer> getListByArea(String areaCode){
        return customerDao.getListByArea(areaCode);

    }

    public Long getPageCount(Customer entity){

        return customerDao.getPageCount(entity);
    }

    public List<Customer> getPageList(Page page , Customer entity){
        return customerDao.getPageList(page,entity);
    }
}
