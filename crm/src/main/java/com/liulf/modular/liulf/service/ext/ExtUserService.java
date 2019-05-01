package com.liulf.modular.liulf.service.ext;

import com.liulf.modular.liulf.dao.ext.ExtUserDao;
import com.liulf.modular.liulf.service.BaseService;
import com.liulf.modular.system.entity.User;
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
