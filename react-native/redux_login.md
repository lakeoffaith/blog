##React native redux  api login token fetch
####for####
	want to make app created by react native with redux can login and fetch data  from the third party.
	

####code####

***/actions/user.js***
```
	

import base64 from 'base-64'
import {API_HOST,LOGIN_URL} from '../configure/Api'
export const LOGIN_REQUEST = 'login.request'
export const LOGIN_SUCCESS = 'login.success'
export const LOGIN_FAILURE = 'login.failure'

export function loginSuccess(data) {
  return {
    type: LOGIN_SUCCESS,
    data
  }
}
function loginRequest() {
   return {
      type: LOGIN_REQUEST
   }
}
export function loginFailure(error) {
  return {
    type: LOGIN_FAILURE,
    error
  }
}

export function login(username, password) {
  return (dispatch) => {

    // We use this to update `isLoggingIn` to `true` in our store, which can
    // be used to display an activity indicator on the login view.
    dispatch(loginRequest())

    // Note: This only works in node.js, use an implementation that works
    // for the platform you're using, e.g.: base64-js for React Native, or
    // btoa() for browsers.
    const headers=new Headers({"Content-Type":"application/json","Accept":"application/json"});
    return fetch(API_HOST+LOGIN_URL,{
      method:'post',
      headers:headers,
      body:JSON.stringify({
          name:'admin1',
          password:'admin1'
      })
    })
    .then(response=>response.json())
    .then(data => {
          console.log(data);
          //成功
          if(data.status===true){
              dispatch(loginSuccess({name:data.ijoy.name,token:data.token}))
          }else {
            dispatch(loginFailure('返回数据 出错'))
          }
    })
    .catch(e=>{
      dispatch(loginFailure('fetch 出错'))
    }).done()
  }
}

```

	Note
    user的action，action 返回json,或者调整的方法；fetch body中传递需要用JSON.stringify来转为json字符串，（后端处理 JSONObject.fromObject(request.getReader().readLine()大致的代码来处理，验证登录后，生产user_id+":"+时间进行编码后，返回为token)）
    
***/actions/employee.js***

```
import base64 from 'base-64'
import {API_HOST,EMPLOYEELIST_URL} from '../configure/Api'
export const EMPLOYEE_LIST_SUCCESS = 'EMPLOYEE_LIST_SUCCESS'
export const EMPLOYEE_LIST_FAILURE= 'EMPLOYEE_LIST_FAILURE'
import {connect} from 'react-redux'
export function employeeListSuccess(list){
  return{
    type:EMPLOYEE_LIST_SUCCESS,
    list
  }
}
export function employeeListFailure(msg){
  return{
    type:EMPLOYEE_LIST_FAILURE,
    msg
  }
}
export function employeeList(user) {

  return (dispatch,getState) => {
    const taken=getState().user.token;
    console.log("getState().user="+getState().user);
    const headers=new Headers({"Content-Type":"application/json","Accept":"application/json"});
    headers.append("Authorization",taken);
    console.log("taken="+taken);
    fetch(API_HOST+EMPLOYEELIST_URL,{
      method:'get',
      headers:headers
    })
    .then(response=>response.json())
    .then(data => {
          console.log(data);
          //成功
          if(data.status===true){
              dispatch(employeeListSuccess(data.ijoy))
          }else {
            dispatch(employeeListFailure('返回数据 出错'))
          }
    })
    .catch(e=>{
      dispatch(loginFailure('fetch 出错'))
    }).done()
  }

}

```
	Note
    getState,在action可以获得，取出里面的token,进行base64编码后放入header中请求（java后端用request.getHeader("Authorization"),进行Base64.decode进行解码，获得用户的id,是否存在，来判断是否登录。）
    
    
***/configure/Api.js***

```
export const API_HOST="http://192.168.100.116:8889/plat";

export const LOGIN_URL="/loginInfo/check/api";

export const EMPLOYEELIST_URL="/employee/api"
```
***/containers/app.js***
```
import React,{Component} from 'react';
import {
  View,
  Text
} from 'react-native';

import { createStore, applyMiddleware, combineReducers,compose } from 'redux'
import {Provider} from 'react-redux'
import thunk from 'redux-thunk'
import devTools from 'remote-redux-devtools';
import * as reducers from '../reducers'

import Login from '../pages/Login'
const reducer=combineReducers(reducers);
function configureStore(initialState){
  const enhancer=compose(
    applyMiddleware(thunk),
    devTools()
  );
  const store =createStore(reducer,initialState,enhancer);
  devTools.updateStore(store);
  return store;
}

const store=configureStore({});


export default class App extends Component{
  render(){
    return(
       <Provider store={store}>
         <Login />
       </Provider>
    );
  }
}
	Note
    加入了redux devtool  方便调试
```

***/pages/Login.js***

