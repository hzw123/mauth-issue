/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : rc_recharge

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-24 16:23:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acct_info
-- ----------------------------
DROP TABLE IF EXISTS `acct_info`;
CREATE TABLE `acct_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `status_id` tinyint(3) DEFAULT NULL COMMENT '1 正常 2 冻结 9注销',
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `total_balance` bigint(20) DEFAULT NULL COMMENT '总余额',
  `last_trade_balance` bigint(20) DEFAULT NULL COMMENT '最后交易余额',
  `last_trade_date` datetime DEFAULT NULL COMMENT '最后交易时间',
  `verification_code` varchar(100) DEFAULT NULL COMMENT '校验码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='账户信息';

-- ----------------------------
-- Records of acct_info
-- ----------------------------
INSERT INTO `acct_info` VALUES ('1', '2018-03-19 22:04:52', '2018-03-19 23:00:51', '1', '2', '8772000', '8871800', '2018-03-19 23:00:51', '4c135f1c862838a94c7840ff62787e2f');

-- ----------------------------
-- Table structure for acct_log
-- ----------------------------
DROP TABLE IF EXISTS `acct_log`;
CREATE TABLE `acct_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `acct_info_id` bigint(20) DEFAULT NULL COMMENT '账户ID',
  `bill_type` tinyint(3) DEFAULT NULL COMMENT '交易单类型 1支付单 2充值单 3退款单 4提现单',
  `bill_status` tinyint(3) DEFAULT NULL COMMENT '账单状态：1 成功 2 异常',
  `trade_type` tinyint(3) DEFAULT NULL COMMENT '交易类型：1 入账 2 出账',
  `pay_serial_no` bigint(20) DEFAULT NULL COMMENT '支付交易订单号',
  `amount` int(11) DEFAULT NULL COMMENT '金额',
  `total_balance` bigint(20) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`),
  KEY `index_create_user_acct` (`gmt_create`,`user_info_id`,`acct_info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='账户日志';

-- ----------------------------
-- Records of acct_log
-- ----------------------------
INSERT INTO `acct_log` VALUES ('1', '2018-03-19 23:00:07', '2018-10-09 16:26:35', '2', '1', '1', '1', '1', '975748757164920833', '98000', '98000');

