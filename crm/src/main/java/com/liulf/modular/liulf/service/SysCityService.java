package com.liulf.modular.liulf.service;

import com.liulf.modular.liulf.dao.SysCityDao;
import com.liulf.modular.liulf.entity.SysCity;
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
