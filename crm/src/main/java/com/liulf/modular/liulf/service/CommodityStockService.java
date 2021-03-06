package com.liulf.modular.liulf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.modular.liulf.entity.CommodityStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityStockService extends BaseService {

    @Autowired
    com.liulf.modular.liulf.dao.CommodityStockDao CommodityStockDao;

    public void save(CommodityStock entity){
        CommodityStockDao.save(entity);
    }

    public void update(CommodityStock entity){
         CommodityStockDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        CommodityStockDao.deleteById(ids,userid);
    }

    public CommodityStock getById(Long id){
       return CommodityStockDao.getById(id);
    }


    public Long getPageCount(CommodityStock entity){

        return CommodityStockDao.getPageCount(entity);
    }

    public List<CommodityStock> getPageList(Page page , CommodityStock entity){
        return CommodityStockDao.getPageList(page,entity);
    }

}
