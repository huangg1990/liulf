package com.liulf.crm.modular.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.modular.crm.dao.ManufacturerSalesDao;
import com.liulf.crm.modular.crm.entity.ManufacturerSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerSalesService extends BaseService {

    @Autowired
    ManufacturerSalesDao manufacturerSalesDao;

    public void save(ManufacturerSales entity) {
        manufacturerSalesDao.save(entity);
    }

    public void update(ManufacturerSales entity) {
        manufacturerSalesDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid) {
        manufacturerSalesDao.deleteById(ids, userid);
    }

    public ManufacturerSales getById(Long id) {
        return manufacturerSalesDao.getById(id);
    }


    public Long getPageCount(ManufacturerSales entity) {

        return manufacturerSalesDao.getPageCount(entity);
    }

    public List<ManufacturerSales> getPageList(Page page, ManufacturerSales entity) {
        return manufacturerSalesDao.getPageList(page, entity);
    }
}
