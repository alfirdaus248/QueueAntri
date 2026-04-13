-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2026 at 12:06 PM
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
-- Database: `rumah_sakit`
--

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_pasien`
--

CREATE TABLE `riwayat_pasien` (
  `nama` varchar(50) NOT NULL,
  `usia` int(11) NOT NULL,
  `keluhan` varchar(50) NOT NULL,
  `prioritas` varchar(10) NOT NULL,
  `waktu_kedatangan` datetime NOT NULL,
  `waktu_selesai` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `riwayat_pasien`
--

INSERT INTO `riwayat_pasien` (`nama`, `usia`, `keluhan`, `prioritas`, `waktu_kedatangan`, `waktu_selesai`) VALUES
('Budi', 20, 'Tipes', '1', '2024-11-29 20:24:21', '2024-11-29 13:24:43'),
('Somad', 24, 'DBD', '1', '2024-11-29 20:26:01', '2024-11-29 13:26:13'),
('Andi', 21, 'Flu', '2', '2024-12-01 23:40:20', '2024-12-01 16:40:41'),
('Andi', 21, 'Flu', '2', '2024-12-01 23:41:37', '2024-12-01 16:41:41'),
('Ari', 20, 'Mag', '2', '2024-12-02 00:36:11', '2024-12-01 17:36:15'),
('Andi', 20, 'Lambung', '2', '2024-12-02 12:09:45', '2024-12-02 05:10:04'),
('Arif', 22, 'Flu', '2', '2024-12-02 12:14:13', '2024-12-02 05:14:52'),
('Riski', 25, 'Demam', '2', '2024-12-02 12:14:44', '2024-12-02 05:15:33'),
('Abdan', 19, 'TB', '2', '2024-12-02 12:15:14', '2024-12-02 05:15:35'),
('Sony', 24, 'Tipes', '1', '2024-12-02 21:04:12', '2024-12-02 14:05:03');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
