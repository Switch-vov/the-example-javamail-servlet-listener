# create database
```
create database test character set utf8;
use test;
```

# create table user
```
create table `user`(
  id int primary key auto_increment,
  username varchar(50),
  birthday date,
  email varchar(100)
);
```

# insert into user
```
insert into user(username,birthday,email) values('admin','1994-01-01','admin@store.com');
insert into user(username,birthday,email) values('Switch','1996-10-23','Switch@store.com');
insert into user(username,birthday,email) values('Kity','1995-10-23','Kity@store.com');
insert into user(username,birthday,email) values('Siwtch','1996-10-23','q547550831@outlook.com');
```