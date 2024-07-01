-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2024 at 10:59 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kmk`
--

-- --------------------------------------------------------

--
-- Table structure for table `castes`
--

CREATE TABLE `castes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `castes`
--

INSERT INTO `castes` (`id`, `name`) VALUES
(1, 'General'),
(2, 'OBC'),
(3, 'SC'),
(6, 'ST'),
(7, 'ABC'),
(9, 'XYZ');

-- --------------------------------------------------------

--
-- Table structure for table `registrations`
--

CREATE TABLE `registrations` (
  `id` bigint(20) NOT NULL,
  `kmk_id` varchar(10) NOT NULL,
  `kmk_type` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `mname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `age_group` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `dob` date NOT NULL,
  `sport` int(11) NOT NULL,
  `sub_sport` int(11) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile_img` varchar(255) NOT NULL,
  `weight` decimal(5,2) DEFAULT NULL COMMENT 'Weight (kg)',
  `height` decimal(5,2) DEFAULT NULL COMMENT 'Height (cm)',
  `district` int(11) DEFAULT NULL,
  `taluko` int(11) DEFAULT NULL,
  `village` int(11) DEFAULT NULL,
  `caste` int(11) NOT NULL,
  `g_fname` varchar(255) DEFAULT NULL COMMENT 'Guardian First Name',
  `g_lname` varchar(255) DEFAULT NULL COMMENT 'Guardian Last Name',
  `g_mobile` varchar(20) DEFAULT NULL COMMENT 'Guardian Mobile',
  `c_name` varchar(255) DEFAULT NULL COMMENT 'Coach Name',
  `c_mobile` varchar(20) DEFAULT NULL COMMENT 'Coach Mobile',
  `c_address` varchar(2000) DEFAULT NULL COMMENT 'Coach Address'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registrations`
--

INSERT INTO `registrations` (`id`, `kmk_id`, `kmk_type`, `fname`, `mname`, `lname`, `age_group`, `gender`, `dob`, `sport`, `sub_sport`, `mobile`, `email`, `password`, `profile_img`, `weight`, `height`, `district`, `taluko`, `village`, `caste`, `g_fname`, `g_lname`, `g_mobile`, `c_name`, `c_mobile`, `c_address`) VALUES
(27, 'KMK1352429', 0, 'Jainil', 'K', 'Dalwadi', 3, 0, '2024-03-21', 2, 2, '1234567890', 'jainil.dalwadi@gmail.com', 'oIurkdQw', '', 9.99, 0.99, 2, 2, 2, 3, 'gdfhgf', 'gfjfgh', '6546353343', 'vmgmhg', '3107431706', 'gfdg rgtgf'),
(30, 'KMK7615433', 0, 'sdgdf', 'gfdgdf', 'gdfgdf', 2, 0, '2024-03-20', 1, 2, '1234567890', 'hello123@gmail.com', 'efCsn4Nz', '', 56.00, 464.00, 2, 2, 2, 3, 'jfgh', 'ghfg', '5654764574', 'mhgjgh', '4456436437', 'gfhf hfgh'),
(32, 'KMK2369470', 0, 'dghfdh', 'gfdhd', 'hdf', 3, 0, '2024-03-27', 1, 2, '1234567890', 'henilchhipani@gmail.com', 'Me2yr4Vp', '', 65.00, 547.00, 2, 2, 2, 2, 'ghjghj', 'dfgdfg', '6546353343', 'fgfdg', '5667487654', 'hfgjf yfdyh'),
(33, 'KMK7422579', 0, 'Preet', 'gdsfg', 'dsfsdf', 2, 0, '2024-03-20', 2, 2, '1234567890', 'henilchhipani@gmail.com', 'cu9AkU3B', '352_fgdgdgdfghf.jpg', 43.00, 343.00, 2, 2, 2, 3, 'fg', 'gfdgdf', '6546353343', 'gfdgfd', '4456436437', 'fdgd fdgdf');

-- --------------------------------------------------------

--
-- Table structure for table `sports`
--

CREATE TABLE `sports` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sports`
--

INSERT INTO `sports` (`id`, `name`) VALUES
(1, 'Football'),
(2, 'Race');

-- --------------------------------------------------------

--
-- Table structure for table `sub_sports`
--

CREATE TABLE `sub_sports` (
  `id` int(11) NOT NULL,
  `sport_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sub_sports`
--

INSERT INTO `sub_sports` (`id`, `sport_id`, `name`) VALUES
(1, 2, '100m Race'),
(2, 2, '500m Race'),
(3, 2, '1000m Race'),
(4, 1, 'Henil'),
(5, 1, 'Deep'),
(6, 1, 'Chirag');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `castes`
--
ALTER TABLE `castes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registrations`
--
ALTER TABLE `registrations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_kmk_id` (`kmk_id`);

--
-- Indexes for table `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_sports`
--
ALTER TABLE `sub_sports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `castes`
--
ALTER TABLE `castes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `registrations`
--
ALTER TABLE `registrations`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `sports`
--
ALTER TABLE `sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sub_sports`
--
ALTER TABLE `sub_sports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
