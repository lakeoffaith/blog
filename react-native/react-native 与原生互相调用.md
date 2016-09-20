##react-native 与原生互相调用

##explain
react-native也相当于一个activity，所以他启动原生activity，我们需要新建一个module，在其中新建启动原生activity的方法，如果传参数就用intent;如果需要返回的话就需要用到回调函数；同样有原生activity启动react-native同样点击按钮，触发方法，启动react-native的activity,传递参数就用intent.

##code