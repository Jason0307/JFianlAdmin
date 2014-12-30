-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.38 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 Jfinal-Ace-Admin 的数据库结构
CREATE DATABASE IF NOT EXISTS `Jfinal-Ace-Admin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Jfinal-Ace-Admin`;


-- 导出  表 Jfinal-Ace-Admin.CommodityRecord 结构
CREATE TABLE IF NOT EXISTS `CommodityRecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `stock` bit(1) DEFAULT NULL,
  `ship` varchar(50) DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  Jfinal-Ace-Admin.CommodityRecord 的数据：~2 rows (大约)
DELETE FROM `CommodityRecord`;
/*!40000 ALTER TABLE `CommodityRecord` DISABLE KEYS */;
INSERT INTO `CommodityRecord` (`id`, `name`, `note`, `stock`, `ship`, `sdate`) VALUES
	(1, 'Desktop Computer', 'note', b'1', 'FedEx', '2014-12-24 10:30:19'),
	(2, 'Laptop45', 'Long text123', b'1', 'InTime', '2014-12-24 00:00:00');
/*!40000 ALTER TABLE `CommodityRecord` ENABLE KEYS */;


-- 导出  表 Jfinal-Ace-Admin.Item 结构
CREATE TABLE IF NOT EXISTS `Item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `qty` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  Jfinal-Ace-Admin.Item 的数据：~0 rows (大约)
DELETE FROM `Item`;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` (`id`, `name`, `qty`) VALUES
	(1, 'ipad', 10),
	(2, 'iphone', 50),
	(3, 'money', 5000),
	(4, 'girl', 2);
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
