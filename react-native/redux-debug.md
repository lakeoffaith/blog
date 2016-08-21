## react-native redux debug
a solution from redux debug in react-native.

###refs###

[https://libraries.io/github/basscamp-io/desktop-boilerplate#redux-devtools](https://libraries.io/github/basscamp-io/desktop-boilerplate#redux-devtools)


###step###

	. npm install --save-dev remote-redux-devtools
    
[https://github.com/zalmoxisus/remote-redux-devtools](https://github.com/zalmoxisus/remote-redux-devtools)
	
    . npm install --save-dev remote-redux-devtools-on-debugger
[remote-redux-devtools-on-debugger](https://github.com/jhen0409/remote-redux-devtools-on-debugger)

	. npm install --save-dev remotedev-server
[https://github.com/zalmoxisus/remotedev-server](https://github.com/zalmoxisus/remotedev-server)

	. install chrome extensions (click below url)
[RemoteDev Chrome Application](https://chrome.google.com/webstore/detail/remotedev/faicmgpfiaijcedapokpbdejaodbelph)

	. add some code to make debug work.
   
###example code###

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
    "redux-thunk": "^2.1.0"
  },
  "devDependencies": {
    "remote-redux-devtools": "^0.4.2",
    "remote-redux-devtools-on-debugger": "^0.6.2",
    "remotedev-server": "^0.1.8"
  }
}

```

***app.js***

```
import React,{Component} from 'react'
import {Platform} from 'react-native'
import {createStore,applyMiddleware,combineReducers,compose} from 'redux';
import {Provider} from 'react-redux'
import thunk from 'redux-thunk'
import * as reducers from '../reducers';
import CounterApp from './counterApp';
import devTools from 'remote-redux-devtools';
const reducer=combineReducers(reducers);
function configureStore(initialState){
  const enhancer=compose(
    applyMiddleware(thunk),
    devTools()
  );
  const store=createStore(reducer,initialState,enhancer);
  devTools.updateStore(store);
  return store;
}
const store=configureStore({});

export default class App extends Component{
  render(){
    return(
      <Provider store={store}>
         <CounterApp />
      </Provider>
    );
  }
}

```


* * *
last update 2016-08-21

