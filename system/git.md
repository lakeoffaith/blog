## git 

###git 回滚操作###
	git reset --hard xxxx
[http://blog.csdn.net/cxc19890214/article/details/43870545](http://blog.csdn.net/cxc19890214/article/details/43870545)

###git 创建新的分支###
	. git branch redux-debug
    . git checkout redux-debug
    . git push origin redux-deug

### 删除分支
	. git checkout master
	. git branch -D redux-debug    本地删除
    . git push origin :redux-debug   远程删除

###用分支替换掉master
	. git branch -m master old-master
    . git branch -m seotweaks master
    . git push -f origin master

### ref
[http://blog.csdn.net/guang11cheng/article/details/37757201](http://blog.csdn.net/guang11cheng/article/details/37757201)
[http://www.open-open.com/lib/view/open1425625009728.html](http://www.open-open.com/lib/view/open1425625009728.html)


* * * 
last update 2016-09-09