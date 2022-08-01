create schema if not exists nmcz;

create table if not exists nmcz.books (
    id SERIAL not null,
    author varchar(100) not null, 
    launch_date TIMESTAMP not null, 
    price decimal(65,2) not null, 
    title VARCHAR(200) NOT NULL,
    constraint pk_books primary key (id)
); 
