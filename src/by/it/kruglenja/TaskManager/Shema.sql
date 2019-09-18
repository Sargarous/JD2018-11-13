-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TaskManager
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `TaskManager` ;

-- -----------------------------------------------------
-- Schema TaskManager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TaskManager` DEFAULT CHARACTER SET utf8 ;
USE `TaskManager` ;

-- -----------------------------------------------------
-- Table `TaskManager`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskManager`.`Roles` ;

CREATE TABLE IF NOT EXISTS `TaskManager`.`Roles` (
  `id` INT NOT NULL,
  `roleName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskManager`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskManager`.`Users` ;

CREATE TABLE IF NOT EXISTS `TaskManager`.`Users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `userPassword` VARCHAR(45) NULL,
  `userEmail` VARCHAR(45) NULL,
  `Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Roles_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskManager`.`ProjectList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskManager`.`ProjectList` ;

CREATE TABLE IF NOT EXISTS `TaskManager`.`ProjectList` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `projectSrart` TIMESTAMP NULL,
  `projectRedLine` TIMESTAMP NULL,
  `projectDeadLine` TIMESTAMP NULL,
  `projectTimeLeft` TIMESTAMP NULL,
  `Users_id` INT UNSIGNED NOT NULL,
  `Users_Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Users_id`, `Users_Roles_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskManager`.`Tasks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskManager`.`Tasks` ;

CREATE TABLE IF NOT EXISTS `TaskManager`.`Tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `taskName` VARCHAR(195) NULL,
  `taskDescription` VARCHAR(255) NULL,
  `taskStartTime` TIMESTAMP NULL,
  `taskRedLine` TIMESTAMP NULL,
  `taskDeadLine` TIMESTAMP NULL,
  `taskTimeLeftToRedLine` TIMESTAMP NULL,
  `taskTimeLeftToDeadLine` VARCHAR(45) NULL,

  `ProjectList_id` INT UNSIGNED NOT NULL,
  `ProjectList_Users_id` INT UNSIGNED NOT NULL,
  `ProjectList_Users_Roles_id` INT NOT NULL,
  `Users_id` INT UNSIGNED NOT NULL,
  `Users_Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`, `ProjectList_id`, `ProjectList_Users_id`, `ProjectList_Users_Roles_id`, `Users_id`, `Users_Roles_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `TaskManager`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `TaskManager`;
INSERT INTO `TaskManager`.`Roles` (`id`, `roleName`) VALUES (1, 'user');
INSERT INTO `TaskManager`.`Roles` (`id`, `roleName`) VALUES (2, 'guest');
INSERT INTO `TaskManager`.`Roles` (`id`, `roleName`) VALUES (3, 'admin');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
