package com.liulf.modular.liulf.service.ext;

import com.liulf.modular.liulf.dao.ext.ExtDeptDao;
import com.liulf.modular.liulf.service.BaseService;
import com.liulf.modular.system.entity.Dept;
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
