CREATE DATABASE `itp_2018_mlb_g3_10_sampath_web_portal_atheeq` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `im_branch_item` (
  `branchItemId` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`branchItemId`),
  UNIQUE KEY `idbranch_item_UNIQUE` (`branchItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'AA01', 'Paper', '0'
'AA02', 'Computer', '0'
'AA03', 'Passbook', '0'
'AA04', 'Repairing Tools', '0'

CREATE TABLE `im_history` (
  `histId` varchar(10) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `ItemId` varchar(10) DEFAULT NULL,
  `ItemName` varchar(100) DEFAULT NULL,
  `action` varchar(1000) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `fromQty` int(11) DEFAULT NULL,
  `toQty` int(11) DEFAULT NULL,
  `dateAndTime` varchar(100) NOT NULL,
  PRIMARY KEY (`histId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


'HH01', 'ATHEEQB', 'AA01', 'Paper', 'New', '1000', '0', '1000', 'Wed 2018-10-03 at 12:07:37 PM IST'
'HH02', 'ATHEEQB', 'AA02', 'Computer', 'New', '50', '0', '50', 'Wed 2018-10-03 at 12:09:53 PM IST'
'HH03', 'ATHEEQB', 'AA03', 'Passbook', 'New', '500', '0', '500', 'Wed 2018-10-03 at 12:10:40 PM IST'
'HH04', 'ATHEEQB', 'AA03', 'Passbook', 'New', '500', '0', '500', 'Wed 2018-10-03 at 12:10:40 PM IST'
'HH05', 'ATHEEQB', 'AA04', 'Repairing Tools', 'New', '50', '0', '50', 'Wed 2018-10-03 at 12:11:54 PM IST'


CREATE TABLE `im_inventory_item` (
  `itemId` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `measurement` varchar(45) NOT NULL,
  `lowStockLevel` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `image` varchar(45) NOT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

'AA01', 'Paper', '1000', 'Bundle', '500', 'About Paper', 'paper.png'
'AA02', 'Computer', '50', 'Number', '25', 'About Computer', 'computer.png'
'AA03', 'Passbook', '500', 'Number', '250', 'About Passbook', 'passbook.png'
'AA04', 'Repairing Tools', '50', 'Number', '25', 'About Repairing Tools', 'repairing_tool.png'

CREATE TABLE `im_request_item` (
  `refId` varchar(45) NOT NULL,
  `head_username` varchar(45) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `itemId` varchar(45) NOT NULL,
  `itemName` varchar(45) NOT NULL,
  `requestAmount` varchar(45) NOT NULL,
  PRIMARY KEY (`refId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






