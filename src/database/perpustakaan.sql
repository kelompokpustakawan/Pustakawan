-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2026 at 12:50 PM
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
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `username`, `password`, `id_petugas`) VALUES
(1, 'Faqih', 'adminfaqih', 1),
(2, 'Siti', 'adminsiti', 2),
(3, 'Rapli', 'adminrapli', 3),
(4, 'Hafizh', 'adminhafizh', 4),
(5, 'Chandra', 'adminchandra', 5),
(6, 'Benaya', 'adminBenaya', 7),
(7, 'Dika', 'admindika', 6),
(8, 'Nazwa', 'adminnazwa', 8);

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` int(11) NOT NULL,
  `kode_anggota` varchar(15) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `jenis_kelamin` enum('L','P') DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `tgl_registrasi` date DEFAULT curdate(),
  `status_aktif` enum('Aktif','Non-aktif') DEFAULT 'Aktif'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `kode_anggota`, `nama_lengkap`, `jenis_kelamin`, `tanggal_lahir`, `no_telp`, `alamat`, `tgl_registrasi`, `status_aktif`) VALUES
(1, 'ANG001', 'Ahmad Fauzi', 'L', '1995-05-12', '0856111', 'Jl. Kenanga 1', '2025-01-10', 'Aktif'),
(2, 'ANG002', 'Rina Mutia', 'P', '1998-09-21', '0856112', 'Jl. Cempaka 5', '2025-01-15', 'Aktif'),
(3, 'ANG003', 'Dewi Lestari', 'P', '2000-12-02', '0856113', 'Jl. Dahlia 3', '2025-02-01', 'Aktif'),
(4, 'ANG004', 'Fajar Ramadhan', 'L', '1993-03-15', '0856114', 'Jl. Anggrek 8', '2025-02-10', 'Non-aktif'),
(5, 'ANG005', 'Gilang Dirga', 'L', '1997-07-07', '0856115', 'Jl. Melati 2', '2025-02-15', 'Aktif'),
(6, 'ANG006', 'Hesti Purwadinata', 'P', '1996-04-18', '0856116', 'Jl. Mawar 9', '2025-03-01', 'Aktif'),
(7, 'ANG007', 'Indra Herlambang', 'L', '1992-10-30', '0856117', 'Jl. Flamboyan 4', '2025-03-10', 'Aktif'),
(8, 'ANG008', 'Jessica Iskandar', 'P', '1999-01-25', '0856118', 'Jl. Garuda 11', '2025-03-12', 'Non-aktif'),
(9, 'ANG009', 'Kevin Sanjaya', 'L', '2001-08-02', '0856119', 'Jl. Merdeka 14', '2025-04-01', 'Aktif'),
(10, 'ANG010', 'Luna Maya', 'P', '1994-08-26', '0856120', 'Jl. Sunset Boulevard', '2025-04-05', 'Aktif'),
(13, 'ANG011', 'Rizky Billar', 'L', '1995-07-12', '0856121', 'Jl. Kalibata No. 3', '2026-07-01', 'Aktif'),
(14, 'ANG012', 'Lesti Kejora', 'P', '1999-08-05', '0856122', 'Jl. Cianjur No. 45', '2026-07-02', 'Aktif'),
(15, 'ANG013', 'Bintang Timur', 'L', '2002-01-14', '0856123', 'Jl. Kebon Jeruk No. 10', '2026-07-03', 'Aktif'),
(16, 'ANG014', 'Citra Kirana', 'P', '1994-04-23', '0856124', 'Jl. Bandung Indah No. 8', '2026-07-04', 'Aktif'),
(17, 'ANG015', 'Reza Rahadian', 'L', '1987-03-05', '0856125', 'Jl. Kemang Raya No. 12', '2026-07-05', 'Aktif'),
(18, 'ANG016', 'Michael', 'L', '0030-08-25', '089443522342', NULL, '0012-12-18', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `judul` varchar(255) NOT NULL,
  `penulis` varchar(100) DEFAULT NULL,
  `penerbit` varchar(100) DEFAULT NULL,
  `tahun_terbit` year(4) DEFAULT NULL,
  `stok` int(11) DEFAULT 0,
  `id_kategori` int(11) DEFAULT NULL,
  `id_rak` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `isbn`, `judul`, `penulis`, `penerbit`, `tahun_terbit`, `stok`, `id_kategori`, `id_rak`) VALUES
(1, '978-602-03', 'Laskar Pelangi', 'Andrea Hirata', 'Bentang Pustaka', '2005', 15, 1, 1),
(2, '978-979-30', 'Bumi Manusia', 'Pramoedya Ananta Toer', 'Lentera Dipantara', '2005', 10, 1, 1),
(3, '978-602-02', 'Pengantar AI', 'Prof. Dr. Widodo', 'Informatika', '2020', 4, 2, 4),
(4, '978-602-04', 'Sejarah Dunia', 'H.G. Wells', 'Gramedia', '2018', 8, 3, 3),
(5, '978-602-05', 'Belajar SQL', 'Rian Azhari', 'Elex Media', '2022', 12, 2, 4),
(6, '978-602-06', 'One Piece Vol 100', 'Eiichiro Oda', 'Elex Media', '2021', 25, 4, 5),
(7, '978-602-07', 'Biografi BJ Habibie', 'A. Makmur Makka', 'THC Mandiri', '2015', 3, 5, 6),
(8, '978-602-08', 'Fiqih Islam', 'Sulaiman Rasjid', 'Sinar Baru', '2010', 20, 6, 7),
(9, '978-602-09', 'Madilog', 'Tan Malaka', 'Narasi', '2014', 5, 10, 10),
(10, '978-602-10', 'Kamus Indonesia-Inggris', 'John M. Echols', 'Gramedia', '2016', 12, 9, 10),
(12, '978-602-11', 'Atomic Habits', 'James Clear', 'Gramedia', '2019', 10, 11, 11),
(13, '978-602-12', 'Rich Dad Poor Dad', 'Robert T. Kiyosaki', 'Gramedia', '2016', 8, 12, 12),
(14, '978-602-13', 'Jaringan Komputer Modern', 'Tanenbaum', 'Andi Offset', '2015', 9, 13, 4),
(15, '978-602-14', 'Anatomi Tubuh Manusia', 'Dr. Syaifuddin', 'EGC', '2018', 6, 15, 13),
(16, '978-602-15', 'Filosofi Teras', 'Henry Manampiring', 'Kompas', '2019', 15, 11, 11),
(17, '978-602-16', 'Mister Rumah Hantu', 'Tere Liye', 'Gramedia', '2024', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `buku_rusak_hilang`
--

CREATE TABLE `buku_rusak_hilang` (
  `id_kasus` int(11) NOT NULL,
  `tanggal_lapor` date NOT NULL,
  `id_buku` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `jenis_kondisi` enum('Hilang','Rusak') NOT NULL,
  `jumlah` int(11) NOT NULL,
  `denda_ganti_rugi` int(11) NOT NULL,
  `status_solusi` enum('Belum Selesai','Sudah Diganti','Denda Lunas') NOT NULL DEFAULT 'Belum Selesai'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku_rusak_hilang`