-- ----------------------------
-- Table structure for area_info
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_code` char(6) DEFAULT NULL COMMENT '省编号',
  `city_code` char(6) DEFAULT NULL COMMENT '市编号',
  `area_code` char(4) DEFAULT NULL COMMENT '区号',
  `province_name` varchar(10) DEFAULT NULL COMMENT '省名称',
  `city_name` varchar(20) DEFAULT NULL COMMENT '市名称',
  `area_type` tinyint(3) DEFAULT NULL COMMENT '分类：1.省 2 市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地区信息';

-- ----------------------------
-- Records of area_info
-- ----------------------------
INSERT INTO `area_info` VALUES ('1', '100000', null, null, '全国', null, '1');
INSERT INTO `area_info` VALUES ('2', '110000', null, null, '北京', null, '1');
INSERT INTO `area_info` VALUES ('3', '120000', null, null, '天津', null, '1');
INSERT INTO `area_info` VALUES ('4', '130000', null, null, '河北', null, '1');
INSERT INTO `area_info` VALUES ('5', '140000', null, null, '山西', null, '1');
INSERT INTO `area_info` VALUES ('6', '150000', null, null, '内蒙古', null, '1');
INSERT INTO `area_info` VALUES ('7', '210000', null, null, '辽宁', null, '1');
INSERT INTO `area_info` VALUES ('8', '220000', null, null, '吉林', null, '1');
INSERT INTO `area_info` VALUES ('9', '230000', null, null, '黑龙江', null, '1');
INSERT INTO `area_info` VALUES ('10', '310000', null, null, '上海', null, '1');
INSERT INTO `area_info` VALUES ('11', '320000', null, null, '江苏', null, '1');
INSERT INTO `area_info` VALUES ('12', '330000', null, null, '浙江', null, '1');
INSERT INTO `area_info` VALUES ('13', '340000', null, null, '安徽', null, '1');
INSERT INTO `area_info` VALUES ('14', '350000', null, null, '福建', null, '1');
INSERT INTO `area_info` VALUES ('15', '360000', null, null, '江西', null, '1');
INSERT INTO `area_info` VALUES ('16', '370000', null, null, '山东', null, '1');
INSERT INTO `area_info` VALUES ('17', '410000', null, null, '河南', null, '1');
INSERT INTO `area_info` VALUES ('18', '420000', null, null, '湖北', null, '1');
INSERT INTO `area_info` VALUES ('19', '430000', null, null, '湖南', null, '1');
INSERT INTO `area_info` VALUES ('20', '440000', null, null, '广东', null, '1');
INSERT INTO `area_info` VALUES ('21', '450000', null, null, '广西', null, '1');
INSERT INTO `area_info` VALUES ('22', '460000', null, null, '海南', null, '1');
INSERT INTO `area_info` VALUES ('23', '500000', null, null, '重庆', null, '1');
INSERT INTO `area_info` VALUES ('24', '510000', null, null, '四川', null, '1');
INSERT INTO `area_info` VALUES ('25', '520000', null, null, '贵州', null, '1');
INSERT INTO `area_info` VALUES ('26', '530000', null, null, '云南', null, '1');
INSERT INTO `area_info` VALUES ('27', '540000', null, null, '西藏', null, '1');
INSERT INTO `area_info` VALUES ('28', '610000', null, null, '陕西', null, '1');
INSERT INTO `area_info` VALUES ('29', '620000', null, null, '甘肃', null, '1');
INSERT INTO `area_info` VALUES ('30', '630000', null, null, '青海', null, '1');
INSERT INTO `area_info` VALUES ('31', '640000', null, null, '宁夏', null, '1');
INSERT INTO `area_info` VALUES ('32', '650000', null, null, '新疆', null, '1');
INSERT INTO `area_info` VALUES ('33', '110000', '110000', '010', '北京', '北京', '2');
INSERT INTO `area_info` VALUES ('34', '120000', '120000', '022', '天津', '天津', '2');
INSERT INTO `area_info` VALUES ('35', '130000', '130100', '0311', '河北', '石家庄', '2');
INSERT INTO `area_info` VALUES ('36', '130000', '130200', '0315', '河北', '唐山', '2');
INSERT INTO `area_info` VALUES ('37', '130000', '130300', '0335', '河北', '秦皇岛', '2');
INSERT INTO `area_info` VALUES ('38', '130000', '130400', '0310', '河北', '邯郸', '2');
INSERT INTO `area_info` VALUES ('39', '130000', '130500', '0319', '河北', '邢台', '2');
INSERT INTO `area_info` VALUES ('40', '130000', '130600', '0312', '河北', '保定', '2');
INSERT INTO `area_info` VALUES ('41', '130000', '130700', '0313', '河北', '张家口', '2');
INSERT INTO `area_info` VALUES ('42', '130000', '130800', '0314', '河北', '承德', '2');
INSERT INTO `area_info` VALUES ('43', '130000', '130900', '0317', '河北', '沧州', '2');
INSERT INTO `area_info` VALUES ('44', '130000', '131000', '0316', '河北', '廊坊', '2');
INSERT INTO `area_info` VALUES ('45', '130000', '131100', '0318', '河北', '衡水', '2');
INSERT INTO `area_info` VALUES ('46', '140000', '140100', '0351', '山西', '太原', '2');
INSERT INTO `area_info` VALUES ('47', '140000', '140200', '0352', '山西', '大同', '2');
INSERT INTO `area_info` VALUES ('48', '140000', '140300', '0353', '山西', '阳泉', '2');
INSERT INTO `area_info` VALUES ('49', '140000', '140400', '0355', '山西', '长治', '2');
INSERT INTO `area_info` VALUES ('50', '140000', '140500', '0356', '山西', '晋城', '2');
INSERT INTO `area_info` VALUES ('51', '140000', '140600', '0349', '山西', '朔州', '2');
INSERT INTO `area_info` VALUES ('52', '140000', '140700', '0354', '山西', '晋中', '2');
INSERT INTO `area_info` VALUES ('53', '140000', '140800', '0359', '山西', '运城', '2');
INSERT INTO `area_info` VALUES ('54', '140000', '140900', '0350', '山西', '忻州', '2');
INSERT INTO `area_info` VALUES ('55', '140000', '141000', '0357', '山西', '临汾', '2');
INSERT INTO `area_info` VALUES ('56', '140000', '141100', '0358', '山西', '吕梁', '2');
INSERT INTO `area_info` VALUES ('57', '150000', '150100', '0471', '内蒙古', '呼和浩特', '2');
INSERT INTO `area_info` VALUES ('58', '150000', '150200', '0472', '内蒙古', '包头', '2');
INSERT INTO `area_info` VALUES ('59', '150000', '150300', '0473', '内蒙古', '乌海', '2');
INSERT INTO `area_info` VALUES ('60', '150000', '150400', '0476', '内蒙古', '赤峰', '2');
INSERT INTO `area_info` VALUES ('61', '150000', '150500', '0475', '内蒙古', '通辽', '2');
INSERT INTO `area_info` VALUES ('62', '150000', '150600', '0477', '内蒙古', '鄂尔多斯', '2');
INSERT INTO `area_info` VALUES ('63', '150000', '150700', '0470', '内蒙古', '呼伦贝尔', '2');
INSERT INTO `area_info` VALUES ('64', '150000', '150800', '0478', '内蒙古', '巴彦淖尔', '2');
INSERT INTO `area_info` VALUES ('65', '150000', '150900', '0474', '内蒙古', '乌兰察布', '2');
INSERT INTO `area_info` VALUES ('66', '150000', '152200', '0482', '内蒙古', '兴安盟', '2');
INSERT INTO `area_info` VALUES ('67', '150000', '152500', '0479', '内蒙古', '锡林郭勒盟', '2');
INSERT INTO `area_info` VALUES ('68', '150000', '152900', '0483', '内蒙古', '阿拉善盟', '2');
INSERT INTO `area_info` VALUES ('69', '210000', '210100', '024', '辽宁', '沈阳', '2');
INSERT INTO `area_info` VALUES ('70', '210000', '210200', '0411', '辽宁', '大连', '2');
INSERT INTO `area_info` VALUES ('71', '210000', '210300', '0412', '辽宁', '鞍山', '2');
INSERT INTO `area_info` VALUES ('72', '210000', '210500', '0414', '辽宁', '本溪', '2');
INSERT INTO `area_info` VALUES ('73', '210000', '210600', '0415', '辽宁', '丹东', '2');
INSERT INTO `area_info` VALUES ('74', '210000', '210700', '0416', '辽宁', '锦州', '2');
INSERT INTO `area_info` VALUES ('75', '210000', '210800', '0417', '辽宁', '营口', '2');
INSERT INTO `area_info` VALUES ('76', '210000', '210900', '0418', '辽宁', '阜新', '2');
INSERT INTO `area_info` VALUES ('77', '210000', '211000', '0419', '辽宁', '辽阳', '2');
INSERT INTO `area_info` VALUES ('78', '210000', '211100', '0427', '辽宁', '盘锦', '2');
INSERT INTO `area_info` VALUES ('79', '210000', '211300', '0421', '辽宁', '朝阳', '2');
INSERT INTO `area_info` VALUES ('80', '210000', '211400', '0429', '辽宁', '葫芦岛', '2');
INSERT INTO `area_info` VALUES ('81', '220000', '220100', '0431', '吉林', '长春', '2');
INSERT INTO `area_info` VALUES ('82', '220000', '220200', '0432', '吉林', '吉林', '2');
INSERT INTO `area_info` VALUES ('83', '220000', '220300', '0434', '吉林', '四平', '2');
INSERT INTO `area_info` VALUES ('84', '220000', '220400', '0437', '吉林', '辽源', '2');
INSERT INTO `area_info` VALUES ('85', '220000', '220500', '0435', '吉林', '通化', '2');
INSERT INTO `area_info` VALUES ('86', '220000', '220600', '0439', '吉林', '白山', '2');
INSERT INTO `area_info` VALUES ('87', '220000', '220700', '0438', '吉林', '松原', '2');
INSERT INTO `area_info` VALUES ('88', '220000', '220800', '0436', '吉林', '白城', '2');
INSERT INTO `area_info` VALUES ('89', '220000', '222400', '0433', '吉林', '延边朝鲜族自治州', '2');
INSERT INTO `area_info` VALUES ('90', '230000', '230100', '0451', '黑龙江', '哈尔滨', '2');
INSERT INTO `area_info` VALUES ('91', '230000', '230200', '0452', '黑龙江', '齐齐哈尔', '2');
INSERT INTO `area_info` VALUES ('92', '230000', '230300', '0467', '黑龙江', '鸡西', '2');
INSERT INTO `area_info` VALUES ('93', '230000', '230400', '0468', '黑龙江', '鹤岗', '2');
INSERT INTO `area_info` VALUES ('94', '230000', '230500', '0469', '黑龙江', '双鸭山', '2');
INSERT INTO `area_info` VALUES ('95', '230000', '230600', '0459', '黑龙江', '大庆', '2');
INSERT INTO `area_info` VALUES ('96', '230000', '230700', '0458', '黑龙江', '伊春', '2');
INSERT INTO `area_info` VALUES ('97', '230000', '230800', '0454', '黑龙江', '佳木斯', '2');
INSERT INTO `area_info` VALUES ('98', '230000', '230900', '0464', '黑龙江', '七台河', '2');
INSERT INTO `area_info` VALUES ('99', '230000', '231000', '0453', '黑龙江', '牡丹江', '2');
INSERT INTO `area_info` VALUES ('100', '230000', '231100', '0456', '黑龙江', '黑河', '2');
INSERT INTO `area_info` VALUES ('101', '230000', '231200', '0455', '黑龙江', '绥化', '2');
INSERT INTO `area_info` VALUES ('102', '230000', '232700', '0457', '黑龙江', '大兴安岭地区', '2');
INSERT INTO `area_info` VALUES ('103', '310000', '310000', '021', '上海', '上海', '2');
INSERT INTO `area_info` VALUES ('104', '320000', '320100', '025', '江苏', '南京', '2');
INSERT INTO `area_info` VALUES ('105', '320000', '320200', '0510', '江苏', '无锡', '2');
INSERT INTO `area_info` VALUES ('106', '320000', '320300', '0516', '江苏', '徐州', '2');
INSERT INTO `area_info` VALUES ('107', '320000', '320400', '0519', '江苏', '常州', '2');
INSERT INTO `area_info` VALUES ('108', '320000', '320500', '0512', '江苏', '苏州', '2');
INSERT INTO `area_info` VALUES ('109', '320000', '320600', '0513', '江苏', '南通', '2');
INSERT INTO `area_info` VALUES ('110', '320000', '320700', '0518', '江苏', '连云港', '2');
INSERT INTO `area_info` VALUES ('111', '320000', '320800', '0517', '江苏', '淮安', '2');
INSERT INTO `area_info` VALUES ('112', '320000', '320900', '0515', '江苏', '盐城', '2');
INSERT INTO `area_info` VALUES ('113', '320000', '321000', '0514', '江苏', '扬州', '2');
INSERT INTO `area_info` VALUES ('114', '320000', '321100', '0511', '江苏', '镇江', '2');
INSERT INTO `area_info` VALUES ('115', '320000', '321200', '0523', '江苏', '泰州', '2');
INSERT INTO `area_info` VALUES ('116', '320000', '321300', '0527', '江苏', '宿迁', '2');
INSERT INTO `area_info` VALUES ('117', '330000', '330100', '0571', '浙江', '杭州', '2');
INSERT INTO `area_info` VALUES ('118', '330000', '330200', '0574', '浙江', '宁波', '2');
INSERT INTO `area_info` VALUES ('119', '330000', '330300', '0577', '浙江', '温州', '2');
INSERT INTO `area_info` VALUES ('120', '330000', '330400', '0573', '浙江', '嘉兴', '2');
INSERT INTO `area_info` VALUES ('121', '330000', '330500', '0572', '浙江', '湖州', '2');
INSERT INTO `area_info` VALUES ('122', '330000', '330600', '0575', '浙江', '绍兴', '2');
INSERT INTO `area_info` VALUES ('123', '330000', '330700', '0579', '浙江', '金华', '2');
INSERT INTO `area_info` VALUES ('124', '330000', '330800', '0570', '浙江', '衢州', '2');
INSERT INTO `area_info` VALUES ('125', '330000', '330900', '0580', '浙江', '舟山', '2');
INSERT INTO `area_info` VALUES ('126', '330000', '331000', '0576', '浙江', '台州', '2');
INSERT INTO `area_info` VALUES ('127', '330000', '331100', '0578', '浙江', '丽水', '2');
INSERT INTO `area_info` VALUES ('128', '340000', '340100', '0551', '安徽', '合肥', '2');
INSERT INTO `area_info` VALUES ('129', '340000', '340200', '0553', '安徽', '芜湖', '2');
INSERT INTO `area_info` VALUES ('130', '340000', '340300', '0552', '安徽', '蚌埠', '2');
INSERT INTO `area_info` VALUES ('131', '340000', '340400', '0554', '安徽', '淮南', '2');
INSERT INTO `area_info` VALUES ('132', '340000', '340500', '0555', '安徽', '马鞍山', '2');
INSERT INTO `area_info` VALUES ('133', '340000', '340600', '0561', '安徽', '淮北', '2');
INSERT INTO `area_info` VALUES ('134', '340000', '340700', '0562', '安徽', '铜陵', '2');
INSERT INTO `area_info` VALUES ('135', '340000', '340800', '0556', '安徽', '安庆', '2');
INSERT INTO `area_info` VALUES ('136', '340000', '341000', '0559', '安徽', '黄山', '2');
INSERT INTO `area_info` VALUES ('137', '340000', '341100', '0550', '安徽', '滁州', '2');
INSERT INTO `area_info` VALUES ('138', '340000', '341300', '0557', '安徽', '宿州', '2');
INSERT INTO `area_info` VALUES ('139', '340000', '341400', '0565', '安徽', '巢湖', '2');
INSERT INTO `area_info` VALUES ('140', '340000', '341500', '0564', '安徽', '六安', '2');
INSERT INTO `area_info` VALUES ('141', '340000', '341600', '0558', '安徽', '亳州', '2');
INSERT INTO `area_info` VALUES ('142', '340000', '341700', '0566', '安徽', '池州', '2');
INSERT INTO `area_info` VALUES ('143', '340000', '341800', '0563', '安徽', '宣城', '2');
INSERT INTO `area_info` VALUES ('144', '350000', '350100', '0591', '福建', '福州', '2');
INSERT INTO `area_info` VALUES ('145', '350000', '350200', '0592', '福建', '厦门', '2');
INSERT INTO `area_info` VALUES ('146', '350000', '350300', '0594', '福建', '莆田', '2');
INSERT INTO `area_info` VALUES ('147', '350000', '350400', '0598', '福建', '三明', '2');
INSERT INTO `area_info` VALUES ('148', '350000', '350500', '0595', '福建', '泉州', '2');
INSERT INTO `area_info` VALUES ('149', '350000', '350600', '0596', '福建', '漳州', '2');
INSERT INTO `area_info` VALUES ('150', '350000', '350700', '0599', '福建', '南平', '2');
INSERT INTO `area_info` VALUES ('151', '350000', '350800', '0597', '福建', '龙岩', '2');
INSERT INTO `area_info` VALUES ('152', '350000', '350900', '0593', '福建', '宁德', '2');
INSERT INTO `area_info` VALUES ('153', '360000', '360100', '0791', '江西', '南昌', '2');
INSERT INTO `area_info` VALUES ('154', '360000', '360200', '0798', '江西', '景德镇', '2');
INSERT INTO `area_info` VALUES ('155', '360000', '360300', '0799', '江西', '萍乡', '2');
INSERT INTO `area_info` VALUES ('156', '360000', '360400', '0792', '江西', '九江', '2');
INSERT INTO `area_info` VALUES ('157', '360000', '360500', '0790', '江西', '新余', '2');
INSERT INTO `area_info` VALUES ('158', '360000', '360600', '0701', '江西', '鹰潭', '2');
INSERT INTO `area_info` VALUES ('159', '360000', '360700', '0797', '江西', '赣州', '2');
INSERT INTO `area_info` VALUES ('160', '360000', '360800', '0796', '江西', '吉安', '2');
INSERT INTO `area_info` VALUES ('161', '360000', '360900', '0795', '江西', '宜春', '2');
INSERT INTO `area_info` VALUES ('162', '360000', '361000', '0794', '江西', '抚州', '2');
INSERT INTO `area_info` VALUES ('163', '360000', '361100', '0793', '江西', '上饶', '2');
INSERT INTO `area_info` VALUES ('164', '370000', '370100', '0531', '山东', '济南', '2');
INSERT INTO `area_info` VALUES ('165', '370000', '370200', '0532', '山东', '青岛', '2');
INSERT INTO `area_info` VALUES ('166', '370000', '370300', '0533', '山东', '淄博', '2');
INSERT INTO `area_info` VALUES ('167', '370000', '370400', '0632', '山东', '枣庄', '2');
INSERT INTO `area_info` VALUES ('168', '370000', '370500', '0546', '山东', '东营', '2');
INSERT INTO `area_info` VALUES ('169', '370000', '370600', '0535', '山东', '烟台', '2');
INSERT INTO `area_info` VALUES ('170', '370000', '370700', '0536', '山东', '潍坊', '2');
INSERT INTO `area_info` VALUES ('171', '370000', '370800', '0537', '山东', '济宁', '2');
INSERT INTO `area_info` VALUES ('172', '370000', '370900', '0538', '山东', '泰安', '2');
INSERT INTO `area_info` VALUES ('173', '370000', '371000', '0631', '山东', '威海', '2');
INSERT INTO `area_info` VALUES ('174', '370000', '371100', '0633', '山东', '日照', '2');
INSERT INTO `area_info` VALUES ('175', '370000', '371200', '0634', '山东', '莱芜', '2');
INSERT INTO `area_info` VALUES ('176', '370000', '371300', '0539', '山东', '临沂', '2');
INSERT INTO `area_info` VALUES ('177', '370000', '371400', '0534', '山东', '德州', '2');
INSERT INTO `area_info` VALUES ('178', '370000', '371500', '0635', '山东', '聊城', '2');
INSERT INTO `area_info` VALUES ('179', '370000', '371600', '0543', '山东', '滨州', '2');
INSERT INTO `area_info` VALUES ('180', '370000', '371700', '0530', '山东', '荷泽', '2');
INSERT INTO `area_info` VALUES ('181', '410000', '410100', '0371', '河南', '郑州', '2');
INSERT INTO `area_info` VALUES ('182', '410000', '410200', '0378', '河南', '开封', '2');
INSERT INTO `area_info` VALUES ('183', '410000', '410300', '0379', '河南', '洛阳', '2');
INSERT INTO `area_info` VALUES ('184', '410000', '410400', '0375', '河南', '平顶山', '2');
INSERT INTO `area_info` VALUES ('185', '410000', '410500', '0372', '河南', '安阳', '2');
INSERT INTO `area_info` VALUES ('186', '410000', '410600', '0392', '河南', '鹤壁', '2');
INSERT INTO `area_info` VALUES ('187', '410000', '410700', '0373', '河南', '新乡', '2');
INSERT INTO `area_info` VALUES ('188', '410000', '410800', '0391', '河南', '焦作', '2');
INSERT INTO `area_info` VALUES ('189', '410000', '410800', '0370', '河南', '商丘', '2');
INSERT INTO `area_info` VALUES ('190', '410000', '410900', '0393', '河南', '濮阳', '2');
INSERT INTO `area_info` VALUES ('191', '410000', '411000', '0374', '河南', '许昌', '2');
INSERT INTO `area_info` VALUES ('192', '410000', '411100', '0395', '河南', '漯河', '2');
INSERT INTO `area_info` VALUES ('193', '410000', '411200', '0398', '河南', '三门峡', '2');
INSERT INTO `area_info` VALUES ('194', '410000', '411300', '0377', '河南', '南阳', '2');
INSERT INTO `area_info` VALUES ('195', '410000', '411400', '0370', '河南', '商丘', '2');
INSERT INTO `area_info` VALUES ('196', '410000', '411500', '0376', '河南', '信阳', '2');
INSERT INTO `area_info` VALUES ('197', '410000', '411600', '0394', '河南', '周口', '2');
INSERT INTO `area_info` VALUES ('198', '410000', '411700', '0396', '河南', '驻马店', '2');
INSERT INTO `area_info` VALUES ('199', '420000', '420100', '027', '湖北', '武汉', '2');
INSERT INTO `area_info` VALUES ('200', '420000', '420200', '0714', '湖北', '黄石', '2');
INSERT INTO `area_info` VALUES ('201', '420000', '420300', '0719', '湖北', '十堰', '2');
INSERT INTO `area_info` VALUES ('202', '420000', '420500', '0717', '湖北', '宜昌', '2');
INSERT INTO `area_info` VALUES ('203', '420000', '420600', '0710', '湖北', '襄樊', '2');
INSERT INTO `area_info` VALUES ('204', '420000', '420700', '0711', '湖北', '鄂州', '2');
INSERT INTO `area_info` VALUES ('205', '420000', '420800', '0724', '湖北', '荆门', '2');
INSERT INTO `area_info` VALUES ('206', '420000', '420900', '0712', '湖北', '孝感', '2');
INSERT INTO `area_info` VALUES ('207', '420000', '421000', '0716', '湖北', '荆州', '2');
INSERT INTO `area_info` VALUES ('208', '420000', '421100', '0713', '湖北', '黄冈', '2');
INSERT INTO `area_info` VALUES ('209', '420000', '421200', '0715', '湖北', '咸宁', '2');
INSERT INTO `area_info` VALUES ('210', '420000', '421300', '0722', '湖北', '随州', '2');
INSERT INTO `area_info` VALUES ('211', '420000', '422800', '0718', '湖北', '恩施土家族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('212', '420000', '429000', '0728', '湖北', '仙桃', '2');
INSERT INTO `area_info` VALUES ('213', '430000', '430100', '0731', '湖南', '长沙', '2');
INSERT INTO `area_info` VALUES ('214', '430000', '430400', '0734', '湖南', '衡阳', '2');
INSERT INTO `area_info` VALUES ('215', '430000', '430500', '0739', '湖南', '邵阳', '2');
INSERT INTO `area_info` VALUES ('216', '430000', '430600', '0730', '湖南', '岳阳', '2');
INSERT INTO `area_info` VALUES ('217', '430000', '430700', '0736', '湖南', '常德', '2');
INSERT INTO `area_info` VALUES ('218', '430000', '430800', '0744', '湖南', '张家界', '2');
INSERT INTO `area_info` VALUES ('219', '430000', '430900', '0737', '湖南', '益阳', '2');
INSERT INTO `area_info` VALUES ('220', '430000', '431000', '0735', '湖南', '郴州', '2');
INSERT INTO `area_info` VALUES ('221', '430000', '431100', '0746', '湖南', '永州', '2');
INSERT INTO `area_info` VALUES ('222', '430000', '431200', '0745', '湖南', '怀化', '2');
INSERT INTO `area_info` VALUES ('223', '430000', '431300', '0738', '湖南', '娄底', '2');
INSERT INTO `area_info` VALUES ('224', '430000', '433100', '0743', '湖南', '湘西土家族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('225', '440000', '440100', '020', '广东', '广州', '2');
INSERT INTO `area_info` VALUES ('226', '440000', '440200', '0751', '广东', '韶关', '2');
INSERT INTO `area_info` VALUES ('227', '440000', '440300', '0755', '广东', '深圳', '2');
INSERT INTO `area_info` VALUES ('228', '440000', '440400', '0756', '广东', '珠海', '2');
INSERT INTO `area_info` VALUES ('229', '440000', '440500', '0754', '广东', '汕头', '2');
INSERT INTO `area_info` VALUES ('230', '440000', '440600', '0757', '广东', '佛山', '2');
INSERT INTO `area_info` VALUES ('231', '440000', '440700', '0750', '广东', '江门', '2');
INSERT INTO `area_info` VALUES ('232', '440000', '440800', '0759', '广东', '湛江', '2');
INSERT INTO `area_info` VALUES ('233', '440000', '440900', '0668', '广东', '茂名', '2');
INSERT INTO `area_info` VALUES ('234', '440000', '441200', '0758', '广东', '肇庆', '2');
INSERT INTO `area_info` VALUES ('235', '440000', '441300', '0752', '广东', '惠州', '2');
INSERT INTO `area_info` VALUES ('236', '440000', '441400', '0753', '广东', '梅州', '2');
INSERT INTO `area_info` VALUES ('237', '440000', '441500', '0660', '广东', '汕尾', '2');
INSERT INTO `area_info` VALUES ('238', '440000', '441600', '0762', '广东', '河源', '2');
INSERT INTO `area_info` VALUES ('239', '440000', '441700', '0662', '广东', '阳江', '2');
INSERT INTO `area_info` VALUES ('240', '440000', '441800', '0763', '广东', '清远', '2');
INSERT INTO `area_info` VALUES ('241', '440000', '441900', '0769', '广东', '东莞', '2');
INSERT INTO `area_info` VALUES ('242', '440000', '442000', '0760', '广东', '中山', '2');
INSERT INTO `area_info` VALUES ('243', '440000', '445100', '0768', '广东', '潮州', '2');
INSERT INTO `area_info` VALUES ('244', '440000', '445200', '0663', '广东', '揭阳', '2');
INSERT INTO `area_info` VALUES ('245', '440000', '445300', '0766', '广东', '云浮', '2');
INSERT INTO `area_info` VALUES ('246', '450000', '450100', '0771', '广西', '南宁', '2');
INSERT INTO `area_info` VALUES ('247', '450000', '450200', '0772', '广西', '柳州', '2');
INSERT INTO `area_info` VALUES ('248', '450000', '450300', '0773', '广西', '桂林', '2');
INSERT INTO `area_info` VALUES ('249', '450000', '450400', '0774', '广西', '梧州', '2');
INSERT INTO `area_info` VALUES ('250', '450000', '450500', '0779', '广西', '北海', '2');
INSERT INTO `area_info` VALUES ('251', '450000', '450600', '0770', '广西', '防城港', '2');
INSERT INTO `area_info` VALUES ('252', '450000', '450700', '0777', '广西', '钦州', '2');
INSERT INTO `area_info` VALUES ('253', '450000', '450900', '0775', '广西', '玉林', '2');
INSERT INTO `area_info` VALUES ('254', '450000', '451000', '0776', '广西', '百色', '2');
INSERT INTO `area_info` VALUES ('255', '450000', '451200', '0778', '广西', '河池', '2');
INSERT INTO `area_info` VALUES ('256', '460000', '460100', '0898', '海南', '海口', '2');
INSERT INTO `area_info` VALUES ('257', '500000', '500000', '023', '重庆', '重庆', '2');
INSERT INTO `area_info` VALUES ('258', '510000', '510100', '028', '四川', '成都', '2');
INSERT INTO `area_info` VALUES ('259', '510000', '510300', '0813', '四川', '自贡', '2');
INSERT INTO `area_info` VALUES ('260', '510000', '510300', '0830', '四川', '泸州', '2');
INSERT INTO `area_info` VALUES ('261', '510000', '510400', '0812', '四川', '攀枝花', '2');
INSERT INTO `area_info` VALUES ('262', '510000', '510500', '0830', '四川', '泸州', '2');
INSERT INTO `area_info` VALUES ('263', '510000', '510600', '0838', '四川', '德阳', '2');
INSERT INTO `area_info` VALUES ('264', '510000', '510700', '0816', '四川', '绵阳', '2');
INSERT INTO `area_info` VALUES ('265', '510000', '510800', '0839', '四川', '广元', '2');
INSERT INTO `area_info` VALUES ('266', '510000', '510900', '0825', '四川', '遂宁', '2');
INSERT INTO `area_info` VALUES ('267', '510000', '511000', '0832', '四川', '内江', '2');
INSERT INTO `area_info` VALUES ('268', '510000', '511100', '0833', '四川', '乐山', '2');
INSERT INTO `area_info` VALUES ('269', '510000', '511300', '0817', '四川', '南充', '2');
INSERT INTO `area_info` VALUES ('270', '510000', '511500', '0831', '四川', '宜宾', '2');
INSERT INTO `area_info` VALUES ('271', '510000', '511600', '0826', '四川', '广安', '2');
INSERT INTO `area_info` VALUES ('272', '510000', '511700', '0818', '四川', '达州', '2');
INSERT INTO `area_info` VALUES ('273', '510000', '511800', '0835', '四川', '雅安', '2');
INSERT INTO `area_info` VALUES ('274', '510000', '511900', '0827', '四川', '巴中', '2');
INSERT INTO `area_info` VALUES ('275', '510000', '513200', '0837', '四川', '阿坝藏族羌族自治州', '2');
INSERT INTO `area_info` VALUES ('276', '510000', '513300', '0836', '四川', '甘孜藏族自治州', '2');
INSERT INTO `area_info` VALUES ('277', '510000', '513400', '0834', '四川', '凉山彝族自治州', '2');
INSERT INTO `area_info` VALUES ('278', '520000', '520100', '0851', '贵州', '贵阳', '2');
INSERT INTO `area_info` VALUES ('279', '520000', '520200', '0858', '贵州', '六盘水', '2');
INSERT INTO `area_info` VALUES ('280', '520000', '520300', '0852', '贵州', '遵义', '2');
INSERT INTO `area_info` VALUES ('281', '520000', '520400', '0853', '贵州', '安顺', '2');
INSERT INTO `area_info` VALUES ('282', '520000', '522200', '0856', '贵州', '铜仁地区', '2');
INSERT INTO `area_info` VALUES ('283', '520000', '522300', '0859', '贵州', '黔西南布依族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('284', '520000', '522400', '0857', '贵州', '毕节地区', '2');
INSERT INTO `area_info` VALUES ('285', '520000', '522600', '0855', '贵州', '黔东南苗族侗族自治州', '2');
INSERT INTO `area_info` VALUES ('286', '520000', '522700', '0854', '贵州', '黔南布依族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('287', '530000', '530100', '0871', '云南', '昆明', '2');
INSERT INTO `area_info` VALUES ('288', '530000', '530300', '0874', '云南', '曲靖', '2');
INSERT INTO `area_info` VALUES ('289', '530000', '530400', '0877', '云南', '玉溪', '2');
INSERT INTO `area_info` VALUES ('290', '530000', '530500', '0875', '云南', '保山', '2');
INSERT INTO `area_info` VALUES ('291', '530000', '530600', '0870', '云南', '昭通', '2');
INSERT INTO `area_info` VALUES ('292', '530000', '530700', '0888', '云南', '丽江', '2');
INSERT INTO `area_info` VALUES ('293', '530000', '530800', '0879', '云南', '思茅', '2');
INSERT INTO `area_info` VALUES ('294', '530000', '530900', '0883', '云南', '临沧', '2');
INSERT INTO `area_info` VALUES ('295', '530000', '532300', '0878', '云南', '楚雄彝族自治州', '2');
INSERT INTO `area_info` VALUES ('296', '530000', '532500', '0873', '云南', '红河哈尼族彝族自治州', '2');
INSERT INTO `area_info` VALUES ('297', '530000', '532600', '0876', '云南', '文山壮族苗族自治州', '2');
INSERT INTO `area_info` VALUES ('298', '530000', '532800', '0691', '云南', '西双版纳傣族自治州', '2');
INSERT INTO `area_info` VALUES ('299', '530000', '532900', '0872', '云南', '大理白族自治州', '2');
INSERT INTO `area_info` VALUES ('300', '530000', '533100', '0692', '云南', '德宏傣族景颇族自治州', '2');
INSERT INTO `area_info` VALUES ('301', '530000', '533300', '0886', '云南', '怒江傈僳族自治州', '2');
INSERT INTO `area_info` VALUES ('302', '530000', '533400', '0887', '云南', '迪庆藏族自治州', '2');
INSERT INTO `area_info` VALUES ('303', '540000', '540100', '0891', '西藏', '拉萨', '2');
INSERT INTO `area_info` VALUES ('304', '540000', '542100', '0895', '西藏', '昌都地区', '2');
INSERT INTO `area_info` VALUES ('305', '540000', '542200', '0893', '西藏', '山南地区', '2');
INSERT INTO `area_info` VALUES ('306', '540000', '542300', '0892', '西藏', '日喀则地区', '2');
INSERT INTO `area_info` VALUES ('307', '540000', '542400', '0896', '西藏', '那曲地区', '2');
INSERT INTO `area_info` VALUES ('308', '540000', '542500', '0897', '西藏', '阿里地区', '2');
INSERT INTO `area_info` VALUES ('309', '540000', '542600', '0894', '西藏', '林芝地区', '2');
INSERT INTO `area_info` VALUES ('310', '610000', '610100', '029', '陕西', '西安', '2');
INSERT INTO `area_info` VALUES ('311', '610000', '610200', '0919', '陕西', '铜川', '2');
INSERT INTO `area_info` VALUES ('312', '610000', '610300', '0917', '陕西', '宝鸡', '2');
INSERT INTO `area_info` VALUES ('313', '610000', '610500', '0913', '陕西', '渭南', '2');
INSERT INTO `area_info` VALUES ('314', '610000', '610600', '0911', '陕西', '延安', '2');
INSERT INTO `area_info` VALUES ('315', '610000', '610700', '0916', '陕西', '汉中', '2');
INSERT INTO `area_info` VALUES ('316', '610000', '610800', '0912', '陕西', '榆林', '2');
INSERT INTO `area_info` VALUES ('317', '610000', '610900', '0915', '陕西', '安康', '2');
INSERT INTO `area_info` VALUES ('318', '610000', '611000', '0914', '陕西', '商洛', '2');
INSERT INTO `area_info` VALUES ('319', '620000', '620100', '0931', '甘肃', '兰州', '2');
INSERT INTO `area_info` VALUES ('320', '620000', '620200', '0937', '甘肃', '嘉峪关', '2');
INSERT INTO `area_info` VALUES ('321', '620000', '620400', '0943', '甘肃', '白银', '2');
INSERT INTO `area_info` VALUES ('322', '620000', '620500', '0938', '甘肃', '天水', '2');
INSERT INTO `area_info` VALUES ('323', '620000', '620600', '0935', '甘肃', '武威', '2');
INSERT INTO `area_info` VALUES ('324', '620000', '620700', '0936', '甘肃', '张掖', '2');
INSERT INTO `area_info` VALUES ('325', '620000', '620800', '0933', '甘肃', '平凉', '2');
INSERT INTO `area_info` VALUES ('326', '620000', '621000', '0934', '甘肃', '庆阳', '2');
INSERT INTO `area_info` VALUES ('327', '620000', '621100', '0932', '甘肃', '定西', '2');
INSERT INTO `area_info` VALUES ('328', '620000', '621200', '0939', '甘肃', '陇南', '2');
INSERT INTO `area_info` VALUES ('329', '620000', '622900', '0930', '甘肃', '临夏回族自治州', '2');
INSERT INTO `area_info` VALUES ('330', '620000', '623000', '0941', '甘肃', '甘南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('331', '630000', '630100', '0971', '青海', '西宁', '2');
INSERT INTO `area_info` VALUES ('332', '630000', '630230', '0973', '青海', '黄南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('333', '630000', '632100', '0972', '青海', '海东地区', '2');
INSERT INTO `area_info` VALUES ('334', '630000', '632200', '0970', '青海', '海北藏族自治州', '2');
INSERT INTO `area_info` VALUES ('335', '630000', '632500', '0974', '青海', '海南藏族自治州', '2');
INSERT INTO `area_info` VALUES ('336', '630000', '632600', '0975', '青海', '果洛藏族自治州', '2');
INSERT INTO `area_info` VALUES ('337', '630000', '632700', '0976', '青海', '玉树藏族自治州', '2');
INSERT INTO `area_info` VALUES ('338', '630000', '632800', '0979', '青海', '海西蒙古族藏族自治州', '2');
INSERT INTO `area_info` VALUES ('339', '630000', '632800', '0977', '青海', '海西蒙古族藏族自治州', '2');
INSERT INTO `area_info` VALUES ('340', '640000', '640100', '0951', '宁夏', '银川', '2');
INSERT INTO `area_info` VALUES ('341', '640000', '640200', '0952', '宁夏', '石嘴山', '2');
INSERT INTO `area_info` VALUES ('342', '640000', '640300', '0953', '宁夏', '吴忠', '2');
INSERT INTO `area_info` VALUES ('343', '640000', '640400', '0954', '宁夏', '固原', '2');
INSERT INTO `area_info` VALUES ('344', '640000', '640500', '0955', '宁夏', '中卫', '2');
INSERT INTO `area_info` VALUES ('345', '650000', '650100', '0991', '新疆', '乌鲁木齐', '2');
INSERT INTO `area_info` VALUES ('346', '650000', '650200', '0990', '新疆', '克拉玛依', '2');
INSERT INTO `area_info` VALUES ('347', '650000', '652100', '0995', '新疆', '吐鲁番地区', '2');
INSERT INTO `area_info` VALUES ('348', '650000', '652200', '0902', '新疆', '哈密地区', '2');
INSERT INTO `area_info` VALUES ('349', '650000', '652300', '0994', '新疆', '昌吉回族自治州', '2');
INSERT INTO `area_info` VALUES ('350', '650000', '652700', '0909', '新疆', '博尔塔拉蒙古自治州', '2');
INSERT INTO `area_info` VALUES ('351', '650000', '652800', '0996', '新疆', '巴音郭楞蒙古自治州', '2');
INSERT INTO `area_info` VALUES ('352', '650000', '652900', '0997', '新疆', '阿克苏地区', '2');
INSERT INTO `area_info` VALUES ('353', '650000', '653000', '0908', '新疆', '克孜勒苏柯尔克孜自治州', '2');
INSERT INTO `area_info` VALUES ('354', '650000', '653100', '0998', '新疆', '喀什地区', '2');
INSERT INTO `area_info` VALUES ('355', '650000', '653200', '0903', '新疆', '和田地区', '2');
INSERT INTO `area_info` VALUES ('356', '650000', '654000', '0999', '新疆', '伊犁哈萨克自治州', '2');
INSERT INTO `area_info` VALUES ('357', '650000', '654200', '0992', '新疆', '塔城地区', '2');
INSERT INTO `area_info` VALUES ('358', '650000', '654200', '0901', '新疆', '塔城地区', '2');
INSERT INTO `area_info` VALUES ('359', '650000', '654300', '0906', '新疆', '阿勒泰地区', '2');
INSERT INTO `area_info` VALUES ('360', '650000', '659000', '0993', '新疆', '石河子', '2');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `card_name` varchar(255) NOT NULL,
  `card_type` varchar(255) NOT NULL,
  `card_face_price` int(11) NOT NULL,
  `validity_time` int(11) NOT NULL,
  `card_status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='储值卡';

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '2018-09-28 15:28:25', '1000面额', '家乐福卡', '1000', '30', '2');
INSERT INTO `card` VALUES ('2', '2018-09-29 10:12:55', '5000面额', '家乐福卡', '5000', '50', '2');
INSERT INTO `card` VALUES ('3', '2018-10-08 13:14:41', '10000面额', '家乐福卡', '10000', '60', '2');

