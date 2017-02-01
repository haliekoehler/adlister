CREATE DATABASE if NOT EXISTS adlister_db;

USE adlister_db;

CREATE TABLE if NOT EXISTS ads(
  id int UNSIGNED not NULL AUTO_INCREMENT,
  title VARCHAR(400) not NULL,
  description TEXT,
  PRIMARY KEY (id))
;

