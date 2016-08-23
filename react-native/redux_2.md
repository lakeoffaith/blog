##react native redux  -2

***read***
	https://github.com/alinz/example-react-native-redux/tree/master/Counter
    

***think***
	redux is best
	
***code***
	
-	app.js
	
```

import {createStore,applyMiddleware,combineReducers} from 'redux';
import {Provider} from 'react-redux'
import thunk from 'redux-thunk'
import * as reducers from '../reducers';
import CounterApp from './counterApp';

const createStoreWithMiddleware=applyMiddleware(thunk)(createStore);
const reducer=combineReducers(reducers);
const store=createStoreWithMiddleware(reducer);

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
	explain
    createStore获得store,applyMiddleWare加入中间件的，createStoreWithMiddleware 则是加入thunk中间件的创建store的函数，combineReducers 将多个reducer合并，传入createStore中获得store,store存放reducer返回的值。Provider 让子组件都可以访问到store，采用技术应该是contextType来达到组件树同时能访问某个数据。


-	counterApp.js


```
import {bindActionCreators} from 'redux';
import Counter from '../components/counter'
import * as counterActions from '../actions/counterActions'
import {connect} from 'react-redux'

class CounterApp extends React.Component{
  constructor(props){
    super(props);
  }
  render(){
    const{state,actions}=this.props;
    console.log('state --');
    console.log(state);
    return(
      <Counter
        looker={state.look}
        {...actions}
      />
    );
  }
}

export default connect(state=>({
  state:state.counter
}),
 (dispatch)=>({
   actions:bindActionCreators(counterActions,dispatch)
 }
 )
)(CounterApp)
Contact GitHub API Training Shop Blog About

```
	explain
    bindActionCreators 获得事件对应action,从而为某一事件设置不同的action 导向。
    connect 方法是将store中的counter属性（reduxer）,和action付给组件，从而可以获得state,actions from this.props.
* * *

-	counter.js

```
const initialState={
  look:0
};

export default function counter(state=initialState,action={}){
  switch (action.type) {
    case "smile":
        return{
          ...state,
          look:state.look+1
        };
    case "cry":
      return {
        ...state,
        look:state.look-1
      };
    default:
    return state;
  }
}
```
	explain
    initialState 设置初始的store,
    counter  根据不同的action 修改原有state.
    
***end***

	流程为 press-action-changeType-reduxers-changeStore-counterApp组件的store.counter 根据发生变化自动更新。state 是存在store中的，所以，state change lead to store change.
    
* * *

***issues***
可能出现的问题 state is undefined ,问题请注意在counterApp.js connect方法的第一个参数里面 state:state.counter 这里的counter指的是reduxers里面的reduxer counter 方法。不能写成state.look. state 为store,store 里面存的为各个reduxer 方法名为key 的对象，对象里面包含key 为look的对象。

* * *
 update 2016-08-19
 update 2016-08-22
