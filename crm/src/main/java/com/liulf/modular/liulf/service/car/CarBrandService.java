package com.liulf.modular.liulf.service.car;

import com.liulf.modular.liulf.dao.car.CarBrandDao;
import com.liulf.modular.liulf.entity.car.CarBrand;
import com.liulf.modular.liulf.service.BaseService;
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
