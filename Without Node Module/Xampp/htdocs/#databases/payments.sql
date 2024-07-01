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
-- Database: `payments`
--

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(8,2) NOT NULL,
  `from_upi` varchar(255) NOT NULL,
  `ref_no` varchar(12) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `amount`, `from_upi`, `ref_no`, `timestamp`) VALUES
(1, 10.00, 'bhavanshuddalwadi@oksbi', '547626542587', '2024-04-11 10:15:06'),
(2, 20.00, 'henilchipani123@oksbi', '265727856278', '2024-04-11 10:30:16'),
(7, 10.00, 'jgfjhf@fgdj.gud', '523653672332', '2024-04-11 13:39:10'),
(9, 20.00, 'hjfg@fdg.fhgdhg', '679427856278', '2024-04-10 14:19:34'),
(10, 38.78, 'dgdf@hfdh', '235226542587', '2024-04-10 14:20:26'),
(11, 100.00, 'fdhgfdgg@fdgdf', '547626542587', '2024-05-01 09:49:50'),
(12, 57.00, 'sdgsdgdsfgf@gf', '947626542587', '2024-05-01 09:49:50'),
(13, 83.00, 'gfdhh@hgdc', '679427856278', '2024-05-02 09:50:06'),
(14, 70.00, 'dgfjh@dfjy', '578626542587', '2024-05-02 09:50:06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
