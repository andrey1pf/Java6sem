create table customer
(
    id      int auto_increment
        primary key,
    surname char(100) not null,
    name    char(100) not null
);

create table service
(
    id             int auto_increment
        primary key,
    description    char(100) not null,
    qualification  int       not null,
    amount_workers int       not null
);

create table orders
(
    id          int auto_increment
        primary key,
    id_customer int        not null,
    id_task     int        not null,
    price       int        not null,
    paid        tinyint(1) not null,
    constraint foreign_key_customer
        foreign key (id_customer) references customer (id),
    constraint foreign_key_service
        foreign key (id_task) references service (id)
);

create table workers
(
    id            int auto_increment
        primary key,
    qualification int        not null,
    salary        float      not null,
    employment    tinyint(1) not null
);


