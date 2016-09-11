#react-Native-Experimental-Navigation-with-redux(一)

####for
	react-native-experimentalNavigation 将会取代原有的navigator ,因为它采用了react的思想就是单一的流管理，是结合redux的最好的选择，通过connect将state,dispatch注入到NavigationCardStack等导航组件的props，导航组件NavigationCardStack的navigationState存储导航的route,route 有key,index,children等属性，renderScene为导航的内容部分，
    
####GlobalNavigation
	为开始导航路径，默认为显示导航栏，也可以显示整个页面
####ApplicationTabs
	根据点击不同的导航按钮程序不同的页面，可能会有相同的顶部菜单栏和底部的菜单栏，android底部菜单栏 
  [https://github.com/sincethere/react-native-tabbar](https://github.com/sincethere/react-native-tabbar)
####ref
[https://github.com/facebook/react-native/issues/6184](https://github.com/facebook/react-native/issues/6184)
[https://github.com/bakery/react-native-complex-nav](https://github.com/bakery/react-native-complex-nav)
[http://blog.thebakery.io/react-native-experimental-navigation-with-redux/](http://blog.thebakery.io/react-native-experimental-navigation-with-redux/)
[https://www.zfanw.com/blog/react-native-navigator-experimental-usage.html](
https://www.zfanw.com/blog/react-native-navigator-experimental-usage.html)
[http://blog.csdn.net/cexo425/article/details/51788671](http://blog.csdn.net/cexo425/article/details/51788671)
[https://medium.com/@dabit3/first-look-react-native-navigator-experimental-9a7cf39a615b#.mw5yg163a](https://medium.com/@dabit3/first-look-react-native-navigator-experimental-9a7cf39a615b#.mw5yg163a)
* * *
update 2016-09-01
last update 2016-09-02