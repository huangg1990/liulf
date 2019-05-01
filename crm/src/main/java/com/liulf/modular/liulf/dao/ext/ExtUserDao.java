package com.liulf.modular.liulf.dao.ext;

import com.liulf.modular.liulf.dao.BaseDao;
import com.liulf.modular.system.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtUserDao extends BaseDao {



    private final static String  getUserListByPCode_sql=
            "select USER_ID,`NAME` from sys_user where `STATUS`='ENABLE' and USER_ID>1000 ";
    /**
     *
     * @param pCode
     * @return
     */
    public List<User> getUserListByPCode(String pCode){
        List<User> list = liulfJdbcTemplate.query(getUserListByPCode_sql,new BeanPropertyRowMapper(User.class));
        if (list == null || list.size() == 0)
            return null;
        return list;
    }
}
