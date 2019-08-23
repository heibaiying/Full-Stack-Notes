-- 用户数据库
CREATE DATABASE ec_shop_customer;
-- 商品数据库
CREATE DATABASE ec_shop_product;
-- 订单数据库
CREATE DATABASE ec_shop_order;

-- 用户表
CREATE TABLE IF NOT EXISTS customers
(
    customer_id   INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    customer_name VARCHAR(20)  NOT NULL COMMENT '用户姓名',
    modified_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY pk_customer_id (customer_id)
) ENGINE = innodb COMMENT '用户信息表';

INSERT INTO customers(customer_name) VALUE ('heibai');
INSERT INTO customers(customer_name) VALUE ('ying');


-- 商品表
CREATE TABLE products
(
    product_id    INT UNSIGNED NOT NULL COMMENT '商品ID',
    product_name  VARCHAR(20)  NOT NULL COMMENT '商品名称',
    modified_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY pk_product_id (product_id)
) ENGINE = innodb COMMENT '商品表';

INSERT INTO products(product_id, product_name) VALUE (1, 'MIX5手机');
INSERT INTO products(product_id, product_name) VALUE (2, '大熊饼干');


-- 订单表
CREATE TABLE IF NOT EXISTS orders
(
    order_id      INT UNSIGNED NOT NULL COMMENT '订单ID',
    customer_id   INT UNSIGNED NOT NULL COMMENT '购买者ID',
    modified_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY pk_order_id (order_id)
) ENGINE = innodb COMMENT '订单表';

INSERT INTO orders(order_id, customer_id) VALUE (1001, 1);
INSERT INTO orders(order_id, customer_id) VALUE (1002, 2);
INSERT INTO orders(order_id, customer_id) VALUE (1003, 1);
INSERT INTO orders(order_id, customer_id) VALUE (1004, 2);


-- 订单明细表
CREATE TABLE IF NOT EXISTS order_detail
(
    order_detail_id INT UNSIGNED NOT NULL COMMENT '主键ID',
    order_id        INT UNSIGNED NOT NULL COMMENT '订单ID',
    product_id      INT UNSIGNED NOT NULL COMMENT '商品ID',
    modified_time   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY pk_order_detail_id (order_detail_id)
) ENGINE = innodb COMMENT '订单明细表';

INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (15, 1001, 1);
INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (16, 1001, 2);
INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (17, 1002, 1);
INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (18, 1003, 1);
INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (19, 1004, 1);
INSERT INTO order_detail(order_detail_id, order_id, product_id) VALUE (10, 1004, 2);

-- 地址表
CREATE TABLE area_info
(
    area_id       INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '主键ID',
    code          varchar(6)                  NOT NULL COMMENT '行政单位代码',
    name          varchar(50)                 NOT NULL COMMENT '行政单位名称',
    parent_code   varchar(6)                  NOT NULL COMMENT '上一级行政单位代码',
    modified_time TIMESTAMP                   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY pk_id (area_id)
) ENGINE = innodb COMMENT '地址表';

INSERT INTO area_info(code, name, parent_code)
VALUES ('110100', '市辖区', '110000');
INSERT INTO area_info(code, name, parent_code)
VALUES ('110101', '东城区', '110100');

