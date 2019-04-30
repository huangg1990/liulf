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
    private Integer payment_status;//	支付状态
    private Long customer_id;//	客户id
}
