##Android官方培训课程中文版笔记

##steps
	1.建立第一个App
用android studio 新建一个新的项目，usb连接设备，点击运行，则能看到结果。mainActivity 覆写onCreate方法，并且设置rootView.怎么启动其他的界面。先新建一个Activity,在第一个Activity中通过点击按钮，触发加载activity界面，通过Intent对象将点击的context和目标activity的class类进行关联,传递参数，参数进行转换为textView,让目标activity进行显示。
   
	2.activity的生命周期
onCreate,在activity被创建的时候调用，很快完成，完成的任务需要少，让加载更快。状态为created;onStart ,启动，很快的完成了。状态为Started;onResume ,状态变化Resumed,让activity能被用户所看见。onPause,暂停，让视图变得不可见，在切换app的时候调用。状态变为Paused,恢复可见用onResume;onStop,停止activity,恢复启动用onStart;onDestroy,销毁，结束
	
	3.fragment
fragment是一中视图，必须要被包含在view中。fragment可以通过不同屏幕大小配置不同的xml来改变布局，也可以灵活生成fagment,fragment有自己的生命周期，可以多次使用，主要方法，onCreateView,生成view,有两不同的包可以引入，support.v4,和v7.前者的能支持的android版本更低。创建fragment.管理生命周期。处理传来的参数。如何将fragment加入已经存在activity中，根据support.v4和v7的方法不同通过fragmentManager.获得fragment事务管理，进行增加或者移除fragment.

	4.如何创建自定义View,创建View的子类，提供context,和参数的构造函数，再通过配置文件，配置他的属性。对属性进行获取，显示
* * *
 2016-09-14
 last update 2016-09-15