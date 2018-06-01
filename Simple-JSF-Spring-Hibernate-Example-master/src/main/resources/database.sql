/*
CREATE DATABASE `simple`;

--MySql Original
CREATE TABLE IF NOT EXISTS `simple`.`user`(
`id` int(11) not null auto_increment primary key,
`name` nvarchar(20) ,
`surname` nvarchar(20) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--------

* Add this Sequence to Oracle  'id_users' :

CREATE SEQUENCE USERDB.ID_USERS
  START WITH 22
  MAXVALUE 9999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;

*/

CREATE DATABASE `USERDB`;

CREATE TABLE USERS
(
  ID       NUMBER(11),
  NAME     VARCHAR2(20 BYTE),
  SURNAME  VARCHAR2(20 BYTE)
)