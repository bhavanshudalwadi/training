create database Inventory_Module;

use Inventory_Module;

CREATE TABLE Categories (
    id INT PRIMARY KEY IDENTITY(1,1),
    name VARCHAR(255) NOT NULL,
	description NVARCHAR(1000),
	img CHAR(255),
	dt datetime2 DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Products (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    cat_id INT NOT NULL,
    price DECIMAL(10, 2),
    in_stock INT,
    FOREIGN KEY (cat_id) REFERENCES categories(id)
);

CREATE TABLE Customers (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    phone NVARCHAR(20) Unique NOT NULL,
    email NVARCHAR(255),
    address NVARCHAR(2000)
);

CREATE TABLE Transactions (
    id INT PRIMARY KEY IDENTITY(1,1),
    product_id INT NOT NULL,
    qty INT NOT NULL,
    type NVARCHAR(20),
    price DECIMAL(8, 2),
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (product_id) REFERENCES Products(id),
);

CREATE TABLE Suppliers (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    phone NVARCHAR(20) unique NOT NULL,
    email NVARCHAR(255),
    address NVARCHAR(2000)
);

CREATE TABLE PurchaseDetails (
    id INT PRIMARY KEY IDENTITY(1,1),
    transection_id INT NOT NULL,
    supplier_id INT NOT NULL,
	FOREIGN KEY (supplier_id) REFERENCES Suppliers(id),
	FOREIGN KEY (transection_id) REFERENCES Transactions(id),
);

CREATE TABLE SaleDetails (
    id INT PRIMARY KEY IDENTITY(1,1),
    transection_id INT NOT NULL,
    cust_id INT NOT NULL,
	FOREIGN KEY (transection_id) REFERENCES Transactions(id),
	FOREIGN KEY (cust_id) REFERENCES Customers(id)
);

insert into Customers(name, phone, email, address) values('Deep', '1234567890', 'deep123@gmail.com', 'deep ka address');
insert into Customers(name, phone) values('Jainil', '0987654321');
insert into Suppliers(name, phone, email, address) values('Henil', '1234567890', 'henil123@gmail.com', 'henil ka address');
insert into Suppliers(name, phone) values('Chirag', '4533543543');
insert into Categories(name, description, img) values('Staples', 'basic food items', './uploads/123product1.png');
insert into Categories(name) values('Home Care');
insert into Products(name, cat_id, price, in_stock) values('Rice', 1, 50, 100);
insert into Products(name, cat_id) values('Mung Dal', 2);
insert into Transactions(type, product_id, qty, price) values('purchase', 1, 20, 120);
insert into Transactions(product_id, qty) values(2, 20);
insert into PurchaseDetails(transection_id, supplier_id) values(1, 1);
insert into SaleDetails(transection_id, cust_id) values(2, 1);

select * from Customers;
select * from Suppliers;
select * from Categories;
select * from Products;
select * from Transactions;
select * from PurchaseDetails;
select * from SaleDetails;

drop table Customers;
drop table Suppliers;
drop table PurchaseDetails;
drop table SaleDetails;
drop table Products;
drop table Categories;
drop table Transactions;

drop database Inventory_Module;
