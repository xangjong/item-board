DROP TABLE IF EXISTS board;
CREATE TABLE board(
                          bno int auto_increment,
                          title varchar (30) not null,
                          content varchar (30) not null,
                          reg_date date not null,
                          readCnt int default 0,
                          primary key(bno)
);

INSERT INTO board(title, content, reg_date, readCnt) VALUES('title1', 'content1',now(),0);
INSERT INTO board(title, content, reg_date, readCnt) VALUES('title2', 'content2',now(),0);
INSERT INTO board(title, content, reg_date, readCnt) VALUES('title3', 'content3',now(),0);
INSERT INTO board(title, content, reg_date, readCnt) VALUES('title4', 'content4',now(),0);
INSERT INTO board(title, content, reg_date, readCnt) VALUES('title5', 'content5',now(),0);
