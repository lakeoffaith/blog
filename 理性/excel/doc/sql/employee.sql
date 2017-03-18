/*
Navicat SQL Server Data Transfer

Source Server         : tt
Source Server Version : 105000
Source Host           : localhost:1433
Source Database       : excelDemo
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2017-03-17 10:10:04
*/


-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE [dbo].[employee]
GO
CREATE TABLE [dbo].[employee] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(255) NULL ,
[cellPhone] varchar(255) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[employee]', RESEED, 2826713)
GO

-- ----------------------------
-- Indexes structure for table employee
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE [dbo].[employee] ADD PRIMARY KEY ([id])
GO
