-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2024 at 05:13 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ead`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image_file_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `created_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `brand`, `category`, `create_at`, `description`, `image_file_name`, `name`, `price`, `created_at`) VALUES
(2, 'Samsung', '1', '2024-10-17 16:55:07.000000', 'Samsung Galaxy S21 Ultra with 256GB storage', 'Samsung-Galaxy-S21-ultra-5G-d.jpg', 'Galaxy S21 Ultra', 1199.99, '2024-10-17 16:55:07.000000'),
(3, 'Dell', '2', '2024-10-17 16:55:07.000000', 'Dell XPS 13 laptop with 16GB RAM and 512GB SSD', 'Dell XPS 13.jpg', 'XPS 13', 1399.99, '2024-10-17 16:55:07.000000'),
(4, 'HP', '2', '2024-10-17 16:55:07.000000', 'HP Spectre x360 convertible laptop with 8GB RAM', 'hp_spectre_x360.jpg', 'Spectre x360', 1299.99, '2024-10-17 16:55:07.000000'),
(5, 'Lenovo', '2', '2024-10-17 16:55:07.000000', 'Lenovo ThinkPad X1 Carbon with 16GB RAM and 1TB SSD', 'thinkpad_x1_carbon.jpg', 'ThinkPad X1 Carbon', 1499.99, '2024-10-17 16:55:07.000000'),
(6, 'Apple', '1', '2024-10-17 16:55:07.000000', 'Apple iPhone 12 Mini with 64GB storage', 'iphone_12_mini.jpg', 'iPhone 12 Mini', 699.99, '2024-10-17 16:55:07.000000'),
(7, 'Samsung', '1', '2024-10-17 16:55:07.000000', 'Samsung Galaxy Note 20 with 128GB storage', 'galaxy_note_20.jpg', 'Galaxy Note 20', 999.99, '2024-10-17 16:55:07.000000'),
(8, 'Asus', '2', '2024-10-17 16:55:07.000000', 'Asus ROG Zephyrus gaming laptop with 32GB RAM', 'rog_zephyrus.jpg', 'ROG Zephyrus', 1999.99, '2024-10-17 16:55:07.000000'),
(9, 'Acer', '2', '2024-10-17 16:55:07.000000', 'Acer Predator Helios gaming laptop with 16GB RAM', 'predator_helios.jpg', 'Predator Helios', 1499.99, '2024-10-17 16:55:07.000000'),
(10, 'Microsoft', '2', '2024-10-17 16:55:07.000000', 'Microsoft Surface Pro 7 with 8GB RAM and 256GB SSD', 'surface_pro_7.jpg', 'Surface Pro 7', 899.99, '2024-10-17 16:55:07.000000'),
(11, 'Apple', '1', '2024-10-17 16:55:07.000000', 'Apple iPhone SE with 128GB storage', 'iphone_se.jpg', 'iPhone SE', 499.99, '2024-10-17 16:55:07.000000'),
(12, 'OnePlus', '1', '2024-10-17 16:55:07.000000', 'OnePlus 9 Pro with 128GB storage', 'oneplus_9_pro.jpg', 'OnePlus 9 Pro', 799.99, '2024-10-17 16:55:07.000000'),
(13, 'Google', '1', '2024-10-17 16:55:07.000000', 'Google Pixel 6 with 128GB storage', 'pixel_6.jpg', 'Pixel 6', 599.99, '2024-10-17 16:55:07.000000'),
(14, 'Huawei', '1', '2024-10-17 16:55:07.000000', 'Huawei P40 Pro with 256GB storage', 'huawei_p40_pro.jpg', 'P40 Pro', 899.99, '2024-10-17 16:55:07.000000'),
(15, 'Sony', 'Other', '2024-10-17 16:55:07.000000', 'Sony Xperia 1 III with 256GB storage', '1729175455588_Xperia 1 III.jpeg', 'Xperia 1 III', 1099.99, '2024-10-17 16:55:07.000000'),
(16, 'Apple', 'Other', '2024-10-17 16:55:07.000000', 'Apple MacBook Air with M1 chip and 256GB SSD', '1729175416989_MacBook Air.jpg', 'MacBook Air', 999.99, '2024-10-17 16:55:07.000000'),
(17, 'HP', 'Other', '2024-10-17 16:55:07.000000', 'HP Envy 13 laptop with Intel i7 processor', '1729175364753_Envy 13.webp', 'Envy 13', 1199.99, '2024-10-17 16:55:07.000000'),
(18, 'Dell', 'Other', '2024-10-17 16:55:07.000000', 'Dell Inspiron 15 with Intel i5 and 512GB SSD', '1729175297321_Inspiron 15.jpeg', 'Inspiron 15', 799.99, '2024-10-17 16:55:07.000000'),
(19, 'Lenovo', '2', '2024-10-17 16:55:07.000000', 'Lenovo Yoga Slim 7 with 16GB RAM', 'Yoga Slim 7.webp', 'Yoga Slim 7', 1299.99, '2024-10-17 16:55:07.000000'),
(20, 'Asus', 'Computer', '2024-10-17 16:55:07.000000', 'Asus VivoBook S15 with Intel i5 and 512GB SSD', '1729175238121_VivoBook S15.jpg', 'VivoBook S15', 699.99, '2024-10-17 16:55:07.000000'),
(22, 'Apple', 'Phone', '2024-10-17 20:10:06.000000', 'Apple iPhone 13 Pro with 128GB storage', '1729176006942_iPhone-13-Pro-ii.webp', 'Apple iPhone 13 Pro', 10000, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
