
 	Script of,
		IT17134668 (Gamage V.S.)


CREATE DATABASE `itp_2018_mlb_g3_10_sampath_web_portal_vinu` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `bankaccount` (
  `accno` int(11) NOT NULL,
  `balance` varchar(45) NOT NULL,
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


'202121212', '1106000.0'
'303131313', '894000.0'

CREATE TABLE `intratransaction` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `accno` int(11) NOT NULL,
  `taccno` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pin` (
  `pinid` int(11) NOT NULL,
  `accno` int(11) NOT NULL,
  PRIMARY KEY (`pinid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `transaction` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `accno` int(11) NOT NULL,
  `taccno` int(11) NOT NULL,
  `date` varchar(45) NOT NULL,
  `amount` double NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


'3', '303131313', '202121212', '2018-10-02', '1000', 'approved'
'4', '303131313', '202121212', '2018-10-02', '100000', 'approved'
'5', '303131313', '202121212', '2018-10-02', '5000', 'approved'
'6', '303131313', '202121212', '2018-10-02', '100000', 'pending'

