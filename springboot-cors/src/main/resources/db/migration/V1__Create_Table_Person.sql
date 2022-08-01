create schema if not exists nmcz;

create table if not exists nmcz.person (
    id SERIAL not null,
    address varchar(100) not null, 
    first_name varchar(80) not null, 
    gender varchar(6) not null, 
    last_name VARCHAR(80) NOT NULL,
    constraint pk_person primary key (id)
); 
