create database LibraryManagement

create table Roles 
(
	roleID int identity (1,1) primary key , 
	roleName nvarchar(30) not null 
)

create table Users
(
	userID int primary key identity(1,1),
	userName varchar(10) not null unique,
	userPassword varchar(20) not null,
	fullName nvarchar(50) not null,
	isActive bit not null,
	roleID int FOREIGN KEY REFERENCES Roles(roleID)
)

select * from Users


select [fullName],[roleID] from Users where [userName] = 'aa' and [userPassword] = '1'


CREATE TABLE Category(
	categoryID nvarchar(10) primary key,
	categoryName nvarchar(50) not null
)

CREATE TABLE Books(
	bookID varchar(10) primary key,
	bookName nvarchar(50) not null,
	bookQuantity int CHECK(bookQuantity > 0),
	bookPublisher nvarchar(30),
	bookAuthor nvarchar(50),
	bookDescription nvarchar(2000),
	categoryID nvarchar(10) FOREIGN KEY REFERENCES Category(categoryID)
)

CREATE TABLE Orders(
	orderID int identity(1,1) primary key,
	userID int FOREIGN KEY REFERENCES Users(userID),
	orderDate date not null,
	returnDate date not null
)

CREATE TABLE orderDetail(
	orderDetailID int identity(1,1) primary key,
	bookID varchar(10) FOREIGN KEY REFERENCES Books(bookID),
	amount int CHECK(amount > 0),
	orderID int FOREIGN KEY REFERENCES Orders(orderID)
)

select * from Books

ALTER TABLE Books
ADD prices float check ( prices > 0 )

ALTER TABLE Books
ADD showCart bit  

select * from Books
select bookName, bookQuantity , bookDescription , prices from Books inner Book orderDetail where bookName like '%j%'

bookQuantity = bookQuantity - amount from orderDetail and Books

use LibraryManagement

------------------------
-- update showCart

declare @bookShow bit 
declare @Amount int 
declare @Quantity int 
declare @bookID varchar(10)
select @bookID = b.bookID from Books as b inner join orderDetail as o on b.bookID  = o.bookID  
select @Quantity = bookQuantity from Books as b inner join orderDetail as o on b.bookID  = o.bookID  
select @Amount = amount  from Books as b inner join orderDetail as o on b.bookID  = o.bookID 
declare @tableSize int 
select @tableSize 

while (@Quantity < @Amount)
if (@Quantity > @Amount)
	begin
		set @bookShow = 1
		update Books set showCart = @bookShow 
	end
else
	begin
		set @bookShow = 0
		update Books set showCart = @bookShow
	end
select showCart from Books
----------------------------------
		update Books set showCart = @bookShow
		if (@bookAvailable < 0 )
			begin 
				set @bookShow = 0
				update Books set showCart = @bookShow
			end
	end

	
--------------------------------------------------------
print @bookShow

declare @cartShow bit 
select  @cartShow = 1

insert into Books (showCart) values (1)

select showCart from Books

select bookQuantity , bookID
from Books

select b.bookID from Books as b inner join orderDetail as o on b.bookID  = o.bookID  
select bookQuantity from Books as b inner join orderDetail as o on b.bookID  = o.bookID 

declare @i varchar(10)
select @i = bookID from Books
declare @tableSizes int
whi

select len(select bookID from Books)

while (select bookID. from Books)
begin 

end 

insert into Orders ([userID],[orderDate],[returnDate]) values (3,'2-2-2020','3-3-2020')
select * from Orders

delete Orders where orderID = '3'

select * from orderDetail

ALTER TABLE Books
 ALTER COLUMN bookQuantity CHECK(bookQuantity >= 0) int 