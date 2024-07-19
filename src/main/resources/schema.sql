create table if not exists book_a
(
    id int primary key,
    name varchar(255) not null,
    source varchar(255) not null
);

create table if not exists book_b
(
    id int primary key,
    name varchar(255) not null,
    source varchar(255) not null
);
