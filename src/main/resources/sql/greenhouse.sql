/*
Navicat MySQL Data Transfer

Source Server         : jiang
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : greenhouse

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-09 15:24:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auto_control_param
-- ----------------------------
DROP TABLE IF EXISTS `auto_control_param`;
CREATE TABLE `auto_control_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动控制参数表ID',
  `param_name` varchar(150) DEFAULT NULL COMMENT '自控参数名称',
  `temperature_min` float(8,0) DEFAULT NULL COMMENT '温室温度下限',
  `temperature_max` float(8,0) DEFAULT NULL COMMENT '温室温度上限',
  `humidity_min` float(8,0) DEFAULT NULL COMMENT '温室湿度下限',
  `humidity_max` float(8,0) DEFAULT NULL COMMENT '温室湿度上限',
  `light_intensity_min` float(8,0) DEFAULT NULL COMMENT '光照强度下限',
  `light_intensity_max` float(8,0) DEFAULT NULL COMMENT '光照强度上限',
  `soil_moisture_min` float(8,0) DEFAULT NULL COMMENT '土壤湿度下限',
  `soil_moisture_max` float(8,0) DEFAULT NULL COMMENT '土壤湿度上限',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_control_param
-- ----------------------------
INSERT INTO `auto_control_param` VALUES ('1', '蝴蝶兰栽培期', '14', '20', '60', '80', '10000', '12000', '30', '40', null, null, '2017-04-07 10:50:19');
INSERT INTO `auto_control_param` VALUES ('2', '蝴蝶兰开花期', '15', '20', '60', '80', '14000', '16000', '30', '40', null, null, null);
INSERT INTO `auto_control_param` VALUES ('3', '新增测试', '15', '20', '60', '80', '14000', '15000', '30', '40', '2017-04-06 15:04:03', '2017-04-06 15:14:01', '2017-04-07 10:04:44');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `operate_from` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_to` varchar(50) DEFAULT NULL COMMENT '操作对象',
  `date` datetime DEFAULT NULL COMMENT '操作时间',
  `behavior` varchar(50) DEFAULT NULL COMMENT '操作行为',
  `state` tinyint(10) DEFAULT NULL COMMENT '操作状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', 'jyp', 'LED', '2017-04-05 17:21:44', 'open', '1');
INSERT INTO `log` VALUES ('2', 'jyp', 'LED', '2017-04-06 10:05:15', 'close', '1');
INSERT INTO `log` VALUES ('3', 'jyp', 'LED', '2017-04-06 10:09:27', 'close', '1');
INSERT INTO `log` VALUES ('4', 'admin', 'LED', '2017-04-06 11:02:28', 'open', '1');
INSERT INTO `log` VALUES ('5', 'admin', 'LED', '2017-04-06 11:02:53', 'open', '1');
INSERT INTO `log` VALUES ('6', 'admin', 'LED', '2017-04-06 11:05:28', 'open', '1');
INSERT INTO `log` VALUES ('7', 'admin', 'LED', '2017-04-06 11:13:22', 'open', '1');
INSERT INTO `log` VALUES ('8', 'admin', 'LED', '2017-04-06 11:15:53', 'close', '1');
INSERT INTO `log` VALUES ('9', 'admin', 'LED', '2017-04-06 11:17:32', 'open', '1');
INSERT INTO `log` VALUES ('10', 'admin', 'LED', '2017-04-06 11:17:54', 'close', '1');
INSERT INTO `log` VALUES ('11', 'admin', 'LED', '2017-04-06 11:17:55', 'open', '1');
INSERT INTO `log` VALUES ('12', 'admin', 'LED', '2017-04-06 11:17:56', 'close', '1');
INSERT INTO `log` VALUES ('13', 'admin', 'LED', '2017-04-06 11:17:57', 'open', '1');
INSERT INTO `log` VALUES ('14', 'admin', 'LED', '2017-04-06 11:17:58', 'close', '1');
INSERT INTO `log` VALUES ('15', 'admin', 'LED', '2017-04-06 11:17:58', 'open', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(50) NOT NULL COMMENT '权限名',
  `permission_sign` varchar(50) NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '普通权限', 'common');
INSERT INTO `permission` VALUES ('2', '管理员权限', 'admin');
INSERT INTO `permission` VALUES ('3', '游客权限', 'guest');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名',
  `role_sign` varchar(50) NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', 'common');
INSERT INTO `role` VALUES ('2', '管理员', 'admin');
INSERT INTO `role` VALUES ('3', '游客', 'guest');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '角色权限ID',
  `role_id` tinyint(4) NOT NULL COMMENT '角色ID',
  `permission_id` tinyint(4) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '2');
INSERT INTO `role_permission` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` char(20) NOT NULL COMMENT '密码',
  `role_id` tinyint(4) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jyp', '123456', '1');
INSERT INTO `user` VALUES ('2', 'admin', '333333', '2');
INSERT INTO `user` VALUES ('3', 'ly', '123456', '1');
INSERT INTO `user` VALUES ('4', 'guest', '123456', '1');
