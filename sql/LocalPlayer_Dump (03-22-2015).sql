-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: ser_sports
-- ------------------------------------------------------
-- Server version	5.6.22

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
-- Table structure for table `locaPlayerStatistics`
--

DROP TABLE IF EXISTS `locaPlayerStatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locaPlayerStatistics` (
  `localPlayerStatistics` int(11) NOT NULL AUTO_INCREMENT,
  `localPlayerID` int(11) NOT NULL,
  `team_name` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `game_date` date NOT NULL,
  `hitting_ab` int(11) DEFAULT NULL,
  `hitting_rbi` int(11) DEFAULT NULL,
  `pitching_era` int(11) DEFAULT NULL,
  `pitching_onbase_h` int(11) DEFAULT NULL,
  `pitching_onbase_s` int(11) DEFAULT NULL,
  `pitching_onbase_d` int(11) DEFAULT NULL,
  `pitching_onbase_t` int(11) DEFAULT NULL,
  `pitching_onbase_hr` int(11) DEFAULT NULL,
  `pitching_onbase_bb` int(11) DEFAULT NULL,
  `pitching_runs_earned` int(11) DEFAULT NULL,
  `pitching_runs_total` int(11) DEFAULT NULL,
  `pitching_outs_ktotal` int(11) DEFAULT NULL,
  `pitching_steal_caught` int(11) DEFAULT NULL,
  `pitching_steal_stolen` int(11) DEFAULT NULL,
  `pitching_games_play` int(11) DEFAULT NULL,
  `pitching_games_win` int(11) DEFAULT NULL,
  `pitching_games_loss` int(11) DEFAULT NULL,
  `pitching_games_save` int(11) DEFAULT NULL,
  `pitching_games_hold` int(11) DEFAULT NULL,
  `hitting_onbase_h` int(11) DEFAULT NULL,
  `hitting_onbase_s` int(11) DEFAULT NULL,
  `hitting_onbase_d` int(11) DEFAULT NULL,
  `hitting_onbase_t` int(11) DEFAULT NULL,
  `hitting_onbase_hr` int(11) DEFAULT NULL,
  `hitting_onbase_bb` int(11) DEFAULT NULL,
  `hitting_onbase_earned` int(11) DEFAULT NULL,
  `hitting_runs_earned` int(11) DEFAULT NULL,
  `hitting_runs_total` int(11) DEFAULT NULL,
  `hitting_outs_ktotal` int(11) DEFAULT NULL,
  `hitting_steal_caught` int(11) DEFAULT NULL,
  `hitting_steal_stolen` int(11) DEFAULT NULL,
  `hitting_games_play` int(11) DEFAULT NULL,
  `hitting_games_loss` int(11) DEFAULT NULL,
  `fielding_po` int(11) DEFAULT NULL,
  `fielding_error` int(11) DEFAULT NULL,
  `fielding_a` int(11) DEFAULT NULL,
  `fielding_fpct` float DEFAULT NULL,
  `fielding_games_play` int(11) DEFAULT NULL,
  `fielding_games_win` int(11) DEFAULT NULL,
  `fielding_games_loss` int(11) DEFAULT NULL,
  `hitting_games_win` int(11) DEFAULT NULL,
  PRIMARY KEY (`localPlayerStatistics`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locaPlayerStatistics`
--

LOCK TABLES `locaPlayerStatistics` WRITE;
/*!40000 ALTER TABLE `locaPlayerStatistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `locaPlayerStatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localPlayers`
--

DROP TABLE IF EXISTS `localPlayers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localPlayers` (
  `localPlayerId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`localPlayerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localPlayers`
--

LOCK TABLES `localPlayers` WRITE;
/*!40000 ALTER TABLE `localPlayers` DISABLE KEYS */;
/*!40000 ALTER TABLE `localPlayers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-22 17:13:31
