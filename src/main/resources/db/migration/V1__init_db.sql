SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database hpi2;

DROP TABLE IF EXISTS `agent`;
CREATE TABLE IF NOT EXISTS `agent` (
    `id` int(11) NOT NULL,
    `num_of_ads` int(11) NOT NULL,
    `rating` tinyint(4) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `childdistricts`;
CREATE TABLE IF NOT EXISTS `childdistricts` (
    `id` int(11) NOT NULL,
    `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `parent_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `parent_id` (`parent_id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `childdistricts` (`id`, `name`, `parent_id`) VALUES
                                                             (258, 'ceyranbatan', 197),
                                                             (65, 'cicek', 197),
                                                             (263, 'digah', 197),
                                                             (116, 'fatmayi', 197),
                                                             (194, 'goredil', 197),
                                                             (50, 'hokmeli', 197),
                                                             (115, 'kohne-corat', 197),
                                                             (261, 'qobu', 197),
                                                             (198, 'masazir', 197),
                                                             (112, 'mehdiabad', 197),
                                                             (265, 'masazir', 197),
                                                             (113, 'novxani', 197),
                                                             (241, 'pirekeskul', 197),
                                                             (111, 'saray', 197),
                                                             (114, 'yeni-corat', 197),
                                                             (106, 'zagulba', 197),
                                                             (73, '2-ci-alatava', 58),
                                                             (259, '28may', 58),
                                                             (128, '6-ci-mikrorayon', 58),
                                                             (129, '7-ci-mikrorayon', 58),
                                                             (130, '8-ci-mikrorayon', 58),
                                                             (131, '9-cu-mikrorayon', 58),
                                                             (17, 'bileceri', 58),
                                                             (18, 'bineqedi-qesebesi', 58),
                                                             (9, 'xocesen', 58),
                                                             (104, 'xutor', 58),
                                                             (19, 'm-e-resulzade', 58),
                                                             (64, 'sulutepe', 58),
                                                             (314, 'ag-sheher', 16),
                                                             (100, 'ehmedli-qesebesi', 16),
                                                             (99, 'hezi-aslanov-qesebesi', 16),
                                                             (200, 'kohne-gunesli', 16),
                                                             (233, 'nzs', 16),
                                                             (79, 'bine', 15),
                                                             (117, 'buzovna', 15),
                                                             (97, 'dubendi', 15),
                                                             (252, 'gurgen', 15),
                                                             (95, 'qala', 15),
                                                             (109, 'merdekan', 15),
                                                             (108, 'sagan', 15),
                                                             (107, 'simal-dres', 15),
                                                             (110, 'suvelan', 15),
                                                             (94, 'turken', 15),
                                                             (96, 'zire', 15),
                                                             (24, 'elet', 57),
                                                             (257, 'gizildash', 57),
                                                             (45, 'qobustan', 57),
                                                             (20, 'lokbatan', 57),
                                                             (98, 'musviqabad', 57),
                                                             (22, 'puta', 57),
                                                             (21, 'sahil-qesebesi', 57),
                                                             (23, 'sengecal', 57),
                                                             (71, 'subani', 57),
                                                             (68, '', 10),
                                                             (123, '1-ci-mikrorayon', 190),
                                                             (124, '2-ci-mikrorayon', 190),
                                                             (125, '3-cu-mikrorayon', 190),
                                                             (126, '4-cu-mikrorayon', 190),
                                                             (127, '5-ci-mikrorayon', 190),
                                                             (70, 'kubinka', 190),
                                                             (74, '8-ci-kilometr', 11),
                                                             (105, 'kesle', 11),
                                                             (313, 'albaliliq', 13),
                                                             (69, 'bakixanov', 13),
                                                             (243, 'balaxani', 13),
                                                             (118, 'bilgeh', 13),
                                                             (120, 'kurdexani', 13),
                                                             (122, 'mastaga', 13),
                                                             (119, 'nardaran', 13),
                                                             (121, 'pirsagi', 13),
                                                             (76, 'ramana', 13),
                                                             (86, 'sabuncu-qesebesi', 13),
                                                             (234, 'savalan', 13),
                                                             (242, 'yeni-balaxani', 13),
                                                             (77, 'yeni-ramana', 13),
                                                             (78, 'zabrat', 13),
                                                             (48, '20-ci-sahe', 12),
                                                             (46, 'badamdar', 12),
                                                             (49, 'bayil', 12),
                                                             (47, 'bibi-heybet', 12),
                                                             (260, 'shixov', 12),
                                                             (256, 'bahar', 14),
                                                             (244, 'bulbule', 14),
                                                             (255, 'gorgud', 14),
                                                             (72, 'emircan', 14),
                                                             (91, 'gunesli', 14),
                                                             (93, 'hovsan', 14),
                                                             (75, 'qaracuxur', 14),
                                                             (81, 'massiv-a', 14),
                                                             (82, 'massiv-b', 14),
                                                             (85, 'massiv-d', 14),
                                                             (84, 'massiv-g', 14),
                                                             (83, 'massiv-v', 14),
                                                             (87, 'suraxani-qesebesi', 14),
                                                             (80, 'serq', 14),
                                                             (92, 'yeni-gunesli', 14),
                                                             (88, 'yeni-suraxani', 14),
                                                             (89, 'zig', 14),
                                                             (103, 'yasamal-qesebesi', 56),
                                                             (102, 'yeni-yasamal', 56);

-- --------------------------------------------------------

--
-- Table structure for table `maindistricts`
--

DROP TABLE IF EXISTS `maindistricts`;
CREATE TABLE IF NOT EXISTS `maindistricts` (
    `id` int(11) NOT NULL,
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maindistricts`
--

INSERT INTO `maindistricts` (`id`, `name`) VALUES
                                               (197, 'abseron'),
                                               (58, 'bineqedi'),
                                               (16, 'xetai'),
                                               (10, 'nerimanov'),
                                               (190, 'nesimi'),
                                               (13, 'sabuncu'),
                                               (12, 'sebail'),
                                               (56, 'yasamal'),
                                               (11, 'nizami'),
                                               (14, 'suraxani'),
                                               (15, 'xezer'),
                                               (57, 'qaradag');

-- --------------------------------------------------------

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
CREATE TABLE IF NOT EXISTS `mark` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mark`
--

INSERT INTO `mark` (`id`, `name`) VALUES
                                      (1, 'ag-seher'),
                                      (2, 'axundov-bagi'),
                                      (3, 'asan-xidmet1'),
                                      (4, 'asan-xidmet2'),
                                      (5, 'asan-xidmet3'),
                                      (6, 'asan-xidmet5'),
                                      (7, 'ayna-sultanova-heykeli'),
                                      (8, 'azadliq-meydani'),
                                      (9, 'azerbaycan-diller-universiteti'),
                                      (10, 'azerbaycan-kinoteatri'),
                                      (11, 'azerbaycan-turizm-institutu'),
                                      (12, 'azneft-meydani'),
                                      (13, 'baki-asiya-universiteti'),
                                      (14, 'baki-dovlet-universiteti'),
                                      (15, 'baki-musiqi-akademiyasi'),
                                      (16, 'baki-slavyan-universiteti'),
                                      (17, 'bayil-parki'),
                                      (18, 'besmertebe'),
                                      (19, 'botanika-bagi'),
                                      (20, 'cavansir-korpusu'),
                                      (21, 'dagustu-parki'),
                                      (22, 'dostluq-kinoteatri'),
                                      (23, 'dovlet-idarecilik-akademiyasi'),
                                      (24, 'dovlet-statistika-komitesi'),
                                      (25, 'fontanlar-bagi'),
                                      (26, 'huseyn-cavid-parki'),
                                      (27, 'xalca-muzeyi'),
                                      (28, 'iceri-seher'),
                                      (29, 'idman-kompleksi'),
                                      (30, 'iqsadiyyat-universiteti'),
                                      (31, 'incesenet-ve-medeniyyet-un'),
                                      (32, 'izmir-parki'),
                                      (33, 'kesle-bazari'),
                                      (34, 'koala-parki'),
                                      (35, 'qis-parki'),
                                      (36, 'qubernator-parki'),
                                      (37, 'm-e-sabir-parki'),
                                      (38, 'm-huseynzade-parki'),
                                      (39, 'malokan-bagi'),
                                      (40, 'memarliq-ve-insaat-universiteti'),
                                      (41, 'merkezi-univermaq'),
                                      (42, 'milli-konservatoriya'),
                                      (43, 'montin-bazari'),
                                      (44, 'neapol-dairesi'),
                                      (45, 'neft-akademiyasi'),
                                      (46, 'neftci-bazasi'),
                                      (47, 'neriman-nerimanov-parki'),
                                      (48, 'nerimanov-heykeli'),
                                      (49, 'nesimi-bazari'),
                                      (50, 'nizami-kinoteatri'),
                                      (51, 'park-zorge'),
                                      (52, 'pedaqoji-universiteti'),
                                      (53, 'port-baku'),
                                      (54, 'prezident-parki'),
                                      (55, 'respublika-stadionu'),
                                      (56, 'ressamliq-akademiyasi'),
                                      (57, 'rusiya-sefirliyi'),
                                      (58, 'sahil-bagi'),
                                      (59, 'seabreeze'),
                                      (60, 'sevil-qaziyeva-parki'),
                                      (61, 'semed-vurgun-parki'),
                                      (62, 'sirk'),
                                      (63, 'sovetski'),
                                      (64, 'space-tv'),
                                      (65, 'sefa-stadionu'),
                                      (66, 'sehidler-xiyabani'),
                                      (67, 'selale-parki'),
                                      (68, 'sherg'),
                                      (69, 'texniki-universiteti'),
                                      (70, 'tehsil-nazirliyi'),
                                      (71, 'tibb-universiteti'),
                                      (72, 'tqdk'),
                                      (73, 'ukrayna-dairesi'),
                                      (74, 'yasamal-bazari'),
                                      (75, 'zabitler-parki'),
                                      (76, 'zerife-eliyeva-adina-park'),
                                      (77, 'zoopark');

-- --------------------------------------------------------

--
-- Table structure for table `metrostations`
--

DROP TABLE IF EXISTS `metrostations`;
CREATE TABLE IF NOT EXISTS `metrostations` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `station` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `metrostations`
--

INSERT INTO `metrostations` (`id`, `station`) VALUES
                                                  (1, 'hezi-aslanov'),
                                                  (2, 'ehmedli'),
                                                  (3, 'xalqlar-dostlugu'),
                                                  (4, 'neftciler'),
                                                  (5, 'qara-qarayev'),
                                                  (6, 'ulduz'),
                                                  (7, 'bakmil'),
                                                  (8, 'neriman-nerimanov'),
                                                  (9, 'genclik'),
                                                  (10, '28-may'),
                                                  (11, 'sah-ismayil-xetai'),
                                                  (12, 'sahil'),
                                                  (13, 'iceri-seher-metrosu'),
                                                  (14, 'nizami-metrosu'),
                                                  (15, 'elmler-akademiyasi'),
                                                  (16, 'insaatcilar'),
                                                  (17, '20-yanvar'),
                                                  (18, '8-noyabr'),
                                                  (19, 'memar-ecemi'),
                                                  (20, 'avtovagzal'),
                                                  (21, 'xocasan'),
                                                  (22, 'nesimi-metrosu'),
                                                  (23, 'azadliq-prospekti'),
                                                  (24, 'dernegul');

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
CREATE TABLE IF NOT EXISTS `statistics` (
    `id` varchar(160) COLLATE utf8mb4_unicode_ci NOT NULL,
    `highest` double NOT NULL,
    `lowest` double NOT NULL,
    `average` double NOT NULL,
    `created_date` datetime NOT NULL,
    `childdistrictid` int(11) NOT NULL,
    `room_num` int(11) NOT NULL,
    `has_repair` tinyint(1) NOT NULL DEFAULT '0',
    `has_bill_of_sale` tinyint(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY `fk_statistics_childdistricts` (`childdistrictid`)
    ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
                                                                                                     ('97b9f38a-f43a-497b-ac0f-c9b46adb81cf', 0, 0, 0, '2023-06-18 10:50:32', 23, 1, 1, 1),
                                                                                                                                                     ('b8625add-eb1f-4908-9ce3-bc31e7db91db', 0, 0, 0, '2023-06-18 10:50:32', 71, 1, 1, 1);
COMMIT;
