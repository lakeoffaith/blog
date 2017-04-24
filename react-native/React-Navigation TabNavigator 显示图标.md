## React-Navigation TabNavigator 显示图标
	注意android TabNavigator 需要设置showIcon，还有背景颜色的问题
```
import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image,
  Platform,
} from 'react-native';

import {TabNavigator} from 'react-navigation';
class MainScreen extends Component{
  static navigationOptions={
    tabBar:{
      label:'Main',
      icon:({ tintColor, focused }) => (
        <Image
          source={require('./chaticon.jpg')}
          style={[{ width: 26,
      height: 26}]}
        />
      ),
    },
  };
  render(){
    return(
      <View><Text>主页</Text>
      <Image
        source={require('./chaticon.jpg')}
        style={[{ width: 26,
    height: 26}]}
      /></View>
    );
  }
}

class UserScreen extends Component{
  static navigationOptions={
    tabBar:{
      label:'User',
      icon:({ tintColor, focused }) => (
        <Image
          source={require('./chaticon.jpg')}
          style={[{ width: 26,
      height: 26}]}
        />
      ),
    },
  };
  render(){
    return(
      <View><Text>用户页面</Text></View>
    );
  }
}

const setup=TabNavigator({
  main:{
    screen:MainScreen,
  },
  user:{
    screen:UserScreen,
  }
},{
  tabBarOptions:{
    showIcon:true,
    activeTintColor: Platform.OS === 'ios' ? '#e91e63' : '#fff',
  },
});

export default setup;
```