CREATE TABLE IF NOT EXISTS `SUBJECT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `ACTIVE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
    UNIQUE KEY `UK_SUBJECT_NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `SUBJECT` (`ID`, `NAME`, `ACTIVE`) VALUES
	(1, 'Mathematics',1),
	(2, 'Physics',1);



CREATE TABLE IF NOT EXISTS `TEACHER_SUBJECT` (
  `USER_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`SUBJECT_ID`),
  CONSTRAINT `FK_TEACHER_USRE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`ID`),
  CONSTRAINT `FK_TEACHER_USRE_SUBJECT` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `SUBJECT` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
