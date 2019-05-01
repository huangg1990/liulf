package com.liulf.modular.liulf.service.ext;

import com.liulf.modular.liulf.dao.ext.ExtDictDao;
import com.liulf.modular.liulf.service.BaseService;
import com.liulf.modular.system.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtDictService extends BaseService {

    @Autowired
    ExtDictDao extDictDao;

    public Dict getDictByCode(String code){
        return extDictDao.getDictByCode(code);
    }
    /**
     *
     * @param pCode
     * @return
     */
    public List<Dict> getDictListByPCode(String pCode){

        return extDictDao.getDictListByPCode(pCode);
    }
}
