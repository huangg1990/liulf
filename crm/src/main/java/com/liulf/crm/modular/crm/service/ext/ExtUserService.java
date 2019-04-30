package com.liulf.crm.modular.crm.service.ext;

import com.liulf.crm.modular.crm.dao.ext.ExtUserDao;
import com.liulf.crm.modular.crm.service.BaseService;
import com.liulf.crm.modular.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtUserService extends BaseService {

    @Autowired
    ExtUserDao extUserDao;
    /**
     *
     * @param pCode
     * @return
     */
    public List<User> getUserListByPCode(String pCode){

        return extUserDao.getUserListByPCode(pCode);
    }
}
