CREATE DATABASE `itp_2018_mlb_g3_10_sampath_web_portal` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `branch` (
  `branchId` char(10) NOT NULL,
  `branchAddressStreet01` varchar(100) NOT NULL,
  `branchAddressStreet02` varchar(100) NOT NULL,
  `branchAddressCity` varchar(50) DEFAULT NULL,
  `branchAddressProvince` varchar(50) NOT NULL,
  `branchAddressZipCode` int(5) NOT NULL,
  `branchEmail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`branchId`),
  UNIQUE KEY `branchId_UNIQUE` (`branchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gender` (
  `genderId` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`genderId`),
  UNIQUE KEY `gender_UNIQUE` (`gender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `nationality` (
  `nationalityId` int(11) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  PRIMARY KEY (`nationalityId`),
  UNIQUE KEY `nationality_UNIQUE` (`nationality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `designation` (
  `designationId` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  PRIMARY KEY (`designationId`),
  UNIQUE KEY `designationId_UNIQUE` (`designationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `department` (
  `branchId` char(10) NOT NULL,
  `departmentId` char(10) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  PRIMARY KEY (`departmentId`,`branchId`),
  KEY `fk01_department_to_branch_idx` (`branchId`),
  CONSTRAINT `fk01_department_to_branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `permission` (
  `permissionLevel` int(11) NOT NULL,
  `permissionType` varchar(10) NOT NULL,
  PRIMARY KEY (`permissionLevel`),
  UNIQUE KEY `permissionLevel_UNIQUE` (`permissionLevel`),
  UNIQUE KEY `permissionType_UNIQUE` (`permissionType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_security_key` (
  `onlineSecurityId` int(11) NOT NULL,
  `onlineSecurityKey` char(10) NOT NULL,
  PRIMARY KEY (`onlineSecurityId`),
  UNIQUE KEY `onlineSecurityId_UNIQUE` (`onlineSecurityId`),
  UNIQUE KEY `onlineSecurityKey_UNIQUE` (`onlineSecurityKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `personId` char(10) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `middleName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) NOT NULL,
  `otherNames` varchar(50) DEFAULT NULL,
  `addressStreet01` varchar(100) NOT NULL,
  `addressStreet02` varchar(100) DEFAULT NULL,
  `addressCity` varchar(50) NOT NULL,
  `addressProvince` varchar(50) NOT NULL,
  `addressZipCode` int(5) NOT NULL,
  `nic` char(10) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `personalEmail` varchar(100) NOT NULL,
  `physicalRegistrationDate` date NOT NULL,
  `onlineRegistrationDate` date DEFAULT NULL,
  `genderId` int(11) NOT NULL,
  `nationalityId` int(11) NOT NULL,
  `branchId` char(10) NOT NULL,
  `onlineSecurityId` int(11) NOT NULL,
  `permissionLevel` int(11) NOT NULL,
  PRIMARY KEY (`personId`),
  UNIQUE KEY `personId_UNIQUE` (`personId`),
  UNIQUE KEY `nic_UNIQUE` (`nic`),
  UNIQUE KEY `personalEmail_UNIQUE` (`personalEmail`),
  UNIQUE KEY `onlineSecurityId_UNIQUE` (`onlineSecurityId`),
  KEY `fk01_person_to_gender_idx` (`genderId`),
  KEY `fk03_person_to_branch_idx` (`branchId`),
  KEY `fk02_person_to_nationality_idx` (`nationalityId`),
  KEY `fk04_person_to_online_security_key_idx` (`onlineSecurityId`),
  KEY `fk03_person_to_permission_idx` (`permissionLevel`),
  CONSTRAINT `fk01_person_to_gender` FOREIGN KEY (`genderId`) REFERENCES `gender` (`genderId`) ON UPDATE CASCADE,
  CONSTRAINT `fk02_person_to_nationality` FOREIGN KEY (`nationalityId`) REFERENCES `nationality` (`nationalityId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_person_to_branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_person_to_online_security_key` FOREIGN KEY (`onlineSecurityId`) REFERENCES `online_security_key` (`onlineSecurityId`) ON UPDATE CASCADE,
  CONSTRAINT `fk03_person_to_permission` FOREIGN KEY (`permissionLevel`) REFERENCES `permission` (`permissionLevel`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `employeeId` char(10) NOT NULL,
  `departmentId` char(10) NOT NULL,
  `companyEmail` varchar(100) NOT NULL,
  `designationId` int(11) NOT NULL,
  `employeeType` varchar(50) NOT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`),
  KEY `fk02_employee_to_department_idx` (`departmentId`),
  KEY `fk03_employee_to_designation_idx` (`designationId`),
  CONSTRAINT `fk01_employee_to_person` FOREIGN KEY (`employeeId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk02_employee_to_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_employee_to_designation` FOREIGN KEY (`designationId`) REFERENCES `designation` (`designationId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `customerId` char(10) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_customer_to_person` FOREIGN KEY (`customerId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `person_contact` (
  `personId` char(10) NOT NULL,
  `contactNumber` char(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`personId`,`contactNumber`),
  UNIQUE KEY `personId_UNIQUE` (`personId`),
  CONSTRAINT `fk01_person_contact_to_person` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_employee_credentials` (
  `onlineEmployeeId` char(10) NOT NULL,
  `employeeId` char(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`onlineEmployeeId`,`employeeId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `onlineEmployeeId_UNIQUE` (`onlineEmployeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`),
  CONSTRAINT `fk01_online_employee_credentials_to_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_customer_credentials` (
  `onlineCustomerId` char(10) NOT NULL,
  `customerId` char(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`onlineCustomerId`,`customerId`),
  UNIQUE KEY `onlineId_UNIQUE` (`onlineCustomerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `fk01_online_customer_credentials_to_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;