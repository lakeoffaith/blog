##react native  redux

***read:***
	[http://jo.wtf/react-native-redux-tutorial-concepts/](http://jo.wtf/react-native-redux-tutorial-concepts/)
    [http://jo.wtf/comprehensive-react-native-redux-tutorial/](
    http://jo.wtf/comprehensive-react-native-redux-tutorial/)
    [http://jo.wtf/react-native-redux-add-reducer/](
    http://jo.wtf/react-native-redux-add-reducer/)
    [http://bbs.reactnative.cn/topic/26](
    http://bbs.reactnative.cn/topic/26)
    [http://www.jianshu.com/p/cf5e33f7b5bf](http://www.jianshu.com/p/cf5e33f7b5bf)
***think***
	a state manager
    flow is action-storechange-viewchange-actiong-..
***code***
   - index.android.js
   	```
    import React from 'react'
    import{
      AppRegistry
    } from 'react-native'
    import App from './app/containers/app'
    AppRegistry.registerComponent('demo',()=>App);
    ```
   - app/containers/app.js
   ```
   import React,{Component} from 'react'
   import{
    View,
    Text
    } from 'react-native'
    import {createStore} from 'redux'
    import {Provider} from 'react-redux'
    const showState=(state='init State of store')=>{
      return state;
    }
    const store=createStore(showState);
    console.log(store);
      export default class App extends Component{
    render(){
      return(
         <Provider store={store}>
            <Main/>
         </Provider>
      );
    }
  }

  class Main extends Component{
    render(){
      return(
         <View>
           <Text>{store.getState()}</Text>
         </View>
      );
    }
  }
   ```
   
   



* * *
update 2016-08-13