package com.liulf.crm.modular.crm.dao;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Joiner;
import com.liulf.crm.modular.crm.entity.CommodityStock;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommodityStockDao extends BaseDao {
    private final static String save_sql =
            "insert into dat_commodity_stock(\n" +
                    "`commodity_id`,\n" +
                    "`unit_price`,\n" +
                    "`amount`,\n" +
                    "`stock_category`,\n" +
                    "`deal_date`,\n" +
                    "`user_id`,\n" +
                    "`payment_status`,\n" +
                    "`manufacturer_sales_id`,\n" +
                    "`note`,\n" +
                    "`delete_flag`,\n" +
                    "`create_time`,\n" +
                    "`create_user`,\n" +
                    "`update_time`,\n" +
                    "`update_user`)\n" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public void save(CommodityStock entity) {
        Object[] para = new Object[]{
                entity.getCommodity_id(),
                entity.getUnit_price(),
                entity.getAmount(),
                entity.getStock_category(),
                entity.getDeal_date(),
                entity.getUser_id(),
                entity.getPayment_status(),
                entity.getManufacturer_sales_id(),
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
            "update dat_commodity_stock\n" +
                    "set " +
                    "`commodity_id`=?,\n" +
                    "`unit_price`=?,\n" +
                    "`amount`=?,\n" +
                    "`stock_category`=?,\n" +
                    "`deal_date`=?,\n" +
                    "`user_id`=?,\n" +
                    "`payment_status`=?,\n" +
                    "`manufacturer_sales_id`=?,\n" +
                    "`note`=?,\n" +
                    "`update_time`=?,\n" +
                    "`update_user`=?\n" +
                    "where `stock_id`=?";

    public void update(CommodityStock entity) {
        Object[] para = new Object[]{
                entity.getCommodity_id(),
                entity.getUnit_price(),
                entity.getAmount(),
                entity.getStock_category(),
                entity.getDeal_date(),
                entity.getUser_id(),
                entity.getPayment_status(),
                entity.getManufacturer_sales_id(),
                entity.getNote(),
                new Date(),
                entity.getUpdate_user(),
                entity.getStock_id()
        };
        liulfJdbcTemplate.update(update_sql, para);
    }

    private final static String deleteById_sql =
            "update dat_commodity_stock\n" +
                    "set `delete_flag`='Y',`update_time`=?,`update_user`=?\n" +
                    "where `stock_id` in (#ids#);";

    public void deleteById(List<Long> ids, Long userid) {
        String tempSql = deleteById_sql.replace("#ids#", Joiner.on(",").join(ids));
        liulfJdbcTemplate.update(tempSql, new Object[]{
                new Date(), userid
        });
    }

    private final static String getById_sql =
            "select \n" +
                    "cs.*,\n" +
                    "c.category_id\n" +
                    "from \n" +
                    "(\n" +
                    "select \n" +
                    " `stock_id`,\n" +
                    " `commodity_id`,\n" +
                    " `unit_price`,\n" +
                    " `amount`,\n" +
                    " `stock_category`,\n" +
                    " `deal_date`,\n" +
                    " `user_id`,\n" +
                    " `payment_status`,\n" +
                    " `manufacturer_sales_id`,\n" +
                    " `note`,\n" +
                    " `delete_flag`,\n" +
                    " `create_time`,\n" +
                    " `create_user`,\n" +
                    " `update_time`,\n" +
                    " `update_user`)\n" +
                    "from dat_commodity_stock where cs.`delete_flag`='N' AND cs.`stock_id`=?) cs\n" +
                    "inner join dat_commodity c \n" +
                    "on cs.commodity_id=c.commodity_id";

    public CommodityStock getById(Long id) {
        List<CommodityStock> list = liulfJdbcTemplate.query(getById_sql, new Object[]{id},
                new BeanPropertyRowMapper(CommodityStock.class));
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }


    private String getWhereSql(CommodityStock entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getCommodity_id())) {
            whereList.add(" `commodity_id`=?");
            queryPara.add(entity.getCommodity_id());
        }
        if (!ToolUtil.isEmpty(entity.getUser_id())) {
            whereList.add(" `user_id`=?");
            queryPara.add(entity.getUser_id());
        }
        if (!ToolUtil.isEmpty(entity.getPayment_status())) {
            whereList.add(" `payment_status`=?");
            queryPara.add(entity.getPayment_status());
        }
        if (!ToolUtil.isEmpty(entity.getStock_category())) {
            whereList.add(" `stock_category`=?");
            queryPara.add(entity.getStock_category());
        }
        if (!ToolUtil.isEmpty(entity.getManufacturer_sales_id())) {
            whereList.add(" `manufacturer_sales_id`=?");
            queryPara.add(entity.getManufacturer_sales_id());
        }

        if (!ToolUtil.isEmpty(entity.getDeal_date())) {
            whereList.add(" `deal_date`>=? and `deal_date`<? ");
            queryPara.add(entity.getDeal_date());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(entity.getDeal_date());
            calendar.add(Calendar.DATE, 1);
            queryPara.add(calendar.getTime());
        }
        if (whereList.size() == 0)
            return "";
        return " and " + Joiner.on(" and ").join(whereList);
    }

    private String getWhereSql2(CommodityStock entity, List<Object> queryPara) {
        List<String> whereList = new ArrayList<>();
        if (!ToolUtil.isEmpty(entity.getCategory_id())) {
            whereList.add(" c.`category_id`=?");
            queryPara.add(entity.getCategory_id());
        }
        if (!ToolUtil.isEmpty(entity.getManufacturer_id())) {
            whereList.add(" m.`manufacturer_id`=?");
            queryPara.add(entity.getManufacturer_id());
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
        if (whereList.size() == 0)
            return "";
        return " where " + Joiner.on(" and ").join(whereList);
    }

    private final static String getPageCount_sql =
            "select count(1) \n" +
                    "from \n" +
                    "(\n" +
                    "select \n" +
                    " `stock_id`,\n" +
                    " `commodity_id`,\n" +
                    " `unit_price`,\n" +
                    " `amount`,\n" +
                    " `stock_category`,\n" +
                    " `deal_date`,\n" +
                    " `user_id`,\n" +
                    " `payment_status`,\n" +
                    " `manufacturer_sales_id`,\n" +
                    " `note`,\n" +
                    " `delete_flag`,\n" +
                    " `create_time`,\n" +
                    " `create_user`,\n" +
                    " `update_time`,\n" +
                    " `update_user`\n" +
                    "from dat_commodity_stock where `delete_flag`='N' #and#) cs\n" +
                    "inner join dat_commodity c \n" +
                    "on cs.commodity_id=c.commodity_id\n" +
                    "inner join dat_manufacturer_sales ms \n" +
                    "on cs.manufacturer_sales_id=ms.sales_id\n" +
                    "inner join dat_manufacturer m \n" +
                    "on m.manufacturer_id=ms.manufacturer_id\n" +
                    "inner join dat_commodity_category cc\n" +
                    "on c.category_id=cc.category_id #and2#";

    public Long getPageCount(CommodityStock entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageCount_sql.replace("#and#", getWhereSql(entity, para));
        tempSQL = tempSQL.replace("#and2#", getWhereSql2(entity, para));
        return liulfJdbcTemplate.queryForObject(tempSQL, para.toArray(), Long.class);
    }

    private final static String getPageList_sql =
            "select \n" +
                    "cs.*,\n" +
                    "c.category_id,\n" +
                    "c.commodity_name,\n" +
                    "m.manufacturer_name,\n" +
                    "cc.category_name\n" +
                    "from \n" +
                    "(\n" +
                    "select \n" +
                    " `stock_id`,\n" +
                    " `commodity_id`,\n" +
                    " `unit_price`,\n" +
                    " `amount`,\n" +
                    " `stock_category`,\n" +
                    " `deal_date`,\n" +
                    " `user_id`,\n" +
                    " `payment_status`,\n" +
                    " `manufacturer_sales_id`,\n" +
                    " `note`,\n" +
                    " `delete_flag`,\n" +
                    " `create_time`,\n" +
                    " `create_user`,\n" +
                    " `update_time`,\n" +
                    " `update_user`\n" +
                    "from dat_commodity_stock where `delete_flag`='N' #and#) cs\n" +
                    "inner join dat_commodity c \n" +
                    "on cs.commodity_id=c.commodity_id\n" +
                    "inner join dat_manufacturer_sales ms \n" +
                    "on cs.manufacturer_sales_id=ms.sales_id\n" +
                    "inner join dat_manufacturer m \n" +
                    "on m.manufacturer_id=ms.manufacturer_id\n" +
                    "inner join dat_commodity_category cc\n" +
                    "on c.category_id=cc.category_id #and2#";

    public List<CommodityStock> getPageList(Page page, CommodityStock entity) {
        List<Object> para = new LinkedList<>();
        String tempSQL = getPageList_sql.replace("#and#", getWhereSql(entity, para));
        tempSQL = tempSQL.replace("#and2#", getWhereSql2(entity, para));
        tempSQL += " order by cs.deal_date desc limit ?,?";
        para.add((page.getCurrent() - 1) * page.getSize());
        para.add(page.getSize());
        List<CommodityStock> list = liulfJdbcTemplate.query(tempSQL, para.toArray(), new BeanPropertyRowMapper(CommodityStock.class));
        return list;
    }

}
