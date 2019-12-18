create table users (username varchar(50) not null, password varchar(50) not null, enabled tinyint(1) not null, primary key('username'));
create table authorities (username varchar(50), authority varchar(50));

insert into users (username, password, enabled) values ('Diego', '{noop}1234', 1);
insert into users (username, password, enabled) values ('Pepito', '{noop}1234', 1);
insert into users (username, password, enabled) values ('Jaimito', '{noop}1234', 1);

insert into authorities (username, authority) value ('Diego', 'ROLE_EMPLOYEE, ROLE_ADMIN');
insert into authorities (username, authority) value ('Pepito', 'ROLE_EMPLOYEE');
insert into authorities (username, authority) value ('Jaimito', 'ROLE_EMPLOYEE, ROLE_MANAGER');