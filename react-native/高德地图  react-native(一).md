##高德地图  react-native(一)

##explain
高德地图在android手机上面的通过react-native如何呈现，和用原生有什么区别。

##steps
	Create the ViewManager subclass
一般是继承simpleViewManager,子类将会构造生成一个自定义View子类的对象，
	
    createViewInstance
采用默认的属性，生产自定义View的对象

	Expose view property setters using @ReactProp (or @ReactPropGroup) annotation
通过@ReactProp让对象变化的prop,能改变原生视图的显示。
	
    Register the ViewManager
在ReactPackage中注册viewManager
	
    Implement the JavaScript module
js中通过NativeRequireModule,以及设置Props来引入原生视图的展现。
	
    Events
当用户触发时间，怎么让原生也触发这样的事件。


##refs
[https://github.com/facebook/react-native/blob/b1e49832ef3f9ffb0e5da2da7f847a8fae1d9c35/docs/NativeComponentsAndroid.md](https://github.com/facebook/react-native/blob/b1e49832ef3f9ffb0e5da2da7f847a8fae1d9c35/docs/NativeComponentsAndroid.md)

* * *
last update 2016-09-13
