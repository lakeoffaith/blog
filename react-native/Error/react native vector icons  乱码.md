## react native vector icons  乱码

## expalin在使用含有react-native-vector-icons的库的插件的时候，图标会出现乱码

## resolve
	1.去node_modules下面，找到react-native-vector-icons，找到里面Fonts(注意)文件，拷贝你需要的字体复制到  /android/app/src/main/asserts/fonts/下面
	2.删除原有包，重新运行就可以了。
	
* * *
last update 2016-09-09