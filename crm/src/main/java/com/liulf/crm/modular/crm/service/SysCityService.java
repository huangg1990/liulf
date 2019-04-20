package com.liulf.crm.modular.crm.service;

import com.liulf.crm.modular.crm.dao.SysCityDao;
import com.liulf.crm.modular.crm.entity.SysCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysCityService extends BaseService {

    @Autowired
    SysCityDao sysCityDao;

    public List<SysCity> getSysCityByLevelTypeAndPid(int levelType, int pid) {
       return sysCityDao.getSysCityByLevelTypeAndPid(levelType,pid);
    }

    public List<SysCity> getSysCityListByIds(String... ids) {
        return  sysCityDao.getSysCityListByIds(ids);
    }
}
