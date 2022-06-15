CREATE DATABASE  IF NOT EXISTS `cuacfinal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cuacfinal`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: cuacfinal
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `seatlog`
--

DROP TABLE IF EXISTS `seatlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seatlog` (
  `email` varchar(45) NOT NULL,
  `classID` int NOT NULL,
  `seatID` int NOT NULL,
  `starttime` varchar(6) NOT NULL,
  `endtime` varchar(6) NOT NULL,
  `date` varchar(15) NOT NULL,
  PRIMARY KEY (`classID`,`seatID`,`starttime`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatlog`
--

LOCK TABLES `seatlog` WRITE;
/*!40000 ALTER TABLE `seatlog` DISABLE KEYS */;
INSERT INTO `seatlog` VALUES ('dummy2@uom.edu.gr',1,63,'9','12','15/6/2022'),('ics211xxx@uom.edu.gr',2,17,'12','15','15/6/2022'),('dummy@gmail.com',2,24,'18','19','15/6/2022'),('dummy@gmail.com',3,18,'19','20','15/6/2022');
/*!40000 ALTER TABLE `seatlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertable` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `pdfPath` varchar(250) DEFAULT NULL,
  `infectionDate` varchar(15) DEFAULT NULL,
  `walletDate` varchar(15) DEFAULT NULL,
  `nearInfectionDate` varchar(15) DEFAULT NULL,
  `notifType1` varchar(1000) DEFAULT NULL,
  `notifType2` varchar(1000) DEFAULT NULL,
  `notifType3` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES ('dummy@gmail.com','Passw0rd',NULL,NULL,'27/8/2022',NULL,'Το πιστοποιητικό σας λήγει σε : 73 μέρες',NULL,NULL),('dummy2@uom.edu.gr','My0therPass',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('ics21xxx@uom.edu.gr','Hell0w0rld','D:\\other\\έντυπο COVID (1).pdf',NULL,'24/6/2022',NULL,'Το πιστοποιητικό σας λήγει σε : 9 μέρες',NULL,NULL);
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-15 15:54:37
