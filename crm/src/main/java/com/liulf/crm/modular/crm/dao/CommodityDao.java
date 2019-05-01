package com.liulf.crm.modular.crm.dao;


import cn.stylefeng.roses.core.util.ToolUtil;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.Commodity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * private Long commodity_id;//	商品编号
 *     private Long category_id;//	类别id
 *     private String commodity_code;//	编码
 *     private String commodity_name;//	名称
 */
@Component
public class CommodityDao extends BaseDao {
    private final static String save_sql=
            "insert into dat_commodity(\n" +
                    "`category_id`,\n"+
                    "`commodity_code`,\n" +
                    "`commodity_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?,?);";
    public void save(Commodity entity){
        Object[] para=new Object[]{
                entity.getCategory_id(),
                entity.getCommodity_code(),
                entity.getCommodity_name(),
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
            "update dat_commodity\n" +
                    "set " +
                    "`category_id`=?,\n"+
                    "`commodity_code`=?,\n" +
                    "`commodity_name`=?,\n" +
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `commodity_id`=?";
    public void update(Commodity entity){
        Object[] para=new Object[]{
                entity.getCategory_id(),
                entity.getCommodity_code(),
                entity.getCommodity_name(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getCommodity_id()
        };
        liulfJdbcTemplate.update(update_sql,para);
    }

    private final static String deleteById_sql=
            "update dat_commodity\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `commodity_id` in (#ids#);";
    public void deleteById(List<Long> ids, Long userid){
        String tempSql=deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql,new Object[]{
                new Date(),userid
        });
    }

    private final static String getById_sql=
            "select \n" +
                    "`commodity_id`,\n"+
                    "`category_id`,\n"+
                    "`commodity_code`,\n" +
                    "`commodity_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`\n" +
                    "from dat_commodity where `delete_flag`='N' AND `commodity_id`=?";
    public Commodity getById(Long id){
        List<Commodity> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(Commodity.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private final static String getByCategoryId_sql=
            "select \n" +
                    "`commodity_id`,\n"+
                    "`commodity_code`,\n" +
                    "`commodity_name`\n" +
                    "from dat_commodity where `delete_flag`='N' and `category_id`=?";
    public List<Commodity> getByCategoryId(String category_id){
        List<Commodity> list = liulfJdbcTemplate.query(getByCategoryId_sql,new Object[]{category_id}, new BeanPropertyRowMapper(Commodity.class));
        return list;
    }


    private String getWhereSql(Commodity entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getCommodity_code())) {
            whereList.add(" c.`commodity_code`  like '%" +entity.getCommodity_code() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCommodity_name())) {
            whereList.add(" c.`commodity_name`  like '%" +entity.getCommodity_name() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCategory_id())) {
            whereList.add(" c.`category_id`=?");
            queryPara.add(entity.getCategory_id());
        }
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }
    private final static String getPageCount_sql=
            "select count(1) from dat_commodity c  ";
    public Long getPageCount(Commodity entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql=
            "select \n" +
                    "cc.`category_name`,\n"+
                    "c.`commodity_id`,\n"+
                    "c.`category_id`,\n"+
                    "c.`commodity_code`,\n" +
                    "c.`commodity_name`,\n" +
                    "c.`note`,\n" +
                    "c.`delete_flag`,\n" +
                    "c.`create_time`,\n" +
                    "c.`create_user`,\n" +
                    "c.`update_time`,\n" +
                    "c.`update_user`\n" +
                    "from dat_commodity c \n" +
                    "inner join dat_commodity_category cc \n" +
                    "on c.category_id=cc.category_id";

    public List<Commodity> getPageList(Page page , Commodity entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<Commodity> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(Commodity.class));
        return list;
    }

}

