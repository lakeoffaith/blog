##React native redux  api login token
####for####
	want to make app created by react native with redux can login and logOut from the third party,every times back end check the app is login or not.

####refs####

[https://stackoverflow.com/questions/35677062/react-native-redux-basic-authentication](https://stackoverflow.com/questions/35677062/react-native-redux-basic-authentication)

[https://jwt.io/](https://jwt.io/)

[https://medium.com/@jtremback/oauth-2-with-react-native-c3c7c64cbb6d#.5ynnfoblm](https://medium.com/@jtremback/oauth-2-with-react-native-c3c7c64cbb6d#.5ynnfoblm)

[http://www.jianshu.com/p/2c43860b0532](http://www.jianshu.com/p/2c43860b0532)
[https://github.com/ninty90/react-native-redux-demo](https://github.com/ninty90/react-native-redux-demo)
####code####

***/actions/user.js***
```
	

export const LOGIN_REQUEST = 'login.request'
export const LOGIN_SUCCESS = 'login.success'
export const LOGIN_FAILURE = 'login.failure'

export function loginSuccess(user) {
  return {
    type: LOGIN_SUCCESS,
    user
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
    return fetch('http://www.baidu.com')
    .then(response => {
          dispatch(loginSuccess({name:'li',password:'123'}))
    })
    .catch(e=>{
      dispatch(loginFailure('fetch 出错'))
    })
  }
}

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

```

***/pages/Login.js***

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

```

***/reducers/index.js***

```
	
import user from './user';

export {
  user
};

```

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
        isLoggingIn: false,
        isAuthenticated: true, // Hide the login view.
        user: action.user
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