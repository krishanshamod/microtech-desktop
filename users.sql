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
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(30) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email_verification_link` varchar(255) DEFAULT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `f_name`, `l_name`, `phone_no`, `password`, `email_verification_link`, `email_verified_at`, `status`) VALUES
('chandrakumara@gmail.com', 'chandrakumara', 'dissanayake', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 0),
('devin@gmail.com', 'devin', 'jayawardena', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 1),
('hasinisama99@gmail.com', 'Hasini', 'Samarathunga', '1234556777', '202cb962ac59075b964b07152d234b70', '6008ad9b551eba21f097ba66b63f3bc5385', '2022-01-12 22:51:25', 1),
('kajanthan@gmail.com', 'kajanthan', 'kumar', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 1),
('krishan@gmail.com', 'krishan', 'shamod', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 1),
('meg@gmail.com', 'meg', 'griffin', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 0),
('paul@gmail.com', 'paul', 'smith', '876543234', '202cb962ac59075b964b07152d234b70', NULL, NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
