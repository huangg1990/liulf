/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : liulf_crm

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 22/04/2019 14:37:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dat_commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `dat_commodity_category`;
CREATE TABLE `dat_commodity_category` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品类别ID',
  `code` varchar(32) DEFAULT NULL COMMENT '商品类编码',
  `category_name` varchar(128) DEFAULT NULL COMMENT '商品类别名称',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dat_commodity_category
-- ----------------------------
BEGIN;
INSERT INTO `dat_commodity_category` VALUES (1, 'BYL', '保养', '', 'N', '2019-04-22 10:07:02', 1, '2019-04-22 10:09:40', 1);
INSERT INTO `dat_commodity_category` VALUES (2, 'WXL', '维修', '', 'N', '2019-04-22 10:07:13', 1, '2019-04-22 10:09:36', 1);
INSERT INTO `dat_commodity_category` VALUES (3, 'WSPJ', '外饰配件', '', 'N', '2019-04-22 10:07:25', 1, '2019-04-22 14:10:35', 1);
INSERT INTO `dat_commodity_category` VALUES (4, 'NSPJ', '内饰配件', '', 'N', '2019-04-22 14:10:15', 1, '2019-04-22 14:10:15', 1);
COMMIT;

-- ----------------------------
-- Table structure for dat_customer
-- ----------------------------
DROP TABLE IF EXISTS `dat_customer`;
CREATE TABLE `dat_customer` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `customer_name` varchar(128) DEFAULT NULL COMMENT '姓名',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `customer_phone` varchar(64) DEFAULT NULL COMMENT '电话',
  `customer_car_card` varchar(128) DEFAULT NULL COMMENT '车牌号码',
  `car_id` varchar(128) DEFAULT NULL COMMENT '车款ID',
  `customer_addr` varchar(128) DEFAULT NULL COMMENT '住址',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dat_customer
-- ----------------------------
BEGIN;
INSERT INTO `dat_customer` VALUES (2, '黄钢', '110000', '110100', '110101', '18379787654', 'M8823fs', NULL, '生命科学园', 'M', '浦东', 'N', '2019-04-22 14:33:46', 1, '2019-04-22 14:34:03', 1);
INSERT INTO `dat_customer` VALUES (3, '发发发', '110000', '110100', '110102', '13098498764', 'M9992342', NULL, 'sfsadfasdf ', 'M', '', 'Y', '2019-04-22 14:36:01', 1, '2019-04-22 14:36:09', 1);
COMMIT;

