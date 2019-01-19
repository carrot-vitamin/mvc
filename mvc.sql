/*
Navicat MySQL Data Transfer

Source Server         : linux
Source Server Version : 50720
Source Host           : 192.168.146.149:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-29 18:18:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(100) NOT NULL,
  `firsttime` datetime NOT NULL,
  `lasttime` datetime NOT NULL,
  `times` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`ip`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromuser` varchar(255) DEFAULT NULL,
  `fromaddr` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `destusers` varchar(255) DEFAULT NULL,
  `cc` varchar(255) DEFAULT NULL,
  `senddate` datetime DEFAULT NULL,
  `needtoread` varchar(255) DEFAULT NULL,
  `containsfiles` varchar(255) DEFAULT NULL,
  `needtoreply` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rbac_module
-- ----------------------------
DROP TABLE IF EXISTS `rbac_module`;
CREATE TABLE `rbac_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `updator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rbac_module
-- ----------------------------
INSERT INTO `rbac_module` VALUES ('1', null, '系统管理', null, 'glyphicon glyphicon-cog', null, '2018-05-29 15:39:56', null, null, null);
INSERT INTO `rbac_module` VALUES ('2', null, '用户管理', '/user/userManage', 'glyphicon glyphicon-user', '1', null, null, null, null);
INSERT INTO `rbac_module` VALUES ('3', null, '模块管理', '/rbacModule/view', 'glyphicon glyphicon-th-list', '1', null, '2018-05-29 15:39:59', '123', '123');
INSERT INTO `rbac_module` VALUES ('4', null, '信箱', null, 'glyphicon glyphicon-cog', null, null, null, null, null);
INSERT INTO `rbac_module` VALUES ('5', null, '收件箱', '/mail/input', 'glyphicon glyphicon-cog', '4', null, null, null, null);
INSERT INTO `rbac_module` VALUES ('6', null, '写信', '/mail/output', 'glyphicon glyphicon-edit', '4', null, null, null, null);
INSERT INTO `rbac_module` VALUES ('7', null, '报表3', '/test/index2', 'glyphicon glyphicon-eye-open', '4', null, null, null, null);
INSERT INTO `rbac_module` VALUES ('8', '', '三级菜单', '', 'glyphicon glyphicon-headphones', null, '2018-05-29 16:53:34', '2018-05-29 16:53:37', '', '');
INSERT INTO `rbac_module` VALUES ('9', '', '三级菜单1', '', 'glyphicon glyphicon-headphones', '8', '2018-05-29 16:53:34', '2018-05-29 16:53:37', '', '');
INSERT INTO `rbac_module` VALUES ('10', '', '三级菜单2', '', 'glyphicon glyphicon-headphones', '9', '2018-05-29 16:53:34', '2018-05-29 16:53:37', '', '');
INSERT INTO `rbac_module` VALUES ('11', '', '三级菜单2', '', 'glyphicon glyphicon-headphones', '9', '2018-05-29 16:53:34', '2018-05-29 16:53:37', '', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `filepath` varchar(100) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `lastlogindate` datetime DEFAULT NULL,
  `logintimes` int(11) DEFAULT '1',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
