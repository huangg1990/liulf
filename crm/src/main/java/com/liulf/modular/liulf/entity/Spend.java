package com.liulf.modular.liulf.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Spend extends BaseEntity implements Serializable {

    private Long spend_id;//	编号
    private Long spend_category_id;//	类别
    private BigDecimal price;//	金额
    private Date spend_date;//		日期
    private Long user_id;//	经手员工


    /**
     * 列表显示字段
     */
    private String spend_category_name;
    private String user_name;

}
