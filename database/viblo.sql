-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 02, 2022 lúc 04:35 PM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `viblo`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comments`
--

CREATE TABLE `comments` (
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `post_id` bigint(20) UNSIGNED NOT NULL,
  `content` varchar(255) NOT NULL,
  `time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `comments`
--

INSERT INTO `comments` (`user_id`, `post_id`, `content`, `time`) VALUES
(2, 1, 'ảnh đâu đấy ?', '2022-03-01 17:30:35'),
(2, 2, 'Chào mọi người!', '2022-03-02 02:59:59'),
(2, 4, 'chào mọi người!', '2022-03-02 02:59:59'),
(2, 3, 'xin chào!', '2022-03-02 02:59:59'),
(2, 3, 'nhớ like và cmt nhá!', '2022-03-02 02:59:59'),
(3, 1, 'ảnh đẹp phết thây =))', '2022-03-02 02:59:59'),
(3, 2, 'chào minh0612', '2022-03-02 02:59:59'),
(3, 3, 'hello ae', '2022-03-02 02:59:59'),
(3, 5, 'chào mn!', '2022-03-02 02:59:59'),
(3, 6, 'chào mn', '2022-03-02 02:59:59'),
(2, 5, 'chào', '2022-03-02 02:59:59'),
(2, 7, 'mặt nhìn ngu vler', '2022-03-02 04:15:07');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `posts`
--

CREATE TABLE `posts` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `content` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `posts`
--

INSERT INTO `posts` (`id`, `user_id`, `content`, `image`) VALUES
(1, 10, 'hello ae', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1646048636/viblo/qfrt9bxsv6usenoysk8q.jpg'),
(2, 2, 'hello ae I am Minh', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1646131313/viblo/b5v5rs6tpjktydrktexh.jpg'),
(3, 2, 'vinh shit', 'https://res.cloudinary.com/diw0u2vl1/image/upload/v1643157837/viblo/it2cezkhtckgkmtbespp.jpg'),
(4, 2, 'hello ae', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1646134957/viblo/qudstekk2bdtvetpsv3t.jpg'),
(5, 3, 'một bức tranh về thiên nhiên!', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1646191114/viblo/d3vsbcrqa2vavbcyrwq6.jpg'),
(6, 3, 'hello ae', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1646192869/viblo/bz8xkgqemdntlgntzsna.jpg'),
(7, 2, 'Vũ Quang Vinh', 'https://res.cloudinary.com/diw0u2vl1/image/upload/v1643018981/viblo/oa6lyc1zkuintv0njos0.jpg'),
(8, 2, 'fg', 'https://res.cloudinary.com/diw0u2vl1/image/upload/v1643018981/viblo/oa6lyc1zkuintv0njos0.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `avatar`, `gender`) VALUES
(1, 'leo messi', 'messi30', 'messi@gmail.com', NULL, 'male'),
(2, 'minh0612', 'vungocminh', 'akari@gmail.com', 'https://res.cloudinary.com/diw0u2vl1/image/upload/w_1000,ar_1:1,c_fill,g_auto,e_art:hokusai/v1644863262/tiktok_image/user31239_ecnpmp.jpg', 'male'),
(3, 'vungocminh', 'akari_tsumugi', 'akari@gmail.com', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1643018981/viblo/oa6lyc1zkuintv0njos0.jpg', 'male'),
(4, 'dsvzsfdbvgf', 'akari_tsumugi', 'akari@gmail.com', NULL, 'male'),
(5, 'congcong123', 'akari_tsumugi', 'akari@gmail.com', NULL, 'male'),
(6, 'vnm061220', 'akari_tsumugi', 'akari1@gmail.com', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1643157911/viblo/chg7i6ouy30nr3pxylig.jpg', 'male'),
(7, 'vnm0612', 'akari_tsumugi', 'akari@gmail.com', NULL, 'male'),
(8, 'kien112233', 'akari_tsumugi', 'akari@gmail.com', 'http://res.cloudinary.com/diw0u2vl1/image/upload/v1643162361/viblo/lsnavzuqde8njxh6l6mq.jpg', 'male'),
(9, 'kien123', 'kien123', 'kien@gmail.com', 'https://res.cloudinary.com/diw0u2vl1/image/upload/v1643020285/viblo/dbxsmd2omitlfpzgpn6q.jpg', 'female'),
(10, 'tnttnt', 'tnttnt', 'minh0612tnt@gmail.com', NULL, 'female');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `comments`
--
ALTER TABLE `comments`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `post_id` (`post_id`);

--
-- Chỉ mục cho bảng `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user` (`user_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `posts`
--
ALTER TABLE `posts`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
