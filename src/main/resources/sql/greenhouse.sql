/*
Navicat MySQL Data Transfer

Source Server         : jiang
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : greenhouse

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-22 12:13:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(50) NOT NULL COMMENT '权限名',
  `permission_sign` varchar(50) NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '普通权限', 'common');
INSERT INTO `permission` VALUES ('2', '管理员权限', 'admin');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名',
  `role_sign` varchar(50) NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', 'common');
INSERT INTO `role` VALUES ('2', '管理员', 'admin');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '角色权限ID',
  `role_id` tinyint(4) NOT NULL COMMENT '角色ID',
  `permission_id` tinyint(4) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jyp', '123456', '1');
INSERT INTO `user` VALUES ('2', 'admin', '123456', '2');
INSERT INTO `user` VALUES ('3', 'ly', '123456', '1');
