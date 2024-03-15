/*
Navicat MySQL Data Transfer

Source Server         : sqlHOST
Source Server Version : 50739
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50739
File Encoding         : 65001

Date: 2024-03-15 17:14:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_product_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_info`;
CREATE TABLE `tb_product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `company_id` varchar(30) DEFAULT NULL COMMENT '公司ID',
  `code` varchar(11) DEFAULT NULL COMMENT '商品编号',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(15,2) DEFAULT NULL COMMENT '价格',
  `sku_type` tinyint(4) DEFAULT NULL COMMENT 'sku类型',
  `color_type` tinyint(4) DEFAULT NULL COMMENT '颜色类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `stock` bigint(20) DEFAULT NULL COMMENT '库存',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code` (`code`) USING BTREE,
  UNIQUE KEY `idx_sku_color` (`sku_type`,`color_type`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of tb_product_info
-- ----------------------------
INSERT INTO `tb_product_info` VALUES ('1', '2', '3', 'TEST1', '99.00', '1', '1', '2024-03-07 00:00:00', '2024-03-13', '10', '2');
INSERT INTO `tb_product_info` VALUES ('10', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_product_info` VALUES ('11', null, null, null, null, null, null, null, null, null, null);
