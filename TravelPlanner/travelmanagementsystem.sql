-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2024 at 09:07 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `security` varchar(100) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `occupation` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `name`, `password`, `security`, `answer`, `occupation`) VALUES
('Rahul123', 'Rahul Modi', '1234', 'Fav character from Marvel.', 'Hulk', 'Customer'),
('Stavan123', 'Stavan Shah', '123', 'Fav character from Marvel.', 'Hulk', 'Customer'),
('Samir345', 'Samir Kothari', '123', 'Fav character from Marvel.', 'Iron Man', 'Customer'),
('Darshika12', 'Darshika Shah', '112233', 'Fav character from Marvel.', 'SpiderMan', 'Customer'),
('reema ', 'reema n shah', '1234', 'Fav character from Marvel.', 'hulk', 'Customer'),
('Meet123', 'Meet Kapadi', '1234', 'Fav character from Marvel.', 'Hulk', 'Customer'),
('acd', ' hj', 'jk', 'Fav Character from The Boys.', 'jkb', 'Customer'),
('Rocky12', 'Rocky', '1234', 'Fav Character from The Boys.', 'XYZ', 'Customer'),
('Moksh', 'Moksh kothari', '1234', 'Fav character from Marvel.', 'Hulk', 'Customer'),
('Rahul Kothari', 'Rahul', '123123', 'Fav character from Marvel.', 'Hulk', 'Customer'),
('Abhishek123', 'Abhishek ', '123123', 'Fav character from Marvel.', 'Hulk', 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `bookhotel`
--

CREATE TABLE `bookhotel` (
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL,
  `ac` varchar(10) DEFAULT NULL,
  `food` varchar(10) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `cost` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookhotel`
--

INSERT INTO `bookhotel` (`username`, `name`, `persons`, `days`, `ac`, `food`, `id`, `number`, `phone`, `cost`) VALUES
('Darshika12', 'The Bay Club Hotel', '8', '4', 'AC', 'Yes', 'Passport', '132156423', '548032354', 'Rs 121600'),
('Rocky12', 'JW Marriott Hotel', '2', '5', 'AC', 'Yes', 'Passport', '1234567', '123456799', 'Rs 75000'),
('Rahul Kothari', 'JW Marriott Hotel', '1', '5', 'AC', 'Yes', 'Passport', '123456789', '1234567890', 'Rs 37500'),
('Abhishek123', 'JW Marriott Hotel', '1', '5', 'AC', 'Yes', 'Passport', '1234567890', '2345678999', 'Rs 37500');

-- --------------------------------------------------------

--
-- Table structure for table `bookpackage`
--

CREATE TABLE `bookpackage` (
  `username` varchar(20) DEFAULT NULL,
  `package` varchar(30) DEFAULT NULL,
  `person` varchar(20) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookpackage`
--

INSERT INTO `bookpackage` (`username`, `package`, `person`, `id`, `number`, `phone`, `price`) VALUES
('', 'Gold Package', '1', '', '', '', 'Rs 12000'),
('Samir345', 'Platinum Package', '2', 'Aadhar Card', '456156245', '5616156', 'Rs 90000'),
('Darshika12', 'Silver Package', '4', 'Passport', '132156423', '548032354', 'Rs 100000'),
('Rocky12', 'Ladakh, India', '2', 'Passport', '1234567', '123456799', 'Rs 45000'),
('Rahul Kothari', 'Ladakh, India', '1', 'Passport', '123456789', '1234567890', 'Rs 22500'),
('Rahul Kothari', 'Kerala, India', '2', 'Passport', '123456789', '1234567890', 'Rs 102000'),
('Abhishek123', 'Goa, India', '1', 'Passport', '1234567890', '2345678999', ''),
('Abhishek123', 'Goa, India', '1', 'Passport', '1234567890', '2345678999', 'Rs 12000');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `username` varchar(20) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`username`, `id`, `number`, `name`, `gender`, `country`, `address`, `phone`, `email`) VALUES
('Samir345', 'Aadhar Card', '456156245', 'Samir Kothari', 'Male', 'India', 'Surendranager', '5616156', 'Samir@gmail.com'),
('Darshika12', 'Passport', '132156423', 'Darshika Shah', 'Female', 'India', 'Surendranager', '548032354', 'Darshika123@gmail.com'),
('reema ', 'Passport', '3296494', 'reema n shah', 'Female', 'india', 'ahem', '263', 'yufctycj'),
('Meet123', 'Passport', 'wefrew', 'Meet Kapadi', 'Male', 'trer', 'weer', 'erewfe', 'ewfer'),
('Rocky12', 'Passport', '1234567', 'Rocky', 'Male', 'India', 'Mumbai', '123456799', 'Rocky@gmail.com'),
('Rahul Kothari', 'Passport', '123456789', 'Rahul', 'Male', 'India', 'Ahem', '1234567890', 'rahulK@email.com'),
('Abhishek123', 'Passport', '1234567890', 'Abhishek ', 'Male', 'India', 'Ahem', '2345678999', 'Abhishek@gmail.com');

--
-- Triggers `customer`
--
DELIMITER $$
CREATE TRIGGER `delete_details` AFTER DELETE ON `customer` FOR EACH ROW BEGIN
Delete from bookhotel where username = old.username;
Delete from bookpackage where username = old.username;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `name` varchar(30) DEFAULT NULL,
  `cost_per_day` varchar(20) DEFAULT NULL,
  `food_charges` varchar(20) DEFAULT NULL,
  `ac_charges` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`name`, `cost_per_day`, `food_charges`, `ac_charges`) VALUES
('JW Marriott Hotel', '2000', '2500', '3000'),
('Four Seasons Hotel', '1200', '1900', '2200'),
('The Taj Hotel', '5000', '1000', '3000'),
('Madarin Oriental Hotel', '9000', '4500', '1000'),
('Raddisson Blue Hotel', '1000', '1500', '500'),
('Classsio Hotel', '7000', '4500', '2000'),
('The Bay Club Hotel', '1100', '1400', '1300'),
('Breeze Blow Hotel', '1000', '1500', '3000'),
('Happy Morning Hotel', '1500', '2000', '3000'),
('River View Hotel', '1540', '1400', '1600');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
