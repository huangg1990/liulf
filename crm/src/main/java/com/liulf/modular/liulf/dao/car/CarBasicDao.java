package com.liulf.modular.liulf.dao.car;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.liulf.entity.car.CarBasic;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarBasicDao extends BaseDao {
    private final static String getSelectByCsId_sql =
            "select Car_Id,Car_Name from Car_Basic where IsState=1 and  Cs_Id=? ";

    public List<CarBasic> getSelectByCsId(String csId) {
        List<CarBasic> list = liulfJdbcTemplate.query(getSelectByCsId_sql, new Object[]{csId}, new BeanPropertyRowMapper(CarBasic.class));
        return list;
    }
}
