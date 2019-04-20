package com.liulf.crm.modular.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.modular.crm.dao.ManufacturerDao;
import com.liulf.crm.modular.crm.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService  extends BaseService{

    @Autowired
    ManufacturerDao manufacturerDao;

    public void save(Manufacturer entity){
        manufacturerDao.save(entity);
    }

    public void update(Manufacturer entity){
        manufacturerDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        manufacturerDao.deleteById(ids,userid);
    }

    public Manufacturer getById(Long id){
        return manufacturerDao.getById(id);
    }

    public List<Manufacturer> getListByArea(String areaCode){
        return manufacturerDao.getListByArea(areaCode);

    }

    public Long getPageCount(Manufacturer entity){

        return manufacturerDao.getPageCount(entity);
    }

    public List<Manufacturer> getPageList(Page page , Manufacturer entity){
        return manufacturerDao.getPageList(page,entity);
    }
}
