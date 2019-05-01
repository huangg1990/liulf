package com.liulf.crm.modular.crm.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CommoditySell extends BaseEntity implements Serializable {
    private Long sell_id;//	编号
    private Long commodity_id;//	商品编号
    private BigDecimal unit_price;//	单价
    private Integer amount;//	数量
    private Date deal_date;//	日期
    private Long user_id;//	经手雇员ID
    private String payment_status;//	支付状态
    private Long customer_id;//	客户id

    /**
     * 修改使用
     */
    private Long category_id; //商品分类ID
    private String commodity_name;
    /**
     * 列表显示使用
     */
    private String category_name;//	类别名称

    private String customer_name; //客户姓名
}
