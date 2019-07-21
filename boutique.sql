/*
SQLyog Community- MySQL GUI v8.3 Beta1
MySQL - 5.0.24-community-nt : Database - boutique
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`boutique` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `boutique`;

/*Table structure for table `barrio` */

DROP TABLE IF EXISTS `barrio`;

CREATE TABLE `barrio` (
  `idBarrio` int(10) NOT NULL auto_increment,
  `nombarrio` varchar(20) default NULL,
  PRIMARY KEY  (`idBarrio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `barrio` */

insert  into `barrio`(`idBarrio`,`nombarrio`) values (1,'loslaureles');

/*Table structure for table `ciudad` */

DROP TABLE IF EXISTS `ciudad`;

CREATE TABLE `ciudad` (
  `idciudad` int(10) NOT NULL auto_increment,
  `Nomciudad` varchar(30) default NULL,
  PRIMARY KEY  (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ciudad` */

insert  into `ciudad`(`idciudad`,`Nomciudad`) values (1,'asuncion');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idcliente` int(10) NOT NULL auto_increment,
  `ruc` varchar(20) default NULL,
  `email` varchar(20) default NULL,
  `nombre` varchar(30) default NULL,
  `apellido` varchar(30) default NULL,
  `documento` varchar(20) default NULL,
  `celular` varchar(30) default NULL,
  PRIMARY KEY  (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idcliente`,`ruc`,`email`,`nombre`,`apellido`,`documento`,`celular`) values (1,'123456677','m@m.gmail.com','justino','saucedo','12345566','12345676'),(3,'123456677','m@m.gmail.com','Manuel','saucedo','12345566','12345676');

/*Table structure for table `detalle` */

DROP TABLE IF EXISTS `detalle`;

CREATE TABLE `detalle` (
  `idDetalle` int(10) NOT NULL auto_increment,
  `factura_idfactura` int(10) NOT NULL,
  `producto_idproducto` int(10) NOT NULL,
  `descuento` double default NULL,
  `totalventa` double default NULL,
  PRIMARY KEY  (`idDetalle`),
  KEY `Detalle_FKIndex1` (`producto_idproducto`),
  KEY `Detalle_FKIndex2` (`factura_idfactura`),
  CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`factura_idfactura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detalle` */

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `idfactura` int(10) NOT NULL auto_increment,
  `usuario_idusuario` int(10) NOT NULL,
  `cliente_idcliente` int(10) NOT NULL,
  `numero_fac` varchar(100) default NULL,
  `fecha` date default NULL,
  `estado` varchar(30) default NULL,
  `subtotal` int(10) default NULL,
  `iva` int(10) default NULL,
  `totalfactura` int(10) default NULL,
  PRIMARY KEY  (`idfactura`),
  KEY `factura_FKIndex1` (`cliente_idcliente`),
  KEY `factura_FKIndex2` (`usuario_idusuario`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `factura` */

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `idmarca` int(10) NOT NULL auto_increment,
  `descripcion` varchar(30) default NULL,
  `marca` varchar(50) default NULL,
  PRIMARY KEY  (`idmarca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `marca` */

insert  into `marca`(`idmarca`,`descripcion`,`marca`) values (1,'test','Prueba2'),(2,'test','Prueba2'),(3,'test','Prueba1');

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `idPais` int(10) unsigned NOT NULL auto_increment,
  `NomPais` varchar(30) default NULL,
  PRIMARY KEY  (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pais` */

insert  into `pais`(`idPais`,`NomPais`) values (1,'paraguay');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `idpersona` int(10) NOT NULL auto_increment,
  `Barrio_idBarrio` int(10) NOT NULL,
  `Ciudad_idciudad` int(10) NOT NULL,
  `Pais_idPais` int(10) unsigned NOT NULL,
  `nombre` varchar(30) default NULL,
  `apellido` varchar(30) default NULL,
  `documento` varchar(30) default NULL,
  `celular` varchar(30) default NULL,
  PRIMARY KEY  (`idpersona`),
  KEY `Persona_FKIndex1` (`Pais_idPais`),
  KEY `Persona_FKIndex2` (`Ciudad_idciudad`),
  KEY `Persona_FKIndex3` (`Barrio_idBarrio`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`Pais_idPais`) REFERENCES `pais` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`Ciudad_idciudad`) REFERENCES `ciudad` (`idciudad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persona_ibfk_3` FOREIGN KEY (`Barrio_idBarrio`) REFERENCES `barrio` (`idBarrio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`idpersona`,`Barrio_idBarrio`,`Ciudad_idciudad`,`Pais_idPais`,`nombre`,`apellido`,`documento`,`celular`) values (1,1,1,1,'justin','saucedo','1234567','1234567');

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `idproducto` int(10) NOT NULL auto_increment,
  `marca_idmarca` int(10) NOT NULL,
  `Nombre` varchar(30) default NULL,
  `modelo` varchar(30) default NULL,
  `cantidad` int(30) unsigned default NULL,
  `precio` int(30) unsigned default NULL,
  PRIMARY KEY  (`idproducto`),
  KEY `producto_FKIndex1` (`marca_idmarca`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`marca_idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`idproducto`,`marca_idmarca`,`Nombre`,`modelo`,`cantidad`,`precio`) values (1,1,'prueba',NULL,NULL,NULL),(2,3,'prueba2',NULL,50,100000),(3,2,'Remeras',NULL,49,2222),(4,1,'asdsaa','ddasd2',222,2222);

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `idproveedor` int(10) NOT NULL auto_increment,
  `Persona_idpersona` int(10) NOT NULL,
  `nomproveedor` varchar(20) default NULL,
  PRIMARY KEY  (`idproveedor`),
  KEY `proveedor_FKIndex1` (`Persona_idpersona`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`Persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proveedor` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idusuario` int(10) NOT NULL auto_increment,
  `Persona_idpersona` int(10) NOT NULL,
  `login` varchar(30) default NULL,
  `pass` varchar(30) default NULL,
  `acceso` varchar(30) default NULL,
  `fecha_ingreso` date default NULL,
  `estado` varchar(30) default NULL,
  PRIMARY KEY  (`idusuario`),
  KEY `usuario_FKIndex1` (`Persona_idpersona`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`Persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`idusuario`,`Persona_idpersona`,`login`,`pass`,`acceso`,`fecha_ingreso`,`estado`) values (1,1,'justin','123','Administrador',NULL,'A');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
