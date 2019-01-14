-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 14, 2019 at 07:43 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `contactnum`
--

CREATE TABLE `contactnum` (
  `cid` int(11) NOT NULL,
  `number` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactnum`
--

INSERT INTO `contactnum` (`cid`, `number`) VALUES
(1, '8861436596'),
(1, '8310819490');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `department` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `veh_deatils` varchar(15) NOT NULL,
  `compensation` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `designation`, `department`, `address`, `veh_deatils`, `compensation`) VALUES
(1, 'PRADHYUMNA K R', 'devops', 'ISE', 'banglore', 'ka06et9951', '12000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contactnum`
--
ALTER TABLE `contactnum`
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contactnum`
--
ALTER TABLE `contactnum`
  ADD CONSTRAINT `contactnum_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
