-- // create_users
-- Migration SQL that makes the change goes here.

-- 用户表
CREATE TABLE `users` (
     `id` BIGINT UNSIGNED NOT NULL PRIMARY KEY COMMENT 'user ID',
     `email` CHAR(100) UNIQUE NOT NULL COMMENT 'user email',
     `username` CHAR(100) UNIQUE NOT NULL COMMENT 'username',
     `password` CHAR(64) NOT NULL NULL COMMENT 'user password',
     `phone` CHAR(13) UNIQUE NOT NULL COMMENT 'phone number',
     `score` INT UNSIGNED DEFAULT 0 COMMENT '积分',
     `money` DECIMAL(10,2) DEFAULT 0 COMMENT 'user money',
     `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE `users`;
