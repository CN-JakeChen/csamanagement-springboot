/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : csa_management

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2020-07-27 14:10:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alien_registration
-- ----------------------------
DROP TABLE IF EXISTS `alien_registration`;
CREATE TABLE `alien_registration` (
  `alien_registration_id` int(11) NOT NULL auto_increment,
  `person_id` varchar(18) NOT NULL,
  `name` varchar(10) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `entry_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `out_date` timestamp NOT NULL default '0000-00-00 00:00:00',
  `visit_the_reason` varchar(20) NOT NULL,
  `visit_build` varchar(5) NOT NULL,
  PRIMARY KEY  (`alien_registration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alien_registration
-- ----------------------------
INSERT INTO `alien_registration` VALUES ('1', '123456781234567890', '张三', '12345678901', '2020-05-24 16:18:16', '2020-03-22 10:28:00', '看孩子', '24直廊');
INSERT INTO `alien_registration` VALUES ('2', '123456789012345678', '王五', '12345678901', '2020-05-24 16:18:13', '2020-03-22 13:48:00', '接孩子', '24直廊');
INSERT INTO `alien_registration` VALUES ('3', '111111111111111111', '王老吉', '11111111113', '2020-05-24 16:18:00', '2020-03-22 14:15:44', '大富大贵', '18#');
INSERT INTO `alien_registration` VALUES ('4', '111111111111111111', '蜘蛛侠', '11111111112', '2020-05-24 16:17:41', '2020-03-22 20:42:00', '来看同学', '18#');
INSERT INTO `alien_registration` VALUES ('5', '111111111111111111', '钢铁侠', '11111111111', '2020-05-24 16:17:36', '2020-03-24 21:51:12', '看孩子', '18#');
INSERT INTO `alien_registration` VALUES ('6', '123456789012345678', '张飞', '12345678901', '2020-05-24 16:17:11', '2020-05-24 20:24:48', '看孩子', '17#');
INSERT INTO `alien_registration` VALUES ('7', '12345678901', '孙悟空', '12345678901', '2020-05-24 17:27:58', '2020-05-24 22:27:37', '接孩子', '17#');
INSERT INTO `alien_registration` VALUES ('8', '123456789012345678', '猪八戒', '12345678901', '2020-05-24 17:31:29', '2020-05-24 21:00:06', '修理电路', '24直廊');
INSERT INTO `alien_registration` VALUES ('9', '123456789012345678', '唐僧', '12345678901', '2020-05-24 17:33:43', '2020-05-24 21:31:36', '看孩子', '18#');
INSERT INTO `alien_registration` VALUES ('10', '123456789012345678', '沙和尚', '12345678901', '2020-05-24 17:35:44', '2020-05-24 21:00:34', '看儿子', '17#');
INSERT INTO `alien_registration` VALUES ('11', '330123213213123', '张东升', '11111111111', '2020-07-18 14:59:12', '2020-07-18 14:58:59', '带孩子爬山', '20#');

-- ----------------------------
-- Table structure for build
-- ----------------------------
DROP TABLE IF EXISTS `build`;
CREATE TABLE `build` (
  `build_id` int(11) NOT NULL auto_increment,
  `build_number` varchar(5) NOT NULL,
  PRIMARY KEY  (`build_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of build
-- ----------------------------
INSERT INTO `build` VALUES ('1', '17#');
INSERT INTO `build` VALUES ('2', '18#');
INSERT INTO `build` VALUES ('3', '24直廊');
INSERT INTO `build` VALUES ('4', '19#');
INSERT INTO `build` VALUES ('5', '20#');
INSERT INTO `build` VALUES ('6', '21#');
INSERT INTO `build` VALUES ('7', '22#');
INSERT INTO `build` VALUES ('8', '23#');
INSERT INTO `build` VALUES ('9', '24#');
INSERT INTO `build` VALUES ('10', '25#');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY  (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '计算机与数据工程学院');
INSERT INTO `dept` VALUES ('2', '土木建筑工程学院');
INSERT INTO `dept` VALUES ('3', '商学院');

-- ----------------------------
-- Table structure for management_field
-- ----------------------------
DROP TABLE IF EXISTS `management_field`;
CREATE TABLE `management_field` (
  `management_field_id` int(11) NOT NULL auto_increment,
  `build_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY  (`management_field_id`),
  KEY `management_field_ibfk_1` (`build_id`),
  KEY `id` (`id`),
  CONSTRAINT `management_field_ibfk_1` FOREIGN KEY (`build_id`) REFERENCES `build` (`build_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `management_field_ibfk_2` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of management_field
-- ----------------------------
INSERT INTO `management_field` VALUES ('10', '1', '20');
INSERT INTO `management_field` VALUES ('13', '2', '27');
INSERT INTO `management_field` VALUES ('14', '3', '27');
INSERT INTO `management_field` VALUES ('15', '4', '29');
INSERT INTO `management_field` VALUES ('16', '5', '29');
INSERT INTO `management_field` VALUES ('17', '6', '30');
INSERT INTO `management_field` VALUES ('18', '7', '30');
INSERT INTO `management_field` VALUES ('19', '8', '31');
INSERT INTO `management_field` VALUES ('20', '9', '31');
INSERT INTO `management_field` VALUES ('21', '10', '32');

-- ----------------------------
-- Table structure for mclass
-- ----------------------------
DROP TABLE IF EXISTS `mclass`;
CREATE TABLE `mclass` (
  `class_id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  PRIMARY KEY  (`class_id`),
  KEY `mclass_ibfk_1` (`dept_id`),
  CONSTRAINT `mclass_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mclass
-- ----------------------------
INSERT INTO `mclass` VALUES ('1', '软件工程171班', '2017', '1');
INSERT INTO `mclass` VALUES ('2', '计算机科学与技术181班', '2018', '1');
INSERT INTO `mclass` VALUES ('3', '金融学191班', '2019', '3');
INSERT INTO `mclass` VALUES ('4', '金融学181班', '2018', '3');
INSERT INTO `mclass` VALUES ('5', '土木工程182班', '2018', '2');
INSERT INTO `mclass` VALUES ('6', '土木工程181班', '2018', '2');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL auto_increment,
  `build_id` int(11) NOT NULL,
  `room_number` varchar(5) NOT NULL,
  PRIMARY KEY  (`room_id`),
  KEY `room_ibfk_1` (`build_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`build_id`) REFERENCES `build` (`build_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '1', '201');
INSERT INTO `room` VALUES ('2', '1', '301');
INSERT INTO `room` VALUES ('3', '3', '405');
INSERT INTO `room` VALUES ('4', '2', '405');
INSERT INTO `room` VALUES ('5', '2', '507');
INSERT INTO `room` VALUES ('6', '2', '506');
INSERT INTO `room` VALUES ('7', '2', '508');
INSERT INTO `room` VALUES ('8', '4', '201');
INSERT INTO `room` VALUES ('9', '4', '202');
INSERT INTO `room` VALUES ('10', '4', '203');
INSERT INTO `room` VALUES ('11', '4', '205');
INSERT INTO `room` VALUES ('12', '5', '201');
INSERT INTO `room` VALUES ('13', '5', '202');
INSERT INTO `room` VALUES ('14', '6', '301');
INSERT INTO `room` VALUES ('15', '6', '302');
INSERT INTO `room` VALUES ('16', '6', '303');
INSERT INTO `room` VALUES ('17', '7', '201');
INSERT INTO `room` VALUES ('18', '7', '202');
INSERT INTO `room` VALUES ('19', '8', '201');
INSERT INTO `room` VALUES ('20', '8', '202');
INSERT INTO `room` VALUES ('21', '9', '201');
INSERT INTO `room` VALUES ('22', '9', '202');
INSERT INTO `room` VALUES ('23', '10', '201');
INSERT INTO `room` VALUES ('24', '10', '202');
INSERT INTO `room` VALUES ('25', '10', '203');
INSERT INTO `room` VALUES ('26', '10', '204');
INSERT INTO `room` VALUES ('27', '10', '205');
INSERT INTO `room` VALUES ('28', '10', '206');

-- ----------------------------
-- Table structure for room_record
-- ----------------------------
DROP TABLE IF EXISTS `room_record`;
CREATE TABLE `room_record` (
  `room_record_id` int(11) NOT NULL auto_increment,
  `room_id` int(11) NOT NULL,
  `record` float(11,1) NOT NULL,
  `record_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `notes` varchar(11) default NULL,
  PRIMARY KEY  (`room_record_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `room_record_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_record
-- ----------------------------
INSERT INTO `room_record` VALUES ('44', '4', '9.7', '2020-03-28 21:45:58', '');
INSERT INTO `room_record` VALUES ('45', '6', '8.5', '2020-03-28 21:46:07', '');
INSERT INTO `room_record` VALUES ('46', '5', '7.5', '2020-03-28 21:46:47', '寝室脏乱');
INSERT INTO `room_record` VALUES ('47', '7', '5.5', '2020-03-28 21:47:08', '厕所脏乱');
INSERT INTO `room_record` VALUES ('64', '1', '9.0', '2020-05-25 14:42:06', '');
INSERT INTO `room_record` VALUES ('65', '2', '9.5', '2020-05-25 14:42:44', '不错');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `class_id` int(11) NOT NULL,
  `room_id` int(11) default NULL,
  `bed_number` int(11) default NULL,
  `is_leave` int(1) NOT NULL default '0',
  PRIMARY KEY  (`student_id`),
  KEY `student_ibfk_1` (`class_id`),
  KEY `student_ibfk_2` (`room_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `mclass` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3180437001', '陈二', '1', '8', '1', '0');
INSERT INTO `student` VALUES ('3180437002', '陈三', '1', '8', '2', '0');
INSERT INTO `student` VALUES ('3180437004', '陈四', '1', '9', '1', '0');
INSERT INTO `student` VALUES ('3180437012', '王五', '1', '5', '1', '0');
INSERT INTO `student` VALUES ('3180447001', '王一', '2', '10', '1', '0');
INSERT INTO `student` VALUES ('3180447002', '王二', '2', '10', '2', '0');
INSERT INTO `student` VALUES ('3180447003', '王三', '2', '10', '3', '0');
INSERT INTO `student` VALUES ('3180447004', '王四', '2', '10', '4', '0');
INSERT INTO `student` VALUES ('3180447005', '王五', '2', '11', '4', '0');
INSERT INTO `student` VALUES ('3180447023', '陈一', '2', '7', '1', '0');
INSERT INTO `student` VALUES ('3180457001', '张一', '3', '11', '1', '0');
INSERT INTO `student` VALUES ('3180457002', '张二', '3', '11', '2', '0');
INSERT INTO `student` VALUES ('3180457003', '李一', '3', '11', '3', '0');
INSERT INTO `student` VALUES ('3180457015', '成三', '3', '1', '1', '0');
INSERT INTO `student` VALUES ('3180467016', '陈龙', '4', '6', '2', '0');
INSERT INTO `student` VALUES ('3180467017', '张伟', '4', '6', '1', '0');
INSERT INTO `student` VALUES ('3180477010', '张三', '5', '2', '1', '0');
INSERT INTO `student` VALUES ('3180477011', '李四', '5', '2', '2', '0');
INSERT INTO `student` VALUES ('3180477019', '李小龙', '5', '4', '2', '0');
INSERT INTO `student` VALUES ('3180487014', '晨儿', '6', '4', '3', '0');
INSERT INTO `student` VALUES ('3180487015', '晨二', '6', '12', '1', '0');
INSERT INTO `student` VALUES ('3180487016', '晨三', '6', '13', '1', '0');
INSERT INTO `student` VALUES ('3180487017', '晨四', '6', '14', '1', '0');
INSERT INTO `student` VALUES ('3180487018', '晨五', '6', '15', '1', '0');
INSERT INTO `student` VALUES ('3180487019', '晨六', '6', '16', '1', '0');
INSERT INTO `student` VALUES ('3180487020', '晨七', '6', '17', '1', '0');
INSERT INTO `student` VALUES ('3180487021', '晨八', '6', '18', '1', '0');
INSERT INTO `student` VALUES ('3180487022', '晨九', '6', '19', '1', '0');
INSERT INTO `student` VALUES ('3180487023', '晨十', '6', '20', '1', '0');
INSERT INTO `student` VALUES ('3180487024', '晨十一', '6', '21', '1', '0');
INSERT INTO `student` VALUES ('3180487025', '晨十二', '6', '22', '1', '0');
INSERT INTO `student` VALUES ('3180487026', '晨十三', '6', '3', '1', '0');
INSERT INTO `student` VALUES ('3180487027', '晨十四', '6', '23', '1', '0');
INSERT INTO `student` VALUES ('3180487028', '晨十五', '6', '24', '1', '0');
INSERT INTO `student` VALUES ('3180487029', '晨十六', '6', '25', '1', '0');
INSERT INTO `student` VALUES ('3180487030', '晨十七', '6', '26', '1', '0');
INSERT INTO `student` VALUES ('3180487031', '晨十八', '6', '27', '1', '0');
INSERT INTO `student` VALUES ('3180487032', '晨十九', '6', '28', '3', '0');

-- ----------------------------
-- Table structure for student_back_registration
-- ----------------------------
DROP TABLE IF EXISTS `student_back_registration`;
CREATE TABLE `student_back_registration` (
  `sbr_id` int(11) NOT NULL auto_increment,
  `student_id` varchar(10) NOT NULL,
  `in_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`sbr_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `student_back_registration_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_back_registration
-- ----------------------------
INSERT INTO `student_back_registration` VALUES ('4', '3180437012', '2020-03-23 17:07:03');
INSERT INTO `student_back_registration` VALUES ('5', '3180487014', '2020-03-23 17:10:38');

-- ----------------------------
-- Table structure for student_leave_registration
-- ----------------------------
DROP TABLE IF EXISTS `student_leave_registration`;
CREATE TABLE `student_leave_registration` (
  `slr_id` int(11) NOT NULL auto_increment,
  `student_id` varchar(10) NOT NULL,
  `out_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `leave_the_reason` varchar(20) NOT NULL,
  PRIMARY KEY  (`slr_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `student_leave_registration_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_leave_registration
-- ----------------------------
INSERT INTO `student_leave_registration` VALUES ('13', '3180487014', '2020-03-23 16:56:51', '放假回家');
INSERT INTO `student_leave_registration` VALUES ('14', '3180437012', '2020-03-23 17:05:55', '放假回家');

-- ----------------------------
-- Table structure for student_record
-- ----------------------------
DROP TABLE IF EXISTS `student_record`;
CREATE TABLE `student_record` (
  `student_record_id` int(11) NOT NULL auto_increment,
  `student_id` varchar(10) NOT NULL,
  `record` float(11,1) NOT NULL,
  `record_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`student_record_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `student_record_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_record
-- ----------------------------
INSERT INTO `student_record` VALUES ('69', '3180477019', '7.8', '2020-03-28 21:45:58');
INSERT INTO `student_record` VALUES ('70', '3180487014', '9.5', '2020-03-28 21:45:58');
INSERT INTO `student_record` VALUES ('71', '3180467017', '7.5', '2020-03-28 21:46:07');
INSERT INTO `student_record` VALUES ('72', '3180437012', '6.3', '2020-03-28 21:46:47');
INSERT INTO `student_record` VALUES ('73', '3180467016', '7.0', '2020-03-28 21:46:47');
INSERT INTO `student_record` VALUES ('74', '3180447023', '5.0', '2020-03-28 21:47:08');
INSERT INTO `student_record` VALUES ('96', '3180457015', '8.5', '2020-05-25 14:42:06');
INSERT INTO `student_record` VALUES ('97', '3180477010', '8.5', '2020-05-25 14:42:44');
INSERT INTO `student_record` VALUES ('98', '3180477011', '9.0', '2020-05-25 14:42:44');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `role` int(11) NOT NULL,
  `dept_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '12345678', '1', null);
INSERT INTO `user` VALUES ('20', '张芳芳', '123456', '3', null);
INSERT INTO `user` VALUES ('23', '王辅导员', '123456', '2', '1');
INSERT INTO `user` VALUES ('26', '张辅导员', '11111112', '2', '2');
INSERT INTO `user` VALUES ('27', '李文文', '123456', '3', null);
INSERT INTO `user` VALUES ('28', '李辅导员', '12345678', '2', '3');
INSERT INTO `user` VALUES ('29', '张三丰', '88888888', '3', null);
INSERT INTO `user` VALUES ('30', '陶渊明', '12345678', '3', null);
INSERT INTO `user` VALUES ('31', '李白', '88888888', '3', null);
INSERT INTO `user` VALUES ('32', '杜甫', '88888888', '3', null);
