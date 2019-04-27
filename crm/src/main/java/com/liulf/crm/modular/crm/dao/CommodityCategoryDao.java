package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.dao.BaseDao;
import com.liulf.crm.modular.crm.entity.CommodityCategory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class CommodityCategoryDao extends BaseDao {
    private final static String save_sql=
            "insert into dat_commodity_category(\n" +
                    "`code`,\n" +
                    "`category_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?);";
    public void save(CommodityCategory entity){
        Object[] para=new Object[]{
                entity.getCode(),
                entity.getCategory_name(),
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
            "update dat_commodity_category\n" +
                    "set `code`=?,\n" +
                    "`category_name`=?,\n" +
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `category_id`=?";
    public void update(CommodityCategory entity){
        Object[] para=new Object[]{
                entity.getCode(),
                entity.getCategory_name(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getCategory_id()
        };
        liulfJdbcTemplate.update(update_sql,para);
    }

    private final static String deleteById_sql=
            "update dat_commodity_category\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `category_id` in (#ids#);";
    public void deleteById(List<Long> ids, Long userid){
        String tempSql=deleteById_sql.replace("#ids#",Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql,new Object[]{
                new Date(),userid
        });
    }

    private final static String getById_sql=
            "select \n" +
            "`category_id`,\n" +
            "`code`,\n" +
            "`category_name`,\n" +
            "`note`,\n" +
            "`delete_flag`,\n" +
            "`create_time`,\n" +
            "`create_user`,\n" +
            "`update_time`,\n" +
            "`update_user`\n" +
            "from dat_commodity_category where `delete_flag`='N' AND `category_id`=?";
    public CommodityCategory getById(Long id){
        List<CommodityCategory> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(CommodityCategory.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private final static String getAllList_sql=
            "select \n" +
                    "`category_id`,\n" +
                    "`code`,\n" +
                    "`category_name`\n" +
                    "from dat_commodity_category where `delete_flag`='N'";
    public List<CommodityCategory> getAllList(){
        List<CommodityCategory> list = liulfJdbcTemplate.query(getAllList_sql, new BeanPropertyRowMapper(CommodityCategory.class));
        return list;
    }


    private String getWhereSql(CommodityCategory entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getCode())) {
            whereList.add(" `code`  like '%" +entity.getCode() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getCategory_name())) {
            whereList.add(" `category_name`  like '%" +entity.getCategory_name() + "%'");
        }
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }
    private final static String getPageCount_sql=
            "select count(1) from dat_commodity_category ";
    public Long getPageCount(CommodityCategory entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql=
            "select \n" +
                    "`category_id`,\n" +
                    "`code`,\n" +
                    "`category_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`\n" +
                    "from dat_commodity_category  ";
    public List<CommodityCategory> getPageList(Page page , CommodityCategory entity){
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<CommodityCategory> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(CommodityCategory.class));
        return list;
    }

}
