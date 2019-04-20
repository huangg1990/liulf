package com.liulf.crm.modular.crm.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {

    @Autowired
    @Qualifier("liulfJdbcTemplate")
    protected JdbcTemplate liulfJdbcTemplate;

    protected static final Logger log = LoggerFactory.getLogger(SysCityDao.class);
}