--

INSERT INTO `buku_rusak_hilang` (`id_kasus`, `tanggal_lapor`, `id_buku`, `id_anggota`, `id_petugas`, `jenis_kondisi`, `jumlah`, `denda_ganti_rugi`, `status_solusi`) VALUES
(1, '2026-06-01', 1, 10, 3, 'Rusak', 1, 25000, 'Denda Lunas'),
(2, '2026-06-03', 2, 2, 3, 'Hilang', 1, 85000, 'Sudah Diganti'),
(3, '2026-06-05', 3, 3, 3, 'Rusak', 1, 15000, 'Belum Selesai'),
(4, '2026-06-10', 4, 10, 3, 'Hilang', 1, 90000, 'Belum Selesai'),
(5, '2026-06-12', 9, 2, 3, 'Rusak', 2, 40000, 'Denda Lunas'),
(6, '2026-06-15', 5, 5, 3, 'Hilang', 1, 75000, 'Sudah Diganti'),
(7, '2026-06-18', 6, 3, 3, 'Rusak', 1, 20000, 'Belum Selesai'),
(8, '2026-06-20', 7, 2, 3, 'Hilang', 1, 60000, 'Denda Lunas'),
(11, '2026-07-02', 3, 3, 3, 'Rusak', 1, 30000, 'Belum Selesai'),
(12, '2026-07-24', 7, 3, 6, 'Rusak', 1, 45000, 'Belum Selesai');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Fiksi / Novel'),
(2, 'Sains & Teknologi'),
(3, 'Sejarah'),
(4, 'Komik'),
(5, 'Biografi'),
(6, 'Agama Islam'),
(7, 'Sosial & Politik'),
(8, 'Bahasa & Sastra'),
(9, 'Ensiklopedia'),
(10, 'Filsafat'),
(11, 'Psikologi & Pengembangan Diri'),
(12, 'Ekonomi & Bisnis'),
(13, 'Komputer & Jaringan'),
(14, 'Sastra Klasik'),
(15, 'Kedokteran & Kesehatan'),
(16, 'Mister');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `no_faktur` varchar(50) NOT NULL,
  `tanggal_beli` date NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`no_faktur`, `tanggal_beli`, `id_petugas`, `total_bayar`) VALUES
