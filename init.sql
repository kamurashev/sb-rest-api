-- Server version	5.7.32
#1 Execute:
# mysql -uroot -e "create database sbApp" -p

#2 Execute
# mysql -u root sbApp < path_to_this_file -p

CREATE USER IF NOT EXISTS 'sbApp'@'localhost' IDENTIFIED BY 'sbApp';
GRANT ALL ON `sbApp`.* TO 'sbApp'@'localhost' IDENTIFIED BY 'sbApp';

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `created` datetime NOT NULL,
                         `created_by` varchar(255) NOT NULL,
                         `last_modified` datetime NOT NULL,
                         `last_modified_by` varchar(255) NOT NULL,
                         `birthday` date DEFAULT NULL,
                         `email` varchar(255) NOT NULL,
                         `first_name` varchar(255) DEFAULT NULL,
                         `last_name` varchar(255) DEFAULT NULL,
                         `login` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL ,
                         `role` varchar(255) NOT NULL DEFAULT 'ROLE_USER',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `LOGIN_UNIQUE` (`login`),
                         UNIQUE KEY `EMAIL_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'0001-01-01 00:00:00','GOD','0001-01-01 00:00:00','GOD','0001-01-01','god@eden.in','GOD','GOD','GOD','$2a$10$o08jDTzJCsexXRU8dm501u3F7Ne0KlZFp28vbj332dn4/4.cILUGq','ROLE_ADMIN'),(2,'2020-12-10 00:00:00','GOD','2020-12-10 00:00:00','GOD','1999-03-22','jimmy@gmail.com','jimmy','bee','jimmy','$2a$10$Ol0u3/k0EaXyBx4JSWxaV.LIZvzJctxb0L0CVpW/YmtS/XGgPH1iu','ROLE_USER'),(3,'2020-12-10 00:00:00','GOD','2020-12-10 00:00:00','GOD','1989-11-15','mery@gmail.com','mary','jane','mery','$2a$10$2ZV0UmcRAxlxiuo8U1osJ.gK9cZ0oDn9CT.HCIh8jgE3ocHoi2xoy','ROLE_USER'),(4,'2020-12-10 00:00:00','GOD','2020-12-10 00:00:00','GOD','1984-02-04','admin@gmail.com','admin','userson','admin','$2a$10$kXB48HddkfZj8RY.pMw25OWotyF0TkacEmIr4oo9ydu.4WwV027hC','ROLE_ADMIN'),(5,'2020-12-10 00:00:00','admin','2020-12-10 00:00:00','admin','1992-05-21','leeloo@gmail.com','leeloo','dallas','leeloo','$2a$10$hrsfSN/.XtYDa7s3mmvn4eE2ywasQdoSEPtyHEta5qCAVklJG.gJ2','ROLE_ADMIN'),(6,'2020-12-10 00:00:00','admin','2020-12-10 00:00:00','admin','1994-07-17','user@gmail.com','user','poor','user','$2a$10$e7l6BWsxGk1oeIyM.PWideXoREmZW.ptOEBXuj9MCZQ4NA9qhu0x6','ROLE_USER'),(7,'2020-12-10 03:49:56','admin','2020-12-10 03:49:56','admin','1997-11-02','anna@gmail.com','anna','hot','anna','$2a$10$vdtCU3FobtJAGHLjlxn9L.EiK1bhThlskw5FblAe5Gn.iMm.Vd6hG','ROLE_USER'),(8,'2020-12-10 03:52:22','GOD','2020-12-10 03:52:22','GOD','1912-06-14','tommy@gmail.com','tommy','angelo','tommy','$2a$10$LIc6hFgWXIJgZ52PISyGaud6g03QKOen8oYMOnzH1.pHQBsA1D0My','ROLE_USER'),(9,'2020-12-10 03:53:37','GOD','2020-12-10 03:53:37','GOD','1981-09-07','antony@gmail.com','antony','manson','antony','$2a$10$LeXEnqhtstXLs0ISYvq7BOosFi34cvNdfGYzJ.WT8e8HV2fA0ddzi','ROLE_USER'),(10,'2020-12-10 03:54:34','GOD','2021-01-11 00:50:53','leeloo','2003-02-08','jill@gmail.com','jill','whatever','jill','$2a$10$pjQpSQW8DNgpYbnDXVyjzewFyr2/V63n6QmtoWpMUowWgSde/qaIi','ROLE_USER'),(11,'2021-01-03 21:11:47','GOD','2021-01-03 21:11:47','GOD','1997-11-02','anna2@gmail.com','anna','hot','anna2','$2a$10$VUGkBOcTdtcpaCA/mX5JtOWDCmfL2Gk3AMehC4r2cw/4E.WJ9lHOi','ROLE_USER'),(12,'2021-01-04 03:43:14','GOD','2021-01-04 06:03:49','leeloo','1997-11-09','anna3@gmail.com','anna','hot','anna3','$2a$10$2338NpADMY5i0R6rr6jVneCgN2s0tBIzc2e9ypoEiMcYiFYPyWLlW','ROLE_USER'),(13,'2021-01-04 06:34:08','GOD','2021-01-04 06:41:00','leeloo','1999-11-02','anna4@gmail.com','anna4','hot','anna4','$2a$10$7LwOuz2PTdUNCOXn9GvoS.1cJZLOEAN6ghPp2luMVgIJrJIaIqZAK','ROLE_USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;