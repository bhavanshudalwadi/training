USE [master]
GO
/****** Object:  Database [Inventory_Module]    Script Date: 24-01-2024 05:52:11 PM ******/
CREATE DATABASE [Inventory_Module]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Inventory_Module', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Inventory_Module.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Inventory_Module_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Inventory_Module_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Inventory_Module] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Inventory_Module].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Inventory_Module] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Inventory_Module] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Inventory_Module] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Inventory_Module] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Inventory_Module] SET ARITHABORT OFF 
GO
ALTER DATABASE [Inventory_Module] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Inventory_Module] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Inventory_Module] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Inventory_Module] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Inventory_Module] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Inventory_Module] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Inventory_Module] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Inventory_Module] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Inventory_Module] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Inventory_Module] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Inventory_Module] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Inventory_Module] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Inventory_Module] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Inventory_Module] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Inventory_Module] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Inventory_Module] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Inventory_Module] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Inventory_Module] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Inventory_Module] SET  MULTI_USER 
GO
ALTER DATABASE [Inventory_Module] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Inventory_Module] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Inventory_Module] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Inventory_Module] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Inventory_Module] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Inventory_Module] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Inventory_Module] SET QUERY_STORE = OFF
GO
USE [Inventory_Module]
GO
/****** Object:  UserDefinedFunction [dbo].[getProducts]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[getProducts](@cat_id int) returns int as
begin
	declare @products int;
	select @products = count(*) from Products where cat_id = @cat_id;
	return (@products)
end
GO
/****** Object:  UserDefinedFunction [dbo].[getSales]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[getSales](@cust_id int) returns int as
begin
	declare @sales int;
	select @sales = count(*) from SaleDetails where cust_id = @cust_id;
	return (@sales)
end
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[description] [nvarchar](1000) NULL,
	[img] [char](255) NULL,
	[dt] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[cat_id] [int] NOT NULL,
	[price] [decimal](10, 2) NULL,
	[in_stock] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Products_By_Category]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Products_By_Category] as
select c.name as cat_name, p.name as pname, p.price from Products p
inner join Categories c on c.id = p.cat_id;
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[phone] [nvarchar](20) NOT NULL,
	[email] [nvarchar](255) NULL,
	[address] [nvarchar](2000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SaleDetails]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SaleDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[transection_id] [int] NOT NULL,
	[cust_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Sales_With_Customer]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create view [dbo].[Sales_With_Customer] as
select c.name, count(sd.id) as sales_count from SaleDetails sd inner join Customers c on c.id = sd.cust_id group by c.name;
GO
/****** Object:  Table [dbo].[PurchaseDetails]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PurchaseDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[transection_id] [int] NOT NULL,
	[supplier_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[phone] [nvarchar](20) NOT NULL,
	[email] [nvarchar](255) NULL,
	[address] [nvarchar](2000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transactions]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transactions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NOT NULL,
	[qty] [int] NOT NULL,
	[type] [nvarchar](20) NULL,
	[price] [decimal](8, 2) NULL,
	[date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([id], [name], [description], [img], [dt]) VALUES (1, N'Staples', N'basic food items', N'./uploads/123product1.png                                                                                                                                                                                                                                      ', CAST(N'2024-01-22T14:22:39.0000000' AS DateTime2))
INSERT [dbo].[Categories] ([id], [name], [description], [img], [dt]) VALUES (2, N'Home Care', NULL, NULL, CAST(N'2024-01-22T14:22:39.0000000' AS DateTime2))
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Customers] ON 

INSERT [dbo].[Customers] ([id], [name], [phone], [email], [address]) VALUES (1, N'bhavanshu', N'3464564566', N'fghd@gfdg.sfg', N'gfhd fghdhfgd')
INSERT [dbo].[Customers] ([id], [name], [phone], [email], [address]) VALUES (2, N'Jainil', N'0987654321', NULL, NULL)
INSERT [dbo].[Customers] ([id], [name], [phone], [email], [address]) VALUES (3, N'bhavanshu', N'2657634785', N'fadsghg@gfdg.sfg', N'gfhd fghdhfgd')
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([id], [name], [cat_id], [price], [in_stock]) VALUES (1, N'Rice', 1, CAST(50.00 AS Decimal(10, 2)), 100)
INSERT [dbo].[Products] ([id], [name], [cat_id], [price], [in_stock]) VALUES (2, N'Mung Dal', 2, NULL, NULL)
INSERT [dbo].[Products] ([id], [name], [cat_id], [price], [in_stock]) VALUES (3, N'lsdkhfgd', 1, NULL, NULL)
INSERT [dbo].[Products] ([id], [name], [cat_id], [price], [in_stock]) VALUES (4, N'lsdkhfgd', 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[PurchaseDetails] ON 

INSERT [dbo].[PurchaseDetails] ([id], [transection_id], [supplier_id]) VALUES (1, 1, 1)
SET IDENTITY_INSERT [dbo].[PurchaseDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[SaleDetails] ON 

INSERT [dbo].[SaleDetails] ([id], [transection_id], [cust_id]) VALUES (1, 2, 1)
SET IDENTITY_INSERT [dbo].[SaleDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Suppliers] ON 

INSERT [dbo].[Suppliers] ([id], [name], [phone], [email], [address]) VALUES (1, N'Henil', N'1234567890', N'henil123@gmail.com', N'henil ka address')
INSERT [dbo].[Suppliers] ([id], [name], [phone], [email], [address]) VALUES (2, N'Chirag', N'4533543543', NULL, NULL)
SET IDENTITY_INSERT [dbo].[Suppliers] OFF
GO
SET IDENTITY_INSERT [dbo].[Transactions] ON 

INSERT [dbo].[Transactions] ([id], [product_id], [qty], [type], [price], [date]) VALUES (1, 1, 20, N'purchase', CAST(120.00 AS Decimal(8, 2)), CAST(N'2024-01-22T14:22:39.003' AS DateTime))
INSERT [dbo].[Transactions] ([id], [product_id], [qty], [type], [price], [date]) VALUES (2, 2, 20, NULL, NULL, CAST(N'2024-01-22T14:22:39.007' AS DateTime))
SET IDENTITY_INSERT [dbo].[Transactions] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Customer__B43B145FFE97CDD2]    Script Date: 24-01-2024 05:52:11 PM ******/
ALTER TABLE [dbo].[Customers] ADD UNIQUE NONCLUSTERED 
(
	[phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [IX_Products_CategoryId]    Script Date: 24-01-2024 05:52:11 PM ******/
CREATE NONCLUSTERED INDEX [IX_Products_CategoryId] ON [dbo].[Products]
(
	[cat_id] DESC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Supplier__B43B145F587074C6]    Script Date: 24-01-2024 05:52:11 PM ******/
ALTER TABLE [dbo].[Suppliers] ADD UNIQUE NONCLUSTERED 
(
	[phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [IX_Transactions_ProductId]    Script Date: 24-01-2024 05:52:11 PM ******/
CREATE NONCLUSTERED INDEX [IX_Transactions_ProductId] ON [dbo].[Transactions]
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Categories] ADD  DEFAULT (getdate()) FOR [dt]
GO
ALTER TABLE [dbo].[Transactions] ADD  DEFAULT (getdate()) FOR [date]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([cat_id])
REFERENCES [dbo].[Categories] ([id])
GO
ALTER TABLE [dbo].[PurchaseDetails]  WITH CHECK ADD FOREIGN KEY([supplier_id])
REFERENCES [dbo].[Suppliers] ([id])
GO
ALTER TABLE [dbo].[PurchaseDetails]  WITH CHECK ADD FOREIGN KEY([transection_id])
REFERENCES [dbo].[Transactions] ([id])
GO
ALTER TABLE [dbo].[SaleDetails]  WITH CHECK ADD FOREIGN KEY([cust_id])
REFERENCES [dbo].[Customers] ([id])
GO
ALTER TABLE [dbo].[SaleDetails]  WITH CHECK ADD FOREIGN KEY([transection_id])
REFERENCES [dbo].[Transactions] ([id])
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[Products] ([id])
GO
/****** Object:  StoredProcedure [dbo].[AddCustomer]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[AddCustomer]
	@name NVARCHAR(255),
	@phone NVARCHAR(20),
	@email NVARCHAR(255),
	@address NVARCHAR(50)
AS
    INSERT INTO Customers VALUES (@name,@phone,@email,@address)
GO
/****** Object:  StoredProcedure [dbo].[AddRecord]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[AddRecord]
	@name NVARCHAR(255),
	@phone NVARCHAR(20),
	@email NVARCHAR(255),
	@address NVARCHAR(50)
AS
    INSERT INTO Customers VALUES (@name,@phone,@email,@address)
GO
/****** Object:  StoredProcedure [dbo].[DeleteCustomer]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DeleteCustomer]
	@id int
AS
    DELETE FROM Customers where id = @id
GO
/****** Object:  StoredProcedure [dbo].[FULLTR]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[FULLTR]
AS
	exec SelectAllCustomers;
	exec AddCustomer @name='bhavanshu', @phone = '2657634785', @email = 'fadsghg@gfdg.sfg', @address = 'gfhd fghdhfgd';
	exec UpdateCustomer @id = 1, @name='bhavanshu', @phone = '3464564566', @email = 'fghd@gfdg.sfg', @address = 'gfhd fghdhfgd';
	exec DeleteCustomer @id = 1;
GO
/****** Object:  StoredProcedure [dbo].[SelectAllCustomers]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectAllCustomers]
AS
    SELECT * FROM Customers;
GO
/****** Object:  StoredProcedure [dbo].[SelectAllRecords]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectAllRecords]
AS
    SELECT * FROM Customers;
GO
/****** Object:  StoredProcedure [dbo].[UpdateCustomer]    Script Date: 24-01-2024 05:52:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateCustomer]
	@id int,
	@name NVARCHAR(255),
	@phone NVARCHAR(20),
	@email NVARCHAR(255),
	@address NVARCHAR(50)
AS
    UPDATE Customers SET name = @name,phone = @phone,email = @email, address = @address where id = @id
GO
USE [master]
GO
ALTER DATABASE [Inventory_Module] SET  READ_WRITE 
GO
