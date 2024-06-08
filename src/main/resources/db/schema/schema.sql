create table address
(
    id      varchar(36) not null
        constraint address_pk
            primary key,
    country varchar(70) not null,
    city    varchar(70) not null,
    street  varchar     not null
);

alter table address
    owner to postgres;

create table student
(
    id              varchar(255) not null
        constraint student_pk
            primary key,
    name            varchar(50)  not null,
    age             integer      not null,
    email           varchar(100) not null,
    degree          double precision,
    phone           varchar(20),
    enrollment_date date,
    address_id      varchar(36)
        constraint student_address_id_fk
            references address
);

alter table student
    owner to postgres;

create unique index student_email_uindex
    on student (email);

