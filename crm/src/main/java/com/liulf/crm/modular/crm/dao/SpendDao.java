package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.Spend;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SpendDao extends BaseDao {
    private final static String save_sql =
            "insert into dat_spend(\n" +
                    "`spend_category_id`,\n" +
                    "`price`,\n" +
                    "`spend_date`,\n" +
                    "`user_id`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?,?,?);";

    public void save(Spend entity) {
        Object[] para = new Object[]{
                entity.getSpend_category_id(),
                entity.getPrice(),
                entity.getSpend_date(),
                entity.getUser_id(),
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
            "update dat_spend\n" +
                    "set " +
                    "`spend_category_id`=?,\n" +
                    "`price`=?,\n" +
                    "`spend_date`=?,\n" +
                    "`user_id`=?,\n" +
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `spend_id`=?";

    public void update(Spend entity) {
        Object[] para = new Object[]{
                entity.getSpend_category_id(),
                entity.getPrice(),
                entity.getSpend_date(),
                entity.getUser_id(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getSpend_id()
        };
        liulfJdbcTemplate.update(update_sql, para);
    }

    private final static String deleteById_sql =
            "update dat_spend\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `spend_id` in (#ids#);";

    public void deleteById(List<Long> ids, Long userid) {
        String tempSql = deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql, new Object[]{
                new Date(), userid
        });
    }

    private final static String getById_sql =
            "select \n" +
                    "`spend_id`,\n" +
                    "`spend_category_id`,\n" +
                    "`price`,\n" +
                    "`spend_date`,\n" +
                    "`user_id`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`\n" +
                    "from dat_spend where `delete_flag`='N' AND `spend_id`=?";

    public Spend getById(Long id) {
        List<Spend> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(Spend.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }




    private String getWhereSql(Spend entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getSpend_category_id())) {
            whereList.add(" s.`spend_category_id`=?");
            queryPara.add(entity.getSpend_category_id());
        }
        if (!ToolUtil.isEmpty(entity.getUser_id())) {
            whereList.add(" s.`user_id`=?");
            queryPara.add(entity.getUser_id());
        }
        if (!ToolUtil.isEmpty(entity.getSpend_date())) {
            whereList.add(" s.`spend_date`>=? and s.`spend_date`<? ");
            queryPara.add(entity.getSpend_date());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(entity.getCreate_time());
            calendar.add(Calendar.DATE, 1);
            queryPara.add(calendar.getTime());
        }
        whereList.add(" s.`delete_flag`='N' ");
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }

    private final static String getPageCount_sql =
            "select count(1) from dat_spend as s " +
                    "inner join sys_user u\n" +
                    "on s.user_id=u.USER_ID\n" +
                    "inner join dat_spend_category sc \n" +
                    "on s.spend_category_id=sc.spend_category_id \n";

    public Long getPageCount(Spend entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql + getWhereSql(entity, para);
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql =
            "select \n" +
                    "s.`spend_id`,\n" +
                    "s.`spend_category_id`,\n" +
                    "sc.`spend_category_name`,\n" +
                    "s.`price`,\n" +
                    "s.`spend_date`,\n" +
                    "s.`user_id`,\n" +
                    "u.`NAME` as user_name,\n" +
                    "s.`note`,\n" +
                    "s.`delete_flag`,\n" +
                    "s.`create_time`,\n" +
                    "s.`create_user`,\n" +
                    "s.`update_time`,\n" +
                    "s.`update_user`\n" +
                    "from dat_spend  s \n" +
                    "inner join sys_user u\n" +
                    "on s.user_id=u.USER_ID\n" +
                    "inner join dat_spend_category sc \n" +
                    "on s.spend_category_id=sc.spend_category_id \n"
                    ;

    public List<Spend> getPageList(Page page, Spend entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql + getWhereSql(entity, para);
        tempSQL += " order by s.create_time desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<Spend> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(Spend.class));
        return list;
    }

}
