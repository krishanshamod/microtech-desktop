-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 18, 2022 at 05:49 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `microtech`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `usermail` varchar(50) NOT NULL,
  `addr_line1` varchar(200) NOT NULL,
  `addr_line2` varchar(200) NOT NULL,
  `city` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `zip` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`usermail`, `addr_line1`, `addr_line2`, `city`, `country`, `zip`) VALUES
('chandrakumara@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123),
('devin@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123),
('hasinisama99@gmail.com', 'No: 123/A', 'Flower Road', 'Colombo', 'Sri Lanka', 123),
('kajanthan@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123),
('krishan@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123),
('meg@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123),
('paul@gmail.com', 'No:123/A', 'flower road', 'colombo', 'sri lanka', 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`usermail`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
