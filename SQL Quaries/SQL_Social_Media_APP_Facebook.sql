create database Social_Media_APP_Facebook;

use Social_Media_APP_Facebook;

CREATE TABLE users (
    id INT PRIMARY KEY identity(1, 1),
    username NVARCHAR(50) UNIQUE not null,
    name NVARCHAR(255),
    email NVARCHAR(100) UNIQUE not null,
    password NVARCHAR(50) not null,
    reg_dt DATETIME2 default current_timestamp
);

CREATE TABLE posts (
    id INT PRIMARY KEY identity(1, 1),
    user_id INT not null,
    content NVARCHAR(MAX) not null,
    post_visibility int default 1, -- 0 - Public, 1 - Friends, 2 - Private
    post_dt DATETIME2 default current_timestamp,
	FOREIGN KEY (user_id) REFERENCES Users(id),
);

CREATE TABLE comments (
    id INT PRIMARY KEY identity(1, 1),
    post_id INT not null,
    user_id INT not null,
    content NVARCHAR(MAX) not null,
    comment_dt DATETIME2 default current_timestamp,
	FOREIGN KEY (user_id) REFERENCES Users(id),
	FOREIGN KEY (post_id) REFERENCES Posts(id),
);

CREATE TABLE likes (
    id INT PRIMARY KEY identity(1, 1),
    post_id INT not null,
    user_id INT not null,
    like_dt DATETIME2 default current_timestamp,
	FOREIGN KEY (user_id) REFERENCES Users(id),
	FOREIGN KEY (post_id) REFERENCES Posts(id),
);

CREATE TABLE friendships (
    id INT PRIMARY KEY identity(1, 1),
    user_id1 INT not null,
    user_id2 INT not null,
    friendship_status int default 0, -- 0 - Pending, 1 - Accepted, 2 - Rejected
	FOREIGN KEY (user_id1) REFERENCES Users(id),
	FOREIGN KEY (user_id2) REFERENCES Users(id),
);

insert into users(username, name, email, password) values('hanil123', 'hanil chhipani', 'hanil123@gmail.com', '12345');
insert into users(username, name, email, password) values('deeeeep', 'deep chhipani', 'deeeeep@gmail.com', '12345');

insert into posts(user_id, content, post_visibility) values(1, 'coding content', 0);
insert into posts(user_id, content) values(1, 'something else');

insert into posts(user_id, content, post_visibility) values(2, 'share market stock', 0);
insert into posts(user_id, content) values(2, 'jocks');

insert into comments(user_id, post_id, content) values(1, 3, 'hal hal...');
insert into comments(user_id, post_id, content) values(1, 4, 'aav deeeeeep...');

insert into comments(user_id, post_id, content) values(2, 1, 'wah fire...');
insert into comments(user_id, post_id, content) values(2, 2, 'aav hanil...');

insert into likes(user_id, post_id) values(1, 3);
insert into likes(user_id, post_id) values(2, 1);

insert into friendships(user_id1, user_id2, friendship_status) values(1, 2, 1);

select * from users;
select * from posts;
select * from comments;
select * from likes;
select * from friendships;

drop table users;
drop table posts;
drop table comments;
drop table likes;
drop table friendships;