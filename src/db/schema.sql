drop table if exists requests;
drop table if exists users;
drop table if exists logins;
create table logins(username varchar primary key, loginpass varchar not null, access varchar not null);
create table users(userId serial primary key, firstName varchar not null, lastName varchar not null, usersName varchar references logins(username));
create table requests(requestId serial primary key, requestName varchar not null, requestType varchar not null, cost numeric(10,2) not null, requestDescription varchar, rUsersname varchar references logins(username) not null, approved varchar not null);

insert into logins(username, loginpass, access) values('KellyAD', 'p4ssw0rd', 'admin');
insert into users(firstName, lastName, usersName) values('Kelly', 'Schwartz', 'KellyAD');
insert into requests(requestId, requestName, requestType, cost, rUsersname, approved) values(1, 'testRequest', 'testType', 20.00, 'KellyAD', 'pending');