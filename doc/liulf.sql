-- 商品类别
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

-- 厂商
DROP TABLE IF EXISTS `dat_manufacturer`;
 CREATE TABLE `dat_manufacturer` (
  `manufacturer_id` INT(10) NOT NULL NOT NULL AUTO_INCREMENT COMMENT '厂商ID',
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





