('FAK-001', '2026-01-05', 1, 500000),
('FAK-002', '2026-01-12', 3, 350000),
('FAK-003', '2026-02-01', 4, 120000),
('FAK-004', '2026-02-15', 5, 450000),
('FAK-005', '2026-03-02', 1, 200000),
('FAK-006', '2026-03-20', 6, 600000),
('FAK-007', '2026-04-05', 7, 150000),
('FAK-008', '2026-04-18', 8, 300000),
('FAK-011', '2026-07-22', 3, 30000),
('FAK-012', '2026-07-01', 5, 200000),
('FAK-013', '2026-07-14', 4, 200000),
('FAK-014', '2026-07-05', 1, 450000),
('FAK-015', '2026-07-06', 3, 200000),
('FAK-016', '2026-07-22', 6, 200000);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_detail`
--

CREATE TABLE `pembelian_detail` (
  `id_detail` int(11) NOT NULL,
  `no_faktur` varchar(50) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian_detail`
--

INSERT INTO `pembelian_detail` (`id_detail`, `no_faktur`, `id_buku`, `jumlah_beli`, `harga_beli`, `subtotal`) VALUES
(1, 'FAK-001', 3, 5, 60000, 300000),
(2, 'FAK-001', 5, 4, 50000, 200000),
(3, 'FAK-002', 1, 5, 70000, 350000),
(4, 'FAK-003', 2, 2, 60000, 120000),
(5, 'FAK-004', 6, 10, 45000, 450000),
(6, 'FAK-005', 4, 4, 50000, 200000),
(7, 'FAK-006', 7, 6, 100000, 600000),
(8, 'FAK-007', 8, 3, 50000, 150000),
(14, 'FAK-011', 10, 3, 10000, 30000),
(15, 'FAK-012', 10, 10, 20000, 200000),
(16, 'FAK-013', 10, 5, 40000, 200000),
(18, 'FAK-016', 14, 4, 50000, 200000);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `id_anggota` int(11) DEFAULT NULL,
  `id_petugas` int(11) DEFAULT NULL,
  `status` enum('Dipinjam','Kembali') DEFAULT 'Dipinjam'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `tanggal_pinjam`, `tanggal_kembali`, `id_anggota`, `id_petugas`, `status`) VALUES
