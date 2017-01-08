-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdconcesionario
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `clienteTipoUsuario_idx` (`tipo`),
  CONSTRAINT `clienteTipoUsuario` FOREIGN KEY (`tipo`) REFERENCES `tipousuarios` (`idtipoUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'254716','Angie ','Ramirez','6521478','calle 52','???<}????B?o???u',2),(2,'214526','Gabriel','Gonzales','5412587','calle 63','?K?? ?X3SS?9V*',2);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concesionarios`
--

DROP TABLE IF EXISTS `concesionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concesionarios` (
  `idConcesionario` int(11) NOT NULL AUTO_INCREMENT,
  `nit` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `direccion` varchar(25) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idConcesionario`),
  KEY `concesionarioTipoUsuario_idx` (`tipoUsuario`),
  CONSTRAINT `concesionarioTipoUsuario` FOREIGN KEY (`tipoUsuario`) REFERENCES `tipousuarios` (`idtipoUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concesionarios`
--

LOCK TABLES `concesionarios` WRITE;
/*!40000 ALTER TABLE `concesionarios` DISABLE KEYS */;
INSERT INTO `concesionarios` VALUES (1,214521,'Ultracar','2154785','calle 20','?y?^?1hF???',1),(2,915478,'Carmax','5214587','calle 98','nZX????oS??d',1),(3,548745,'Madiaautos','5124784','calle 10','???9e?????c??',1),(4,226369,'Karam','2014587','calle 96','D?HS?????&?_Ln',1),(5,845745,'Alemautos','9587454','calle 90','?%o???j?z5??&?f',1);
/*!40000 ALTER TABLE `concesionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventas`
--

DROP TABLE IF EXISTS `detalleventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventas` (
  `iddetalleVenta` int(11) NOT NULL,
  `codigoVehiculo` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddetalleVenta`),
  KEY `detalleVehiculos_idx` (`codigoVehiculo`),
  KEY `detalleVetasVentas_idx` (`idVenta`),
  CONSTRAINT `detalleVehiculos` FOREIGN KEY (`codigoVehiculo`) REFERENCES `vehiculos` (`codigoVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalleVetasVentas` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventas`
--

LOCK TABLES `detalleventas` WRITE;
/*!40000 ALTER TABLE `detalleventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'disponible'),(2,'deshabilitado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idPermiso` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `urlPermiso` varchar(100) NOT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuarios`
--

DROP TABLE IF EXISTS `tipousuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipousuarios` (
  `idtipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idtipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuarios`
--

LOCK TABLES `tipousuarios` WRITE;
/*!40000 ALTER TABLE `tipousuarios` DISABLE KEYS */;
INSERT INTO `tipousuarios` VALUES (1,'Concesionario'),(2,'Cliente');
/*!40000 ALTER TABLE `tipousuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariospermisos`
--

DROP TABLE IF EXISTS `usuariospermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariospermisos` (
  `idTipoUsuario` int(11) NOT NULL,
  `idPermiso` int(11) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`,`idPermiso`),
  KEY `usuarioPermisiso_idx` (`idPermiso`),
  CONSTRAINT `usuarioPermisiso` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarioTipoUsuario` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuarios` (`idtipoUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariospermisos`
--

LOCK TABLES `usuariospermisos` WRITE;
/*!40000 ALTER TABLE `usuariospermisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariospermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculos` (
  `codigoVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(10) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(95) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `idConcesionario` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  PRIMARY KEY (`codigoVehiculo`),
  KEY `vehiculosEstado_idx` (`idEstado`),
  KEY `vehiculosConsesionarios_idx` (`idConcesionario`),
  CONSTRAINT `vehiculosConsesionarios` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionarios` (`idConcesionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vehiculosEstado` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'ghj-875','Audi','Q8',85000000,2,1),(2,'fre-201','BMW','Roadster',95000000,3,1),(3,'tyu-587','Chevrolet','Cruze Hatchback 2017',82000000,1,1),(4,'cvb-521','Chevrolet','Spark GT RS',34000000,1,1),(5,'dfg-254','Chevrolet','Sonic Sedán 2017',44000000,2,1),(6,'tyu-547','Citroën','C3',80000000,3,1);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `fecha` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `ventasClientes_idx` (`idCliente`),
  CONSTRAINT `ventasClientes` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdconcesionario'
--

--
-- Dumping routines for database 'bdconcesionario'
--
/*!50003 DROP FUNCTION IF EXISTS `guardarContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `guardarContrasena`(contra VARCHAR(45)) RETURNS varchar(45) CHARSET latin1
BEGIN
DECLARE resultado VARCHAR(45);
SET resultado = (SELECT AES_ENCRYPT('fenixcontra202',contra));
RETURN resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-08 13:12:29
