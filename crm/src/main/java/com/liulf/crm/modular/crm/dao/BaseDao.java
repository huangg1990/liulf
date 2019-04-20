package com.liulf.crm.modular.crm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {

    @Autowired
    @Qualifier("liulfJdbcTemplate")
    protected JdbcTemplate liulfJdbcTemplate;

}
