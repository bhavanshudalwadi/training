-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2024 at 01:07 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `profile_app_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(191) NOT NULL,
  `email` varchar(191) NOT NULL,
  `phone` varchar(191) DEFAULT NULL,
  `password` varchar(191) NOT NULL,
  `timestamp` datetime(3) NOT NULL DEFAULT current_timestamp(3)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `phone`, `password`, `timestamp`) VALUES
(1, 'Chintu', 'chintu123@gmail.com', '2353456445', '$2a$10$5fbOvvDI4pt1IrpdQcavjOGwrrnN06d/3El0.Kv2R8iNvRk/92mGS', '2024-06-14 04:55:18.921'),
(3, 'Siddharth', 'sk123@gmail.com', '3647367484', '$2a$10$AIj.VXKtSnjRix4X49cllOWv7Wj.YJtFg6i9KlhKEQugbFHrrkxM6', '2024-06-14 05:10:21.643'),
(4, 'Splitz Programmer', 'splitzpro7@gmail.com', '5476467666', '$2a$10$6F9v8dSbSdCaGlNyUvzNKurfjV1L5XSyLbTdXh/g5kxXo7CW8r7RO', '2024-06-14 05:11:09.212'),
(5, 'Aadarsh', 'aadarsh123@gmail.com', '7852364533', '$2a$10$B3I9lFDTuomhe19fXtnVTeIuByivJju2h.csrbSM/0ZuSUFD1EiGK', '2024-06-14 05:17:09.625');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `User_email_key` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
