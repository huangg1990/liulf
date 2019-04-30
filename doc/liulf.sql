-- 商品类别
DROP TABLE IF EXISTS `dat_commodity_category`;
 CREATE TABLE `dat_commodity_category` (
 `category_id` INT(10) NOT NULL  AUTO_INCREMENT COMMENT '商品类别ID',
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

 -- 商品
DROP TABLE IF EXISTS `dat_commodity`;
 CREATE TABLE `dat_commodity` (
 `commodity_id` INT(10) NOT NULL  AUTO_INCREMENT COMMENT '商品ID',
 `category_id` INT(10) NOT NULL COMMENT '商品类别ID',
 `commodity_code` VARCHAR(32) DEFAULT NULL COMMENT '商品编码',
 `commodity_name` VARCHAR(128) DEFAULT NULL COMMENT '商品名称',
 `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
 `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
 `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
 `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
 `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
 PRIMARY KEY (`commodity_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

-- 厂商
DROP TABLE IF EXISTS `dat_manufacturer`;
 CREATE TABLE `dat_manufacturer` (
  `manufacturer_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '厂商ID',
  `manufacturer_name` VARCHAR(128) DEFAULT NULL COMMENT '厂商名称',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `manufacturer_addr` VARCHAR(128) DEFAULT NULL COMMENT '地址',
  `manufacturer_phone` VARCHAR(128) DEFAULT NULL COMMENT '电话',
  `manufacturer_post` VARCHAR(128) DEFAULT NULL COMMENT '邮政编码',
  `manufacturer_band_account` VARCHAR(128) DEFAULT NULL COMMENT '银行账号',
  `manufacturer_dept` VARCHAR(128) DEFAULT NULL COMMENT '业务部门',
  `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
  `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`manufacturer_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


 -- 厂商业务员
DROP TABLE IF EXISTS `dat_manufacturer_sales`;
 CREATE TABLE `dat_manufacturer_sales` (
  `sales_id` INT(10) NOT NULL NOT NULL AUTO_INCREMENT COMMENT '厂商业务员ID',
  `manufacturer_id` INT(10) NOT NULL  COMMENT '厂商ID',
  `sales_name` VARCHAR(128) DEFAULT NULL COMMENT '厂商业务员姓名',
  `sales_addr` VARCHAR(128) DEFAULT NULL COMMENT '厂商业务员地址',
  `sales_phone` VARCHAR(128) DEFAULT NULL COMMENT '厂商业务员电话',
  `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
  `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`sales_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

-- 客户表
DROP TABLE IF EXISTS `dat_customer`;
 CREATE TABLE `dat_customer` (
  `customer_id` INT(10) NOT NULL NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` VARCHAR(128) DEFAULT NULL COMMENT '姓名',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `customer_phone` VARCHAR(64) DEFAULT NULL COMMENT '电话',
  `customer_car_card` VARCHAR(128) DEFAULT NULL COMMENT '车牌号码',
  `car_brand_id` VARCHAR(128) DEFAULT NULL COMMENT '品牌',
  `car_serial_id` VARCHAR(128) DEFAULT NULL COMMENT '子品牌',
  `car_basic_id` VARCHAR(128) DEFAULT NULL COMMENT '车款ID',
  `customer_addr` VARCHAR(128) DEFAULT NULL COMMENT '住址',
  `gender` VARCHAR(1) DEFAULT NULL COMMENT '性别',
  `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
  `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`customer_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

-- 支出类别
DROP TABLE IF EXISTS `dat_spend_category`;
 CREATE TABLE `dat_spend_category` (
 `spend_category_id` INT(10) NOT NULL  AUTO_INCREMENT COMMENT '支出类别ID',
 `spend_category_code` VARCHAR(32) DEFAULT NULL COMMENT '支出类编码',
 `spend_category_name` VARCHAR(128) DEFAULT NULL COMMENT '支出类别名称',
 `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
 `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
 `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
 `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
 `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
 PRIMARY KEY (`spend_category_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


 -- 支出明细
DROP TABLE IF EXISTS `dat_spend`;
 CREATE TABLE `dat_spend` (
 `spend_id` INT(10) NOT NULL  AUTO_INCREMENT COMMENT '支出ID',
 `spend_category_id` INT(10) NOT NULL  COMMENT '支出类别ID',
 `price` DECIMAL(10,2) DEFAULT NULL COMMENT '支出金额',
 `spend_date` DATETIME DEFAULT NULL COMMENT '支出日期',
 `user_id` INT(10) DEFAULT NULL COMMENT '经手员工ID',
 `note` VARCHAR(1024) DEFAULT NULL COMMENT '备注',
 `delete_flag` VARCHAR(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
 `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
 `create_user` INT(10) DEFAULT NULL COMMENT '创建用户ID',
 `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
 `update_user` INT(10) DEFAULT NULL COMMENT '修改用户ID',
 PRIMARY KEY (`spend_id`) USING BTREE
 ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;



















