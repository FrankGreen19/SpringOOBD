create sequence hibernate_sequence start 1 increment 1;
create table client
(
    id           int4 not null,
    email        varchar(255),
    first_name   varchar(255),
    last_name    varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    discount     int4,
    primary key (id)
);
create table orders
(
    id          int4 generated by default as identity,
    order_date  timestamp,
    order_price float8,
    client_id   int4,
    primary key (id)
);
create table orders_products
(
    order_id    int4 not null,
    products_id int4 not null
);
create table product
(
    id            int4 generated by default as identity,
    product_brand varchar(255),
    product_price float8,
    product_type  varchar(255),
    primary key (id)
);
create table shop
(
    id      int4 generated by default as identity,
    address varchar(255),
    name    varchar(255),
    primary key (id)
);
create table shop_clients
(
    shop_id    int4 not null,
    clients_id int4 not null
);
create table shop_orders
(
    shop_id   int4 not null,
    orders_id int4 not null
);
create table shop_products
(
    shop_id     int4 not null,
    products_id int4 not null
);
create table shop_workers
(
    shop_id    int4 not null,
    workers_id int4 not null
);
create table worker
(
    id           int4 not null,
    email        varchar(255),
    first_name   varchar(255),
    last_name    varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    position     varchar(255),
    primary key (id)
);
alter table if exists orders_products
    add constraint UK_qmviv5y7625wak8tjq4nirybh unique (products_id);
alter table if exists shop_clients
    add constraint UK_goi7waa0lg7jfrtolfpxf8o5r unique (clients_id);
alter table if exists shop_orders
    add constraint UK_7ce3s8m8ucw2wk6h8pkpi1dqo unique (orders_id);
alter table if exists shop_products
    add constraint UK_jl6c6oa3w67miw5senqm8dc96 unique (products_id);
alter table if exists shop_workers
    add constraint UK_pdhqbbmhmv85q70tyc7iynte3 unique (workers_id);
alter table if exists orders
    add constraint FK17yo6gry2nuwg2erwhbaxqbs9 foreign key (client_id) references client;
alter table if exists orders_products
    add constraint FKrm329y1qei2vbtf3we4oh1gyx foreign key (products_id) references product;
alter table if exists orders_products
    add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders;
alter table if exists shop_clients
    add constraint FKq31mnuqff9jco3is4uywfgx16 foreign key (clients_id) references client;
alter table if exists shop_clients
    add constraint FKtd3lnky7cemmhqdg1dgr58sht foreign key (shop_id) references shop;
alter table if exists shop_orders
    add constraint FKp4d7jd756csbi53f8hljqivk3 foreign key (orders_id) references orders;
alter table if exists shop_orders
    add constraint FKma1w77ae07yi9uvf5ippephmu foreign key (shop_id) references shop;
alter table if exists shop_products
    add constraint FK3ed150whwkaf4cemdt05kxldb foreign key (products_id) references product;
alter table if exists shop_products
    add constraint FKrrqcs17d3j6jrxu91y1u7a01k foreign key (shop_id) references shop;
alter table if exists shop_workers
    add constraint FK2avspt0sid3hsvhle8r3hbe3e foreign key (workers_id) references worker;
alter table if exists shop_workers
    add constraint FKa3jh2xe7dce45dt1jrs1t6u8s foreign key (shop_id) references shop;