-- ----------------------------
-- Table structure for card_bills
-- ----------------------------
DROP TABLE IF EXISTS `card_bills`;
CREATE TABLE `card_bills` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `card_id` bigint(20) NOT NULL,
  `card_face_price` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `total` double NOT NULL,
  `order_card_id` bigint(20) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card_bills
-- ----------------------------

-- ----------------------------
-- Table structure for card_info
-- ----------------------------
DROP TABLE IF EXISTS `card_info`;
CREATE TABLE `card_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `card_face_price` int(10) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `card_type` varchar(255) NOT NULL,
  `order_card_id` bigint(20) NOT NULL,
  `order_card_pay_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `days` int(11) NOT NULL,
  `expire` bit(1) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `serial_no` varchar(255) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `auth_sign` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='储值卡信息表';

-- ----------------------------
-- Records of card_info
-- ----------------------------

-- ----------------------------
-- Table structure for card_log
-- ----------------------------
DROP TABLE IF EXISTS `card_log`;
CREATE TABLE `card_log` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `order_card_water_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='储值卡操作日志';

-- ----------------------------
-- Records of card_log
-- ----------------------------

-- ----------------------------
-- Table structure for cash_flow
-- ----------------------------
DROP TABLE IF EXISTS `cash_flow`;
CREATE TABLE `cash_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `card_face_price` int(11) DEFAULT NULL,
  `card_key` varchar(255) DEFAULT NULL,
  `auth_sign` varchar(255) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cash_flow
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `sales_area` varchar(9) DEFAULT NULL COMMENT '销售地区（省编号）',
  `face_price` varchar(20) DEFAULT NULL COMMENT '面值',
  `cost_price` int(11) DEFAULT NULL COMMENT '成本价格',
  `sales_price1` int(11) DEFAULT NULL COMMENT '销售价格',
  `sales_price2` int(11) DEFAULT NULL COMMENT '销售价格',
  `sales_price3` int(11) DEFAULT NULL COMMENT '销售价格',
  `carrier_type` tinyint(3) DEFAULT NULL COMMENT '运营商类型：1移动，2 电信，3联通',
  `item_category` tinyint(3) DEFAULT NULL COMMENT '商品类别（1充值，2兑换）',
  `item_type` tinyint(3) DEFAULT NULL COMMENT '商品类型：1流量，2话费，3兑换卡',
  `item_status` tinyint(3) DEFAULT NULL COMMENT '状态：1 初始，2正常，3下架',
  `item_no` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `item_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `item_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `flow_scope` tinyint(3) DEFAULT NULL COMMENT '使用范围：1本地，2全国',
  `flow_package_type` tinyint(3) DEFAULT NULL COMMENT '包体类型：1日包，2月包，3季度包，4年包',
  `flow_stream_type` tinyint(3) DEFAULT NULL COMMENT '通道类型：1全国，2分省',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品管理';

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for item_supply
-- ----------------------------
DROP TABLE IF EXISTS `item_supply`;
CREATE TABLE `item_supply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `item_status` tinyint(3) DEFAULT NULL COMMENT '状态：1 初始，2正常，3下架',
  `item_id` bigint(20) DEFAULT NULL COMMENT '商品iD',
  `item_no` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `item_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `supply_info_id` bigint(20) DEFAULT NULL COMMENT '供应商编号',
  `supply_code` varchar(50) DEFAULT NULL COMMENT '上游编码',
  `supply_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `priority` tinyint(3) DEFAULT NULL COMMENT '优先级',
  `loss_type` tinyint(3) DEFAULT NULL COMMENT '是否折损',
  `loss_time` int(11) DEFAULT NULL COMMENT '折损次数',
  `face_price` varchar(20) DEFAULT NULL COMMENT '商品面值',
  `cost_price` int(11) DEFAULT NULL COMMENT '成本价',
  `supply_product_code` varchar(50) DEFAULT NULL COMMENT '上游商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供应商商品管理';

-- ----------------------------
-- Records of item_supply
-- ----------------------------
INSERT INTO `item_supply` VALUES ('1', '2018-01-05 14:47:39', '2018-01-09 10:21:25', '2', '5', '11100000100111', '全国移动100MB流量全国月包全国', '2', 'longguochongzhi', '龙果充值', '10', null, null, '100MB', '2000', '');
INSERT INTO `item_supply` VALUES ('2', '2018-01-05 14:47:53', '2018-09-14 10:49:51', '2', '3', '21100000100000', '全国移动100元话费', '2', 'longguochongzhi', '龙果充值', '9', null, null, '100元', '99000', '');
INSERT INTO `item_supply` VALUES ('3', '2018-01-05 14:47:58', '2018-09-13 10:26:57', '3', '2', '31100000100000', '全国移动100元充值卡', '1', 'longguoduihuan', '龙果兑换', '10', null, null, '100元', '95000', '');
INSERT INTO `item_supply` VALUES ('4', '2018-01-09 15:16:17', '2018-09-13 10:26:51', '3', '6', '2110000050000', '全国移动50话费', '2', 'longguochongzhi', '龙果充值', '10', null, null, '50', '49000', '');

-- ----------------------------
-- Table structure for merchant_info
-- ----------------------------
DROP TABLE IF EXISTS `merchant_info`;
CREATE TABLE `merchant_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `status_id` tinyint(3) DEFAULT NULL COMMENT '1 正常 2 冻结 9 注销',
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `acct_info_id` bigint(20) DEFAULT NULL COMMENT '账户ID',
  `app_id` varchar(50) DEFAULT NULL COMMENT 'APPID',
  `price_level` tinyint(3) DEFAULT NULL COMMENT '价格级别(对应商品的销售价位)',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `compay_name` varchar(255) DEFAULT NULL COMMENT '公司全称',
  `charging_limit` int(11) DEFAULT NULL COMMENT '充值限制',
  `warning_balance` int(11) DEFAULT NULL COMMENT '余额阈值',
  `deposit_balance` int(1) DEFAULT NULL COMMENT '保证金',
  `api_verify_type` tinyint(3) DEFAULT NULL COMMENT '接口校验类型：1秘钥，2秘钥+白名单',
  `app_seceret` varchar(255) DEFAULT NULL COMMENT 'AppSeceret',
  `white_list` varchar(511) DEFAULT NULL COMMENT '白名单',
  `tx_verify_type` tinyint(3) DEFAULT NULL COMMENT '提现校验类型：1支付密码，2支付密码+动态码',
  `pay_pwd` char(32) DEFAULT NULL COMMENT '支付密码',
  `verify_code_key` varchar(255) DEFAULT NULL COMMENT '动态秘钥',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='下游代理商';

