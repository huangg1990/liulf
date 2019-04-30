package com.liulf.crm.modular.crm.service.ext;

import com.liulf.crm.modular.crm.dao.ext.ExtDeptDao;
import com.liulf.crm.modular.crm.service.BaseService;
import com.liulf.crm.modular.system.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtDeptService extends BaseService {

    @Autowired
    ExtDeptDao extDeptDao;
    /**
     *
     * @param pCode
     * @return
     */
    public List<Dept> getDeptListByPCode(String pCode){

        return extDeptDao.getDeptListByPCode(pCode);
    }
}
