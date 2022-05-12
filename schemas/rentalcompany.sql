CREATE SCHEMA IF NOT EXISTS `keith_denysiuk`;
USE `keith_denysiuk`;

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`licence` (
  `id_licence` INT NOT NULL AUTO_INCREMENT,
  `num` VARCHAR(10) NOT NULL,
  `expiration_date` INT NOT NULL,
  PRIMARY KEY (`id_licence`));

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `u_name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `licence_id_licence` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  FOREIGN KEY (`licence_id_licence`)
  REFERENCES `licence` (`id_licence`) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`insurance` (
  `id_insurance` INT NOT NULL AUTO_INCREMENT,
  `i_name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `insurance_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id_insurance`));
  
CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`location` (
  `id_location` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_location`));

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`building` (
  `id_building` INT NOT NULL AUTO_INCREMENT,
  `b_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `location_id_location` INT NOT NULL,
  PRIMARY KEY (`id_building`),
  FOREIGN KEY (`location_id_location`)
  REFERENCES `location` (`id_location`) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`job_position` (
  `id_position` INT NOT NULL AUTO_INCREMENT,
  `name_of_position` VARCHAR(45) NOT NULL,
  `pay_per_hour` VARCHAR(45) NULL,
  PRIMARY KEY (`id_position`));

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`work_shift` (
  `id_work_shitf` INT NOT NULL AUTO_INCREMENT,
  `time_range` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_work_shitf`));

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`worker` (
  `id_worker` INT NOT NULL AUTO_INCREMENT,
  `w_name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `building_id_building` INT NOT NULL,
  `position_idposition` INT NOT NULL,
  `work_shift_id_work_shitf` INT NOT NULL,
  PRIMARY KEY (`id_worker`),
  FOREIGN KEY (`building_id_building`)
  REFERENCES `building` (`id_building`) ON DELETE CASCADE,
  FOREIGN KEY (`position_idposition`)
  REFERENCES `job_position` (`id_position`) ON DELETE CASCADE,
  FOREIGN KEY (`work_shift_id_work_shitf`)
  REFERENCES `work_shift` (`id_work_shitf`) ON DELETE CASCADE);
  
  CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `user_id_user` INT NOT NULL,
  `order_date` VARCHAR(45) NOT NULL,
  `insurance_id_insurance` INT NOT NULL,
  `worker_id_worker` INT NOT NULL,
  PRIMARY KEY (`id_order`),
  FOREIGN KEY (`user_id_user`)
  REFERENCES `user` (`id_user`) ON DELETE CASCADE,
  FOREIGN KEY (`insurance_id_insurance`)
  REFERENCES `insurance` (`id_insurance`) ON DELETE CASCADE,
  FOREIGN KEY (`worker_id_worker`)
  REFERENCES `worker` (`id_worker`) ON DELETE CASCADE);
  
CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `vehicle_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`));
  
    CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`model` (
  `id_model` INT NOT NULL AUTO_INCREMENT,
  `m_name` VARCHAR(45) NOT NULL,
  `price_per_day` INT NOT NULL,
  `category_id_category` INT NOT NULL,
  PRIMARY KEY (`id_model`),
  FOREIGN KEY (`category_id_category`)
  REFERENCES `category`(`id_category`) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`vehicles` (
  `id_vehicles` INT NOT NULL AUTO_INCREMENT,
  `licence_plate` VARCHAR(10) NULL,
  `model_id_model` INT NOT NULL,
  PRIMARY KEY (`id_vehicles`),
  FOREIGN KEY (`model_id_model`)
  REFERENCES `model` (`id_model`) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS `keith_denysiuk`.`vehicles_has_order` (
  `vehicles_id_vehicles` INT NOT NULL AUTO_INCREMENT,
  `order_id_order` INT NOT NULL,
  `date_of_order` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`vehicles_id_vehicles`, `order_id_order`),
  FOREIGN KEY (`vehicles_id_vehicles`)
  REFERENCES `vehicles` (`id_vehicles`) ON DELETE CASCADE,
  FOREIGN KEY (`order_id_order`)
  REFERENCES `orders` (`id_order`) ON DELETE CASCADE);
