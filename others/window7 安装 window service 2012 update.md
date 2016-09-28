##window7 安装 window service 2012 update

##explain 
工作需要安装window service 2012的双系统，基本环境为win7,gpt,所以只能采用uefi+gpt+u盘。u盘格式为fats 才能为Uefi识别，如果镜像文件大于4g需要用压缩为sed.
u盘分区对新手不适用，这个方法要排除
##step

	1.下载镜像，解压，
	2.下载sed转换工具，压缩install.wim成install.sed  转换出错，跳转下面resolve的步骤
sed转换工具 ESD2WIM-WIM2ESD-v2.zip  
[http://download.csdn.net/detail/li905663280/9639881](http://download.csdn.net/detail/li905663280/9639881)
	
	3.替换install.wim
	4.进行安装
##resolve
	最后的解决方法是不安装windows service 2012 update 改成安装windows service 2012，一切变的好简单 
    下载必须先安装迅雷
[http://www.jianshu.com/p/57b5ee3611b9](http://www.jianshu.com/p/57b5ee3611b9)
##refs
[https://msdn.microsoft.com/zh-cn/library/hh825112.aspx](https://msdn.microsoft.com/zh-cn/library/hh825112.aspx)

[http://jingyan.baidu.com/article/ce4366492fb3223772afd361.html](http://jingyan.baidu.com/article/ce4366492fb3223772afd361.html)

[http://www.lastos.org/forum/index.php?threads/win-8-1-1-high-compression.1084/](http://www.lastos.org/forum/index.php?threads/win-8-1-1-high-compression.1084/)

[http://www.upantool.com/jiaocheng/xiufu/2012/1108.html](http://www.upantool.com/jiaocheng/xiufu/2012/1108.html)
* * *
update 2016-09-26
update 2016-09-27
last update 2016-09-29

