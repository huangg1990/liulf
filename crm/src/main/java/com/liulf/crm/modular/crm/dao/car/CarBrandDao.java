package com.liulf.crm.modular.crm.dao.car;

import com.liulf.crm.modular.crm.dao.BaseDao;
import com.liulf.crm.modular.crm.entity.car.CarBrand;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarBrandDao extends BaseDao {

    private final static String getSelect_sql =
            "select cb_Id,cb_Name from Car_Brand  where IsState=1";

    public List<CarBrand> getSelect() {
        List<CarBrand> list = liulfJdbcTemplate.query(getSelect_sql, new BeanPropertyRowMapper(CarBrand.class));
        return list;
    }
}
