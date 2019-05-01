package com.liulf.modular.liulf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.modular.liulf.dao.CommodityCategoryDao;
import com.liulf.modular.liulf.entity.CommodityCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityCategoryService extends BaseService {

    @Autowired
    CommodityCategoryDao commodityCategoryDao;

    public void save(CommodityCategory entity){
        commodityCategoryDao.save(entity);
    }

    public void update(CommodityCategory entity){
         commodityCategoryDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        commodityCategoryDao.deleteById(ids,userid);
    }

    public CommodityCategory getById(Long id){
       return commodityCategoryDao.getById(id);
    }

    public List<CommodityCategory> getAllList(){
        return commodityCategoryDao.getAllList();

    }

    public Long getPageCount(CommodityCategory entity){

        return commodityCategoryDao.getPageCount(entity);
    }

    public List<CommodityCategory> getPageList(Page page , CommodityCategory entity){
        return commodityCategoryDao.getPageList(page,entity);
    }

}
