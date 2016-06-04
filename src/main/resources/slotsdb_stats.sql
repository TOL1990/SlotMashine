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

-- Dump completed on 2016-06-03 16:07:26
