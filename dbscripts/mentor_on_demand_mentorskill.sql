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
-- Table structure for table `mentorskill`
--

DROP TABLE IF EXISTS `mentorskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentorskill` (
  `ms_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ms_rating` int(2) DEFAULT NULL,
  `ms_exp` float DEFAULT NULL,
  `ms_us_id` bigint(20) NOT NULL,
  `ms_sk_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ms_id`),
  KEY `fk_skill_mentor1_idx` (`ms_us_id`),
  KEY `fk_mentorskill_skill1_idx` (`ms_sk_id`),
  CONSTRAINT `fk_mentorskill_skill1` FOREIGN KEY (`ms_sk_id`) REFERENCES `skill` (`sk_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_mentor1` FOREIGN KEY (`ms_us_id`) REFERENCES `mentor` (`me_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentorskill`
--

LOCK TABLES `mentorskill` WRITE;
/*!40000 ALTER TABLE `mentorskill` DISABLE KEYS */;
INSERT INTO `mentorskill` VALUES (2,2,1.2,12,1),(3,5,1.2,12,4),(4,7,3,14,1),(5,8,5,14,3),(7,8,5,15,4),(8,9,1,15,3);
/*!40000 ALTER TABLE `mentorskill` ENABLE KEYS */;
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
