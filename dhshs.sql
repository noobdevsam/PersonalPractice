/*M!999999\- enable the sandbox mode */                           -- MariaDB dump 10.19-11.6.1-MariaDB, for Android (aarch64)
--                                                                -- Host: localhost    Database: university                        -- ------------------------------------------------------
-- Server version       11.6.1-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `Advisor`
--

DROP TABLE IF EXISTS `Advisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Advisor` (
  `s_ID` int(11) NOT NULL,
  `i_ID` int(11) NOT NULL,
  PRIMARY KEY (`s_ID`,`i_ID`),
  KEY `i_ID` (`i_ID`),
  CONSTRAINT `Advisor_ibfk_1` FOREIGN KEY (`s_ID`) REFERENCES `Student` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `Advisor_ibfk_2` FOREIGN KEY (`i_ID`) REFERENCES `Instructor` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Advisor`
--

LOCK TABLES `Advisor` WRITE;
/*!40000 ALTER TABLE `Advisor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Advisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Classroom`
--

DROP TABLE IF EXISTS `Classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Classroom` (
  `building` varchar(50) NOT NULL,
  `room_number` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`building`,`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Classroom`
--

LOCK TABLES `Classroom` WRITE;
/*!40000 ALTER TABLE `Classroom` DISABLE KEYS */;
INSERT INTO `Classroom` VALUES
('Packard',101,500),
('Painter',514,10),
('Taylor',3128,70),
('Watson',100,30),
('Watson',120,50);
/*!40000 ALTER TABLE `Classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `course_id` varchar(10) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `Course_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `Department` (`dept_name`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES
('BIO-101','Intro. to Biology','Biology',4),
('BIO-301','Genetics','Biology',4),
('BIO-399','Computational Biology','Biology',3),
('CS-101','Into. to Computer Science','Comp. Sci.',4),
('CS-190','Game Design','Comp. Sci.',4),
('CS-315','Robotics','Comp. Sci.',3),
('CS-319','Image Processing','Comp. Sci.',3),
('CS-347','Database System Concepts','Comp. Sci.',3),
('EE-181','Intro. to Digital Systems','Elec. Eng.',3),
('FIN-201','Investment Banking','Finance',3),
('HIS-351','World History','History',3),
('MU-199','Misic Video Production','Music',3),
('PHY-101','Physical Principles','Physics',4);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Department`
--

DROP TABLE IF EXISTS `Department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Department` (
  `dept_name` varchar(50) NOT NULL,
  `building` varchar(50) DEFAULT NULL,
  `budget` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Department`
--

LOCK TABLES `Department` WRITE;
/*!40000 ALTER TABLE `Department` DISABLE KEYS */;
INSERT INTO `Department` VALUES
('Biology','Watson',90000.00),
('Comp. Sci.','Taylor',100000.00),
('Elec. Eng.','Taylor',85000.00),
('Finance','Painter',120000.00),
('History','Painter',50000.00),
('Music','Packard',80000.00),
('Physics','Watson',70000.00);
/*!40000 ALTER TABLE `Department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Instructor`
--

DROP TABLE IF EXISTS `Instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Instructor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `salary` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `Instructor_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `Department` (`dept_name`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=333457 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instructor`
--

LOCK TABLES `Instructor` WRITE;
/*!40000 ALTER TABLE `Instructor` DISABLE KEYS */;
INSERT INTO `Instructor` VALUES
(10101,'Srinivasam','Comp. Sci.',65000.00),
(12121,'Wu','Finance',90000.00),
(15151,'Mozart','Music',40000.00),
(22222,'Einstein','Physics',95000.00),
(32343,'El Said','History',60000.00),
(33456,'Gold','Physics',87000.00),
(45565,'Katz','Comp. Sci. ',75000.00),
(58583,'Califieri','History',62000.00),
(76543,'Singh','Finance',80000.00),
(76766,'Crick','Biology',72000.00),
(83821,'Brandt','Comp. Sci.',92000.00),
(98345,'Kim','Elec. Eng.',80000.00);
/*!40000 ALTER TABLE `Instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prerequisite`
--

DROP TABLE IF EXISTS `Prerequisite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Prerequisite` (
  `course_id` varchar(10) NOT NULL,
  `prereq_id` varchar(10) NOT NULL,
  PRIMARY KEY (`course_id`,`prereq_id`),
  KEY `prereq_id` (`prereq_id`),
  CONSTRAINT `Prerequisite_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `Prerequisite_ibfk_2` FOREIGN KEY (`prereq_id`) REFERENCES `Course` (`course_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prerequisite`
--

LOCK TABLES `Prerequisite` WRITE;
/*!40000 ALTER TABLE `Prerequisite` DISABLE KEYS */;
/*!40000 ALTER TABLE `Prerequisite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Section`
--

DROP TABLE IF EXISTS `Section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Section` (
  `course_id` varchar(10) NOT NULL,
  `sec_id` int(11) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `building` varchar(50) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `time_slot_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`sec_id`,`semester`,`year`),
  KEY `building` (`building`,`room_number`),
  KEY `time_slot_id` (`time_slot_id`),
  CONSTRAINT `Section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `Section_ibfk_2` FOREIGN KEY (`building`, `room_number`) REFERENCES `Classroom` (`building`, `room_number`),
  CONSTRAINT `Section_ibfk_3` FOREIGN KEY (`time_slot_id`) REFERENCES `Time_Slot` (`time_slot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Section`
--

LOCK TABLES `Section` WRITE;
/*!40000 ALTER TABLE `Section` DISABLE KEYS */;
INSERT INTO `Section` VALUES
('BIO-101',1,'Summer',2009,'Painter',514,'B'),
('BIO-301',1,'Summer',2010,'Painter',514,'A'),
('CS-101',1,'Fall',2009,'Packard',101,'H'),
('CS-101',1,'Spring',2010,'Packard',101,'F'),
('CS-190',1,'Spring',2009,'Taylor',3128,'E'),
('CS-190',2,'Spring',2009,'Taylor',3128,'A'),
('CS-315',1,'Spring',2010,'Watson',120,'D'),
('CS-319',1,'Spring',2010,'Watson',100,'B'),
('CS-319',2,'Spring',2010,'Taylor',3128,'C'),
('CS-347',1,'Fall',2009,'Taylor',3128,'A'),
('EE-181',1,'Spring',2009,'Taylor',3128,'C'),
('FIN-201',1,'Spring',2010,'Packard',101,'B'),
('HIS-351',1,'Spring',2010,'Painter',514,'C'),
('MU-199',1,'Spring',2010,'Packard',101,'D'),
('PHY-101',1,'Fall',2009,'Watson',100,'A');
/*!40000 ALTER TABLE `Section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `tot_cred` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `dept_name` (`dept_name`),
  CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`dept_name`) REFERENCES `Department` (`dept_name`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98989 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES
(128,'Zhang','Comp. Sci.',102),
(12345,'Shankar','Comp. Sci.',32),
(19991,'Brandt','History',80),
(23121,'Chavez','Finance',110),
(44553,'Peltier','Physics',56),
(45678,'Levy','Physics',46),
(54321,'Williams','Comp. Sci.',54),
(55739,'Sanchez','Music',38),
(70557,'Snow','Physics',0),
(76543,'Brown','Comp. Sci.',58),
(76653,'Aoi','Elec. Eng.',60),
(98765,'Bourikas','Elec. Eng.',98),
(98988,'Tanaka','Biology',120);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Takes`
--

DROP TABLE IF EXISTS `Takes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Takes` (
  `ID` int(11) NOT NULL,
  `course_id` varchar(10) NOT NULL,
  `sec_id` int(11) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  `grade` char(2) DEFAULT NULL,
  PRIMARY KEY (`ID`,`course_id`,`sec_id`,`semester`,`year`),
  KEY `course_id` (`course_id`,`sec_id`,`semester`,`year`),
  CONSTRAINT `Takes_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Student` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `Takes_ibfk_2` FOREIGN KEY (`course_id`, `sec_id`, `semester`, `year`) REFERENCES `Section` (`course_id`, `sec_id`, `semester`, `year`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Takes`
--

LOCK TABLES `Takes` WRITE;
/*!40000 ALTER TABLE `Takes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Takes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teaches`
--

DROP TABLE IF EXISTS `Teaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teaches` (
  `ID` int(11) NOT NULL,
  `course_id` varchar(10) NOT NULL,
  `sec_id` int(11) NOT NULL,
  `semester` varchar(20) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`ID`,`course_id`,`sec_id`,`semester`,`year`),
  KEY `course_id` (`course_id`,`sec_id`,`semester`,`year`),
  CONSTRAINT `Teaches_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Instructor` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `Teaches_ibfk_2` FOREIGN KEY (`course_id`, `sec_id`, `semester`, `year`) REFERENCES `Section` (`course_id`, `sec_id`, `semester`, `year`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teaches`
--

LOCK TABLES `Teaches` WRITE;
/*!40000 ALTER TABLE `Teaches` DISABLE KEYS */;
INSERT INTO `Teaches` VALUES
(76766,'BIO-101',1,'Summer',2009),
(76766,'BIO-301',1,'Summer',2010),
(10101,'CS-101',1,'Fall',2009),
(45565,'CS-101',1,'Spring',2010),
(83821,'CS-190',1,'Spring',2009),
(83821,'CS-190',2,'Spring',2009),
(10101,'CS-315',1,'Spring',2010),
(45565,'CS-319',1,'Spring',2010),
(83821,'CS-319',2,'Spring',2010),
(10101,'CS-347',1,'Fall',2009),
(98345,'EE-181',1,'Spring',2009),
(12121,'FIN-201',1,'Spring',2010),
(32343,'HIS-351',1,'Spring',2010),
(15151,'MU-199',1,'Spring',2010),
(22222,'PHY-101',1,'Fall',2009);
/*!40000 ALTER TABLE `Teaches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Time_Slot`
--

DROP TABLE IF EXISTS `Time_Slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Time_Slot` (
  `time_slot_id` varchar(10) NOT NULL,
  `day` varchar(15) NOT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`time_slot_id`,`day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Time_Slot`
--

LOCK TABLES `Time_Slot` WRITE;
/*!40000 ALTER TABLE `Time_Slot` DISABLE KEYS */;
INSERT INTO `Time_Slot` VALUES
('A','F','08:00:00','08:50:00'),
('A','M','08:00:00','08:50:00'),
('A','W','08:00:00','08:50:00'),
('B','F','09:00:00','09:50:00'),
('B','M','09:00:00','09:50:00'),
('B','W','09:00:00','09:50:00'),
('C','F','11:00:00','11:50:00'),
('C','M','11:00:00','11:50:00'),
('C','W','11:00:00','11:50:00'),
('D','F','13:00:00','13:50:00'),
('D','M','13:00:00','13:50:00'),
('D','W','13:00:00','13:50:00'),
('E','R','10:30:00','11:45:00'),
('E','T','10:30:00','11:45:00'),
('F','R','14:30:00','15:45:00'),
('F','T','14:30:00','15:45:00'),
('G','F','16:00:00','16:50:00'),
('G','M','16:00:00','16:50:00'),
('G','W','16:00:00','16:50:00'),
('H','W','10:00:00','12:30:00');
/*!40000 ALTER TABLE `Time_Slot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2024-11-18 10:03:23
