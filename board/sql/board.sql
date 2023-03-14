CREATE DATABASE IF NOT EXISTS `boarddb`;

USE `boarddb`;

DROP TABLE IF EXISTS `TB_BOARD` CASCADE;

CREATE TABLE `TB_BOARD` (
                            `ITEM_NO`	INT	NOT NULL AUTO_INCREMENT,
                            `ITEM_CODE` VARCHAR(100) NULL,
                            `ITEM_NAME`	VARCHAR(100) NULL,
                            `ITEM_DETAIL`	VARCHAR(200) NULL,
                            `ITEM_QUANTITY`	INT	DEFAULT 1 ,
                            `ITEM_PRICE`	INT	DEFAULT 0,
                            `REG_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP,
                            `MOD_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`ITEM_NO`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

INSERT INTO `TB_BOARD` VALUES (1, 'CODE1234', '냉장고', '삼성 비스포크', 1, 300000000, now(), now()),
                              (2, 'CODE1235', '모니터', '삼성 ', 10, 500000000, now(), now()),
                              (3, 'CODE1236', '노트북', '윈도우', 7, 100000000, now(), now()),
                              (4, 'CODE1237', '선풍기', '한성', 2, 200000000, now(), now()),
                              (5, 'CODE1238', '정수기', 'LG', 1, 350000000, now(), now()),
                              (6, 'CODE1239', '본체', '데스크탑', 10, 330000000, now(), now()),
                              (7, 'CODE1240', '프린터', 'SAMSUNG', 2, 330000, now(), now()),
                              (8, 'CODE1241', '팩스', 'LG', 4, 500000, now(), now()),
                              (9, 'CODE1242', '종이', '이면지', 2000, 300000, now(), now()),
                              (10, 'CODE1243', '컵', '종이컵', 100, 3032000, now(), now());


DROP TABLE IF EXISTS `TB_MEMBER` CASCADE;

CREATE TABLE `TB_MEMBER` (

    `MEMBER_NO` INT NOT NULL AUTO_INCREMENT,
    `MEMBER_ID` VARCHAR(30) NOT NULL,
    `MEMBER_PW` VARCHAR(255) NOT NULL,
    `MEMBER_NAME` VARCHAR(30) NOT NULL,
    `MEMBER_STATE` VARCHAR(10) NOT NULL DEFAULT 'Y',
    `MEMBER_ROLE` VARCHAR(10) NOT NULL DEFAULT 'USER',
    `REG_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP,
    `MOD_DATETIME`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`MEMBER_NO`)

) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;


INSERT INTO `TB_MEMBER` VALUES (1, 'xangjong', '1234', '최상종', 'Y', 'USER', now(), now()),
                               (2, 'jongxang', '1234', '최종상', 'Y', 'USER', now(), now()),
                               (3, 'testUSer', '1234', '테스트계정', 'Y', 'USER', now(), now());
