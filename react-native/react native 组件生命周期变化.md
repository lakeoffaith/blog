##react native 组件生命周期变化

##step
生命周期方法
	
    componentDidMount
组件加载完成后进行，props修改并不能进入componentDidMount,也不能让组件自动刷新。

存在期
	
    componentwillReceiveProps
组件显示期间，接受比较nextProps和this.props从而进行props的修改，或者执行方法，不刷新组件。刷新组件，需要改变state.
##refs
	
[http://blog.csdn.net/slandove/article/details/50748473](http://blog.csdn.net/slandove/article/details/50748473)

* * *
update 2016-09-21
last update 2016-09-22