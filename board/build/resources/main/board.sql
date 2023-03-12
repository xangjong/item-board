CREATE DATABASE IF NOT EXISTS `boarddb`;

USE `boarddb`;

DROP TABLE IF EXISTS `TB_BOARD` CASCADE;

CREATE TABLE `TB_BOARD` (
                            `ITEM_NO`	INT	NOT NULL AUTO_INCREMENT,
                            `ITEM_NAME`	VARCHAR(100) NULL,
                            `ITEM_DETAIL`	VARCHAR(200) NULL,
                            `ITEM_QUANTITY`	INT	DEFAULT 1 ,
                            `ITEM_PRICE`	INT	DEFAULT 0,
                            `ITEM_IMAGE`	BLOB NULL,
                            `REG_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `MOD_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`ITEM_NO`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

INSERT INTO `TB_BOARD` VALUES (1, '냉장고', '삼성 비스포크', 1, 300000000, null, now(), now());