-- ----------------------------
-- Records of merchant_info
-- ----------------------------
INSERT INTO `merchant_info` VALUES ('1', '2018-03-19 22:04:52', '2018-03-19 22:04:52', '1', '2', '1', 'RCbc0f20736d264c96b525d62e97428aba', '1', '测试用户', '测试公司', '500', '1000', '2000', '1', '6bdef1a23d5c466cadf51dccd651f7ba', '', '1', '123456', '');

-- ----------------------------
-- Table structure for mobile_info
-- ----------------------------
DROP TABLE IF EXISTS `mobile_info`;
CREATE TABLE `mobile_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile_prefix` char(255) DEFAULT NULL,
  `province_code` char(255) DEFAULT NULL,
  `city_code` char(255) DEFAULT NULL,
  `area_code` char(255) DEFAULT NULL,
  `province_name` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `carrier_name` varchar(255) DEFAULT NULL,
  `carrier_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='移动信息';

-- ----------------------------
-- Records of mobile_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_card
-- ----------------------------
DROP TABLE IF EXISTS `order_card`;
CREATE TABLE `order_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_card_name` varchar(255) NOT NULL,
  `order_no` bigint(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `total_price` double(10,2) NOT NULL,
  `user_pay_account` varchar(255) NOT NULL,
  `pay_type` varchar(255) NOT NULL COMMENT '支付方式',
  `status` varchar(255) NOT NULL COMMENT '状态',
  `days` int(11) NOT NULL COMMENT '有效天数',
  `order_type` varchar(255) NOT NULL,
  `load_password` varchar(255) DEFAULT NULL,
  `auth_sign` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='储值卡订单表';

-- ----------------------------
-- Records of order_card
-- ----------------------------

-- ----------------------------
-- Table structure for order_card_pay
-- ----------------------------
DROP TABLE IF EXISTS `order_card_pay`;
CREATE TABLE `order_card_pay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `serial_no` varchar(255) DEFAULT NULL,
  `serial_type` varchar(255) DEFAULT NULL,
  `order_card_id` bigint(20) NOT NULL,
  `serial_amount` double NOT NULL,
  `status` int(11) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='储值卡订单支付';

