package com.liulf.crm.modular.crm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品表
 */
@Data
public class Commodity extends BaseEntity implements Serializable {
    private Long commodity_id;//	商品编号
    private Long category_id;//	类别id
    private String commodity_code;//	编码
    private String commodity_name;//	名称

    /**
     * 列表显示使用
     */
    private String category_name;

}
