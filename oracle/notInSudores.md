## is not in the sudoers file

- i type su to use root(if your su has no password,you should change user,type sudo passwd to give a password to su,then reture )

- in root mode. chmod u+w /etc/sudoers
- gedit /etc/sudoers ,type oracle ALL=(ALL) ALL (oracle is your system name) after root ALL=(ALL) ALL 
- chmod u-w /etc/sudoers


* * *
***read*** 
	[http://www.linuxidc.com/Linux/2010-12/30386.htm](http://www.linuxidc.com/Linux/2010-12/30386.htm)
    [http://blog.csdn.net/david_xtd/article/details/7229325](
    http://blog.csdn.net/david_xtd/article/details/7229325)
    
update 2016-8-14