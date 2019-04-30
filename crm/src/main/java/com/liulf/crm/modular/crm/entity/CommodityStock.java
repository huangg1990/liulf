package com.liulf.crm.modular.crm.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CommodityStock extends BaseEntity implements Serializable {
    private Long stock_id;//	编号
    private Long commodity_id;//	商品编号
    private BigDecimal unit_price;//	单价
    private Integer amount;//	数量
    private String stock_category;//	进、退货标识
    private Date deal_date;//	日期
    private Long user_id;//	经手雇员ID
    private String payment_status;//	支付状态
    private Long manufacturer_sales_id;//	厂商业务员id


    /**
     * 修改使用
     */
    private Long category_id; //商品分类ID
    /**
     * 列表显示使用
     */
    private String category_name;//	类别名称
    private Long  manufacturer_id;//
    private String manufacturer_name;
}
