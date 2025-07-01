-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Jul 2025 pada 16.43
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rumahmakan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nik` int(11) NOT NULL,
  `nama_karyawan` varchar(40) DEFAULT NULL,
  `jabatan` varchar(40) DEFAULT NULL,
  `no_hp` int(15) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `jenis_kelamin` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nik`, `nama_karyawan`, `jabatan`, `no_hp`, `alamat`, `jenis_kelamin`, `email`, `username`) VALUES
(124, 111111, 'alpan', 'Staf Admin', 8211316, 'Depok', 'Laki', 'alpan@gmail.com', ''),
(125, 12983173, 'roby amanda putra', 'Staf Admin', 910391283, 'medan', 'Laki', 'roby@gmail.com', 'roby'),
(126, 8123813, 'faisal', 'Staf Admin', 913981312, 'bsdtangerang', 'Laki', 'faisal@gmail.com', 'faisal'),
(127, 211011, 'arya saputra', 'Staf kitchen', 1201921, 'depok', 'Laki', '910', 'arya'),
(129, 1211191, 'samsul', 'Staf Admin', 10211, 'koya', 'Laki', 'fiaksakl', 'muklis');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan1`
--

CREATE TABLE `pesanan1` (
  `id_pesanan` int(11) NOT NULL,
  `id_karyawan` int(11) DEFAULT NULL,
  `nama_pelanggan` varchar(255) DEFAULT NULL,
  `nomer_meja` varchar(255) DEFAULT NULL,
  `jenis_nasi` varchar(50) DEFAULT NULL,
  `jumlah_nasi` int(11) DEFAULT NULL,
  `jenis_lauk` varchar(50) DEFAULT NULL,
  `jumlah_lauk` int(11) DEFAULT NULL,
  `jenis_minuman` varchar(50) DEFAULT NULL,
  `jumlah_total` decimal(10,2) DEFAULT NULL,
  `tanggal_pesanan` timestamp NOT NULL DEFAULT current_timestamp(),
  `jumlah_minuman` int(11) NOT NULL,
  `status_pesanan` varchar(50) DEFAULT 'Belum Selesai',
  `username` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pesanan1`
--

