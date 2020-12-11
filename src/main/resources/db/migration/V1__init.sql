use 'pdc';

create table movie
(
    id                   int auto_increment
        primary key,
    movie_name  varchar(100) null,
    directors   varchar(100) null,
    cast        varchar(250) null,
    category    varchar(100) null,
    premiere    date         null,
    duration    int          null,
    language    varchar(100) null,
    rated       varchar(100) null,
    description varchar(500) null
);

create table timetable
(
	id int auto_increment,
	time_slot int null,
	seat_available int null,
	movie_id int null,
	constraint timetable_pk
		primary key (id)
);