/*
SQLyog Ultimate v8.32 
MySQL - 5.7.21 : Database - db_bmlog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_bmlog` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `db_bmlog`;

/*Table structure for table `tb_auth_user` */

DROP TABLE IF EXISTS `tb_auth_user`;

CREATE TABLE `tb_auth_user` (
  `user_code` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `auth_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '授权码',
  `add_time` datetime DEFAULT NULL,
  `add_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `opt_time` datetime DEFAULT NULL,
  `opt_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `auth_time` datetime DEFAULT NULL COMMENT '授权时间',
  PRIMARY KEY (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='授权用户表';

/*Data for the table `tb_auth_user` */

/*Table structure for table `tb_logger_api` */

DROP TABLE IF EXISTS `tb_logger_api`;

CREATE TABLE `tb_logger_api` (
  `id` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '日志编号',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '日志标题',
  `content` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '日志内容',
  `request_uri` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求uri',
  `remote_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求方ip',
  `request_method` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '请求方式',
  `request_params` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '请求参数',
  `content_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '请求参数类型',
  `api_controller_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'API接口名',
  `api_method_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'API方法名',
  `api_method_notes` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'API方法说明',
  `start_time` datetime DEFAULT NULL COMMENT '请求开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '请求结束时间',
  `use_time` int(11) DEFAULT NULL COMMENT '耗时',
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求状态',
  `project_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名',
  `create_time` datetime DEFAULT NULL COMMENT '日志生成时间',
  `host_ip` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '日志来源',
  `add_time` datetime DEFAULT NULL,
  `add_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `auth_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `result_data` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '请求返回数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='接口日志';

/*Data for the table `tb_logger_api` */

/*Table structure for table `tb_logger_main` */

DROP TABLE IF EXISTS `tb_logger_main`;

CREATE TABLE `tb_logger_main` (
  `id` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '日志主键',
  `type_id` int(11) DEFAULT NULL COMMENT '外键关联日志类型表',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '日志标题',
  `project_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '所属项目名',
  `create_time` datetime DEFAULT NULL COMMENT '日志产生时间',
  `host_ip` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '日志来源',
  `add_time` datetime DEFAULT NULL,
  `add_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `auth_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '授权用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志主表';

/*Data for the table `tb_logger_main` */

/*Table structure for table `tb_logger_type` */

DROP TABLE IF EXISTS `tb_logger_type`;

CREATE TABLE `tb_logger_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志类型主键',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型名称',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `add_time` datetime DEFAULT NULL,
  `add_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `opt_time` datetime DEFAULT NULL,
  `opt_user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '状态，1有效，0无效，-1删除',
  `user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '所有者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志类型';

/*Data for the table `tb_logger_type` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
