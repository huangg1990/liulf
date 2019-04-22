package com.liulf.crm.modular.crm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer extends BaseEntity implements Serializable {
    private Long customer_id; //` INT(10) NOT NULL NOT NULL AUTO_INCREMENT COMMENT '客户编号',
    private String customer_name;//` VARCHAR(128) DEFAULT NULL COMMENT '姓名',
    private String province;//` varchar(20) DEFAULT NULL COMMENT '省',
    private String city;//` varchar(20) DEFAULT NULL COMMENT '市',
    private String area;//` varchar(20) DEFAULT NULL COMMENT '城市编码',
    private String customer_phone;// VARCHAR(64) DEFAULT NULL COMMENT '电话',
    private String customer_car_card;//` VARCHAR(128) DEFAULT NULL COMMENT '车牌号码',
    private String car_id;//` VARCHAR(128) DEFAULT NULL COMMENT '车款ID',
    private String customer_addr;//` VARCHAR(128) DEFAULT NULL COMMENT '住址',
    private Character gender;//` VARCHAR(1) DEFAULT NULL COMMENT '性别',
}

