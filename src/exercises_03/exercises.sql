-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 30, 2021 lúc 12:26 PM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `exercises`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `birth_year` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `gpa` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `student_name`, `birth_year`, `gender`, `gpa`) VALUES
(2, 'Ngan', '1999', 'Female', 7),
(5, 'Ho', '1999', 'Male', 7),
(6, 'Huyen', '1999', 'Female', 8),
(7, 'Huy', '1999', 'Male', 6.33),
(9, 'Hao', '1998', 'Female', 6.67),
(30, 'Hung', '2000', 'Male', 7.17);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `subject_name` varchar(30) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `mark` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id`, `subject_name`, `student_id`, `mark`) VALUES
(2, 'Toan', 2, 8),
(3, 'Ly', 2, 6),
(4, 'Van', 2, 7),
(11, 'Ly', 5, 6),
(12, 'Toan', 5, 8),
(13, 'Van', 5, 7),
(14, 'Toan', 6, 8),
(15, 'Van', 6, 7),
(16, 'Ly', 6, 9),
(17, 'Toan', 7, 6),
(18, 'Ly', 7, 6),
(19, 'Van', 7, 7),
(99, 'Van', 30, 7),
(100, 'Ly', 30, 7.5),
(101, 'Toan', 30, 7),
(108, 'Ly', 9, 8),
(109, 'Toan', 9, 7),
(110, 'Van', 9, 5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_studentId` (`student_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `fk_studentId` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
