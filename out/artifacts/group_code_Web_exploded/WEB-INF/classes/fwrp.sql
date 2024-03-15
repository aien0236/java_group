-- MySQL Script generated by MySQL Workbench
-- Fri Mar 15 10:29:22 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema FWRP
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FWRP
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FWRP` DEFAULT CHARACTER SET utf8 ;
USE `FWRP` ;

-- -----------------------------------------------------
-- Table `FWRP`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FWRP`.`user` ;

CREATE TABLE IF NOT EXISTS `FWRP`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `usertype` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FWRP`.`consumers_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FWRP`.`consumers_inventory` ;

CREATE TABLE IF NOT EXISTS `FWRP`.`consumers_inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `food_name` VARCHAR(50) NULL,
  `expiration_date` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FWRP`.`organization_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FWRP`.`organization_inventory` ;

CREATE TABLE IF NOT EXISTS `FWRP`.`organization_inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `food_name` VARCHAR(50) NULL,
  `expiration_date` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FWRP`.`retailer_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FWRP`.`retailer_inventory` ;

CREATE TABLE IF NOT EXISTS `FWRP`.`retailer_inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `food_name` VARCHAR(50) NULL,
  `expiration_date` VARCHAR(50) NULL,
  `flag` VARCHAR(50) NULL,
  `price` VARCHAR(50) NULL,
  `discount` VARCHAR(50) NULL,
  `foodtype` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FWRP`.`subscription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FWRP`.`subscription` ;

CREATE TABLE IF NOT EXISTS `FWRP`.`subscription` (
  `user_id` INT NOT NULL,
  `subscriber_name` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  `phone` VARCHAR(50) NULL,
  `food_preference` VARCHAR(50) NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_subscription_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `FWRP`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
