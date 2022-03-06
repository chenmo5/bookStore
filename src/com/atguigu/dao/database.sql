drop database if exists book;

create database book;

use book;

CREATE TABLE `book`.`t_user`  (
                                  `id`       int          NOT NULL AUTO_INCREMENT,
                                  `username` varchar(20)  NOT NULL,
                                  `password` varchar(30)  NOT NULL,
                                  `email`    varchar(255) NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE INDEX `unique_username` (`username`) USING BTREE
);

insert into t_user(`username`,`password`,`email`) values ('admin','admin','admin@atguigu.com');

select * from t_user;