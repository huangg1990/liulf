package com.liulf.crm.modular.crm.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 厂商信息
 */
@Data
public class Manufacturer extends BaseEntity implements Serializable {
    private Long manufacturer_id; //厂商编号
    private String manufacturer_name; //名称
    private String province;//varchar(20) DEFAULT NULL COMMENT '省',
    private String city;//varchar(20) DEFAULT NULL COMMENT '市',
    private String area;// 地区编码
    private String manufacturer_addr; //地址
    private String manufacturer_phone; //电话
    private String manufacturer_post; //邮编
    private String manufacturer_band_account; //银行账号
    private String manufacturer_dept; //业务部门
}
