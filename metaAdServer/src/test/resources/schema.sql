drop table if exists m_ads CASCADE;
CREATE TABLE `m_ads` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `ads_id` varchar(255) DEFAULT NULL,
                         `ads_name` varchar(255) DEFAULT NULL,
                         `ads_type` varchar(255) DEFAULT NULL,
                         `ads_width` int DEFAULT '0',
                         `ads_height` int DEFAULT '0',
                         `material_url` varchar(255) DEFAULT NULL,
                         `status` varchar(255) DEFAULT NULL,
                         `created_at` datetime(6) DEFAULT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

INSERT INTO m_ads
(id, ads_id, ads_name, ads_type, ads_width, ads_height, material_url, status, created_at, updated_at)
VALUES(9, '11001', '코로나광고', 'Image', 700, 965, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/ad_corona.jpeg', 'ENABLE', now(), now())
, (10, '11002', '사이다 광고', 'Image', 358, 500, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/cider.jpeg', 'ENABLE', now(), now())
, (11, '11003', '중소기업 광고', 'Video', 497, 280, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/company_ads_pre.mp4', 'ENABLE', now(), now())
, (12, '11004', '하나은행 광고', 'Image', 700, 965, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/hanabank.jpeg', 'ENABLE', now(), now())
, (13, '11005', '우리은행 광고', 'Image', 400, 700, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/ilovewoori.jpeg', 'ENABLE', now(), now())
, (14, '11006', 'KB리브 광고', 'Image', 600, 300, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/kb_liiv.jpeg', 'ENABLE', now(), now())
, (15, '11007', 'KCC광고', 'Image', 1280, 720, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/kcc_ad.jpeg', 'ENABLE', now(), now())
, (16, '11008', 'Uplus 광고1', 'Video', 22, 512, 'https://taekyung7.s3.ap-northeast-2.amazonaws.com/ads_meterial/uplus_ads_pre.mp4', 'ENABLE', now(), now())
, (37, '11013', '13', 'Image', 912, 29, '129', 'ENABLE', now(), now());

drop table if exists m_app CASCADE;
CREATE TABLE `m_app` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `created_at` datetime(6) DEFAULT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         `app_id` varchar(255) DEFAULT NULL,
                         `app_key` varchar(255) DEFAULT NULL,
                         `app_name` varchar(255) DEFAULT NULL,
                         `status` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

INSERT INTO m_app
(id, created_at, updated_at, app_id, app_key, app_name, status)
VALUES(1, now(), now(), 'game1', 'app_IF2ZJv8OCTc0CsUP', '메타버스 게임앱', 'ENABLE');

drop table if exists m_strategy CASCADE;
CREATE TABLE `m_strategy` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `measuring_screen_areax` int DEFAULT NULL,
                              `measuring_screen_areay` int DEFAULT NULL,
                              `measuring_screen_area_width` int DEFAULT NULL,
                              `measuring_screen_area_height` int DEFAULT NULL,
                              `max_measuring_count` int DEFAULT NULL,
                              `waiting_interval` varchar(255) DEFAULT NULL,
                              `measuring_interval` varchar(255) DEFAULT NULL,
                              `viewable_time_image` varchar(255) DEFAULT NULL,
                              `viewable_time_video` varchar(255) DEFAULT NULL,
                              `cool_down_time` int DEFAULT '0',
                              `viewing_angle` int DEFAULT '0',
                              `visible_area` varchar(255) DEFAULT NULL,
                              `pixel_grid` varchar(255) DEFAULT NULL,
                              `reference_screen_handheldx` int DEFAULT NULL,
                              `reference_screen_handheldy` int DEFAULT NULL,
                              `reference_screen_bigx` int DEFAULT NULL,
                              `reference_screen_bigy` int DEFAULT NULL,
                              `screen_relative_length` varchar(255) DEFAULT NULL,
                              `created_at` datetime(6) DEFAULT NULL,
                              `updated_at` datetime(6) DEFAULT NULL,
                              PRIMARY KEY (`id`)
);


INSERT INTO m_strategy
(id, measuring_screen_areax, measuring_screen_areay, measuring_screen_area_width, measuring_screen_area_height, max_measuring_count, waiting_interval, measuring_interval, viewable_time_image, viewable_time_video, cool_down_time, viewing_angle, visible_area, pixel_grid, reference_screen_handheldx, reference_screen_handheldy, reference_screen_bigx, reference_screen_bigy, screen_relative_length, created_at, updated_at)
VALUES(2, 0, 0, 1, 1, 100, '1', '0.2', '1', '2', 3, 55, '0.9', '100', 1024, 768, 1536, 864, '0.1', now(), now());

drop table if exists m_user CASCADE;
CREATE TABLE `m_user` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `created_at` datetime(6) DEFAULT NULL,
                          `updated_at` datetime(6) DEFAULT NULL,
                          `email` varchar(255) NOT NULL,
                          `name` varchar(255) NOT NULL,
                          `picture` varchar(255) DEFAULT NULL,
                          `role` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`)
);