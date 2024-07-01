-- <<<<<<<<<<<< Assignment 8 >>>>>>>>>>>
use Inventory_Module;

create view Products_By_Category as
select c.name as cat_name, p.name as pname, p.price from Products p
inner join Categories c on c.id = p.cat_id;

create view Sales_With_Customer as
select c.name, count(sd.id) as sales_count from SaleDetails sd inner join Customers c on c.id = sd.cust_id group by c.name;

select * from Products_By_Category;
select * from Sales_With_Customer;
------------------------------------------------------
use Library_Managment_System;

create view Rented_Books as
select u.name, b.title, r.start_time, r.end_time from rents r
inner join books b on b.id = r.book_id
inner join users u on u.id = r.user_id;

create view Wait_List as
select u.name, b.title, w.req_date from waitlist w
inner join users u on u.id = w.user_id
inner join books b on b.id = w.book_id;

select * from Rented_Books;
select * from Wait_List;
----------------------------------------------------------
use Social_Media_APP_Facebook;

create view Posts_By_Users as
select u.name, p.content from posts p
inner join users u on u.id = p.user_id

create view Posts_With_Comments as
select (select name from users where id = p.user_id) as post_by, p.content as post, u.name as comment_by, c.content as comment from comments c
inner join posts p on p.id = c.post_id
inner join users u on u.id = c.user_id;

select * from Posts_By_Users;
select * from Posts_With_Comments;


-- <<<<<<<<< Assignment 9 >>>>>>>>>>
use Inventory_Module;

create function getProducts(@cat_id int) returns int as
begin
	declare @products int;
	select @products = count(*) from Products where cat_id = @cat_id;
	return (@products)
end
-- Scalar Functions => one/more parameter, single return value
-- 
select name, dbo.getProducts(id) from Categories;

create function getSales(@cust_id int) returns int as
begin
	declare @sales int;
	select @sales = count(*) from SaleDetails where cust_id = @cust_id;
	return (@sales)
end

create function checkNull(@val as varchar(2000)) returns varchar(2000) as
begin
	declare @str varchar(2000)
	if @val != ''
	begin
		set @str = @val
	end
	else
	begin
		set @str = 'Value is Null'
	end
	return @str
end

drop function checkNull;

select name, ISNULL(Products.price, 0) from Products;
select name, dbo.checkNull(Products.price) from Products;

select name, dbo.getSales(id) from Customers;

--------------------------------------------------------------------

use Library_Managment_System;

create function getRentedBook(@user_id int) returns int as
begin
	declare @books int;
	select @books = count(*) from rents where user_id = @user_id;
	return (@books)
end

select name, dbo.getRentedBook(id) from users;

create function getBooks(@auther_id int) returns int as
begin
	declare @books int;
	select @books = count(*) from books where author_id = @auther_id;
	return (@books)
end

select name, dbo.getBooks(id) from authors;
---------------------------------------------------------------------

use Social_Media_APP_Facebook;

create function getPosts(@user_id int) returns int as
begin
	declare @posts int;
	select @posts = count(*) from posts where user_id = @user_id;
	return (@posts)
end

select name, dbo.getPosts(id) from users;

create function getLikes(@user_id int) returns int as
begin
	declare @likes int;
	select @likes = count(*) from likes where user_id = @user_id;
	return (@likes)
end

select name, dbo.getLikes(id) from users;


-- <<<<<<<<< Assignment 10 >>>>>>>>>>
use Inventory_Module;

CREATE PROCEDURE SelectAllCustomers
AS
    SELECT * FROM Customers;
GO

CREATE PROCEDURE AddCustomer
	@name NVARCHAR(255),
	@phone NVARCHAR(20),
	@email NVARCHAR(255),
	@address NVARCHAR(50)
AS
    INSERT INTO Customers VALUES (@name,@phone,@email,@address)
GO

CREATE PROCEDURE UpdateCustomer
	@id int,
	@name NVARCHAR(255),
	@phone NVARCHAR(20),
	@email NVARCHAR(255),
	@address NVARCHAR(50)
AS
    UPDATE Customers SET name = @name,phone = @phone,email = @email, address = @address where id = @id
GO

CREATE PROCEDURE DeleteCustomer
	@id int
AS
    DELETE FROM Customers where id = @id
GO

CREATE PROCEDURE FULLTR
AS
	exec SelectAllCustomers;
	exec AddCustomer @name='bhavanshu', @phone = '2657634785', @email = 'fadsghg@gfdg.sfg', @address = 'gfhd fghdhfgd';
	exec UpdateCustomer @id = 1, @name='bhavanshu', @phone = '3464564566', @email = 'fghd@gfdg.sfg', @address = 'gfhd fghdhfgd';
	exec DeleteCustomer @id = 1;
GO

exec FULLTR;

-- <<<<<<<<< Assignment 11 >>>>>>>>>>
use Inventory_Module;

CREATE NONCLUSTERED INDEX IX_Products_CategoryId
ON Products (cat_id DESC);

CREATE NONCLUSTERED INDEX IX_Transactions_ProductId
ON Transactions (product_id);

use Library_Managment_System;

CREATE NONCLUSTERED INDEX IX_Books_AutherId
ON books (author_id);

CREATE NONCLUSTERED INDEX IX_Books_CatId
ON books (cat_id);

use Social_Media_APP_Facebook;

CREATE NONCLUSTERED INDEX IX_Posts_UserId
ON posts (user_id);

CREATE NONCLUSTERED INDEX IX_Likes_PostId
ON likes (post_id);

-- <<<<<<<<< Assignment 12 >>>>>>>>>>

CREATE TRIGGER InsteadOfInsertProducts
ON Products
INSTEAD OF INSERT
AS
BEGIN
	print 'Insert Started';

    INSERT INTO Products (name, cat_id, price, in_stock)
    SELECT name, cat_id, price, in_stock
    FROM inserted;
END;

CREATE TRIGGER AfterInsertProducts
ON Products
AFTER INSERT
AS
BEGIN
    print 'Inserted';
END;

Insert into Products(name, cat_id) values('lsdkhfgd', 1)

CREATE TRIGGER InsteadOfUpdateProducts
ON Products
INSTEAD OF Update
AS
BEGIN
	print 'Update Started';
END;

CREATE TRIGGER AfterUpdateProducts
ON Products
AFTER Update
AS
BEGIN
    print 'Updated';
END;

Update Products set name = 'jehfd', cat_id = 2 where id = 1

CREATE TRIGGER InsteadOfDeleteProducts
ON Products
INSTEAD OF Delete
AS
BEGIN
	print 'Delete Started';
END;

CREATE TRIGGER AfterDeleteProducts
ON Products
AFTER Delete
AS
BEGIN
    print 'Deleted';
END;

Delete from Products where id = 1

-- <<<<<<<<< Assignment 13 >>>>>>>>>>

SELECT name FROM Products
UNION
SELECT DISTINCT p.name
FROM Products p
INNER JOIN Transactions t ON p.id = t.product_id;

SELECT name FROM Products
UNION ALL
SELECT p.name
FROM Products p
INNER JOIN Transactions t ON p.id = t.product_id;

-- <<<<<<<<< Assignment 18 >>>>>>>>>>

select p.name, c.name from Products p
inner join Categories c on c.id = p.cat_id;

select p.* from Products p
left join Categories c on c.id = p.cat_id;

select c.* from Products p
right join Categories c on c.id = p.cat_id;

select p.*, c.* from Products p
join Categories c on c.id = p.cat_id;