-- phpMyAdmin SQL Dump
-- version 5.2.1-4.fc40
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Wrz 30, 2024 at 01:03 PM
-- Wersja serwera: 8.0.39
-- Wersja PHP: 8.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `username`, `password`) VALUES
(1, 'admin@ws.com', 'admin', 'admin123'),
(2, 'test@ws.com', 'test', 'test1234'),
(4, 'bruce@gotham.com', 'batsy', 'gotham123');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `coach`
--

CREATE TABLE `coach` (
  `id` int NOT NULL,
  `coachId` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(100) NOT NULL,
  `phone` int NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`id`, `coachId`, `name`, `surname`, `email`, `age`, `gender`, `phone`, `status`) VALUES
(14, 'SZC-PL-WS', 'Weronika', 'Stępień', 'example@test.com', 24, 'Female', 111111111, 'Active'),
(15, 'NY-USA-TC', 'Thomas', 'Crown', 'test@example.com', 36, 'Male', 222222222, 'Inactive'),
(16, 'GOT-USA-BW', 'Bruce', 'Wayne', 'test@test.com', 32, 'Male', 333333333, 'Active'),
(17, 'GOT-USA-SK', 'Selina', 'Kyle', 'example@example.com', 30, 'Female', 444444444, 'Inactive');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `member`
--

CREATE TABLE `member` (
  `id` int NOT NULL,
  `memberId` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `address` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `phone` int NOT NULL,
  `status` varchar(100) NOT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `schedule` varchar(100) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `memberId`, `name`, `surname`, `email`, `age`, `address`, `gender`, `phone`, `status`, `startDate`, `endDate`, `schedule`, `price`) VALUES
(6, 'CAL-USA-DT', 'Dominic', 'Toretto', 'example@example', 29, 'example', 'Male', 22222222, 'Unpaid', '2019-06-20', '2019-06-25', '9 AM - 11 AM', 1900),
(9, 'LON-UK-JB', 'James', 'Bond', 'test@test.com', 32, 'test', 'Male', 111111111, 'Paid', '2023-06-08', '2023-06-16', '1:30 PM - 3 PM', 1750),
(10, 'SZC-PL-WS', 'Weronika', 'Stępień', 'test@example.com', 24, 'test test', 'Female', 333333333, 'Paid', '2023-03-01', '2024-03-07', '5:30 PM - 7 PM', 6250),
(12, 'CAL-USA-LT', 'Letty', 'Toretto', 'example@test.com', 26, 'example', 'Female', 444444444, 'Unpaid', '2023-06-22', '2023-06-30', '11:30 AM - 1 PM', 18400);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `coachId` (`coachId`),
  ADD KEY `coachId_2` (`coachId`);

--
-- Indeksy dla tabeli `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `coach`
--
ALTER TABLE `coach`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
