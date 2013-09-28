CREATE DATABASE  IF NOT EXISTS `helenafranca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `helenafranca`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: helenafranca
-- ------------------------------------------------------
-- Server version	5.6.11-log

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
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artista` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nomeArtistico` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `codigoUsuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK3791A1DA489C6000` (`codigoUsuario`),
  CONSTRAINT `FK3791A1DA489C6000` FOREIGN KEY (`codigoUsuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (1,'(51) 5151-5151','helena.fran13@gmail.com','http://localhost:8081/imagensHelenaFranca/img1377549692783.jpg','Maria Helena de França Silva','Helena França','(51) 5151-5151',1);
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biografia`
--

DROP TABLE IF EXISTS `biografia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biografia` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `texto` longtext,
  `titulo` varchar(255) DEFAULT NULL,
  `codigoArtista` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK398DA701248D98` (`codigoArtista`),
  CONSTRAINT `FK398DA701248D98` FOREIGN KEY (`codigoArtista`) REFERENCES `artista` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biografia`
--

LOCK TABLES `biografia` WRITE;
/*!40000 ALTER TABLE `biografia` DISABLE KEYS */;
INSERT INTO `biografia` VALUES (1,'Eu sou a Helena França.','Helena França',1);
/*!40000 ALTER TABLE `biografia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `codigo` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Abstrato'),(2,'Animais'),(3,'Florais'),(4,'Paisagens'),(5,'Pessoas'),(6,'Natureza Morta'),(7,'Releitura');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `foto` varchar(255) DEFAULT NULL,
  `codigoBiografia` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK300D04CEC5584` (`codigoBiografia`),
  CONSTRAINT `FK300D04CEC5584` FOREIGN KEY (`codigoBiografia`) REFERENCES `biografia` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (1,'http://localhost:8081/imagensHelenaFranca/img1375397048278.jpg',1),(2,'http://localhost:8081/imagensHelenaFranca/img1375397004820.jpg',1),(3,'http://localhost:8081/imagensHelenaFranca/img1375397383734.jpg',1),(4,'http://localhost:8081/imagensHelenaFranca/img1375232234834.jpg',1),(5,'http://localhost:8081/imagensHelenaFranca/img1377550665214.jpg',1);
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postagem`
--

DROP TABLE IF EXISTS `postagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postagem` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` varchar(255) DEFAULT NULL,
  `hora` varchar(255) DEFAULT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `texto` longtext,
  `titulo` varchar(255) DEFAULT NULL,
  `codigoArtista` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK2D24EFEE1248D98` (`codigoArtista`),
  CONSTRAINT `FK2D24EFEE1248D98` FOREIGN KEY (`codigoArtista`) REFERENCES `artista` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postagem`
--

LOCK TABLES `postagem` WRITE;
/*!40000 ALTER TABLE `postagem` DISABLE KEYS */;
INSERT INTO `postagem` VALUES (14,'2013-01-01','17:20:00','http://localhost:8081/imagensHelenaFranca/img1376338427735.jpg','e tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tal','A lula',1),(15,'2013-08-07','17:55','http://localhost:8081/imagensHelenaFranca/img1376338062258.jpg','Teste','Teste',1),(16,'2013-08-07','17:56','http://localhost:8081/imagensHelenaFranca/img1375908998770.jpg','Teste 2 e tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tale tal','Teste 2',1),(17,'2013-08-12','17:47','http://localhost:8081/imagensHelenaFranca/img1376340420706.jpg','Terminei!! Uhuu!!!','Final do manter postagem',1),(18,'2013-08-21','17:51','http://localhost:8081/imagensHelenaFranca/img1377118332721.jpg','Aweeeeeeeeeeeeeee!!!!!!!!!','Terminei o Manter SlideShow',1);
/*!40000 ALTER TABLE `postagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quadro`
--

DROP TABLE IF EXISTS `quadro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quadro` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `altura` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `largura` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `peso` varchar(255) DEFAULT NULL,
  `preco` varchar(255) DEFAULT NULL,
  `codigoArtista` bigint(20) DEFAULT NULL,
  `codigoCategoria` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKC771F9C4C064630A` (`codigoCategoria`),
  KEY `FKC771F9C41248D98` (`codigoArtista`),
  CONSTRAINT `FKC771F9C41248D98` FOREIGN KEY (`codigoArtista`) REFERENCES `artista` (`codigo`),
  CONSTRAINT `FKC771F9C4C064630A` FOREIGN KEY (`codigoCategoria`) REFERENCES `categoria` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quadro`
--

LOCK TABLES `quadro` WRITE;
/*!40000 ALTER TABLE `quadro` DISABLE KEYS */;
INSERT INTO `quadro` VALUES (1,'100','http://localhost:8081/imagensHelenaFranca/img1375232234834.jpg','100','Fazenda','00.50','150.0',1,4),(2,'100','http://localhost:8081/imagensHelenaFranca/img1377551013060.jpg','100','Baiana','12.31','123.12',1,5),(3,'100','http://localhost:8081/imagensHelenaFranca/img1375727992365.jpg','100','Abstrato','23.42','234.32',1,1),(4,'100','http://localhost:8081/imagensHelenaFranca/img1375232469481.jpg','100','Morenas','51.51','515.15',1,5),(5,'100','http://localhost:8081/imagensHelenaFranca/img1375727956200.jpg','100','Copos de leite','15.15','515.15',1,3);
/*!40000 ALTER TABLE `quadro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slideshow`
--

DROP TABLE IF EXISTS `slideshow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slideshow` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigoArtista` bigint(20) DEFAULT NULL,
  `codigoQuadro` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKD0864C4E1248D98` (`codigoArtista`),
  KEY `FKD0864C4E3F29B564` (`codigoQuadro`),
  CONSTRAINT `FKD0864C4E1248D98` FOREIGN KEY (`codigoArtista`) REFERENCES `artista` (`codigo`),
  CONSTRAINT `FKD0864C4E3F29B564` FOREIGN KEY (`codigoQuadro`) REFERENCES `quadro` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slideshow`
--

LOCK TABLES `slideshow` WRITE;
/*!40000 ALTER TABLE `slideshow` DISABLE KEYS */;
INSERT INTO `slideshow` VALUES (1,1,4),(2,1,2),(3,1,3),(4,1,1),(5,1,5);
/*!40000 ALTER TABLE `slideshow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Ativo'),(2,'Inativo');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipousuario` (
  `codigo` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'Artista'),(2,'Cliente');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `codigoStatus` bigint(20) DEFAULT NULL,
  `codigoTipoUsuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK5B4D8B0E45E161C0` (`codigoStatus`),
  KEY `FK5B4D8B0EF99E5A78` (`codigoTipoUsuario`),
  CONSTRAINT `FK5B4D8B0E45E161C0` FOREIGN KEY (`codigoStatus`) REFERENCES `status` (`codigo`),
  CONSTRAINT `FK5B4D8B0EF99E5A78` FOREIGN KEY (`codigoTipoUsuario`) REFERENCES `tipousuario` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'helenaadmin','7da0c94cee7a66519581a64813dc0ab2',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-28 11:22:11
