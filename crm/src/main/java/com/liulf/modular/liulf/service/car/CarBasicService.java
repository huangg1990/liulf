package com.liulf.modular.liulf.service.car;

import com.liulf.modular.liulf.dao.car.CarBasicDao;
import com.liulf.modular.liulf.entity.car.CarBasic;
import com.liulf.modular.liulf.service.BaseService;
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
