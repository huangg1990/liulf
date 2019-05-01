package com.liulf.modular.liulf.service.car;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.liulf.dao.car.CarSerialDao;
import com.liulf.modular.liulf.entity.car.CarSerial;
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
