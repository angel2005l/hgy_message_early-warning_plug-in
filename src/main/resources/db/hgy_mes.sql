/*
Navicat MySQL Data Transfer

Source Server         : XH_100
Source Server Version : 50505
Source Host           : 192.168.0.100:3306
Source Database       : xh_f7_mes

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-10 10:27:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mep_equipment
-- ----------------------------
DROP TABLE IF EXISTS `mep_equipment`;
CREATE TABLE `mep_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equ_order_child_no` varchar(20) DEFAULT NULL COMMENT '子订单编号',
  `equ_product_code` varchar(20) DEFAULT NULL COMMENT '设备编号',
  `equ_use_statedsp` varchar(10) DEFAULT NULL COMMENT '运行状态',
  `equ_statedsp` varchar(10) DEFAULT NULL COMMENT '状态dsp',
  `equ_code` varchar(10) DEFAULT NULL COMMENT '设备序号',
  `equ_start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `equ_use_state` varchar(10) DEFAULT NULL COMMENT '使用情况',
  `equ_maintain_state` varchar(10) DEFAULT NULL COMMENT '基本状态',
  `equ_maintain_statedsp` varchar(10) DEFAULT NULL COMMENT '基本状态dsp',
  `equ_product_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `equ_model` varchar(50) DEFAULT NULL COMMENT '模式',
  `equ_state` varchar(10) DEFAULT NULL COMMENT '状态',
  `equ_id` int(11) DEFAULT NULL COMMENT '设备id编号',
  `equ_running_state` varchar(8) DEFAULT NULL COMMENT '运行状态',
  `equ_repair_statedsp` varchar(10) DEFAULT NULL,
  `equ_quantity` varchar(30) DEFAULT NULL COMMENT '计划生产数',
  `equ_data_mode` varchar(10) DEFAULT NULL COMMENT '数据模式',
  `equ_stop_reason` varchar(255) DEFAULT NULL COMMENT '停机原因',
  `equ_device_order_count` int(11) DEFAULT NULL COMMENT '设备订单数',
  `equ_alarm_count` varchar(10) DEFAULT NULL COMMENT '报警数',
  `equ_complete_quantity` varchar(30) DEFAULT NULL COMMENT '实际生产数',
  `equ_qualified_quantity` varchar(30) DEFAULT NULL COMMENT '合格数',
  `equ_repair_state` varchar(10) DEFAULT NULL COMMENT '维修情况',
  `equ_progress` varchar(10) DEFAULT NULL COMMENT '生产进度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_equ_id` (`equ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_equipment
-- ----------------------------
INSERT INTO `mep_equipment` VALUES ('1', '', '', '维修中', '可用', '1#', null, 'duInRepair', '', '', '', 'E-VICTORY 940/300  PRO', 'dsUsed', '1', '2', '正常', '', '9', '', '0', '', '', '', 'drNorm', '');
INSERT INTO `mep_equipment` VALUES ('2', '', '', '维修中', '可用', '2#', null, 'duInRepair', '', '', '', 'VICTORY 1050/300 TECHPRO', 'dsUsed', '2', '3', '正常', '', '9', '', '0', '', '', '', 'drNorm', '');
INSERT INTO `mep_equipment` VALUES ('3', '2018270003-001', '20140001', '生产', '可用', '3#', '2018-06-30 07:21:06', 'duWork', '', '', '', 'VICTORY 1050/300 TECHPRO', 'dsUsed', '3', '1', '正常', '259000', '9', '', '1', '1', '130208', '130128', 'drNorm', '50.2');
INSERT INTO `mep_equipment` VALUES ('4', '', '', '维修中', '可用', '4#', null, 'duInRepair', '', '', '', 'VICTORY 1050/300 TECHPRO', 'dsUsed', '4', '1', '待维修', '', '9', '', '0', '', '', '', 'drToDo', '');
INSERT INTO `mep_equipment` VALUES ('5', '', '', '维修中', '可用', '5#', null, 'duInRepair', '', '', '', 'VICTORY 330/90   TECHPRO', 'dsUsed', '5', '3', '待维修', '', '9', '', '0', '', '', '', 'drToDo', '');
INSERT INTO `mep_equipment` VALUES ('6', '2018270005-001', '20140009', '生产', '可用', '6#', '2018-07-02 08:02:42', 'duWork', '', '', '', 'VICTORY 1050/300 TECHPRO', 'dsUsed', '6', '3', '正常', '210000', '9', '', '1', '1', '54864', '54784', 'drNorm', '26.1');
INSERT INTO `mep_equipment` VALUES ('7', '2018270006-001', '20140009', '生产', '可用', '7#', '2018-06-30 07:21:40', 'duWork', '', '', '', 'E-VICTORY 940/300  PRO', 'dsUsed', '7', '3', '正常', '245000', '9', '', '1', '1', '123712', '123632', 'drNorm', '50.5');
INSERT INTO `mep_equipment` VALUES ('8', '2018270020-001', '20140006', '生产', '可用', '8#', '2018-07-02 09:13:59', 'duWork', '', '', '', 'VICTORY 1050/220 TECHPRO', 'dsUsed', '8', '3', '正常', '415000', '9', '', '1', '1', '131104', '130944', 'drNorm', '31.6');
INSERT INTO `mep_equipment` VALUES ('9', '2018270021-001', '20140010', '生产', '可用', '9#', '2018-07-02 08:52:30', 'duWork', '', '', '', 'VICTORY 650/220  TECHPRO', 'dsUsed', '9', '3', '正常', '425000', '9', '', '1', '1', '129696', '129536', 'drNorm', '30.5');
INSERT INTO `mep_equipment` VALUES ('10', '2018270010-001', '20140004', '生产', '可用', '10#', '2018-06-30 07:22:08', 'duWork', '', '', '', 'VICTORY 300/180  TECHPRO', 'dsUsed', '10', '3', '正常', '770000', '9', '', '1', '1', '434712', '434471', 'drNorm', '56.4');
INSERT INTO `mep_equipment` VALUES ('11', '2018270011-001', '20140003', '生产', '可用', '11#', '2018-06-30 07:22:18', 'duWork', '', '', '', 'VICTORY 650/160  TECHPRO', 'dsUsed', '11', '3', '正常', '252000', '9', '', '1', '1', '128296', '128216', 'drNorm', '50.9');
INSERT INTO `mep_equipment` VALUES ('12', '2018270012-001', '20140003', '生产', '可用', '12#', '2018-06-30 10:36:56', 'duWork', '', '', '', 'VICTORY1050/220TECHPRO', 'dsUsed', '12', '3', '正常', '504000', '9', '', '1', '1', '267232', '267072', 'drNorm', '53');
INSERT INTO `mep_equipment` VALUES ('13', '2018270013-001', '20140007', '生产', '可用', '13#', '2018-06-30 07:22:36', 'duWork', '', '', '', 'VICTORY 650/120 TECHPRO', 'dsUsed', '13', '3', '正常', '1190000', '9', '', '1', '1', '581120', '580800', 'drNorm', '48.8');
INSERT INTO `mep_equipment` VALUES ('14', '2018270014-001', '20140002', '生产', '可用', '14#', '2018-07-02 08:03:01', 'duWork', '', '', '', 'VICTORY 330/90   TECHPRO', 'dsUsed', '14', '3', '正常', '510000', '9', '', '1', '1', '118000', '117840', 'drNorm', '23.1');
INSERT INTO `mep_equipment` VALUES ('15', '2018270015-001', '20140012', '生产', '可用', '15#', '2018-06-30 07:22:47', 'duWork', '', '', '', 'VICTORY 330/90   TECHPRO', 'dsUsed', '15', '3', '正常', '595000', '9', '', '1', '1', '329872', '329712', 'drNorm', '55.4');
INSERT INTO `mep_equipment` VALUES ('16', '2018270016-001', '20140011', '生产', '可用', '16#', '2018-06-30 07:22:59', 'duWork', '', '', '', 'VICTORY 200/90   TECHPRO', 'dsUsed', '16', '3', '正常', '595000', '9', '', '1', '1', '298464', '298304', 'drNorm', '50.1');
INSERT INTO `mep_equipment` VALUES ('17', '2018270017-001', '20140018', '生产', '可用', '17#', '2018-06-30 07:23:18', 'duWork', '', '', '', 'VICTORY 200/60   TECHPRO', 'dsUsed', '17', '3', '正常', '630000', '9', '', '1', '1', '358544', '358384', 'drNorm', '56.9');
INSERT INTO `mep_equipment` VALUES ('18', '2018270018-001', '20140013', '生产', '可用', '18#', '2018-06-30 07:23:34', 'duWork', '', '', '', 'VICTORY 60/50    TECHPRO', 'dsUsed', '18', '3', '正常', '945000', '9', '', '1', '1', '476272', '476112', 'drNorm', '50.4');
INSERT INTO `mep_equipment` VALUES ('19', '2018270019-001', '20140005', '生产', '可用', '19#', '2018-06-30 07:23:47', 'duWork', '', '', '', 'VICTORY 60/50    TECHPRO', 'dsUsed', '19', '3', '正常', '945000', '9', '', '1', '1', '479344', '479184', 'drNorm', '50.7');

-- ----------------------------
-- Table structure for mep_event
-- ----------------------------
DROP TABLE IF EXISTS `mep_event`;
CREATE TABLE `mep_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `event_code` varchar(10) DEFAULT NULL,
  `event_name` varchar(30) DEFAULT NULL,
  `event_pid` int(11) DEFAULT NULL,
  `rule_code` varchar(30) DEFAULT NULL,
  `event_status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_event_id` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_event
-- ----------------------------
INSERT INTO `mep_event` VALUES ('1', '1551', '40', '工艺参数提醒', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('2', '1522', '39', '提醒制定模具维保计划', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('3', '1521', '37', '模具驳回', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('4', '1508', '38', '生产转产', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('5', '1509', '20', '工单未开始', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('6', '1514', '27', '调机异常', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('7', '1512', '23', '模具未点检', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('8', '1518', '28', '工单未完成', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('9', '1517', '33', '模具维保计划未执行', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('10', '1516', '36', '模具送审', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('11', '1511', '22', '设备未点检', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('12', '1506', '31', '模具达到使用寿命', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('13', '1505', '30', '设备维修计划驳回', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('14', '1504', '26', '转产异常', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('15', '1520', '34', '呼叫工艺', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('16', '1519', '29', '设备维修计划送审', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('17', '1515', '35', '呼叫品质', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('18', '1513', '25', '模具维修单异常', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('19', '1510', '21', '工单超产', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('20', '1503', '24', '设备维修单异常', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('21', '1507', '32', '提醒执行模具维保计划', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('22', '1554', '41', '产品重量缺失提醒', '1502', 'default_rule', '1');
INSERT INTO `mep_event` VALUES ('23', '0', '0', '模具和设备维修预警提醒', null, 'default_rule', '1');

-- ----------------------------
-- Table structure for mep_mould
-- ----------------------------
DROP TABLE IF EXISTS `mep_mould`;
CREATE TABLE `mep_mould` (
  `id` int(11) NOT NULL COMMENT '模具编号',
  `mould_code` varchar(64) DEFAULT NULL COMMENT '模具编码',
  `mould_name` varchar(255) DEFAULT NULL COMMENT '模具名称',
  `mould_type` varchar(16) DEFAULT NULL COMMENT '模具类型',
  `mould_state` varchar(32) DEFAULT NULL COMMENT '模具状态（code）',
  `mould_use_state` varchar(32) DEFAULT NULL COMMENT '模具使用状态',
  `mould_maintain_state` varchar(32) DEFAULT NULL COMMENT '模具维修状态',
  `mould_repair_state` varchar(64) DEFAULT NULL COMMENT '模具修复状态',
  `mould_holes_num` int(11) DEFAULT NULL COMMENT '型腔数',
  `mould_life_times` int(11) DEFAULT NULL COMMENT '模具寿命',
  `mould_internal_times` int(11) DEFAULT NULL COMMENT '厂内打模次数',
  `mould_external_times` int(11) DEFAULT NULL COMMENT '外协打模数',
  `mould_produce_cycle` varchar(32) DEFAULT NULL COMMENT '生产周期（s）',
  `mould_quantity_quota` varchar(32) NOT NULL COMMENT '产量定额',
  `mould_change_over_time` varchar(32) DEFAULT NULL COMMENT '预计换模时间',
  `mould_week_capacity` int(11) DEFAULT NULL COMMENT '周生产能力',
  `mould_primary_mode` int(11) DEFAULT NULL COMMENT '一级保养模次',
  `mould_secondary_mode` int(11) DEFAULT NULL COMMENT '二级保养模次',
  `mould_third_mode` int(11) DEFAULT NULL COMMENT '三级保养模次',
  `mould_accept_date` varchar(255) DEFAULT NULL COMMENT '接受日期',
  `mould_model_use_state_new` varchar(255) DEFAULT NULL COMMENT '模具最新使用状态',
  `mould_remaining_times` int(11) DEFAULT NULL COMMENT '剩余使用次数',
  `mould_rule_code` varchar(30) DEFAULT NULL,
  `push_rule_code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_mould_code` (`mould_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_mould
-- ----------------------------
INSERT INTO `mep_mould` VALUES ('65', 'M031-0133(XH1509)', 'Trigger板手', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '63287', '0', '15.00', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9936713', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('66', 'M031-0134(XH1508)', 'Dome Fixer圆顶固定器', '', 'msProduce', 'muWorking', '', 'mrNorm', '32', '10000000', '325061', '0', '15.10', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9674939', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('67', 'M031-0135(XH1510)', 'Nozzle 0.3喷嘴', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '592692', '0', '14.70', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9407308', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('68', 'M031-0136(XH1504)', 'Reservoir Piston内活塞柱', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '591808', '0', '15.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9408192', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('69', 'M031-0137(XH1505)', 'Reservoir Piston Seal 内活塞', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '649402', '0', '14.70', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9350598', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('70', 'M031-0138(XH1506)', 'Reservoir Spring Plate 弹簧挡板', '', 'msProduce', 'muWorking', '', 'mrNorm', '15', '10000000', '486432', '0', '9.70', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9513568', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('71', 'M031-0139(XH1507)', 'Reservoir Spring Lock 弹簧锁', '', 'msProduce', 'muNorm', '', '', '32', '10000000', '19234', '0', '15.50', '', '', '0', '0', '0', '0', '', 'nusDoProduct', '9980766', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('72', 'M031-0140(XH1512)', 'Venting Plug排气塞', '', 'msProduce', 'muNorm', '', 'mrNorm', '32', '10000000', '297730', '0', '10.70', '', '', '0', '0', '0', '0', '', 'nusDoProduct', '9702270', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('73', 'M031-0141(XH1511)', 'Refill Cap替换盖', '', 'msProduce', 'muNorm', '', '', '8', '10000000', '50250', '0', '14.50', '', '', '0', '0', '0', '0', '', 'nusDoProduct', '9949750', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('74', 'M031-0142', 'Frame主体', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '426791', '0', '17.80', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9573209', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('75', 'M031-0143', 'Frame主体', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '478719', '0', '17.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9521281', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('76', 'M031-0144', 'Dome Valve圆顶', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '625654', '0', '15.40', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9374346', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('77', 'M031-0145', 'Valve Housing主体塞', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '590512', '0', '15.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9409488', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('78', 'M031-0146', 'Reservoir(1x8)长管', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '344019', '0', '18.80', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9655981', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('79', 'M031-0147', 'Reservoir(1x16)长管', '', 'msProduce', 'muWorking', '', 'mrNorm', '14', '10000000', '459925', '0', '17.80', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9540075', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('80', 'M031-0148', 'Piston活塞', '', 'msProduce', 'muWorking', '', 'mrNorm', '24', '10000000', '413617', '0', '16.90', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9586383', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('81', 'M031-0149', 'Prime Valve排气阀', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '494290', '0', '10.00', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9505710', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('82', 'M031-0150', 'Top Shroud上壳', '', 'msProduce', 'muWorking', '', 'mrNorm', '16', '10000000', '541416', '0', '15.20', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9458584', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('83', 'M031-0151', 'Shroud外壳', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '301921', '0', '18.00', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9698079', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('84', 'M031-0152', 'Shroud外壳', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '338117', '0', '18.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9661883', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('85', 'M031-0153(PQ15011)', 'Trigger Lock扳手锁', '', 'msProduce', 'muNorm', '', '', '8', '10000000', '4975', '0', '13.00', '', '', '0', '0', '0', '0', '', 'nusDoProduct', '9995025', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('86', 'M031-0159', 'Trigger Lock II&III (扳手锁 2-3)', '', 'msProduce', 'muNorm', '', '', '16', '10000000', '7248', '0', '14.00', '', '', '0', '0', '0', '0', '', 'nusDoProduct', '9992752', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('87', 'M031-0160', 'Frame主体', '', 'msProduce', 'muToRepair', '', 'mrNorm', '8', '10000000', '310357', '0', '17.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9689643', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('88', 'M031-0161', 'Trigger板手', '', 'msProduce', 'muWorking', '', 'mrNorm', '13', '10000000', '480124', '0', '14.50', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9519876', 'default_rule', 'default_mould_rule');
INSERT INTO `mep_mould` VALUES ('89', 'M031-0162', 'Shroud外壳', '', 'msProduce', 'muWorking', '', 'mrNorm', '8', '10000000', '425949', '0', '18.00', '', '', '0', '0', '0', '0', '', 'nusDoWorking', '9574051', 'default_rule', 'default_mould_rule');

-- ----------------------------
-- Table structure for mep_mould_device
-- ----------------------------
DROP TABLE IF EXISTS `mep_mould_device`;
CREATE TABLE `mep_mould_device` (
  `device_id` int(11) DEFAULT NULL COMMENT '设备编号',
  `device_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备编码',
  `mold_id` int(11) DEFAULT NULL COMMENT '模具编号',
  `mold_code` varchar(30) DEFAULT NULL COMMENT '模具编码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_mould_device
-- ----------------------------
INSERT INTO `mep_mould_device` VALUES ('8', '8#', '65', 'VICTORY 1050/220 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('13', '13#', '66', 'VICTORY 650/120 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('17', '17#', '67', 'VICTORY 200/60   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('16', '16#', '68', 'VICTORY 200/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('15', '15#', '69', 'VICTORY 330/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('19', '19#', '70', 'VICTORY 60/50    TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('18', '18#', '70', 'VICTORY 60/50    TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('13', '13#', '71', 'VICTORY 650/120 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('18', '18#', '72', 'VICTORY 60/50    TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('11', '11#', '73', 'VICTORY 650/160  TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('1', '1#', '74', 'E-VICTORY 940/300  PRO');
INSERT INTO `mep_mould_device` VALUES ('2', '2#', '74', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('3', '3#', '74', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('1', '1#', '75', 'E-VICTORY 940/300  PRO');
INSERT INTO `mep_mould_device` VALUES ('2', '2#', '75', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('3', '3#', '75', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('5', '5#', '76', 'VICTORY 330/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('14', '14#', '77', 'VICTORY 330/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('11', '11#', '78', 'VICTORY 650/160  TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('12', '12#', '79', 'VICTORY1050/220TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('10', '10#', '80', 'VICTORY 300/180  TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('19', '19#', '81', 'VICTORY 60/50    TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('9', '9#', '82', 'VICTORY 650/220  TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('4', '4#', '83', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('6', '6#', '83', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('7', '7#', '83', 'E-VICTORY 940/300  PRO');
INSERT INTO `mep_mould_device` VALUES ('4', '4#', '84', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('6', '6#', '84', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('7', '7#', '84', 'E-VICTORY 940/300  PRO');
INSERT INTO `mep_mould_device` VALUES ('16', '16#', '85', 'VICTORY 200/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('18', '18#', '85', 'VICTORY 60/50    TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('16', '16#', '86', 'VICTORY 200/90   TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('1', '1#', '87', 'E-VICTORY 940/300  PRO');
INSERT INTO `mep_mould_device` VALUES ('2', '2#', '87', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('3', '3#', '87', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('8', '8#', '88', 'VICTORY 1050/220 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('4', '4#', '89', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('6', '6#', '89', 'VICTORY 1050/300 TECHPRO');
INSERT INTO `mep_mould_device` VALUES ('7', '7#', '89', 'E-VICTORY 940/300  PRO');

-- ----------------------------
-- Table structure for mep_mould_log
-- ----------------------------
DROP TABLE IF EXISTS `mep_mould_log`;
CREATE TABLE `mep_mould_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mould_log_code` varchar(20) DEFAULT NULL,
  `mould_log_name` varchar(64) DEFAULT NULL,
  `mould_log_context` text,
  `mould_plan_times` int(11) DEFAULT NULL,
  `mould_real_times` int(11) DEFAULT '0',
  `mould_log_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mould_log_status` char(1) DEFAULT '1',
  `mould_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_mould_log
-- ----------------------------

-- ----------------------------
-- Table structure for mep_mould_rule
-- ----------------------------
DROP TABLE IF EXISTS `mep_mould_rule`;
CREATE TABLE `mep_mould_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mould_rule_code` varchar(30) DEFAULT NULL,
  `mould_rule_name` varchar(30) DEFAULT NULL,
  `mould_rule_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_mould_rule
-- ----------------------------
INSERT INTO `mep_mould_rule` VALUES ('1', 'default_rule', '默认模具保养规则', '10000');

-- ----------------------------
-- Table structure for mep_panel
-- ----------------------------
DROP TABLE IF EXISTS `mep_panel`;
CREATE TABLE `mep_panel` (
  `id` int(11) NOT NULL,
  `panel_code` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `panel_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `panel_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mep_panel
-- ----------------------------

-- ----------------------------
-- Table structure for mep_push_rule
-- ----------------------------
DROP TABLE IF EXISTS `mep_push_rule`;
CREATE TABLE `mep_push_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_code` varchar(30) DEFAULT NULL COMMENT '规则编码',
  `rule_name` varchar(30) DEFAULT NULL COMMENT '规则名称',
  `rule_first_time` int(11) DEFAULT NULL COMMENT '第一级推送时间',
  `rule_second_time` int(11) DEFAULT NULL COMMENT '第二级推送时间',
  `rule_third_time` int(11) DEFAULT NULL COMMENT '第三级推送时间',
  `rule_fourth_time` int(11) DEFAULT NULL COMMENT '第四级推送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_push_rule
-- ----------------------------
INSERT INTO `mep_push_rule` VALUES ('1', 'default_rule', '默认预警推送规则', '0', '180', '720', '1440');
INSERT INTO `mep_push_rule` VALUES ('3', 'default_mould_rule', '默认模具保养推送', '-1', '-1', '-1', '-1');

-- ----------------------------
-- Table structure for mep_task
-- ----------------------------
DROP TABLE IF EXISTS `mep_task`;
CREATE TABLE `mep_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_code` varchar(32) DEFAULT NULL COMMENT '调度任务编码',
  `task_name` varchar(30) DEFAULT NULL COMMENT '调度任务名称',
  `task_type` char(4) DEFAULT NULL COMMENT '调度任务名称（data/work）',
  `task_run_type` char(4) DEFAULT NULL COMMENT '执行类型（once/cont）',
  `task_time` int(11) DEFAULT NULL COMMENT '执行时间间隔',
  `task_timing` varchar(10) DEFAULT '' COMMENT '执行时间点',
  `task_last_execute_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次执行时间',
  `status` char(1) DEFAULT 'Y' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_task
-- ----------------------------
INSERT INTO `mep_task` VALUES ('1', 'task_s_molud', '获取模具信息', 'data', 'cont', '21600', '00:00:00', '2018-07-03 17:12:00', 'Y');
INSERT INTO `mep_task` VALUES ('2', 'task_s_equipment', '获取机台信息', 'data', 'cont', '60', '00:00:00', '2018-07-03 18:52:30', 'Y');
INSERT INTO `mep_task` VALUES ('3', 'task_s_warning', '获取预警信息', 'data', 'cont', '60', '00:00:00', '2018-07-03 18:53:00', 'Y');
INSERT INTO `mep_task` VALUES ('4', 'task_s_warning_type', '获取预警类型信息', 'data', 'once', '0', '09:30:00', '2018-07-03 09:30:00', 'Y');
INSERT INTO `mep_task` VALUES ('5', 'task_s_mould_device', '获取模具机台关联信息', 'data', 'once', '0', '09:15:05', '2018-07-03 09:15:30', 'Y');
INSERT INTO `mep_task` VALUES ('6', 'task_w_warning', '推送预警信息', 'work', 'cont', '45', '13:00:00', '2018-07-03 18:52:30', 'Y');
INSERT INTO `mep_task` VALUES ('7', 'task_w_warning_stat_week', '推送预警周统计', 'work', 'once', '0', '10:30:00', '2018-07-03 10:30:00', 'Y');
INSERT INTO `mep_task` VALUES ('8', 'task_w_warning_stat_month', '推送预警月统计', 'work', 'once', '0', '09:00:00', '2018-07-03 09:00:00', 'Y');
INSERT INTO `mep_task` VALUES ('9', 'task_w_mould', '模具保养预警', 'work', 'once', '0', '09:05:00', '2018-06-13 15:06:20', 'N');

-- ----------------------------
-- Table structure for mep_user
-- ----------------------------
DROP TABLE IF EXISTS `mep_user`;
CREATE TABLE `mep_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_code` varchar(7) DEFAULT NULL COMMENT '用户工号',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户姓名',
  `user_token` varchar(50) DEFAULT NULL COMMENT '用户token',
  `user_email` varchar(30) DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(18) DEFAULT NULL COMMENT '用户电话',
  `user_level` int(2) DEFAULT NULL COMMENT '用户级别',
  `is_work` char(1) DEFAULT NULL COMMENT '是否当班',
  `user_status` char(1) DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_user
-- ----------------------------
INSERT INTO `mep_user` VALUES ('1', '0750010', 'TEST_HDD', 'oVM1v1MEwpv6P9e0eZws7mLSkqLk', '', '13888888888', '1', 'N', '1');
INSERT INTO `mep_user` VALUES ('2', '0750011', '商务智能部测试人员', 'oVM1v1LYIa38thd9xm6MR0-AoVb0', '', '', '1', 'Y', '1');
INSERT INTO `mep_user` VALUES ('5', '075008', '张成兵', 'oVM1v1JytmKRZrobkP4iiSnNQZrI', 'fzsbz@xinhaigroup.com', '', '1', 'Y', '1');
INSERT INTO `mep_user` VALUES ('6', '070807', '胡宇帅', 'oVM1v1GB6aJTnGBaLvwSpHXeoXrQ', 'fzszjbz@xinhaigroup.com', '', '1', 'Y', '1');
INSERT INTO `mep_user` VALUES ('7', '075005', '王柱林', 'oVM1v1LEhO3S6PqLphJjjd_sHWbQ', 'fzsbz@xinhaigroup.com', '', '1', 'N', '1');
INSERT INTO `mep_user` VALUES ('8', '070811', '刘金花', 'oVM1v1A5_BpKfw3kFagQ_nCc4Bew', 'fzszjbz@xinhaigroup.com', '', '1', 'N', '1');
INSERT INTO `mep_user` VALUES ('9', '075003', '陈亚利', 'oVM1v1HG_pHuSmzu93HUAavWA3j4', 'fzssfy@xinhaigroup.com', '', '2', 'N', '1');
INSERT INTO `mep_user` VALUES ('10', '075007', '刘小博', 'oVM1v1KlfQBSiIg3AytM2drpjRjg', 'fzsbz@xinhaigroup.com', '', '2', 'N', '1');
INSERT INTO `mep_user` VALUES ('11', '075001', '应雪峰', 'oVM1v1B4w_R07dbvPsMXFYeyhr7g', 'fzscjzr@xinhaigroup.com', '', '2', 'N', '1');
INSERT INTO `mep_user` VALUES ('12', '074005', '陈金苗', 'oVM1v1CO3ivDXlmsDjA15iGEZbko', 'cjinmiao@xinhaigroup.com', '', '3', 'N', '1');
INSERT INTO `mep_user` VALUES ('13', '070802', '郑伟', 'oVM1v1GkTiBmtKdjq93at5Neg2k8', 'fjsy@xinhaigroup.com', '', '3', 'N', '1');
INSERT INTO `mep_user` VALUES ('14', '800011', '葛志宏', 'oVM1v1BOYznWkSU_dIUz0i31DRUI', 'qcten@xinhaigroup.com', '', '4', 'N', '1');

-- ----------------------------
-- Table structure for mep_warning
-- ----------------------------
DROP TABLE IF EXISTS `mep_warning`;
CREATE TABLE `mep_warning` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_id` varchar(20) DEFAULT NULL COMMENT '预警ID',
  `event_type` varchar(30) DEFAULT NULL COMMENT '预警类型',
  `event_code` varchar(10) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL COMMENT '预警标题',
  `message` text COMMENT '预警信息',
  `device_id` varchar(8) DEFAULT NULL COMMENT '设备编号',
  `guid` varchar(40) DEFAULT NULL COMMENT '预警唯一标识码',
  `status` varchar(8) DEFAULT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `reliever` varchar(255) DEFAULT NULL COMMENT '解决人',
  `relieve_time` datetime DEFAULT NULL COMMENT '解决时间',
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `read_status` char(1) DEFAULT '0' COMMENT '预警上报级别',
  `read_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '推送级别',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_guid` (`guid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3123539 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mep_warning
-- ----------------------------
INSERT INTO `mep_warning` VALUES ('1', '262149', '工单未开始预警提醒', '20', '设备编号(3#)工单未开始预警提醒', '设备编号(3#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '3', 'ae76f989-1306-435c-9f99-7781ef2a4031', '1', '2018-05-28 13:55:33', '', null, '2018-05-29 11:42:29', '0', '2018-05-29 11:42:29');
INSERT INTO `mep_warning` VALUES ('2', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018220003)已超出计划生产数量。产品编码:20140001设备编号:3#班别:夜班产线:第一产线计划数量:74000超额数量:8', '3', '2bf11bbc-354b-47fd-b8fe-ff3a8039d335', '1', '2018-05-28 03:31:59', '', '2018-05-28 13:55:30', '2018-05-29 11:42:29', '0', '2018-05-29 11:42:29');
INSERT INTO `mep_warning` VALUES ('3', '262154', '未完成提醒', '28', '工单号(2018220021)未完成提醒', '工单(2018220021)当班未完成。计划结束时间:2018-05-27 19:30班别:白班产线:', '19', '486efe95-549f-487d-aaad-062f1ef34a0d', '0', '2018-05-27 19:00:01', '', null, '2018-05-29 11:42:29', '4', '2018-05-30 09:43:18');
INSERT INTO `mep_warning` VALUES ('4', '262154', '未完成提醒', '28', '工单号(2018220003)未完成提醒', '工单(2018220003)当班未完成。计划结束时间:2018-5-27 19:30班别:白班产线:', '3', '5806ef02-555e-4d31-8416-d073b94f1bfd', '1', '2018-05-27 19:00:01', '', '2018-05-28 13:55:30', '2018-05-29 11:42:29', '0', '2018-05-29 11:42:29');
INSERT INTO `mep_warning` VALUES ('5', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018210004)已超出计划生产数量。产品编码:20140009设备编号:4#班别:夜班产线:第一产线计划数量:245000超额数量:8', '4', 'de7b7e0d-36cf-43da-a913-c68ad8ea1985', '1', '2018-05-26 22:23:19', '', '2018-05-28 14:01:15', '2018-05-29 11:42:29', '0', '2018-05-29 11:42:29');
INSERT INTO `mep_warning` VALUES ('6', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(1#)工艺参数超出上下限提醒。', '设备编号1# 正在生产的工单(2018220001)工艺参数超出上下限。参数名称:空循环时间上限最大值3.14实际值3.59超出值0.45上限:+2.00参数名称:切换点容积[AC3U]上限最大值59.01实际值76.03超出值17.02上限:+2.00参数名称:液压注射压力峰值下限最小值719.60实际值671.20小于值48.40下限:-1.00参数名称:余料量体积最小值上限最大值44.82实际值63.02超出值18.20上限:+1.00参数名称:注射容积上限最大值134.00实际值201.96超出值67.96上限:+5.00参数名称:转保压液压压力下限最小值717.60实际值671.20小于值46.40下限:-3.00参数名称:液压背压峰值下限最小值150.50实际值48.90小于值101.60下限:-3.00参数名称:塑化行程体积实际值上限最大值167.30实际值190.07超出值22.77上限:+1.00参数名称:保压终点余料量体积上限最大值48.89实际值65.37超出值16.48上限:+5.00参数名称:在保压后的余料量体积上限最大值50.19实际值76.08超出值25.89上限:+1.00参数名称:料管区段4温度下限最小值225.00实际值220.00小于值5.00下限:-5.00参数名称:注射时间下限最小值60.00实际值1.59小于值58.41下限:-5.00参数名称:再循环时间上限最大值3.15实际值3.88超出值0.73上限:+2.00', '1', 'a067c9f9-d6e7-4c22-a225-3d71e1bc246d', '0', '2018-05-26 13:31:30', '', null, '2018-05-29 11:42:29', '4', '2018-05-30 10:14:32');
INSERT INTO `mep_warning` VALUES ('7', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:马铁青设备编号:12#班别:白班产线:第二产线', '12', '08ba13d3-dfa4-4b01-8352-a224b5b232c7', '0', '2018-05-26 13:02:55', '', null, '2018-05-29 11:42:30', '4', '2018-05-30 10:14:33');
INSERT INTO `mep_warning` VALUES ('8', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018220002)工艺参数超出上下限。参数名称:周期时间下限最小值25.00实际值17.26小于值7.74下限:-5.00', '2', '21d4d2ac-17d0-47b8-97a9-d21b2f1f03ed', '0', '2018-05-26 10:57:29', '', null, '2018-05-29 11:42:30', '4', '2018-05-30 10:14:33');
INSERT INTO `mep_warning` VALUES ('9', '262149', '工单未开始预警提醒', '20', '设备编号(9#)工单未开始预警提醒', '设备编号(9#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '9', '05cb404e-263f-4513-a59e-13d3ab61cede', '1', '2018-05-26 08:27:27', '', null, '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('10', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', '82360ace-ca04-4b0e-8a9f-49dce3f39899', '1', '2018-05-26 08:25:37', '', null, '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('11', '262149', '工单未开始预警提醒', '20', '设备编号(6#)工单未开始预警提醒', '设备编号(6#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '6', '30221c35-221c-41e9-ac92-7455ad1b5558', '1', '2018-05-26 08:05:37', '', null, '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('12', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018220002)工艺参数超出上下限。参数名称:周期时间下限最小值25.00实际值17.27小于值7.73下限:-5.00参数名称:料管区段2温度下限最小值225.00实际值224.91小于值0.09下限:-5.00', '2', 'debccce8-1124-4cc1-9cff-d6afe256adf7', '0', '2018-05-26 06:57:28', '', null, '2018-05-29 11:42:30', '4', '2018-05-30 10:14:34');
INSERT INTO `mep_warning` VALUES ('13', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018210002)工艺参数超出上下限。参数名称:料管区段2温度下限最小值225.00实际值224.95小于值0.05下限:-5.00参数名称:周期时间下限最小值25.00实际值17.25小于值7.75下限:-5.00', '2', 'f2e76210-3160-468a-9a67-ffa1f9e1ea07', '1', '2018-05-26 06:41:08', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('14', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018210017)已超出计划生产数量。产品编码:20140018设备编号:17#班别:夜班产线:第二产线计划数量:630000超额数量:16', '17', '15ead342-596a-46a6-932a-9b71900bdb88', '1', '2018-05-26 05:49:30', '', '2018-05-26 07:01:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('15', '262153', '超工单生产预警提醒', '21', '设备编号(18#)超工单生产预警提醒', '工单(2018210018)已超出计划生产数量。产品编码:20140013设备编号:18#班别:夜班产线:第二产线计划数量:945000超额数量:8', '18', '0424e225-d270-410a-b69b-d1465708347a', '1', '2018-05-26 04:34:24', '', '2018-05-26 07:01:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('16', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018210016)已超出计划生产数量。产品编码:20140011设备编号:16#班别:夜班产线:第二产线计划数量:595000超额数量:8', '16', '2326041c-ad32-4202-b50e-339f2b8d97e2', '1', '2018-05-26 04:14:59', '', '2018-05-26 07:01:15', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('17', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018210012)已超出计划生产数量。产品编码:20140025设备编号:12#班别:夜班产线:第二产线计划数量:504000超额数量:16', '12', 'd3788583-a050-497d-bd76-ec7aa96339b7', '1', '2018-05-26 04:04:59', '', '2018-05-26 07:00:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('18', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018210002)工艺参数超出上下限。参数名称:液压注射压力峰值上限最大值692.70实际值694.40超出值1.70上限:+1.00参数名称:料管区段2温度下限最小值225.00实际值224.71小于值0.29下限:-5.00参数名称:周期时间下限最小值25.00实际值17.25小于值7.75下限:-5.00', '2', 'a4d810c2-8886-4e02-9b44-8b2e658d7b95', '1', '2018-05-26 02:41:08', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('19', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018210014)已超出计划生产数量。产品编码:20140002设备编号:14#班别:夜班产线:第二产线计划数量:595000超额数量:8', '14', 'b1f4a549-a497-4bc0-ac2b-b554673405fd', '1', '2018-05-26 00:49:51', '', '2018-05-26 07:00:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('20', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018210002)已超出计划生产数量。产品编码:20140001设备编号:2#班别:夜班产线:第一产线计划数量:259000超额数量:4', '2', 'd04a3a38-98e2-44f9-8ed6-f99b4843016c', '1', '2018-05-25 23:56:05', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('21', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:王柱林设备编号:4#班别:夜班产线:第一产线', '4', '746ae32c-6184-4fa3-8113-b4d80de91551', '0', '2018-05-25 22:51:39', '', null, '2018-05-29 11:42:30', '4', '2018-05-30 10:14:34');
INSERT INTO `mep_warning` VALUES ('22', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018210002)工艺参数超出上下限。参数名称:料管区段2温度下限最小值225.00实际值224.95小于值0.05下限:-5.00参数名称:液压注射压力峰值上限最大值692.70实际值693.20超出值0.50上限:+1.00参数名称:周期时间下限最小值25.00实际值17.26小于值7.74下限:-5.00', '2', '07d8b8b2-f4c8-4f6a-8f8b-c529908bf88f', '1', '2018-05-25 22:41:06', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('23', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018210009)已超出计划生产数量。产品编码:20140010设备编号:9#班别:夜班产线:第一产线计划数量:595000超额数量:8', '9', '1b7238d0-c22e-4091-86a1-9049961a4f90', '1', '2018-05-25 22:23:04', '', '2018-05-26 08:27:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('24', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018210003)已超出计划生产数量。产品编码:20140001设备编号:3#班别:夜班产线:第一产线计划数量:259000超额数量:6', '3', '0dcaf4e7-0939-4b11-93d1-f5f633dfd6d2', '1', '2018-05-25 20:22:18', '', '2018-05-26 06:57:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('25', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:王柱林设备编号:4#班别:夜班产线:第一产线', '4', '3d4c17f9-c129-4ac4-aede-9de89e9dd935', '0', '2018-05-25 20:05:53', '', null, '2018-05-29 11:42:30', '4', '2018-05-30 10:14:35');
INSERT INTO `mep_warning` VALUES ('26', '262154', '未完成提醒', '28', '工单号(2018210017)未完成提醒', '工单(2018210017)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '17', 'a8475b1d-34bf-4726-99d8-f6bc352f03e3', '1', '2018-05-25 19:00:04', '', '2018-05-26 07:01:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('27', '262154', '未完成提醒', '28', '工单号(2018210016)未完成提醒', '工单(2018210016)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '16', '79bee482-e27d-49ed-91ad-43cedbbd80db', '1', '2018-05-25 19:00:04', '', '2018-05-26 07:01:15', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('28', '262154', '未完成提醒', '28', '工单号(2018210009)未完成提醒', '工单(2018210009)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '9', '4e0277c1-aa82-4a90-8b5a-beee2834d849', '1', '2018-05-25 19:00:04', '', '2018-05-26 08:27:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('29', '262154', '未完成提醒', '28', '工单号(2018210019)未完成提醒', '工单(2018210019)当班未完成。计划结束时间:2018-05-25 19:30班别:白班产线:', '19', '4e422fa0-8b4c-4e95-bc24-18b84b23b508', '1', '2018-05-25 19:00:04', '', '2018-05-26 07:02:00', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('30', '262154', '未完成提醒', '28', '工单号(2018210007)未完成提醒', '工单(2018210007)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '5', 'a57bf079-f7c8-4e9e-8ea2-fe914e1967e6', '1', '2018-05-25 19:00:04', '', '2018-05-26 06:58:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('31', '262154', '未完成提醒', '28', '工单号(2018210003)未完成提醒', '工单(2018210003)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '3', '43c14d9e-3ae2-487c-b95d-2a57a7089419', '1', '2018-05-25 19:00:04', '', '2018-05-26 06:57:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('32', '262154', '未完成提醒', '28', '工单号(2018210002)未完成提醒', '工单(2018210002)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '2', '9135f550-61c7-4b21-8450-269c2b7d3f80', '1', '2018-05-25 19:00:04', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('33', '262154', '未完成提醒', '28', '工单号(2018210012)未完成提醒', '工单(2018210012)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '12', 'acfd89cf-0292-4cda-b8ce-accdb22fd0d8', '1', '2018-05-25 19:00:04', '', '2018-05-26 07:00:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('34', '262154', '未完成提醒', '28', '工单号(2018210004)未完成提醒', '工单(2018210004)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '4', '0a8d9ded-0080-42da-9ba1-302f1cd7ccf5', '1', '2018-05-25 19:00:04', '', '2018-05-28 14:01:15', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('35', '262154', '未完成提醒', '28', '工单号(2018210014)未完成提醒', '工单(2018210014)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '14', 'ede35c98-1e23-470a-8aac-b386390d56d6', '1', '2018-05-25 19:00:04', '', '2018-05-26 07:00:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('36', '262154', '未完成提醒', '28', '工单号(2018210018)未完成提醒', '工单(2018210018)当班未完成。计划结束时间:2018-5-25 19:30班别:白班产线:', '18', '51af5462-35d5-4225-a188-52723e2b04b2', '1', '2018-05-25 19:00:03', '', '2018-05-26 07:01:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('37', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018210005)已超出计划生产数量。产品编码:20140009设备编号:6#班别:白班产线:第一产线计划数量:245000超额数量:6', '6', 'c1992ac7-a9cb-46e9-8870-e58212a02f8a', '1', '2018-05-25 18:47:21', '', '2018-05-26 08:05:45', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('38', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018210002)工艺参数超出上下限。参数名称:液压注射压力峰值上限最大值692.70实际值693.60超出值0.90上限:+1.00参数名称:转保压液压压力上限最大值653.60实际值653.80超出值0.20上限:+3.00参数名称:周期时间下限最小值25.00实际值17.25小于值7.75下限:-5.00', '2', '57a2cf1c-ccd1-40fb-b447-d1be60e14cbb', '1', '2018-05-25 18:41:05', '', '2018-05-26 06:57:30', '2018-05-29 11:42:30', '0', '2018-05-29 11:42:30');
INSERT INTO `mep_warning` VALUES ('39', '262153', '超工单生产预警提醒', '21', '设备编号(7#)超工单生产预警提醒', '工单(2018210006)已超出计划生产数量。产品编码:20140009设备编号:7#班别:白班产线:第一产线计划数量:245000超额数量:8', '7', '7f21053b-9cd0-4373-a5fd-b69b51583bb2', '1', '2018-05-25 18:23:31', '', '2018-05-26 06:59:00', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('40', '262160', '工艺参数超出上下限提醒。', '40', '设备编号(2#)工艺参数超出上下限提醒。', '设备编号2# 正在生产的工单(2018210002)工艺参数超出上下限。参数名称:料管区段2温度下限最小值225.00实际值224.95小于值0.05下限:-5.00参数名称:液压注射压力峰值上限最大值692.70实际值694.70超出值2.00上限:+1.00参数名称:周期时间下限最小值25.00实际值17.25小于值7.75下限:-5.00', '2', '21c98970-b137-4704-9d32-8eecec966fc4', '1', '2018-05-25 14:41:05', '', '2018-05-26 06:57:30', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('41', '262153', '超工单生产预警提醒', '21', '设备编号(1#)超工单生产预警提醒', '工单(2018210001)已超出计划生产数量。产品编码:20140001设备编号:1#班别:白班产线:第一产线计划数量:185000超额数量:8', '1', 'ba9b32ad-d66a-4711-a839-05efde346be1', '1', '2018-05-25 13:48:08', '', '2018-05-26 06:57:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('42', '262153', '超工单生产预警提醒', '21', '设备编号(13#)超工单生产预警提醒', '工单(2018210013)已超出计划生产数量。产品编码:20140007设备编号:13#班别:白班产线:第二产线计划数量:680000超额数量:16', '13', '0abc195c-e8e5-4117-877c-71cd5b6191ad', '1', '2018-05-25 13:29:48', '', '2018-05-26 07:00:45', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('43', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018210015)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:595000超额数量:8', '15', 'af8e1149-b747-40d3-b2e4-2e591b7acaae', '1', '2018-05-25 13:28:03', '', '2018-05-26 07:01:00', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('44', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018210010)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:770000超额数量:14', '10', '521d838a-09b2-432a-8ff8-c191148143d8', '1', '2018-05-25 12:29:53', '', '2018-05-26 07:00:00', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('45', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018210008)已超出计划生产数量。产品编码:20140006设备编号:8#班别:夜班产线:第一产线计划数量:581000超额数量:8', '8', '2d073b4b-87b8-46f1-8f02-5e88f8f1d23a', '1', '2018-05-25 01:45:46', '', '2018-05-26 06:59:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('46', '262153', '超工单生产预警提醒', '21', '设备编号(11#)超工单生产预警提醒', '工单(2018210011)已超出计划生产数量。产品编码:20140025设备编号:11#班别:白班产线:第二产线计划数量:144000超额数量:8', '11', '6c0607d0-e62e-47c7-8d04-b9022407dbe2', '1', '2018-05-24 16:43:32', '', '2018-05-26 07:00:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('47', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:张成兵设备编号:12#班别:白班产线:第二产线', '12', 'dbfe45cc-1d8a-4bc7-a05e-742dc507ab06', '0', '2018-05-24 13:42:30', '', null, '2018-05-29 11:42:31', '4', '2018-06-06 08:26:25');
INSERT INTO `mep_warning` VALUES ('48', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:张成兵设备编号:12#班别:白班产线:第二产线', '12', 'de4d6cfa-4095-4b42-8a10-02d96efa1ba6', '0', '2018-05-24 13:31:18', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:36');
INSERT INTO `mep_warning` VALUES ('49', '65538', '设备报修预警提醒', '0', '设备编号(2#)设备报修预警提醒', '设备(2#)故障，请及时维修。n报修人:张成兵班别:白班产线:第一产线', '2', 'ebe2edc8-52f8-4eb7-a560-95ba3faf8e2b', '0', '2018-05-24 08:04:30', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:36');
INSERT INTO `mep_warning` VALUES ('50', '65538', '设备报修预警提醒', '0', '设备编号(1#)设备报修预警提醒', '设备(1#)故障，请及时维修。n报修人:张成兵班别:白班产线:第一产线', '1', 'b0d652bf-f69e-4599-894c-65fb81b92bdb', '0', '2018-05-24 08:03:59', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:37');
INSERT INTO `mep_warning` VALUES ('51', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:张成兵设备编号:12#班别:白班产线:第二产线', '12', '18014182-59a6-4a62-9e74-5a2ec75158d6', '0', '2018-05-24 07:03:45', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:38');
INSERT INTO `mep_warning` VALUES ('52', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:王柱林设备编号:12#班别:白班产线:第二产线', '12', 'b07bf103-b2ac-478e-8822-a3c6382ecd4b', '0', '2018-05-23 09:30:41', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:38');
INSERT INTO `mep_warning` VALUES ('53', '262149', '工单未开始预警提醒', '20', '设备编号(19#)工单未开始预警提醒', '设备编号(19#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '19', '8e32fa92-35c7-4c2f-a7ce-0184111eba47', '1', '2018-05-23 08:00:57', '', '2018-05-23 08:03:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('54', '131079', '模具报修预警提醒', '0', '设备编号(17#)模具报修预警提醒', '模具(M031-0135(XH1510))故障，请及时维修。报修人:马铁青设备编号:17#班别:白班产线:第二产线', '17', '4b4d2cc2-ab9f-434b-90a5-e2e055c0f1c3', '0', '2018-05-22 15:03:38', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:39');
INSERT INTO `mep_warning` VALUES ('55', '131079', '模具报修预警提醒', '0', '设备编号(18#)模具报修预警提醒', '模具(M031-0138(XH1506))故障，请及时维修。报修人:王柱林设备编号:18#班别:白班产线:第二产线', '18', 'cd7297ce-a129-4d3e-95eb-bd21761356d4', '0', '2018-05-22 08:50:18', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:39');
INSERT INTO `mep_warning` VALUES ('56', '131079', '模具报修预警提醒', '0', '设备编号(18#)模具报修预警提醒', '模具(M031-0138(XH1506))故障，请及时维修。报修人:王柱林设备编号:18#班别:白班产线:第二产线', '18', 'c0c0f710-b84a-4529-bba6-81ae0e4626c5', '0', '2018-05-22 08:11:20', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:40');
INSERT INTO `mep_warning` VALUES ('57', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:王柱林设备编号:12#班别:白班产线:第二产线', '12', 'eb4d1e5c-6555-48f5-ad02-a09694ef5ed7', '0', '2018-05-22 07:51:16', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:41');
INSERT INTO `mep_warning` VALUES ('58', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0133(XH1509))故障，请及时维修。报修人:张成兵设备编号:8#班别:白班产线:第一产线', '8', '4958a59e-4c59-4d68-81d7-18b37d27daec', '0', '2018-05-21 09:22:58', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:41');
INSERT INTO `mep_warning` VALUES ('59', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:张成兵设备编号:4#班别:白班产线:第一产线', '4', '63b513a0-3f0a-4934-8b9d-9caaf45a2b73', '0', '2018-05-20 14:41:58', '', null, '2018-05-29 11:42:31', '4', '2018-05-30 10:14:42');
INSERT INTO `mep_warning` VALUES ('60', '262149', '工单未开始预警提醒', '20', '设备编号(18#)工单未开始预警提醒', '设备编号(18#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '18', 'ca80b6be-def9-462d-9685-55e9d03f50da', '1', '2018-05-19 09:10:39', '', null, '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('61', '262149', '工单未开始预警提醒', '20', '设备编号(18#)工单未开始预警提醒', '设备编号(18#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '18', 'f356542d-e341-4e61-9038-f8d06dec267e', '1', '2018-05-19 09:04:39', '', null, '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('62', '262149', '工单未开始预警提醒', '20', '设备编号(1#)工单未开始预警提醒', '设备编号(1#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '1', '2acce049-3b1b-4ad8-8511-623c07ac5b3a', '1', '2018-05-19 07:39:39', '', null, '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('63', '262149', '工单未开始预警提醒', '20', '设备编号(4#)工单未开始预警提醒', '设备编号(4#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '4', '809516f2-e038-4c8d-b53d-7b30fbebcf37', '1', '2018-05-19 07:39:39', '', '2018-05-19 07:41:45', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('64', '262149', '工单未开始预警提醒', '20', '设备编号(18#)工单未开始预警提醒', '设备编号(18#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '18', '8181503c-b375-49c9-93d3-1b55f9ae6619', '1', '2018-05-19 07:08:09', '', null, '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('65', '262154', '未完成提醒', '28', '工单号(2018200019)未完成提醒', '工单(2018200019)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '19', '1c251f64-14f9-4aaa-b74d-da558256d2b6', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:08:00', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('66', '262154', '未完成提醒', '28', '工单号(2018200016)未完成提醒', '工单(2018200016)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '16', '902bf042-caaf-4421-8e92-72dced6a1736', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:08:30', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('67', '262154', '未完成提醒', '28', '工单号(2018200009)未完成提醒', '工单(2018200009)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '9', 'b6d58cab-aa84-43a8-b1fc-a5e8def180a0', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:10:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('68', '262154', '未完成提醒', '28', '工单号(2018200018)未完成提醒', '工单(2018200018)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '18', '3f31840f-ba78-4956-b287-bff29294251b', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:08:15', '2018-05-29 11:42:31', '0', '2018-05-29 11:42:31');
INSERT INTO `mep_warning` VALUES ('69', '262154', '未完成提醒', '28', '工单号(2018200007)未完成提醒', '工单(2018200007)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '5', '41e49216-9a2d-4be1-b4cb-adc35f496287', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:09:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('70', '262154', '未完成提醒', '28', '工单号(2018200014)未完成提醒', '工单(2018200014)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '14', '4d2083b8-721f-41b1-907c-4147da4cd89c', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:08:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('71', '262154', '未完成提醒', '28', '工单号(2018200013)未完成提醒', '工单(2018200013)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '13', 'c6fa909b-eb7c-4f64-ac4a-830781d4d409', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:09:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('72', '262154', '未完成提醒', '28', '工单号(2018200005)未完成提醒', '工单(2018200005)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '6', 'a034528b-99f1-4027-9737-cae6f6c6594a', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:09:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('73', '262154', '未完成提醒', '28', '工单号(2018200010)未完成提醒', '工单(2018200010)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '10', '819e5885-928c-4e53-8f76-74a4762400a9', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:10:30', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('74', '262154', '未完成提醒', '28', '工单号(2018200002)未完成提醒', '工单(2018200002)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '2', '6ffbd697-8f07-4aa6-a5dd-cbac78af2846', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:09:30', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('75', '262154', '未完成提醒', '28', '工单号(2018200012)未完成提醒', '工单(2018200012)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '12', '97f22bb7-e466-498b-ac3c-5658cb1b2ab4', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:09:15', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('76', '262154', '未完成提醒', '28', '工单号(2018200017)未完成提醒', '工单(2018200017)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '17', '291ff833-49d0-4cab-aa52-6605957d0097', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:08:15', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('77', '262154', '未完成提醒', '28', '工单号(2018200006)未完成提醒', '工单(2018200006)当班未完成。计划结束时间:2018-5-18 19:30班别:白班产线:', '7', 'ec861af0-8202-4efb-885e-c3c14f3b7dc2', '1', '2018-05-18 19:00:03', '', '2018-05-19 07:10:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('78', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018200015)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:425000超额数量:24', '15', '2c9e7c93-7c51-40a6-9e4b-230bdbc46ee0', '1', '2018-05-18 12:30:52', '', '2018-05-19 07:08:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('79', '131079', '模具报修预警提醒', '0', '设备编号(5#)模具报修预警提醒', '模具(M031-0144)故障，请及时维修。报修人:张成兵设备编号:5#班别:白班产线:第一产线', '5', 'f7803636-6b4c-45f9-9071-b0606f19dfcf', '0', '2018-05-18 09:48:57', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:42');
INSERT INTO `mep_warning` VALUES ('80', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018200003)已超出计划生产数量。产品编码:20140001设备编号:3#班别:白班产线:第一产线计划数量:185000超额数量:6', '3', 'f9b84fd3-0ddf-45f3-8bbf-0db7d6a61ff5', '1', '2018-05-17 17:55:20', '', '2018-05-19 07:04:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('81', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018200020)已超出计划生产数量。产品编码:20140006设备编号:8#班别:白班产线:第一产线计划数量:83000超额数量:8', '8', '53ba13a3-7a44-410d-9fda-2d8c6260f5f0', '1', '2018-05-17 10:19:25', '', '2018-05-18 15:40:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('82', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:张成兵设备编号:12#班别:白班产线:第二产线', '12', 'bd07fc3d-09e1-42ac-9905-7d2097e734d5', '0', '2018-05-17 07:05:03', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:43');
INSERT INTO `mep_warning` VALUES ('83', '262154', '未完成提醒', '28', '工单号(2018200020)未完成提醒', '工单(2018200020)当班未完成。计划结束时间:2018-05-16 19:30班别:白班产线:', '8', '27af2e53-8112-461e-8115-b8fefc59092d', '1', '2018-05-16 19:00:02', '', '2018-05-18 15:40:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('84', '262154', '未完成提醒', '28', '工单号(2018200003)未完成提醒', '工单(2018200003)当班未完成。计划结束时间:2018-5-16 19:30班别:白班产线:', '3', '9acb402d-ee38-4a90-9c73-e002b89b7fd5', '1', '2018-05-16 19:00:02', '', '2018-05-19 07:04:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('85', '131079', '模具报修预警提醒', '0', '设备编号(9#)模具报修预警提醒', '模具(M031-0150)故障，请及时维修。报修人:张成兵设备编号:9#班别:白班产线:第一产线', '9', '80b9138c-8724-4d5f-b5ac-fd7076b06852', '0', '2018-05-16 08:54:51', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:43');
INSERT INTO `mep_warning` VALUES ('86', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018200008)已超出计划生产数量。产品编码:20140006设备编号:8#班别:夜班产线:第一产线计划数量:332000超额数量:16', '8', '4e8f2cae-faea-45f5-a3dd-4b225447056d', '1', '2018-05-16 05:16:57', '', '2018-05-16 08:59:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('87', '131079', '模具报修预警提醒', '0', '设备编号(9#)模具报修预警提醒', '模具(M031-0150)故障，请及时维修。报修人:张成兵设备编号:9#班别:夜班产线:第一产线', '9', '0d48b7eb-5563-4dcf-89f5-dbf27e0d82af', '0', '2018-05-15 20:25:13', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:44');
INSERT INTO `mep_warning` VALUES ('88', '262154', '未完成提醒', '28', '工单号(2018200008)未完成提醒', '工单(2018200008)当班未完成。计划结束时间:2018-5-15 19:30班别:白班产线:', '8', '0ea4bb40-e937-496d-b222-a778c9b1f900', '1', '2018-05-15 19:00:03', '', '2018-05-16 08:59:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('89', '131079', '模具报修预警提醒', '0', '设备编号(1#)模具报修预警提醒', '模具(M031-0160)故障，请及时维修。报修人:张成兵设备编号:1#班别:白班产线:第一产线', '1', 'c366375a-4c60-43a5-aba1-351bc998b237', '0', '2018-05-13 08:55:10', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:44');
INSERT INTO `mep_warning` VALUES ('90', '131079', '模具报修预警提醒', '0', '设备编号(13#)模具报修预警提醒', '模具(M031-0134(XH1508))故障，请及时维修。报修人:张成兵设备编号:13#班别:白班产线:第二产线', '13', 'c9f81eaa-eaa4-4a89-ace3-6932e530394c', '0', '2018-05-12 09:11:08', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:45');
INSERT INTO `mep_warning` VALUES ('91', '262149', '工单未开始预警提醒', '20', '设备编号(13#)工单未开始预警提醒', '设备编号(13#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '13', 'b4486e47-fb21-4537-879b-b734a07ba59d', '1', '2018-05-12 08:20:22', '', '2018-05-12 08:37:45', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('92', '262149', '工单未开始预警提醒', '20', '设备编号(13#)工单未开始预警提醒', '设备编号(13#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '13', '5d46f7d7-f9e1-41f6-8ba5-6944550df19f', '1', '2018-05-12 08:13:32', '', null, '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('93', '262149', '工单未开始预警提醒', '20', '设备编号(13#)工单未开始预警提醒', '设备编号(13#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '13', '23f4fad8-c560-4e73-9422-f97959da01b5', '1', '2018-05-12 08:03:52', '', null, '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('94', '262149', '工单未开始预警提醒', '20', '设备编号(13#)工单未开始预警提醒', '设备编号(13#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '13', '8bc56707-7209-482c-b5f4-110280358624', '1', '2018-05-12 07:46:32', '', null, '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('95', '262153', '超工单生产预警提醒', '21', '设备编号(1#)超工单生产预警提醒', '工单(2018190018)已超出计划生产数量。产品编码:20140001设备编号:1#班别:白班产线:第一产线计划数量:37000超额数量:8', '1', '61a78dd7-62c3-40a9-b439-8d42714fc4dd', '1', '2018-05-12 07:11:45', '', '2018-05-12 07:14:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('96', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018190015)已超出计划生产数量。产品编码:20140001设备编号:2#班别:夜班产线:第一产线计划数量:111000超额数量:8', '2', 'a628bb3a-0c8e-47de-a159-158909d0da15', '1', '2018-05-12 06:26:00', '', '2018-05-12 07:14:15', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('97', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018190017)已超出计划生产数量。产品编码:20140025设备编号:12#班别:夜班产线:第二产线计划数量:216000超额数量:16', '12', 'bbff0be1-8713-45c8-bd7e-7e2ee779756e', '1', '2018-05-12 06:12:14', '', '2018-05-12 07:16:00', '2018-05-29 11:42:32', '0', '2018-05-29 11:42:32');
INSERT INTO `mep_warning` VALUES ('98', '131079', '模具报修预警提醒', '0', '设备编号(17#)模具报修预警提醒', '模具(M031-0135(XH1510))故障，请及时维修。报修人:王柱林设备编号:17#班别:夜班产线:第二产线', '17', '97f75b0c-f5f6-4c75-b5a3-efe5cabace7f', '0', '2018-05-12 05:16:31', '', null, '2018-05-29 11:42:32', '4', '2018-05-30 10:14:45');
INSERT INTO `mep_warning` VALUES ('99', '262153', '超工单生产预警提醒', '21', '设备编号(19#)超工单生产预警提醒', '工单(2018190014)已超出计划生产数量。产品编码:20140005设备编号:19#班别:夜班产线:第二产线计划数量:945000超额数量:14', '19', '8807ae8e-d401-4259-b2ed-c5e53159fa64', '1', '2018-05-12 05:04:39', '', '2018-05-12 07:17:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('100', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018190016)已超出计划生产数量。产品编码:20140009设备编号:4#班别:夜班产线:第一产线计划数量:105000超额数量:8', '4', 'c5e9ed20-729f-42bf-9166-9397768ce72c', '1', '2018-05-12 04:44:29', '', '2018-05-12 07:14:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('101', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018190011)已超出计划生产数量。产品编码:20140011设备编号:16#班别:夜班产线:第二产线计划数量:595000超额数量:5', '16', '192919df-cfda-4724-be27-8c92e24533cf', '1', '2018-05-12 03:41:48', '', '2018-05-12 07:16:45', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('102', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018190012)已超出计划生产数量。产品编码:20140018设备编号:17#班别:夜班产线:第二产线计划数量:630000超额数量:12', '17', 'ff2e33c5-cf7d-477f-b569-6531090d480b', '1', '2018-05-12 03:04:18', '', '2018-05-13 08:55:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('103', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018190009)已超出计划生产数量。产品编码:20140002设备编号:14#班别:夜班产线:第二产线计划数量:595000超额数量:8', '14', '15999f1d-2bfd-4a72-a075-9d9dd7adddde', '1', '2018-05-12 00:55:17', '', '2018-05-12 07:16:15', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('104', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018190006)已超出计划生产数量。产品编码:20140010设备编号:9#班别:夜班产线:第一产线计划数量:595000超额数量:8', '9', '58e0d894-4239-4413-a651-392a238746f1', '1', '2018-05-12 00:40:42', '', '2018-05-12 07:15:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('105', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018190001)已超出计划生产数量。产品编码:20140001设备编号:3#班别:白班产线:第一产线计划数量:259000超额数量:3', '3', 'c41951a9-3886-4bb8-b04e-904ef72e48ca', '1', '2018-05-11 19:09:07', '', '2018-05-12 07:14:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('106', '262154', '未完成提醒', '28', '工单号(2018190002)未完成提醒', '工单(2018190002)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '5', 'e1327e99-5049-4c4d-b46d-f002cda811e9', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:14:45', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('107', '262154', '未完成提醒', '28', '工单号(2018190016)未完成提醒', '工单(2018190016)当班未完成。计划结束时间:2018-05-11 19:30班别:白班产线:', '4', 'b8a2932e-24dc-414b-b9e1-d8ba1bfdbec8', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:14:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('108', '262154', '未完成提醒', '28', '工单号(2018190014)未完成提醒', '工单(2018190014)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '19', 'b3cad338-239a-4de9-942b-75a521c9bb58', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:17:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('109', '262154', '未完成提醒', '28', '工单号(2018190011)未完成提醒', '工单(2018190011)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '16', '0e64ac49-eeeb-49fb-adef-e3803e1c9fde', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:16:45', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('110', '262154', '未完成提醒', '28', '工单号(2018190012)未完成提醒', '工单(2018190012)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '17', '4e080643-9404-4055-96c3-949437550915', '1', '2018-05-11 19:00:00', '', '2018-05-13 08:55:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('111', '262154', '未完成提醒', '28', '工单号(2018190018)未完成提醒', '工单(2018190018)当班未完成。计划结束时间:2018-05-11 19:30班别:白班产线:', '1', '03e6281c-ed6a-4b4f-9c21-b8e2bd5a4179', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:14:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('112', '262154', '未完成提醒', '28', '工单号(2018190009)未完成提醒', '工单(2018190009)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '14', '4e025a5b-4a9a-4f22-b1d5-e665a806bb1d', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:16:15', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('113', '262154', '未完成提醒', '28', '工单号(2018190004)未完成提醒', '工单(2018190004)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '7', '1686e9ef-ed3b-4d04-acec-fdd4145c41d2', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:15:15', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('114', '262154', '未完成提醒', '28', '工单号(2018190007)未完成提醒', '工单(2018190007)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '10', '50f734d2-ca50-4ca6-8f94-d2488e10bf45', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:15:45', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('115', '262154', '未完成提醒', '28', '工单号(2018190015)未完成提醒', '工单(2018190015)当班未完成。计划结束时间:2018-05-11 19:30班别:白班产线:', '2', 'ccf245f0-4b90-4644-be7e-570ef8231ba3', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:14:15', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('116', '262154', '未完成提醒', '28', '工单号(2018190006)未完成提醒', '工单(2018190006)当班未完成。计划结束时间:2018-5-11 19:30班别:白班产线:', '9', '7b65b600-e245-4e13-9874-f46eaf37483b', '1', '2018-05-11 19:00:00', '', '2018-05-12 07:15:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('117', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018190010)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:595000超额数量:4', '15', 'f96bd926-760f-4781-97ae-bd122fdfa1bf', '1', '2018-05-11 13:03:54', '', '2018-05-12 07:16:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('118', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018190005)已超出计划生产数量。产品编码:20140006设备编号:8#班别:夜班产线:第一产线计划数量:581000超额数量:8', '8', 'd2dd0e30-a512-4974-ac54-73674327be74', '1', '2018-05-11 04:16:00', '', '2018-05-12 07:15:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('119', '131079', '模具报修预警提醒', '0', '设备编号(11#)模具报修预警提醒', '模具(M031-0146)故障，请及时维修。报修人:张成兵设备编号:11#班别:夜班产线:第二产线', '11', '2cd7d196-e190-4230-8dbd-4ffc5f487272', '0', '2018-05-10 21:59:21', '', null, '2018-05-29 11:42:33', '4', '2018-05-30 10:14:46');
INSERT INTO `mep_warning` VALUES ('120', '262154', '未完成提醒', '28', '工单号(2018190017)未完成提醒', '工单(2018190017)当班未完成。计划结束时间:2018-05-09 19:30班别:白班产线:', '12', '4685e243-c304-4c73-beb6-46a3d49aa0ec', '1', '2018-05-09 19:00:00', '', '2018-05-12 07:16:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('121', '262149', '工单未开始预警提醒', '20', '设备编号(12#)工单未开始预警提醒', '设备编号(12#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '12', 'b8abab66-3a02-4bcd-acad-89fad5efa8eb', '1', '2018-05-09 10:08:44', '', '2018-05-09 10:09:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('122', '262149', '工单未开始预警提醒', '20', '设备编号(2#)工单未开始预警提醒', '设备编号(2#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '2', 'b576aa68-b857-442a-88a1-aa93ecbf8c29', '1', '2018-05-09 10:02:14', '', '2018-05-09 10:03:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('123', '262149', '工单未开始预警提醒', '20', '设备编号(4#)工单未开始预警提醒', '设备编号(4#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '4', '54f1a606-0628-4937-92ac-40568edadf14', '1', '2018-05-09 10:02:14', '', null, '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('124', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018190003)已超出计划生产数量。产品编码:20140009设备编号:6#班别:夜班产线:第一产线计划数量:105000超额数量:8', '6', '75310dd9-dab4-480e-bec8-cc946c10d6c8', '1', '2018-05-08 05:09:07', '', '2018-05-12 07:15:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('125', '262154', '未完成提醒', '28', '工单号(2018190003)未完成提醒', '工单(2018190003)当班未完成。计划结束时间:2018-5-7 19:30班别:白班产线:', '6', '04e57266-a372-48e8-88f0-f6d0603284ee', '1', '2018-05-07 19:00:03', '', '2018-05-12 07:15:00', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('126', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018180013)已超出计划生产数量。产品编码:20140025设备编号:12#班别:白班产线:第二产线计划数量:432000超额数量:16', '12', '2874d572-5186-4e8d-8da8-7e8e11a99741', '1', '2018-05-07 11:04:10', '', '2018-05-07 15:44:45', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('127', '131079', '模具报修预警提醒', '0', '设备编号(10#)模具报修预警提醒', '模具(M031-0148)故障，请及时维修。报修人:张成兵设备编号:10#班别:白班产线:第一产线', '10', '2046afd4-a135-43b2-bf79-5bdcd32b3c81', '0', '2018-05-07 07:47:54', '', null, '2018-05-29 11:42:33', '4', '2018-05-30 10:14:47');
INSERT INTO `mep_warning` VALUES ('128', '262149', '工单未开始预警提醒', '20', '设备编号(5#)工单未开始预警提醒', '设备编号(5#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '5', '4e84d06f-32cf-4728-be90-0444256588d9', '1', '2018-05-05 16:15:41', '', '2018-05-05 16:20:30', '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('129', '262149', '工单未开始预警提醒', '20', '设备编号(6#)工单未开始预警提醒', '设备编号(6#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '6', '16af72ca-3979-4ad8-aad9-81b1d3cdc5d5', '1', '2018-05-05 07:30:29', '', null, '2018-05-29 11:42:33', '0', '2018-05-29 11:42:33');
INSERT INTO `mep_warning` VALUES ('130', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018180020-0001)已超出计划生产数量。产品编码:20140010设备编号:9#班别:白班产线:第一产线计划数量:85000超额数量:8', '9', '53e87265-719e-4004-8f0b-3b3c0e199d18', '1', '2018-05-05 07:28:34', '', '2018-05-05 07:31:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('131', '262153', '超工单生产预警提醒', '21', '设备编号(19#)超工单生产预警提醒', '工单(2018180019)已超出计划生产数量。产品编码:20140005设备编号:19#班别:夜班产线:第二产线计划数量:810000超额数量:16', '19', 'c92bd909-82b9-4643-9d6a-75043bae4ad1', '1', '2018-05-05 06:33:13', '', '2018-05-05 07:33:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('132', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018180016)已超出计划生产数量。产品编码:20140011设备编号:16#班别:夜班产线:第二产线计划数量:510000超额数量:6', '16', '31455c04-74eb-4590-8e3b-43050fc5233e', '1', '2018-05-05 04:51:07', '', '2018-05-05 07:32:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('133', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018180017)已超出计划生产数量。产品编码:20140018设备编号:17#班别:夜班产线:第二产线计划数量:540000超额数量:12', '17', '5d04d777-985b-4711-89bf-0df7930ea370', '1', '2018-05-05 03:47:17', '', '2018-05-05 07:32:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('134', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018180014)已超出计划生产数量。产品编码:20140002设备编号:14#班别:夜班产线:第二产线计划数量:510000超额数量:16', '14', '1adfcc47-2a9d-49f2-9034-252fc3b8aec7', '1', '2018-05-05 02:50:51', '', '2018-05-05 07:32:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('135', '65538', '设备报修预警提醒', '0', '设备编号(12#)设备报修预警提醒', '设备(12#)故障，请及时维修。n报修人:张成兵班别:夜班产线:第二产线', '12', 'fcdc9afd-d48e-4098-a168-0f8ae95e5f0a', '0', '2018-05-05 00:07:23', '', null, '2018-05-29 11:42:34', '4', '2018-05-30 10:14:47');
INSERT INTO `mep_warning` VALUES ('136', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018180006)已超出计划生产数量。产品编码:20140019设备编号:6#班别:夜班产线:第一产线计划数量:125000超额数量:4', '6', '37312d62-6802-4014-9fb0-785854eb520a', '1', '2018-05-04 20:52:56', '', '2018-05-05 07:30:30', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('137', '262154', '未完成提醒', '28', '工单号(2018180014)未完成提醒', '工单(2018180014)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '14', 'c3a8da64-b759-4693-a02e-7ac90e43bd56', '1', '2018-05-04 19:00:03', '', '2018-05-05 07:32:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('138', '262154', '未完成提醒', '28', '工单号(2018180020-0001)未完成提醒', '工单(2018180020-0001)当班未完成。计划结束时间:2018-05-04 19:30班别:白班产线:', '9', 'b333882d-e2d8-487f-ba5b-57f4f0b06cb6', '1', '2018-05-04 19:00:03', '', '2018-05-05 07:31:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('139', '262154', '未完成提醒', '28', '工单号(2018180003)未完成提醒', '工单(2018180003)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '7', '97830610-b0f9-4a27-91e7-3645a3b1f922', '1', '2018-05-04 19:00:03', '', '2018-05-09 10:12:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('140', '262154', '未完成提醒', '28', '工单号(2018180021-0001)未完成提醒', '工单(2018180021-0001)当班未完成。计划结束时间:2018-05-04 19:30班别:白班产线:', '11', '4e11e7f5-bed9-4417-8039-5d6895051c40', '1', '2018-05-04 19:00:03', '', '2018-05-07 15:40:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('141', '262154', '未完成提醒', '28', '工单号(2018180017)未完成提醒', '工单(2018180017)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '17', '4357c518-e120-4969-ab93-546a9cf5e51c', '1', '2018-05-04 19:00:02', '', '2018-05-05 07:32:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('142', '262154', '未完成提醒', '28', '工单号(2018180013)未完成提醒', '工单(2018180013)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '12', '53db37d1-d00b-488c-bf82-b6c3ddc9d8b0', '1', '2018-05-04 19:00:02', '', '2018-05-07 15:44:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('143', '262154', '未完成提醒', '28', '工单号(2018180016)未完成提醒', '工单(2018180016)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '16', '4465c8b4-5268-48c4-8174-90c60ba71ce0', '1', '2018-05-04 19:00:02', '', '2018-05-05 07:32:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('144', '262154', '未完成提醒', '28', '工单号(2018180019)未完成提醒', '工单(2018180019)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '19', '9206ba28-c0a6-419e-9702-3420fbf5b719', '1', '2018-05-04 19:00:02', '', '2018-05-05 07:33:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('145', '262154', '未完成提醒', '28', '工单号(2018180006)未完成提醒', '工单(2018180006)当班未完成。计划结束时间:2018-5-4 19:30班别:白班产线:', '6', '34faa785-8f8f-4e28-bdf6-52d34f12511c', '1', '2018-05-04 19:00:02', '', '2018-05-05 07:30:30', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('146', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018180009)已超出计划生产数量。产品编码:20140006设备编号:8#班别:白班产线:第一产线计划数量:249000超额数量:6', '8', '5491b63c-254a-40a3-93b0-475a23701f3e', '1', '2018-05-04 18:50:15', '', '2018-05-05 07:31:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('147', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018180012)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:660000超额数量:8', '10', '94574dd5-b501-4056-903b-386448e575fe', '1', '2018-05-04 18:13:54', '', '2018-05-05 07:31:45', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('148', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018180015)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:510000超额数量:6', '15', 'b7fee221-bd8f-4f82-bae3-3359b5a643b3', '1', '2018-05-04 16:33:29', '', '2018-05-05 07:32:30', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('149', '262149', '工单未开始预警提醒', '20', '设备编号(11#)工单未开始预警提醒', '设备编号(11#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '11', '0d9622f1-a6cd-4879-b4f1-3275ffad0161', '1', '2018-05-04 08:45:32', '', null, '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('150', '262149', '工单未开始预警提醒', '20', '设备编号(9#)工单未开始预警提醒', '设备编号(9#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '9', 'eabe4f9b-28bb-44c0-b33b-7641a525433a', '1', '2018-05-04 08:35:12', '', null, '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('151', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:张成兵设备编号:12#班别:白班产线:第二产线', '12', '3591b5ac-ca94-4dd9-a3db-5ac141c3b046', '0', '2018-05-04 07:30:02', '', null, '2018-05-29 11:42:34', '4', '2018-05-30 10:14:48');
INSERT INTO `mep_warning` VALUES ('152', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018180011)已超出计划生产数量。产品编码:20140020设备编号:9#班别:夜班产线:第一产线计划数量:170000超额数量:12', '9', 'eee4513a-4db3-41be-947d-248a63e99caa', '1', '2018-05-03 23:40:20', '', '2018-05-04 01:21:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('153', '262153', '超工单生产预警提醒', '21', '设备编号(5#)超工单生产预警提醒', '工单(2018180004)已超出计划生产数量。产品编码:20140015设备编号:5#班别:白班产线:第一产线计划数量:360000超额数量:14', '5', '9fb054fe-c077-49fb-a52c-d13028b99930', '1', '2018-05-03 09:16:03', '', '2018-05-04 08:50:30', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('154', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018180002)已超出计划生产数量。产品编码:20140001设备编号:3#班别:夜班产线:第一产线计划数量:148000超额数量:4', '3', '44fd02af-6e74-4720-ab3b-74c196255d83', '1', '2018-05-03 01:16:59', '', '2018-05-05 07:30:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('155', '131079', '模具报修预警提醒', '0', '设备编号(9#)模具报修预警提醒', '模具(M031-0150)故障，请及时维修。报修人:张成兵设备编号:9#班别:夜班产线:第一产线', '9', '3aa68023-4e82-4055-96ec-2f9b18700b6c', '0', '2018-05-03 00:09:44', '', null, '2018-05-29 11:42:34', '4', '2018-05-30 10:14:48');
INSERT INTO `mep_warning` VALUES ('156', '262154', '未完成提醒', '28', '工单号(2018180004)未完成提醒', '工单(2018180004)当班未完成。计划结束时间:2018-5-2 19:30班别:白班产线:', '5', '147c578e-200f-407f-8f88-def9579a8fe1', '1', '2018-05-02 19:00:04', '', '2018-05-04 08:50:30', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('157', '262154', '未完成提醒', '28', '工单号(2018180011)未完成提醒', '工单(2018180011)当班未完成。计划结束时间:2018-5-2 19:30班别:白班产线:', '9', '8b1403cf-8318-4982-a8aa-60f01a2e138a', '1', '2018-05-02 19:00:04', '', '2018-05-04 01:21:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('158', '262154', '未完成提醒', '28', '工单号(2018180002)未完成提醒', '工单(2018180002)当班未完成。计划结束时间:2018-5-2 19:30班别:白班产线:', '3', '3b405850-2cbc-4921-92b2-621fac491ccf', '1', '2018-05-02 19:00:04', '', '2018-05-05 07:30:15', '2018-05-29 11:42:34', '0', '2018-05-29 11:42:34');
INSERT INTO `mep_warning` VALUES ('159', '65538', '设备报修预警提醒', '0', '设备编号(12#)设备报修预警提醒', '设备(12#)故障，请及时维修。n报修人:王柱林班别:白班产线:第二产线', '12', '805c539f-1229-4436-9c13-de03d9943dfd', '0', '2018-05-02 18:02:00', '', null, '2018-05-29 11:42:34', '4', '2018-06-06 08:26:25');
INSERT INTO `mep_warning` VALUES ('160', '65538', '设备报修预警提醒', '0', '设备编号(13#)设备报修预警提醒', '设备(13#)故障，请及时维修。n报修人:张成兵班别:夜班产线:第二产线', '13', '8c4bc51a-5e24-492b-b9ac-014131a43cf6', '0', '2018-05-30 05:20:05', '', null, '2018-05-30 09:38:46', '4', '2018-06-06 08:26:26');
INSERT INTO `mep_warning` VALUES ('161', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018220014)已超出计划生产数量。产品编码:20140025设备编号:12#班别:夜班产线:第二产线计划数量:288000超额数量:8', '12', '89f4ff98-0105-49de-ab4e-eb68194af0c3', '0', '2018-05-30 03:02:44', '', null, '2018-05-30 09:38:46', '4', '2018-06-06 08:26:26');
INSERT INTO `mep_warning` VALUES ('162', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018220010)已超出计划生产数量。产品编码:20140017设备编号:8#班别:夜班产线:第一产线计划数量:332000超额数量:4', '8', '45020a27-c913-493d-b2b2-3f105cf92a0c', '0', '2018-05-30 01:25:10', '', null, '2018-05-30 09:38:46', '4', '2018-06-06 08:26:26');
INSERT INTO `mep_warning` VALUES ('163', '262154', '未完成提醒', '28', '工单号(2018220014)未完成提醒', '工单(2018220014)当班未完成。计划结束时间:2018-5-29 19:30班别:白班产线:', '12', '39b376a3-d3ba-4307-afa3-85a2be74ead3', '0', '2018-05-29 19:00:00', '', null, '2018-05-30 09:38:46', '4', '2018-06-06 08:26:25');
INSERT INTO `mep_warning` VALUES ('164', '131079', '模具报修预警提醒', '0', '设备编号(16#)模具报修预警提醒', '模具(M031-0136(XH1504))故障，请及时维修。报修人:马铁青设备编号:16#班别:白班产线:第二产线', '16', '24524282-5a6d-4b9a-bf2f-f91010de9e71', '0', '2018-05-29 15:28:56', '', null, '2018-05-30 09:38:46', '4', '2018-06-06 08:26:25');
INSERT INTO `mep_warning` VALUES ('5408', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0133(XH1509))故障，请及时维修。报修人:马铁青设备编号:8#班别:白班产线:第一产线', '8', '3ae41d42-4216-4d55-9458-088e63b83cee', '0', '2018-05-30 10:26:19', '', null, '2018-05-30 10:26:51', '4', '2018-06-06 08:26:26');
INSERT INTO `mep_warning` VALUES ('17618', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:张成兵设备编号:4#班别:夜班产线:第一产线', '4', 'daa7d589-e16c-4a15-8546-bee4749cd9cb', '0', '2018-06-01 00:04:09', '', null, '2018-06-01 08:35:59', '4', '2018-06-06 08:26:27');
INSERT INTO `mep_warning` VALUES ('17677', '262149', '工单未开始预警提醒', '20', '设备编号(18#)工单未开始预警提醒', '设备编号(18#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '18', 'd276f28b-d8cc-4167-a6fc-b3bd62af2506', '1', '2018-06-02 09:38:09', '', '2018-06-02 09:38:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17678', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:马铁青设备编号:12#班别:白班产线:第二产线', '12', 'ca901e81-66ce-4ab6-a30b-f3b01f5262d5', '0', '2018-06-02 08:13:47', '', null, '2018-06-02 12:48:04', '4', '2018-06-06 08:26:27');
INSERT INTO `mep_warning` VALUES ('17679', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', 'ab23d01e-705e-4990-a334-a7c793c0815a', '1', '2018-06-02 08:04:49', '', '2018-06-02 08:05:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17680', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018220016)已超出计划生产数量。产品编码:20140002设备编号:14#班别:白班产线:第二产线计划数量:595000超额数量:8', '14', '0e19742e-168e-48be-a953-7ca8e469ab48', '1', '2018-06-02 07:15:40', '', '2018-06-02 09:37:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17681', '262149', '工单未开始预警提醒', '20', '设备编号(9#)工单未开始预警提醒', '设备编号(9#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '9', 'c85a0563-7fd5-4214-947d-5ef707026cf2', '1', '2018-06-02 07:09:39', '', null, '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17682', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', 'bc7f88e7-5034-4acb-8341-42c46784f3ee', '1', '2018-06-02 07:09:09', '', null, '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17683', '262153', '超工单生产预警提醒', '21', '设备编号(11#)超工单生产预警提醒', '工单(2018220013)已超出计划生产数量。产品编码:20140025设备编号:11#班别:夜班产线:第二产线计划数量:252000超额数量:8', '11', 'b9716926-6c3a-495f-9df5-8d5a745b7820', '1', '2018-06-02 04:56:14', '', '2018-06-02 07:10:00', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17684', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018220004)已超出计划生产数量。产品编码:20140026设备编号:3#班别:夜班产线:第一产线计划数量:185000超额数量:1', '3', 'f2948722-973e-4486-8a6d-365d90299cde', '1', '2018-06-02 04:08:18', '', '2018-06-02 07:07:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17685', '262153', '超工单生产预警提醒', '21', '设备编号(18#)超工单生产预警提醒', '工单(2018220020)已超出计划生产数量。产品编码:20140013设备编号:18#班别:夜班产线:第二产线计划数量:945000超额数量:8', '18', 'f69036cc-c193-4cae-8172-cb579a28b16a', '1', '2018-06-02 01:40:37', '', '2018-06-02 09:38:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17686', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018220007)已超出计划生产数量。产品编码:20140019设备编号:6#班别:夜班产线:第一产线计划数量:245000超额数量:6', '6', 'e43d30e9-4307-4458-918f-4a4b97f7e22a', '1', '2018-06-01 21:49:09', '', '2018-06-02 07:08:30', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17687', '262153', '超工单生产预警提醒', '21', '设备编号(1#)超工单生产预警提醒', '工单(2018220001)已超出计划生产数量。产品编码:20140001设备编号:1#班别:夜班产线:第一产线计划数量:259000超额数量:2', '1', '3ce45bc1-d06a-48b6-82e9-ce7ce10e0100', '1', '2018-06-01 21:22:14', '', '2018-06-02 07:07:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17688', '262153', '超工单生产预警提醒', '21', '设备编号(7#)超工单生产预警提醒', '工单(2018220006)已超出计划生产数量。产品编码:20140009设备编号:7#班别:夜班产线:第一产线计划数量:245000超额数量:2', '7', '7230b109-ba2f-4777-9bfc-b8444360a945', '1', '2018-06-01 20:55:59', '', '2018-06-02 07:08:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17689', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018220002)已超出计划生产数量。产品编码:20140001设备编号:2#班别:白班产线:第一产线计划数量:259000超额数量:2', '2', '2b2058e7-79ff-4ef7-bb1c-3ae14201cfe2', '1', '2018-06-01 19:23:08', '', '2018-06-02 07:07:30', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17690', '262154', '未完成提醒', '28', '工单号(2018220006)未完成提醒', '工单(2018220006)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '7', 'd6414508-345e-4e4f-ad7b-7bcc28b0b99c', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:08:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17691', '262154', '未完成提醒', '28', '工单号(2018220013)未完成提醒', '工单(2018220013)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '11', '7d8d1f4a-55f8-401f-af28-e304b99d541f', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:10:00', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17692', '262154', '未完成提醒', '28', '工单号(2018220016)未完成提醒', '工单(2018220016)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '14', '16b9cfa1-1f49-45c2-8054-76dc2c84d5f5', '1', '2018-06-01 19:00:00', '', '2018-06-02 09:37:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17693', '262154', '未完成提醒', '28', '工单号(2018220005)未完成提醒', '工单(2018220005)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '4', 'dab4b24b-d0d7-4066-b618-2ff52031a7db', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:08:00', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17694', '262154', '未完成提醒', '28', '工单号(2018220015)未完成提醒', '工单(2018220015)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '13', '1da814e7-4158-4846-9cba-1ebed54b3cdb', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:10:30', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17695', '262154', '未完成提醒', '28', '工单号(2018220020)未完成提醒', '工单(2018220020)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '18', '868155ab-4df0-47f6-9706-bc23953a0a90', '1', '2018-06-01 19:00:00', '', '2018-06-02 09:38:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17696', '262154', '未完成提醒', '28', '工单号(2018220001)未完成提醒', '工单(2018220001)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '1', '8840a034-5727-4509-aca8-918ab8da9d0c', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:07:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17697', '262154', '未完成提醒', '28', '工单号(2018220008)未完成提醒', '工单(2018220008)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '5', '94c9a958-0bfa-4950-93c0-cb2f80be9711', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:08:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17698', '262154', '未完成提醒', '28', '工单号(2018220022)未完成提醒', '工单(2018220022)当班未完成。计划结束时间:2018-06-01 19:30班别:白班产线:', '8', '4151236c-9b1b-4ed7-b5e1-ab629996dedd', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:09:15', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17699', '262154', '未完成提醒', '28', '工单号(2018220004)未完成提醒', '工单(2018220004)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '3', '29e71dac-fdd5-4d8c-8ab3-49a8e497aae0', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:07:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17700', '262154', '未完成提醒', '28', '工单号(2018220007)未完成提醒', '工单(2018220007)当班未完成。计划结束时间:2018-6-1 19:30班别:白班产线:', '6', '0569b60e-bea6-4178-9f73-920004d8ea64', '1', '2018-06-01 19:00:00', '', '2018-06-02 07:08:30', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17701', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018220011)已超出计划生产数量。产品编码:20140020设备编号:9#班别:白班产线:第一产线计划数量:595000超额数量:14', '9', '5806dd62-2c5b-4f3e-9d1f-3b9e191a6f80', '1', '2018-06-01 17:23:42', '', '2018-06-02 07:09:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17702', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018220019)已超出计划生产数量。产品编码:20140018设备编号:17#班别:白班产线:第二产线计划数量:630000超额数量:16', '17', '64e6dd7e-1412-4f8f-bd00-a0acce6a4337', '1', '2018-06-01 14:39:16', '', '2018-06-02 07:11:30', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17703', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018220012)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:770000超额数量:16', '10', '4fd035aa-de56-47f6-9c7f-da9683212c04', '1', '2018-06-01 13:16:50', '', '2018-06-02 08:00:45', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17704', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018220017)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:595000超额数量:8', '15', '3077964f-e984-42b4-8aa6-d81f72a10718', '1', '2018-06-01 12:56:20', '', '2018-06-02 07:11:00', '2018-06-02 12:48:04', '0', '2018-06-02 12:48:04');
INSERT INTO `mep_warning` VALUES ('17705', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0161)故障，请及时维修。报修人:马铁青设备编号:8#班别:白班产线:第一产线', '8', '7d120a4b-4188-4d82-b95c-aef2f83b02f3', '0', '2018-06-01 10:08:57', '', null, '2018-06-02 12:48:04', '4', '2018-06-06 08:26:27');
INSERT INTO `mep_warning` VALUES ('21037', '131079', '模具报修预警提醒', '0', '设备编号(18#)模具报修预警提醒', '模具(M031-0140(XH1512))故障，请及时维修。报修人:翟省委设备编号:18#班别:白班产线:第二产线', '18', 'aec134da-1b6b-4161-882d-274ba0500247', '0', '2018-06-02 15:12:14', '', null, '2018-06-02 15:13:39', '4', '2018-06-06 08:26:27');
INSERT INTO `mep_warning` VALUES ('22494', '131079', '模具报修预警提醒', '0', '设备编号(17#)模具报修预警提醒', '模具(M031-0135(XH1510))故障，请及时维修。报修人:翟省委设备编号:17#班别:白班产线:第二产线', '17', '49257b7c-c667-4c48-811e-c1b8a45ed338', '0', '2018-06-02 16:22:20', '', null, '2018-06-02 16:22:30', '4', '2018-06-06 08:26:28');
INSERT INTO `mep_warning` VALUES ('23774', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018230009)已超出计划生产数量。产品编码:20140017设备编号:8#班别:夜班产线:第一产线计划数量:166000超额数量:16', '8', '59014ea4-fc37-410a-8c6c-9aab139bd36e', '1', '2018-06-04 03:17:24', '', '2018-06-04 08:02:15', '2018-06-04 08:45:33', '0', '2018-06-04 08:45:33');
INSERT INTO `mep_warning` VALUES ('23775', '262154', '未完成提醒', '28', '工单号(2018230009)未完成提醒', '工单(2018230009)当班未完成。计划结束时间:2018-6-3 19:30班别:白班产线:', '8', 'b421ec9a-d0bf-4c9d-989f-1b738cd337f1', '1', '2018-06-03 19:00:02', '', '2018-06-04 08:02:15', '2018-06-04 08:45:33', '0', '2018-06-04 08:45:33');
INSERT INTO `mep_warning` VALUES ('23944', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', '5630e091-340d-48ab-9c60-e02adcfd912c', '1', '2018-06-04 08:51:24', '', null, '2018-06-04 08:51:32', '0', '2018-06-04 09:12:26');
INSERT INTO `mep_warning` VALUES ('37699', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:翟省委设备编号:12#班别:白班产线:第二产线', '12', '39d31750-1e17-4762-82de-cdc178057b27', '0', '2018-06-05 13:12:12', '', null, '2018-06-05 13:12:29', '4', '2018-06-06 08:26:28');
INSERT INTO `mep_warning` VALUES ('38563', '131079', '模具报修预警提醒', '0', '设备编号(10#)模具报修预警提醒', '模具(M031-0148)故障，请及时维修。报修人:翟省委设备编号:10#班别:白班产线:第一产线', '10', 'f7ab61ed-8234-4cc7-895d-bddd4f84dcf5', '0', '2018-06-05 13:42:26', '', null, '2018-06-05 13:42:49', '4', '2018-06-06 08:26:28');
INSERT INTO `mep_warning` VALUES ('38600', '131079', '模具报修预警提醒', '0', '设备编号(1#)模具报修预警提醒', '模具(M031-0160)故障，请及时维修。报修人:张成兵设备编号:1#班别:白班产线:第一产线', '1', 'c627cd43-f289-43b7-965e-1feff1b374eb', '0', '2018-06-06 07:15:37', '', null, '2018-06-06 08:25:57', '4', '2018-06-06 08:26:29');
INSERT INTO `mep_warning` VALUES ('38601', '262153', '超工单生产预警提醒', '21', '设备编号(1#)超工单生产预警提醒', '工单(2018230001)已超出计划生产数量。产品编码:20140001设备编号:1#班别:夜班产线:第一产线计划数量:148000超额数量:2', '1', '7ad65450-fcc8-4c98-ba17-1b8d8b0248ca', '1', '2018-06-06 01:12:26', '', '2018-06-09 09:13:00', '2018-06-06 08:25:57', '4', '2018-06-09 09:13:29');
INSERT INTO `mep_warning` VALUES ('38602', '262154', '未完成提醒', '28', '工单号(2018230001)未完成提醒', '工单(2018230001)当班未完成。计划结束时间:2018-6-5 19:30班别:白班产线:', '1', '6860a143-901d-461c-b3e7-c178becaf4ec', '1', '2018-06-05 19:00:00', '', '2018-06-09 09:13:00', '2018-06-06 08:25:57', '4', '2018-06-09 09:13:29');
INSERT INTO `mep_warning` VALUES ('41000', '131079', '模具报修预警提醒', '0', '设备编号(6#)模具报修预警提醒', '模具(M031-0162)故障，请及时维修。报修人:翟省委设备编号:6#班别:白班产线:第一产线', '6', 'f67b84ae-fbea-49c7-9f93-ac97bcddd553', '0', '2018-06-06 09:38:17', '', null, '2018-06-06 09:38:26', '4', '2018-06-06 09:39:55');
INSERT INTO `mep_warning` VALUES ('47519', '262149', '工单未开始预警提醒', '20', '设备编号(6#)工单未开始预警提醒', '设备编号(6#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '6', 'ba90c0ca-3084-4c52-8a33-bb4b08b44394', '1', '2018-06-07 08:18:23', '', null, '2018-06-07 12:18:18', '0', '2018-06-07 12:18:18');
INSERT INTO `mep_warning` VALUES ('54323', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018230011)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:330000超额数量:24', '10', '893adfeb-4d10-4118-bd4a-26a0168a78ef', '1', '2018-06-07 15:55:04', '', '2018-06-09 06:56:15', '2018-06-07 17:10:18', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('102827', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018230016)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:595000超额数量:8', '15', '4b4e6d3e-2893-4d63-90c8-bd1ac9769f25', '1', '2018-06-08 12:00:57', '', '2018-06-09 06:57:00', '2018-06-08 12:01:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('107975', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018230003)已超出计划生产数量。产品编码:20140026设备编号:3#班别:白班产线:第一产线计划数量:259000超额数量:8', '3', '4d7ceedd-a82e-4e1c-a04d-26ce72e5d375', '1', '2018-06-08 13:57:43', '', '2018-06-09 06:54:45', '2018-06-08 13:58:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('111530', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018230010)已超出计划生产数量。产品编码:20140010设备编号:9#班别:白班产线:第一产线计划数量:595000超额数量:31', '9', '5ae512d9-bbe5-4f9a-9b93-9457f5eaa5c5', '1', '2018-06-08 15:16:34', '', '2018-06-09 06:56:00', '2018-06-08 15:17:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('117372', '262153', '超工单生产预警提醒', '21', '设备编号(7#)超工单生产预警提醒', '工单(2018230005)已超出计划生产数量。产品编码:20140009设备编号:7#班别:白班产线:第一产线计划数量:245000超额数量:16', '7', '52dd3a48-044d-4602-b101-c61c30ea2a97', '1', '2018-06-08 17:23:40', '', '2018-06-09 06:55:30', '2018-06-08 17:24:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('117607', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018230017)已超出计划生产数量。产品编码:20140011设备编号:16#班别:白班产线:第二产线计划数量:595000超额数量:8', '16', '550bb672-f59e-4a85-8356-368af530c715', '1', '2018-06-08 17:28:30', '', '2018-06-09 06:57:15', '2018-06-08 17:29:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('119863', '65538', '设备报修预警提醒', '0', '设备编号(19#)设备报修预警提醒', '设备(19#)故障，请及时维修。n报修人:王柱林班别:白班产线:第二产线', '19', '35c2726e-69f4-4dfa-a290-8f55ec97fd3a', '0', '2018-06-08 18:15:45', '', null, '2018-06-08 18:16:21', '4', '2018-06-08 18:16:51');
INSERT INTO `mep_warning` VALUES ('121480', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018230002)已超出计划生产数量。产品编码:20140001设备编号:2#班别:白班产线:第一产线计划数量:259000超额数量:1', '2', 'a8518d93-aaa7-4d8d-ae9f-fc1d268bd2db', '1', '2018-06-08 18:48:46', '', '2018-06-09 06:54:30', '2018-06-08 18:49:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('121880', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018230004)已超出计划生产数量。产品编码:20140009设备编号:4#班别:白班产线:第一产线计划数量:245000超额数量:16', '4', '7c7518bf-8247-42ce-a652-3f932e781a38', '1', '2018-06-08 18:56:41', '', '2018-06-09 06:55:00', '2018-06-08 18:57:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('122033', '262154', '未完成提醒', '28', '工单号(2018230012)未完成提醒', '工单(2018230012)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '11', '475422e8-3166-4c54-9b40-a1cf2e6f961f', '1', '2018-06-08 19:00:12', '', '2018-06-09 06:56:15', '2018-06-08 19:00:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('122034', '262154', '未完成提醒', '28', '工单号(2018230014)未完成提醒', '工单(2018230014)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '13', '5ab59c44-6d49-4401-90c9-efa479ca25a5', '1', '2018-06-08 19:00:12', '', '2018-06-09 07:16:45', '2018-06-08 19:00:21', '4', '2018-06-09 07:17:21');
INSERT INTO `mep_warning` VALUES ('122035', '262154', '未完成提醒', '28', '工单号(2018230015)未完成提醒', '工单(2018230015)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '14', '445709f1-1e54-4b7d-a27c-edfa8256e7bd', '1', '2018-06-08 19:00:07', '', '2018-06-09 06:56:45', '2018-06-08 19:00:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('122036', '262154', '未完成提醒', '28', '工单号(2018230020)未完成提醒', '工单(2018230020)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '18', 'e225cbbe-69e9-495b-b53f-4c5aebb519d0', '1', '2018-06-08 19:00:07', '', '2018-06-09 06:57:45', '2018-06-08 19:00:21', '4', '2018-06-09 06:58:21');
INSERT INTO `mep_warning` VALUES ('122037', '262154', '未完成提醒', '28', '工单号(2018230007)未完成提醒', '工单(2018230007)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '5', '2b0e327f-1e88-4876-9dfa-f0b867b54530', '1', '2018-06-08 19:00:02', '', '2018-06-09 06:55:00', '2018-06-08 19:00:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('122038', '262154', '未完成提醒', '28', '工单号(2018230019)未完成提醒', '工单(2018230019)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '19', '180458d2-f48b-47b7-8d47-d02b4247ebf6', '1', '2018-06-08 19:00:02', '', '2018-06-09 06:57:45', '2018-06-08 19:00:21', '4', '2018-06-09 06:58:21');
INSERT INTO `mep_warning` VALUES ('122039', '262154', '未完成提醒', '28', '工单号(2018230021)未完成提醒', '工单(2018230021)当班未完成。计划结束时间:2018-06-08 19:30班别:白班产线:', '8', '0e7b1965-73eb-4bcb-8e87-909c853b6381', '1', '2018-06-08 19:00:02', '', '2018-06-09 06:55:45', '2018-06-08 19:00:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('122040', '262154', '未完成提醒', '28', '工单号(2018230013)未完成提醒', '工单(2018230013)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '12', '8011b065-4b8e-495b-988d-7df75fe7354d', '1', '2018-06-08 19:00:02', '', '2018-06-09 06:56:45', '2018-06-08 19:00:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('122041', '262154', '未完成提醒', '28', '工单号(2018230018)未完成提醒', '工单(2018230018)当班未完成。计划结束时间:2018-6-8 19:30班别:白班产线:', '17', '0df51043-e88f-4cd1-8c91-e1ef6946bf58', '1', '2018-06-08 19:00:02', '', '2018-06-09 00:58:00', '2018-06-08 19:00:21', '4', '2018-06-09 00:58:21');
INSERT INTO `mep_warning` VALUES ('122093', '262154', '未完成提醒', '28', '工单号(2018230022)未完成提醒', '工单(2018230022)当班未完成。计划结束时间:2018-06-08 19:30班别:白班产线:', '6', 'cd3464c8-69ee-426e-acb5-25704a4da2f2', '1', '2018-06-08 19:00:22', '', '2018-06-09 06:55:15', '2018-06-08 19:01:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('125509', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018230018)已超出计划生产数量。产品编码:20140018设备编号:17#班别:白班产线:第二产线计划数量:630000超额数量:16', '17', '5e9e1562-106a-4e52-bdbb-97f20ba93411', '1', '2018-06-08 19:56:26', '', '2018-06-09 06:57:30', '2018-06-08 19:57:21', '4', '2018-06-09 06:58:21');
INSERT INTO `mep_warning` VALUES ('128547', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018230013)已超出计划生产数量。产品编码:20140025设备编号:12#班别:夜班产线:第二产线计划数量:504000超额数量:32', '12', '57c5371a-7bde-4920-844a-ae350e726c36', '1', '2018-06-08 20:45:42', '', '2018-06-09 06:56:45', '2018-06-08 20:46:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('128799', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018230021)已超出计划生产数量。产品编码:20140006设备编号:8#班别:夜班产线:第一产线计划数量:415000超额数量:4', '8', '0d7fcf5a-97d1-45e8-950b-a32d4186b10f', '1', '2018-06-08 20:49:37', '', '2018-06-09 06:55:45', '2018-06-08 20:50:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('135455', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018230022)已超出计划生产数量。产品编码:20140009设备编号:6#班别:夜班产线:第一产线计划数量:70000超额数量:8', '6', '930e2e03-48d5-4d45-869d-1ff3c2da1a33', '1', '2018-06-08 22:33:58', '', '2018-06-09 06:55:15', '2018-06-08 22:34:21', '4', '2018-06-09 06:55:21');
INSERT INTO `mep_warning` VALUES ('153915', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018230015)已超出计划生产数量。产品编码:20140002设备编号:14#班别:夜班产线:第二产线计划数量:595000超额数量:8', '14', '86258032-8183-4e5d-a0ff-9f983171d8f5', '1', '2018-06-09 03:17:36', '', '2018-06-09 06:56:45', '2018-06-09 03:18:21', '4', '2018-06-09 06:57:21');
INSERT INTO `mep_warning` VALUES ('158535', '262153', '超工单生产预警提醒', '21', '设备编号(11#)超工单生产预警提醒', '工单(2018230012)已超出计划生产数量。产品编码:20140025设备编号:11#班别:夜班产线:第二产线计划数量:252000超额数量:12', '11', '0309805e-1c59-4e12-bcf4-85ca88fdd98d', '1', '2018-06-09 04:27:28', '', '2018-06-09 06:56:15', '2018-06-09 04:28:21', '4', '2018-06-09 06:56:21');
INSERT INTO `mep_warning` VALUES ('173677', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0161)故障，请及时维修。报修人:王柱林设备编号:8#班别:白班产线:第一产线', '8', '918d5570-6ae1-4741-9f61-5fe22f22cb82', '0', '2018-06-09 08:13:59', '', null, '2018-06-09 08:14:21', '4', '2018-06-09 09:48:59');
INSERT INTO `mep_warning` VALUES ('261193', '131079', '模具报修预警提醒', '0', '设备编号(6#)模具报修预警提醒', '模具(M031-0162)故障，请及时维修。报修人:王柱林设备编号:6#班别:夜班产线:第一产线', '6', 'f10cb489-e026-4ee2-8ac6-26b02bb1e317', '0', '2018-06-10 05:49:17', '', null, '2018-06-10 05:50:13', '4', '2018-06-11 05:49:43');
INSERT INTO `mep_warning` VALUES ('364279', '131079', '模具报修预警提醒', '0', '设备编号(12#)模具报修预警提醒', '模具(M031-0147)故障，请及时维修。报修人:王柱林设备编号:12#班别:夜班产线:第二产线', '12', 'b7039679-e88f-418f-91e1-22afd5fc7288', '0', '2018-06-11 06:44:07', '', null, '2018-06-11 06:44:13', '4', '2018-06-11 08:34:43');
INSERT INTO `mep_warning` VALUES ('483559', '131079', '模具报修预警提醒', '0', '设备编号(11#)模具报修预警提醒', '模具(M031-0146)故障，请及时维修。报修人:马铁青设备编号:11#班别:白班产线:第二产线', '11', 'adc5323a-d723-4932-8b62-a61e40cca41c', '0', '2018-06-12 11:15:20', '', null, '2018-06-12 11:16:20', '4', '2018-06-13 11:15:20');
INSERT INTO `mep_warning` VALUES ('516503', '262154', '未完成提醒', '28', '工单号(2018240003)未完成提醒', '工单(2018240003)当班未完成。计划结束时间:2018-6-12 19:30班别:白班产线:', '3', '81deb0c5-4271-4f35-8262-4d87cbccb03a', '1', '2018-06-12 19:00:03', '', '2018-06-13 08:32:00', '2018-06-12 19:00:20', '3', '2018-06-13 08:32:20');
INSERT INTO `mep_warning` VALUES ('525863', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018240003)已超出计划生产数量。产品编码:20140026设备编号:3#班别:夜班产线:第一产线计划数量:148000超额数量:8', '3', '8cc36d19-c534-4325-b6da-54b3c4f616d1', '1', '2018-06-12 21:09:22', '', '2018-06-13 08:32:00', '2018-06-12 21:10:20', '2', '2018-06-13 08:32:20');
INSERT INTO `mep_warning` VALUES ('573386', '131079', '模具报修预警提醒', '0', '设备编号(14#)模具报修预警提醒', '模具(M031-0145)故障，请及时维修。报修人:马铁青设备编号:14#班别:白班产线:第二产线', '14', '66ef09f4-6ada-4bc0-bc8a-3c338fc47337', '0', '2018-06-13 08:01:01', '', null, '2018-06-13 08:01:20', '4', '2018-06-14 08:01:21');
INSERT INTO `mep_warning` VALUES ('622152', '262154', '未完成提醒', '28', '工单号(2018240021)未完成提醒', '工单(2018240021)当班未完成。计划结束时间:2018-06-13 19:30班别:白班产线:', '3', 'fc9bc0cb-d443-42da-a83e-ce57a28508f2', '1', '2018-06-13 19:00:05', '', '2018-06-16 15:21:45', '2018-06-13 19:00:20', '4', '2018-06-16 15:22:21');
INSERT INTO `mep_warning` VALUES ('671952', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018240021)已超出计划生产数量。产品编码:20140026设备编号:3#班别:夜班产线:第一产线计划数量:37000超额数量:8', '3', '8c13abda-0190-4767-951e-ea5d68f5d02b', '1', '2018-06-14 06:04:07', '', '2018-06-16 15:21:45', '2018-06-14 06:04:20', '4', '2018-06-16 15:22:21');
INSERT INTO `mep_warning` VALUES ('690268', '262153', '超工单生产预警提醒', '21', '设备编号(13#)超工单生产预警提醒', '工单(2018240013)已超出计划生产数量。产品编码:20140007设备编号:13#班别:白班产线:第二产线计划数量:850000超额数量:16', '13', 'ce12f9c3-feb1-49d0-820f-e92d690bf8b0', '1', '2018-06-14 10:05:19', '', '2018-06-15 08:42:00', '2018-06-14 10:05:20', '3', '2018-06-15 08:42:21');
INSERT INTO `mep_warning` VALUES ('726920', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:张成兵设备编号:4#班别:白班产线:第一产线', '4', '17488412-9ac9-45cc-92e0-0fe6e90df3f9', '0', '2018-06-14 18:00:58', '', null, '2018-06-14 18:01:21', '4', '2018-06-15 18:01:21');
INSERT INTO `mep_warning` VALUES ('796496', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', '6eceb0b8-17be-41e4-a46d-4920c72aac3e', '1', '2018-06-15 08:55:51', '', null, '2018-06-15 08:56:21', '0', '2018-06-15 08:56:21');
INSERT INTO `mep_warning` VALUES ('805818', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018240017)已超出计划生产数量。产品编码:20140018设备编号:17#班别:白班产线:第二产线计划数量:630000超额数量:16', '17', '2b2151fb-e95b-4d51-8b47-eb8a0e2f3277', '1', '2018-06-15 10:53:34', '', '2018-06-16 07:24:00', '2018-06-15 10:54:21', '3', '2018-06-16 07:24:21');
INSERT INTO `mep_warning` VALUES ('809178', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018240010)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:770000超额数量:20', '10', '93af6751-0630-4caa-acb6-c9c316829070', '1', '2018-06-15 11:36:14', '', '2018-06-16 07:17:00', '2018-06-15 11:36:21', '3', '2018-06-16 07:17:21');
INSERT INTO `mep_warning` VALUES ('812418', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018240009)已超出计划生产数量。产品编码:20140010设备编号:9#班别:白班产线:第一产线计划数量:595000超额数量:4', '9', '9086a71e-cdb6-40b4-a7cb-e56b7d22d031', '1', '2018-06-15 12:15:54', '', '2018-06-16 07:16:45', '2018-06-15 12:16:21', '3', '2018-06-16 07:17:21');
INSERT INTO `mep_warning` VALUES ('842840', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018240016)已超出计划生产数量。产品编码:20140011设备编号:16#班别:白班产线:第二产线计划数量:595000超额数量:8', '16', '885c0123-2e34-4515-938e-19726ef24226', '1', '2018-06-15 18:26:37', '', '2018-06-16 07:23:45', '2018-06-15 18:27:21', '3', '2018-06-16 07:24:21');
INSERT INTO `mep_warning` VALUES ('844998', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018240002)已超出计划生产数量。产品编码:20140001设备编号:2#班别:白班产线:第一产线计划数量:259000超额数量:4', '2', '67552b38-481c-45cf-b638-b3e60ec93972', '1', '2018-06-15 18:52:38', '', '2018-06-16 07:15:45', '2018-06-15 18:53:21', '3', '2018-06-16 07:16:21');
INSERT INTO `mep_warning` VALUES ('845586', '262154', '未完成提醒', '28', '工单号(2018240014)未完成提醒', '工单(2018240014)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '14', '78f72eeb-3910-4c3b-86ba-4f04cd6337d4', '1', '2018-06-15 19:00:10', '', '2018-06-16 07:17:45', '2018-06-15 19:00:21', '3', '2018-06-16 07:18:21');
INSERT INTO `mep_warning` VALUES ('845587', '262154', '未完成提醒', '28', '工单号(2018240006)未完成提醒', '工单(2018240006)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '7', 'b63f66af-4d86-4a5d-84d3-563896208ec3', '1', '2018-06-15 19:00:10', '', '2018-06-16 07:16:30', '2018-06-15 19:00:21', '3', '2018-06-16 07:17:21');
INSERT INTO `mep_warning` VALUES ('845588', '262154', '未完成提醒', '28', '工单号(2018240011)未完成提醒', '工单(2018240011)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '11', '37027d86-54b2-416d-bb51-53b36c34eca6', '1', '2018-06-15 19:00:05', '', '2018-06-16 08:12:15', '2018-06-15 19:00:21', '3', '2018-06-16 08:12:21');
INSERT INTO `mep_warning` VALUES ('845589', '262154', '未完成提醒', '28', '工单号(2018240019)未完成提醒', '工单(2018240019)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '18', 'ec2c580d-c91a-40bb-b93d-776abd372875', '1', '2018-06-15 19:00:05', '', '2018-06-16 08:12:45', '2018-06-15 19:00:21', '3', '2018-06-16 08:13:21');
INSERT INTO `mep_warning` VALUES ('845590', '262154', '未完成提醒', '28', '工单号(2018240020)未完成提醒', '工单(2018240020)当班未完成。计划结束时间:2018-06-15 19:30班别:白班产线:', '19', '1e83c235-fac8-4f6c-a4ec-4eb2545ad57a', '1', '2018-06-15 19:00:05', '', '2018-06-16 09:24:45', '2018-06-15 19:00:21', '3', '2018-06-16 09:25:21');
INSERT INTO `mep_warning` VALUES ('845591', '262154', '未完成提醒', '28', '工单号(2018240007)未完成提醒', '工单(2018240007)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '5', '69c550cf-e58f-43b0-97c0-f4edb74bd685', '1', '2018-06-15 19:00:00', '', '2018-06-16 07:16:00', '2018-06-15 19:00:21', '3', '2018-06-16 07:16:21');
INSERT INTO `mep_warning` VALUES ('845592', '262154', '未完成提醒', '28', '工单号(2018240005)未完成提醒', '工单(2018240005)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '6', 'c962be1b-af86-41b9-82c3-017dbac88d9d', '1', '2018-06-15 19:00:00', '', '2018-06-16 07:16:15', '2018-06-15 19:00:21', '3', '2018-06-16 07:16:21');
INSERT INTO `mep_warning` VALUES ('845593', '262154', '未完成提醒', '28', '工单号(2018240023)未完成提醒', '工单(2018240023)当班未完成。计划结束时间:2018-06-15 19:30班别:白班产线:', '8', '7d691406-db95-4eaf-a1b1-a810297f2676', '1', '2018-06-15 19:00:00', '', '2018-06-16 07:16:45', '2018-06-15 19:00:21', '3', '2018-06-16 07:17:21');
INSERT INTO `mep_warning` VALUES ('845594', '262154', '未完成提醒', '28', '工单号(2018240015)未完成提醒', '工单(2018240015)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '15', 'a8219ea7-335e-4b08-9ff9-eee64867afd4', '1', '2018-06-15 19:00:00', '', '2018-06-16 07:17:45', '2018-06-15 19:00:21', '3', '2018-06-16 07:18:21');
INSERT INTO `mep_warning` VALUES ('845595', '262154', '未完成提醒', '28', '工单号(2018240001)未完成提醒', '工单(2018240001)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '1', 'e7f211c0-5c09-4c3a-8e0b-3ec1306becc4', '1', '2018-06-15 19:00:00', '', '2018-06-16 07:15:30', '2018-06-15 19:00:21', '3', '2018-06-16 07:16:21');
INSERT INTO `mep_warning` VALUES ('845680', '262154', '未完成提醒', '28', '工单号(2018240022)未完成提醒', '工单(2018240022)当班未完成。计划结束时间:2018-06-15 19:30班别:白班产线:', '13', 'ee89693b-f78e-4dd8-9643-4b7669e3bb1d', '1', '2018-06-15 19:00:20', '', '2018-06-16 13:22:30', '2018-06-15 19:01:21', '3', '2018-06-16 13:23:21');
INSERT INTO `mep_warning` VALUES ('848245', '262154', '未完成提醒', '28', '工单号(2018240004)未完成提醒', '工单(2018240004)当班未完成。计划结束时间:2018-6-15 19:30班别:白班产线:', '4', '3bd78a7b-8664-4eea-9544-7666ec52fa33', '1', '2018-06-15 19:27:51', '', '2018-06-17 08:42:30', '2018-06-15 19:28:21', '4', '2018-06-19 11:07:48');
INSERT INTO `mep_warning` VALUES ('891925', '262153', '超工单生产预警提醒', '21', '设备编号(5#)超工单生产预警提醒', '工单(2018240007)已超出计划生产数量。产品编码:20140015设备编号:5#班别:夜班产线:第一产线计划数量:630000超额数量:12', '5', '322c300a-1c07-47bf-8e15-3acd63130b7d', '1', '2018-06-16 03:03:07', '', '2018-06-16 07:16:00', '2018-06-16 03:03:21', '2', '2018-06-16 07:16:21');
INSERT INTO `mep_warning` VALUES ('895029', '262153', '超工单生产预警提醒', '21', '设备编号(18#)超工单生产预警提醒', '工单(2018240019)已超出计划生产数量。产品编码:20140024设备编号:18#班别:夜班产线:第二产线计划数量:1610000超额数量:80', '18', 'cebe28dd-508d-4e22-af8c-6f031acc0e46', '1', '2018-06-16 03:34:52', '', '2018-06-16 08:12:45', '2018-06-16 03:35:21', '2', '2018-06-16 08:13:21');
INSERT INTO `mep_warning` VALUES ('913649', '262153', '超工单生产预警提醒', '21', '设备编号(11#)超工单生产预警提醒', '工单(2018240011)已超出计划生产数量。产品编码:20140025设备编号:11#班别:夜班产线:第二产线计划数量:252000超额数量:8', '11', 'd3503fa0-3b4e-4fae-8ea9-37d3961ec27f', '1', '2018-06-16 06:45:01', '', '2018-06-16 08:12:15', '2018-06-16 06:45:21', '1', '2018-06-16 08:12:21');
INSERT INTO `mep_warning` VALUES ('914639', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018240023)已超出计划生产数量。产品编码:20140006设备编号:8#班别:夜班产线:第一产线计划数量:85000超额数量:24', '8', '7804bd08-6f25-47b4-b20d-c35dd1514e06', '1', '2018-06-16 06:54:51', '', '2018-06-16 07:16:45', '2018-06-16 06:55:21', '1', '2018-06-16 07:17:21');
INSERT INTO `mep_warning` VALUES ('916839', '262149', '工单未开始预警提醒', '20', '设备编号(7#)工单未开始预警提醒', '设备编号(7#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '7', 'da8c03b9-c475-42f1-9bdf-81999c18f9f7', '1', '2018-06-16 07:16:37', '', null, '2018-06-16 07:17:21', '1', '2018-06-16 07:52:21');
INSERT INTO `mep_warning` VALUES ('930171', '131079', '模具报修预警提醒', '0', '设备编号(10#)模具报修预警提醒', '模具(M031-0148)故障，请及时维修。报修人:张成兵设备编号:10#班别:白班产线:第一产线', '10', '21fdc0eb-dbf5-4b60-a78c-ffcfc7c6e531', '0', '2018-06-16 09:29:21', '', null, '2018-06-16 09:29:21', '4', '2018-06-19 11:07:48');
INSERT INTO `mep_warning` VALUES ('935475', '262153', '超工单生产预警提醒', '21', '设备编号(13#)超工单生产预警提醒', '工单(2018240022)已超出计划生产数量。产品编码:20140007设备编号:13#班别:白班产线:第二产线计划数量:170000超额数量:16', '13', '7ad09cc8-b76c-47ea-b012-a81db71e5b5b', '1', '2018-06-16 10:20:32', '', '2018-06-16 13:22:30', '2018-06-16 10:21:21', '2', '2018-06-16 13:23:21');
INSERT INTO `mep_warning` VALUES ('935476', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0161)故障，请及时维修。报修人:张成兵设备编号:8#班别:白班产线:第一产线', '8', 'b193f255-dd66-48e1-80fc-3356087701a2', '0', '2018-06-19 10:56:49', '', null, '2018-06-19 11:07:48', '4', '2018-06-20 10:57:17');
INSERT INTO `mep_warning` VALUES ('935477', '262154', '未完成提醒', '28', '工单号(2018250020)未完成提醒', '工单(2018250020)当班未完成。计划结束时间:2018-06-17 19:30班别:白班产线:', '7', 'b60277c0-b751-45fb-a1c1-99726af7fe4e', '1', '2018-06-17 19:00:04', '', '2018-06-23 07:32:30', '2018-06-19 11:07:48', '4', '2018-06-23 07:32:49');
INSERT INTO `mep_warning` VALUES ('1082371', '131079', '模具报修预警提醒', '0', '设备编号(1#)模具报修预警提醒', '模具(M031-0160)故障，请及时维修。报修人:张成兵设备编号:1#班别:白班产线:第一产线', '1', '636dc58f-3502-4cb1-a65f-3ba2e9b9fcc3', '0', '2018-06-20 10:26:31', '', null, '2018-06-20 10:27:17', '4', '2018-06-21 10:26:48');
INSERT INTO `mep_warning` VALUES ('1088201', '65538', '设备报修预警提醒', '0', '设备编号(8#)设备报修预警提醒', '设备(8#)故障，请及时维修。n报修人:张成兵班别:白班产线:第一产线', '8', '61c97268-70c9-414d-bc5a-3406a13c084d', '0', '2018-06-20 11:21:28', '', null, '2018-06-20 11:22:17', '4', '2018-06-21 11:21:49');
INSERT INTO `mep_warning` VALUES ('1138063', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0161)故障，请及时维修。报修人:王柱林设备编号:8#班别:白班产线:第一产线', '8', '89912c78-70f3-42f6-aa9c-6b3be261ff18', '0', '2018-06-20 19:07:17', '', null, '2018-06-20 19:08:17', '4', '2018-06-21 19:07:18');
INSERT INTO `mep_warning` VALUES ('1211071', '262153', '超工单生产预警提醒', '21', '设备编号(7#)超工单生产预警提醒', '工单(2018250020)已超出计划生产数量。产品编码:20140009设备编号:7#班别:夜班产线:第一产线计划数量:70000超额数量:8', '7', '439a9cf2-f586-4523-a6f4-a51054e7e7b4', '1', '2018-06-21 06:26:10', '', '2018-06-23 07:32:30', '2018-06-21 06:26:18', '4', '2018-06-23 07:32:49');
INSERT INTO `mep_warning` VALUES ('1241373', '131079', '模具报修预警提醒', '0', '设备编号(7#)模具报修预警提醒', '模具(M031-0152)故障，请及时维修。报修人:王柱林设备编号:7#班别:白班产线:第一产线', '7', '4dc67f02-d1ca-437c-9b89-6581b46ed00d', '0', '2018-06-21 11:03:27', '', null, '2018-06-21 11:04:18', '4', '2018-06-22 11:03:48');
INSERT INTO `mep_warning` VALUES ('1396143', '131079', '模具报修预警提醒', '0', '设备编号(14#)模具报修预警提醒', '模具(M031-0145)故障，请及时维修。报修人:王柱林设备编号:14#班别:白班产线:第二产线', '14', '8944d174-a9b8-496f-ab65-25df48f5f948', '0', '2018-06-22 10:31:46', '', null, '2018-06-22 10:31:48', '4', '2018-06-23 10:32:19');
INSERT INTO `mep_warning` VALUES ('1452641', '262154', '未完成提醒', '28', '工单号(2018250001)未完成提醒', '工单(2018250001)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '1', '52aed88b-74bb-488e-adae-95b37a3de098', '1', '2018-06-22 19:00:29', '', '2018-06-23 07:31:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:31:49');
INSERT INTO `mep_warning` VALUES ('1452642', '262154', '未完成提醒', '28', '工单号(2018250014)未完成提醒', '工单(2018250014)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '14', '96cacf86-8f81-475a-937c-38bc90bc8fc5', '1', '2018-06-22 19:00:19', '', '2018-06-23 07:34:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1452643', '262154', '未完成提醒', '28', '工单号(2018250019)未完成提醒', '工单(2018250019)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '19', '77049507-c8af-496c-97f6-4219d4b3187f', '1', '2018-06-22 19:00:14', '', '2018-06-23 07:35:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:35:49');
INSERT INTO `mep_warning` VALUES ('1452644', '262154', '未完成提醒', '28', '工单号(2018250007)未完成提醒', '工单(2018250007)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '5', '7d43470d-0dbc-47a8-b81e-0dd78c03e5db', '1', '2018-06-22 19:00:14', '', '2018-06-23 07:32:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:32:49');
INSERT INTO `mep_warning` VALUES ('1452645', '262154', '未完成提醒', '28', '工单号(2018250012)未完成提醒', '工单(2018250012)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '12', 'de25ca7a-fa8c-42a5-9ca1-7ff91d5101a5', '1', '2018-06-22 19:00:09', '', '2018-06-23 07:33:30', '2018-06-22 19:00:49', '3', '2018-06-23 07:33:49');
INSERT INTO `mep_warning` VALUES ('1452646', '262154', '未完成提醒', '28', '工单号(2018250005)未完成提醒', '工单(2018250005)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '6', '02d9a067-2585-42fa-ad4d-c352ec8cfd21', '1', '2018-06-22 19:00:09', '', '2018-06-23 07:32:15', '2018-06-22 19:00:49', '3', '2018-06-23 07:32:49');
INSERT INTO `mep_warning` VALUES ('1452647', '262154', '未完成提醒', '28', '工单号(2018250016)未完成提醒', '工单(2018250016)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '16', 'a19493db-fb83-47eb-b059-ae08dec2d036', '1', '2018-06-22 19:00:09', '', '2018-06-23 07:34:30', '2018-06-22 19:00:49', '3', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1452648', '262154', '未完成提醒', '28', '工单号(2018250002)未完成提醒', '工单(2018250002)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '2', 'bf45c2dd-e6e0-4d93-b757-4ebc27b6fc42', '1', '2018-06-22 19:00:09', '', '2018-06-23 07:31:30', '2018-06-22 19:00:49', '3', '2018-06-23 07:31:49');
INSERT INTO `mep_warning` VALUES ('1452649', '262154', '未完成提醒', '28', '工单号(2018250010)未完成提醒', '工单(2018250010)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '10', '61197031-38d2-433f-ab30-268db76b8dc2', '1', '2018-06-22 19:00:05', '', '2018-06-23 07:33:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:33:49');
INSERT INTO `mep_warning` VALUES ('1452650', '262154', '未完成提醒', '28', '工单号(2018250011)未完成提醒', '工单(2018250011)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '11', 'd7fcf591-df82-4273-a1ee-615ada449ef0', '1', '2018-06-22 19:00:05', '', '2018-06-23 07:33:15', '2018-06-22 19:00:49', '3', '2018-06-23 07:33:49');
INSERT INTO `mep_warning` VALUES ('1452651', '262154', '未完成提醒', '28', '工单号(2018250015)未完成提醒', '工单(2018250015)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '15', '56cb1993-564e-4653-ad7b-da9aa93e5b3a', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:34:15', '2018-06-22 19:00:49', '3', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1452652', '262154', '未完成提醒', '28', '工单号(2018250017)未完成提醒', '工单(2018250017)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '17', 'b04716f0-4195-42f7-86e1-48ef303839a9', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:34:45', '2018-06-22 19:00:49', '3', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1452653', '262154', '未完成提醒', '28', '工单号(2018250009)未完成提醒', '工单(2018250009)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '9', 'b832f46a-4a30-47cf-9017-49278d568d87', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:32:45', '2018-06-22 19:00:49', '3', '2018-06-23 07:32:49');
INSERT INTO `mep_warning` VALUES ('1452654', '262154', '未完成提醒', '28', '工单号(2018250003)未完成提醒', '工单(2018250003)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '3', 'f47a49a8-c5cf-4609-b26f-f1ce62eca9d0', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:31:45', '2018-06-22 19:00:49', '3', '2018-06-23 07:31:49');
INSERT INTO `mep_warning` VALUES ('1452655', '262154', '未完成提醒', '28', '工单号(2018250008)未完成提醒', '工单(2018250008)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '8', 'e3648d25-669e-4feb-a6a9-1c5cb908bb29', '1', '2018-06-22 19:00:04', '', '2018-06-23 15:31:00', '2018-06-22 19:00:49', '3', '2018-06-23 15:31:49');
INSERT INTO `mep_warning` VALUES ('1452656', '262154', '未完成提醒', '28', '工单号(2018250018)未完成提醒', '工单(2018250018)当班未完成。计划结束时间:2018-6-22 19:30班别:白班产线:', '18', '00d090ca-b4c8-4c34-9316-e5bd02264a71', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:35:00', '2018-06-22 19:00:49', '3', '2018-06-23 07:35:49');
INSERT INTO `mep_warning` VALUES ('1452657', '262154', '未完成提醒', '28', '工单号(2018250021)未完成提醒', '工单(2018250021)当班未完成。计划结束时间:2018-06-22 19:30班别:白班产线:', '4', 'f380e9d4-fc35-4ef4-98ed-dfc7c2c67f60', '1', '2018-06-22 19:00:04', '', '2018-06-23 07:31:45', '2018-06-22 19:00:49', '3', '2018-06-23 07:31:49');
INSERT INTO `mep_warning` VALUES ('1516257', '262153', '超工单生产预警提醒', '21', '设备编号(18#)超工单生产预警提醒', '工单(2018250018)已超出计划生产数量。产品编码:20140013设备编号:18#班别:夜班产线:第二产线计划数量:675000超额数量:24', '18', 'b92dfa26-c253-477c-8a95-9e6df9c6cd9d', '1', '2018-06-23 03:17:29', '', '2018-06-23 07:35:00', '2018-06-23 03:17:49', '2', '2018-06-23 07:35:49');
INSERT INTO `mep_warning` VALUES ('1543476', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018250015)已超出计划生产数量。产品编码:20140012设备编号:15#班别:夜班产线:第二产线计划数量:510000超额数量:16', '15', '33ae7c85-3de2-4e63-998d-247cb7eff7cd', '1', '2018-06-23 06:47:52', '', '2018-06-23 07:34:15', '2018-06-23 06:48:49', '1', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1544516', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018250021)已超出计划生产数量。产品编码:20140019设备编号:4#班别:夜班产线:第一产线计划数量:35000超额数量:16', '4', 'a29896d9-5ae0-4c42-a7b9-ad9757b46539', '1', '2018-06-23 06:55:57', '', '2018-06-23 07:31:45', '2018-06-23 06:56:49', '1', '2018-06-23 07:31:49');
INSERT INTO `mep_warning` VALUES ('1545433', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018250017)已超出计划生产数量。产品编码:20140018设备编号:17#班别:白班产线:第二产线计划数量:540000超额数量:16', '17', '98c82c3d-fca1-448e-934d-9bca05933231', '1', '2018-06-23 07:02:57', '', '2018-06-23 07:34:45', '2018-06-23 07:03:49', '1', '2018-06-23 07:34:49');
INSERT INTO `mep_warning` VALUES ('1549393', '262149', '工单未开始预警提醒', '20', '设备编号(11#)工单未开始预警提醒', '设备编号(11#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '11', '962cd24a-cc35-41a7-bb6b-1d64d8235388', '1', '2018-06-23 07:33:25', '', null, '2018-06-23 07:33:49', '1', '2018-06-23 08:05:49');
INSERT INTO `mep_warning` VALUES ('1974328', '131079', '模具报修预警提醒', '0', '设备编号(13#)模具报修预警提醒', '模具(M031-0134(XH1508))故障，请及时维修。报修人:王柱林设备编号:13#班别:白班产线:第二产线', '13', 'e4dfcd6a-b4b5-4314-b997-140012c58a36', '0', '2018-06-25 12:47:57', '', null, '2018-06-25 12:48:50', '4', '2018-06-26 12:48:21');
INSERT INTO `mep_warning` VALUES ('2146116', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:张成兵设备编号:4#班别:白班产线:第一产线', '4', 'c7940203-51ab-49f0-aed6-5f09172b6224', '0', '2018-06-26 10:10:46', '', null, '2018-06-26 10:10:50', '4', '2018-06-27 10:11:27');
INSERT INTO `mep_warning` VALUES ('2161101', '262149', '工单未开始预警提醒', '20', '设备编号(1#)工单未开始预警提醒', '设备编号(1#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '1', '3ff06c42-483b-46ae-8f4a-ab32cc0a0293', '1', '2018-06-26 12:01:35', '', '2018-06-26 12:01:45', '2018-06-26 12:01:50', '0', '2018-06-26 12:01:50');
INSERT INTO `mep_warning` VALUES ('2218085', '262154', '未完成提醒', '28', '工单号(2018260005)未完成提醒', '工单(2018260005)当班未完成。计划结束时间:2018-6-26 19:30班别:白班产线:', '6', '45d0ca18-7535-4dfa-9206-4a034d047681', '1', '2018-06-26 19:00:09', '', '2018-06-27 08:07:45', '2018-06-26 19:00:57', '3', '2018-06-27 08:07:57');
INSERT INTO `mep_warning` VALUES ('2261240', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018260005)已超出计划生产数量。产品编码:20140009设备编号:6#班别:夜班产线:第一产线计划数量:140000超额数量:8', '6', 'b282c941-5818-43c5-99c5-6134ab27b889', '1', '2018-06-27 00:15:07', '', '2018-06-27 08:07:45', '2018-06-27 00:15:57', '2', '2018-06-27 08:07:57');
INSERT INTO `mep_warning` VALUES ('2615072', '262154', '未完成提醒', '28', '工单号(2018260021)未完成提醒', '工单(2018260021)当班未完成。计划结束时间:2018-06-28 19:30班别:白班产线:', '6', '65bb8969-7704-4378-95c9-d288f40e6896', '0', '2018-06-28 19:00:09', '', null, '2018-06-28 19:00:28', '4', '2018-06-29 19:00:29');
INSERT INTO `mep_warning` VALUES ('2697916', '262153', '超工单生产预警提醒', '21', '设备编号(6#)超工单生产预警提醒', '工单(2018260021)已超出计划生产数量。产品编码:20140009设备编号:6#班别:夜班产线:第一产线计划数量:70000超额数量:8', '6', 'b274e636-ada4-4328-9c04-dc3ea3159c8e', '0', '2018-06-29 04:56:21', '', null, '2018-06-29 04:56:28', '4', '2018-06-30 04:56:29');
INSERT INTO `mep_warning` VALUES ('2728296', '262153', '超工单生产预警提醒', '21', '设备编号(15#)超工单生产预警提醒', '工单(2018260015)已超出计划生产数量。产品编码:20140012设备编号:15#班别:白班产线:第二产线计划数量:595000超额数量:8', '15', '3d944f47-6bcc-4f17-97ad-1b6e19d0b288', '1', '2018-06-29 08:32:49', '', '2018-06-30 07:23:00', '2018-06-29 08:33:28', '3', '2018-06-30 07:23:29');
INSERT INTO `mep_warning` VALUES ('2777082', '262153', '超工单生产预警提醒', '21', '设备编号(17#)超工单生产预警提醒', '工单(2018260017)已超出计划生产数量。产品编码:20140018设备编号:17#班别:白班产线:第二产线计划数量:630000超额数量:16', '17', '6dcdb1de-e399-4845-b23f-b52bf26c2651', '1', '2018-06-29 14:18:32', '', '2018-06-30 07:23:30', '2018-06-29 14:19:28', '3', '2018-06-30 07:24:29');
INSERT INTO `mep_warning` VALUES ('2777650', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018260009)已超出计划生产数量。产品编码:20140010设备编号:9#班别:白班产线:第一产线计划数量:595000超额数量:8', '9', '4e1252ce-ae86-42e5-b4f3-57b11e60e634', '1', '2018-06-29 14:22:47', '', '2018-06-30 07:33:30', '2018-06-29 14:23:28', '3', '2018-06-30 07:34:29');
INSERT INTO `mep_warning` VALUES ('2777793', '262153', '超工单生产预警提醒', '21', '设备编号(10#)超工单生产预警提醒', '工单(2018260010)已超出计划生产数量。产品编码:20140004设备编号:10#班别:白班产线:第一产线计划数量:770000超额数量:8', '10', '0f0decd8-5825-484b-9663-8afdc382e8e0', '1', '2018-06-29 14:23:57', '', '2018-06-30 07:22:15', '2018-06-29 14:24:28', '3', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2791905', '131079', '模具报修预警提醒', '0', '设备编号(7#)模具报修预警提醒', '模具(M031-0152)故障，请及时维修。报修人:王柱林设备编号:7#班别:白班产线:第一产线', '7', '4986555a-8e27-41e6-be72-277a7bac0e99', '0', '2018-06-29 16:02:10', '', null, '2018-06-29 16:02:28', '4', '2018-06-30 16:02:29');
INSERT INTO `mep_warning` VALUES ('2794370', '262153', '超工单生产预警提醒', '21', '设备编号(12#)超工单生产预警提醒', '工单(2018260012)已超出计划生产数量。产品编码:20140025设备编号:12#班别:白班产线:第二产线计划数量:504000超额数量:16', '12', '185608c7-1d96-4fa7-9e46-4bae4467d077', '1', '2018-06-29 16:18:48', '', '2018-06-30 07:58:45', '2018-06-29 16:19:28', '3', '2018-06-30 07:59:29');
INSERT INTO `mep_warning` VALUES ('2814810', '262153', '超工单生产预警提醒', '21', '设备编号(16#)超工单生产预警提醒', '工单(2018260016)已超出计划生产数量。产品编码:20140011设备编号:16#班别:白班产线:第二产线计划数量:595000超额数量:8', '16', '34f538eb-06cd-485c-851b-503138faf11a', '1', '2018-06-29 18:39:14', '', '2018-06-30 07:23:00', '2018-06-29 18:39:58', '3', '2018-06-30 07:23:29');
INSERT INTO `mep_warning` VALUES ('2817897', '262154', '未完成提醒', '28', '工单号(2018260007)未完成提醒', '工单(2018260007)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '5', '159e2079-2d1a-46b2-9cd1-11fd589f4492', '1', '2018-06-29 19:00:21', '', '2018-06-30 07:21:30', '2018-06-29 19:00:58', '3', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2817898', '262154', '未完成提醒', '28', '工单号(2018260020)未完成提醒', '工单(2018260020)当班未完成。计划结束时间:2018-06-29 19:30班别:白班产线:', '1', '957d33de-c39b-4bcf-9fce-93bb4bbb5262', '1', '2018-06-29 19:00:11', '', '2018-06-30 09:46:00', '2018-06-29 19:00:58', '3', '2018-06-30 09:46:29');
INSERT INTO `mep_warning` VALUES ('2817899', '262154', '未完成提醒', '28', '工单号(2018260013)未完成提醒', '工单(2018260013)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '13', '9bedd9ea-9b38-4ac8-aaa9-db193c0e2445', '1', '2018-06-29 19:00:11', '', '2018-06-30 07:22:45', '2018-06-29 19:00:58', '3', '2018-06-30 07:23:29');
INSERT INTO `mep_warning` VALUES ('2817900', '262154', '未完成提醒', '28', '工单号(2018260008)未完成提醒', '工单(2018260008)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '8', '6c8b34b8-60b9-4090-854d-8a4ebc1a8747', '1', '2018-06-29 19:00:06', '', '2018-06-30 07:22:00', '2018-06-29 19:00:58', '3', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2817901', '262154', '未完成提醒', '28', '工单号(2018260004)未完成提醒', '工单(2018260004)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '4', '1e866ae2-785d-4325-ac9a-0291b6b7e601', '1', '2018-06-29 19:00:06', '', '2018-06-30 07:21:30', '2018-06-29 19:00:58', '3', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2817902', '262154', '未完成提醒', '28', '工单号(2018260018)未完成提醒', '工单(2018260018)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '18', '13f7663b-08f9-49fd-8cf1-a1a7e9631cb0', '1', '2018-06-29 19:00:01', '', '2018-06-30 07:23:45', '2018-06-29 19:00:58', '3', '2018-06-30 07:24:29');
INSERT INTO `mep_warning` VALUES ('2817903', '262154', '未完成提醒', '28', '工单号(2018260011)未完成提醒', '工单(2018260011)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '11', 'd68cbde1-14e8-4b30-8828-6f7734114601', '1', '2018-06-29 19:00:01', '', '2018-06-30 07:22:30', '2018-06-29 19:00:58', '3', '2018-06-30 07:23:29');
INSERT INTO `mep_warning` VALUES ('2817904', '262154', '未完成提醒', '28', '工单号(2018260002)未完成提醒', '工单(2018260002)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '2', 'c5d7c921-4130-45ae-8d84-8c73bc01d2e3', '1', '2018-06-29 19:00:01', '', '2018-06-30 07:21:00', '2018-06-29 19:00:58', '3', '2018-06-30 07:21:29');
INSERT INTO `mep_warning` VALUES ('2817905', '262154', '未完成提醒', '28', '工单号(2018260019)未完成提醒', '工单(2018260019)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '19', 'da01820d-3408-4c92-bcb4-74b546edcdae', '1', '2018-06-29 19:00:01', '', '2018-06-30 07:24:00', '2018-06-29 19:00:58', '3', '2018-06-30 07:24:29');
INSERT INTO `mep_warning` VALUES ('2817906', '262154', '未完成提醒', '28', '工单号(2018260003)未完成提醒', '工单(2018260003)当班未完成。计划结束时间:2018-6-29 19:30班别:白班产线:', '3', '394a8073-d80f-4e52-ad0b-44e19c2573e5', '1', '2018-06-29 19:00:01', '', '2018-06-30 07:21:15', '2018-06-29 19:00:58', '3', '2018-06-30 07:21:29');
INSERT INTO `mep_warning` VALUES ('2825747', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018260008)已超出计划生产数量。产品编码:20140006设备编号:8#班别:白班产线:第一产线计划数量:581000超额数量:8', '8', 'c1b58d9a-db3b-4bab-929f-6091bae86f8a', '1', '2018-06-29 19:50:24', '', '2018-06-30 07:22:00', '2018-06-29 19:50:58', '2', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2827485', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018260004)已超出计划生产数量。产品编码:20140019设备编号:4#班别:夜班产线:第一产线计划数量:245000超额数量:8', '4', 'b117680a-efb7-4dc0-80f6-9630cfdd09d7', '1', '2018-06-29 20:01:15', '', '2018-06-30 07:21:30', '2018-06-29 20:01:58', '2', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2832891', '262153', '超工单生产预警提醒', '21', '设备编号(5#)超工单生产预警提醒', '工单(2018260007)已超出计划生产数量。产品编码:20140015设备编号:5#班别:夜班产线:第一产线计划数量:630000超额数量:16', '5', 'f234759d-9f8b-433d-9cbf-9ba575ecc3fb', '1', '2018-06-29 20:35:30', '', '2018-06-30 07:21:30', '2018-06-29 20:35:58', '2', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2836251', '262153', '超工单生产预警提醒', '21', '设备编号(3#)超工单生产预警提醒', '工单(2018260003)已超出计划生产数量。产品编码:20140001设备编号:3#班别:夜班产线:第一产线计划数量:259000超额数量:8', '3', '4e44abde-63c5-4b2d-b1a5-be803fb5c5db', '1', '2018-06-29 20:56:20', '', '2018-06-30 07:21:15', '2018-06-29 20:56:58', '2', '2018-06-30 07:21:29');
INSERT INTO `mep_warning` VALUES ('2839632', '262153', '超工单生产预警提醒', '21', '设备编号(7#)超工单生产预警提醒', '工单(2018260006)已超出计划生产数量。产品编码:20140009设备编号:7#班别:夜班产线:第一产线计划数量:245000超额数量:8', '7', '40ed6b5b-b445-430b-9eac-7c53ad9b1720', '1', '2018-06-29 21:17:55', '', '2018-06-30 07:21:45', '2018-06-29 21:17:58', '2', '2018-06-30 07:22:29');
INSERT INTO `mep_warning` VALUES ('2852592', '262153', '超工单生产预警提醒', '21', '设备编号(2#)超工单生产预警提醒', '工单(2018260002)已超出计划生产数量。产品编码:20140001设备编号:2#班别:夜班产线:第一产线计划数量:259000超额数量:8', '2', '8301dc3c-2b4e-40aa-8fa6-bca8e9837a35', '1', '2018-06-29 22:37:16', '', '2018-06-30 07:21:00', '2018-06-29 22:37:58', '2', '2018-06-30 07:21:29');
INSERT INTO `mep_warning` VALUES ('2861231', '262153', '超工单生产预警提醒', '21', '设备编号(18#)超工单生产预警提醒', '工单(2018260018)已超出计划生产数量。产品编码:20140013设备编号:18#班别:夜班产线:第二产线计划数量:945000超额数量:8', '18', '89d54003-06d2-4054-815f-610bc0b909ed', '1', '2018-06-29 23:30:01', '', '2018-06-30 07:23:45', '2018-06-29 23:30:59', '2', '2018-06-30 07:24:29');
INSERT INTO `mep_warning` VALUES ('2915351', '262153', '超工单生产预警提醒', '21', '设备编号(11#)超工单生产预警提醒', '工单(2018260011)已超出计划生产数量。产品编码:20140003设备编号:11#班别:夜班产线:第二产线计划数量:252000超额数量:8', '11', '71187be7-1b37-46ce-9650-312251c02f42', '1', '2018-06-30 05:01:14', '', '2018-06-30 07:22:30', '2018-06-30 05:01:29', '1', '2018-06-30 07:23:29');
INSERT INTO `mep_warning` VALUES ('2924921', '262153', '超工单生产预警提醒', '21', '设备编号(1#)超工单生产预警提醒', '工单(2018260020)已超出计划生产数量。产品编码:20140001设备编号:1#班别:夜班产线:第一产线计划数量:148000超额数量:8', '1', '4f060d74-e745-4f54-9e28-9c1830a443cc', '1', '2018-06-30 05:59:19', '', '2018-06-30 09:46:00', '2018-06-30 05:59:29', '2', '2018-06-30 09:46:29');
INSERT INTO `mep_warning` VALUES ('2938699', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', '8e54e3e8-bce9-4ed7-8ed4-bae87a873329', '1', '2018-06-30 07:22:12', '', null, '2018-06-30 07:22:29', '1', '2018-06-30 07:40:29');
INSERT INTO `mep_warning` VALUES ('2943375', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', 'a1746768-3749-49f4-a39a-080021a92349', '1', '2018-06-30 07:50:12', '', null, '2018-06-30 07:50:29', '1', '2018-06-30 07:55:29');
INSERT INTO `mep_warning` VALUES ('2947071', '131079', '模具报修预警提醒', '0', '设备编号(7#)模具报修预警提醒', '模具(M031-0152)故障，请及时维修。报修人:刘小博设备编号:7#班别:白班产线:第一产线', '7', '6d751555-ee03-4060-a612-7e9274f9cc65', '0', '2018-06-30 08:11:37', '', null, '2018-06-30 08:12:29', '4', '2018-07-01 08:12:29');
INSERT INTO `mep_warning` VALUES ('2969041', '262149', '工单未开始预警提醒', '20', '设备编号(12#)工单未开始预警提醒', '设备编号(12#)处于生产状态，但工单未开始。班别:白班产线:第二产线', '12', 'a8b998e7-a317-4def-8f0e-b4dc5381e629', '1', '2018-06-30 10:21:42', '', '2018-06-30 10:37:00', '2018-06-30 10:22:29', '1', '2018-06-30 10:37:29');
INSERT INTO `mep_warning` VALUES ('2984341', '262149', '工单未开始预警提醒', '20', '设备编号(1#)工单未开始预警提醒', '设备编号(1#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '1', '14fdfe7f-2491-409b-98a6-32bff0156b38', '1', '2018-06-30 11:51:43', '', null, '2018-06-30 11:52:29', '1', '2018-06-30 11:55:29');
INSERT INTO `mep_warning` VALUES ('2994430', '131079', '模具报修预警提醒', '0', '设备编号(8#)模具报修预警提醒', '模具(M031-0161)故障，请及时维修。报修人:刘小博设备编号:8#班别:白班产线:第一产线', '8', '6c206756-4f75-41cf-af61-be83a26a8b77', '0', '2018-06-30 12:51:12', '', null, '2018-06-30 12:51:29', '4', '2018-07-01 12:51:30');
INSERT INTO `mep_warning` VALUES ('3109498', '262153', '超工单生产预警提醒', '21', '设备编号(4#)超工单生产预警提醒', '工单(2018270004)已超出计划生产数量。产品编码:20140019设备编号:4#班别:白班产线:第一产线计划数量:52500超额数量:4', '4', '6ce78fcc-45da-4a24-8b8d-9e77e1a9fd7c', '1', '2018-07-01 16:34:41', '', '2018-07-02 08:07:00', '2018-07-01 16:35:29', '3', '2018-07-02 08:07:00');
INSERT INTO `mep_warning` VALUES ('3110137', '262153', '超工单生产预警提醒', '21', '设备编号(9#)超工单生产预警提醒', '工单(2018270009)已超出计划生产数量。产品编码:20140020设备编号:9#班别:夜班产线:第一产线计划数量:170000超额数量:16', '9', 'af47623f-f9b0-428a-b345-013e058db094', '1', '2018-07-02 03:14:06', '', '2018-07-02 08:52:30', '2018-07-02 03:15:00', '2', '2018-07-02 08:53:00');
INSERT INTO `mep_warning` VALUES ('3110179', '262153', '超工单生产预警提醒', '21', '设备编号(8#)超工单生产预警提醒', '工单(2018270008)已超出计划生产数量。产品编码:20140017设备编号:8#班别:夜班产线:第一产线计划数量:166000超额数量:16', '8', 'b949f926-ba71-4fd7-a9a2-daaba160688e', '1', '2018-07-02 03:35:36', '', '2018-07-02 09:05:15', '2018-07-02 03:36:00', '2', '2018-07-02 09:06:00');
INSERT INTO `mep_warning` VALUES ('3110209', '262153', '超工单生产预警提醒', '21', '设备编号(14#)超工单生产预警提醒', '工单(2018260014)已超出计划生产数量。产品编码:20140002设备编号:14#班别:夜班产线:第二产线计划数量:595000超额数量:8', '14', '90673d66-62e1-4d2b-8200-5cdcaa4078c2', '1', '2018-07-02 03:45:31', '', '2018-07-02 08:03:15', '2018-07-02 03:46:00', '2', '2018-07-02 08:04:00');
INSERT INTO `mep_warning` VALUES ('3111437', '262149', '工单未开始预警提醒', '20', '设备编号(9#)工单未开始预警提醒', '设备编号(9#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '9', 'c4f8a37f-2e28-404f-9a04-a3beffb1952b', '1', '2018-07-02 08:52:29', '', null, '2018-07-02 08:53:00', '0', '2018-07-02 08:53:00');
INSERT INTO `mep_warning` VALUES ('3111517', '262149', '工单未开始预警提醒', '20', '设备编号(8#)工单未开始预警提醒', '设备编号(8#)处于生产状态，但工单未开始。班别:白班产线:第一产线', '8', 'fbb2470e-33ec-45e0-81f7-8e140fa6bc76', '1', '2018-07-02 09:08:19', '', '2018-07-02 09:14:00', '2018-07-02 09:09:00', '1', '2018-07-02 09:14:00');
INSERT INTO `mep_warning` VALUES ('3114763', '131079', '模具报修预警提醒', '0', '设备编号(4#)模具报修预警提醒', '模具(M031-0151)故障，请及时维修。报修人:刘小博设备编号:4#班别:白班产线:第一产线', '4', 'a000e9df-69a8-437d-a88c-9c5e6dd93b8e', '0', '2018-07-02 18:09:07', '', null, '2018-07-02 18:10:00', '4', '2018-07-03 18:09:31');
INSERT INTO `mep_warning` VALUES ('3121476', '65538', '设备报修预警提醒', '0', '设备编号(5#)设备报修预警提醒', '设备(5#)故障，请及时维修。n报修人:王柱林班别:白班产线:第一产线', '5', '3fbe4245-a697-4575-ab57-06fc71c3501d', '0', '2018-07-03 10:08:01', '', null, '2018-07-03 10:09:00', '2', '2018-07-03 13:08:31');
INSERT INTO `mep_warning` VALUES ('3123436', '327681', '现在时间：2018-07-03 15:00:03,请进行巡检', '1', '现在时间：2018-07-03 15:00:03,请进行巡检', '巡检提醒：请及时对车间所有在产工单进行巡检,提醒时间：2018-07-03 15:00:03', '0', '6cabc0d2-bc30-4d85-813d-315f8f149e34', '0', '2018-07-03 15:00:03', '', null, '2018-07-03 15:01:01', '0', '2018-07-03 15:01:01');
INSERT INTO `mep_warning` VALUES ('3123460', '131079', '模具报修预警提醒', '0', '设备编号(1#)模具报修预警提醒', '模具(M031-0160)故障，请及时维修。报修人:刘小博设备编号:1#班别:白班产线:第一产线', '1', 'f562e8db-3b52-40b5-9d6d-823274797a5d', '0', '2018-07-03 17:03:32', '', null, '2018-07-03 17:04:01', '1', '2018-07-03 17:04:31');
INSERT INTO `mep_warning` VALUES ('3123497', '65538', '设备报修预警提醒', '0', '设备编号(5#)设备报修预警提醒', '设备(5#)故障，请及时维修。n报修人:刘小博班别:白班产线:第一产线', '5', '5e5a5bfd-19fc-478c-84f1-2fff0150d427', '0', '2018-07-03 17:40:34', '', null, '2018-07-03 17:41:01', '1', '2018-07-03 17:41:31');
INSERT INTO `mep_warning` VALUES ('3123535', '327681', '现在时间：2018-07-03 18:00:00,请进行巡检', '1', '现在时间：2018-07-03 18:00:00,请进行巡检', '巡检提醒：请及时对车间所有在产工单进行巡检,提醒时间：2018-07-03 18:00:00', '0', 'cf9e4a8d-de66-4984-9c9d-3fb9aa8b539a', '0', '2018-07-03 18:00:00', '', null, '2018-07-03 18:00:01', '0', '2018-07-03 18:00:01');
INSERT INTO `mep_warning` VALUES ('3123538', '327681', '现在时间：2018-07-03 18:00:00,请进行巡检', '1', '现在时间：2018-07-03 18:00:00,请进行巡检', '巡检提醒：请及时对车间所有在产工单进行巡检,提醒时间：2018-07-03 18:00:00', '0', 'dbdb3816-2a9b-48b2-a5f1-16d1ec3c0f3c', '0', '2018-07-03 18:00:00', '', null, '2018-07-03 18:01:01', '0', '2018-07-03 18:01:01');
