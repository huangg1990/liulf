/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - liulf_crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liulf_crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `liulf_crm`;

/*Table structure for table `dat_commodity_category` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dat_commodity_category` */

/*Table structure for table `sys_dept` */

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

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`DEPT_ID`,`PID`,`PIDS`,`SIMPLE_NAME`,`FULL_NAME`,`DESCRIPTION`,`VERSION`,`SORT`,`CREATE_TIME`,`UPDATE_TIME`,`CREATE_USER`,`UPDATE_USER`) values (25,0,'[0],','技术部','技术部','技术部',NULL,2,NULL,'2019-04-20 00:04:29',NULL,1),(26,0,'[0],','运营部','运营部','运营部',NULL,3,NULL,'2019-04-20 00:04:56',NULL,1),(27,0,'[0],','战略部','战略部','战略部',NULL,4,NULL,'2019-04-20 00:05:07',NULL,1),(1119270394835005442,0,'[0],','人事部','人事部','人事部',NULL,5,'2019-04-20 00:03:52',NULL,1,NULL);

/*Table structure for table `sys_dict` */

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

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`DICT_ID`,`PID`,`NAME`,`CODE`,`DESCRIPTION`,`SORT`,`CREATE_TIME`,`UPDATE_TIME`,`CREATE_USER`,`UPDATE_USER`) values (50,0,'性别','SEX','',0,NULL,NULL,NULL,NULL),(51,50,'男','M',NULL,1,NULL,NULL,NULL,NULL),(52,50,'女','F',NULL,2,NULL,NULL,NULL,NULL),(56,0,'账号状态','ACCOUNT_STATUS','',0,NULL,NULL,NULL,NULL),(57,56,'启用','ENABLE',NULL,1,NULL,NULL,NULL,NULL),(58,56,'冻结','FREEZE',NULL,2,NULL,NULL,NULL,NULL),(59,56,'已删除','DELETED',NULL,3,NULL,NULL,NULL,NULL),(1071611355157749761,0,'是否删除','DEL_FLAG','用于数据库中是否删除的标记',NULL,'2018-12-09 11:43:51',NULL,1,NULL),(1071611420735692802,1071611355157749761,'已经删除','Y','',NULL,'2018-12-09 11:44:07',NULL,1,NULL),(1071611458312462337,1071611355157749761,'未删除','N','',NULL,'2018-12-09 11:44:16',NULL,1,NULL);

/*Table structure for table `sys_file_info` */

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

/*Data for the table `sys_file_info` */

/*Table structure for table `sys_login_log` */

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
) ENGINE=InnoDB AUTO_INCREMENT=1119603065956073475 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='登录记录';

/*Data for the table `sys_login_log` */

insert  into `sys_login_log`(`LOGIN_LOG_ID`,`LOG_NAME`,`USER_ID`,`CREATE_TIME`,`SUCCEED`,`MESSAGE`,`IP_ADDRESS`) values (1119272297841061890,'退出日志',1,'2019-04-20 00:11:26','成功',NULL,'127.0.0.1'),(1119272317671731201,'登录日志',1,'2019-04-20 00:11:30','成功',NULL,'127.0.0.1'),(1119272386944856065,'登录日志',1,'2019-04-20 00:11:47','成功',NULL,'127.0.0.1'),(1119276286624165889,'登录日志',1,'2019-04-20 00:27:17','成功',NULL,'127.0.0.1'),(1119276807405727745,'登录日志',1,'2019-04-20 00:29:19','成功',NULL,'127.0.0.1'),(1119278782960660482,'登录日志',1119271483839901697,'2019-04-20 00:37:12','成功',NULL,'127.0.0.1'),(1119278920533831682,'登录日志',1119271483839901697,'2019-04-20 00:37:45','成功',NULL,'127.0.0.1'),(1119280134734508033,'退出日志',1119271483839901697,'2019-04-20 00:42:34','成功',NULL,'127.0.0.1'),(1119280170079907842,'登录日志',1119271483839901697,'2019-04-20 00:42:42','成功',NULL,'127.0.0.1'),(1119280869509459969,'退出日志',1119271483839901697,'2019-04-20 00:45:29','成功',NULL,'127.0.0.1'),(1119280908927528962,'登录日志',1119271483839901697,'2019-04-20 00:45:39','成功',NULL,'127.0.0.1'),(1119534744715919361,'登录日志',1,'2019-04-20 17:34:17','成功',NULL,'127.0.0.1'),(1119603065956073474,'登录日志',1,'2019-04-20 22:05:47','成功',NULL,'127.0.0.1');

