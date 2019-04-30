package com.liulf.crm.modular.crm.dao.ext;

import com.liulf.crm.modular.crm.dao.BaseDao;
import com.liulf.crm.modular.system.entity.Dept;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtDeptDao extends BaseDao {

    private final static String  getDeptListByPCode_sql=
            "select DEPT_ID,FULL_NAME from sys_dept";
    /**
     *
     * @param pCode
     * @return
     */
    public List<Dept> getDeptListByPCode(String pCode){
        List<Dept> list = liulfJdbcTemplate.query(getDeptListByPCode_sql,new BeanPropertyRowMapper(Dept.class));
        if (list == null || list.size() == 0)
            return null;
        return list;
    }
}
