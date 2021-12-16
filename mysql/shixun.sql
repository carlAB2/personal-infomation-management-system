-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: shixun
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `birth` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `work_place` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id_idx` (`group_id`),
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'John','18573774947','jm18573774947@163.com','7.12','ysp','school','he is so cool',1),(2,'Turbine','17873475491','1097076568@qq.com','9.21','衡阳','hnit','he is so  handsome',2),(4,'Turbine','17873475491','1097076568@qq.com','9.21','衡阳','hnit','he is so  handsome',2),(6,'Tom','17872674548','2380668366@qq.com','1995.05.08','长沙','坡子街派出所','he si a police',2),(7,'Jeff','18374182480','1457643523@qq.com','2000.07.08','永州','九嶷山旅游公司','he is of great stature',2);
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diary`
--

DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `weather` varchar(45) DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `about_place` varchar(180) DEFAULT NULL,
  `about_people` varchar(180) DEFAULT NULL,
  `happening` varchar(9000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES (1,'sun','2021-12-09 21:22:18','school','','I code database project all day'),(3,'rainy','2021-12-10 21:22:18','学校','John','watch soccer games'),(4,'sunny','2021-12-15 10:11:15','bedroom',NULL,'work for DatabaseSystem'),(5,'cloud','2021-12-15 13:11:12','school','John','It is clear that even though we may have spent years writing computer code, we are still much better at English.  Coding in an unnatural language can be costly.  Any programmer knows that writing code is just the beginning.  This code needs to be documented, debugged, maintained, and refactored.  The unnatural nature of the code requires a lot of effort and time to understand the logic of the code.  Training other developers to use the code is even more demanding.  Using public apis (or company-wide apis) presents greater documentation and training challenges.  If we can code in English. '),(6,'rain','2021-12-15 13:52:22','school','John','这几天有些空闲，在做一个缩略词的词典。\n\n　　要用到swing，也是许久没有写过swing构件的代码了，对于swing这把刀已经感觉很生疏了。\n\n　　要用到一个文本显示区，为了便于复制，我用了JTextArea。JTextArea本身默认的是不换行，不滚动条显示。你设置完他的大小之后，他就只是显示在这个窗口大小内的内容。\n\n　　换行\n\n　　这个实现起来比较容易：　　\n\n1         JTextArea textAreaOutput;\n2         textAreaOutput = new JTextArea(\"缩略词词典\", 20, 43);\n3         textAreaOutput.setSelectedTextColor(Color.RED);\n4         textAreaOutput.setLineWrap(true);        //激活自动换行功能 \n5         textAreaOutput.setWrapStyleWord(true);            // 激活断行不断字功能\n　　这样子，无论是TextArea还是JTextArea都可以正常的进行换行了。\n\n　　滚动条\n\n　　实现起来，在TextArea和JTextArea中有所区别：\n\n　　TextArea：　　\n\n1         TextArea textArea；\n2         textAreaOutput = new JTextArea(\"缩略词词典\", 20, 43, TextArea.SCROLLBARS_VERTICAL_ONLY);\n　　JTextArea：\n\n    JTextArea textAreaOutput;\n    JPanel panelOutput;\n\n    panelOutput = new JPanel();\n    panelOutput.add(new JScrollPane(textAreaOutput));\n　　有人曾说swing是一把刀（http://www.iteye.com/topic/699515），这把刀平时可能用不着，比如专注于java web的monkey们，但是不免有时候需要一个小程序来帮助我们进行大项目的开发，这时候，swing可能就会用到了。当然不是个文本换行的小儿科问题。所以，我感觉swing这把刀一定要随时的能上手，不能让他锈太久。');
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`gname`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (4,'colleagues'),(1,'family'),(2,'friends'),(10,'schoolmates'),(11,'teachers');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` float NOT NULL COMMENT '单位：元',
  `type_id` int DEFAULT NULL,
  `info` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_id_idx` (`type_id`),
  CONSTRAINT `income_fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (2,'2021-12-15 06:12:38',200,NULL,'sister give me'),(3,'2021-12-15 07:08:24',20,2,'friends return me'),(4,'2021-12-15 11:33:05',5,3,'Meituan cashback'),(23,'2021-12-14 14:48:05',2000,NULL,'the money is come so easy');
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `income_AFTER_INSERT` AFTER INSERT ON `income` FOR EACH ROW BEGIN
	#DECLARE ta_max_id int DEFAULT 0;
    DECLARE total_2 float default 1;
    
    DECLARE info_2 varchar(360) DEFAULT null;
    DECLARE type_id int DEFAULT 0;
    
	#SELECT MAX(id) INTO ta_max_id  FROM shixun.total_amount;
    SELECT total INTO total_2 FROM shixun.total_amount WHERE id=(
		SELECT MAX(id) FROM shixun.total_amount
    );
    IF NEW.type_id IS NOT NULL THEN
		SET type_id = NEW.type_id;
        IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('income type: ',(SELECT type FROM shixun.type WHERE id=type_id) ,'\n' ,NEW.info);
		ELSE
			SET info_2 = concat('income type: ',(SELECT type FROM shixun.type WHERE id=type_id));
		END IF;
	ELSE 
		IF NEW.info IS NOT NULL THEN
			SET info_2 = new.info;
		ELSE 
			SET info_2 = null;
        END IF;
    END IF;
    
    SET total_2=total_2+NEW.amount;
	INSERT INTO shixun.total_amount VALUES(null,now(),total_2,info_2);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `income_AFTER_UPDATE` AFTER UPDATE ON `income` FOR EACH ROW BEGIN
	DECLARE total_2 float default 1;
    declare info_2 varchar(360);
    declare type_id int default 0;
    declare amount_i int default 0;
    
    SELECT total INTO total_2 FROM shixun.total_amount WHERE id=(
		SELECT MAX(id) FROM shixun.total_amount
    );
    
    IF NEW.type_id IS NOT NULL THEN
		SET type_id = NEW.type_id;
        IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('update\n','income type: ',(SELECT type FROM shixun.type WHERE id=type_id) ,'\n' ,NEW.info);
		ELSE
			SET info_2 = concat('update\n','income type: ',(SELECT type FROM shixun.type WHERE id=type_id));
		END IF;
	ELSE 
		IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('update\n',NEW.info);
		ELSE 
			SET info_2 = null;
        END IF;
    END IF;
    
    set amount_i = new.amount-old.amount;
    if amount_i<>0 then
		set total_2 = total_2+amount_i;
        if total_2 < 0 then
			set total_2 = 0;
		end if;
        INSERT INTO shixun.total_amount VALUES(null,now(),total_2,info_2);
	end if;
    
    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pay_bills`
--

DROP TABLE IF EXISTS `pay_bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_bills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` float NOT NULL COMMENT '单位：元',
  `type_id` int DEFAULT NULL,
  `info` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_id_idx` (`type_id`),
  CONSTRAINT `pay_bills_fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_bills`
--

LOCK TABLES `pay_bills` WRITE;
/*!40000 ALTER TABLE `pay_bills` DISABLE KEYS */;
INSERT INTO `pay_bills` VALUES (1,'2021-12-14 18:25:49',12,NULL,'eat dinner'),(2,'2021-12-15 11:06:32',15,4,NULL),(3,'2021-12-14 11:10:45',14,5,'eat lunch');
/*!40000 ALTER TABLE `pay_bills` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `pay_bills_AFTER_INSERT` AFTER INSERT ON `pay_bills` FOR EACH ROW BEGIN
	DECLARE ta_max_id int DEFAULT 0;
    DECLARE total_2 float DEFAULT 1;
    DECLARE info_2 varchar(360) DEFAULT null;
    DECLARE type_id_2 int DEFAULT 0;
    
    SET ta_max_id = (SELECT MAX(id) FROM shixun.total_amount);
    SET total_2 = (SELECT total FROM shixun.total_amount WHERE id=ta_max_id);
	
    IF NEW.type_id IS NOT NULL THEN
		SET type_id_2 = NEW.type_id;
        IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('pay type: ',(SELECT type FROM shixun.type WHERE id=type_id_2),'\n',NEW.info);
		ELSE
			SET info_2 = concat('pay type: ',(SELECT type FROM shixun.type WHERE id=type_id_2));
		END IF;
	ELSE 
		IF NEW.info IS NOT NULL THEN
			SET info_2 = NEW.info;
		ELSE 
			SET info_2 = null;
        END IF;
    END IF;
    
    IF NEW.amount>total_2 THEN 
		SET total_2 = 0;
	ELSE
		SET total_2 = total_2 - NEW.amount;
    END IF;

	INSERT INTO shixun.total_amount VALUES(null,now(),total_2,info_2);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `pay_bills_AFTER_UPDATE` AFTER UPDATE ON `pay_bills` FOR EACH ROW BEGIN
	DECLARE total_2 float default 1;
    declare info_2 varchar(360);
    declare type_id int default 0;
    declare amount_i int default 0;
    
    SELECT total INTO total_2 FROM shixun.total_amount WHERE id=(
		SELECT MAX(id) FROM shixun.total_amount
    );
    
    IF NEW.type_id IS NOT NULL THEN
		SET type_id = NEW.type_id;
        IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('update\n','pay type: ',(SELECT type FROM shixun.type WHERE id=type_id) ,'\n' ,NEW.info);
		ELSE
			SET info_2 = concat('update\n','pay type: ',(SELECT type FROM shixun.type WHERE id=type_id));
		END IF;
	ELSE 
		IF NEW.info IS NOT NULL THEN
			SET info_2 = concat('update\n',NEW.info);
		ELSE 
			SET info_2 = null;
        END IF;
    END IF;
    
    set amount_i = new.amount-old.amount;
    if amount_i <> 0 then
		set total_2 = total_2-amount_i;
        if total_2<0 then
			set total_2=0;
		end if;
        
        INSERT INTO shixun.total_amount VALUES(null,now(),total_2,info_2);
	end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(180) DEFAULT NULL,
  `place` varchar(180) DEFAULT NULL,
  `event` varchar(1200) DEFAULT NULL,
  `should_complete_time` datetime DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '1 ready to do\n2 doing\n3 already complete',
  PRIMARY KEY (`id`),
  CONSTRAINT `todo_chk_1` CHECK ((`status` in (1,2,3)))
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
INSERT INTO `todo` VALUES (1,'2021-12-09 21:01:39','eat dinnner','润泽食堂','','2021-12-09 19:00:00',3),(2,'2021-12-10 20:09:07','eat dinnner','bedroom','','2021-12-10 22:00:00',2),(3,'2021-12-13 17:50:46','看小说','图书馆','read a song of ice and fire','2021-12-20 00:00:00',1),(4,'2021-12-13 17:50:46','实训','计算机楼','元辰实训','2021-12-15 00:00:00',1),(5,'2021-12-13 17:50:46','看球赛','南操','狗裁收了多少钱','2021-12-16 00:00:00',1),(6,'2021-12-13 17:50:46','grade of enlish','do\'nt know yet','have a exam','2021-12-18 00:00:00',2),(7,'2021-12-13 17:50:46','欧冠',NULL,'2021-2022赛季季欧冠','2021-12-25 00:00:00',1),(8,'2021-12-13 17:50:46','欧冠',NULL,'2021-2022赛季季欧冠','2021-12-30 00:00:00',1),(9,'2021-12-13 17:50:46','studying','bedroom','learn spring boot','2021-12-20 00:00:00',1),(10,'2021-12-13 17:50:46','watch show','bedroom','F','2021-12-22 00:00:00',1),(11,'2021-12-13 17:50:46','eat dinner','外卖','bedroom','2021-12-13 20:00:00',1),(12,'2021-12-13 17:50:46','go to toilet','you know','gogogo','2021-12-13 17:50:46',1),(13,'2021-12-13 17:50:46','go home','far away','leave school,go home','2021-01-01 12:00:00',1),(16,'2021-12-13 17:56:25','test_done','do','I doing test','2021-12-13 17:56:25',3),(17,'2021-12-13 17:56:25','test1','do','I doing test','2021-12-13 17:56:25',3),(18,'2021-12-14 11:27:16','eat lunch','bedroom','work for database','2021-12-15 11:28:21',1),(22,'2021-12-15 11:36:51','shixun','school','shixun of database','2021-12-15 00:00:00',1),(24,'2021-12-15 11:48:33','1','1','1','2021-12-15 00:00:00',1),(25,'2021-12-15 12:06:35','2','2','2','2021-12-15 00:00:00',1);
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_amount`
--

DROP TABLE IF EXISTS `total_amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `total_amount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '单位：元',
  `total` float NOT NULL,
  `info` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_amount`
--

LOCK TABLES `total_amount` WRITE;
/*!40000 ALTER TABLE `total_amount` DISABLE KEYS */;
INSERT INTO `total_amount` VALUES (1,'2021-12-10 14:53:25',0,'start'),(35,'2021-12-14 14:48:05',2000,'the money is come so easy'),(36,'2021-12-14 14:48:05',1000,'buy a computer'),(37,'2021-12-15 10:39:09',988,'eat dinner'),(38,'2021-12-15 12:34:30',1188,'sister give me'),(39,'2021-12-15 12:34:30',1208,'income type: buy goods\nfriends return me'),(40,'2021-12-15 12:34:30',1213,'income type: eat\nMeituan cashback'),(41,'2021-12-15 12:35:05',1198,'pay type: from family'),(42,'2021-12-15 12:35:05',1184,'pay type: Take-away cashback\neat lunch');
/*!40000 ALTER TABLE `total_amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(180) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (2,'buy goods'),(3,'eat'),(1,'food'),(4,'from family'),(5,'Take-away cashback');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shixun'
--

--
-- Dumping routines for database 'shixun'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 14:29:16