(1, '2026-06-01', '2026-06-08', 1, 1, 'Kembali'),
(2, '2026-06-02', '2026-06-09', 2, 3, 'Kembali'),
(3, '2026-06-03', '2026-06-10', 3, 4, 'Kembali'),
(4, '2026-06-04', '2026-06-11', 5, 5, 'Kembali'),
(5, '2026-06-05', '2026-06-12', 6, 6, 'Kembali'),
(6, '2026-06-10', '2026-06-17', 7, 1, 'Kembali'),
(7, '2026-06-15', '2026-06-22', 9, 7, 'Kembali'),
(8, '2026-06-20', '2026-06-27', 10, 8, 'Kembali'),
(9, '2026-06-22', '2026-06-29', 2, 9, 'Kembali'),
(11, '2026-07-01', '2026-07-08', 3, 6, 'Dipinjam'),
(18, '2026-07-24', '2026-07-31', 8, 7, 'Dipinjam'),
(19, '2026-07-29', '2026-08-05', 4, 8, 'Dipinjam');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_detail`
--

CREATE TABLE `peminjaman_detail` (
  `id_detail` int(11) NOT NULL,
  `id_peminjaman` int(11) DEFAULT NULL,
  `id_buku` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman_detail`
--

INSERT INTO `peminjaman_detail` (`id_detail`, `id_peminjaman`, `id_buku`) VALUES
(1, 1, 1),
(2, 2, 3),
(3, 3, 5),
(4, 4, 2),
(5, 5, 7),
(6, 6, 4),
(7, 7, 6),
(8, 8, 8),
(11, 11, 3),
(12, 18, 9),
(13, 19, 7);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` int(11) NOT NULL,
  `id_peminjaman` int(11) DEFAULT NULL,
  `tanggal_dikembalikan` date NOT NULL,
  `denda` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id_pengembalian`, `id_peminjaman`, `tanggal_dikembalikan`, `denda`) VALUES
