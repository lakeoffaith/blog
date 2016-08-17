##oracle 中文乱码 和 sqlplus 格式输出

***中文乱码***
	在插入中文数据之前必须要做。
    -	sudo gedit /home/oracle/.bash_profile

		export LANG=zh_CN.UTF-8
    	export NLS_LANG="SIMPLIFIED CHINESE_CHINA.AL32UTF8"
    -	source /home/oracle/.bash_profile
***ref***
	[http://blog.csdn.net/zengmuansha/article/details/40328569](http://blog.csdn.net/zengmuansha/article/details/40328569)
    
***格式输出***
	[http://blog.csdn.net/huoyin/article/details/5803324](http://blog.csdn.net/huoyin/article/details/5803324)