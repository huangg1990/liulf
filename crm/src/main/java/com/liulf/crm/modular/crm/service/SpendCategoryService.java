package com.liulf.crm.modular.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.modular.crm.dao.SpendCategoryDao;
import com.liulf.crm.modular.crm.entity.SpendCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendCategoryService extends BaseService {

    @Autowired
    SpendCategoryDao SpendCategoryDao;

    public void save(SpendCategory entity){
        SpendCategoryDao.save(entity);
    }

    public void update(SpendCategory entity){
         SpendCategoryDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        SpendCategoryDao.deleteById(ids,userid);
    }

    public SpendCategory getById(Long id){
       return SpendCategoryDao.getById(id);
    }

    public List<SpendCategory> getAllList(){
        return SpendCategoryDao.getAllList();

    }

    public Long getPageCount(SpendCategory entity){

        return SpendCategoryDao.getPageCount(entity);
    }

    public List<SpendCategory> getPageList(Page page , SpendCategory entity){
        return SpendCategoryDao.getPageList(page,entity);
    }

}
