package com.liulf.crm.modular.crm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ManufacturerSales extends BaseEntity implements Serializable {
    private Long sales_id;//	业务员编号
    private Long manufacturer_id;//	厂商ID
    private String sales_name;//	姓名
    private String sales_addr;//	地址
    private String sales_phone;//电话

    /**
     * 列表现实使用
     */
    private String province;//` varchar(20) DEFAULT NULL COMMENT '省',
    private String city;//` varchar(20) DEFAULT NULL COMMENT '市',
    private String area;//` varchar(20) DEFAULT NULL COMMENT '城市编码',
}
