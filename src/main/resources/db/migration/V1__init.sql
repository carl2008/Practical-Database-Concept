create table employee
(
    id int auto_increment,
    first_name varchar(50) null,
    last_name varchar(50) null,
    email varchar(100) null,
    constraint employee_pk
        primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;