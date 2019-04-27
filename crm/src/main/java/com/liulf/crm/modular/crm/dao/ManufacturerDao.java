package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.Manufacturer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class ManufacturerDao extends BaseDao {
    private final static String save_sql=
            "insert into dat_manufacturer(\n" +
                        "`manufacturer_name`,\n" +
                        "`province`,\n" +
                        "`city`,"+
                        "`area`,\n" +
                        "`manufacturer_addr`,\n" +
                        "`manufacturer_phone`,\n" +
                        "`manufacturer_post`,\n" +
                        "`manufacturer_band_account`,\n" +
                        "`manufacturer_dept`,"+
                        "`note`,\n" +
                        "`delete_flag`,\n" +
                        "`create_time`,\n" +
                        "`create_user`,\n" +
                        "`update_time`,\n" +
                        "`update_user`)\n" +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public void save(Manufacturer entity){
        Object[] para=new Object[]{
                entity.getManufacturer_name(),
                entity.getProvince(),
                entity.getCity(),
                entity.getArea(),
                entity.getManufacturer_addr(),
                entity.getManufacturer_phone(),
                entity.getManufacturer_post(),
                entity.getManufacturer_band_account(),
                entity.getManufacturer_dept(),
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
            "update dat_manufacturer\n" +
                    "set \n" +
                    "`manufacturer_name`=?,\n" +
                    "`province`=?,\n" +
                    "`city`=?,"+
                    "`area`=?,\n" +
                    "`manufacturer_addr`=?,\n" +
                    "`manufacturer_phone`=?,\n" +
                    "`manufacturer_post`=?,\n" +
                    "`manufacturer_band_account`=?,\n" +
                    "`manufacturer_dept`=?, "+
                    "`note`=?, "+
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `manufacturer_id` =?";
    public void update(Manufacturer entity){
        Object[] para=new Object[]{
                entity.getManufacturer_name(),
                entity.getProvince(),
                entity.getCity(),
                entity.getArea(),
                entity.getManufacturer_addr(),
                entity.getManufacturer_phone(),
                entity.getManufacturer_post(),
                entity.getManufacturer_band_account(),
                entity.getManufacturer_dept(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getManufacturer_id()
        };
        liulfJdbcTemplate.update(update_sql,para);
    }

    private final static String deleteById_sql=
            "update dat_manufacturer\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `manufacturer_id` in (#ids#);";
    public void deleteById(List<Long> ids, Long userid){
        String tempSql=deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql,new Object[]{
                new Date(),userid
        });
    }

    private final static String getById_sql=
            "select \n" +
                    "`manufacturer_id`,\n"+
                    "`manufacturer_name`,\n" +
                    "`province`,\n" +
                    "`city`,"+
                    "`area`,\n" +
                    "`manufacturer_addr`,\n" +
                    "`manufacturer_phone`,\n" +
                    "`manufacturer_post`,\n" +
                    "`manufacturer_band_account`,\n" +
                    "`manufacturer_dept`,"+
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user` \n" +
                    "from dat_manufacturer where `delete_flag`='N' AND `manufacturer_id`=?";
    public Manufacturer getById(Long id){
        List<Manufacturer> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(Manufacturer.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private final static String getListByArea_sql=
            "select \n" +
                    "`manufacturer_id`,\n"+
                    "`manufacturer_name`\n" +
                    "from dat_manufacturer where `delete_flag`='N' AND `area`=?";
    public List<Manufacturer> getListByArea(String areaCode){
        List<Manufacturer> list = liulfJdbcTemplate.query(getListByArea_sql,new Object[]{areaCode}, new BeanPropertyRowMapper(Manufacturer.class));
        return list;
    }


    private String getWhereSql(Manufacturer entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getManufacturer_name())) {
            whereList.add(" `manufacturer_name`  like '%" +entity.getManufacturer_name() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getManufacturer_phone())) {
            whereList.add(" `manufacturer_phone`  like '%" +entity.getManufacturer_phone() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getManufacturer_addr())) {
            whereList.add(" `manufacturer_addr`  like '%" +entity.getManufacturer_addr() + "%'");
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
            "select count(1) from dat_manufacturer ";
    public Long getPageCount(Manufacturer entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql=
            "select \n" +
                    "`manufacturer_id`,\n"+
                    "`manufacturer_name`,\n" +
                    "`province`,\n" +
                    "`city`,"+
                    "`area`,\n" +
                    "`manufacturer_addr`,\n" +
                    "`manufacturer_phone`,\n" +
                    "`manufacturer_post`,\n" +
                    "`manufacturer_band_account`,\n" +
                    "`manufacturer_dept`,"+
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user` \n" +
                    "from dat_manufacturer ";
    public List<Manufacturer> getPageList(Page page , Manufacturer entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<Manufacturer> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(Manufacturer.class));
        return list;
    }
}
