CREATE DATABASE  IF NOT EXISTS `slotsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `slotsdb`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: slotsdb
-- ------------------------------------------------------
-- Server version	5.5.46-log

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
-- Table structure for table `bets`
--

DROP TABLE IF EXISTS `bets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bets` (
  `mashine_id` int(11) NOT NULL,
  `bet` decimal(10,0) DEFAULT NULL COMMENT 'Описывает доступные ставки для слот машш',
  `bet_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bet_id`),
  UNIQUE KEY `bet_id_UNIQUE` (`bet_id`),
  KEY `BetToMashineFK_idx` (`mashine_id`),
  CONSTRAINT `BetToMashineFK` FOREIGN KEY (`mashine_id`) REFERENCES `mashines` (`mashine_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bets`
--

LOCK TABLES `bets` WRITE;
/*!40000 ALTER TABLE `bets` DISABLE KEYS */;
INSERT INTO `bets` VALUES (1,5,1),(1,10,2),(1,25,3),(1,50,4),(1,100,5),(2,50,6),(2,100,7),(2,200,8),(2,500,9),(2,300,10),(2,750,11),(2,1000,12);
/*!40000 ALTER TABLE `bets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icons`
--

DROP TABLE IF EXISTS `icons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icons` (
  `icon_id` int(11) NOT NULL AUTO_INCREMENT,
  `image` tinyblob,
  `description` varchar(100) DEFAULT NULL,
  `pay_table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`icon_id`),
  KEY `IconToPayTableFK_idx` (`pay_table_id`),
  CONSTRAINT `IconToPayTableFK` FOREIGN KEY (`pay_table_id`) REFERENCES `pay_tables` (`pay_table_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icons`
--

LOCK TABLES `icons` WRITE;
/*!40000 ALTER TABLE `icons` DISABLE KEYS */;
INSERT INTO `icons` VALUES (1,NULL,'Anubis',1),(2,NULL,'Mummy',1),(3,NULL,'Pyramid',1),(4,NULL,'Pharaon',1),(5,NULL,'Hippo',1);
/*!40000 ALTER TABLE `icons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line_points`
--

DROP TABLE IF EXISTS `line_points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `line_points` (
  `line_id` int(11) NOT NULL COMMENT 'какой линии принадлежит точка',
  `coll` int(11) DEFAULT NULL COMMENT 'Столбец ',
  `row` int(11) DEFAULT NULL COMMENT 'строка',
  `line_point_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`line_point_id`),
  KEY `LineToLinePointsFK_idx` (`line_id`),
  CONSTRAINT `LineToLinePointsFK` FOREIGN KEY (`line_id`) REFERENCES `mashine_lines` (`line_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='Описывает точки через которые проходит линия';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line_points`
--

LOCK TABLES `line_points` WRITE;
/*!40000 ALTER TABLE `line_points` DISABLE KEYS */;
INSERT INTO `line_points` VALUES (1,1,1,1),(1,2,1,2),(1,3,1,3),(1,4,1,4),(1,5,1,5),(2,1,2,6),(2,2,2,7),(2,3,2,8),(2,4,2,9),(2,5,2,10),(3,1,3,11),(3,2,3,12),(3,3,3,13),(3,4,3,14),(3,5,3,15),(6,1,2,16),(6,2,1,17),(6,3,1,18),(6,4,1,19),(6,5,2,20),(4,1,1,22),(4,2,2,23),(4,3,3,24),(4,4,2,25),(4,5,1,26),(5,1,3,27),(5,2,2,28),(5,3,1,29),(5,4,2,30),(5,5,3,31),(7,1,2,32),(7,2,3,33),(7,3,3,34),(7,4,3,35),(7,5,2,36);
/*!40000 ALTER TABLE `line_points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mashine_lines`
--

DROP TABLE IF EXISTS `mashine_lines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mashine_lines` (
  `line_id` int(11) NOT NULL AUTO_INCREMENT,
  `mashine_id` int(11) NOT NULL COMMENT 'Какой машине принадлежит линия',
  PRIMARY KEY (`line_id`),
  KEY `MashineToLineFK_idx` (`mashine_id`),
  CONSTRAINT `MashineToLineFK` FOREIGN KEY (`mashine_id`) REFERENCES `mashines` (`mashine_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='Описывает лини для конкретной машины';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mashine_lines`
--

LOCK TABLES `mashine_lines` WRITE;
/*!40000 ALTER TABLE `mashine_lines` DISABLE KEYS */;
INSERT INTO `mashine_lines` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1);
/*!40000 ALTER TABLE `mashine_lines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mashines`
--

DROP TABLE IF EXISTS `mashines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mashines` (
  `mashine_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mashine_id`),
  UNIQUE KEY `mashine_id_UNIQUE` (`mashine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mashines`
--

LOCK TABLES `mashines` WRITE;
/*!40000 ALTER TABLE `mashines` DISABLE KEYS */;
INSERT INTO `mashines` VALUES (1,'Egypt'),(2,'Ukraine');
/*!40000 ALTER TABLE `mashines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_icons`
--

DROP TABLE IF EXISTS `pay_icons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_icons` (
  `icon_id` int(11) DEFAULT NULL,
  `images_count` int(11) DEFAULT NULL COMMENT 'за сколько собранных картинок получишь награду',
  `award` decimal(10,0) DEFAULT NULL COMMENT 'сколько получишь за собранные картинки',
  `pay_icon_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pay_icon_id`),
  KEY `PayIconToIconFK` (`icon_id`),
  CONSTRAINT `PayIconToIconFK` FOREIGN KEY (`icon_id`) REFERENCES `icons` (`icon_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_icons`
--

LOCK TABLES `pay_icons` WRITE;
/*!40000 ALTER TABLE `pay_icons` DISABLE KEYS */;
INSERT INTO `pay_icons` VALUES (5,3,500,1),(5,4,1000,2),(5,5,10000,3),(1,3,8,16),(1,4,40,17),(1,5,150,18),(2,3,6,19),(2,4,35,20),(2,5,100,21),(3,3,5,22),(3,4,30,23),(3,5,80,24),(4,3,5,25),(4,4,25,26),(4,5,75,27);
/*!40000 ALTER TABLE `pay_icons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_tables`
--

DROP TABLE IF EXISTS `pay_tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_tables` (
  `mashine_id` int(11) DEFAULT NULL,
  `pay_table_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pay_table_id`),
  UNIQUE KEY `pay_table_id_UNIQUE` (`pay_table_id`),
  KEY `MashineToPayTabFK_idx` (`mashine_id`),
  CONSTRAINT `MashineToPayTabFK` FOREIGN KEY (`mashine_id`) REFERENCES `mashines` (`mashine_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Описывает таблички выплат для каждой машины';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_tables`
--

LOCK TABLES `pay_tables` WRITE;
/*!40000 ALTER TABLE `pay_tables` DISABLE KEYS */;
INSERT INTO `pay_tables` VALUES (1,1,'Egypt pay Table'),(2,2,'Ukraine pay table');
/*!40000 ALTER TABLE `pay_tables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `balance` bigint(20) NOT NULL,
  PRIMARY KEY (`player_id`),
  UNIQUE KEY `nick_UNIQUE` (`nick`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'lamer','111',110),(2,'pro','123654',999710),(3,'Grisha','123123',100000),(4,'noobko','0000',10000);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stats`
--

DROP TABLE IF EXISTS `stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stats` (
  `stats_id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` int(11) NOT NULL COMMENT 'Какой юзер играл',
  `time` datetime DEFAULT NULL COMMENT 'когда сыграно',
  `mashine_id` int(11) NOT NULL COMMENT 'на какой машине',
  `money_bet` decimal(10,0) DEFAULT NULL,
  `money_get` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`stats_id`),
  KEY `PlayerToStatsFK_idx` (`player_id`),
  KEY `MashineToStatsFK_idx` (`mashine_id`),
  CONSTRAINT `MashineToStatsFK` FOREIGN KEY (`mashine_id`) REFERENCES `mashines` (`mashine_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PlayerToStatsFK` FOREIGN KEY (`player_id`) REFERENCES `players` (`player_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stats`
--

LOCK TABLES `stats` WRITE;
/*!40000 ALTER TABLE `stats` DISABLE KEYS */;
INSERT INTO `stats` VALUES (1,1,'2016-06-20 16:10:00',1,100,-100),(2,1,'2016-06-20 16:11:00',2,100,1000),(3,2,'2016-06-20 16:12:00',1,500,-500),(4,2,'2016-06-20 16:13:00',1,500,-500);
/*!40000 ALTER TABLE `stats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-10 17:17:31
