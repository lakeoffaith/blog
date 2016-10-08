##window server radius 802.1x认证

##explain
企业无线网络需要实现802.1x认证，通过初步了解，认证必须要先搭建认证服务器，ADCS。客户端（连接无线），到Access Point,再到AD证书认证，再到服务器。证书认证可以理解为http为明文，有了证书认证后，转为https认证，所有传送数据都为密文。
用vm虚拟机安装服务器，个人推荐下载win server 2012,因为win server 2003下载经常缺少组件。


##question
	1.ThinkPad 此主机支持Intel VT-x, 但Intel VT-x 处于禁用状态
电脑进入BIOS后，需要选择Security菜单，然后选择Virtualization，设置为Enabled。
[http://skypegnu1.blog.51cto.com/8991766/1618355](http://skypegnu1.blog.51cto.com/8991766/1618355)
##refs
[http://www.czzyca.com/thread-11981-1-1.html](http://www.czzyca.com/thread-11981-1-1.html)
[http://hubuxcg.blog.51cto.com/2559426/1636719](http://hubuxcg.blog.51cto.com/2559426/1636719)

[http://blog.csdn.net/xlh1991/article/details/38951257](http://blog.csdn.net/xlh1991/article/details/38951257)


* * *
last update 2016-10-01

