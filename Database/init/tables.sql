# create table USER
drop table if exists USER;
create table user
(
    id       int auto_increment
        primary key,
    userName varchar(30) not null,
    password varchar(20) null
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=UTF8;

INSERT INTO USER VALUES ('1', 'admin', 'admin');

# create table category
DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY(
                         ID INT(11) NOT NULL ,
                         NAME VARCHAR(255) NOT NULL ,
                         PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

# create table book
DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK (
                      ID INT(11) NOT NULL AUTO_INCREMENT,
                      COVER VARCHAR(255) DEFAULT '',
                      TITLE VARCHAR(255) NOT NULL DEFAULT '',
                      AUTHOR VARCHAR(255) DEFAULT '',
                      DATE VARCHAR(20) DEFAULT '',
                      PRESS VARCHAR(255) DEFAULT '',
                      ABS VARCHAR(255) DEFAULT NULL,
                      CID INT(11) DEFAULT NULL,
                      PRIMARY KEY (ID),
                      KEY FK_BOOK_CATEGORY_ON_CID (CID),
                      CONSTRAINT FK_BOOK_CATEGORY_ON_CID FOREIGN KEY (CID) REFERENCES CATEGORY (ID) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