/*Table structure for table `sys_menu` */

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
) ENGINE=InnoDB AUTO_INCREMENT=1119604043476369411 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`MENU_ID`,`CODE`,`PCODE`,`PCODES`,`NAME`,`ICON`,`URL`,`SORT`,`LEVELS`,`MENU_FLAG`,`DESCRIPTION`,`STATUS`,`NEW_PAGE_FLAG`,`OPEN_FLAG`,`CREATE_TIME`,`UPDATE_TIME`,`CREATE_USER`,`UPDATE_USER`) values (105,'system','0','[0],','系统管理','layui-icon layui-icon-username','#',30,1,'Y',NULL,'ENABLE',NULL,'1',NULL,'2019-03-26 12:56:28',NULL,1),(106,'mgr','design','[0],[design],','员工管理','','/mgr',1,2,'Y',NULL,'ENABLE',NULL,'0',NULL,'2019-04-20 00:21:17',NULL,1),(107,'mgr_add','mgr','[0],[system],[mgr],','添加用户',NULL,'/mgr/add',1,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(108,'mgr_edit','mgr','[0],[system],[mgr],','修改用户',NULL,'/mgr/edit',2,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(109,'mgr_delete','mgr','[0],[system],[mgr],','删除用户',NULL,'/mgr/delete',3,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(110,'mgr_reset','mgr','[0],[system],[mgr],','重置密码',NULL,'/mgr/reset',4,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(111,'mgr_freeze','mgr','[0],[system],[mgr],','冻结用户',NULL,'/mgr/freeze',5,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(112,'mgr_unfreeze','mgr','[0],[system],[mgr],','解除冻结用户',NULL,'/mgr/unfreeze',6,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(113,'mgr_setRole','mgr','[0],[system],[mgr],','分配角色',NULL,'/mgr/setRole',7,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(114,'role','quanxian','[0],[quanxian],','角色管理','','/role',2,2,'Y',NULL,'ENABLE',NULL,'0',NULL,'2019-04-20 00:26:25',NULL,1),(115,'role_add','role','[0],[system],[role],','添加角色',NULL,'/role/add',1,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(116,'role_edit','role','[0],[system],[role],','修改角色',NULL,'/role/edit',2,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(117,'role_remove','role','[0],[system],[role],','删除角色',NULL,'/role/remove',3,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(118,'role_setAuthority','role','[0],[system],[role],','配置权限',NULL,'/role/setAuthority',4,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(119,'menu','system','[0],[system],','菜单管理',NULL,'/menu',4,2,'Y',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(120,'menu_add','menu','[0],[system],[menu],','添加菜单',NULL,'/menu/add',1,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(121,'menu_edit','menu','[0],[system],[menu],','修改菜单',NULL,'/menu/edit',2,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(122,'menu_remove','menu','[0],[system],[menu],','删除菜单',NULL,'/menu/remove',3,3,'N',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(128,'log','system','[0],[system],','业务日志',NULL,'/log',6,2,'Y',NULL,'ENABLE',NULL,'0',NULL,NULL,NULL,NULL),(130,'druid','system','[0],[system],','监控管理',NULL,'/druid',7,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(131,'dept','design','[0],[design],','部门管理','','/dept',3,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,'2019-04-20 00:16:17',NULL,1),(132,'dict','system','[0],[system],','字典管理',NULL,'/dict',4,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(133,'loginLog','system','[0],[system],','登录日志',NULL,'/loginLog',6,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(134,'log_clean','log','[0],[system],[log],','清空日志',NULL,'/log/delLog',3,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(135,'dept_add','dept','[0],[system],[dept],','添加部门',NULL,'/dept/add',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(136,'dept_update','dept','[0],[system],[dept],','修改部门',NULL,'/dept/update',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(137,'dept_delete','dept','[0],[system],[dept],','删除部门',NULL,'/dept/delete',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(138,'dict_add','dict','[0],[system],[dict],','添加字典',NULL,'/dict/add',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(139,'dict_update','dict','[0],[system],[dict],','修改字典',NULL,'/dict/update',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(140,'dict_delete','dict','[0],[system],[dict],','删除字典',NULL,'/dict/delete',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(141,'notice','design','[0],[design],','通知管理','','/notice',9,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,'2019-04-20 00:23:08',NULL,1),(142,'notice_add','notice','[0],[system],[notice],','添加通知',NULL,'/notice/add',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(143,'notice_update','notice','[0],[system],[notice],','修改通知',NULL,'/notice/update',2,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(144,'notice_delete','notice','[0],[system],[notice],','删除通知',NULL,'/notice/delete',3,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(145,'hello','system_message','[0],[system_message],','系统消息','layui-icon layui-icon-tips','/notice/hello',1,2,'Y',NULL,'ENABLE',NULL,NULL,NULL,'2019-02-11 15:47:19',NULL,1),(150,'to_menu_edit','menu','[0],[system],[menu],','菜单编辑跳转','','/menu/menu_edit',4,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(151,'menu_list','menu','[0],[system],[menu],','菜单列表','','/menu/list',5,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(152,'to_dept_update','dept','[0],[system],[dept],','修改部门跳转','','/dept/dept_update',4,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(153,'dept_list','dept','[0],[system],[dept],','部门列表','','/dept/list',5,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(154,'dept_detail','dept','[0],[system],[dept],','部门详情','','/dept/detail',6,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(155,'to_dict_edit','dict','[0],[system],[dict],','修改菜单跳转','','/dict/dict_edit',4,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(156,'dict_list','dict','[0],[system],[dict],','字典列表','','/dict/list',5,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(157,'dict_detail','dict','[0],[system],[dict],','字典详情','','/dict/detail',6,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(158,'log_list','log','[0],[system],[log],','日志列表','','/log/list',2,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(159,'log_detail','log','[0],[system],[log],','日志详情','','/log/detail',3,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(160,'del_login_log','loginLog','[0],[system],[loginLog],','清空登录日志','','/loginLog/delLoginLog',1,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(161,'login_log_list','loginLog','[0],[system],[loginLog],','登录日志列表','','/loginLog/list',2,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(162,'to_role_edit','role','[0],[system],[role],','修改角色跳转','','/role/role_edit',5,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(163,'to_role_assign','role','[0],[system],[role],','角色分配跳转','','/role/role_assign',6,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(164,'role_list','role','[0],[system],[role],','角色列表','','/role/list',7,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(165,'to_assign_role','mgr','[0],[system],[mgr],','分配角色跳转','','/mgr/role_assign',8,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(166,'to_user_edit','mgr','[0],[system],[mgr],','编辑用户跳转','','/mgr/user_edit',9,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(167,'mgr_list','mgr','[0],[system],[mgr],','用户列表','','/mgr/list',10,3,'N',NULL,'ENABLE',NULL,NULL,NULL,NULL,NULL,NULL),(172,'system_message','0','[0],','系统消息','layui-icon layui-icon-tips','#',10,1,'Y',NULL,'ENABLE',NULL,NULL,NULL,'2019-02-11 15:47:32',NULL,1),(1112532525670105089,'customer','0','[0],','客户管理','','community',2,1,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-01 09:49:59','2019-04-20 17:35:05',1,1),(1112532661309702145,'community_list','customer','[0],[customer],','楼盘管理','','/community/community_list',1,2,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-01 09:50:31','2019-04-20 17:35:05',1,1),(1112618084073607169,'community_add','community_list','[0],[customer],[community_list],','添加楼盘','','/community/add',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-01 15:29:57','2019-04-20 17:35:05',1,1),(1112618348105043969,'community_delete','community_list','[0],[customer],[community_list],','删除楼盘','','/community/delete',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-01 15:31:00','2019-04-20 17:35:05',1,1),(1112618741052608514,'community_update','community_list','[0],[customer],[community_list],','修改楼盘','','/community/update',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-01 15:32:34','2019-04-20 17:35:05',1,1),(1112619131173212161,'to_community_update','community_list','[0],[customer],[community_list],','楼盘修改','','/community/community_update',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-01 15:34:07','2019-04-20 17:35:05',1,1),(1112619359217520642,'to_community_add','community_list','[0],[customer],[community_list],','添加楼盘','','/community/community_add',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-01 15:35:01','2019-04-20 17:35:05',1,1),(1112897475081031682,'shoppingdistrict_list','customer','[0],[customer],','商圈管理','','/shoppingdistrict/shoppingdistrict_list',1,2,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-02 10:00:09','2019-04-20 17:35:05',1,1),(1112897942594932737,'shoppingdistrict_add','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','添加商圈','','/shoppingdistrict/add',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 10:02:01','2019-04-20 17:35:05',1,1),(1112898340365946881,'to_shoppingdistrict_add','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','添加商圈','','/shoppingdistrict/shoppingdistrict_add',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 10:03:36','2019-04-20 17:35:05',1,1),(1112958133982130178,'shoppingdistrict_delete','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','删除商圈','','/shoppingdistrict/delete',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 14:01:12','2019-04-20 17:35:05',1,1),(1112969005920145409,'shoppingdistrict_update','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','商圈修改','','/shoppingdistrict/update',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 14:44:24','2019-04-20 17:35:05',1,1),(1112969548256235521,'to_shoppingdistrict_update','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','商圈修改','','/shoppingdistrict/shoppingdistrict_update',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 14:46:33','2019-04-20 17:35:05',1,1),(1112969893703307266,'shoppingdistrict_detail','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','商圈详情','','/shoppingdistrict/detail',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-02 14:47:55','2019-04-20 17:35:05',1,1),(1113256273071194114,'shoppingdistrict_select','shoppingdistrict_list','[0],[customer],[shoppingdistrict_list],','商圈选择','','/shoppingdistrict/select',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-03 09:45:53','2019-04-20 17:35:05',1,1),(1113256458614620161,'community_select','community_list','[0],[customer],[community_list],','楼盘选择','','/community/select',1,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-03 09:46:38','2019-04-20 17:35:05',1,1),(1113267293315559426,'community_detail','community_list','[0],[customer],[community_list],','楼盘查看','','/community/detail',0,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-03 10:29:41','2019-04-20 17:35:05',1,1),(1113279026952273922,'quanxian','0','[0],','权限管理','','quanxian',10,1,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-03 11:16:18','2019-04-20 00:25:59',1,1),(1113314822306451457,'design','0','[0],','人事管理','','employe',4,1,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-03 13:38:33','2019-04-20 00:22:33',1,1),(1119603264858357761,'JXC','0','[0],','进销存管理','','JXC',1,1,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-20 22:06:34',NULL,1,NULL),(1119603493628280833,'commodity_category','JXC','[0],[JXC],','商品分类管理','','commodity_category/list',1,2,'Y',NULL,'ENABLE',NULL,NULL,'2019-04-20 22:07:29',NULL,1,NULL),(1119603679918292994,'commodity_category_add','commodity_category','[0],[JXC],[commodity_category],','商品分类管理添加','','commodity_category/add',2,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-20 22:08:13','2019-04-20 22:10:30',1,1),(1119603911414513666,'commodity_category_update','commodity_category','[0],[JXC],[commodity_category],','商品分类修改','','commodity_category/update',3,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-20 22:09:08','2019-04-20 22:10:39',1,1),(1119604043476369410,'commodity_category_delete','commodity_category','[0],[JXC],[commodity_category],','商品分类删除','','commodity_category/delete',3,3,'N',NULL,'ENABLE',NULL,NULL,'2019-04-20 22:09:40','2019-04-20 22:10:47',1,1);

/*Table structure for table `sys_notice` */

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

/*Data for the table `sys_notice` */

insert  into `sys_notice`(`NOTICE_ID`,`TITLE`,`CONTENT`,`CREATE_TIME`,`CREATE_USER`,`UPDATE_TIME`,`UPDATE_USER`) values (1119273934408151041,'2019-04-20放假一天','关于元旦放假的通知\n各位同仁：\n　　20xx年1月1日——元旦为国家法定假日，放假一天。\n　　为便于各部门及早合理地安排节假日生产等有关工作，现将元旦放假调休日期具体安排通知如下：\n　　200xx年12月30日—200xx年1月1日放假，共3天。其中，1月1日& #40;星期二& #41;为法定节假日，12月30日& #40;星期日& #41;为公休日，12月29日& #40;星期六& #41;公休日调至12月31日& #40;星期一& #41;，12月29日& #40;星期六& #41;上班。\n　　节假日期间，各部门要认真做好各项工作：\n　　& #40;1& #41;加强节日期间安全生产和其它工作领导，强化监督管理，落实各项安全措施，确保节日期间的安全生产。\n　　& #40;2& #41;要做好节日期间的值班和安全保卫工作，严格值班制度，并要有领导带班、值班制度，值班人员要恪尽职守，遇到重大问题和紧急突发事件，要在第一时间向上级请示报告，妥善处理，不得延误。在新的一年到来之际确保过上一个欢乐、祥和的节日。\n　　请各部门将节日值班表于12月29日前报公司办公室。\n**有限责任公司\nXXXX年XX月XX日','2019-04-20 00:17:56',1,'2019-04-20 00:19:25',1);

/*Table structure for table `sys_operation_log` */

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
) ENGINE=InnoDB AUTO_INCREMENT=1119604326092767234 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

/*Data for the table `sys_operation_log` */

insert  into `sys_operation_log`(`OPERATION_LOG_ID`,`LOG_TYPE`,`LOG_NAME`,`USER_ID`,`CLASS_NAME`,`METHOD`,`CREATE_TIME`,`SUCCEED`,`MESSAGE`) values (1119273166435282945,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:14:53','成功','菜单名称=员工管理;;;字段名称:菜单名称,旧值:作品管理,新值:员工管理;;;字段名称:url地址,旧值:design,新值:employe'),(1119273290242748418,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:15:22','成功','菜单名称=用户管理;;;'),(1119273332286451713,'业务日志','删除菜单',1,'com.liulf.crm.modular.system.controller.MenuController','remove','2019-04-20 00:15:32','成功','菜单名称=作品列表'),(1119273369976467458,'业务日志','删除菜单',1,'com.liulf.crm.modular.system.controller.MenuController','remove','2019-04-20 00:15:41','成功','菜单名称=作品详情'),(1119273398812307458,'业务日志','删除菜单',1,'com.liulf.crm.modular.system.controller.MenuController','remove','2019-04-20 00:15:48','成功','菜单名称=作品审核'),(1119273429762076674,'业务日志','删除菜单',1,'com.liulf.crm.modular.system.controller.MenuController','remove','2019-04-20 00:15:55','成功','菜单名称=作品审核'),(1119273522053541889,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:16:17','成功','菜单名称=部门管理;;;'),(1119273934496231426,'业务日志','新增通知',1,'com.liulf.crm.modular.system.controller.NoticeController','add','2019-04-20 00:17:56','成功','标题=2019-04-20放假一天'),(1119274307395022850,'业务日志','修改通知',1,'com.liulf.crm.modular.system.controller.NoticeController','update','2019-04-20 00:19:25','成功','标题=2019-04-20放假一天;;;字段名称:内容,旧值:2019-04-20放假一天,新值:关于元旦放假的通知\n各位同仁：\n　　20xx年1月1日——元旦为国家法定假日，放假一天。\n　　为便于各部门及早合理地安排节假日生产等有关工作，现将元旦放假调休日期具体安排通知如下：\n　　200xx年12月30日—200xx年1月1日放假，共3天。其中，1月1日& #40;星期二& #41;为法定节假日，12月30日& #40;星期日& #41;为公休日，12月29日& #40;星期六& #41;公休日调至12月31日& #40;星期一& #41;，12月29日& #40;星期六& #41;上班。\n　　节假日期间，各部门要认真做好各项工作：\n　　& #40;1& #41;加强节日期间安全生产和其它工作领导，强化监督管理，落实各项安全措施，确保节日期间的安全生产。\n　　& #40;2& #41;要做好节日期间的值班和安全保卫工作，严格值班制度，并要有领导带班、值班制度，值班人员要恪尽职守，遇到重大问题和紧急突发事件，要在第一时间向上级请示报告，妥善处理，不得延误。在新的一年到来之际确保过上一个欢乐、祥和的节日。\n　　请各部门将节日值班表于12月29日前报公司办公室。\n**有限责任公司\nXXXX年XX月XX日'),(1119274426609725442,'业务日志','新增通知',1,'com.liulf.crm.modular.system.controller.NoticeController','add','2019-04-20 00:19:53','成功','标题=2019-10-19'),(1119274776876052481,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:21:17','成功','菜单名称=员工管理;;;字段名称:菜单名称,旧值:用户管理,新值:员工管理'),(1119275097379598337,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:22:33','成功','菜单名称=人事管理;;;字段名称:菜单名称,旧值:员工管理,新值:人事管理'),(1119275243685310466,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:23:08','成功','菜单名称=通知管理;;;'),(1119275308952875009,'业务日志','删除通知',1,'com.liulf.crm.modular.system.controller.NoticeController','delete','2019-04-20 00:23:23','成功','标题=2019-10-19'),(1119275960529612801,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:25:59','成功','菜单名称=权限管理;;;字段名称:菜单编号,旧值:housetype,新值:quanxian;;;字段名称:菜单名称,旧值:户型管理,新值:权限管理;;;字段名称:url地址,旧值:housetype,新值:quanxian;;;字段名称:菜单排序号,旧值:3,新值:10'),(1119276070806253569,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 00:26:25','成功','菜单名称=角色管理;;;'),(1119276147050311681,'业务日志','删除菜单',1,'com.liulf.crm.modular.system.controller.MenuController','remove','2019-04-20 00:26:43','成功','菜单名称=户型管理'),(1119278158189719554,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:34:43','成功','角色名称=服务顾问,资源名称=系统消息,系统消息'),(1119278209754492930,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:34:55','成功','角色名称=维修技术员,资源名称=系统管理,字典管理,添加字典,修改字典,删除字典,修改菜单跳转,字典列表,字典详情,登录日志,清空登录日志,登录日志列表,系统消息,系统消息'),(1119278355246510081,'业务日志','添加角色',1,'com.liulf.crm.modular.system.controller.RoleController','add','2019-04-20 00:35:30','成功','角色名称=人事人员'),(1119278423441698817,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:35:46','成功','角色名称=人事人员,资源名称=系统消息,系统消息,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119278682804875266,'业务日志','分配角色',1,'com.liulf.crm.modular.system.controller.UserMgrController','setRole','2019-04-20 00:36:48','成功','账号=liulf,角色名称集合=服务顾问,维修技术员,财务,人事人员'),(1119279692935884802,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:40:49','成功','角色名称=人事人员,资源名称=系统管理,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119279748325863426,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:41:02','成功','角色名称=财务,资源名称=系统消息,系统消息'),(1119279824205017090,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:41:20','成功','角色名称=人事人员,资源名称=系统管理,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119279895940198402,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:41:37','成功','角色名称=维修技术员,资源名称=系统消息,系统消息'),(1119279950919135234,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:41:50','成功','角色名称=超级管理员,资源名称=系统管理,菜单管理,添加菜单,修改菜单,删除菜单,菜单编辑跳转,菜单列表,业务日志,清空日志,日志列表,日志详情,监控管理,字典管理,添加字典,修改字典,删除字典,修改菜单跳转,字典列表,字典详情,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,楼盘管理,楼盘管理,添加楼盘,删除楼盘,修改楼盘,楼盘修改,添加楼盘,楼盘选择,楼盘查看,商圈管理,添加商圈,添加商圈,删除商圈,商圈修改,商圈修改,商圈详情,商圈选择,权限管理,角色管理,添加角色,修改角色,删除角色,配置权限,修改角色跳转,角色分配跳转,角色列表,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119280049070043137,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:42:14','成功','角色名称=人事人员,资源名称=系统管理,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119280288661270529,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:43:11','成功','角色名称=人事人员,资源名称=系统管理,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119280408341540865,'业务日志','添加角色',1,'com.liulf.crm.modular.system.controller.RoleController','add','2019-04-20 00:43:39','成功','角色名称=BOOS'),(1119280513639542785,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 00:44:04','成功','角色名称=BOOS,资源名称=系统管理,业务日志,清空日志,日志列表,日志详情,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,权限管理,角色管理,添加角色,修改角色,删除角色,配置权限,修改角色跳转,角色分配跳转,角色列表,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知'),(1119280685362737153,'业务日志','分配角色',1,'com.liulf.crm.modular.system.controller.UserMgrController','setRole','2019-04-20 00:44:45','成功','账号=liulf,角色名称集合=BOOS'),(1119280715003883521,'业务日志','分配角色',1,'com.liulf.crm.modular.system.controller.UserMgrController','setRole','2019-04-20 00:44:52','成功','账号=liulf,角色名称集合=BOOS'),(1119280801150693378,'业务日志','分配角色',1,'com.liulf.crm.modular.system.controller.UserMgrController','setRole','2019-04-20 00:45:13','成功','账号=liulf,角色名称集合=BOOS'),(1119534943601426433,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 17:35:05','成功','菜单名称=客户管理;;;字段名称:菜单编号,旧值:community,新值:customer;;;字段名称:菜单名称,旧值:楼盘管理,新值:客户管理'),(1119603264946438145,'业务日志','菜单新增',1,'com.liulf.crm.modular.system.controller.MenuController','add','2019-04-20 22:06:34','成功','菜单名称=进销存管理'),(1119603493720555521,'业务日志','菜单新增',1,'com.liulf.crm.modular.system.controller.MenuController','add','2019-04-20 22:07:29','成功','菜单名称=商品分类管理'),(1119603679964430338,'业务日志','菜单新增',1,'com.liulf.crm.modular.system.controller.MenuController','add','2019-04-20 22:08:13','成功','菜单名称=商品分类管理添加'),(1119603911485816833,'业务日志','菜单新增',1,'com.liulf.crm.modular.system.controller.MenuController','add','2019-04-20 22:09:08','成功','菜单名称=商品分类修改'),(1119604043476369411,'业务日志','菜单新增',1,'com.liulf.crm.modular.system.controller.MenuController','add','2019-04-20 22:09:40','成功','菜单名称=商品分类删除'),(1119604119561043969,'业务日志','配置权限',1,'com.liulf.crm.modular.system.controller.RoleController','setAuthority','2019-04-20 22:09:58','成功','角色名称=超级管理员,资源名称=系统管理,菜单管理,添加菜单,修改菜单,删除菜单,菜单编辑跳转,菜单列表,业务日志,清空日志,日志列表,日志详情,监控管理,字典管理,添加字典,修改字典,删除字典,修改菜单跳转,字典列表,字典详情,登录日志,清空登录日志,登录日志列表,系统消息,系统消息,客户管理,楼盘管理,添加楼盘,删除楼盘,修改楼盘,楼盘修改,添加楼盘,楼盘选择,楼盘查看,商圈管理,添加商圈,添加商圈,删除商圈,商圈修改,商圈修改,商圈详情,商圈选择,权限管理,角色管理,添加角色,修改角色,删除角色,配置权限,修改角色跳转,角色分配跳转,角色列表,人事管理,员工管理,添加用户,修改用户,删除用户,重置密码,冻结用户,解除冻结用户,分配角色,分配角色跳转,编辑用户跳转,用户列表,部门管理,添加部门,修改部门,删除部门,修改部门跳转,部门列表,部门详情,通知管理,添加通知,修改通知,删除通知,进销存管理,商品分类管理,商品分类管理添加,商品分类修改,商品分类删除'),(1119604252960882689,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 22:10:30','成功','菜单名称=商品分类管理添加;;;字段名称:null,旧值:Y,新值:N'),(1119604293725323266,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 22:10:40','成功','菜单名称=商品分类修改;;;字段名称:null,旧值:Y,新值:N'),(1119604326092767233,'业务日志','修改菜单',1,'com.liulf.crm.modular.system.controller.MenuController','edit','2019-04-20 22:10:47','成功','菜单名称=商品分类删除;;;字段名称:null,旧值:Y,新值:N');

/*Table structure for table `sys_relation` */

DROP TABLE IF EXISTS `sys_relation`;

CREATE TABLE `sys_relation` (
  `RELATION_ID` bigint(20) NOT NULL COMMENT '主键',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`RELATION_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色和菜单关联表';

/*Data for the table `sys_relation` */

insert  into `sys_relation`(`RELATION_ID`,`MENU_ID`,`ROLE_ID`) values (1119278157883535361,172,1110402389680799745),(1119278157921284098,145,1110402389680799745),(1119279748145508353,172,1119269662790545409),(1119279748183257090,145,1119269662790545409),(1119279895793397761,172,1110402703939026945),(1119279895822757889,145,1110402703939026945),(1119280287193264130,105,1119278355137458177),(1119280287231012866,133,1119278355137458177),(1119280287256178689,160,1119278355137458177),(1119280287277150209,161,1119278355137458177),(1119280287302316034,172,1119278355137458177),(1119280287327481857,145,1119278355137458177),(1119280287348453378,1113314822306451457,1119278355137458177),(1119280287386202114,106,1119278355137458177),(1119280287411367937,107,1119278355137458177),(1119280287432339457,108,1119278355137458177),(1119280287457505281,109,1119278355137458177),(1119280287482671106,110,1119278355137458177),(1119280287503642625,111,1119278355137458177),(1119280287528808450,112,1119278355137458177),(1119280287549779969,113,1119278355137458177),(1119280287579140098,165,1119278355137458177),(1119280287604305921,166,1119278355137458177),(1119280287633666049,167,1119278355137458177),(1119280287658831873,131,1119278355137458177),(1119280287692386305,135,1119278355137458177),(1119280287717552130,136,1119278355137458177),(1119280287746912258,137,1119278355137458177),(1119280287780466689,152,1119278355137458177),(1119280287814021122,153,1119278355137458177),(1119280287843381249,154,1119278355137458177),(1119280287868547074,141,1119278355137458177),(1119280287893712897,142,1119278355137458177),(1119280287923073026,143,1119278355137458177),(1119280287948238849,144,1119278355137458177),(1119280511898906625,105,1119280408257654786),(1119280511932461057,128,1119280408257654786),(1119280511966015489,134,1119280408257654786),(1119280511991181313,158,1119280408257654786),(1119280512016347137,159,1119280408257654786),(1119280512041512962,133,1119280408257654786),(1119280512096038914,160,1119280408257654786),(1119280512133787649,161,1119280408257654786),(1119280512171536386,172,1119280408257654786),(1119280512205090818,145,1119280408257654786),(1119280512242839553,1113279026952273922,1119280408257654786),(1119280512272199681,114,1119280408257654786),(1119280512293171201,115,1119280408257654786),(1119280512318337026,116,1119280408257654786),(1119280512347697154,117,1119280408257654786),(1119280512385445889,118,1119280408257654786),(1119280512419000322,162,1119280408257654786),(1119280512439971842,163,1119280408257654786),(1119280512460943362,164,1119280408257654786),(1119280512486109185,1113314822306451457,1119280408257654786),(1119280512515469314,106,1119280408257654786),(1119280512536440833,107,1119280408257654786),(1119280512565800961,108,1119280408257654786),(1119280512590966786,109,1119280408257654786),(1119280512620326913,110,1119280408257654786),(1119280512641298434,111,1119280408257654786),(1119280512666464257,112,1119280408257654786),(1119280512691630082,113,1119280408257654786),(1119280512716795906,165,1119280408257654786),(1119280512737767425,166,1119280408257654786),(1119280512771321858,167,1119280408257654786),(1119280512800681985,131,1119280408257654786),(1119280512825847810,135,1119280408257654786),(1119280512851013633,136,1119280408257654786),(1119280512876179458,137,1119280408257654786),(1119280512901345282,152,1119280408257654786),(1119280512926511105,153,1119280408257654786),(1119280512951676929,154,1119280408257654786),(1119280512976842754,141,1119280408257654786),(1119280513002008578,142,1119280408257654786),(1119280513027174401,143,1119280408257654786),(1119280513052340225,144,1119280408257654786),(1119604116805386241,105,1),(1119604116826357762,119,1),(1119604116855717889,120,1),(1119604116872495105,121,1),(1119604116901855233,122,1),(1119604116918632450,150,1),(1119604116964769793,151,1),(1119604116985741313,128,1),(1119604117006712833,134,1),(1119604117027684354,158,1),(1119604117044461570,159,1),(1119604117065433089,130,1),(1119604117094793217,132,1),(1119604117115764738,138,1),(1119604117136736257,139,1),(1119604117153513473,140,1),(1119604117174484994,155,1),(1119604117195456513,156,1),(1119604117212233730,157,1),(1119604117229010945,133,1),(1119604117249982466,160,1),(1119604117266759681,161,1),(1119604117287731201,172,1),(1119604117308702722,145,1),(1119604117325479938,1112532525670105089,1),(1119604117346451457,1112532661309702145,1),(1119604117363228674,1112618084073607169,1),(1119604117380005889,1112618348105043969,1),(1119604117400977410,1112618741052608514,1),(1119604117421948930,1112619131173212161,1),(1119604117442920450,1112619359217520642,1),(1119604117459697665,1113256458614620161,1),(1119604117489057794,1113267293315559426,1),(1119604117505835009,1112897475081031682,1),(1119604117526806530,1112897942594932737,1),(1119604117551972353,1112898340365946881,1),(1119604117572943874,1112958133982130178,1),(1119604117593915394,1112969005920145409,1),(1119604117619081217,1112969548256235521,1),(1119604117631664130,1112969893703307266,1),(1119604117652635649,1113256273071194114,1),(1119604117677801473,1113279026952273922,1),(1119604117698772993,114,1),(1119604117719744514,115,1),(1119604117736521729,116,1),(1119604117753298945,117,1),(1119604117778464770,118,1),(1119604117795241985,162,1),(1119604117816213506,163,1),(1119604117837185026,164,1),(1119604117858156545,1113314822306451457,1),(1119604117874933761,106,1),(1119604117895905282,107,1),(1119604117916876801,108,1),(1119604117933654017,109,1),(1119604117954625537,110,1),(1119604117975597058,111,1),(1119604117996568577,112,1),(1119604118013345794,113,1),(1119604118063677441,165,1),(1119604118084648961,166,1),(1119604118101426177,167,1),(1119604118122397698,131,1),(1119604118139174913,135,1),(1119604118155952130,136,1),(1119604118176923649,137,1),(1119604118197895169,152,1),(1119604118218866690,153,1),(1119604118248226818,154,1),(1119604118273392642,141,1),(1119604118290169858,142,1),(1119604118306947074,143,1),(1119604118327918593,144,1),(1119604118344695810,1119603264858357761,1),(1119604118365667330,1119603493628280833,1),(1119604118386638850,1119603679918292994,1),(1119604118403416065,1119603911414513666,1),(1119604118424387586,1119604043476369410,1);

/*Table structure for table `sys_role` */

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

/*Data for the table `sys_role` */

insert  into `sys_role`(`ROLE_ID`,`PID`,`NAME`,`DESCRIPTION`,`SORT`,`VERSION`,`CREATE_TIME`,`UPDATE_TIME`,`CREATE_USER`,`UPDATE_USER`) values (1,0,'超级管理员','administrator',1,1,NULL,NULL,NULL,NULL),(1110402389680799745,0,'服务顾问','服务顾问',0,NULL,'2019-03-26 12:45:35','2019-04-20 00:00:32',1,1),(1110402703939026945,0,'维修技术员','维修技术员',0,NULL,'2019-03-26 12:46:50','2019-04-20 00:01:15',1,1),(1119269662790545409,0,'财务','财务',4,NULL,'2019-04-20 00:00:57',NULL,1,NULL),(1119278355137458177,0,'人事人员','人事人员',6,NULL,'2019-04-20 00:35:30',NULL,1,NULL),(1119280408257654786,0,'BOOS','BOOS',6,NULL,'2019-04-20 00:43:39',NULL,1,NULL);

/*Table structure for table `sys_user` */

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

/*Data for the table `sys_user` */

insert  into `sys_user`(`USER_ID`,`AVATAR`,`ACCOUNT`,`PASSWORD`,`SALT`,`NAME`,`BIRTHDAY`,`SEX`,`EMAIL`,`PHONE`,`ROLE_ID`,`DEPT_ID`,`STATUS`,`CREATE_TIME`,`CREATE_USER`,`UPDATE_TIME`,`UPDATE_USER`,`VERSION`) values (1,'1','admin','507c9a3645aacca3dc106e5c3db499d0','q6taw','admin','2019-03-26 00:00:00','M','admin@qq.com','18200000000','1',0,'ENABLE','2016-01-29 08:49:53',NULL,'2019-04-19 23:42:58',24,25),(1119271483839901697,NULL,'liulf','3fb1b67d1f2eb707154d43a777d340c7','qb6bn','刘连峰','1988-10-08 00:00:00','M','383830950@qq.com','','1119280408257654786',26,'ENABLE','2019-04-20 00:08:11',1,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
