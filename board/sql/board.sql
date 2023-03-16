CREATE DATABASE IF NOT EXISTS `boarddb`;

USE `boarddb`;

DROP TABLE IF EXISTS `TB_BOARD` CASCADE;

CREATE TABLE `TB_BOARD` (
                            `ITEM_NO`	INT	NOT NULL AUTO_INCREMENT,
                            `ITEM_CODE` VARCHAR(100) NOT NULL,
                            `ITEM_NAME`	VARCHAR(100) NOT NULL,
                            `ITEM_DETAIL`	VARCHAR(200) NULL,
                            `ITEM_QUANTITY`	INT	DEFAULT 1 NOT NULL,
                            `ITEM_PRICE`	INT	DEFAULT 0 NOT NULL,
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
                              (10, 'CODE1243', '컵', '종이컵', 100, 3032000, now(), now()),
                              (11, 'CODE1244', '냉장고', '삼성 비스포크', 1, 300000000, now(), now()),
                              (12, 'CODE1245', '모니터', '삼성 ', 10, 500000000, now(), now()),
                              (13, 'CODE1246', '노트북', '윈도우', 7, 100000000, now(), now()),
                              (14, 'CODE1247', '선풍기', '한성', 2, 200000000, now(), now()),
                              (15, 'CODE1248', '정수기', 'LG', 1, 350000000, now(), now()),
                              (16, 'CODE1249', '본체', '데스크탑', 10, 330000000, now(), now()),
                              (17, 'CODE1250', '프린터', 'SAMSUNG', 2, 330000, now(), now()),
                              (18, 'CODE1251', '팩스', 'LG', 4, 500000, now(), now()),
                              (19, 'CODE1252', '종이', '이면지', 2000, 300000, now(), now()),
                              (20, 'CODE125232', '컵', '종이컵', 100, 3032000, now(), now()),
                              (21, 'CODE12522', '냉장고', '삼성 비스포크', 1, 300000000, now(), now()),
                              (22, 'CODE1252321', '모니터', '삼성 ', 10, 500000000, now(), now()),
                              (23, 'CODE12523', '노트북', '윈도우', 7, 100000000, now(), now()),
                              (24, 'CODE1244', '선풍기', '한성', 2, 200000000, now(), now()),
                              (25, 'CODE1244', '정수기', 'LG', 1, 350000000, now(), now()),
                              (26, 'CODE1244', '본체', '데스크탑', 10, 330000000, now(), now()),
                              (27, 'CODE1323', '프린터', 'SAMSUNG', 2, 330000, now(), now()),
                              (28, 'CODE1323', '팩스', 'LG', 4, 500000, now(), now()),
                              (29, 'CODE1323', '종이', '이면지', 2000, 300000, now(), now()),
                              (30, 'CODE1323', '컵', '종이컵', 100, 3032000, now(), now()),
                              (31, 'CODE1323', '냉장고', '삼성 비스포크', 1, 300000000, now(), now()),
                              (32, 'CODE1323', '모니터', '삼성 ', 10, 500000000, now(), now()),
                              (33, 'CODE1238', '노트북', '윈도우', 7, 100000000, now(), now()),
                              (34, 'CODE1238', '선풍기', '한성', 2, 200000000, now(), now()),
                              (35, 'CODE1238', '정수기', 'LG', 1, 350000000, now(), now()),
                              (36, 'CODE1238', '본체', '데스크탑', 10, 330000000, now(), now()),
                              (37, 'CODE1238', '프린터', 'SAMSUNG', 2, 330000, now(), now()),
                              (38, 'CODE1238', '팩스', 'LG', 4, 500000, now(), now()),
                              (39, 'CODE1274', '종이', '이면지', 2000, 300000, now(), now()),
                              (40, 'CODE1274', '컵', '종이컵', 100, 3032000, now(), now()),
                              (41, 'CODE1274', '냉장고', '삼성 비스포크', 1, 300000000, now(), now()),
                              (42, 'CODE1274', '모니터', '삼성 ', 10, 500000000, now(), now()),
                              (43, 'CODE1274', '노트북', '윈도우', 7, 100000000, now(), now()),
                              (44, 'CODE1274', '선풍기', '한성', 2, 200000000, now(), now()),
                              (45, 'CODE1274', '정수기', 'LG', 1, 350000000, now(), now()),
                              (46, 'CODE1274', '본체', '데스크탑', 10, 330000000, now(), now()),
                              (47, 'CODE1274', '프린터', 'SAMSUNG', 2, 330000, now(), now()),
                              (48, 'CODE1274', '팩스', 'LG', 4, 500000, now(), now()),
                              (49, 'CODE1274', '종이', '이면지', 2000, 300000, now(), now()),
                              (50, 'CODE1274', '컵', '종이컵', 100, 3032000, now(), now());


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