(1, 1, '2026-06-08', 0),
(2, 2, '2026-06-09', 0),
(3, 3, '2026-06-12', 4000),
(4, 4, '2026-06-11', 0),
(5, 5, '2026-06-12', 0),
(6, 6, '2026-06-17', 0),
(7, 7, '2026-06-23', 2000),
(8, 1, '2026-06-08', 0),
(11, 9, '2026-06-29', 14000),
(12, 8, '2026-06-27', 14000);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jabatan` enum('Admin','Kepala Perpustakaan','Petugas Kebersihan','Sekretaris Bendahara') NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `Jenis_kelamin` enum('Laki-Laki','Perempuan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `jabatan`, `telepon`, `alamat`, `Jenis_kelamin`) VALUES
(1, 'Muhammad Faiz Faqih', 'Admin', '081234567890', 'Jl. Merdeka No. 10', 'Laki-Laki'),
(2, 'Siti Sri Rizki Ramadhani', '', '081234567891', 'Jl. Mawar No. 5', 'Perempuan'),
(3, 'Muhammad Rafly Aryaduta Suwari', 'Admin', '081234567892', 'Jl. Melati No. 12', 'Laki-Laki'),
(4, ' Muhamad Hafidz Ramadhan', 'Admin', '081234567893', 'Jl. Kenanga No. 8', 'Laki-Laki'),
(5, 'Chandra Dewatama', 'Admin', '081234567894', 'Jl. Dahlia No. 3', 'Laki-Laki'),
(6, 'Dika Kurniawan', 'Admin', '081234567895', 'Jl. Anggrek No. 15', 'Laki-Laki'),
(7, 'Samuel Benaya', 'Admin', '081234567896', 'Jl. Cempaka No. 22', 'Laki-Laki'),
(8, 'Nazwa Rahadatul Aisy', 'Admin', '081234567897', 'Jl. Flamboyan No. 7', 'Perempuan'),
(9, 'Iwan Fals', 'Admin', '081234567898', 'Jl. Garuda No. 19', 'Laki-Laki'),
(10, 'John Doe', 'Admin', '0895674764', 'Jl. Siliwangi', 'Laki-Laki'),
(11, 'Kenny Edward', 'Admin', '089234245', 'Jl. Kendari No. 17', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Table structure for table `rak`
--

CREATE TABLE `rak` (
  `id_rak` int(11) NOT NULL,
  `nama_rak` varchar(50) NOT NULL,
  `lokasi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rak`
--

INSERT INTO `rak` (`id_rak`, `nama_rak`, `lokasi`) VALUES
(1, 'Rak Novel A', 'Lantai 1 - Utara'),
(2, 'Rak Sains B', 'Lantai 1 - Selatan'),
(3, 'Rak Sejarah C', 'Lantai 2 - Barat'),
(4, 'Rak Komputer D', 'Lantai 2 - Timur'),
(5, 'Rak Komik E', 'Lantai 1 - Tengah'),
(6, 'Rak Biografi F', 'Lantai 2 - Tengah'),
(7, 'Rak Agama G', 'Lantai 1 - Pojok'),
(8, 'Rak Politik H', 'Lantai 2 - Pojok'),
(9, 'Rak Bahasa I', 'Lantai 1 - Sayap Kiri'),
(10, 'Rak Kamus J', 'Lantai 2 - Sayap Kanan'),
(11, 'Rak Psikologi K', 'Lantai 2 - Sayap Kiri'),
(12, 'Rak Ekonomi L', 'Lantai 1 - Barat'),
(13, 'Rak Kedokteran M', 'Lantai 2 - Utara'),
(14, 'Rak Mister', 'Lantai 3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`),
  ADD UNIQUE KEY `kode_anggota` (`kode_anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD KEY `fk_kategori` (`id_kategori`),
  ADD KEY `fk_rak` (`id_rak`);

--
-- Indexes for table `buku_rusak_hilang`
--
ALTER TABLE `buku_rusak_hilang`
  ADD PRIMARY KEY (`id_kasus`),
  ADD KEY `fk_kasus_buku` (`id_buku`),
  ADD KEY `fk_kasus_anggota` (`id_anggota`),
  ADD KEY `fk_kasus_petugas` (`id_petugas`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`no_faktur`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `no_faktur` (`no_faktur`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_peminjaman` (`id_peminjaman`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `id_peminjaman` (`id_peminjaman`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `rak`
--
ALTER TABLE `rak`
  ADD PRIMARY KEY (`id_rak`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id_akun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12329;

--
-- AUTO_INCREMENT for table `buku_rusak_hilang`
--
ALTER TABLE `buku_rusak_hilang`
  MODIFY `id_kasus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `id_pengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `rak`
--
ALTER TABLE `rak`
  MODIFY `id_rak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `akun`
--
ALTER TABLE `akun`
  ADD CONSTRAINT `akun_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `fk_kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_rak` FOREIGN KEY (`id_rak`) REFERENCES `rak` (`id_rak`) ON DELETE SET NULL;

--
-- Constraints for table `buku_rusak_hilang`
--
ALTER TABLE `buku_rusak_hilang`
  ADD CONSTRAINT `fk_kasus_anggota` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kasus_buku` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kasus_petugas` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON UPDATE CASCADE;

--
-- Constraints for table `pembelian_detail`
--
ALTER TABLE `pembelian_detail`
  ADD CONSTRAINT `pembelian_detail_ibfk_1` FOREIGN KEY (`no_faktur`) REFERENCES `pembelian` (`no_faktur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_detail_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON UPDATE CASCADE;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);

--
-- Constraints for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  ADD CONSTRAINT `peminjaman_detail_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE CASCADE,
  ADD CONSTRAINT `peminjaman_detail_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
