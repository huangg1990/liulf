package com.liulf.crm.modular.crm.service.car;

import com.liulf.crm.modular.crm.dao.car.CarBrandDao;
import com.liulf.crm.modular.crm.entity.car.CarBrand;
import com.liulf.crm.modular.crm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService extends BaseService {

    @Autowired
    CarBrandDao carBrandDao;

    public List<CarBrand> getSelect() {
        return carBrandDao.getSelect();
    }
}
