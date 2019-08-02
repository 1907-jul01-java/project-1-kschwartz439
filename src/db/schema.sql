drop table if exists request;
drop table if exists users;
drop table if exists logins;
create table logins(username varchar primary key, password varchar not null, access varchar not null);
create table users(firstName varchar not null, lastName varchar not null, usersName varchar references username primary key);
create table requests(requestName varchar not null, requestType varchar not null, cost money not null, requestDescription varchar, imageLocation filestream, rUsersname varchar references username not null, requestId serial primary key);

insert into logins(KellyAD, p4ssw0rd, admin);
insert into users(Kelly, Schwartz, KellyAD);