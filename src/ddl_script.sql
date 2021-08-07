drop table category_master;
drop table productmaster;
drop table invoice;
drop table stock;
drop table orders;
drop table order_items;
drop table customer;

create table if not exists category_master
(
    id int auto_increment
        primary key,
    category_name varchar(200) null
);

create table if not exists customer
(
    customer_id int auto_increment,
    customer_name varchar(500) not null,
    phone_number varchar(10) null,
    address varchar(500) null,
    constraint customer_customer_id_uindex
        unique (customer_id)
);

alter table customer
    add primary key (customer_id);

create table if not exists invoice
(
    order_id int not null,
    customer_id int not null,
    invoice_id int auto_increment
        primary key
);

create table if not exists order_items
(
    order_id int not null,
    product_id int not null,
    qty int null,
    item_total decimal(10,2) null
);

create table if not exists orders
(
    order_id int auto_increment
        primary key,
    order_total decimal(10,2) null,
    order_date datetime default CURRENT_TIMESTAMP not null
);

create table if not exists productmaster
(
    category varchar(200) null,
    rate decimal(10,2) null,
    model varchar(200) null,
    company varchar(200) null,
    pname varchar(500) not null,
    product_id int auto_increment,
    constraint productmaster_product_id_uindex
        unique (product_id)
);

alter table productmaster
    add primary key (product_id);

create table if not exists stock
(
    product_id int not null
        primary key,
    qty int null
);

