/*
Navicat MySQL Data Transfer

Source Server         : orange
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2019-03-04 16:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_name` varchar(90) DEFAULT NULL COMMENT '姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `company` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `sex` char(1) DEFAULT NULL COMMENT '性别（0-女，1-男）',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件地址',
  `phone_num` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `first_login_time` timestamp NULL DEFAULT NULL COMMENT '第一次登陆时间',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '上次登陆时间',
  `last_lgoin_ip` varchar(15) DEFAULT NULL COMMENT '上次登陆IP',
  `is_valid` char(255) DEFAULT 'Y' COMMENT '有效标志（Y-有效，N-无效）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('admin', '系统管理员', '123', 'Servyou', '1', '2014-07-18', null, null, '2019-03-04 16:13:56', '', null, null, null, 'Y');