-- ----------------------------
-- Records of order_card_pay
-- ----------------------------

-- ----------------------------
-- Table structure for order_supply
-- ----------------------------
DROP TABLE IF EXISTS `order_supply`;
CREATE TABLE `order_supply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `order_status` tinyint(255) NOT NULL,
  `order_trade_no` bigint(20) NOT NULL,
  `item_supply_id` bigint(20) NOT NULL,
  `user_info_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `item_category` tinyint(4) NOT NULL,
  `item_type` tinyint(4) NOT NULL,
  `item_no` varchar(255) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `mobile` char(255) NOT NULL,
  `supply_info_id` bigint(20) DEFAULT NULL,
  `supply_code` varchar(255) DEFAULT NULL,
  `supply_name` varchar(255) DEFAULT NULL,
  `supply_serial_no` bigint(20) DEFAULT NULL,
  `supply_face_price` decimal(10,2) DEFAULT NULL,
  `supply_cost_price` int(11) DEFAULT NULL,
  `supply_actual_cost` int(11) DEFAULT NULL,
  `supply_desc` varchar(255) DEFAULT NULL,
  `repeat_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商订单';

-- ----------------------------
-- Records of order_supply
-- ----------------------------

-- ----------------------------
-- Table structure for order_trade
-- ----------------------------
DROP TABLE IF EXISTS `order_trade`;
CREATE TABLE `order_trade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `order_status` tinyint(4) NOT NULL,
  `user_info_id` bigint(20) NOT NULL,
  `acct_info_id` bigint(20) NOT NULL,
  `item_supply_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `item_category` tinyint(4) NOT NULL,
  `item_type` tinyint(255) NOT NULL,
  `item_no` varchar(255) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `sales_price` int(11) NOT NULL,
  `face_price` varchar(255) NOT NULL,
  `cost_price` int(11) NOT NULL,
  `actual_cost` int(11) NOT NULL,
  `mobile` char(255) NOT NULL,
  `channel` tinyint(4) NOT NULL,
  `trade_no` bigint(20) NOT NULL,
  `pay_serial_no` bigint(20) NOT NULL,
  `order_no` varchar(255) NOT NULL,
  `order_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `carrier_type` tinyint(255) NOT NULL,
  `supply_desc` varchar(255) NOT NULL,
  `supply_count` int(11) NOT NULL,
  `supply_index` int(11) NOT NULL,
  `notify_url` varchar(255) NOT NULL,
  `flow_mode` tinyint(255) DEFAULT NULL,
  `flow_scope` tinyint(4) DEFAULT NULL,
  `flow_package_type` tinyint(255) DEFAULT NULL,
  `flow_stream_type` tinyint(4) DEFAULT NULL,
  `card_no` varchar(255) DEFAULT NULL,
  `card_pwd` varchar(255) DEFAULT NULL,
  `repeat_type` tinyint(4) DEFAULT NULL,
  `supply_serial_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易订单';

-- ----------------------------
-- Records of order_trade
-- ----------------------------

-- ----------------------------
-- Table structure for order_trade_pay
-- ----------------------------
DROP TABLE IF EXISTS `order_trade_pay`;
CREATE TABLE `order_trade_pay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `pay_status` tinyint(3) DEFAULT NULL COMMENT '1创建 2支付成功 3支付失败 9异常',
  `pay_serial_no` bigint(20) DEFAULT NULL COMMENT '交易订单ID',
  `order_trade_no` bigint(20) DEFAULT NULL COMMENT '平台交易号',
  `user_info_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `acct_info_id` bigint(20) DEFAULT NULL COMMENT '账户ID',
  `acct_log_id` bigint(20) DEFAULT NULL COMMENT '账户日志ID',
  `item_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `item_no` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `sales_price` int(11) DEFAULT NULL COMMENT '销售价',
  `pay_type` tinyint(3) DEFAULT NULL COMMENT '支付类型：1余额',
  `trade_type` tinyint(3) DEFAULT NULL COMMENT '交易类型：1 入账 2 出账',
  `error_msg` varchar(255) DEFAULT NULL COMMENT '错误信息',
  PRIMARY KEY (`id`),
  KEY `index_bizorder` (`pay_serial_no`) USING BTREE,
  KEY `index_create_user_acct` (`gmt_create`,`user_info_id`,`acct_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='支付订单';

-- ----------------------------
-- Records of order_trade_pay
-- ----------------------------

-- ----------------------------
-- Table structure for schema_version
-- ----------------------------
DROP TABLE IF EXISTS `schema_version`;
CREATE TABLE `schema_version` (
  `version` varchar(20) NOT NULL,
  `version_rank` int(11) NOT NULL,
  `installed_rank` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `script` varchar(255) NOT NULL,
  `checksum` int(11) NOT NULL,
  `installed_by` varchar(255) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` bit(1) NOT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目版本';

-- ----------------------------
-- Records of schema_version
-- ----------------------------

-- ----------------------------
-- Table structure for supply_info
-- ----------------------------
DROP TABLE IF EXISTS `supply_info`;
CREATE TABLE `supply_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `status_id` tinyint(3) DEFAULT NULL COMMENT '1 正常 2 冻结 9 注销',
  `supply_category` tinyint(3) DEFAULT NULL COMMENT '供货商类别（1充值，2兑换）',
  `supply_code` varchar(50) DEFAULT NULL COMMENT '上游编码',
  `supply_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `compay_name` varchar(255) DEFAULT NULL COMMENT '公司名',
  `para_request_url` varchar(255) DEFAULT NULL COMMENT '参数：请求URl',
  `para_order_url` varchar(255) DEFAULT NULL COMMENT '参数：订单查询url',
  `para_balance_url` varchar(255) DEFAULT NULL COMMENT '参数：余额查询URL',
  `para_user_id` varchar(255) DEFAULT NULL COMMENT '参数：用户ID',
  `para_key` varchar(255) DEFAULT NULL COMMENT '参数：key',
  `para_seceret` varchar(255) DEFAULT NULL COMMENT '参数：seceret',
  `para_ext1` varchar(255) DEFAULT NULL COMMENT '扩展参数1',
  `para_ext2` varchar(255) DEFAULT NULL COMMENT '扩展参数2',
  `para_ext3` varchar(255) DEFAULT NULL COMMENT '扩展参数3',
  `para_ext4` varchar(255) DEFAULT NULL COMMENT '扩展参数4',
  `para_ext5` varchar(255) DEFAULT NULL COMMENT '扩展参数5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='上游供货商';

-- ----------------------------
-- Records of supply_info
-- ----------------------------
INSERT INTO `supply_info` VALUES ('1', null, null, '1', '2', 'longguoduihuan', '龙果兑换', '广州市领课网络科技有限公司', 'http://recharge.roncoo.com/exchange', 'http://recharge.roncoo.com/exchange/order', 'http://recharge.roncoo.com/balance/query', '88', '88', '88', '88', '88', '88', '88', '88');
INSERT INTO `supply_info` VALUES ('2', null, null, '1', '1', 'longguochongzhi', '龙果充值', '广州市领课网络科技有限公司', 'http://recharge.roncoo.com/recharge', 'http://recharge.roncoo.com/recharge/order', 'http://recharge.roncoo.com/balance/query', '99', '99', '99', '99', '99', '99', '99', '99');
INSERT INTO `supply_info` VALUES ('4', null, null, '1', '2', 'roncooduihuan', 'roncoo兑换', '龙果学院', 'http://www.roncoo.com/exchange', 'http://www.roncoo.com/exchange/order', 'http://www.roncoo.com/balance/query', '66', '66', '66', '66', '66', '66', '66', '66');

-- ----------------------------
-- Table structure for sys_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_login`;
CREATE TABLE `sys_log_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_info_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `login_name` varchar(30) NOT NULL DEFAULT '' COMMENT '登录名',
  `login_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '登录IP',
  `last_login_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '上次登录IP',
  `last_login_time` datetime NOT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户登陆日志';

-- ----------------------------
-- Records of sys_log_login
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_opt
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_opt`;
CREATE TABLE `sys_log_opt` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_info_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `login_name` varchar(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `action` tinyint(3) NOT NULL DEFAULT '0' COMMENT '动作',
  `remark` varchar(1023) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户操作日志表';

-- ----------------------------
-- Records of sys_log_opt
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `platform_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '平台ID',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) NOT NULL COMMENT '菜单路径',
  `target_name` varchar(50) DEFAULT NULL COMMENT '目标名称',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单信息';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '2017-12-27 21:59:23', '2017-12-27 21:59:23', '999', '1', '1', '0', '系统管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('2', '2017-12-27 22:00:08', '2017-12-27 22:00:08', '997', '1', '1', '0', '商品管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('3', '2017-12-27 22:06:02', '2017-12-27 22:06:02', '100', '1', '1', '0', '订单管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('4', '2017-12-27 22:06:51', '2017-12-27 22:06:51', '1', '1', '1', '1', '用户管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('5', '2017-12-27 22:07:06', '2017-12-27 22:07:06', '10', '1', '1', '4', '用户管理', '/admin/sysUserInfo/list', 'admin-sysUserInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('6', '2017-12-27 22:09:16', '2017-12-27 22:09:16', '21', '1', '1', '5', '添加', '/admin/sysUserInfo/add', 'admin-sysMenuRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('7', '2017-12-27 22:10:11', '2017-12-27 22:10:11', '1', '1', '1', '6', '保存', '/admin/sysUserInfo/save', '', '', '');
INSERT INTO `sys_menu` VALUES ('8', '2017-12-27 22:10:32', '2017-12-27 22:10:32', '20', '1', '1', '5', '修改', '/admin/sysUserInfo/edit', 'admin-sysMenuRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('9', '2017-12-27 22:12:26', '2017-12-27 22:12:26', '1', '1', '1', '8', '更新', '/admin/sysUserInfo/update', '', '', '');
INSERT INTO `sys_menu` VALUES ('10', '2017-12-27 22:12:44', '2017-12-27 22:12:44', '18', '1', '1', '5', '删除', '/admin/sysUserInfo/delete', 'admin-sysMenuRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('12', '2017-12-27 22:20:56', '2017-12-27 22:20:56', '2', '1', '1', '1', '权限管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('13', '2017-12-27 22:21:36', '2017-12-27 22:21:36', '10', '1', '1', '12', '角色管理', '/admin/sysRole/list', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('14', '2017-12-27 22:22:22', '2017-12-27 22:22:22', '8', '1', '1', '12', '菜单管理', '/admin/sysMenu/list', 'admin-sysMenu', 'list', '');
INSERT INTO `sys_menu` VALUES ('15', '2017-12-27 22:22:46', '2017-12-27 22:22:46', '1', '1', '1', '12', '平台管理', '/admin/sysPlatform/list', 'admin-sysPlatform', 'list', '');
INSERT INTO `sys_menu` VALUES ('21', '2017-12-27 22:34:54', '2017-12-27 22:34:54', '1', '1', '1', '2', '商品管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('26', '2017-12-27 22:40:45', '2017-12-27 22:40:45', '1', '1', '1', '3', '订单管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('58', '2017-12-27 23:02:30', '2017-12-27 23:02:30', '21', '1', '1', '13', '添加', '/admin/sysRole/add', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('59', '2017-12-27 23:02:45', '2017-12-27 23:02:45', '1', '1', '1', '58', '保存', '/admin/sysRole/save', '', '', '');
INSERT INTO `sys_menu` VALUES ('60', '2017-12-27 23:03:14', '2017-12-27 23:03:14', '20', '1', '1', '13', '修改', '/admin/sysRole/edit', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('61', '2017-12-27 23:03:26', '2017-12-27 23:03:26', '1', '1', '1', '60', '更新', '/admin/sysRole/update', '', '', '');
INSERT INTO `sys_menu` VALUES ('62', '2017-12-27 23:03:48', '2017-12-27 23:03:48', '18', '1', '1', '13', '删除', '/admin/sysRole/delete', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('63', '2017-12-28 09:47:25', '2017-12-28 09:47:25', '21', '1', '1', '14', '添加', '/admin/sysMenu/add', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('64', '2017-12-28 09:47:39', '2017-12-28 09:47:39', '1', '1', '1', '63', '保存', '/admin/sysMenu/save', '', '', '');
INSERT INTO `sys_menu` VALUES ('65', '2017-12-28 09:47:51', '2017-12-28 09:47:51', '20', '1', '1', '14', '修改', '/admin/sysMenu/edit', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('66', '2017-12-28 09:48:05', '2017-12-28 09:48:05', '1', '1', '1', '65', '更新', '/admin/sysMenu/update', '', '', '');
INSERT INTO `sys_menu` VALUES ('67', '2017-12-28 09:48:49', '2017-12-28 09:48:49', '21', '1', '1', '15', '添加', '/admin/sysPlatform/add', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('68', '2017-12-28 09:48:58', '2017-12-28 09:48:58', '1', '1', '1', '67', '保存', '/admin/sysPlatform/save', '', '', '');
INSERT INTO `sys_menu` VALUES ('69', '2017-12-28 09:49:15', '2017-12-28 09:49:15', '20', '1', '1', '15', '修改', '/admin/sysPlatform/edit', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('70', '2017-12-28 09:49:25', '2017-12-28 09:49:25', '1', '1', '1', '69', '更新', '/admin/sysPlatform/update', '', '', '');
INSERT INTO `sys_menu` VALUES ('71', '2017-12-28 09:49:50', '2017-12-28 09:49:50', '19', '1', '1', '14', '删除', '/admin/sysMenu/delete', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('72', '2017-12-28 09:50:09', '2017-12-28 09:50:09', '19', '1', '1', '15', '删除', '/admin/sysPlatform/delete', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('80', '2018-09-12 16:27:07', '2018-09-12 16:27:07', '3', '1', '1', '1', '日志管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('81', '2018-09-12 16:27:39', '2018-09-12 16:27:39', '999', '1', '1', '80', '登录日志管理', '/admin/sysLogLogin/list', 'admin-sysLogLogin', 'list', '998');
INSERT INTO `sys_menu` VALUES ('82', '2018-09-12 16:28:19', '2018-09-12 16:28:19', '998', '1', '1', '80', '用户操作日志管理', '/admin/sysLogOpt/list', 'admin-sysLogOpt', 'list', '');
INSERT INTO `sys_menu` VALUES ('83', '2018-09-12 17:17:19', '2018-09-12 17:17:19', '3', '1', '1', '80', '账户日志管理', '/admin/acctLog/list', 'admin-acctLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('84', '2018-09-12 17:56:03', '2018-09-12 17:56:03', '998', '1', '1', '0', '账户管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('85', '2018-09-12 17:56:43', '2018-09-12 17:56:43', '1', '1', '1', '84', '账户管理', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('86', '2018-09-12 17:56:57', '2018-09-12 17:56:57', '1', '1', '1', '85', '账户管理', '/admin/acctInfo/list', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('88', '2018-09-13 14:26:45', '2018-09-13 14:26:45', '99', '1', '1', '21', '储值卡类型', '/admin/card/list', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('89', '2018-09-14 12:57:29', '2018-09-14 12:57:29', '999', '1', '1', '26', '储值卡订单', '/admin/orderCard/list', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('90', '2017-12-28 09:47:25', '2017-12-28 09:47:25', '17', '1', '1', '14', '添加sub', '/admin/sysMenu/save/sub', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('91', '2018-09-17 16:07:16', '2018-09-17 16:07:16', '19', '1', '1', '13', '设置菜单', '/admin/sysMenuRole/set', 'admin-sysMenuRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('92', '2017-12-27 22:09:16', '2017-12-27 22:09:16', '19', '1', '1', '5', '设置角色', '/admin/sysRoleUser/set', 'admin-sysRoleUser', 'list', '');
INSERT INTO `sys_menu` VALUES ('93', '2018-09-17 16:17:00', '2018-09-17 16:17:00', '1', '1', '1', '88', '查看', '/admin/card/view', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('94', '2018-09-17 16:17:16', '2018-09-17 16:17:16', '3', '1', '1', '88', '编辑', '/admin/card/edit', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('95', '2018-09-17 16:17:44', '2018-09-17 16:17:44', '2', '1', '1', '88', '删除', '/admin/card/delete', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('96', '2018-09-17 16:19:14', '2018-09-17 16:19:14', '4', '1', '1', '88', '添加', '/admin/card/add', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('101', '2018-09-17 16:28:51', '2018-09-17 16:28:51', '18', '1', '1', '86', '查看', '/admin/acctInfo/view', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('102', '2018-09-17 16:29:24', '2018-09-17 16:29:24', '7', '1', '1', '89', '查看', '/admin/orderCard/view', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('103', '2018-09-17 16:29:38', '2018-09-17 16:29:38', '9', '1', '1', '89', '修改', '/admin/orderCard/edit', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('104', '2018-09-17 16:30:02', '2018-09-17 16:30:02', '10', '1', '1', '89', '添加', '/admin/orderCard/add', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('105', '2018-09-17 16:30:14', '2018-09-17 16:30:14', '8', '1', '1', '89', '删除', '/admin/orderCard/delete', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('106', '2018-09-17 16:31:13', '2018-09-17 16:31:13', '1', '1', '1', '81', '查看', '/admin/sysLogLogin/view', 'admin-sysLogLogin', 'list', '');
INSERT INTO `sys_menu` VALUES ('107', '2018-09-17 16:31:32', '2018-09-17 16:31:32', '2', '1', '1', '81', '删除', '/admin/sysLogLogin/delete', 'admin-sysLogLogin', 'list', '');
INSERT INTO `sys_menu` VALUES ('108', '2018-09-17 16:31:46', '2018-09-17 16:31:46', '3', '1', '1', '81', '修改', '/admin/sysLogLogin/set', 'admin-sysLogLogin', 'list', '');
INSERT INTO `sys_menu` VALUES ('109', '2018-09-17 17:26:11', '2018-09-17 17:26:11', '98', '1', '1', '21', '储值卡信息', '/admin/cardInfo/list', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('110', '2018-09-17 17:28:18', '2018-09-17 17:28:18', '10', '1', '1', '109', '添加', '/admin/cardInfo/add', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('111', '2018-09-17 17:28:37', '2018-09-17 17:28:37', '7', '1', '1', '109', '查看', '/admin/cardInfo/view', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('112', '2018-09-17 17:29:26', '2018-09-17 17:29:26', '8', '1', '1', '109', '删除', '/admin/cardInfo/delete', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('113', '2018-09-17 17:29:40', '2018-09-17 17:29:40', '9', '1', '1', '109', '修改', '/admin/cardInfo/edit', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('114', '2018-09-17 17:32:59', '2018-09-17 17:32:59', '1', '1', '1', '108', '更新', '/admin/sysLogLogin/update', 'admin-sysLogLogin', 'list', '');
INSERT INTO `sys_menu` VALUES ('115', '2018-09-17 17:34:06', '2018-09-17 17:34:06', '11', '1', '1', '110', '保存', '/admin/cardInfo/save', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('116', '2018-09-17 17:34:28', '2018-09-17 17:34:28', '1', '1', '1', '113', '更新', '/admin/cardInfo/uodate', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('117', '2018-09-17 17:34:53', '2018-09-17 17:34:53', '1', '1', '1', '96', '保存', '/admin/card/save', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('118', '2018-09-17 17:35:20', '2018-09-17 17:35:20', '1', '1', '1', '94', '更新', '/admin/card/update', 'admin-card', 'list', '');
INSERT INTO `sys_menu` VALUES ('119', '2018-09-18 10:06:34', '2018-09-18 10:06:34', '21', '1', '1', '86', '添加', '/admin/acctInfo/add', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('120', '2018-09-18 10:06:57', '2018-09-18 10:06:57', '1', '1', '1', '119', '保存', '/admin/acctInfo/save', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('121', '2018-09-18 10:07:20', '2018-09-18 10:07:20', '20', '1', '1', '86', '修改', '/admin/acctInfo/edit', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('122', '2018-09-18 10:07:36', '2018-09-18 10:07:36', '1', '1', '1', '121', '更新', '/admin/acctInfo/update', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('123', '2018-09-18 10:07:52', '2018-09-18 10:07:52', '19', '1', '1', '86', '删除', '/admin/acctInfo/delete', 'admin-acctInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('124', '2018-09-19 15:34:10', '2018-09-19 15:34:10', '4', '1', '1', '80', '储值卡操作日志', '/admin/cardLog/list', 'admin-cardLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('125', '2018-09-19 16:27:44', '2018-09-19 16:27:44', '998', '1', '1', '26', '储值卡支付', '/admin/orderCardPay/list', 'admin-orderCardPay', 'list', '储值卡支付');
INSERT INTO `sys_menu` VALUES ('126', '2018-09-19 16:28:18', '2018-09-19 16:28:18', '4', '1', '1', '125', '添加', '/admin/orderCardPay/add', 'admin-orderCardPay', 'list', '');
INSERT INTO `sys_menu` VALUES ('127', '2018-09-19 16:28:34', '2018-09-19 16:28:34', '1', '1', '1', '126', '保存', '/admin/orderCardPay/save', 'admin-orderCardPay', 'list', '');
INSERT INTO `sys_menu` VALUES ('128', '2018-09-19 16:28:58', '2018-09-19 16:28:58', '1', '1', '1', '125', '查看', '/admin/orderCardPay/view', 'admin-orderCardPay', 'list', '储值卡支付');
INSERT INTO `sys_menu` VALUES ('129', '2018-09-19 16:29:18', '2018-09-19 16:29:18', '2', '1', '1', '125', '删除', '/admin/orderCardPay/delete', 'admin-orderCardPay', 'list', '储值卡支付');
INSERT INTO `sys_menu` VALUES ('130', '2018-09-19 16:29:51', '2018-09-19 16:29:51', '3', '1', '1', '125', '编辑', '/admin/orderCardPay/edit', 'admin-orderCardPay', 'list', '');
INSERT INTO `sys_menu` VALUES ('131', '2018-09-19 16:30:09', '2018-09-19 16:30:09', '1', '1', '1', '130', '更新', '/admin/orderCardPay/update', 'admin-orderCardPay', 'list', '');
INSERT INTO `sys_menu` VALUES ('132', '2018-09-19 16:31:15', '2018-09-19 16:31:15', '4', '1', '1', '104', '保存', '/admin/orderCard/save', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('133', '2018-09-19 16:31:49', '2018-09-19 16:31:49', '2', '1', '1', '103', '更新', '/admin/orderCard/update', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('134', '2018-09-19 16:33:39', '2018-09-19 16:33:39', '1', '1', '1', '82', '查看', '/admin/sysLogOpt/view', 'admin-sysLogOpt', 'list', '');
INSERT INTO `sys_menu` VALUES ('135', '2018-09-19 16:34:10', '2018-09-19 16:34:10', '2', '1', '1', '82', '删除', '/admin/sysLogOpt/delete', 'admin-sysLogOpt', 'list', '');
INSERT INTO `sys_menu` VALUES ('136', '2018-09-19 16:34:27', '2018-09-19 16:34:27', '3', '1', '1', '82', '编辑', '/admin/sysLogOpt/edit', 'admin-sysLogOpt', 'list', '');
INSERT INTO `sys_menu` VALUES ('137', '2018-09-19 16:34:55', '2018-09-19 16:34:55', '1', '1', '1', '136', '更新', '/admin/sysLogOpt/update', 'admin-sysLogOpt', 'list', '');
INSERT INTO `sys_menu` VALUES ('138', '2018-09-19 17:08:50', '2018-09-19 17:08:50', '17', '1', '1', '5', '查看', '/admin/sysUserInfo/view', 'admin-sysUserInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('139', '2018-09-19 17:12:01', '2018-09-19 17:12:01', '17', '1', '1', '13', '查看', '/admin/sysRole/view', 'admin-sysRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('140', '2018-09-19 17:13:23', '2018-09-19 17:13:23', '18', '1', '1', '14', '查看', '/admin/sysMenu/view', 'admin-sysMenu', 'list', '');
INSERT INTO `sys_menu` VALUES ('141', '2018-09-19 17:14:44', '2018-09-19 17:14:44', '18', '1', '1', '15', '查看', '/admin/sysPlatform/view', 'admin-sysPlatform', 'list', '');
INSERT INTO `sys_menu` VALUES ('142', '2018-10-09 16:09:40', '2018-10-09 16:09:40', '6', '1', '1', '89', '支付', '/admin/orderCard/pay', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('143', '2018-10-09 16:10:34', '2018-10-09 16:10:34', '5', '1', '1', '89', '下载', '/admin/orderCard/download', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('144', '2018-10-09 16:13:27', '2018-10-09 16:13:27', '1', '1', '1', '109', '激活', '/admin/cardInfo/active', 'admin-cardInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('145', '2018-10-09 16:21:45', '2018-10-09 16:21:45', '10', '1', '1', '124', '查看', '/admin/cardLog/view', 'admin-cardLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('146', '2018-10-09 16:22:53', '2018-10-09 16:22:53', '1', '1', '1', '83', '查看', '/admin/acctLog/view', 'admin-acctLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('147', '2018-10-09 16:23:23', '2018-10-09 16:23:23', '2', '1', '1', '83', '删除', '/admin/acctLog/delete', 'admin-acctLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('148', '2018-10-09 16:24:13', '2018-10-09 16:24:13', '3', '1', '1', '83', '编辑', '/admin/acctLog/edit', 'admin-acctLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('149', '2018-10-09 16:24:48', '2018-10-09 16:24:48', '1', '1', '1', '148', '更新', '/admin/acctLog/update', 'admin-acctLog', 'list', '');
INSERT INTO `sys_menu` VALUES ('152', '2018-10-09 16:44:17', '2018-10-09 16:44:17', '1', '1', '1', '91', '保存', '/admin/sysMenuRole/save', 'admin-sysMenuRole', 'list', '');
INSERT INTO `sys_menu` VALUES ('153', '2018-10-09 16:55:33', '2018-10-09 16:55:33', '16', '1', '1', '5', '修改密码', '/admin/sysUserInfo/password', 'admin-sysRoleUser', 'list', '');
INSERT INTO `sys_menu` VALUES ('154', '2018-10-09 16:55:59', '2018-10-09 16:55:59', '15', '1', '1', '5', '我的信息', '/admin/sysUserInfo/info', 'admin-sysUserInfo', 'list', '');
INSERT INTO `sys_menu` VALUES ('155', '2018-10-09 17:38:22', '2018-10-09 17:38:22', '1', '1', '1', '92', '保存', '/admin/sysRoleUser/save', 'admin-sysRoleUser', 'list', '');
INSERT INTO `sys_menu` VALUES ('156', '2018-10-12 11:50:25', '2018-10-12 11:50:25', '4', '1', '1', '89', '查看密码', '/admin/orderCard/pwd', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('157', '2018-10-17 12:11:46', '2018-10-17 12:11:46', '99', '1', '1', '0', '统计管理', '', '', '', null);
INSERT INTO `sys_menu` VALUES ('158', '2018-10-17 12:12:19', '2018-10-17 12:12:19', '99', '1', '1', '157', '财务统计', '', '', '', '');
INSERT INTO `sys_menu` VALUES ('159', '2018-10-17 12:13:17', '2018-10-17 12:13:17', '99', '1', '1', '158', '财务统计管理', '/admin/statistics/list', 'admin-statistics', '', '');
INSERT INTO `sys_menu` VALUES ('160', '2018-10-22 14:42:09', '2018-10-22 14:42:09', '11', '1', '1', '89', '发送短信', '/admin/orderCard/sendSms', 'admin-orderCard', 'list', '');
INSERT INTO `sys_menu` VALUES ('161', '2018-10-22 14:42:32', '2018-10-22 14:42:32', '1', '1', '1', '160', '发送', '/api/sendSms/rote', 'admin-send', 'list', '');
INSERT INTO `sys_menu` VALUES ('162', '2018-10-23 14:14:44', '2018-10-23 14:14:44', '97', '1', '1', '21', '储值卡激活流水', '/admin/cashFlow/list', 'admin-cashFlow', 'list', '');
INSERT INTO `sys_menu` VALUES ('163', '2018-10-23 14:15:41', '2018-10-23 14:15:41', '1', '1', '1', '162', '查看', '/admin/cashFlow/view', 'admin-cashFlow', 'list', '');

-- ----------------------------
-- Table structure for sys_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `platform_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '平台ID',
  `menu_id` bigint(20) unsigned NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1994 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单角色关联表';

-- ----------------------------
-- Records of sys_menu_role
-- ----------------------------
INSERT INTO `sys_menu_role` VALUES ('1733', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '1', '2');
INSERT INTO `sys_menu_role` VALUES ('1734', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '80', '2');
INSERT INTO `sys_menu_role` VALUES ('1735', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '81', '2');
INSERT INTO `sys_menu_role` VALUES ('1736', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '106', '2');
INSERT INTO `sys_menu_role` VALUES ('1737', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '82', '2');
INSERT INTO `sys_menu_role` VALUES ('1738', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '134', '2');
INSERT INTO `sys_menu_role` VALUES ('1739', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '124', '2');
INSERT INTO `sys_menu_role` VALUES ('1740', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '145', '2');
INSERT INTO `sys_menu_role` VALUES ('1741', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '83', '2');
INSERT INTO `sys_menu_role` VALUES ('1742', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '146', '2');
INSERT INTO `sys_menu_role` VALUES ('1743', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '4', '2');
INSERT INTO `sys_menu_role` VALUES ('1744', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '5', '2');
INSERT INTO `sys_menu_role` VALUES ('1745', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '8', '2');
INSERT INTO `sys_menu_role` VALUES ('1746', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '9', '2');
INSERT INTO `sys_menu_role` VALUES ('1747', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '138', '2');
INSERT INTO `sys_menu_role` VALUES ('1748', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '153', '2');
INSERT INTO `sys_menu_role` VALUES ('1749', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '154', '2');
INSERT INTO `sys_menu_role` VALUES ('1750', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '84', '2');
INSERT INTO `sys_menu_role` VALUES ('1751', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '85', '2');
INSERT INTO `sys_menu_role` VALUES ('1752', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '86', '2');
INSERT INTO `sys_menu_role` VALUES ('1753', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '121', '2');
INSERT INTO `sys_menu_role` VALUES ('1754', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '122', '2');
INSERT INTO `sys_menu_role` VALUES ('1755', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '101', '2');
INSERT INTO `sys_menu_role` VALUES ('1756', '2018-10-23 14:17:33', '2018-10-23 14:17:33', '1', '1', '1', '2', '2');
INSERT INTO `sys_menu_role` VALUES ('1757', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '21', '2');
INSERT INTO `sys_menu_role` VALUES ('1758', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '88', '2');
INSERT INTO `sys_menu_role` VALUES ('1759', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '93', '2');
INSERT INTO `sys_menu_role` VALUES ('1760', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '3', '2');
INSERT INTO `sys_menu_role` VALUES ('1761', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '26', '2');
INSERT INTO `sys_menu_role` VALUES ('1762', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '89', '2');
INSERT INTO `sys_menu_role` VALUES ('1763', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '160', '2');
INSERT INTO `sys_menu_role` VALUES ('1764', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '161', '2');
INSERT INTO `sys_menu_role` VALUES ('1765', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '104', '2');
INSERT INTO `sys_menu_role` VALUES ('1766', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '132', '2');
INSERT INTO `sys_menu_role` VALUES ('1767', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '103', '2');
INSERT INTO `sys_menu_role` VALUES ('1768', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '133', '2');
INSERT INTO `sys_menu_role` VALUES ('1769', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '102', '2');
INSERT INTO `sys_menu_role` VALUES ('1770', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '142', '2');
INSERT INTO `sys_menu_role` VALUES ('1771', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '143', '2');
INSERT INTO `sys_menu_role` VALUES ('1772', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '156', '2');
INSERT INTO `sys_menu_role` VALUES ('1773', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '125', '2');
INSERT INTO `sys_menu_role` VALUES ('1774', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '128', '2');
INSERT INTO `sys_menu_role` VALUES ('1775', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '157', '2');
INSERT INTO `sys_menu_role` VALUES ('1776', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '158', '2');
INSERT INTO `sys_menu_role` VALUES ('1777', '2018-10-23 14:17:34', '2018-10-23 14:17:34', '1', '1', '1', '159', '2');
INSERT INTO `sys_menu_role` VALUES ('1886', '2018-10-23 14:18:29', '2018-10-23 14:18:29', '1', '1', '1', '1', '1');
INSERT INTO `sys_menu_role` VALUES ('1887', '2018-10-23 14:18:29', '2018-10-23 14:18:29', '1', '1', '1', '80', '1');
INSERT INTO `sys_menu_role` VALUES ('1888', '2018-10-23 14:18:29', '2018-10-23 14:18:29', '1', '1', '1', '81', '1');
INSERT INTO `sys_menu_role` VALUES ('1889', '2018-10-23 14:18:29', '2018-10-23 14:18:29', '1', '1', '1', '108', '1');
INSERT INTO `sys_menu_role` VALUES ('1890', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '114', '1');
INSERT INTO `sys_menu_role` VALUES ('1891', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '107', '1');
INSERT INTO `sys_menu_role` VALUES ('1892', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '106', '1');
INSERT INTO `sys_menu_role` VALUES ('1893', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '82', '1');
INSERT INTO `sys_menu_role` VALUES ('1894', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '136', '1');
INSERT INTO `sys_menu_role` VALUES ('1895', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '137', '1');
INSERT INTO `sys_menu_role` VALUES ('1896', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '135', '1');
INSERT INTO `sys_menu_role` VALUES ('1897', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '134', '1');
INSERT INTO `sys_menu_role` VALUES ('1898', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '124', '1');
INSERT INTO `sys_menu_role` VALUES ('1899', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '145', '1');
INSERT INTO `sys_menu_role` VALUES ('1900', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '83', '1');
INSERT INTO `sys_menu_role` VALUES ('1901', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '148', '1');
INSERT INTO `sys_menu_role` VALUES ('1902', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '149', '1');
INSERT INTO `sys_menu_role` VALUES ('1903', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '147', '1');
INSERT INTO `sys_menu_role` VALUES ('1904', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '146', '1');
INSERT INTO `sys_menu_role` VALUES ('1905', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '12', '1');
INSERT INTO `sys_menu_role` VALUES ('1906', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '13', '1');
INSERT INTO `sys_menu_role` VALUES ('1907', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '58', '1');
INSERT INTO `sys_menu_role` VALUES ('1908', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '59', '1');
INSERT INTO `sys_menu_role` VALUES ('1909', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '60', '1');
INSERT INTO `sys_menu_role` VALUES ('1910', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '61', '1');
INSERT INTO `sys_menu_role` VALUES ('1911', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '91', '1');
INSERT INTO `sys_menu_role` VALUES ('1912', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '152', '1');
INSERT INTO `sys_menu_role` VALUES ('1913', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '62', '1');
INSERT INTO `sys_menu_role` VALUES ('1914', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '139', '1');
INSERT INTO `sys_menu_role` VALUES ('1915', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '14', '1');
INSERT INTO `sys_menu_role` VALUES ('1916', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '63', '1');
INSERT INTO `sys_menu_role` VALUES ('1917', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '64', '1');
INSERT INTO `sys_menu_role` VALUES ('1918', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '65', '1');
INSERT INTO `sys_menu_role` VALUES ('1919', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '66', '1');
INSERT INTO `sys_menu_role` VALUES ('1920', '2018-10-23 14:18:30', '2018-10-23 14:18:30', '1', '1', '1', '71', '1');
INSERT INTO `sys_menu_role` VALUES ('1921', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '140', '1');
INSERT INTO `sys_menu_role` VALUES ('1922', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '90', '1');
INSERT INTO `sys_menu_role` VALUES ('1923', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '15', '1');
INSERT INTO `sys_menu_role` VALUES ('1924', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '67', '1');
INSERT INTO `sys_menu_role` VALUES ('1925', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '68', '1');
INSERT INTO `sys_menu_role` VALUES ('1926', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '69', '1');
INSERT INTO `sys_menu_role` VALUES ('1927', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '70', '1');
INSERT INTO `sys_menu_role` VALUES ('1928', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '72', '1');
INSERT INTO `sys_menu_role` VALUES ('1929', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '141', '1');
INSERT INTO `sys_menu_role` VALUES ('1930', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '4', '1');
INSERT INTO `sys_menu_role` VALUES ('1931', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '5', '1');
INSERT INTO `sys_menu_role` VALUES ('1932', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '6', '1');
INSERT INTO `sys_menu_role` VALUES ('1933', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '7', '1');
INSERT INTO `sys_menu_role` VALUES ('1934', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '8', '1');
INSERT INTO `sys_menu_role` VALUES ('1935', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '9', '1');
INSERT INTO `sys_menu_role` VALUES ('1936', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '92', '1');
INSERT INTO `sys_menu_role` VALUES ('1937', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '155', '1');
INSERT INTO `sys_menu_role` VALUES ('1938', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '10', '1');
INSERT INTO `sys_menu_role` VALUES ('1939', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '138', '1');
INSERT INTO `sys_menu_role` VALUES ('1940', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '153', '1');
INSERT INTO `sys_menu_role` VALUES ('1941', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '154', '1');
INSERT INTO `sys_menu_role` VALUES ('1942', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '84', '1');
INSERT INTO `sys_menu_role` VALUES ('1943', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '85', '1');
INSERT INTO `sys_menu_role` VALUES ('1944', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '86', '1');
INSERT INTO `sys_menu_role` VALUES ('1945', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '119', '1');
INSERT INTO `sys_menu_role` VALUES ('1946', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '120', '1');
INSERT INTO `sys_menu_role` VALUES ('1947', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '121', '1');
INSERT INTO `sys_menu_role` VALUES ('1948', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '122', '1');
INSERT INTO `sys_menu_role` VALUES ('1949', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '123', '1');
INSERT INTO `sys_menu_role` VALUES ('1950', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '101', '1');
INSERT INTO `sys_menu_role` VALUES ('1951', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '2', '1');
INSERT INTO `sys_menu_role` VALUES ('1952', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '21', '1');
INSERT INTO `sys_menu_role` VALUES ('1953', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '88', '1');
INSERT INTO `sys_menu_role` VALUES ('1954', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '96', '1');
INSERT INTO `sys_menu_role` VALUES ('1955', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '117', '1');
INSERT INTO `sys_menu_role` VALUES ('1956', '2018-10-23 14:18:31', '2018-10-23 14:18:31', '1', '1', '1', '94', '1');
INSERT INTO `sys_menu_role` VALUES ('1957', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '118', '1');
INSERT INTO `sys_menu_role` VALUES ('1958', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '95', '1');
INSERT INTO `sys_menu_role` VALUES ('1959', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '93', '1');
INSERT INTO `sys_menu_role` VALUES ('1960', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '109', '1');
INSERT INTO `sys_menu_role` VALUES ('1961', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '110', '1');
INSERT INTO `sys_menu_role` VALUES ('1962', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '115', '1');
INSERT INTO `sys_menu_role` VALUES ('1963', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '113', '1');
INSERT INTO `sys_menu_role` VALUES ('1964', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '116', '1');
INSERT INTO `sys_menu_role` VALUES ('1965', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '112', '1');
INSERT INTO `sys_menu_role` VALUES ('1966', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '111', '1');
INSERT INTO `sys_menu_role` VALUES ('1967', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '144', '1');
INSERT INTO `sys_menu_role` VALUES ('1968', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '162', '1');
INSERT INTO `sys_menu_role` VALUES ('1969', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '163', '1');
INSERT INTO `sys_menu_role` VALUES ('1970', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '3', '1');
INSERT INTO `sys_menu_role` VALUES ('1971', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '26', '1');
INSERT INTO `sys_menu_role` VALUES ('1972', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '89', '1');
INSERT INTO `sys_menu_role` VALUES ('1973', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '160', '1');
INSERT INTO `sys_menu_role` VALUES ('1974', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '161', '1');
INSERT INTO `sys_menu_role` VALUES ('1975', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '104', '1');
INSERT INTO `sys_menu_role` VALUES ('1976', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '132', '1');
INSERT INTO `sys_menu_role` VALUES ('1977', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '103', '1');
INSERT INTO `sys_menu_role` VALUES ('1978', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '133', '1');
INSERT INTO `sys_menu_role` VALUES ('1979', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '105', '1');
INSERT INTO `sys_menu_role` VALUES ('1980', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '102', '1');
INSERT INTO `sys_menu_role` VALUES ('1981', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '142', '1');
INSERT INTO `sys_menu_role` VALUES ('1982', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '143', '1');
INSERT INTO `sys_menu_role` VALUES ('1983', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '156', '1');
INSERT INTO `sys_menu_role` VALUES ('1984', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '125', '1');
INSERT INTO `sys_menu_role` VALUES ('1985', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '126', '1');
INSERT INTO `sys_menu_role` VALUES ('1986', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '127', '1');
INSERT INTO `sys_menu_role` VALUES ('1987', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '130', '1');
INSERT INTO `sys_menu_role` VALUES ('1988', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '131', '1');
INSERT INTO `sys_menu_role` VALUES ('1989', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '129', '1');
INSERT INTO `sys_menu_role` VALUES ('1990', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '128', '1');
INSERT INTO `sys_menu_role` VALUES ('1991', '2018-10-23 14:18:32', '2018-10-23 14:18:32', '1', '1', '1', '157', '1');
INSERT INTO `sys_menu_role` VALUES ('1992', '2018-10-23 14:18:33', '2018-10-23 14:18:33', '1', '1', '1', '158', '1');
INSERT INTO `sys_menu_role` VALUES ('1993', '2018-10-23 14:18:33', '2018-10-23 14:18:33', '1', '1', '1', '159', '1');

-- ----------------------------
-- Table structure for sys_platform
-- ----------------------------
DROP TABLE IF EXISTS `sys_platform`;
CREATE TABLE `sys_platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `platform_app_id` char(34) NOT NULL DEFAULT '' COMMENT '平台APPID',
  `platform_app_secret` char(64) NOT NULL DEFAULT '' COMMENT '平台APPSECRET',
  `platform_name` varchar(255) NOT NULL DEFAULT '' COMMENT '平台名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_id` (`platform_app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='授权客户端表';

-- ----------------------------
-- Records of sys_platform
-- ----------------------------
INSERT INTO `sys_platform` VALUES ('1', '2017-12-27 21:31:16', '2017-12-27 21:31:16', '1', '1', 'RC9560472864454143847a270bd4436532', '86aa6ab90d5b4379afaeb905fc1c7019', '储值卡管理平台', '我的平台');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `platform_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '平台ID',
  `role_name` varchar(50) NOT NULL COMMENT '名称',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色信息';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '2017-12-28 09:58:04', '2017-12-28 09:58:04', '1', '1', '1', '超级管理员', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '2018-03-19 21:56:44', '2018-03-19 21:56:44', '1', '1', '1', '运营人员', '运营人员');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `platform_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '平台ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `user_info_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色用户关联表';

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '2017-12-28 12:28:51', '2017-12-28 12:28:51', '1', '1', '1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2018-03-19 21:59:05', '2018-03-19 21:59:05', '1', '1', '1', '2', '2');
INSERT INTO `sys_role_user` VALUES ('3', '2018-09-13 10:12:32', '2018-09-13 10:12:32', '1', '1', '1', '1', '3');
INSERT INTO `sys_role_user` VALUES ('4', '2018-09-18 12:39:31', '2018-09-18 12:39:31', '1', '1', '1', '1', '4');
INSERT INTO `sys_role_user` VALUES ('5', '2018-09-18 12:55:03', '2018-09-18 12:55:03', '1', '1', '1', '1', '5');
INSERT INTO `sys_role_user` VALUES ('6', '2018-09-18 13:00:04', '2018-09-18 13:00:04', '1', '1', '1', '1', '6');
INSERT INTO `sys_role_user` VALUES ('7', '2018-09-18 14:23:42', '2018-09-18 14:23:42', '1', '1', '1', '1', '7');
INSERT INTO `sys_role_user` VALUES ('8', '2018-10-09 16:47:23', '2018-10-09 16:47:23', '1', '1', '1', '2', '8');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `status_id` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1 正常 2 冻结 9 注销',
  `user_type` tinyint(3) DEFAULT NULL COMMENT '1 内部 2 下游',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` char(11) DEFAULT NULL COMMENT '手机',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `salt` char(32) DEFAULT NULL COMMENT '密码盐',
  `pwd` char(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台用户信息';

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1', '2017-12-27 10:14:14', '2017-12-27 10:14:14', '1', '1', '1', 'fengyw', 'feng', 'xxx@qq.com', '18333333333', '测试地址', '65f410e663fc45dd9fa1b08ea92e0348', 'adad4f342d123fa4a1fac6b2c6b08eb1');
INSERT INTO `sys_user_info` VALUES ('6', '2018-09-18 12:59:56', '2018-09-18 12:59:56', '1', '1', '1', 'admin', 'hzw', '1127835288@qq.com', '15154876251', '11', 'cb2987d0cf2949d78fb0bb921b072ac9', '189c800e16db20a679c23311be2778e4');
INSERT INTO `sys_user_info` VALUES ('8', '2018-10-09 16:35:20', '2018-10-09 16:35:20', '1', '1', '1', 'root', 'root', '1127835288@qq.com', '15123658497', '', '9e27eacbb79442218bc10800eeae5f83', '75e0eb98f0d6a0e7c78df11bfcf9fc2c');
