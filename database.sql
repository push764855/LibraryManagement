USE [master]
GO
/****** Object:  Database [ProjectJavaWeb]    Script Date: 6/30/2020 10:07:59 PM ******/
CREATE DATABASE [ProjectJavaWeb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectJavaWeb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ProjectJavaWeb.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProjectJavaWeb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ProjectJavaWeb_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProjectJavaWeb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectJavaWeb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectJavaWeb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ProjectJavaWeb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectJavaWeb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectJavaWeb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ProjectJavaWeb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectJavaWeb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProjectJavaWeb] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectJavaWeb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectJavaWeb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectJavaWeb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectJavaWeb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ProjectJavaWeb] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ProjectJavaWeb]
GO
/****** Object:  Table [dbo].[Log_in]    Script Date: 6/30/2020 10:07:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Log_in](
	[loginID] [nvarchar](10) NOT NULL,
	[password] [nvarchar](30) NOT NULL,
	[roleID] [nvarchar](10) NOT NULL,
	[userID] [int] NOT NULL,
	[isActive] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[loginID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Roles]    Script Date: 6/30/2020 10:07:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[roleID] [nvarchar](10) NOT NULL,
	[nameRole] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/30/2020 10:07:59 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[birthdate] [date] NOT NULL,
	[gender] [bit] NOT NULL,
	[addresses] [nvarchar](300) NOT NULL,
	[phone] [nvarchar](13) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Log_in] ([loginID], [password], [roleID], [userID], [isActive]) VALUES (N'aa', N'1', N'ad', 6, 1)
INSERT [dbo].[Log_in] ([loginID], [password], [roleID], [userID], [isActive]) VALUES (N'asd', N'1', N'us', 2, 0)
INSERT [dbo].[Log_in] ([loginID], [password], [roleID], [userID], [isActive]) VALUES (N'zz', N'1', N'us', 5, 1)
INSERT [dbo].[Roles] ([roleID], [nameRole]) VALUES (N'ad', N'administrator')
INSERT [dbo].[Roles] ([roleID], [nameRole]) VALUES (N'us', N'user')
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([userID], [fullname], [birthdate], [gender], [addresses], [phone]) VALUES (2, N'Huynh Anh', CAST(N'1998-08-08' AS Date), 1, N'zxc', N'033')
INSERT [dbo].[Users] ([userID], [fullname], [birthdate], [gender], [addresses], [phone]) VALUES (4, N'Thu Hang', CAST(N'1988-08-09' AS Date), 0, N'asss', N'066')
INSERT [dbo].[Users] ([userID], [fullname], [birthdate], [gender], [addresses], [phone]) VALUES (5, N'Ngoc Nga', CAST(N'1996-01-18' AS Date), 0, N'vd', N'011')
INSERT [dbo].[Users] ([userID], [fullname], [birthdate], [gender], [addresses], [phone]) VALUES (6, N'Minh Huy', CAST(N'1999-06-10' AS Date), 1, N'123', N'022')
SET IDENTITY_INSERT [dbo].[Users] OFF
ALTER TABLE [dbo].[Log_in]  WITH CHECK ADD FOREIGN KEY([roleID])
REFERENCES [dbo].[Roles] ([roleID])
GO
ALTER TABLE [dbo].[Log_in]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
GO
USE [master]
GO
ALTER DATABASE [ProjectJavaWeb] SET  READ_WRITE 
GO
