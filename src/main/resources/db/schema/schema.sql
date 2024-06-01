create table student
(
    id    varchar(255) not null
        constraint student_pk
            primary key,
    name  varchar(50)  not null,
    age   integer      not null,
    email varchar(100) not null
);

create unique index student_email_uindex
    on student (email);



INSERT INTO student (id, name, age, email) VALUES ('f24537e5-932b-4a06-8ed8-bbd78c5c178e', 'Ragheb', 22, 'ragheb@pioneers.com');

select * from student;


alter table student
    add degree float;

alter table student
    add phone varchar(20);

alter table student
    add enrollment_date varchar(10);

alter table student
    drop column enrollment_date;

alter table student
    add enrollment_date DATE;
