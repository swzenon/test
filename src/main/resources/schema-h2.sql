drop table if exists person;

create table person (
    person_id integer not null primary key auto_increment,
    name varchar not null,
    birth_date date not null
);