/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : shopee_jav

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 28/11/2020 19:19:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `filter_value_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK2y94svpmqttx80mshyny85wqr` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, 'Test', 0);
INSERT INTO `category` VALUES (2, 'Test', 0);
INSERT INTO `category` VALUES (3, 'Test 2', 0);
INSERT INTO `category` VALUES (4, 'Test 3', 0);
COMMIT;

-- ----------------------------
-- Table structure for conversation
-- ----------------------------
DROP TABLE IF EXISTS `conversation`;
CREATE TABLE `conversation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `last_message` varchar(45) DEFAULT NULL,
  `last_user_id_message` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of conversation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `Rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of feedback
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for filter_name
-- ----------------------------
DROP TABLE IF EXISTS `filter_name`;
CREATE TABLE `filter_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of filter_name
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for filter_value
-- ----------------------------
DROP TABLE IF EXISTS `filter_value`;
CREATE TABLE `filter_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `SL` int(11) DEFAULT NULL,
  `Sku` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of filter_value
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `is_thumb` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of image
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `conversation_id` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of messages
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `price` varchar(15) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(15) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_feedback` varchar(255) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `total_sold` int(11) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `madeIn` varchar(45) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `width` varchar(45) DEFAULT NULL,
  `Wide` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `store_name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `is_store` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `avatar` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (5, 'Nguyen Thanh Luan', 'Test', 'e10adc3949ba59abbe56e057f20f883e', '0894763894', 'beginlive@gmail.com', NULL, 'w23232', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '23233', '123232', '149815eb972b3c370dee3b89d645ae14', '32323', '323232@sdsd.com', NULL, '232', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, '783627842', '32332', 'aef5a7530aaa272bbaec34e49251b25a', '783648', '23232@s.com', NULL, '34343434', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, 'Nguy?n Thành Luân', 'Lrandom', 'afd84683ac22162150457f71d1cd2658', '0868120192', 'beginlive@gmail.com', NULL, 'H? Long', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, 'Luân', 'Tes', '8017d0408f41b75489701e3fb1c3e773', '0868120', 'beginlive@gma.xom', NULL, 'ha Long', NULL, NULL, NULL, '11_2020/16059592216422020-10-30 09.06.55.jpg');
INSERT INTO `user` VALUES (10, 'Luan', '67567 5', '8cacbbe8dea5108025ed532bc53a1c5f', '837489347', 'ghjg@s.com', NULL, '3743847', NULL, NULL, NULL, '11_2020/1605959594214nordwood-themes-kRNZiGKtz48-unsplash.jpg');
INSERT INTO `user` VALUES (11, 'dgfhjkg', 'jhkjhjk', '5d9f6bd795756a635f4ba265a5d3a331', '20937298', '789687@s.com', NULL, '3487394', NULL, NULL, NULL, '11_2020/1605962404222image_2020-11-21_11-45-44.png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
