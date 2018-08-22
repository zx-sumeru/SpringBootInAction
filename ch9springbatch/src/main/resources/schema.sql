drop table if exists PERSON;
create table PERSON
(
  id int not null primary key auto_increment,
  name varchar(20),
  age int,
  nation varchar(20),
  address varchar(20)
);