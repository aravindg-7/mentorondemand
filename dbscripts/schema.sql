-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mentor_on_demand
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mentor_on_demand
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mentor_on_demand` DEFAULT CHARACTER SET utf8 ;
USE `mentor_on_demand` ;

-- -----------------------------------------------------
-- Table `mentor_on_demand`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`user` (
  `us_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `us_username` VARCHAR(45) NOT NULL,
  `us_password` VARCHAR(90) NOT NULL,
  `us_first_name` VARCHAR(45) NOT NULL,
  `us_last_name` VARCHAR(45) NOT NULL,
  `us_role` VARCHAR(15) NOT NULL,
  `us_contact_number` BIGINT(10) NOT NULL,
  `us_reg_code` VARCHAR(45) NULL DEFAULT NULL,
  `us_active` TINYINT(1) NULL DEFAULT NULL,
  `us_confirmed_signup` TINYINT(1) NULL DEFAULT NULL,
  `us_reset_password` TINYINT(1) NULL DEFAULT NULL,
  `us_reset_password_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE INDEX `us_username_UNIQUE` (`us_username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`mentor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`mentor` (
  `me_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `me_url` VARCHAR(95) NULL DEFAULT NULL,
  `me_experience` FLOAT NULL DEFAULT NULL,
  `me_us_id` BIGINT(20) NOT NULL,
  `me_slot` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`me_id`),
  UNIQUE INDEX `me_url_UNIQUE` (`me_url` ASC),
  INDEX `fk_mentor_user_idx` (`me_us_id` ASC),
  CONSTRAINT `fk_mentor_user`
    FOREIGN KEY (`me_us_id`)
    REFERENCES `mentor_on_demand`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`skill` (
  `sk_id` BIGINT(20) NOT NULL,
  `sk_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`sk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`mentorskill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`mentorskill` (
  `ms_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ms_rating` INT(2) NULL DEFAULT NULL,
  `ms_exp` FLOAT NULL DEFAULT NULL,
  `ms_us_id` BIGINT(20) NOT NULL,
  `ms_sk_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ms_id`),
  INDEX `fk_skill_mentor1_idx` (`ms_us_id` ASC),
  INDEX `fk_mentorskill_skill1_idx` (`ms_sk_id` ASC),
  CONSTRAINT `fk_mentorskill_skill1`
    FOREIGN KEY (`ms_sk_id`)
    REFERENCES `mentor_on_demand`.`skill` (`sk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_mentor1`
    FOREIGN KEY (`ms_us_id`)
    REFERENCES `mentor_on_demand`.`mentor` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`training` (
  `tr_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tr_status` VARCHAR(20) NULL DEFAULT NULL,
  `tr_progress` INT(11) NULL DEFAULT NULL,
  `tr_rating` FLOAT NULL DEFAULT NULL,
  `tr_startdate` DATE NULL DEFAULT NULL,
  `tr_enddate` DATE NULL DEFAULT NULL,
  `tr_us_id` BIGINT(20) NOT NULL,
  `tr_me_id` BIGINT(20) NOT NULL,
  `tr_sk_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`tr_id`),
  INDEX `fk_training_user1_idx` (`tr_us_id` ASC),
  INDEX `fk_training_mentor1_idx` (`tr_me_id` ASC),
  INDEX `fk_training_skill1_idx` (`tr_sk_id` ASC),
  CONSTRAINT `fk_training_mentor1`
    FOREIGN KEY (`tr_me_id`)
    REFERENCES `mentor_on_demand`.`mentor` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_training_skill1`
    FOREIGN KEY (`tr_sk_id`)
    REFERENCES `mentor_on_demand`.`skill` (`sk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_training_user1`
    FOREIGN KEY (`tr_us_id`)
    REFERENCES `mentor_on_demand`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
