-- // create_goods
-- Migration SQL that makes the change goes here.
CREATE TABLE `goods`
(
    `id`       BIGINT UNSIGNED NOT NULL PRIMARY KEY COMMENT '商品id',
    `name`     VARCHAR(100)    NOT NULL COMMENT '商品名称',
    `quantity` INT UNSIGNED    NOT NULL DEFAULT 0 COMMENT '商品库存',
    `price`    DECIMAL(10, 2)           DEFAULT 0 COMMENT '商品价格',
    `desc`     VARCHAR(255)             DEFAULT NULL COMMENT '商品描述',
    `created`  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated`  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE `goods`;

