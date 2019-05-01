package com.liulf.crm.modular.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.modular.crm.dao.CommoditySellDao;
import com.liulf.crm.modular.crm.entity.CommoditySell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditySellService extends BaseService {

    @Autowired
    CommoditySellDao CommoditySellDao;

    public void save(CommoditySell entity){
        CommoditySellDao.save(entity);
    }

    public void update(CommoditySell entity){
         CommoditySellDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        CommoditySellDao.deleteById(ids,userid);
    }

    public CommoditySell getById(Long id){
       return CommoditySellDao.getById(id);
    }


    public Long getPageCount(CommoditySell entity){

        return CommoditySellDao.getPageCount(entity);
    }

    public List<CommoditySell> getPageList(Page page , CommoditySell entity){
        return CommoditySellDao.getPageList(page,entity);
    }

}
