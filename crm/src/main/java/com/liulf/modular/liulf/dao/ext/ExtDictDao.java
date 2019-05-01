package com.liulf.modular.liulf.dao.ext;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.system.entity.Dict;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtDictDao extends BaseDao {

    private final static String getDictByCode_sql=
            "select DICT_ID,PID,`NAME`,`CODE`,DESCRIPTION,SORT from sys_dict where `CODE`=?";
    /**
     * HOUSE_HIND
     * @param code
     * @return
     */
    public Dict getDictByCode(String code){
        List<Dict> list = liulfJdbcTemplate.query(getDictByCode_sql, new Object[]{code},
                new BeanPropertyRowMapper(Dict.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }



    private final static String  getDictListByPCode_sql=
            "select `CODE`,`NAME` from sys_dict where \n" +
            "PID in (\n" +
            "select DICT_ID from sys_dict where `CODE`=?\n" +
            ")\n" +
            "ORDER BY SORT ASC";
    /**
     *
     * @param pCode
     * @return
     */
    public List<Dict> getDictListByPCode(String pCode){
        List<Dict> list = liulfJdbcTemplate.query(getDictListByPCode_sql, new Object[]{pCode},
                new BeanPropertyRowMapper(Dict.class));
        if (list == null || list.size() == 0)
            return null;
        return list;
    }
}
