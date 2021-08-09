drop table if exists person;

create table person (
                        person_id serial PRIMARY KEY,
                        name varchar not null,
                        birth_date date not null
);