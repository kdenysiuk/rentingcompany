create database rental_company;
use rental_company;

create table user (
id int auto_increment,
email varchar(50) not null,
telephone varchar(10),
primary key(id),
unique key(email)
);

create table licence (
id int auto_increment,
emitiondate date not null,
expirationdate date not null,
fk_user int not null,
primary key(id),
foreign key(fk_user) references user(id)
);


