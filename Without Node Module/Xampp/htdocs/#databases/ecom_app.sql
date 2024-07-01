-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2024 at 01:06 PM
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
-- Database: `ecom_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `timestamp`) VALUES
(1, 'admin\'s birthday', 'admin@gmail.com', '$2y$10$z07J9pOqmOq5LRsWLu5ni.4sgpRw1njqUG9pIiep0sN206/ExSJM2', '2024-05-20 11:00:29'),
(4, 'ytyrty', 'yrtyrt@gfddfg', '$2y$10$xXjziMVCYKEyXBxciHdyaOcoW3YjQ.GyZ0Zi1o72ka4ge5Y/PveFG', '2024-05-20 12:42:17'),
(5, 'dfghfdh', 'dfgdfg@gfgf', '$2y$10$A0NmAXmvQmSuZcBMEQ2gNeRPeVThJR0Mgl73HhbrOvp2cPtGVPNbW', '2024-05-20 12:44:40'),
(6, 'fgdfg', 'gdfgdf@fdg.fdgf', '$2y$10$eAvLyDtC/l5hzufo//1Gd.4hyvUJmPAER/y7.SZWM/mM76Nalr8/y', '2024-05-20 12:45:43'),
(7, 'Henil Chipani', 'henil123@gmail.com', '$2y$10$rmZYEbKuXwTTF77Hg7Z9EuI06MlzX0LrT2Q5U9GPpbUpGoOgIxuxG', '2024-05-20 12:48:10'),
(8, 'Chirag', 'chirag123@gmail.com', '$2y$10$QgrRfzUjFp7t4eccCjoMb.oa8bLcmK7276fRSan2i.zTMBxJAi7HG', '2024-05-20 14:55:41'),
(9, 'Chirag', 'chirag1234@gmail.com', '$2y$10$dATVlex/1y4579nnRS6UrON.P62fvFqoZm.kC.LA3pgMoQ88L.fxu', '2024-05-20 14:56:52'),
(10, 'deep', 'deep123@gmail.com', '$2y$10$bGo6XawEHd6XWWaSUqL26unpH8E6qyfO6g.zUGf1ZlqxRwJzr0AWm', '2024-05-20 15:00:35'),
(11, 'jkaksdjk', 'hfdshg@fgds.sacd', '$2y$10$.K2GAs1iIquRVapPmOuF5Ooz4jkiG.2P.o4PoJ/UtQdz9pGvGeVUK', '2024-05-20 15:11:01'),
(12, 'jkaksdjk', 'fdsffdshg@fgds.sacd', '$2y$10$QvITfxT0L4Da2C5Oj7xt8.ozA6eZV9J8obcVVFAn3w0po0Rr1vF.G', '2024-05-20 15:11:57'),
(13, 'tyrt', 'ytryrt@gdhdfg', '$2y$10$GccP0oV/4pqaRdp4xYMkI.l3esrO8ZbBWOx.Dgytq9RTi0V/XKe/i', '2024-05-20 15:33:06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
