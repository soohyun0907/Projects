CREATE TABLE `areainfo` (
  `acode` varchar(45) NOT NULL,
  `alocalname1` varchar(10) DEFAULT NULL,
  `alocalname2` varchar(15) DEFAULT NULL,
  `alocalname3` varchar(15) DEFAULT NULL,
  `alocalname4` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`acode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `userinfo` (
  `uid` varchar(45) NOT NULL,
  `upw` varchar(45) NOT NULL,
  `uname` varchar(45) DEFAULT NULL,
  `uaddress` varchar(45) DEFAULT NULL,
  `uphone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `favoritearea` (
  `uid` varchar(15) NOT NULL,
  `acode` varchar(15) NOT NULL,
  PRIMARY KEY (`uid`,`acode`),
  KEY `fk_favoritearea_areainfo1_idx` (`acode`),
  CONSTRAINT `fk_favoritearea_areainfo1` FOREIGN KEY (`acode`) REFERENCES `areainfo` (`acode`),
  CONSTRAINT `fk_favoritearea_userinfo` FOREIGN KEY (`uid`) REFERENCES `userinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `HouseDeal` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `dealAmount` varchar(50) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `dealYear` varchar(30) DEFAULT NULL,
  `dealMonth` varchar(30) DEFAULT NULL,
  `dealDay` varchar(30) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `floor` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `rentMoney` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=68865 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `HouseInfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5996 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `storeinfo` (
  `no` int NOT NULL,
  `shopname` varchar(45) DEFAULT NULL,
  `localname` varchar(45) DEFAULT NULL,
  `code1` varchar(45) DEFAULT NULL,
  `codename1` varchar(45) DEFAULT NULL,
  `code2` varchar(45) DEFAULT NULL,
  `codename2` varchar(45) DEFAULT NULL,
  `code3` varchar(45) DEFAULT NULL,
  `codename3` varchar(45) DEFAULT NULL,
  `code4` varchar(45) DEFAULT NULL,
  `codename4` varchar(45) DEFAULT NULL,
  `citycode` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `gucode` varchar(45) DEFAULT NULL,
  `gu` varchar(45) DEFAULT NULL,
  `dongcode` varchar(45) DEFAULT NULL,
  `dong` varchar(45) DEFAULT NULL,
  `jibuaddress` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `oldpostcode` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `lng` varchar(45) DEFAULT NULL,
  `lat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE dongcode (
  num int(11) NOT NULL,
  city varchar(50) NOT NULL,
  code varchar(50) DEFAULT NULL,
  dongcode varchar(50) DEFAULT NULL,
  gugun varchar(50) DEFAULT NULL,
  dong varchar(50) DEFAULT NULL,
  lat varchar(50) DEFAULT NULL,
  lng varchar(50) DEFAULT NULL,
  PRIMARY KEY (num)
) ;

CREATE TABLE `ssafy_member2` (
	`userno`		int		PRIMARY KEY auto_increment ,
	`userid`		VARCHAR(20) 	NOT NULL UNIQUE,
	`username`		VARCHAR(20) 	NOT NULL,
	`userpwd`		VARCHAR(100) 	NOT NULL,
	`telephone`		VARCHAR(20),
	`email`		VARCHAR(200),
	`address` 		VARCHAR(2000),
	`joindate` 		TIMESTAMP	NOT NULL DEFAULT current_timestamp
);


INSERT INTO ssafy_member2 (userid, username, userpwd, telephone, email, address)
VALUES('admin', '관리자', 'admin', '010-1234-9876', 'admin@ssafy.com','서울시 역삼동');

INSERT INTO ssafy_member2 (userid, username, userpwd, telephone, email, address)
VALUES('ssafy', '김싸피', 'ssafy', '010-7272-7272', 'ssafy@ssafy.com','대전시 덕명동');

CREATE TABLE `guestbook` (
	`articleno`   int PRIMARY KEY auto_increment ,
	`userid`    VARCHAR(20) NULL,
	`subject`     VARCHAR(100) NULL,
	`content`     VARCHAR(2000) NULL,
	`regtime`    TIMESTAMP   NOT NULL DEFAULT current_timestamp,
	constraint `guestbook_to_member_fk` foreign key (`userid`) 
	references  `ssafy_member2` (`userid`)
);