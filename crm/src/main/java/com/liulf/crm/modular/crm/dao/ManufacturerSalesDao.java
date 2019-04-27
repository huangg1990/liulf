package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.ManufacturerSales;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Component
public class ManufacturerSalesDao extends BaseDao {
    private final static String save_sql =
            "insert into dat_manufacturer_sales(\n" +
                    "`manufacturer_id`,\n" +
                    "`sales_name`,\n" +
                    "`sales_addr`," +
                    "`sales_phone`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?,?,?);";

    public void save(ManufacturerSales entity) {
        Object[] para = new Object[]{
                entity.getManufacturer_id(),
                entity.getSales_name(),
                entity.getSales_addr(),
                entity.getSales_phone(),
                entity.getNote(),
                "N",
                new Date(),
                entity.getCreate_user(),
                new Date(),
                entity.getUpdate_user()
        };
        liulfJdbcTemplate.update(save_sql, para);
    }

    private final static String update_sql =
            "update dat_manufacturer_sales\n" +
                    "set \n" +
                    "`manufacturer_id`=?,\n" +
                    "`sales_name`=?,\n" +
                    "`sales_addr`=?," +
                    "`sales_phone`=?,\n" +
                    "`note`=?, " +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `sales_id` =?";

    public void update(ManufacturerSales entity) {
        Object[] para = new Object[]{
                entity.getManufacturer_id(),
                entity.getSales_name(),
                entity.getSales_addr(),
                entity.getSales_phone(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getSales_id()
        };
        liulfJdbcTemplate.update(update_sql, para);
    }

    private final static String deleteById_sql =
            "update dat_manufacturer_sales\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `sales_id` in (#ids#);";

    public void deleteById(List<Long> ids, Long userid) {
        String tempSql = deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql, new Object[]{
                new Date(), userid
        });
    }

    private final static String getById_sql =
            "select \n" +
                    "m.`province`,\n" +
                    "m.`city`,"+
                    "m.`area`,\n" +
                    "m.`manufacturer_name`,\n" +
                    "ms.`sales_id`, \n"+
                    "ms.`manufacturer_id`,\n" +
                    "ms.`sales_name`,\n" +
                    "ms.`sales_addr`," +
                    "ms.`sales_phone`,\n" +
                    "ms.`note`,\n" +
                    "ms.`delete_flag`,\n" +
                    "ms.`create_time`,\n" +
                    "ms.`create_user`,\n" +
                    "ms.`update_time`,\n" +
                    "ms.`update_user` \n" +
                    "from dat_manufacturer_sales ms \n"+
                    "inner join dat_manufacturer m\n" +
                    "on ms.manufacturer_id=m.manufacturer_id  where ms.`delete_flag`='N' AND ms.`sales_id`=?";

    public ManufacturerSales getById(Long id) {
        List<ManufacturerSales> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(ManufacturerSales.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private String getWhereSql(ManufacturerSales entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getSales_name())) {
            whereList.add(" ms.`sales_name`  like '%" + entity.getSales_name() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getSales_phone())) {
            whereList.add(" ms.`sales_phone`  like '%" + entity.getSales_phone() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getProvince())) {
            whereList.add(" m.`province`=? ");
            queryPara.add(entity.getProvince());
        }
        if (!ToolUtil.isEmpty(entity.getCity())) {
            whereList.add(" m.`city`=? ");
            queryPara.add(entity.getCity());
        }
        if (!ToolUtil.isEmpty(entity.getArea())) {
            whereList.add(" m.`area`=? ");
            queryPara.add(entity.getArea());
        }
        if (!ToolUtil.isEmpty(entity.getManufacturer_id())) {
            whereList.add(" ms.`manufacturer_id`=? ");
            queryPara.add(entity.getManufacturer_id());
        }
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }

    private final static String getPageCount_sql =
            "select count(1) \n" +
                    "from dat_manufacturer_sales ms\n" +
                    "inner join dat_manufacturer m\n" +
                    "on ms.manufacturer_id=m.manufacturer_id #and#";

    public Long getPageCount(ManufacturerSales entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql.replace("#and#" , getWhereSql(entity, para));
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql =
            "select \n" +
                    "m.`province`,\n" +
                    "m.`city`,"+
                    "m.`area`,\n" +
                    "m.`manufacturer_name`,\n" +
                    "ms.`sales_id`, \n"+
                    "ms.`manufacturer_id`,\n" +
                    "ms.`sales_name`,\n" +
                    "ms.`sales_addr`," +
                    "ms.`sales_phone`,\n" +
                    "ms.`note`,\n" +
                    "ms.`delete_flag`,\n" +
                    "ms.`create_time`,\n" +
                    "ms.`create_user`,\n" +
                    "ms.`update_time`,\n" +
                    "ms.`update_user` \n" +
                    "from dat_manufacturer_sales ms \n"+
                    "inner join dat_manufacturer m\n" +
                    "on ms.manufacturer_id=m.manufacturer_id #and#";

    public List<ManufacturerSales> getPageList(Page page, ManufacturerSales entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql.replace("#and#", getWhereSql(entity, para));
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<ManufacturerSales> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(ManufacturerSales.class));
        return list;
    }
}
