create database realstate;
use realstate;
CREATE TABLE `person` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `personID` int(11) DEFAULT NULL,
  `preference` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `personID_idx` (`personID`),
  CONSTRAINT `client_person` FOREIGN KEY (`personID`) REFERENCES `person` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `owner` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `personID` int(11) DEFAULT NULL,
  `isPrivate` int(11) DEFAULT NULL,
  `isBusiness` int(11) DEFAULT NULL,
  `businessName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `owner_person_idx` (`personID`),
  CONSTRAINT `owner_person` FOREIGN KEY (`personID`) REFERENCES `person` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `personID` int(11) DEFAULT NULL,
  `isSupervisor` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `staff_person_idx` (`personID`),
  CONSTRAINT `staff_person` FOREIGN KEY (`personID`) REFERENCES `person` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `supervisor_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `supervisorID` int(11) DEFAULT NULL,
  `staffID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `supervisorid_staff_idx` (`supervisorID`),
  KEY `staffid_staff_idx` (`staffID`),
  CONSTRAINT `staffid_staff` FOREIGN KEY (`staffID`) REFERENCES `staff` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `supervisorid_staff` FOREIGN KEY (`supervisorID`) REFERENCES `staff` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `property` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) DEFAULT NULL,
  `noOfRooms` int(11) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `isHouse` int(11) DEFAULT NULL,
  `isAppartment` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `owner_owned_property` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ownerID` int(11) DEFAULT NULL,
  `propertyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `owner_owned_property_owner_idx` (`ownerID`),
  KEY `owner_owned_property_property_idx` (`propertyID`),
  CONSTRAINT `owner_owned_property_owner` FOREIGN KEY (`ownerID`) REFERENCES `owner` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `owner_owned_property_property` FOREIGN KEY (`propertyID`) REFERENCES `property` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `property_view` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `clientID` int(11) DEFAULT NULL,
  `propertyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `property_view_client_idx` (`clientID`),
  KEY `property_view_property_idx` (`propertyID`),
  CONSTRAINT `property_view_client` FOREIGN KEY (`clientID`) REFERENCES `client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `property_view_property` FOREIGN KEY (`propertyID`) REFERENCES `property` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rent` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `leaseSigned` int(11) DEFAULT NULL,
  `deposit` decimal(10,2) DEFAULT NULL,
  `rentStartDate` datetime DEFAULT NULL,
  `rentFinishDate` varchar(45) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `rentPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `selling` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `soldPrice` decimal(10,2) DEFAULT NULL,
  `soldDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `staff_managed_property` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) DEFAULT NULL,
  `propertyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `staff_managed_property_staff_idx` (`staffID`),
  KEY `staff_managed_property_property_idx` (`propertyID`),
  CONSTRAINT `staff_managed_property_property` FOREIGN KEY (`propertyID`) REFERENCES `property` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `staff_managed_property_staff` FOREIGN KEY (`staffID`) REFERENCES `staff` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `transaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ownerID` int(11) DEFAULT NULL,
  `clientID` int(11) DEFAULT NULL,
  `propertyID` int(11) DEFAULT NULL,
  `sellingID` int(11) DEFAULT NULL,
  `rentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `transaction_owner_idx` (`ownerID`),
  KEY `transaction_client_idx` (`clientID`),
  KEY `transaction_property_idx` (`propertyID`),
  KEY `transaction_sellingID_idx` (`sellingID`),
  KEY `transaction_rendID_idx` (`rentID`),
  CONSTRAINT `transaction_client` FOREIGN KEY (`clientID`) REFERENCES `client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_owner` FOREIGN KEY (`ownerID`) REFERENCES `owner` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_property` FOREIGN KEY (`propertyID`) REFERENCES `property` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_rendID` FOREIGN KEY (`rentID`) REFERENCES `rent` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_sellingID` FOREIGN KEY (`sellingID`) REFERENCES `selling` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("john snow","winterfell","abc");
INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("Sansa Stark","winterfell","abc");

INSERT INTO `realstate`.`client`(`personID`,`preference`) VALUES
(1,"abasdfasdf");
INSERT INTO `realstate`.`client`(`personID`,`preference`) VALUES
(2,"abasdfasdf");


INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("Luis Suarez","liverpool","abc");
INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("David Silva","manchester city","abc");

INSERT INTO `realstate`.`owner`(`personID`,`isPrivate`,`isBusiness`,`businessName`) VALUES
(3,1,0,null);
INSERT INTO `realstate`.`owner`(`personID`,`isPrivate`,`isBusiness`,`businessName`) VALUES
(4,0,1,"suarez corp");

INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("hari","fairfield","abc");
INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("gopal","otumwa","abc");
INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("patrick","fairfield","abc");
INSERT INTO `realstate`.`person` (`name`,`address`,`password`) VALUES
("john","otumwa","abc");

INSERT INTO `realstate`.`staff`(`personID`,`isSupervisor`) VALUES
(5,0);
INSERT INTO `realstate`.`staff`(`personID`,`isSupervisor`) VALUES
(6,0);
INSERT INTO `realstate`.`staff`(`personID`,`isSupervisor`) VALUES
(7,0);
INSERT INTO `realstate`.`staff`(`personID`,`isSupervisor`) VALUES
(8,1);

INSERT INTO `realstate`.`supervisor_staff`(`supervisorID`,`staffID`)VALUES
(4,1);
INSERT INTO `realstate`.`supervisor_staff`(`supervisorID`,`staffID`)VALUES
(4,2);
INSERT INTO `realstate`.`supervisor_staff`(`supervisorID`,`staffID`)VALUES
(4,3);


INSERT INTO `realstate`.`property`(`address`,`noOfRooms`,`price`,`isHouse`,`isAppartment`) VALUES
("fairfield 4000 N 1st street",4,10000,1,0);
INSERT INTO `realstate`.`property`(`address`,`noOfRooms`,`price`,`isHouse`,`isAppartment`) VALUES
("fairfield 4000 N 2st street",7,40000,1,0);
INSERT INTO `realstate`.`property`(`address`,`noOfRooms`,`price`,`isHouse`,`isAppartment`) VALUES
("fairfield 4000 N 3st street",2,1000,0,1);
INSERT INTO `realstate`.`property`(`address`,`noOfRooms`,`price`,`isHouse`,`isAppartment`) VALUES
("fairfield 4000 N 4st street",1,500,0,1);

