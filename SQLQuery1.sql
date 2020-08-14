create database ProjectJavaWeb
go 

use ProjectJavaWeb 
go

create table Users(
userID int primary key identity(1,1),
fullname nvarchar(50) not null ,
birthdate date not null ,
gender bit not null ,
addresses nvarchar(300) not null ,
phone nvarchar(13) not null 
)
go

create table Roles
(
roleID nvarchar(10) primary key ,
nameRole nvarchar(30) not null,
)
go

create table Log_in
(
loginID nvarchar(10) primary key ,
password nvarchar(30) not null,
roleID nvarchar(10) not null,
userID int not null,
isActive bit ,
foreign key (userID) references Users(userID),
foreign key (roleID) references Roles(roleID)
)
go

create table Books
(


)

create table Orders
(


)
create table Orders
(


)


select * from [dbo].[Users]