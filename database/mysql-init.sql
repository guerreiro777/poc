SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


DROP SCHEMA IF EXISTS `cateno` ;


CREATE SCHEMA IF NOT EXISTS `cateno` DEFAULT CHARACTER SET utf8 ;
USE `cateno` ;


DROP TABLE IF EXISTS `cateno`.`requisicao` ;

CREATE TABLE IF NOT EXISTS `cateno`.`requisicao` (
 `id_requisicao` INT NOT NULL AUTO_INCREMENT,
 `dt_requisicao` text NOT NULL,
 `dt_cotacao` text NOT NULL,
 `vl_compra` text NOT NULL,
 `vl_venda` text NOT NULL,
 `dt_hora_cotacao` text NOT NULL,
 PRIMARY KEY (`id_requisicao`));
