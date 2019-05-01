package com.liulf.modular.liulf.dao.car;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.liulf.entity.car.CarBrand;
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
