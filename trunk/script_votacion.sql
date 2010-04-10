/*
SQLyog Community v8.4 Beta1
MySQL - 5.1.45-community : Database - db_voto
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_voto` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_voto`;

/*Table structure for table `tb_candidato` */

DROP TABLE IF EXISTS `tb_candidato`;

CREATE TABLE `tb_candidato` (
  `cod_persona` varchar(7) NOT NULL,
  `cod_proceso` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cod_persona`,`cod_proceso`),
  KEY `tb_persona_has_tb_proceso_FKIndex1` (`cod_persona`),
  KEY `tb_persona_has_tb_proceso_FKIndex2` (`cod_proceso`),
  CONSTRAINT `tb_candidato_ibfk_1` FOREIGN KEY (`cod_persona`) REFERENCES `tb_persona` (`cod_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_candidato_ibfk_2` FOREIGN KEY (`cod_proceso`) REFERENCES `tb_proceso` (`cod_proceso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_candidato` */

insert  into `tb_candidato`(`cod_persona`,`cod_proceso`) values ('u913694',1),('u920858',1),('u920900',1),('u921134',1);

/*Table structure for table `tb_persona` */

DROP TABLE IF EXISTS `tb_persona`;

CREATE TABLE `tb_persona` (
  `cod_persona` varchar(7) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `ape_paterno` varchar(45) DEFAULT NULL,
  `ape_materno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_persona` */

insert  into `tb_persona`(`cod_persona`,`nombre`,`ape_paterno`,`ape_materno`) values ('u913694','CARLOS MOISES','ZUÑIGA','RODRIGUEZ'),('u920858','JOEL FELIX','GAVILAN','REYNOSO'),('u920900','ALVARO','MILLONES','QUIROZ'),('u920942','DENISSE JENNYFER','FLORES','ESPINOZA'),('u920962','RAFAEL RICARDO','LEIVA','GUERRA'),('u921123','JOSE IVAN','VILLANES','CORRALES'),('u921134','MIGUEL ANGEL','VILLAFUERTE','NUÑEZ'),('u921212','JESUS ROBINSON','CRUZ','MONROY');

/*Table structure for table `tb_proceso` */

DROP TABLE IF EXISTS `tb_proceso`;

CREATE TABLE `tb_proceso` (
  `cod_proceso` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `estado_jornada` int(10) unsigned DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_proceso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_proceso` */

insert  into `tb_proceso`(`cod_proceso`,`nombre`,`estado_jornada`,`fecha`) values (1,'Elección del Delegado de Base de Datos',0,'17/05/2010'),(2,'Elección del Delegado de Calculo',0,'17/05/2010'),(3,'Elección del Delegado de Liderazgo',0,'17/05/2010');

/*Table structure for table `tb_usuario` */

DROP TABLE IF EXISTS `tb_usuario`;

CREATE TABLE `tb_usuario` (
  `cod_persona` varchar(7) NOT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `passwod` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_persona`),
  KEY `tb_usuario_FKIndex1` (`cod_persona`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`cod_persona`) REFERENCES `tb_persona` (`cod_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_usuario` */

insert  into `tb_usuario`(`cod_persona`,`usuario`,`passwod`) values ('u920942','u920942','u920942'),('u920962','u920962','u920962'),('u921123','u921123','u921123'),('u921212','u921212','u921212');

/*Table structure for table `tb_voto` */

DROP TABLE IF EXISTS `tb_voto`;

CREATE TABLE `tb_voto` (
  `cod_proceso` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cod_elector` varchar(7) NOT NULL,
  `cod_candidato` varchar(7) DEFAULT NULL,
  `estado_voto` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`cod_proceso`,`cod_elector`),
  KEY `tb_voto_FKIndex1` (`cod_proceso`),
  KEY `tb_voto_FKIndex2` (`cod_elector`),
  KEY `tb_voto_FKIndex3` (`cod_candidato`),
  CONSTRAINT `tb_voto_ibfk_1` FOREIGN KEY (`cod_proceso`) REFERENCES `tb_proceso` (`cod_proceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_voto_ibfk_2` FOREIGN KEY (`cod_elector`) REFERENCES `tb_persona` (`cod_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_voto_ibfk_3` FOREIGN KEY (`cod_candidato`) REFERENCES `tb_persona` (`cod_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tb_voto` */

insert  into `tb_voto`(`cod_proceso`,`cod_elector`,`cod_candidato`,`estado_voto`) values (1,'u913694',NULL,0),(1,'u920900',NULL,0),(1,'u920942',NULL,0),(1,'u920962',NULL,0),(1,'u921212',NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
