CREATE DATABASE `itp_2018_mlb_g3_10_sampath_web_portal` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `gender` (
  `genderId` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`genderId`),
  UNIQUE KEY `gender_UNIQUE` (`gender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'2', 'female'
'1', 'male'

CREATE TABLE `nationality` (
  `nationalityId` int(11) NOT NULL,
  `nationality` varchar(20) NOT NULL,
  PRIMARY KEY (`nationalityId`),
  UNIQUE KEY `nationality_UNIQUE` (`nationality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'2', 'muslim'
'1', 'sinhalese'
'3', 'tamil'

CREATE TABLE `branch` (
  `branchId` char(10) NOT NULL,
  `branchAddressStreet01` varchar(100) NOT NULL,
  `branchAddressStreet02` varchar(100) DEFAULT NULL,
  `branchAddressCity` varchar(50) NOT NULL,
  `branchAddressProvince` varchar(50) NOT NULL,
  `branchAddressZipCode` int(5) NOT NULL,
  `branchEmail` varchar(100) NOT NULL,
  PRIMARY KEY (`branchId`),
  UNIQUE KEY `branchId_UNIQUE` (`branchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'BRAN000001', 'branch 01 address 1', '', 'branch 01 city', 'branch 01 province', '11111', 'branch01@sampath.lk'
'BRAN000002', 'branch 02 address 1', '', 'branch 02 city', 'branch 02 province', '22222', 'branch02@sampath.lk'
'BRAN000003', 'branch 03 address 1', NULL, 'branch 03 city', 'branch 03 province', '33333', 'branch03@sampath.lk'

CREATE TABLE `online_security_key` (
  `onlineSecurityId` int(11) NOT NULL,
  `onlineSecurityKey` char(10) NOT NULL,
  PRIMARY KEY (`onlineSecurityId`),
  UNIQUE KEY `onlineSecurityId_UNIQUE` (`onlineSecurityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'1', 'abcd1234e5'
'2', 'abcd4567f8'

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
  `onlineSecurityId` int(11) DEFAULT NULL,
  `homeContact` char(10) NOT NULL,
  `mobileContact` char(10) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  UNIQUE KEY `personId_UNIQUE` (`personId`),
  UNIQUE KEY `nic_UNIQUE` (`nic`),
  UNIQUE KEY `personalEmail_UNIQUE` (`personalEmail`),
  UNIQUE KEY `onlineSecurityId_UNIQUE` (`onlineSecurityId`),
  KEY `fk01_person_to_gender_idx` (`genderId`),
  KEY `fk03_person_to_branch_idx` (`branchId`),
  KEY `fk02_person_to_nationality_idx` (`nationalityId`),
  KEY `fk04_person_to_online_security_key_idx` (`onlineSecurityId`),
  CONSTRAINT `fk01_person_to_gender` FOREIGN KEY (`genderId`) REFERENCES `gender` (`genderId`) ON UPDATE CASCADE,
  CONSTRAINT `fk02_person_to_nationality` FOREIGN KEY (`nationalityId`) REFERENCES `nationality` (`nationalityId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_person_to_branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_person_to_online_security_key` FOREIGN KEY (`onlineSecurityId`) REFERENCES `online_security_key` (`onlineSecurityId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUST000001', 'Keshi', '', 'Bogahawatte', '', '123', '', 'abc', 'Western', '11111', '961111111v', '1001-01-01', 'kb@gmail.com', '2018-09-07', '2018-09-07', '2', '1', 'BRAN000001', '1', '0112874874', '077847847'
'EMPL000001', 'Isuru', NULL, 'Samarasekara', NULL, '83/2 Piliyandala Road', NULL, 'Maharagama', 'eastern', '10280', '964444444v', '1001-01-01', 'isuru@gmail.com', '2018-09-07', '2018-09-18', '1', '1', 'BRAN000001', '2', '0112844830', '0772841580'

CREATE TABLE `customer` (
  `customerId` char(10) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_customer_to_person` FOREIGN KEY (`customerId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUST000001'

CREATE TABLE `department` (
  `branchId` char(10) NOT NULL,
  `departmentId` char(10) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  PRIMARY KEY (`departmentId`,`branchId`),
  KEY `fk01_department_to_branch_idx` (`branchId`),
  CONSTRAINT `fk01_department_to_branch` FOREIGN KEY (`branchId`) REFERENCES `branch` (`branchId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'BRAN000001', 'DEPT000001', 'human resource'
'BRAN000001', 'DEPT000002', 'inventory'
'BRAN000001', 'DEPT000003', 'transaction'
'BRAN000001', 'DEPT000004', 'loan'
'BRAN000002', 'DEPT000005', 'human resource'
'BRAN000002', 'DEPT000006', 'inventory'
'BRAN000002', 'DEPT000007', 'transaction'
'BRAN000002', 'DEPT000008', 'loan'
'BRAN000003', 'DEPT000009', 'human resource'
'BRAN000003', 'DEPT000010', 'inventory'
'BRAN000003', 'DEPT000011', 'transaction'
'BRAN000003', 'DEPT000012', 'loan'

CREATE TABLE `leave_days` (
  `leaveDaysId` int(11) NOT NULL,
  `noOfLeavesPerYear` int(11) NOT NULL,
  PRIMARY KEY (`leaveDaysId`),
  UNIQUE KEY `leaveDaysId_UNIQUE` (`leaveDaysId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'1', '20'
'2', '30'
'3', '35'

CREATE TABLE `designation` (
  `designationId` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `leaveDaysId` int(11) NOT NULL,
  PRIMARY KEY (`designationId`),
  UNIQUE KEY `designationId_UNIQUE` (`designationId`),
  KEY `fk01_designation_to_leave_days_idx` (`leaveDaysId`),
  CONSTRAINT `fk01_designation_to_leave_days` FOREIGN KEY (`leaveDaysId`) REFERENCES `leave_days` (`leaveDaysId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'1', 'normal employee', '1'
'2', 'human resource manager', '2'
'3', 'admin', '3'
'4', 'user manager', '1'
'5', 'head', '3'
'6', 'inventory manager', '3'
'7', 'inventory employee', '3'

CREATE TABLE `employee` (
  `employeeId` char(10) NOT NULL,
  `departmentId` char(10) NOT NULL,
  `companyEmail` varchar(100) NOT NULL,
  `designationId` int(11) NOT NULL,
  `employeeType` varchar(50) NOT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`),
  UNIQUE KEY `companyEmail_UNIQUE` (`companyEmail`),
  KEY `fk02_employee_to_department_idx` (`departmentId`),
  KEY `fk03_employee_to_designation_idx` (`designationId`),
  CONSTRAINT `fk01_employee_to_person` FOREIGN KEY (`employeeId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk02_employee_to_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk03_employee_to_designation` FOREIGN KEY (`designationId`) REFERENCES `designation` (`designationId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'EMPL000001', 'DEPT000001', 'isuru@Company.com', '2', 'manager'

CREATE TABLE `leave_details` (
  `employeeId` char(10) NOT NULL,
  `noOfLeavesLeft` int(11) NOT NULL,
  `lastEffectiveLeaveDate` date DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`),
  CONSTRAINT `fk01_leave_details_to_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'EMPL000001', '30', '2018-09-18'

CREATE TABLE `leave_request` (
  `employeeId` char(10) NOT NULL,
  `leaveRequestId` int(11) NOT NULL,
  `leaveType` varchar(50) NOT NULL,
  `leaveDescription` varchar(2000) NOT NULL,
  `leaveRequestedDate` date NOT NULL,
  `leaveStartDate` date NOT NULL,
  `leaveDuration` int(11) NOT NULL,
  `leaveStatus` varchar(50) NOT NULL,
  `leaveReviewedBy` char(10) DEFAULT NULL,
  `leaveReviewSpeed` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employeeId`,`leaveRequestId`),
  CONSTRAINT `fk01_leave_request_to_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `online_customer_credentials` (
  `onlineCustomerId` char(10) NOT NULL,
  `customerId` char(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `question01` varchar(100) NOT NULL,
  `answer01` varchar(100) NOT NULL,
  `question02` varchar(100) NOT NULL,
  `answer02` varchar(100) NOT NULL,
  PRIMARY KEY (`onlineCustomerId`,`customerId`),
  UNIQUE KEY `onlineId_UNIQUE` (`onlineCustomerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `fk01_online_customer_credentials_to_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUON000001', 'CUST000001', 'KESHI', 'keshi', 'a?', 'a', 'b?', 'b'

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

'EMON000001', 'EMPL000001', 'ISURU', 'isuru'

CREATE TABLE `accounts` (
  `personId` char(10) NOT NULL,
  `accountNo` int(9) NOT NULL,
  PRIMARY KEY (`accountNo`),
  UNIQUE KEY `personId_UNIQUE` (`personId`),
  UNIQUE KEY `accountNo_UNIQUE` (`accountNo`),
  CONSTRAINT `fk01_account_to_person` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUST000001', '202121212'

CREATE TABLE `customer_registration_requests` (
  `customerId` char(10) NOT NULL,
  `question01` varchar(100) DEFAULT NULL,
  `answer01` varchar(100) DEFAULT NULL,
  `question02` varchar(100) DEFAULT NULL,
  `answer02` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_customer_registration_requests_to_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee_update_requests` (
  `employeeId` char(10) NOT NULL,
  `addressStreet01` varchar(100) DEFAULT NULL,
  `addressStreet02` varchar(100) DEFAULT NULL,
  `addressCity` varchar(50) DEFAULT NULL,
  `addressProvince` varchar(50) DEFAULT NULL,
  `addressZipCode` int(5) DEFAULT NULL,
  `personalEmail` varchar(100) DEFAULT NULL,
  `homeContact` char(10) DEFAULT NULL,
  `mobileContact` char(10) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `empoyeeId_UNIQUE` (`employeeId`),
  CONSTRAINT `fk01_employee_update_requests_to_person` FOREIGN KEY (`employeeId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `inactive_employees` (
  `employeeId` char(10) NOT NULL,
  `reason` varchar(100) NOT NULL,
  `inactivationDate` date DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  CONSTRAINT `fk01_inactive_employees_to_person` FOREIGN KEY (`employeeId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `next_primary_keys` (
  `primaryKey` int(11) NOT NULL,
  `nextEmployeeId` char(10) NOT NULL,
  `nextOnlineEmployeeId` char(10) NOT NULL,
  `nextOnlineSecurityId` int(11) NOT NULL,
  `leaveRequestId` int(11) NOT NULL,
  `nextOnlineCustomerId` char(10) DEFAULT NULL,
  PRIMARY KEY (`primaryKey`),
  UNIQUE KEY `primaryKey_UNIQUE` (`primaryKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'1', 'EMPL00002', 'EMON000002', '3', '1', 'CUON000002'

CREATE TABLE `temp_customer_online_reg_pins` (
  `customerId` char(10) NOT NULL,
  `onlineRegPin` int(5) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `custId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_temp_customer_online_reg_pins_to_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