```
import React ,{Component} from 'react';
import{
    View,
    Text,
    TouchableWithoutFeedback
} from 'react-native'
import {login} from '../actions/user'
import {employeeList} from '../actions/employee'
import {connect} from 'react-redux'
import {bindActionCreators} from 'redux';
export default class Login extends Component{
   render(){
     const{state,actions}=this.props;
     console.log(state);
     console.log(actions);
     console.log(state.list);
     console.log(state.employeeList  && state.employeeList.length);
     console.log("employeeList="+state.employeeList);
     return(
       <View>
            {state.isLoggingIn===true? <View><Text>正在登录</Text></View>:null}
            {state.isAuthenticated===true?<Text>{state.name}+已经登录</Text>:null}
            {state.error===true?<Text>{state.error}</Text>:null}
            <TouchableWithoutFeedback onPress={()=>actions.login('li','12')}>
               <View>
                 <Text>登录</Text>
               </View>
            </TouchableWithoutFeedback>
            <TouchableWithoutFeedback onPress={actions.employeeList}>
               <View>
                 <Text>获得employeeList</Text>
               </View>
            </TouchableWithoutFeedback>
            {state.employeeList !==null ?
              state.employeeList.map((item,i)=>{
                return(
                  <View key={item.id}><Text>{item.name}</Text></View>
                );
              })
              :<View><Text>没有结果</Text></View>
            }
       </View>
     );
   }
}

export default connect(
  state=>({state:Object.assign({},state.user,state.error,state.employee)}),
  (dispatch)=>({
    actions:bindActionCreators({employeeList,login},dispatch)
  })
)(Login)

```
	Note
    Object.assign讲各个的json拼成一个json,注意第一个参数为什么是{},而不是state.user,connect 第一个方法参数是将state里面的数学mapto 组件的this.props,第二个方法参数是将action mapto this.props,注意多个action加入的方法，
    map function 里的变量需要家{}。

***/reducers/index.js***

```
	
import user from './user';

import user from './user';
import employee from './employee'
export {
  user,
  employee
};

```
	Note
    便于将reducer结合成reducers.

***/reducers/user.js***

```
import {
  LOGIN_REQUEST,
  LOGIN_FAILURE,
  LOGIN_SUCCESS
} from '../actions/user'

export default function user(state = {
  isLoggingIn: false,
  isAuthenticated: false
}, action) {
  switch(action.type) {
    case LOGIN_REQUEST:
      return {
        isLoggingIn: true, // Show a loading indicator.
        isAuthenticated: false
      }
    case LOGIN_FAILURE:
      return {
        isLoggingIn: false,
        isAuthenticated: false,
        error: action.error
      }
    case LOGIN_SUCCESS:
      return {
        ...action.data,
        isLoggingIn: false,
        isAuthenticated: true, // Hide the login view.
      }
    default:
      return state
  }
}
	
```
	Note
    ...action.data,将data里面的属性转成user的属性，不定参数需要放在最前面。

***/reducers/employee.js***

```
import {
  EMPLOYEE_LIST_SUCCESS,
  EMPLOYEE_LIST_FAILURE
} from '../actions/employee'

export default function employee(state={
  employeeList:null,
  status:false,
  msg:null
}, action) {
  switch(action.type) {
    case EMPLOYEE_LIST_SUCCESS:
      return {
        ...state,
        employeeList:action.list,
        status:true
      }
    case EMPLOYEE_LIST_FAILURE:
      return {
        ...state,
        msg:action.msg
      }
    default:
      return state
  }
}

```

***index.android.js***

```
import React from 'react'
import{
  AppRegistry
} from 'react-native'
import App from './app/containers/app'
AppRegistry.registerComponent('demo',()=>App);

```

***package.json***

```
{
  "name": "demo",
  "version": "0.0.1",
  "private": true,
  "scripts": {
    "start": "node node_modules/react-native/local-cli/cli.js start",
    "postinstall": "remotedev-debugger"
  },
  "dependencies": {
    "react": "15.2.1",
    "react-native": "^0.30.0",
    "react-native-material-design": "^0.3.7",
    "react-native-material-kit": "^0.3.2",
    "react-redux": "^4.4.5",
    "redux": "^3.5.2",
    "redux-persist": "^3.4.0",
    "redux-thunk": "^2.1.0"
  },
  "devDependencies": {
    "remote-redux-devtools": "^0.4.2",
    "remote-redux-devtools-on-debugger": "^0.6.2",
    "remotedev-server": "^0.1.8"
  }
}

```
####refs####
[http://stackoverflow.com/questions/34815853/react-native-fetch-and-basic-authentication](http://stackoverflow.com/questions/34815853/react-native-fetch-and-basic-authentication)

[https://stackoverflow.com/questions/35677062/react-native-redux-basic-authentication](https://stackoverflow.com/questions/35677062/react-native-redux-basic-authentication)

[https://jwt.io/](https://jwt.io/)

[https://medium.com/@jtremback/oauth-2-with-react-native-c3c7c64cbb6d#.5ynnfoblm](https://medium.com/@jtremback/oauth-2-with-react-native-c3c7c64cbb6d#.5ynnfoblm)

[http://www.jianshu.com/p/2c43860b0532](http://www.jianshu.com/p/2c43860b0532)
[https://github.com/ninty90/react-native-redux-demo](https://github.com/ninty90/react-native-redux-demo)

* * *
last upate 2016-08-24