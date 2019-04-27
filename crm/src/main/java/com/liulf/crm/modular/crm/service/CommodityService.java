package com.liulf.crm.modular.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liulf.crm.modular.crm.dao.CommodityDao;
import com.liulf.crm.modular.crm.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService extends BaseService {

    @Autowired
    CommodityDao commodityDao;

    public void save(Commodity entity) {
        commodityDao.save(entity);
    }

    public void update(Commodity entity) {
        commodityDao.update(entity);
    }

    public void deleteById(List<Long> ids, Long userid) {
        commodityDao.deleteById(ids, userid);
    }

    public Commodity getById(Long id) {
        return commodityDao.getById(id);
    }

    public List<Commodity> getByCategoryId(String category_id) {
        return commodityDao.getByCategoryId(category_id);

    }

    public Long getPageCount(Commodity entity) {

        return commodityDao.getPageCount(entity);
    }

    public List<Commodity> getPageList(Page page, Commodity entity) {
        return commodityDao.getPageList(page, entity);
    }

}
