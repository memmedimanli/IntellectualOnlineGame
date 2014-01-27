-- phpMyAdmin SQL Dump
-- version 2.8.2.4
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Jan 28, 2014 at 12:29 AM
-- Server version: 5.0.51
-- PHP Version: 5.1.6
-- 
-- Database: `db_nhn`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `comment`
-- 

CREATE TABLE `comment` (
  `Comment_id` int(11) NOT NULL auto_increment,
  `Content` text NOT NULL,
  `Author_id` int(11) NOT NULL,
  `Like` int(11) NOT NULL default '0',
  `Parent_id` int(11) default NULL,
  PRIMARY KEY  (`Comment_id`),
  KEY `Author_id_idx` (`Author_id`),
  KEY `Parent_id_idx` (`Parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `comment`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `contest`
-- 

CREATE TABLE `contest` (
  `Contest_id` int(11) NOT NULL auto_increment,
  `Winner_id` int(11) default NULL,
  `ContestName` varchar(100) NOT NULL,
  `BeginTime` datetime NOT NULL,
  `Duration` time NOT NULL,
  `Season_id` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY  (`Contest_id`),
  KEY `seasonContest` (`Season_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `contest`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `forum`
-- 

CREATE TABLE `forum` (
  `Forum_id` int(11) NOT NULL auto_increment,
  `Title` varchar(200) NOT NULL,
  `Content` text NOT NULL,
  `Author` int(11) NOT NULL,
  `Like` int(11) NOT NULL default '0',
  PRIMARY KEY  (`Forum_id`),
  KEY `authorForum` (`Author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `forum`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `invitation`
-- 

CREATE TABLE `invitation` (
  `Invitation_id` int(11) NOT NULL auto_increment,
  `FromTeam` int(11) NOT NULL,
  `ToUser` int(11) NOT NULL,
  `Status` int(11) NOT NULL default '0' COMMENT 'Status may be in 3 form. 0-pending, 1-accepted, 2-rejected',
  PRIMARY KEY  (`Invitation_id`),
  KEY `touserInvitation` (`ToUser`),
  KEY `fromteamInvitation` (`FromTeam`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `invitation`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `members`
-- 

CREATE TABLE `members` (
  `User_id` int(11) NOT NULL,
  `team1_id` int(11) NOT NULL,
  PRIMARY KEY  (`User_id`),
  KEY `teamidMembers` (`team1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `members`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `question`
-- 

CREATE TABLE `question` (
  `Question_id` int(11) NOT NULL auto_increment,
  `Content` text NOT NULL,
  `Answer` varchar(200) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Comment` varchar(200) NOT NULL,
  PRIMARY KEY  (`Question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `question`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `rekvizit`
-- 

CREATE TABLE `rekvizit` (
  `picture` varchar(200) NOT NULL,
  PRIMARY KEY  (`picture`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `rekvizit`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `score`
-- 

CREATE TABLE `score` (
  `Score_id` int(11) NOT NULL auto_increment,
  `Team_id` int(11) NOT NULL,
  `Contest_id` int(11) NOT NULL,
  `Answer` int(11) NOT NULL,
  PRIMARY KEY  (`Score_id`),
  KEY `teamidScore` (`Team_id`),
  KEY `contestidScore` (`Contest_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `score`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `season`
-- 

CREATE TABLE `season` (
  `Season_id` int(11) NOT NULL auto_increment,
  `SeasonName` varchar(50) NOT NULL,
  `Date` datetime NOT NULL,
  PRIMARY KEY  (`Season_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `season`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `team`
-- 

CREATE TABLE `team` (
  `Team_id` int(11) NOT NULL auto_increment,
  `TeamName` varchar(50) NOT NULL,
  `Captain_id` int(11) NOT NULL,
  `Count` int(11) NOT NULL default '1',
  PRIMARY KEY  (`Team_id`),
  UNIQUE KEY `TeamName_UNIQUE` (`TeamName`),
  UNIQUE KEY `Captain_id_UNIQUE` (`Captain_id`),
  KEY `captainidTeam` (`Captain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- Dumping data for table `team`
-- 

INSERT INTO `team` VALUES (1, 'ASDF', 1, 1);

-- --------------------------------------------------------

-- 
-- Table structure for table `users`
-- 

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL auto_increment,
  `Name` varchar(50) default NULL,
  `Surname` varchar(50) default NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `University` varchar(45) default NULL,
  `About` varchar(500) default NULL,
  `RegisterDate` datetime NOT NULL,
  `Birthday` date default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- Dumping data for table `users`
-- 

INSERT INTO `users` VALUES (1, 'hikmet', 'haciyev', 'hikmet655', 'asdf', 'asdf', 'asdf', 'asdf', '0000-00-00 00:00:00', NULL);

-- 
-- Constraints for dumped tables
-- 

-- 
-- Constraints for table `comment`
-- 
ALTER TABLE `comment`
  ADD CONSTRAINT `authorComment` FOREIGN KEY (`Author_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `parentComment` FOREIGN KEY (`Parent_id`) REFERENCES `forum` (`Forum_id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints for table `forum`
-- 
ALTER TABLE `forum`
  ADD CONSTRAINT `authorForum` FOREIGN KEY (`Author`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints for table `members`
-- 
ALTER TABLE `members`
  ADD CONSTRAINT `teamidMembers` FOREIGN KEY (`team1_id`) REFERENCES `team` (`Team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `useridMembers` FOREIGN KEY (`User_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints for table `team`
-- 
ALTER TABLE `team`
  ADD CONSTRAINT `captainidTeam` FOREIGN KEY (`Captain_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
