CREATE DATABASE IF NOT EXISTS `boarddb`

#     /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */
#     /*!80016 DEFAULT ENCRYPTION='N' */;

USE `boarddb`;

DROP TABLE IF EXISTS `TB_USER` CASCADE;

CREATE TABLE `TB_USER` (
                           `USER_ID`	VARCHAR(30)	NOT NULL,
                           `USER_PW`	VARCHAR(255) NOT NULL,
                           `USER_NAME`	VARCHAR(30)	NOT NULL,
                           `USER_EMAIL`	VARCHAR(50)	NOT NULL,
                           `USER_NUMBER`	VARCHAR(50)	NOT NULL,
                           `USER_STATE`	CHAR(1)	NOT NULL DEFAULT 'Y',
                           `USER_RIGHT`	CHAR(1)	NOT NULL DEFAULT 'Y',
                           PRIMARY KEY (`USER_ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb3;

INSERT INTO `TB_USER` VALUES ('xangjong', '1234', '최상종', 'csj7080@naver.com', '010-3617-9409', 'Y', 'Y');

DROP TABLE IF EXISTS `TB_ITEM` CASCADE;

CREATE TABLE `TB_ITEM` (
                           `ITEM_NO`	INT	NOT NULL AUTO_INCREMENT,
                           `ITEM_NAME`	VARCHAR(100) NULL,
                           `ITEM_DETAIL`	VARCHAR(200) NULL,
                           `ITEM_QUANTITY`	INT	DEFAULT 1 ,
                           `ITEM_PRICE`	INT	DEFAULT 0,
                           `ITEM_IMAGE`	BLOB	NULL,
                           `DESCRIPTION`	VARCHAR(255)	NULL,
                           `CONTEXT`	TEXT	NULL,
                           `USER_ID`	VARCHAR(30)	NOT NULL,
                           PRIMARY KEY (`ITEM_NO`),
                           KEY `USER_ID` (`USER_ID`),
                           CONSTRAINT `FK_TB_ITEM_USER_ID`
                               FOREIGN KEY(`USER_ID`) REFERENCES `TB_USER` (`USER_ID`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

INSERT INTO `TB_ITEM` VALUES (1, '123324', '312321321', 1, 0, null, '312321312', null, 'xangjong');


# ALTER TABLE `TB_ITEM` ADD CONSTRAINT `FK_TB_ITEM_USER_ID`
    #     FOREIGN KEY(`USER_ID`) REFERENCES `TB_USER` (`USER_ID`) ON DELETE CASCADE;


DROP TABLE IF EXISTS `TB_BOARD` CASCADE;

CREATE TABLE `TB_BOARD` (
                            `BOARD_NO`	INT	NOT NULL AUTO_INCREMENT,
                            `CATEGORY`	CHAR(1)	NOT NULL,
                            `VIEWSTATE`	CHAR(1)	NOT NULL,
                            `REG_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `MOD_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            `USER_ID`	VARCHAR(30)	NOT NULL,
                            `ITEM_NO`	INT	NOT NULL,
                            PRIMARY KEY (`BOARD_NO`),
                            KEY `USER_ID` (`USER_ID`),
                            KEY `ITEM_NO` (`ITEM_NO`),
                            CONSTRAINT `FK_TB_BOARD_USER` FOREIGN KEY(`USER_ID`) REFERENCES `TB_USER`(`USER_ID`)
                                ON DELETE CASCADE,
                            CONSTRAINT `FK_TB_BOARD_ITEM` FOREIGN KEY(`ITEM_NO`) REFERENCES `TB_ITEM`(`ITEM_NO`)
                                ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

# ALTER TABLE `TB_BOARD` ADD CONSTRAINT `FK_TB_BOARD_ITEM_NO`
    #     FOREIGN KEY (`ITEM_NO`) REFERENCES `TB_ITEM` (`ITEM_NO`) ON DELETE CASCADE;

DELETE FROM `TB_USER` WHERE `USER_NAME` = '최상종';


DROP TABLE IF EXISTS `TB_STATE` CASCADE;

CREATE TABLE `TB_STATE` (
                            `CATEGORY`	CHAR(1)	NOT NULL,
                            `CODE_CD` CHAR(1),
                            `STATE`	CHAR(1)	NOT NULL DEFAULT 'Y',
                            `RIGHT`	CHAR(1)	NOT NULL DEFAULT 'Y',
                            `VIEWSTATE`	CHAR(1)	NOT NULL DEFAULT 'Y',
                            `CONTEXT`	TEXT	NULL
);
