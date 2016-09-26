##window7 安装 window service 2012 update

##explain 
工作需要安装window service 2012的双系统，基本环境为win7,硬盘类型为gpk,所以只能采用uefi+gpk+u盘。u盘格式为fats 才能为Uefi识别，如果镜像文件大于4g需要用压缩为sed.
##step
	1.下载镜像，解压，
	2.下载sed转换工具，压缩install.wim成install.sed
	3.替换install.wim
	4.进行安装

##refs
[https://msdn.microsoft.com/zh-cn/library/hh825112.aspx](https://msdn.microsoft.com/zh-cn/library/hh825112.aspx)

[http://jingyan.baidu.com/article/ce4366492fb3223772afd361.html](http://jingyan.baidu.com/article/ce4366492fb3223772afd361.html)


* * *
last update 2016-09-26

