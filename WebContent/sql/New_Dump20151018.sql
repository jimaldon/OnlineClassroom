CREATE DATABASE  IF NOT EXISTS `ci6206` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ci6206`;

CREATE TABLE `users_profile` (
  `LoginName` varchar(30) NOT NULL,
  `Password` varchar(30) NOT Null,
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Country` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Telephone` varchar(30) DEFAULT NULL,
  `PostalCode` varchar(30) DEFAULT NULL,
  `Birthday_Month` varchar(10)  DEFAULT NULL,
  `Birthday_Date` varchar(10)  DEFAULT NULL,
  `Birthday_year` varchar(10)  DEFAULT NULL,
  `ProfileInfo` varchar(2000)  DEFAULT NULL,
  `UserType` varchar(1),
  `IsDeleted` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`LoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into users_profile (LoginName,Password,UserType) values ('shanka','password','A');
insert into users_profile (LoginName,Password,UserType) values ('shankara','password','S');
commit;

CREATE TABLE `course_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `courses` (
  `CourseID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseCode` varchar(3) DEFAULT NULL,
    `Title` varchar(45) DEFAULT NULL,
    `shortDescription` varchar(1000) DEFAULT NULL,
  `CoursecategoryId` int(11) NOT NULL,
  `course_Month` varchar(10)  DEFAULT NULL,
  `course_Date` varchar(10)  DEFAULT NULL,
  `course_year` varchar(10)  DEFAULT NULL,
  `comments` varchar(10)  DEFAULT NULL,
  `author` varchar(50)  DEFAULT NULL,
  `Likes` varchar(10)  DEFAULT NULL,
  PRIMARY KEY (`CourseID`),
  KEY `CoursecategoryId` (`CoursecategoryId`),
  CONSTRAINT `CoursecategoryId` FOREIGN KEY (`CoursecategoryId`) REFERENCES `course_category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into course_category (description) values ('DATABASE');
insert into course_category (description) values ('TECHNOLOGY');
commit;

insert into courses (CourseCode,Title,shortDescription,CoursecategoryId,course_Month,course_Date,course_year,author)
values ('DB1','Introduction to Databases','Starting in summer 2014 the materials are now being offered on the OpenEdX platform as a set of smaller self-paced "mini-courses", which can be assembled in a variety of ways to learn about different aspects of databases','1','October','19','2015','Shankara');
insert into courses (CourseCode,Title,shortDescription,CoursecategoryId,course_Month,course_Date,course_year,author)
values ('DB2','Databases Management Essentials','Database Management Essentials provides the foundation you need for a career in database development, data warehousing, or business intelligence, as well as for the entire Data Warehousing for Business Intelligence specialization. In this course, you will create relational databases, write SQL statements to extract information to satisfy business reporting requests, create entity relationship diagrams (ERDs) to design databases, and analyze table designs for excessive redundancy','1','October','20','2015','Shankara');
commit;

CREATE TABLE `course_enrolls` (
  `CourseID` int(11) NOT NULL,
  `LoginName` varchar(75) NOT NULL,
  PRIMARY KEY (`CourseID`,`LoginName`),
  CONSTRAINT `fk_Enrolls_CourseOfferings` FOREIGN KEY (`CourseID`) REFERENCES `courses` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Enrolls_Students` FOREIGN KEY (`LoginName`) REFERENCES `users_profile` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into course_enrolls values (1,'shankara');
insert into course_enrolls values (2,'shankara');
commit;
