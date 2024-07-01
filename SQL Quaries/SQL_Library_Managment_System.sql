create database Library_Managment_System;

use Library_Managment_System;

create table categories (
	id int primary key identity(1, 1),
	name nvarchar(255) not null
)

create table authors (
	id int primary key identity(1, 1),
	name nvarchar(255) not null
)

create table books (
	id int primary key identity(1, 1),
	title nvarchar(255) not null,
	description nvarchar(255),
	cat_id int not null,
	author_id int not null,
	dt datetime default current_timestamp,
	foreign key (cat_id) references categories(id),
	foreign key (author_id) references authors(id)
)

create table users (
	id int primary key identity(1, 1),
	name nvarchar(255) not null,
	phone nvarchar(20) UNIQUE not null,
	email nvarchar(255),
	address nvarchar(2000)
)

create table rents (
	id int primary key identity(1, 1),
	user_id int not null,
	book_id int not null,
	end_time datetime not null,
	start_time datetime default current_timestamp,
	foreign key (book_id) references books(id)
)

create table waitlist (
	id int primary key identity(1, 1),
	user_id int not null,
	book_id int not null,
	req_date datetime default current_timestamp,
)

insert into categories(name) values('Fantasy');
insert into categories(name) values('Love Story');

insert into authors(name) values('J. K. Rolling');
insert into authors(name) values('Chetan Bhagat');

insert into books(title, description, cat_id, author_id)
values(
	'Harry Potter and the Philosopher''s Stone',
	'Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts. Even as he escapes a dreary life and enters a world of magic, he finds trouble awaiting him.',
	1,
	1
)
insert into books(title, description, cat_id, author_id)
values(
	'2 States',
	'It is the story about a couple coming from two states in India, who face hardships in convincing their parents to approve of their marriage',
	2,
	2
)

insert into users(name, phone, email, address) values('Henil', '1234567890', 'henil123@gmail.com', 'henil ka address');
insert into users(name, phone) values('Deeeeep', '1234567890');

insert into rents(user_id, book_id, end_time) values(1, 1, '2024-02-20');
insert into rents(user_id, book_id, end_time) values(2, 2, '2024-02-20');

insert into waitlist(user_id, book_id) values(1, 2);
insert into waitlist(user_id, book_id) values(2, 1);

select * from categories;
select * from authors;
select * from books;
select * from users;
select * from rents;
select * from waitlist;

drop table categories;
drop table authors;
drop table books;
drop table users;
drop table rents;
drop table waitlist;

drop database Library_Managment_System;