INSERT INTO `pesanan1` (`id_pesanan`, `id_karyawan`, `nama_pelanggan`, `nomer_meja`, `jenis_nasi`, `jumlah_nasi`, `jenis_lauk`, `jumlah_lauk`, `jenis_minuman`, `jumlah_total`, `tanggal_pesanan`, `jumlah_minuman`, `status_pesanan`, `username`) VALUES
(21, NULL, 'kairi', 'Meja 2', 'Nasi Biasa', 2, 'Ayam Bakar', 2, 'Es Teh Manis', 40000.00, '2025-06-25 04:39:08', 2, 'Selesai', 'alpan'),
(22, NULL, 'satrio', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-26 14:26:49', 1, 'Selesai', 'alpan'),
(23, 0, 'damar', 'Meja 3', 'Nasi Biasa', 7, 'Ayam Bakar', 7, 'Es Teh Manis', 140000.00, '2025-06-26 14:30:55', 7, 'Selesai', NULL),
(24, NULL, 'muhamad faisal', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 03:34:19', 1, 'Selesai', 'alpan'),
(25, 0, 'muhamad faisal', 'Meja 8', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 03:53:58', 1, 'Selesai', NULL),
(26, 0, 'janu', 'Meja 4', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 03:58:51', 1, 'Selesai', NULL),
(27, NULL, 'satrui', 'Meja 5', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:01:36', 1, 'Selesai', 'alpan'),
(28, NULL, 'zarip', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:11:22', 1, 'Selesai', 'alpan'),
(29, 0, 'zarip', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:18:09', 1, 'Selesai', NULL),
(30, 0, 'nurlela', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:24:12', 1, 'Selesai', NULL),
(31, NULL, 'king', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:33:14', 1, 'Selesai', 'alpan'),
(32, NULL, 'king zarip', 'Meja 1', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 04:35:40', 1, 'Selesai', 'alpan'),
(33, NULL, 'oman', 'Meja 5', 'Nasi Biasa', 5, 'Ayam Bakar', 5, 'Es Teh Manis', 100000.00, '2025-06-27 06:46:29', 5, 'Selesai', 'alpan'),
(34, NULL, 'iki saputta', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 07:35:20', 1, 'Selesai', 'arya'),
(35, NULL, 'matar', 'Meja 4', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 07:39:27', 1, 'Selesai', 'alpan'),
(36, NULL, 'saiful', 'Meja 7', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 07:43:12', 1, 'Selesai', 'alpan'),
(37, NULL, 'manusia', 'Meja 1', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 07:55:21', 1, 'Selesai', 'alpan'),
(38, 0, 'imam', 'Meja 2', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 08:41:44', 1, 'Belum Selesai', NULL),
(39, 0, 'okap', 'Meja 5', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 08:45:45', 1, 'Belum Selesai', 'alpan'),
(40, 0, 'asam', 'Meja 10', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-27 09:47:42', 1, 'Selesai', 'alpan'),
(41, 0, 'arya wijaya', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-29 09:23:18', 1, 'Selesai', NULL),
(42, 0, 'ewing nasution', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-29 09:26:01', 1, 'Selesai', NULL),
(43, 0, 'muhamad faisal', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-29 09:33:24', 1, 'Selesai', 'faisal'),
(44, 126, 'arya', 'Meja 6', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Es Teh Manis', 20000.00, '2025-06-29 09:36:07', 1, 'Selesai', 'faisal'),
(45, 0, 'arya', 'Meja 8', 'Nasi Biasa', 1, 'Ayam Bakar', 0, 'Es Teh Manis', 15000.00, '2025-06-30 06:07:46', 2, 'Belum Selesai', NULL),
(46, 0, 'sijafir', 'Meja 4', 'Nasi Biasa', 1, 'Ayam Bakar', 1, 'Air Putih', 20000.00, '2025-06-30 23:39:23', 1, 'Belum Selesai', 'alpan'),
(47, 125, 'prabowo', 'Meja 6', 'Nasi Pulen', 1, 'Rendang', 1, 'Air Putih, Es Teh Manis', 25000.00, '2025-06-30 23:47:30', 2, 'Selesai', 'roby');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok_menu`
--

CREATE TABLE `stok_menu` (
  `id_stokmenu` int(11) NOT NULL,
  `nama_menu` varchar(255) NOT NULL,
  `harga_jual` decimal(12,2) NOT NULL,
  `jumlah_stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `stok_menu`
--

INSERT INTO `stok_menu` (`id_stokmenu`, `nama_menu`, `harga_jual`, `jumlah_stok`) VALUES
(1, 'Ayam Bakar', 1200.00, 41),
(2, 'Nasi Biasa', 10000.00, 1920),
(3, 'Es Teh Manis', 5000.00, 738),
(4, 'Nasi Pulen', 10000.00, 96),
(6, 'Air Putih', 6000.00, 997),
(7, 'Rendang', 12000.00, 98);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pesanan` int(11) DEFAULT NULL,
  `nama_menu` varchar(255) NOT NULL,
  `nomer_meja` int(11) NOT NULL,
  `nama_pelanggan` varchar(255) NOT NULL,
  `tanggal_transaksi` datetime DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  `metode_pembayaran` varchar(50) DEFAULT NULL,
  `kategori` varchar(255) NOT NULL,
  `jumlah_nasi` int(11) NOT NULL,
  `jumlah_lauk` int(11) NOT NULL,
  `jumlah_minuman` int(11) NOT NULL,
  `username` varchar(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_pesanan`, `nama_menu`, `nomer_meja`, `nama_pelanggan`, `tanggal_transaksi`, `total_harga`, `metode_pembayaran`, `kategori`, `jumlah_nasi`, `jumlah_lauk`, `jumlah_minuman`, `username`, `id_karyawan`) VALUES
(32, 23, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 3, 'damar', '2025-06-26 21:32:24', 140000, 'TUNAI', 'Makanan dan Minuman', 7, 7, 7, 'roby', 125),
(33, 22, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 2, 'satrio', '2025-06-27 10:20:26', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(36, 24, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'muhamad faisal', '2025-06-27 10:41:45', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(37, 25, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 8, 'muhamad faisal', '2025-06-27 10:57:27', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(38, 27, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 5, 'satrui', '2025-06-27 11:03:19', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(39, 28, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 2, 'zarip', '2025-06-27 11:12:43', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'roby', 125),
(40, 26, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 4, 'janu', '2025-06-27 11:17:32', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'roby', 125),
(41, 29, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 2, 'zarip', '2025-06-27 11:21:27', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'roby', 125),
(42, 30, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 2, 'nurlela', '2025-06-27 11:31:48', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'roby', 125),
(43, 31, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 2, 'king', '2025-06-27 11:52:24', 20000, 'Tunai', 'Makanan dan Minuman', 1, 1, 1, 'alpan', 0),
(44, 32, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 1, 'king zarip', '2025-06-27 11:54:19', 20000, 'Tunai', 'Makanan dan Minuman', 1, 1, 1, 'alpan', 0),
(45, 33, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 5, 'oman', '2025-06-27 13:47:25', 100000, 'Tunai', 'Makanan dan Minuman', 5, 5, 5, 'alpan', 0),
(46, 34, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'iki saputta', '2025-06-29 16:19:57', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(47, 41, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'arya wijaya', '2025-06-29 16:24:20', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(48, 42, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'ewing nasution', '2025-06-29 16:32:52', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(49, 43, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'muhamad faisal', '2025-06-29 16:35:17', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(50, 40, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 10, 'asam', '2025-06-29 16:35:41', 20000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 1, 'faisal', 126),
(51, 37, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 1, 'manusia', '2025-06-30 13:14:14', 20000, 'DEBIT', 'Makanan dan Minuman', 1, 1, 1, 'roby', 125),
(52, 35, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 4, 'matar', '2025-07-01 06:33:29', 20000, 'Qris', 'Makanan dan Minuman', 1, 1, 1, 'alpan', 0),
(53, 36, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 7, 'saiful', '2025-07-01 06:35:57', 20000, 'Debit', 'Makanan dan Minuman', 1, 1, 1, 'alpan', 0),
(54, 44, 'Nasi Biasa, Ayam Bakar, Es Teh Manis', 6, 'arya', '2025-07-01 06:40:47', 20000, 'Tunai', 'Makanan dan Minuman', 1, 1, 1, 'alpan', 0),
(55, 47, 'Nasi Pulen, Rendang, Air Putih, Es Teh Manis', 6, 'prabowo', '2025-07-01 06:48:52', 25000, 'TUNAI', 'Makanan dan Minuman', 1, 1, 2, 'roby', 125);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `akses` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `akses`) VALUES
(1, 'alpan', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Admin'),
(2, 'faisal', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Pegawai'),
(3, 'roby', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Pegawai'),
(4, 'ewing', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Admin'),
(5, 'arya', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Admin'),
(6, 'rafly', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Pegawai'),
(7, 'muklis', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indeks untuk tabel `pesanan1`
--
ALTER TABLE `pesanan1`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indeks untuk tabel `stok_menu`
--
ALTER TABLE `stok_menu`
  ADD PRIMARY KEY (`id_stokmenu`),
  ADD UNIQUE KEY `nama_menu` (`nama_menu`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_transaksi_pesanan1` (`id_pesanan`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT untuk tabel `pesanan1`
--
ALTER TABLE `pesanan1`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT untuk tabel `stok_menu`
--
ALTER TABLE `stok_menu`
  MODIFY `id_stokmenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_transaksi_pesanan1` FOREIGN KEY (`id_pesanan`) REFERENCES `pesanan1` (`id_pesanan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
