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

'1', 'abcd1111f1'
'2', 'abcd1234e5'
'3', 'abcd1111f2'
'4', 'abcd2222e2'
'5', 'abcd2222e3'
'6', 'abcd3333g3'
'7', 'abcd3333g4'

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

'CUST000001', 'KeshiA', 'Customer', 'BogahawatteA', '', '10 Pamunuwa', '', 'Maharagama', 'Western', '10280', '968052031v', '1996-10-31', 'keshaniA@gmail.com', '2018-10-02', '2018-10-02', '2', '1', 'BRAN000001', '1', '0112848701', '0779979351'
'CUST000002', 'VinuA', 'Customer', 'GamageA', NULL, '10 Dehiwela Road', NULL, 'Papiliyana', 'Western', '10005', '985011211v', '1998-01-01', 'sahanigamageA@gmail.com', '2018-10-02', '2018-10-02', '2', '1', 'BRAN000001', '6', '0112731051', '0776950591'
'EMPL000001', 'Isuru', 'HRManager', 'Samarasekara', NULL, '10 Piliyandala Road', NULL, 'Maharagama', 'Western', '10280', '961370211v', '1001-01-01', 'isurusamarasekaraA@gmail.com', '2018-09-07', '2018-09-07', '1', '1', 'BRAN000001', '2', '0112844830', '0772841580'
'EMPL000002', 'KeshiB', 'Manager', 'BogahawatteB', NULL, '20 Pamunuwa', NULL, 'Maharagama', 'Western', '10280', '968052032v', '1996-10-31', 'keshaniB@gmail.com', '2018-10-02', '2018-10-02', '2', '1', 'BRAN000001', '3', '0112848702', '0779979352'
'EMPL000003', 'AtheeqA', 'Head', 'MaharoofA', NULL, '10 st.peter\'s Place', NULL, 'Bambalapitiya', 'Western', '10004', '973451181v', '1997-12-10', 'atheeqrcA@gmail.com', '2018-10-02', '2018-10-02', '1', '2', 'BRAN000001', '4', '0112503381', '0716346041'
'EMPL000004', 'AtheeqB', 'Manager', 'MaharoofB', NULL, '20 st.peter\'s Place', NULL, 'Bambalapitiya', 'Western', '10004', '973451182v', '1997-12-10', 'atheeqrcB@gmail.com', '2018-10-02', '2018-10-02', '1', '2', 'BRAN000001', '5', '0112503382', '0716346042'
'EMPL000005', 'VinuB', 'Manager', 'GamageB', NULL, '20 Dehiwela Road', NULL, 'Papiliyana', 'western', '10005', '985011212v', '1998-01-01', 'sahanigamageB@gmail.com', '2018-10-02', '2018-10-02', '2', '1', 'BRAN000001', '7', '0112731052', '0776950592'

CREATE TABLE `customer` (
  `customerId` char(10) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_customer_to_person` FOREIGN KEY (`customerId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUST000001'
'CUST000002'

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
'7', 'transaction manager', '3'

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
'EMPL000002', 'DEPT000001', 'BogahawatteB96@Company.com', '4', 'normal employee'
'EMPL000003', 'DEPT000002', 'MaharoofA97@Company.com', '5', 'head'
'EMPL000004', 'DEPT000002', 'MaharoofB97@Company.com', '6', 'inventory manager'
'EMPL000005', 'DEPT000003', 'GamageB98@Company.com', '7', 'transaction manager'

CREATE TABLE `leave_details` (
  `employeeId` char(10) NOT NULL,
  `noOfLeavesLeft` int(11) NOT NULL,
  `lastEffectiveLeaveDate` date DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`),
  CONSTRAINT `fk01_leave_details_to_employee` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'EMPL000001', '30', '2018-09-18'
'EMPL000002', '20', '2018-10-02'
'EMPL000003', '35', '2018-10-02'
'EMPL000004', '35', '2018-10-02'
'EMPL000005', '35', '2018-10-02'

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

'CUON000001', 'CUST000001', 'KESHIA', 'keshia', 'a?', 'a', 'b?', 'b'
'CUON000002', 'CUST000002', 'VINUA', 'vinua', 'v?', 'v', 'v?', 'v'

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

'EMON000001', 'EMPL000001', 'ISURUA', 'isurua'
'EMON000002', 'EMPL000002', 'KESHIB', 'keshib'
'EMON000003', 'EMPL000003', 'ATHEEQA', 'atheeqa'
'EMON000004', 'EMPL000004', 'ATHEEQB', 'atheeqb'
'EMON000005', 'EMPL000005', 'VINUB', 'vinub'

CREATE TABLE `accounts` (
  `personId` char(10) NOT NULL,
  `accountNo` int(9) NOT NULL,
  PRIMARY KEY (`accountNo`),
  UNIQUE KEY `personId_UNIQUE` (`personId`),
  UNIQUE KEY `accountNo_UNIQUE` (`accountNo`),
  CONSTRAINT `fk01_account_to_person` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'CUST000001', '202121212'
'CUST000002', '303131313'

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

'1', 'EMPL000006', 'EMON000006', '8', '1', 'CUON000003'

CREATE TABLE `temp_customer_online_reg_pins` (
  `customerId` char(10) NOT NULL,
  `onlineRegPin` int(5) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `custId_UNIQUE` (`customerId`),
  CONSTRAINT `fk01_temp_customer_online_reg_pins_to_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `email_company` (
  `emailId` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(100) DEFAULT NULL,
  `receiver` varchar(100) DEFAULT NULL,
  `subject` varchar(100) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `sentDate` date NOT NULL,
  PRIMARY KEY (`emailId`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`),
  KEY `email_company_to_employee_idx` (`sender`),
  KEY `fk02_email_company_to_employee_idx` (`receiver`),
  CONSTRAINT `fk01_email_company_to_employee` FOREIGN KEY (`sender`) REFERENCES `employee` (`companyEmail`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk02_email_company_to_employee` FOREIGN KEY (`receiver`) REFERENCES `employee` (`companyEmail`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

