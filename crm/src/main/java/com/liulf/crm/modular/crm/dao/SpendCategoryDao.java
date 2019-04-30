package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.SpendCategory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class SpendCategoryDao extends BaseDao {
    private final static String save_sql =
            "insert into dat_spend_category(\n" +
                    "`spend_category_code`,\n" +
                    "`spend_category_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?);";

    public void save(SpendCategory entity) {
        Object[] para = new Object[]{
                entity.getSpend_category_code(),
                entity.getSpend_category_name(),
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
            "update dat_spend_category\n" +
                    "set " +
                    "`spend_category_code`=?,\n" +
                    "`spend_category_name`=?,\n" +
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `spend_category_id`=?";

    public void update(SpendCategory entity) {
        Object[] para = new Object[]{
                entity.getSpend_category_code(),
                entity.getSpend_category_name(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getSpend_category_id()
        };
        liulfJdbcTemplate.update(update_sql, para);
    }

    private final static String deleteById_sql =
            "update dat_spend_category\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `spend_category_id` in (#ids#);";

    public void deleteById(List<Long> ids, Long userid) {
        String tempSql = deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql, new Object[]{
                new Date(), userid
        });
    }

    private final static String getById_sql =
            "select \n" +
                    "`spend_category_id`,\n" +
                    "`spend_category_code`,\n" +
                    "`spend_category_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`\n" +
                    "from dat_spend_category where `delete_flag`='N' AND `spend_category_id`=?";

    public SpendCategory getById(Long id) {
        List<SpendCategory> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(SpendCategory.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    private final static String getAllList_sql =
            "select \n" +
                    "`spend_category_id`,\n" +
                    "`spend_category_code`,\n" +
                    "`spend_category_name` \n" +
                    "from dat_spend_category where `delete_flag`='N'";

    public List<SpendCategory> getAllList() {
        List<SpendCategory> list = liulfJdbcTemplate.query(getAllList_sql, new BeanPropertyRowMapper(SpendCategory.class));
        return list;
    }


    private String getWhereSql(SpendCategory entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getSpend_category_code())) {
            whereList.add(" `spend_category_code`  like '%" + entity.getSpend_category_code() + "%'");
        }
        if (!ToolUtil.isEmpty(entity.getSpend_category_name())) {
            whereList.add(" `spend_category_name`  like '%" + entity.getSpend_category_name() + "%'");
        }
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }

    private final static String getPageCount_sql =
            "select count(1) from dat_spend_category ";

    public Long getPageCount(SpendCategory entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql =
            "select \n" +
                    "`spend_category_id`,\n" +
                    "`spend_category_code`,\n" +
                    "`spend_category_name`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`\n" +
                    "from dat_spend_category  ";

    public List<SpendCategory> getPageList(Page page, SpendCategory entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<SpendCategory> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(SpendCategory.class));
        return list;
    }

}
