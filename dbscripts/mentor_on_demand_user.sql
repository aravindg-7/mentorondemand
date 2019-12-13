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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `us_username` varchar(45) NOT NULL,
  `us_password` varchar(90) NOT NULL,
  `us_first_name` varchar(45) NOT NULL,
  `us_last_name` varchar(45) NOT NULL,
  `us_role` varchar(15) NOT NULL,
  `us_contact_number` bigint(10) NOT NULL,
  `us_reg_code` varchar(45) DEFAULT NULL,
  `us_active` tinyint(1) DEFAULT NULL,
  `us_confirmed_signup` tinyint(1) DEFAULT NULL,
  `us_reset_password` tinyint(1) DEFAULT NULL,
  `us_reset_password_date` date DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE KEY `us_username_UNIQUE` (`us_username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'thor','$2a$10$kiPwQPVtAMiNbc13htb6F.j7pqivQ4ZE4mo25rwm36yfPczS6EWcK','thor','odinson','USER',1233333333,NULL,1,1,NULL,NULL),(3,'loki','$2a$10$LalEwUWa4BEY.ArWlsgSOunugCwZJgIgJFRjdl7oD2xE.R2xjeeru','loki','odinson','USER',2233333333,NULL,1,1,NULL,NULL),(28,'hela','$2a$10$M78oy6KD8RHeZGtWwpIDMeiqPvGOKRo0.dqf4iNJU0pioYhB7GbTi','hela','odinson','MENTOR',1234554321,'',0,0,0,NULL),(31,'surtur','$2a$10$ueEAIFByCEo9aWFIxS7wqO4ow2MIhWoHgbP6Xy54cZC/.O0TVYx6e','sur','tur','MENTOR',1888999989,'',0,0,0,NULL),(32,'heimdhall','$2a$10$OHNpitgui8Oa7Uv1z1r1HO07.zhoiuzLZbmKtpneISUlBfvkmC8kC','heimd','hall','MENTOR',2222223345,'',0,0,0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 12:48:20
