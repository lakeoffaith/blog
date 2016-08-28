##Amap location for React Native

####ref####
https://github.com/xiaobuu/react-native-amap-location

####code####

```
	import React from 'react';
import {
  View,
  Text
} from 'react-native';
import AMapLocation from 'react-native-amap-location';
export default class App extends React.Component{
  componentDidMount() {
  this.listener = AMapLocation.addEventListener((data) => console.log('data', data));
  AMapLocation.startLocation({
    accuracy: 'HighAccuracy',
    killProcess: true,
    needDetail: true,
  });
}

componentWillUnmount() {
  AMapLocation.stopLocation();
  this.listener.remove();
}
  render(){
    return(
      <View>
        <Text>amap</Text>
      </View>
    );
  }
}
```

####step####

-	按照[amaplocation](https://github.com/xiaobuu/react-native-amap-location)的步骤全部进行
-	生产apiKey [http://lbs.amap.com/api/android-location-sdk/guide/creat-project/get-key/](http://lbs.amap.com/api/android-location-sdk/guide/creat-project/get-key/)
	其中包名为你android程序的包名，
    SHA1生产方法。[http://lbs.amap.com/dev/ticket#/faq/74](http://lbs.amap.com/dev/ticket#/faq/74)
-	添加libs 
	将[amaplocation](https://github.com/xiaobuu/react-native-amap-location) libs 下的AMap_Location_V2.4.0_20160308.jar复制到android/app/libs下
-	完成配置，运行程序，debug,在console就会看到输出的定位地点


* * *
update 2016-08-25
last update 2016-08-26