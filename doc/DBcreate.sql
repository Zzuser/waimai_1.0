CREATE DATABASE  IF NOT EXISTS `waimai_1.1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `waimai_1.1`;
-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: waimai_1.1
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin（un）`
--

DROP TABLE IF EXISTS `admin（un）`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin（un）` (
  `admin_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `admin_name` int(4) NOT NULL COMMENT '管理员名',
  `admin_psd` int(4) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `car_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `order_id` int(11) NOT NULL COMMENT '订单编号',
  `food_id` int(11) NOT NULL COMMENT '菜品编号',
  `user_id` int(11) NOT NULL COMMENT '顾客id',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cat_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `cat_name` varchar(10) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_name_UNIQUE` (`cat_name`),
  KEY `cat_id` (`cat_id`,`cat_name`),
  KEY `cat_name` (`cat_name`),
  KEY `cat_name_2` (`cat_name`,`cat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '城市id',
  `city_name` varchar(20) NOT NULL COMMENT '城市名称',
  `city_lon` double NOT NULL COMMENT '城市经度',
  `city_lat` double NOT NULL COMMENT '城市纬度',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `daily_bill`
--

DROP TABLE IF EXISTS `daily_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_bill` (
  `bill_id` int(4) NOT NULL AUTO_INCREMENT,
  `shop_id` int(4) NOT NULL,
  `order_num` int(11) DEFAULT NULL COMMENT '今日订单量',
  `totalmoney` double DEFAULT NULL COMMENT '今日交易总金额',
  `new_collection_num` int(11) DEFAULT NULL COMMENT '今日新增收藏',
  `bill_time` datetime DEFAULT NULL COMMENT '流水创建时间',
  `shop_status` varchar(45) DEFAULT NULL COMMENT '商店状态',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `food_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '菜品编号',
  `food_name` varchar(32) NOT NULL COMMENT '食品名称',
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  UNIQUE KEY `food_name_UNIQUE` (`food_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `food_shop`
--

DROP TABLE IF EXISTS `food_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food_shop` (
  `food_shop_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品——商铺连接id',
  `food_id` int(11) NOT NULL COMMENT '菜品id',
  `shop_id` int(11) NOT NULL COMMENT '商铺id',
  `food_num` int(11) DEFAULT NULL COMMENT '食品库存',
  `food_price` double NOT NULL COMMENT '食品价格',
  `food_sales` int(11) DEFAULT NULL COMMENT '食品销量',
  `food_ev` varchar(200) DEFAULT NULL COMMENT '食品评价',
  `food_pic` varchar(200) DEFAULT NULL COMMENT '食品图片',
  `food_des` varchar(145) DEFAULT NULL COMMENT '食品描述',
  PRIMARY KEY (`food_shop_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horseman`
--

DROP TABLE IF EXISTS `horseman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horseman` (
  `horseman_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '骑手id',
  `horseman_name` varchar(8) NOT NULL COMMENT '骑手姓名',
  `horseman_psd` varchar(12) NOT NULL COMMENT '骑手登录密码',
  `horseman_tel` varchar(20) NOT NULL COMMENT '骑手电话',
  `horseman_status` tinyint(3) DEFAULT NULL COMMENT '骑手状态',
  `horeseman_add` varchar(255) NOT NULL COMMENT '骑手位置',
  `takeout_num` tinyint(3) DEFAULT NULL COMMENT '已接单数量',
  `accomplish_time` datetime DEFAULT NULL COMMENT '平均完成时间',
  `horseman_lon` double DEFAULT NULL COMMENT '骑手经度',
  `horseman_lat` double DEFAULT NULL COMMENT '骑手纬度',
  `horseman_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`horseman_id`),
  UNIQUE KEY `horseman_tel_UNIQUE` (`horseman_tel`),
  UNIQUE KEY `horseman_name_UNIQUE` (`horseman_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horseman_evaluate`
--

DROP TABLE IF EXISTS `horseman_evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horseman_evaluate` (
  `ev_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '骑手评价ｉｄ',
  `ev_all` float NOT NULL COMMENT '骑手总评分',
  `on_time_count` int(11) DEFAULT NULL COMMENT '准时送到数量',
  `out_time_count` int(11) DEFAULT NULL COMMENT '超时送达数量',
  `on_time_rate` double DEFAULT NULL COMMENT '准时率',
  PRIMARY KEY (`ev_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_food`
--

DROP TABLE IF EXISTS `order_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_food` (
  `order_food_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单——食品ｉｄ',
  `food_id` int(11) NOT NULL COMMENT '食品ｉｄ',
  `order_id` int(11) NOT NULL COMMENT '订单ｉｄ',
  `food_count` int(3) NOT NULL COMMENT '食品数量',
  PRIMARY KEY (`order_food_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `shop_id` int(11) NOT NULL COMMENT '商户ｉｄ',
  `horseman_id` int(11) DEFAULT NULL COMMENT '骑手ｉｄ',
  `account` char(8) DEFAULT NULL COMMENT '订单总金额',
  `payment` varchar(11) DEFAULT NULL COMMENT '支付方式',
  `status` varchar(16) DEFAULT NULL COMMENT '订单处理状态',
  `order_time` datetime DEFAULT NULL COMMENT '订单下达时间',
  `arrive_time` datetime DEFAULT NULL COMMENT '预计送达时间',
  `order_number` varchar(20) DEFAULT NULL COMMENT '订单编号',
  `order_money` double DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `province_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(30) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商户id',
  `shop_name` varchar(60) NOT NULL COMMENT '商户名称',
  `shop_psw` varchar(45) NOT NULL COMMENT '商户密码',
  `shop_tel` varchar(20) NOT NULL COMMENT '商户电话',
  `shop_add` varchar(50) NOT NULL COMMENT '商户地址',
  `shop_img` varchar(200) DEFAULT NULL COMMENT '商铺图片',
  `delivery_fee` varchar(8) DEFAULT NULL COMMENT '配送费',
  `shop_proclamation` varchar(450) DEFAULT NULL COMMENT ' 商店公告',
  `month_sales` int(11) DEFAULT NULL COMMENT '月销售量',
  `order_num` varchar(45) DEFAULT NULL COMMENT '订单总量',
  `collection_num` int(11) DEFAULT NULL COMMENT '总收藏数',
  `city_id` int(4) DEFAULT NULL COMMENT '商户城市id',
  `province_id` int(4) DEFAULT NULL COMMENT '商户省份ID',
  `shop_lat` double(20,0) DEFAULT NULL COMMENT '商户经度',
  `shop_lon` double(20,0) DEFAULT NULL COMMENT '商户经度',
  `shop_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `shop_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `shop_tel_UNIQUE` (`shop_tel`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop_category`
--

DROP TABLE IF EXISTS `shop_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_category` (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL COMMENT '商户ｉｄ',
  `category_id` int(11) NOT NULL COMMENT '食品分类ｉｄ',
  PRIMARY KEY (`shop_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop_evaluate`
--

DROP TABLE IF EXISTS `shop_evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_evaluate` (
  `ev_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价ｉｄ',
  `shop_id` int(11) NOT NULL COMMENT '商户ｉｄ',
  `user_id` int(11) NOT NULL COMMENT '用户ｉｄ',
  `ev_all` double NOT NULL COMMENT '总评分',
  `ev_comment` varchar(100) NOT NULL COMMENT '评论详情',
  `ev_pic` varchar(30) DEFAULT NULL COMMENT '评价图片',
  PRIMARY KEY (`ev_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop_shop_type`
--

DROP TABLE IF EXISTS `shop_shop_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_shop_type` (
  `shop_shoptype_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店铺——店铺类型连接id',
  `shop_id` int(11) NOT NULL COMMENT '店铺id',
  `shoptype_id` int(11) NOT NULL COMMENT '店铺类型id',
  PRIMARY KEY (`shop_shoptype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shop_type`
--

DROP TABLE IF EXISTS `shop_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_type` (
  `shoptype_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店铺类型id',
  `type_name` varchar(10) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`shoptype_id`),
  UNIQUE KEY `type_name_UNIQUE` (`type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(22) NOT NULL COMMENT '用户昵称',
  `user_portrait` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `user_psd` varchar(22) NOT NULL COMMENT '用户密码',
  `user_tel` varchar(20) NOT NULL COMMENT '用户电话',
  `receive_add` varchar(60) DEFAULT NULL COMMENT '收货人地址',
  `receive_name` varchar(60) DEFAULT NULL COMMENT '收货人姓名',
  `receive_tel` int(11) DEFAULT NULL COMMENT '收货人电话',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '上次登录ip',
  `user_lon` double(20,0) DEFAULT NULL COMMENT '顾客经度',
  `user_lat` double(20,0) DEFAULT NULL COMMENT '顾客纬度',
  `user_createtime` datetime DEFAULT NULL COMMENT '顾客创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_shop`
--

DROP TABLE IF EXISTS `user_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_shop` (
  `user_shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '顾客id',
  `shop_id` int(11) NOT NULL COMMENT '商铺id',
  PRIMARY KEY (`user_shop_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-14 15:05:35
