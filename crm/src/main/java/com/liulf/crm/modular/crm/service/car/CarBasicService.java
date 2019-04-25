package com.liulf.crm.modular.crm.service.car;

import com.liulf.crm.modular.crm.dao.car.CarBasicDao;
import com.liulf.crm.modular.crm.entity.car.CarBasic;
import com.liulf.crm.modular.crm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBasicService extends BaseService {

    @Autowired
    CarBasicDao carBasicDao;

    public List<CarBasic> getSelectByCsId(String csId) {
         return  carBasicDao.getSelectByCsId(csId);
    }
}
