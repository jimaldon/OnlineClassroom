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

INSERT INTO `users_profile` VALUES ('Devanand','Password','Devanand','Krishnamoorthy','M','Macpherson','Singapore','Singapore','devanand@juronghealth.com.sg','91086727','542323','01','01','1986','Tutor','T','N'),
('Jim','password','Jim','Aldon','M','Pioneer','Singapore','Singapore','jim@nut.edu.sg','91086729','542326','01','01','1992','Student','S','N'),
('Max','password','Maxat','Skakov','M','Bishan','Singapore','Singapore','maxat@accenture.com.sg','91086727','542322','01','01','1990','Student','S','N'),
('shanka','password','Shankar','Kailash','M','Sengkang','Singapore','Singapore','kailash@cna.com.sg','91086725','542321','01','01','1975','Admin','A','N'),
('shankara','password','Shankara','Narayanan','M','Bishan','Singapore','Singapore','shankar@nc.sco.sg','91086726','542322','01','01','1991','Student','S','N');
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

CREATE TABLE `course_contents` (
  `ContentId` int(11) NOT NULL AUTO_INCREMENT,
  `CourseCode` varchar(45) DEFAULT NULL,
  `AboutCourse` LongText DEFAULT NULL,
  `Syllabus` LongText NOT NULL,
  `VideoURL` varchar(1000), 
  PRIMARY KEY (`ContentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into course_contents (CourseCode,AboutCourse,Syllabus,VideoURL) values
('DB2','Database Management Essentials is course 1 of 5 in the Data Warehousing for Business Intelligence Specialization.
This Specialization covers data architecture skills that are increasingly critical across a broad range of technology fields. You’ll learn the basics of structured data modeling, gain practical SQL coding experience, and develop an in-depth understanding of data warehouse design and data manipulation. You’ll have the opportunity to work with large data sets in a data warehouse environment to create dashboards and Visual Analytics. You will use of MicroStrategy, a leading BI tool, OLAP (online analytical processing) and Visual Insights capabilities to create dashboards and Visual Analytics. In the final Capstone Project, you’ll apply your skills to build a small, basic data warehouse, populate it with data, and create dashboards and other visualizations to analyze and communicate the data to a broad audience.',
'Week 1
Course Introduction
Introduction to Databases and DBMSs

    Specialization Introduction
    Course Introduction
    Course objectives
    Topics and assignments
    Database management software requirements
    Database characteristics
    Organizational roles
    DBMS overview and database definition feature
    Non-procedural access
    Transaction processing overview
    Data warehouse processing overview
    DBMS technology evolution
    Review

    Quiz: Module02 Quiz

Week 2
Relational Data Model and the CREATE TABLE Statement

    Basics of relational databases
    Integrity rules
    Basic SQL CREATE TABLE statement
    Integrity constraint syntax
    Assignment 1 Notes
    Practice Problems and Assignment

    Assignment: Module 3 Assignment

Week 3
Basic Query Formulation with SQL
Extended Query Formulation with SQL

    SQL Overview
    SELECT statement introduction
    Join Operator
    Using join operations in SQL SELECT statements
    GROUP BY clause
    Practice Problems and Assignment
    Query formulation guidelines
    Multiple table problems
    Problems involving join and grouping operations
    SQL set operators
    SQL modification statements
    Practice Problems and Assignment

    Assignment: Module 4 Assignment
    Assignment: Module 5 Assignment

Week 4
Notation for Entity Relationship Diagrams
ERD Rules and Problem Solving

    Database development goals
    Basic ERD notation
    Relationship variations I
    Relationship variations II
    Practice Problems and Assignment
    Basic diagram rules
    Extended diagram rules
    ERD problems I
    ERD problems II
    ER Assistant Demonstration
    Practice Problems and Assignment

    Assignment: Module 6 Assignment
    Assignment: Module 7 Assignment

Week 5
Developing Business Data Models
Data Modeling Problems and Completion of an ERD

    Conceptual data modeling goals and challenges
    Analyzing narrative problems
    Design transformations I
    Design transformations II
    Practice Problems and Assignment
    Data modeling problems I
    Data modeling problems II
    Finalizing an ERD
    Practice Problems and Assignment

    Assignment: Module 8 Assignment
    Assignment: Module 9 Assignment

Week 6
Schema Conversion

    Goals and steps of logical database design
    Conversion rules
    Conversion problems
    Practice Problems and Assignment

    Assignment: Module 10 Assignment

Week 7
Normalization Concepts and Practice

    Modification anomalies
    Functional dependencies
    Normal forms
    Practical concerns
    Normalization problems
    Course Conclusion
    Practice Problems and Assignment

    Assignment: Module 11 Assignment','');