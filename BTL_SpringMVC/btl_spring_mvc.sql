create database springmvc
go
use springmvc
go
create table account(
	aid int primary key identity,
	accountName varchar(50) not null,
	password varchar(20) not null
)
go
create table category
(
    cid int PRIMARY key identity,
    name nvarchar(100) not null unique,
    status bit default(0)
)
go
CREATE TABLE product (
  pid INT primary key identity,
  name nVARCHAR(255) not null unique,
  price float not null,
  quantity int not null,
  image VARCHAR(255) ,
  categoryId int not null,
  status bit default(0),
  create_date date default(CURRENT_TIMESTAMP),
  foreign key(categoryId) references category(cid)
)
go
create table orders(
  oid INT primary key identity,
  total_amount float,
  quantity int not null,
  role bit default(0),
  create_date date default(CURRENT_TIMESTAMP) ,
  productId int not null,
  foreign key(productId) references product(pid)
)