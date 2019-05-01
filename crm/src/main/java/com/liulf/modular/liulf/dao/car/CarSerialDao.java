package com.liulf.modular.liulf.dao.car;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.liulf.entity.car.CarSerial;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarSerialDao extends BaseDao {
    private final static String getSelectByCbId_sql =
            "select cs_Id,cs_Name from Car_Serial where IsState=1 and  cb_Id=? ";

    public List<CarSerial> getSelectByCbId(String cbId) {
        List<CarSerial> list = liulfJdbcTemplate.query(getSelectByCbId_sql, new Object[]{cbId}, new BeanPropertyRowMapper(CarSerial.class));
        return list;
    }
}
