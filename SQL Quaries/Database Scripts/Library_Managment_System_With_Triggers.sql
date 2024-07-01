USE [master]
GO
/****** Object:  Database [Library_Managment_System]    Script Date: 24-01-2024 05:54:01 PM ******/
CREATE DATABASE [Library_Managment_System]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Library_Managment_System', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Library_Managment_System.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Library_Managment_System_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Library_Managment_System_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Library_Managment_System] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Library_Managment_System].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Library_Managment_System] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Library_Managment_System] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Library_Managment_System] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Library_Managment_System] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Library_Managment_System] SET ARITHABORT OFF 
GO
ALTER DATABASE [Library_Managment_System] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Library_Managment_System] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Library_Managment_System] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Library_Managment_System] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Library_Managment_System] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Library_Managment_System] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Library_Managment_System] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Library_Managment_System] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Library_Managment_System] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Library_Managment_System] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Library_Managment_System] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Library_Managment_System] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Library_Managment_System] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Library_Managment_System] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Library_Managment_System] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Library_Managment_System] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Library_Managment_System] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Library_Managment_System] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Library_Managment_System] SET  MULTI_USER 
GO
ALTER DATABASE [Library_Managment_System] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Library_Managment_System] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Library_Managment_System] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Library_Managment_System] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Library_Managment_System] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Library_Managment_System] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Library_Managment_System] SET QUERY_STORE = OFF
GO
USE [Library_Managment_System]
GO
/****** Object:  UserDefinedFunction [dbo].[getBooks]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[getBooks](@auther_id int) returns int as
begin
	declare @books int;
	select @books = count(*) from books where author_id = @auther_id;
	return (@books)
end
GO
/****** Object:  UserDefinedFunction [dbo].[getRentedBook]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create function [dbo].[getRentedBook](@user_id int) returns int as
begin
	declare @books int;
	select @books = count(*) from rents where user_id = @user_id;
	return (@books)
end
GO
/****** Object:  Table [dbo].[books]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[books](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[description] [nvarchar](255) NULL,
	[cat_id] [int] NOT NULL,
	[author_id] [int] NOT NULL,
	[dt] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
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
/****** Object:  Table [dbo].[rents]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rents](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[end_time] [datetime] NOT NULL,
	[start_time] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Rented_Books]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Rented_Books] as
select u.name, b.title, r.start_time, r.end_time from rents r
inner join books b on b.id = r.book_id
inner join users u on u.id = r.user_id;
GO
/****** Object:  Table [dbo].[waitlist]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[waitlist](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[req_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Wait_List]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[Wait_List] as
select u.name, b.title, w.req_date from waitlist w
inner join users u on u.id = w.user_id
inner join books b on b.id = w.book_id;
GO
/****** Object:  Table [dbo].[authors]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authors](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 24-01-2024 05:54:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[books] ADD  DEFAULT (getdate()) FOR [dt]
GO
ALTER TABLE [dbo].[rents] ADD  DEFAULT (getdate()) FOR [start_time]
GO
ALTER TABLE [dbo].[waitlist] ADD  DEFAULT (getdate()) FOR [req_date]
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD FOREIGN KEY([author_id])
REFERENCES [dbo].[authors] ([id])
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD FOREIGN KEY([cat_id])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[rents]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[books] ([id])
GO
USE [master]
GO
ALTER DATABASE [Library_Managment_System] SET  READ_WRITE 
GO
