DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(64) NOT NULL DEFAULT '',
  password varchar(128) NOT NULL DEFAULT '',
  salt varchar(32) NOT NULL DEFAULT '',
  headUrl varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (id),
  UNIQUE KEY name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(128) NOT NULL DEFAULT '',
  link varchar(256) NOT NULL DEFAULT '',
  image varchar(256) NOT NULL DEFAULT '',
  likeCount int NOT NULL,
  commentCount int NOT NULL,
  createddate datetime NOT NULL,
  userId int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `LoginTicket`;
CREATE TABLE `loginTicket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `ticket` VARCHAR(45) NOT NULL,
  `expired` DATETIME NOT NULL,
  `status` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ticket_UNIQUE` (`ticket` ASC));