-- ----------------------------
-- Table structure for dat_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `dat_manufacturer`;
CREATE TABLE `dat_manufacturer` (
  `manufacturer_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '厂商ID',
  `manufacturer_name` varchar(128) DEFAULT NULL COMMENT '厂商名称',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '城市编码',
  `manufacturer_addr` varchar(128) DEFAULT NULL COMMENT '地址',
  `manufacturer_phone` varchar(128) DEFAULT NULL COMMENT '电话',
  `manufacturer_post` varchar(128) DEFAULT NULL COMMENT '邮政编码',
  `manufacturer_band_account` varchar(128) DEFAULT NULL COMMENT '银行账号',
  `manufacturer_dept` varchar(128) DEFAULT NULL COMMENT '业务部门',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '删除标志位 N 未删除  Y 已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` int(10) DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`manufacturer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dat_manufacturer
-- ----------------------------
BEGIN;
INSERT INTO `dat_manufacturer` VALUES (1, '北汽', '110000', '110100', '110102', '大望路39号', '0717-8997003', '', '', '', '', 'N', '2019-04-22 10:14:12', 1, '2019-04-22 10:14:12', 1);
INSERT INTO `dat_manufacturer` VALUES (2, '奔驰', '110000', '110100', '110101', '海淀南路39号', '18293817161', '', '', '', '', 'N', '2019-04-22 10:14:48', 1, '2019-04-22 10:14:48', 1);
INSERT INTO `dat_manufacturer` VALUES (3, '宝马', '340000', '340100', '340104', '和平路98号4楼', '989-1093113', '', '', '', '', 'N', '2019-04-22 14:11:14', 1, '2019-04-22 14:11:25', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PID` bigint(20) DEFAULT NULL COMMENT '父部门id',
  `PIDS` varchar(512) DEFAULT NULL COMMENT '父级ids',
  `SIMPLE_NAME` varchar(45) DEFAULT NULL COMMENT '简称',
  `FULL_NAME` varchar(255) DEFAULT NULL COMMENT '全称',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '描述',
  `VERSION` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1119270394835005443 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` VALUES (25, 0, '[0],', '技术部', '技术部', '技术部', NULL, 2, NULL, '2019-04-20 00:04:29', NULL, 1);
INSERT INTO `sys_dept` VALUES (26, 0, '[0],', '运营部', '运营部', '运营部', NULL, 3, NULL, '2019-04-20 00:04:56', NULL, 1);
INSERT INTO `sys_dept` VALUES (27, 0, '[0],', '战略部', '战略部', '战略部', NULL, 4, NULL, '2019-04-20 00:05:07', NULL, 1);
INSERT INTO `sys_dept` VALUES (1119270394835005442, 0, '[0],', '人事部', '人事部', '人事部', NULL, 5, '2019-04-20 00:03:52', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `DICT_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PID` bigint(20) DEFAULT NULL COMMENT '父级字典id',
  `NAME` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `CODE` varchar(255) DEFAULT NULL COMMENT '字典的编码',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`DICT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1117265736566259714 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES (50, 0, '性别', 'SEX', '', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (51, 50, '男', 'M', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (52, 50, '女', 'F', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (56, 0, '账号状态', 'ACCOUNT_STATUS', '', 0, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (57, 56, '启用', 'ENABLE', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (58, 56, '冻结', 'FREEZE', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (59, 56, '已删除', 'DELETED', NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `sys_dict` VALUES (1071611355157749761, 0, '是否删除', 'DEL_FLAG', '用于数据库中是否删除的标记', NULL, '2018-12-09 11:43:51', NULL, 1, NULL);
INSERT INTO `sys_dict` VALUES (1071611420735692802, 1071611355157749761, '已经删除', 'Y', '', NULL, '2018-12-09 11:44:07', NULL, 1, NULL);
INSERT INTO `sys_dict` VALUES (1071611458312462337, 1071611355157749761, '未删除', 'N', '', NULL, '2018-12-09 11:44:16', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_file_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_info`;
CREATE TABLE `sys_file_info` (
  `FILE_ID` varchar(50) NOT NULL COMMENT '主键id',
  `FILE_DATA` text COMMENT 'base64编码的文件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`FILE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文件信息表\r\n';

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `LOGIN_LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOG_NAME` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `SUCCEED` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `MESSAGE` text COMMENT '具体消息',
  `IP_ADDRESS` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`LOGIN_LOG_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1120213917979791363 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_login_log` VALUES (1119272297841061890, '退出日志', 1, '2019-04-20 00:11:26', '成功', NULL, '127.0.0.1');
INSERT INTO `sys_login_log` VALUES (1119272317671731201, '登录日志', 1, '2019-04-20 00:11:30', '成功', NULL, '127.0.0.1');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CODE` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `PCODE` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `PCODES` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `NAME` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `ICON` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `URL` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `SORT` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `LEVELS` int(65) DEFAULT NULL COMMENT '菜单层级',
  `MENU_FLAG` varchar(32) DEFAULT NULL COMMENT '是否是菜单(字典)',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '备注',
  `STATUS` varchar(32) DEFAULT 'ENABLE' COMMENT '菜单状态(字典)',
  `NEW_PAGE_FLAG` varchar(32) DEFAULT NULL COMMENT '是否打开新页面的标识(字典)',
  `OPEN_FLAG` varchar(32) DEFAULT NULL COMMENT '是否打开(字典)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1120147463284609027 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (105, 'system', '0', '[0],', '系统管理', 'layui-icon layui-icon-username', '#', 30, 1, 'Y', NULL, 'ENABLE', NULL, '1', NULL, '2019-03-26 12:56:28', NULL, 1);
INSERT INTO `sys_menu` VALUES (106, 'mgr', 'design', '[0],[design],', '员工管理', '', '/mgr', 1, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-04-20 00:21:17', NULL, 1);
INSERT INTO `sys_menu` VALUES (107, 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', NULL, '/mgr/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (108, 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', NULL, '/mgr/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (109, 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', NULL, '/mgr/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (110, 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', NULL, '/mgr/reset', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (111, 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', NULL, '/mgr/freeze', 5, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (112, 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', NULL, '/mgr/unfreeze', 6, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (113, 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', NULL, '/mgr/setRole', 7, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (114, 'role', 'quanxian', '[0],[quanxian],', '角色管理', '', '/role', 2, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-04-20 00:26:25', NULL, 1);
INSERT INTO `sys_menu` VALUES (115, 'role_add', 'role', '[0],[system],[role],', '添加角色', NULL, '/role/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (116, 'role_edit', 'role', '[0],[system],[role],', '修改角色', NULL, '/role/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (117, 'role_remove', 'role', '[0],[system],[role],', '删除角色', NULL, '/role/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (118, 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', NULL, '/role/setAuthority', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (119, 'menu', 'system', '[0],[system],', '菜单管理', NULL, '/menu', 4, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (120, 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', NULL, '/menu/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (121, 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', NULL, '/menu/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (122, 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', NULL, '/menu/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (128, 'log', 'system', '[0],[system],', '业务日志', NULL, '/log', 6, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (130, 'druid', 'system', '[0],[system],', '监控管理', NULL, '/druid', 7, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (131, 'dept', 'design', '[0],[design],', '部门管理', '', '/dept', 3, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-04-20 00:16:17', NULL, 1);
INSERT INTO `sys_menu` VALUES (132, 'dict', 'system', '[0],[system],', '字典管理', NULL, '/dict', 4, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (133, 'loginLog', 'system', '[0],[system],', '登录日志', NULL, '/loginLog', 6, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (134, 'log_clean', 'log', '[0],[system],[log],', '清空日志', NULL, '/log/delLog', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (135, 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', NULL, '/dept/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (136, 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', NULL, '/dept/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (137, 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', NULL, '/dept/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (138, 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', NULL, '/dict/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (139, 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', NULL, '/dict/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (140, 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', NULL, '/dict/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (141, 'notice', 'design', '[0],[design],', '通知管理', '', '/notice', 9, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-04-20 00:23:08', NULL, 1);
INSERT INTO `sys_menu` VALUES (142, 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', NULL, '/notice/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (143, 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', NULL, '/notice/update', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (144, 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', NULL, '/notice/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (145, 'hello', 'system_message', '[0],[system_message],', '系统消息', 'layui-icon layui-icon-tips', '/notice/hello', 1, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-02-11 15:47:19', NULL, 1);
INSERT INTO `sys_menu` VALUES (150, 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (151, 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (152, 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (153, 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (154, 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (155, 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (156, 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (157, 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (158, 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (159, 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (160, 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (161, 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (162, 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (163, 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (164, 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', 7, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (165, 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', 8, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (166, 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', 9, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (167, 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', 10, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (172, 'system_message', '0', '[0],', '系统消息', 'layui-icon layui-icon-tips', '#', 10, 1, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-02-11 15:47:32', NULL, 1);
INSERT INTO `sys_menu` VALUES (1112532525670105089, 'customer', '0', '[0],', '客户管理', '', '/customer/list', 2, 1, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-01 09:49:59', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112532661309702145, 'manufacturer_list', 'JXC', '[0],[JXC],', '厂商管理', '', '/manufacturer/list', 1, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-01 09:50:31', '2019-04-22 10:03:08', 1, 1);
INSERT INTO `sys_menu` VALUES (1112618084073607169, 'manufacturer_add', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '添加厂商', '', '/manufacturer/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-01 15:29:57', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112618348105043969, 'manufacturer_delete', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '删除厂商', '', '/manufacturer/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-01 15:31:00', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112618741052608514, 'manufacturer_update', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '修改厂商', '', '/manufacturer/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-01 15:32:34', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112619131173212161, 'manufacturer_edit', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '厂商修改', '', '/manufacturer/view_update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-01 15:34:07', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112619359217520642, 'manufacturer_add', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '添加厂商', '', '/manufacturer/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-01 15:35:01', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1112897475081031682, 'customer_list', 'customer', '[0],[customer],', '客户管理', '', '/customer/list', 1, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-02 10:00:09', '2019-04-22 12:45:18', 1, 1);
INSERT INTO `sys_menu` VALUES (1112897942594932737, 'customer_add', 'customer_list', '[0],[customer],[customer_list],', '添加客户', '', '/customer/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 10:02:01', '2019-04-22 12:40:55', 1, 1);
INSERT INTO `sys_menu` VALUES (1112898340365946881, 'customer_add', 'customer_list', '[0],[customer],[customer_list],', '添加客户', '', '/customer/view_add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 10:03:36', '2019-04-22 12:41:39', 1, 1);
INSERT INTO `sys_menu` VALUES (1112958133982130178, 'customer_delete', 'customer_list', '[0],[customer],[customer_list],', '删除客户', '', '/customer/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 14:01:12', '2019-04-22 12:42:03', 1, 1);
INSERT INTO `sys_menu` VALUES (1112969005920145409, 'customer_update', 'customer_list', '[0],[customer],[customer_list],', '修改客户', '', '/customer/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 14:44:24', '2019-04-22 12:42:33', 1, 1);
INSERT INTO `sys_menu` VALUES (1112969548256235521, 'to_customer_update', 'customer_list', '[0],[customer],[customer_list],', '修改客户', '', '/customer/view_update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 14:46:33', '2019-04-22 12:43:15', 1, 1);
INSERT INTO `sys_menu` VALUES (1112969893703307266, 'customer_detail', 'customer_list', '[0],[customer],[customer_list],', '客户详情', '', '/customer/detail', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-02 14:47:55', '2019-04-22 12:43:53', 1, 1);
INSERT INTO `sys_menu` VALUES (1113256458614620161, 'manufacturer_select', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '厂商选择', '', '/manufacturer/select', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-03 09:46:38', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1113267293315559426, 'manufacturer_detail', 'manufacturer_list', '[0],[customer],[manufacturer_list],', '厂商查看', '', '/manufacturer/detail', 0, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-03 10:29:41', '2019-04-22 12:40:10', 1, 1);
INSERT INTO `sys_menu` VALUES (1113279026952273922, 'quanxian', '0', '[0],', '权限管理', '', 'quanxian', 10, 1, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-03 11:16:18', '2019-04-20 00:25:59', 1, 1);
INSERT INTO `sys_menu` VALUES (1113314822306451457, 'design', '0', '[0],', '人事管理', '', 'employe', 4, 1, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-03 13:38:33', '2019-04-20 00:22:33', 1, 1);
INSERT INTO `sys_menu` VALUES (1119603264858357761, 'JXC', '0', '[0],', '进销存管理', '', 'JXC', 1, 1, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-20 22:06:34', NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (1119603493628280833, 'commodity_category', 'JXC', '[0],[JXC],', '商品分类管理', '', 'commodity_category/list', 1, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-04-20 22:07:29', NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (1119603679918292994, 'commodity_category_add', 'commodity_category', '[0],[JXC],[commodity_category],', '商品分类管理添加', '', '/commodity_category/add', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-20 22:08:13', '2019-04-22 10:08:21', 1, 1);
INSERT INTO `sys_menu` VALUES (1119603911414513666, 'commodity_category_update', 'commodity_category', '[0],[JXC],[commodity_category],', '商品分类修改', '', '/commodity_category/update', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-20 22:09:08', '2019-04-22 10:06:12', 1, 1);
INSERT INTO `sys_menu` VALUES (1119604043476369410, 'commodity_category_delete', 'commodity_category', '[0],[JXC],[commodity_category],', '商品分类删除', '', '/commodity_category/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-20 22:09:40', '2019-04-22 10:06:24', 1, 1);
INSERT INTO `sys_menu` VALUES (1120147463284609026, 'commodity_category_detail', 'commodity_category', '[0],[JXC],[commodity_category],', '商品分类详情', '', '/commodity_category/detail', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, '2019-04-22 10:09:01', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `NOTICE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `CONTENT` text COMMENT '内容',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`NOTICE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1119274426534227971 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice` VALUES (1119273934408151041, '2019-04-20放假一天', '关于元旦放假的通知\n各位同仁：\n　　20xx年1月1日——元旦为国家法定假日，放假一天。\n　　为便于各部门及早合理地安排节假日生产等有关工作，现将元旦放假调休日期具体安排通知如下：\n　　200xx年12月30日—200xx年1月1日放假，共3天。其中，1月1日& #40;星期二& #41;为法定节假日，12月30日& #40;星期日& #41;为公休日，12月29日& #40;星期六& #41;公休日调至12月31日& #40;星期一& #41;，12月29日& #40;星期六& #41;上班。\n　　节假日期间，各部门要认真做好各项工作：\n　　& #40;1& #41;加强节日期间安全生产和其它工作领导，强化监督管理，落实各项安全措施，确保节日期间的安全生产。\n　　& #40;2& #41;要做好节日期间的值班和安全保卫工作，严格值班制度，并要有领导带班、值班制度，值班人员要恪尽职守，遇到重大问题和紧急突发事件，要在第一时间向上级请示报告，妥善处理，不得延误。在新的一年到来之际确保过上一个欢乐、祥和的节日。\n　　请各部门将节日值班表于12月29日前报公司办公室。\n**有限责任公司\nXXXX年XX月XX日', '2019-04-20 00:17:56', 1, '2019-04-20 00:19:25', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `OPERATION_LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOG_TYPE` varchar(32) DEFAULT NULL COMMENT '日志类型(字典)',
  `LOG_NAME` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `USER_ID` bigint(65) DEFAULT NULL COMMENT '用户id',
  `CLASS_NAME` varchar(255) DEFAULT NULL COMMENT '类名称',
  `METHOD` text COMMENT '方法名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `SUCCEED` varchar(32) DEFAULT NULL COMMENT '是否成功(字典)',
  `MESSAGE` text COMMENT '备注',
  PRIMARY KEY (`OPERATION_LOG_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1120213599728586755 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_operation_log` VALUES (1119273166435282945, '业务日志', '修改菜单', 1, 'com.liulf.crm.modular.system.controller.MenuController', 'edit', '2019-04-20 00:14:53', '成功', '菜单名称=员工管理;;;字段名称:菜单名称,旧值:作品管理,新值:员工管理;;;字段名称:url地址,旧值:design,新值:employe');
INSERT INTO `sys_operation_log` VALUES (1119273290242748418, '业务日志', '修改菜单', 1, 'com.liulf.crm.modular.system.controller.MenuController', 'edit', '2019-04-20 00:15:22', '成功', '菜单名称=用户管理;;;');
COMMIT;

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `RELATION_ID` bigint(20) NOT NULL COMMENT '主键',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`RELATION_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
BEGIN;
INSERT INTO `sys_relation` VALUES (1119278157883535361, 172, 1110402389680799745);
INSERT INTO `sys_relation` VALUES (1119278157921284098, 145, 1110402389680799745);
INSERT INTO `sys_relation` VALUES (1119279748145508353, 172, 1119269662790545409);
INSERT INTO `sys_relation` VALUES (1119279748183257090, 145, 1119269662790545409);
INSERT INTO `sys_relation` VALUES (1119279895793397761, 172, 1110402703939026945);
INSERT INTO `sys_relation` VALUES (1119279895822757889, 145, 1110402703939026945);
INSERT INTO `sys_relation` VALUES (1119280287193264130, 105, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287231012866, 133, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287256178689, 160, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287277150209, 161, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287302316034, 172, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287327481857, 145, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287348453378, 1113314822306451457, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287386202114, 106, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287411367937, 107, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287432339457, 108, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287457505281, 109, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287482671106, 110, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287503642625, 111, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287528808450, 112, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287549779969, 113, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287579140098, 165, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287604305921, 166, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287633666049, 167, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287658831873, 131, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287692386305, 135, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287717552130, 136, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287746912258, 137, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287780466689, 152, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287814021122, 153, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287843381249, 154, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287868547074, 141, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287893712897, 142, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287923073026, 143, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280287948238849, 144, 1119278355137458177);
INSERT INTO `sys_relation` VALUES (1119280511898906625, 105, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280511932461057, 128, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280511966015489, 134, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280511991181313, 158, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512016347137, 159, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512041512962, 133, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512096038914, 160, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512133787649, 161, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512171536386, 172, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512205090818, 145, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512242839553, 1113279026952273922, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512272199681, 114, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512293171201, 115, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512318337026, 116, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512347697154, 117, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512385445889, 118, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512419000322, 162, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512439971842, 163, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512460943362, 164, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512486109185, 1113314822306451457, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512515469314, 106, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512536440833, 107, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512565800961, 108, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512590966786, 109, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512620326913, 110, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512641298434, 111, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512666464257, 112, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512691630082, 113, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512716795906, 165, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512737767425, 166, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512771321858, 167, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512800681985, 131, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512825847810, 135, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512851013633, 136, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512876179458, 137, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512901345282, 152, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512926511105, 153, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512951676929, 154, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280512976842754, 141, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280513002008578, 142, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280513027174401, 143, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1119280513052340225, 144, 1119280408257654786);
INSERT INTO `sys_relation` VALUES (1120186530663686145, 105, 1);
INSERT INTO `sys_relation` VALUES (1120186530672074753, 119, 1);
INSERT INTO `sys_relation` VALUES (1120186530684657666, 120, 1);
INSERT INTO `sys_relation` VALUES (1120186530693046273, 121, 1);
INSERT INTO `sys_relation` VALUES (1120186530701434882, 122, 1);
INSERT INTO `sys_relation` VALUES (1120186530714017794, 150, 1);
INSERT INTO `sys_relation` VALUES (1120186530722406402, 151, 1);
INSERT INTO `sys_relation` VALUES (1120186530730795009, 128, 1);
INSERT INTO `sys_relation` VALUES (1120186530739183618, 134, 1);
INSERT INTO `sys_relation` VALUES (1120186530747572225, 158, 1);
INSERT INTO `sys_relation` VALUES (1120186530755960834, 159, 1);
INSERT INTO `sys_relation` VALUES (1120186530764349442, 130, 1);
INSERT INTO `sys_relation` VALUES (1120186530772738050, 132, 1);
INSERT INTO `sys_relation` VALUES (1120186530781126658, 138, 1);
INSERT INTO `sys_relation` VALUES (1120186530789515265, 139, 1);
INSERT INTO `sys_relation` VALUES (1120186530797903873, 140, 1);
INSERT INTO `sys_relation` VALUES (1120186530806292481, 155, 1);
INSERT INTO `sys_relation` VALUES (1120186530814681090, 156, 1);
INSERT INTO `sys_relation` VALUES (1120186530823069697, 157, 1);
INSERT INTO `sys_relation` VALUES (1120186530827264002, 133, 1);
INSERT INTO `sys_relation` VALUES (1120186530839846914, 160, 1);
INSERT INTO `sys_relation` VALUES (1120186530844041217, 161, 1);
INSERT INTO `sys_relation` VALUES (1120186530852429825, 172, 1);
INSERT INTO `sys_relation` VALUES (1120186530860818434, 145, 1);
INSERT INTO `sys_relation` VALUES (1120186530869207042, 1112532525670105089, 1);
INSERT INTO `sys_relation` VALUES (1120186530873401345, 1112897475081031682, 1);
INSERT INTO `sys_relation` VALUES (1120186530881789953, 1112897942594932737, 1);
INSERT INTO `sys_relation` VALUES (1120186530890178561, 1112898340365946881, 1);
INSERT INTO `sys_relation` VALUES (1120186530894372865, 1112958133982130178, 1);
INSERT INTO `sys_relation` VALUES (1120186530902761474, 1112969005920145409, 1);
INSERT INTO `sys_relation` VALUES (1120186530911150081, 1112969548256235521, 1);
INSERT INTO `sys_relation` VALUES (1120186530919538689, 1112969893703307266, 1);
INSERT INTO `sys_relation` VALUES (1120186530923732994, 1113279026952273922, 1);
INSERT INTO `sys_relation` VALUES (1120186530932121602, 114, 1);
INSERT INTO `sys_relation` VALUES (1120186530940510210, 115, 1);
INSERT INTO `sys_relation` VALUES (1120186530948898817, 116, 1);
INSERT INTO `sys_relation` VALUES (1120186530953093122, 117, 1);
INSERT INTO `sys_relation` VALUES (1120186530961481730, 118, 1);
INSERT INTO `sys_relation` VALUES (1120186530969870338, 162, 1);
INSERT INTO `sys_relation` VALUES (1120186530978258945, 163, 1);
INSERT INTO `sys_relation` VALUES (1120186530986647553, 164, 1);
INSERT INTO `sys_relation` VALUES (1120186530995036161, 1113314822306451457, 1);
INSERT INTO `sys_relation` VALUES (1120186531003424769, 106, 1);
INSERT INTO `sys_relation` VALUES (1120186531011813378, 107, 1);
INSERT INTO `sys_relation` VALUES (1120186531020201985, 108, 1);
INSERT INTO `sys_relation` VALUES (1120186531028590594, 109, 1);
INSERT INTO `sys_relation` VALUES (1120186531036979201, 110, 1);
INSERT INTO `sys_relation` VALUES (1120186531045367810, 111, 1);
INSERT INTO `sys_relation` VALUES (1120186531053756417, 112, 1);
INSERT INTO `sys_relation` VALUES (1120186531062145026, 113, 1);
INSERT INTO `sys_relation` VALUES (1120186531070533633, 165, 1);
INSERT INTO `sys_relation` VALUES (1120186531078922241, 166, 1);
INSERT INTO `sys_relation` VALUES (1120186531087310850, 167, 1);
INSERT INTO `sys_relation` VALUES (1120186531095699458, 131, 1);
INSERT INTO `sys_relation` VALUES (1120186531104088065, 135, 1);
INSERT INTO `sys_relation` VALUES (1120186531112476674, 136, 1);
INSERT INTO `sys_relation` VALUES (1120186531116670977, 137, 1);
INSERT INTO `sys_relation` VALUES (1120186531129253890, 152, 1);
INSERT INTO `sys_relation` VALUES (1120186531137642497, 153, 1);
INSERT INTO `sys_relation` VALUES (1120186531141836801, 154, 1);
INSERT INTO `sys_relation` VALUES (1120186531154419713, 141, 1);
INSERT INTO `sys_relation` VALUES (1120186531162808322, 142, 1);
INSERT INTO `sys_relation` VALUES (1120186531171196929, 143, 1);
INSERT INTO `sys_relation` VALUES (1120186531179585537, 144, 1);
INSERT INTO `sys_relation` VALUES (1120186531187974146, 1119603264858357761, 1);
INSERT INTO `sys_relation` VALUES (1120186531196362753, 1112532661309702145, 1);
INSERT INTO `sys_relation` VALUES (1120186531204751362, 1112618084073607169, 1);
INSERT INTO `sys_relation` VALUES (1120186531208945665, 1112618348105043969, 1);
INSERT INTO `sys_relation` VALUES (1120186531217334274, 1112618741052608514, 1);
INSERT INTO `sys_relation` VALUES (1120186531225722882, 1112619131173212161, 1);
INSERT INTO `sys_relation` VALUES (1120186531234111489, 1112619359217520642, 1);
INSERT INTO `sys_relation` VALUES (1120186531242500097, 1113256458614620161, 1);
INSERT INTO `sys_relation` VALUES (1120186531246694401, 1113267293315559426, 1);
INSERT INTO `sys_relation` VALUES (1120186531255083010, 1119603493628280833, 1);
INSERT INTO `sys_relation` VALUES (1120186531263471618, 1119603679918292994, 1);
INSERT INTO `sys_relation` VALUES (1120186531271860226, 1119603911414513666, 1);
INSERT INTO `sys_relation` VALUES (1120186531280248834, 1119604043476369410, 1);
INSERT INTO `sys_relation` VALUES (1120186531288637441, 1120147463284609026, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PID` bigint(20) DEFAULT NULL COMMENT '父角色id',
  `NAME` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '提示',
  `SORT` int(11) DEFAULT NULL COMMENT '序号',
  `VERSION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1119280408257654787 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 0, '超级管理员', 'administrator', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (1110402389680799745, 0, '服务顾问', '服务顾问', 0, NULL, '2019-03-26 12:45:35', '2019-04-20 00:00:32', 1, 1);
INSERT INTO `sys_role` VALUES (1110402703939026945, 0, '维修技术员', '维修技术员', 0, NULL, '2019-03-26 12:46:50', '2019-04-20 00:01:15', 1, 1);
INSERT INTO `sys_role` VALUES (1119269662790545409, 0, '财务', '财务', 4, NULL, '2019-04-20 00:00:57', NULL, 1, NULL);
INSERT INTO `sys_role` VALUES (1119278355137458177, 0, '人事人员', '人事人员', 6, NULL, '2019-04-20 00:35:30', NULL, 1, NULL);
INSERT INTO `sys_role` VALUES (1119280408257654786, 0, 'BOOS', 'BOOS', 6, NULL, '2019-04-20 00:43:39', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` bigint(20) NOT NULL COMMENT '主键id',
  `AVATAR` varchar(255) DEFAULT NULL COMMENT '头像',
  `ACCOUNT` varchar(45) DEFAULT NULL COMMENT '账号',
  `PASSWORD` varchar(45) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `NAME` varchar(45) DEFAULT NULL COMMENT '名字',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `SEX` varchar(32) DEFAULT NULL COMMENT '性别(字典)',
  `EMAIL` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `PHONE` varchar(45) DEFAULT NULL COMMENT '电话',
  `ROLE_ID` varchar(255) DEFAULT NULL COMMENT '角色id(多个逗号隔开)',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '部门id(多个逗号隔开)',
  `STATUS` varchar(32) DEFAULT NULL COMMENT '状态(字典)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '更新人',
  `VERSION` int(11) DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, '1', 'admin', '507c9a3645aacca3dc106e5c3db499d0', 'q6taw', 'admin', '2019-03-26 00:00:00', 'M', 'admin@qq.com', '18200000000', '1', 0, 'ENABLE', '2016-01-29 08:49:53', NULL, '2019-04-19 23:42:58', 24, 25);
INSERT INTO `sys_user` VALUES (1119271483839901697, NULL, 'liulf', '3fb1b67d1f2eb707154d43a777d340c7', 'qb6bn', '刘连峰', '1988-10-08 00:00:00', 'M', '383830950@qq.com', '', '1119280408257654786', 26, 'ENABLE', '2019-04-20 00:08:11', 1, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
