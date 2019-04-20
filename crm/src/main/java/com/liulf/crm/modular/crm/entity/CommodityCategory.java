package com.liulf.crm.modular.crm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品类别（dat_commodity_category）
 */
@Data
public class CommodityCategory extends BaseEntity implements Serializable {
    private Long   category_id;//	商品类别
    private String code;
    private String category_name;//	类别名称
}

/**
 DROP TABLE IF EXISTS `dat_commodity_category`;
 CREATE TABLE `dat_commodity_category` (
 `category_id` INT(10) NOT NULL NOT NULL AUTO_INCREMENT COMMENT '商品类别ID',
 `code` VARCHAR(32) DEFAULT NULL COMMENT '商品类编码',
 `category_name` VARCHAR(128) DEFAULT NULL COMMENT '商品类别名称',
 `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
 `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
 `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
 `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
 `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
 PRIMARY KEY (`category_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
 **/