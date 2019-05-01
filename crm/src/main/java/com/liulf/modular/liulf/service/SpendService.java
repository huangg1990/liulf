package com.liulf.modular.liulf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.modular.liulf.entity.Spend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendService extends BaseService {

    @Autowired
    com.liulf.modular.liulf.dao.SpendDao SpendDao;

    public void save(Spend entity){
        SpendDao.save(entity);
    }

    public void update(Spend entity){
         SpendDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid){
        SpendDao.deleteById(ids,userid);
    }

    public Spend getById(Long id){
       return SpendDao.getById(id);
    }


    public Long getPageCount(Spend entity){

        return SpendDao.getPageCount(entity);
    }

    public List<Spend> getPageList(Page page , Spend entity){
        return SpendDao.getPageList(page,entity);
    }

}
