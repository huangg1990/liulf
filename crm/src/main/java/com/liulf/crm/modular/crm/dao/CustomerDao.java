package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class CustomerDao extends BaseDao {

    private final static String save_sql=
            "insert into dat_customer(\n" +
                    "`customer_name`,\n" +
                    "`province`,\n" +
                    "`city`,\n" +
                    "`area`,\n" +
                    "`customer_phone`,\n" +
                    "`customer_car_card`,\n" +
                    "`car_id`,\n" +
                    "`customer_addr`,\n" +
                    "`gender`,"+
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?);";
    public void save(Customer entity){
        Object[] para=new Object[]{
                entity.getCustomer_name(),
                entity.getProvince(),
                entity.getCity(),
                entity.getArea(),
                entity.getCustomer_phone(),
                entity.getCustomer_car_card(),
                entity.getCar_id(),
                entity.getCustomer_addr(),
                entity.getGender()+"",
                entity.getNote(),
                "N",
                new Date(),
                entity.getCreate_user(),
                new Date(),
                entity.getUpdate_user()
        };
        liulfJdbcTemplate.update(save_sql,para);
    }
    private final static String update_sql=
            "update dat_customer\n" +
                    "set \n" +
                    "`customer_name`=?,\n" +
                    "`province`=?,\n" +
                    "`city`=?,\n" +
                    "`area`=?,\n" +
                    "`customer_phone`=?,\n" +
                    "`customer_car_card`=?,\n" +
                    "`car_id`=?,\n" +
                    "`customer_addr`=?,\n" +
                    "`gender`=?,"+
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `customer_id` =?";
    public void update(Customer entity){
        Object[] para=new Object[]{
                entity.getCustomer_name(),
                entity.getProvince(),
                entity.getCity(),
                entity.getArea(),
                entity.getCustomer_phone(),
                entity.getCustomer_car_card(),
                entity.getCar_id(),
                entity.getCustomer_addr(),
                entity.getGender()+"",
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getCustomer_id()
        };
        liulfJdbcTemplate.update(update_sql,para);
    }

    private final static String deleteById_sql=
            "update dat_customer\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `customer_id` in (#ids#);";
    public void deleteById(List<Long> ids, Long userid){
        String tempSql=deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql,new Object[]{
                new Date(),userid
        });
    }

    private final static String getById_sql=
            "select \n" +
                    "`customer_id`,\n" +
                    "`customer_name`,\n" +
                    "`province`,\n" +
                    "`city`,\n" +
                    "`area`,\n" +
                    "`customer_phone`,\n" +
                    "`customer_car_card`,\n" +
                    "`car_id`,\n" +
                    "`customer_addr`,\n" +
                    "`gender`,"+
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user` \n" +
                    "from dat_customer where `delete_flag`='N' AND `customer_id`=?";
    public Customer getById(Long id){
        List<Customer> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(Customer.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private final static String getListByArea_sql=
            "select \n" +
                    "`manufacturer_id`\n"+
                    "`manufacturer_name`\n" +
                    "from dat_manufacturer where `delete_flag`='N' AND `area`=?";
    public List<Customer> getListByArea(String areaCode){
        List<Customer> list = liulfJdbcTemplate.query(getListByArea_sql,new Object[]{areaCode}, new BeanPropertyRowMapper(Customer.class));
        return list;
    }


    private String getWhereSql(Customer entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getCustomer_name())) {
            whereList.add(" `customer_name`  like '%" +entity.getCustomer_name() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCustomer_phone())) {
            whereList.add(" `customer_phone`  like '%" +entity.getCustomer_phone() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCustomer_addr())) {
            whereList.add(" `customer_addr`  like '%" +entity.getCustomer_addr() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCustomer_car_card())) {
            whereList.add(" `customer_car_card`  like '%" +entity.getCustomer_car_card() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCar_id())) {
            whereList.add(" `car_id`=? ");
            queryPara.add(entity.getCar_id());
        }
        if (!ToolUtil.isEmpty(entity.getProvince())) {
            whereList.add(" `province`=? ");
            queryPara.add(entity.getProvince());
        }
        if (!ToolUtil.isEmpty(entity.getCity())) {
            whereList.add(" `city`=? ");
            queryPara.add(entity.getCity());
        }
        if (!ToolUtil.isEmpty(entity.getArea())) {
            whereList.add(" `area`=? ");
            queryPara.add(entity.getArea());
        }
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }
    private final static String getPageCount_sql=
            "select count(1) from dat_customer ";
    public Long getPageCount(Customer entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql=
            "select \n" +
                    "`customer_id`,\n" +
                    "`customer_name`,\n" +
                    "`province`,\n" +
                    "`city`,\n" +
                    "`area`,\n" +
                    "`customer_phone`,\n" +
                    "`customer_car_card`,\n" +
                    "`car_id`,\n" +
                    "`customer_addr`,\n" +
                    "`gender`,"+
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user` \n" +
                    "from dat_customer ";
    public List<Customer> getPageList(Page page , Customer entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<Customer> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(Customer.class));
        return list;
    }

}
