/*
SQLyog Community Edition- MySQL GUI v5.20
Host - 5.0.45-community-nt : Database - cloudupload
*********************************************************************
Server version : 5.0.45-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `cloudupload`;

USE `cloudupload`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `grouplist` */

DROP TABLE IF EXISTS `grouplist`;

CREATE TABLE `grouplist` (
  `gid` int(10) unsigned NOT NULL auto_increment,
  `gname` varchar(45) default NULL,
  `contact` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `skey` varchar(45) default NULL,
  PRIMARY KEY  (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `grouplist` */

insert  into `grouplist`(`gid`,`gname`,`contact`,`email`,`skey`) values (4,'Group1','VSpace','vspace@gmail.com','k4aBBzbgFgWTIc8R'),(5,'MumbaiRocks','Mumbailog','ajit@gmail.com','CUFP74cDXr7SOFGv');

/*Table structure for table `privilegekeys` */

DROP TABLE IF EXISTS `privilegekeys`;

CREATE TABLE `privilegekeys` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `uid` int(10) unsigned default NULL,
  `ekey` varchar(45) default NULL,
  `fname` varchar(50) default NULL,
  `lname` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `groupid` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `privilegekeys` */

insert  into `privilegekeys`(`id`,`uid`,`ekey`,`fname`,`lname`,`email`,`groupid`) values (7,7,'k4aBBzbgFgWTIc8R','Tuljaram','Koli','tuljaram@vspace.in',4),(8,8,'k4aBBzbgFgWTIc8R','Bharat','Bhagat','bharat@vspace.in',4),(10,13,'CUFP74cDXr7SOFGv','Ravi','Saini','ravisaini1611@gmail.com',5);

/*Table structure for table `sizechunk` */

DROP TABLE IF EXISTS `sizechunk`;

CREATE TABLE `sizechunk` (
  `chunk` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sizechunk` */

insert  into `sizechunk`(`chunk`) values (10),(1),(1),(23);

/*Table structure for table `userfiledetails` */

DROP TABLE IF EXISTS `userfiledetails`;

CREATE TABLE `userfiledetails` (
  `id` int(5) NOT NULL auto_increment,
  `filename` varchar(100) default NULL,
  `uploaddate` date default NULL,
  `uploadtime` time default NULL,
  `hash` varchar(100) default NULL,
  `link` int(10) default '0',
  `fid` int(5) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Data for the table `userfiledetails` */

insert  into `userfiledetails`(`id`,`filename`,`uploaddate`,`uploadtime`,`hash`,`link`,`fid`) values (1,'out0.chunk','2016-02-18','15:41:21','11c214fdbbe7c062c93b9d333f8c58d2dca9605a',0,71),(2,'out0.chunk','2016-02-18','16:09:33','3f37fce07052244260cf8a80eceff7c7df0baeec',0,71),(3,'out1.chunk','2016-02-18','16:09:33','21a7e1d74bbf9937d3cf17fdd9388470fd317922',0,71),(4,'out2.chunk','2016-02-18','16:09:33','b789b1a0a8858d909447729a7f4a078f8d2fbf74',0,71),(5,'out3.chunk','2016-02-18','16:09:33','9503b65d31a28ba52a56d30b34dc37396724bfe6',0,71),(6,'out0.chunk','2016-02-19','15:04:55','a503799dc096b384b5611973ea9547ae62a52c64',0,71),(7,'out0.chunk','2016-02-19','16:24:05','a503799dc096b384b5611973ea9547ae62a52c64',0,101),(8,'out0.chunk','2016-02-26','12:24:15','746407460765ff7c073c113b38c6306b229a9d65',0,131),(9,'out0.chunk','2016-02-26','19:01:56','f4f341b686022c8fed8fa865fbc9be218b6a7e27',0,131),(10,'out0.chunk','2016-02-29','01:05:47','4668c25750ea8f328ae87f2d319556a757fe221e',0,131),(11,'out1.chunk','2016-02-29','01:05:47','48022a4ad449c722821aa6b94f03c22956c2cdc5',0,131),(12,'out2.chunk','2016-02-29','01:05:47','80a1afef0d9a75e711301b358fb0530562210422',0,131),(13,'out3.chunk','2016-02-29','01:05:47','ccee53bf656a291fd4f5f2551b9eb177a4dd7570',0,131),(14,'out4.chunk','2016-02-29','01:05:47','a398f3c15b7bb42f9c2ffe36889bbaf006c9c837',0,131),(15,'out5.chunk','2016-02-29','01:05:47','ba133e38b73f0ec2ff5885ed5fa68bee0e736f17',0,131),(16,'out6.chunk','2016-02-29','01:05:47','7b656fa55f37bccf47b68d6179b5acdd6f5b894d',0,131),(17,'out7.chunk','2016-02-29','01:05:48','22536e3789c6a609d3968363e29c6517316bb4cd',0,131),(18,'out8.chunk','2016-02-29','01:05:48','6738860b1b326dd146da9485cc60feee274513f0',0,131),(19,'out9.chunk','2016-02-29','01:05:48','7cf4cfe778d1e8bba3b0c87777c1def994f52ba1',0,131),(20,'out10.chunk','2016-02-29','01:05:48','45d5aae1ec06b1c45986fedc59e8f1297085baa4',0,131),(21,'out11.chunk','2016-02-29','01:05:48','97e8a3e86d9073ad042d947c07347733a42a6dc4',0,131),(22,'out12.chunk','2016-02-29','01:05:48','a1e4a778a45363556f7e8f9f199cff7dd50ff98d',0,131),(23,'out13.chunk','2016-02-29','01:05:48','5edbedc492d516d4726d3bf66f30629524f47111',0,131),(24,'out14.chunk','2016-02-29','01:05:48','ab24c1757e0d34fc1040c75c2079a15b2c92077d',0,131),(25,'out15.chunk','2016-02-29','01:05:49','d8bd2211f0214f815fc82fcb30cad9bc8fca533a',0,131),(26,'out16.chunk','2016-02-29','01:05:49','cf6de7dbf5df980b4a5a8a9c45e4e7e5976da351',0,131),(27,'out17.chunk','2016-02-29','01:05:49','f4b26bc48f6af3c6250302e3f2fe75030855d9b1',0,131),(28,'out18.chunk','2016-02-29','01:05:49','e7410bf29bae0b0351636b3ea9ac98d205636035',0,131),(29,'out19.chunk','2016-02-29','01:05:49','d218a31e5ae6ae6b75f566dccf302ebcd9a71886',0,131),(30,'out20.chunk','2016-02-29','01:05:49','ccdab2c83a1ac7a25db49159a7f5939829ef0ef5',0,131),(31,'out21.chunk','2016-02-29','01:05:50','ec40c510e3328f47ee3f3418dae6c58b566a75da',0,131),(32,'out22.chunk','2016-02-29','01:05:50','aea671b99bdc2f780f56305dcac76221ada88540',0,131);

/*Table structure for table `userfilelist` */

DROP TABLE IF EXISTS `userfilelist`;

CREATE TABLE `userfilelist` (
  `id` int(5) NOT NULL auto_increment,
  `uid` int(5) default NULL,
  `filename` varchar(100) default NULL,
  `uploaddate` date default NULL,
  `uploadtime` time default NULL,
  `filestartid` int(5) default '0',
  `fileendid` int(5) default '0',
  `foldername` varchar(100) default '0',
  `status` int(2) default '0',
  `hash` varchar(100) default NULL,
  `share` int(2) default '0',
  `link` int(10) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `userfilelist` */

insert  into `userfilelist`(`id`,`uid`,`filename`,`uploaddate`,`uploadtime`,`filestartid`,`fileendid`,`foldername`,`status`,`hash`,`share`,`link`) values (10,13,'qwert.txt','2016-02-29','14:18:20',1,0,'qwert.txt',0,'89d9f63dc373474312747b8d9c866feaa614da68',0,0);

/*Table structure for table `userregistration` */

DROP TABLE IF EXISTS `userregistration`;

CREATE TABLE `userregistration` (
  `uid` int(11) NOT NULL auto_increment,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `dateofbirth` varchar(10) NOT NULL,
  `mobileno` varchar(10) NOT NULL,
  `gender` varchar(10) default NULL,
  `emailid` varchar(30) default NULL,
  `password` varchar(10) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `userregistration` */

insert  into `userregistration`(`uid`,`firstname`,`lastname`,`dateofbirth`,`mobileno`,`gender`,`emailid`,`password`) values (7,'Tuljaram','Koli','22-8-1993','9876543210','Male','tuljaram@vspace.in','1234'),(8,'Bharat','Bhagat','15-12-1990','1234567890','Male','bharat@vspace.in','1234'),(13,'Ravi','Saini','16/11/1990','8551823827','Male','ravisaini1611@gmail.com','saini6');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
