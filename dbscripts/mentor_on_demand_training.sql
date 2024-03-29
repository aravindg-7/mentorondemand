-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: mentor_on_demand
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training` (
  `tr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tr_status` varchar(20) DEFAULT NULL,
  `tr_progress` int(11) DEFAULT NULL,
  `tr_rating` float DEFAULT NULL,
  `tr_startdate` date DEFAULT NULL,
  `tr_enddate` date DEFAULT NULL,
  `tr_us_id` bigint(20) NOT NULL,
  `tr_me_id` bigint(20) NOT NULL,
  `tr_sk_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tr_id`),
  KEY `fk_training_user1_idx` (`tr_us_id`),
  KEY `fk_training_mentor1_idx` (`tr_me_id`),
  KEY `fk_training_skill1_idx` (`tr_sk_id`),
  CONSTRAINT `fk_training_mentor1` FOREIGN KEY (`tr_me_id`) REFERENCES `mentor` (`me_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_training_skill1` FOREIGN KEY (`tr_sk_id`) REFERENCES `skill` (`sk_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_training_user1` FOREIGN KEY (`tr_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'Request Pending',0,0,'2019-12-11','2019-12-18',1,12,1);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 12:48:19
