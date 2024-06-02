-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_ppc
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `emp_event`
--

DROP TABLE IF EXISTS `emp_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `empID` int DEFAULT NULL,
  `eventID` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_empid_idx` (`empID`),
  KEY `fk_eventid_idx` (`eventID`),
  CONSTRAINT `fk_empid` FOREIGN KEY (`empID`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_eventid` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_event`
--

LOCK TABLES `emp_event` WRITE;
/*!40000 ALTER TABLE `emp_event` DISABLE KEYS */;
INSERT INTO `emp_event` VALUES (1,37,1,'2022-10-10','“Bill Gates is going to join DataOrb on 1st November as a SE.”','1-11-2022'),(2,38,1,'2022-10-10','“Steve Jobs joined DataOrb on 1st October as an Architect.”','1-10-2022'),(3,39,1,'2022-10-10','“Martin has joined DataOrb as a SE.”','15-10-2022'),(4,38,2,'2022-10-10','“Oct Salary of Steve.”','3000'),(5,38,3,'2022-10-10','“Bouns of Steve.”','50'),(6,37,3,'2022-10-10','“Bouns of Bill”','3300'),(7,39,2,'2022-10-10','“Nov Salary of Steve.”','34000'),(8,37,5,'2022-11-10','“Nov Travelling.”','303'),(9,39,5,'2022-11-10','“Nov Travelling.”','330'),(10,38,4,'2022-11-10','“Exit Steve.”','1-12-2022'),(11,40,1,'2022-10-10','“Vijay is going to join DataOrb on 1st November as a SE.”','1-11-2022'),(12,41,1,'2022-11-10','“Sumit Jobs joined DataOrb on 1st October as an Architect.”','1-10-2022'),(13,42,1,'2022-11-10','“Mark has joined DataOrb as a SE.”','15-10-2022'),(14,41,2,'2022-10-14','“Oct Salary\"','3000'),(15,41,3,'2022-10-10','“Bouns of Steve.”','50'),(16,40,3,'2022-10-10','“Bouns of Bill”','3300'),(17,42,2,'2022-10-10','“Nov Salary of Steve.”','34000'),(18,40,5,'2022-11-10','“Nov Travelling.”','303'),(19,42,5,'2022-11-10','“Nov Travelling.”','330'),(20,41,4,'2022-11-10','“Exit Steve.”','1-12-2022'),(21,43,1,'2022-11-10','“Bret Gates is going to join DataOrb on 1st November as a SE.”','1-11-2022'),(22,44,1,'2022-10-10','“Sara Jobs joined DataOrb on 1st October as an Architect.”','1-10-2022'),(23,45,1,'2022-11-10','“Markus has joined DataOrb as a SE.”','15-10-2022'),(24,45,2,'2022-11-10','“Oct Salary of Steve.”','3000'),(25,43,3,'2022-10-10','“Bouns of Steve.”','50'),(26,44,3,'2022-11-10','“Bouns of Bill”','3300'),(27,43,2,'2022-10-10','“Nov Salary of Steve.”','34000'),(28,40,5,'2022-11-10','“Nov Travelling.”','303'),(29,45,5,'2022-11-10','“Nov Travelling.”','330'),(30,45,4,'2022-11-10','“Exit markus”','1-12-2022');
/*!40000 ALTER TABLE `emp_event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03  1:27:08
