package com.liulf.crm.modular.crm.service.car;

import com.liulf.crm.modular.crm.dao.BaseDao;
import com.liulf.crm.modular.crm.dao.car.CarSerialDao;
import com.liulf.crm.modular.crm.entity.car.CarSerial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarSerialService extends BaseDao {
    @Autowired
    CarSerialDao carSerialDao;

    public List<CarSerial> getSelectByCbId(String cbId) {
       return carSerialDao.getSelectByCbId(cbId);
    }
}
