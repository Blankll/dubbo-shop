#!/bin/bash
mysql -h 127.0.0.1 -uroot -P 33060 -pshop@1996 << EOF
DROP DATABASE IF EXISTS \`shop\`;
CREATE DATABASE \`shop\` DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
DROP USER IF EXISTS 'shop'@'%';
CREATE USER 'shop'@'%' IDENTIFIED BY 'shop&&1234';
GRANT ALL ON shop.* TO 'shop'@'%';
EOF
